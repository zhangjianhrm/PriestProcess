/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDao;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDepDao;
import com.lenovo.lps.farseer.priest2.platform.dal.TaskDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessStateEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;
import com.lenovo.lps.farseer.priest2.platform.service.JbpmProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.LockService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.CronExpressionUtils;
import com.lenovo.lps.farseer.priest2.platform.util.DataTransformation;
import com.rits.cloning.Cloner;

/**
 * @author niexm1
 * 
 */
public class ScheduleServiceImpl implements ScheduleService {
	private Logger logger = Logger.getLogger(ScheduleServiceImpl.class);

	/**
	 * <pre>
	 * 补跑待调度流程
	 * 
	 * 最外层Map:   processId_startDate_endDate ==>多天需要补跑的流程(补跑时,界面指定多天）
	 *  里层Map:         日期 ==>该日期下需要补跑的流程
	 * </pre>
	 */
	private Map<String, Map<String, List<ProcessEntity>>> historyWaittingRunMap = new ConcurrentHashMap<String, Map<String, List<ProcessEntity>>>();

	/**
	 * 补跑运行中的流程：Map processId_startDate_endDate ==> 运行中的日期
	 */
	private Map<String, String> historyRunningMap = new ConcurrentHashMap<String, String>();
	// 从数据库加载流程实例executor
	ScheduledExecutorService fetchProcessInstanceExecutor = Executors.newSingleThreadScheduledExecutor();

	// 运行补跑流程
	ScheduledExecutorService supplementProcessExecutor = Executors.newScheduledThreadPool(1);

	@Autowired
	@Qualifier("processInstanceFetchWork")
	private Runnable processInstanceFetchWork;
	@Autowired
	private JbpmProcessService jbpmProcessService;

	@Resource
	private LockService lockService;

	@Resource
	private ProcessService processService;

	@Resource
	private ProcessDao processDao;
	
	@Resource
	private ProcessDepDao processDepDao;

	@Resource
	private TaskDao taskDao;

	@Resource
	private ApplicationDao applicationDao;

	@PostConstruct
	private void start() {
		// delay 1分钟,防止被调用bean未初始化完整被执行
		int initialDelay = 60;

		long delay = 60;

		// 每分钟加载一次
		fetchProcessInstanceExecutor.scheduleWithFixedDelay(processInstanceFetchWork, initialDelay, delay, TimeUnit.SECONDS);


		// 流程补跑,加载一次后隔5分钟再加载一次
		Runnable supplementProcessRunWork = new SupplementProcessRunWork(historyWaittingRunMap, processDao,
				jbpmProcessService, historyRunningMap, processDepDao);
		supplementProcessExecutor.scheduleAtFixedRate(supplementProcessRunWork, initialDelay, delay, TimeUnit.SECONDS);

		// 初始化血缘关系生成锁I
		lockService.initialLockI();

		// 添加Priest关闭的钩子.
		// 在应用程序正常退出或虚拟机非正常退出时,将正在运行和排队中的流程设置为失败
		preShutdownExecution();
	}

	// Priest退出之前对运行和排队中的流程进行处理
	private void preShutdownExecution() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					processService.failedRunningProcess();
					processService.failedHistoryRunning();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}

	@Override
	public void abortRunningProcess(Integer processId, String execDate) {
		// 中断已经运行的实例
		jbpmProcessService.cancelRunningProcess(processId, execDate);
	}

	@Override
	public void submitJbpmProcess(ProcessEntity toRunProcess) {
		jbpmProcessService.submitJbpmProcess(toRunProcess);
	}

	@Override
	public void rerunProcess(Integer processId, String execDate, HttpSession session) {
		// 判断当前流程是否符合重跑条件：1.依赖流程都成功,2.当前流程成功,失败或中止,3.重跑操作人有重跑权限
		Set<Integer> parentsIds = processService.getProcessParentsIds(processId);
		for (Integer parentId : parentsIds) {
			ProcessEntity parentProcess = processService.getProcessRun(parentId, execDate);
			if (!StatusEnum.S.name().equals(parentProcess.getProcessStatus())) {
				throw new PriestPlatformException("Can't rerun the process,the dependence process " + parentId + "isn't run successfully!");
			}
		}

		ProcessEntity oldProcessRun = processService.getProcessRun(processId, execDate);
		Assert.notNull(oldProcessRun, "Can't find the process,Process ID:" + processId + ",execDate:" + execDate);
		String processStatus = oldProcessRun.getProcessStatus();
		Assert.isTrue(
				processStatus.equals(StatusEnum.S.name()) || processStatus.equals(StatusEnum.F.name())
						|| processStatus.equals(StatusEnum.C.name()), "Only successfully, failed, aborted process can be rerun!");

		// 限定只能重跑本人新增的流程
		if (!oldProcessRun.getCreatedBy().equals(AccessSession.getAccessUser(session))
				&& !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(session))) {
			throw new PriestPlatformException("Can't rerun the process if U aren't creator,the creator is:" + oldProcessRun.getCreatedBy());
		}

		int remedyTimes = oldProcessRun.getRemedyTimes();
		oldProcessRun.setRemedyTimes(remedyTimes + 1);
		oldProcessRun.setProcessStatus(StatusEnum.Q.name());
		// 流程重运行
		oldProcessRun.setMessage(null);
		oldProcessRun.setStartTime(null);
		oldProcessRun.setEndTime(null);
		oldProcessRun.setRetry(true);
		processDao.updateProcessRun(oldProcessRun);
		// 删除期下所有执行task info
		taskDao.deleteProcessTasks(processId, execDate);

		// 向线程池提交流程
		jbpmProcessService.submitJbpmProcess(oldProcessRun);
	}

	@Override
	public void rerunProcesses(Integer processId, String execDate) {
		// 1.检查当前的流程节点以及该节点的所有子孙节点
		Set<Integer> rerunProcessIds = new LinkedHashSet<Integer>();
		rerunProcessIds = checkRunningProcesses(processId, execDate, rerunProcessIds);
		// 2.重跑自该节点开始的整个流程图
		rerunProcessesExecutor(execDate, rerunProcessIds);
	}

	@Override
	public Set<Integer> checkRunningProcesses(Integer processId, String execDate, Set<Integer> rerunProcessIds) {
		ProcessEntity checkProcess = processService.getProcessRun(processId, execDate);
		Assert.notNull(checkProcess, "Can't find the process,Process ID:" + processId + ",execDate:" + execDate);
		String processName = checkProcess.getProcessName();
		String processStatus = checkProcess.getProcessStatus();
		Assert.isTrue(
				processStatus.equals(StatusEnum.S.name()) || processStatus.equals(StatusEnum.F.name())
						|| processStatus.equals(StatusEnum.C.name()) || processStatus.equals(StatusEnum.W.name()), "Denpendence Process:"
						+ processId + "-" + processName + " can't rerun.Only successfully, failed, aborted, waiting process can be rerun!");
		if (!rerunProcessIds.contains(processId)) {
			rerunProcessIds.add(processId);
			Set<Integer> processChildrenIds = processService.getProcessChildrenIds(processId);
			for (Integer childId : processChildrenIds) {
				ProcessEntity childProcess = processService.getProcessRun(childId, execDate);
				if (childProcess == null) {
					continue;
				}
				checkRunningProcesses(childId, execDate, rerunProcessIds);
			}
		}
		return rerunProcessIds;
	}

	@Override
	public Set<Integer> abortRunningProcesses(Integer processId, String execDate, Set<Integer> rerunProcessIds) {
		abortRunningProcess(processId, execDate);
		rerunProcessIds.add(processId);
		Set<Integer> processChildrenIds = processService.getProcessChildrenIds(processId);
		processChildrenIds.removeAll(rerunProcessIds);
		for (Integer childId : processChildrenIds) {
			abortRunningProcesses(childId, execDate, rerunProcessIds);
		}
		return rerunProcessIds;
	}
	
	@Override
	public Set<Integer> getProcessChildrenIds(Integer processId, int depth) {
		return getAllChildrenIds(processId, new LinkedHashSet<Integer>(), depth, 1);
	}
	
	@Override
	public Set<Integer> getProcessParentIds(Integer processId, int depth) {
		return getAllParentIds(processId, new LinkedHashSet<Integer>(), depth, 1);
	}
	
	@Override
	public void abortWaitProcess(Integer processId, String execDate, String userName, Set<Integer> abortProcessIds) {
		processDao.failedWaitProcess(String.valueOf(processId), execDate, Constants.COMPONENTS_PARAMS_MSG_HEADER + userName);
		abortProcessIds.add(processId);
		Set<Integer> processChildrenIds = processService.getProcessChildrenIds(processId);
		processChildrenIds.removeAll(abortProcessIds);
		
		for (Integer childId : processChildrenIds) {
			abortWaitProcess(childId, execDate, userName, abortProcessIds);
		}
	}

	private void rerunProcessesExecutor(String execDate, Set<Integer> rerunProcessIds) {
		for (Integer rerunProcessId : rerunProcessIds) {
			doRunProcess(rerunProcessId, execDate);
		}
	}

	private void doRunProcess(Integer processId, String execDate) {
		// 获取重跑流程状态,重新设计调度时间,记录重跑次数
		ProcessEntity rerunProcess = processService.getProcessRun(processId, execDate);
		boolean isStandby = checkStandbyProcess(rerunProcess);
		rerunProcess.setProcessStatus(isStandby ? StatusEnum.Q.name() : StatusEnum.W.name());

		int remedyTimes = rerunProcess.getRemedyTimes();
		rerunProcess.setRemedyTimes(remedyTimes + 1);
		rerunProcess.setMessage(null);
		rerunProcess.setStartTime(null);
		rerunProcess.setEndTime(null);
		// 流程重运行
		rerunProcess.setRetry(true);
		processDao.updateProcessRun(rerunProcess);
		// 删除其下所有执行task info
		taskDao.deleteProcessTasks(processId, execDate);

		// 提交线程池执行
		if (isStandby) {
			jbpmProcessService.submitJbpmProcess(rerunProcess);
		}
	}

	@Override
	public void historyRunProcesses(Integer processId, String startDataDate, String endDataDate, String dFlagState)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		// 1.判断是否需要跑依赖流程,找出需要跑的流程（最大集合）
		Set<Integer> maxToRunProcessIds = getToRunProcessIds(processId, dFlagState);
		Map<Integer, ProcessEntity> maxToRunProcessMap = checkHistoryProcesses(maxToRunProcessIds);
		// 2.获取总的补跑流程ID集合
		Map<String, List<Integer>> wholeIdsMap = getWholeHistoryRunProcessIds(startDataDate, endDataDate, maxToRunProcessMap);
		// 3.检查每天补跑流程状态并告警提示
		checkWholeHistoryRunProcess(wholeIdsMap);

		// 本次补跑内存标识：processId_startDate_endDate
		StringBuilder sb = new StringBuilder();
		String uniqKey = sb.append(processId).append("_").append(startDataDate).append("_").append(endDataDate).toString();
		// 4.流程提交调度
		queuedHistoryProcessList(wholeIdsMap, maxToRunProcessMap, uniqKey);
	}

	/**
	 * 设置待补跑流程DB状态,并内存排队
	 * 
	 * @param wholeIdsMap
	 * @param maxToRunProcessMap
	 * @param uniqKey
	 *            本次补跑标记
	 */
	private void queuedHistoryProcessList(Map<String, List<Integer>> wholeIdsMap, Map<Integer, ProcessEntity> maxToRunProcessMap,
			String uniqKey) {
		Cloner cloner=new Cloner();
		
		Map<String, List<ProcessEntity>> historyToRun = new LinkedHashMap<String, List<ProcessEntity>>();
		for (Entry<String, List<Integer>> dateIdsEntry : wholeIdsMap.entrySet()) {
			String execDate = dateIdsEntry.getKey();
			List<Integer> processIds = dateIdsEntry.getValue();
			List<ProcessEntity> dateProcessList = new ArrayList<ProcessEntity>();
			// 清除旧状态
			for (Integer processId : processIds) {
				ProcessEntity processDef = maxToRunProcessMap.get(processId);
				ProcessEntity process = cloner.deepClone(processDef);
				
				process.setExecDate(execDate);
				process.setScheduleDate(DateUtils.getDayNow());
				process.setProcessStatus(StatusEnum.H.name());
				process.setProcessType(ProcessTypeEnum.H.name());
				processDao.deleteProcessRun(processId, execDate);
				taskDao.deleteProcessTasks(processId, execDate);
				dateProcessList.add(process);
			}

			// 设置流程新状态
			if (!dateProcessList.isEmpty()) {
				processDao.batchInsertRun(dateProcessList);
				historyToRun.put(execDate, dateProcessList);
			}
		}
		
		logger.info(String.format("History process[%s] info[%s]", uniqKey, historyToRun));
		// 保存本次补跑流程
		historyWaittingRunMap.put(uniqKey, historyToRun);
	}

	private void checkWholeHistoryRunProcess(Map<String, List<Integer>> wholeIdsMap) {
		Map<String, List<Integer>> alarmIdsMap = new HashMap<String, List<Integer>>();
		for (Entry<String, List<Integer>> everydayIds : wholeIdsMap.entrySet()) {
			String execDate = everydayIds.getKey();
			List<Integer> idsList = everydayIds.getValue();
			Set<Integer> allParentsIdsSet = new HashSet<Integer>();
			for (Integer id : idsList) {
				// 如果补跑的流程目前正在运行中,检查其是否可以补跑
				ProcessEntity checkProcess = processService.getProcessRun(id, execDate);
				if (checkProcess != null) {
					String processName = checkProcess.getProcessName();
					String processStatus = checkProcess.getProcessStatus();
					if (StatusEnum.H.name().equals(processStatus) || StatusEnum.R.name().equals(processStatus)
							|| StatusEnum.Q.name().equals(processStatus)) {
						throw new PriestPlatformException("Execdate:" + execDate + " Process:" + id + "-" + processName + " status is waiting,Queuing or Running, can't rerun history!");
					}
				}
				Set<Integer> parentsIdSet = processService.getProcessParentsIds(id);
				allParentsIdsSet.addAll(parentsIdSet);
			}
			allParentsIdsSet.removeAll(idsList);
			List<Integer> alarmIdsListPerDay = new ArrayList<Integer>();
			for (Integer parentsIdNotInHistoryRun : allParentsIdsSet) {
				ProcessEntity process = processService.getProcessRun(parentsIdNotInHistoryRun, execDate);
				if (process == null || !StatusEnum.S.name().equals(process.getProcessStatus())) {
					alarmIdsListPerDay.add(parentsIdNotInHistoryRun);
				}
			}
			if (!alarmIdsListPerDay.isEmpty()) {
				alarmIdsMap.put(execDate, alarmIdsListPerDay);
			}
		}
		if (!alarmIdsMap.isEmpty()) {
			String message = "Can't rerun history, the dependence processes aren't run successfully! Please handle it first, the unsuccessfulle processes is:\n" + alarmIdsMap;
			logger.error(message);
			throw new PriestPlatformException(message);
		}
	}

	private Map<String, List<Integer>> getWholeHistoryRunProcessIds(String startDataDate, String endDataDate,
			Map<Integer, ProcessEntity> maxToRunProcessMap) throws ParseException, JsonParseException, JsonMappingException,
			IOException {
		Map<String, List<Integer>> wholeHistoryRunProcessIdsMap = new LinkedHashMap<String, List<Integer>>();
		List<String> execDateAsStringList = DateUtils.getDateAsStringList(startDataDate, endDataDate);
		for (String execDateAsString : execDateAsStringList) {
			List<Integer> toRunProcessIdsPerDay = new ArrayList<Integer>();
			String historyRunScheduleDate = DateUtils.getNextDayAsString(execDateAsString);
			String scheduleTimeTemplate = "00:00:00";
			for (Entry<Integer, ProcessEntity> processEntry : maxToRunProcessMap.entrySet()) {
				ProcessEntity toRunProcess = processEntry.getValue();
				ScheduleTypeEnum scheduleType = ScheduleTypeEnum.valueOf(toRunProcess.getScheduleType());
				String designedScheduleDate = toRunProcess.getScheduleDate();
				String desinedQuartzString = CronExpressionUtils.buildQuarzStr(scheduleType, designedScheduleDate,
						scheduleTimeTemplate);
				String historyRunQuartzString = CronExpressionUtils.buildQuarzStr(scheduleType, historyRunScheduleDate,
						scheduleTimeTemplate);
				if (desinedQuartzString.equals(historyRunQuartzString)) {
					Integer toRunProcessId = processEntry.getKey();
					toRunProcessIdsPerDay.add(toRunProcessId);
				}
			}

			if (toRunProcessIdsPerDay.size() > 0) {
				wholeHistoryRunProcessIdsMap.put(execDateAsString, toRunProcessIdsPerDay);
			}

		}
		return wholeHistoryRunProcessIdsMap;
	}

	private Map<Integer, ProcessEntity> checkHistoryProcesses(Set<Integer> maxToRunProcessIds) {
		Map<Integer, ProcessEntity> maxToRunProcessMap = new LinkedHashMap<Integer, ProcessEntity>();
		Set<Integer> notToRunProcessIds = new LinkedHashSet<Integer>();
		// 查询出非正常流程
		for (Integer toRunProcessId : maxToRunProcessIds) {
			ProcessEntity toRunProcess = processService.getProcessDef(String.valueOf(toRunProcessId));
			if (toRunProcess == null || !toRunProcess.getProcessState().equals(ProcessStateEnum.N.name())) {
				notToRunProcessIds.add(toRunProcessId);
			}
			maxToRunProcessMap.put(toRunProcessId, toRunProcess);
		}

		// 过滤非正常流程及其后续流程,装载入map
		for (Integer notRunProcessId : notToRunProcessIds) {
			Set<Integer> notRunIds = getToRunProcessIds(notRunProcessId, "Y");
			for (Integer notRunId : notRunIds) {
				maxToRunProcessMap.remove(notRunId);
			}
		}
		return maxToRunProcessMap;
	}

	// 获取补跑流程的ID最大集合
	private Set<Integer> getToRunProcessIds(Integer processId, String dFlagState) {
		Set<Integer> toRunProcessIds = new LinkedHashSet<Integer>();
		toRunProcessIds.add(processId);
		if ("Y".equals(dFlagState)) {
			return getAllChildrenIds(processId, toRunProcessIds, 100, 1);
		}
		return toRunProcessIds;
	}

	// 获取补跑流程的子流程ID
	private Set<Integer> getAllChildrenIds(Integer processId, Set<Integer> toRunProcessIds, int depth, Integer flagDepth) {
		Set<Integer> processChildrenIds = processService.getProcessChildrenIds(processId);
		processChildrenIds.removeAll(toRunProcessIds);
		toRunProcessIds.addAll(processChildrenIds);
		flagDepth++;
		if (flagDepth < depth) {
			for (Integer childId : processChildrenIds) {
				getAllChildrenIds(childId, toRunProcessIds, depth, flagDepth);
			}
		}
		return toRunProcessIds;
	}
	
	// 获取流程所有相关父流程ID
	private Set<Integer> getAllParentIds(Integer processId, Set<Integer> toRunProcessIds, int depth, Integer flagDepth) {
		Set<Integer> processChildrenIds = processService.getProcessParentsIds(processId);
		processChildrenIds.removeAll(toRunProcessIds);
		toRunProcessIds.addAll(processChildrenIds);
		flagDepth++;
		if (flagDepth < depth) {
			for (Integer childId : processChildrenIds) {
				getAllParentIds(childId, toRunProcessIds, depth, flagDepth);
			}
		}
		return toRunProcessIds;
	}

	@Override
	public boolean checkStandbyProcess(ProcessEntity process) {
		boolean standbyFlag = true;
		Set<Integer> parentsIds = processService.getProcessParentsIds(process.getProcessId());
		String execDate = process.getExecDate();
		for (Integer parentId : parentsIds) {
			ProcessEntity parentProcess = processService.getProcessRun(parentId, execDate);
			if (parentProcess == null || !StatusEnum.S.name().equals(parentProcess.getProcessStatus())) {
				standbyFlag = false;
				break;
			}
		}
		return standbyFlag;
	}

	@Override
	public void pulseProcesses(Map<String, String> requestParam) throws ParseException {
		String execDate = DateUtils.getExecDateFromScheduleDate(DateUtils.getDayNow());
		Integer firstProcessId = Integer.valueOf(requestParam.get("firstProcessId"));
		ProcessEntity process = processService.getProcessRun(firstProcessId, execDate);
		requestParam.remove("firstProcessId");
		Map<String, Object> parameters = DataTransformation.parseProcessVariables(process);
		parameters.putAll(requestParam);
		processService.updateRunningProcessVariable(firstProcessId, execDate, parameters);
		rerunProcesses(firstProcessId, execDate);
	}

	@Override
	public void historyCancelProcesses(Integer processId, String startDataDate, String endDataDate, String userName) throws ParseException {
		List<String> dateAsStringList = DateUtils.getDateAsStringList(startDataDate, endDataDate);
		// 按天取消流程
		for (String execDate : dateAsStringList) {
			//标记撤销流程结果
			boolean flag = false;
			
			// 取消正在执行的流程
			Iterator<Entry<String, String>> historyRunningIte = historyRunningMap.entrySet().iterator();
			while (historyRunningIte.hasNext()) {
				Entry<String, String> historyRunningEntry = historyRunningIte.next();
				String uniqKey = historyRunningEntry.getKey();
				String runningExecDate = historyRunningEntry.getValue();

				if (uniqKey.startsWith(processId + "_") && runningExecDate.equals(execDate)) {
					Map<String, List<ProcessEntity>> process4OneTime = historyWaittingRunMap.get(uniqKey);
					List<ProcessEntity> process4OneDay = process4OneTime.get(execDate);

					// 加null判断,有可能补跑运行完后,被补跑线程清除内存状态
					if (CollectionUtils.isNotEmpty(process4OneDay)) {
						for (ProcessEntity p : process4OneDay) {
							jbpmProcessService.cancelRunningProcess(p.getProcessId(), p.getExecDate());
						}
						logger.info(String.format("History process[%s] info[%s] cancel [%s] on running!", uniqKey, process4OneTime, execDate));
						historyRunningIte.remove();
						process4OneTime.remove(execDate);
						if (process4OneTime.isEmpty()) {
							historyWaittingRunMap.remove(uniqKey);
						}
						flag = true;
					}
					break;
				}
			}

			// 取消待调度流程
			Iterator<Entry<String, Map<String, List<ProcessEntity>>>> historyWaittingRunIte = historyWaittingRunMap.entrySet()
					.iterator();
			while (historyWaittingRunIte.hasNext()) {
				Entry<String, Map<String, List<ProcessEntity>>> wait = historyWaittingRunIte.next();
				String uniqKey = wait.getKey();

				// 符合流程ID_开始日期_结束日期 标记
				if (uniqKey.startsWith(processId + "_")) {
					Map<String, List<ProcessEntity>> process4OneTime = wait.getValue();

					// 找到当天待补跑流程
					if (process4OneTime.containsKey(execDate)) {
						List<ProcessEntity> process4OneDay = process4OneTime.get(execDate);
						// DB标记为failed
						processDao.batchFailProcs(process4OneDay, Constants.COMPONENTS_PARAMS_MSG_HEADER + userName);

						// 请理内存状态
						logger.info(String.format("History process[%s] info[%s] cancel [%s] on waiting!", uniqKey, process4OneTime, execDate));
						process4OneTime.remove(execDate);
						if (process4OneTime.isEmpty()) {
							historyWaittingRunIte.remove();
						}
						flag = true;
						break;
					}
				}
			}
			
			try {
				//撤销流程结果为失败并且流程确实为补跑流程,则进行二次撤销 
				if (!flag && processDao.checkHistoryPro(processId, execDate)) {
					//检查流程是否正在运行  是正在运行的则直接通知调度进程取消 否则直接修改数据库状态
					if (jbpmProcessService.checkRunningProcess(processId, execDate)) {
						jbpmProcessService.cancelRunningProcess(processId, execDate);
					} else {
						processDao.cancelAgain(Constants.COMPONENTS_PARAMS_MSG_HEADER + userName, processId, execDate);
					}
					// 取消待调度流程
					Iterator<Entry<String, Map<String, List<ProcessEntity>>>> runIt = historyWaittingRunMap.entrySet().iterator();
					w1:while (runIt.hasNext()) {
						Entry<String, Map<String, List<ProcessEntity>>> wait = runIt.next();
						Map<String, List<ProcessEntity>> process4OneTime = wait.getValue();
						// 找到当天待补跑流程
						if (process4OneTime.containsKey(execDate)) {
							List<ProcessEntity> process4OneDay = process4OneTime.get(execDate);
							for (ProcessEntity entity: process4OneDay) {
								if (entity.getProcessId().intValue() == processId) {
									entity.setProcessStatus(StatusEnum.F.name());
									break w1;
								}
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error(String.format("Again, cancle processid [%s] execDate[%s] by user [%s] error:", processId, execDate, userName), e);
			}
		}
	}
}
