package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.SQLStatementEnum;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDao;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDepDao;
import com.lenovo.lps.farseer.priest2.platform.dal.TaskDao;
import com.lenovo.lps.farseer.priest2.platform.entity.LockTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleInfo;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveOperationEnum;
import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;
import com.lenovo.lps.farseer.priest2.platform.service.LockService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.CronExpressionUtils;
import com.lenovo.lps.farseer.priest2.platform.util.HiveSqlParserUtil;
import com.lenovo.lps.farseer.priest2.platform.util.SQLParserUtils;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class ProcessServiceImpl implements ProcessService {
	private final Logger logger = Logger.getLogger(ProcessServiceImpl.class);

	@Autowired
	@Qualifier("processDao")
	private ProcessDao processDao;

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	private LockService lockService;

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ProcessDepDao processDepDao;

	@Resource
	private TaskDao taskDao;

	// 开启流程调度
	private static final String PROCESS_STATE_NORMAL = "N";
	
	@PostConstruct
	private void initial() {
		//启动时加载当天运行流程,将信息放入p_process_run信息
		loadProcessToRunDaily();
	}

	@Override
	public ProcessEntity getProcessRun(Integer processId, String execDate) {
		return processDao.searchProcessRunByIdExecDate(String.valueOf(processId), execDate);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertProcess(ProcessEntity process) {
		processDao.insertProcess(process);

		// 更新业务变量
		updateAppVars(process);

		// 流程依赖处理
		if (process.getDeps().size() > 0) {
			processDepDao.insertDeps(process.getDeps());
		}

		if (PROCESS_STATE_NORMAL.equals(process.getProcessState())) {
			// 调度类型
			ScheduleTypeEnum scheduleType = ScheduleTypeEnum.valueOf(process.getScheduleType());
			// 调度日期
			String scheduleDate = process.getScheduleDate();
			// 调度时间
			String scheduleTime = process.getScheduleTime();
			// 计算调度日期
			ScheduleInfo nextScheduleInfo = CronExpressionUtils.getNextSchedule(scheduleType, scheduleDate, scheduleTime);
			// 当天运行
			if (CronExpressionUtils.shouldRunToday(nextScheduleInfo.getNextScheduleDate())) {
				// 数据日期设置
				process.setExecDate(nextScheduleInfo.getExecDate());
				List<ProcessEntity> toRunProcess = new ArrayList<ProcessEntity>();
				insertProcessToRun(process, toRunProcess);
			}
		}
	}

	@Override
	public ProcessEntity getProcessDef(String processId) {
		ProcessEntity requestParam = new ProcessEntity();
		requestParam.setProcessId(Integer.valueOf(processId));
		List<ProcessEntity> processList = processDao.searchProcessDef(requestParam);

		return (processList == null || processList.size() == 0) ? null : processList.get(0);
	}

	@Override
	public ProcessEntity getProcessDefByName(String processName) {
		ProcessEntity requestParam = new ProcessEntity();
		requestParam.setProcessName(processName);
		List<ProcessEntity> processList = processDao.searchProcessDef(requestParam);

		return (processList == null || processList.size() == 0) ? null : processList.get(0);
	}

	@Override
	public PagingResult<ProcessEntity> getProcessDef(ProcessEntity requestParam) {
		// 支持模糊查询
		if (StringUtils.isNotEmpty(requestParam.getProcessName())) {
			requestParam.setProcessName("%" + requestParam.getProcessName() + "%");
		}

		try {
			// mysql sql between 日期条件为[date_begin,date_end)后开区间,需要把end日期往后推一天
			if (StringUtils.isNotEmpty(requestParam.getCreatedDateEnd())) {
				requestParam.setCreatedDateEnd(DateUtils.getAfterDate(
						DateUtils.parseString2Date(requestParam.getCreatedDateEnd(), Constants.DATE_PATTENR), 1));
			}

			// 获取符合条件的总记录数
			Long totalRecords = processDao.searchProcessDefCount(requestParam);

			// 设置分页时limit offset
			requestParam.setOffset((requestParam.getPage() - 1) * requestParam.getRows());

			List<ProcessEntity> processList = processDao.searchProcessDef(requestParam);

			// 总页数
			Long totalPages = (totalRecords.longValue() - 1) / requestParam.getRows() + 1;

			PagingResult<ProcessEntity> result = new PagingResult<ProcessEntity>();
			// 设置当前页
			result.setPageNo(requestParam.getPage());
			// 设置每页大小
			result.setPageSize(requestParam.getRows());
			// 设置总页数
			result.setTotalPages(totalPages);
			// 设置总记录数
			result.setTotalRecords(totalRecords);

			result.setResults(processList);

			return result;
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
	}

	@Override
	public List<ProcessEntity> getProcessRun(String processId, String processStatus) {
		if (StringUtils.isEmpty(processId)) {
			throw new PriestPlatformException("ProcessId is empty!");
		}
		Map<String, String> processRunMap = new HashMap<String, String>();
		processRunMap.put("processId", processId);
		if (StringUtils.isNotEmpty(processStatus)) {
			try {
				processRunMap.put("processStatus", StatusEnum.valueOf(processStatus).name());
			} catch (Exception e) {
				throw new PriestPlatformException(e);
			}
		} else {
			processRunMap.put("processStatus", null);
		}
		return processDao.searchProcessRun(processRunMap);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateProcess(ProcessEntity process) {
		/**
		 * 1.修改流程前，检查流程当天执行状态:内存排队与正在执行的流程不能修改
		 */
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_PATTENR);

		Calendar execDate = new GregorianCalendar();
		// 业务数据日期为当前调度日期-1,仓库计算时,今天算昨天的数据
		execDate.add(Calendar.DAY_OF_MONTH, -1);
		String execDateStr = sf.format(execDate.getTime());

		Integer processId = process.getProcessId();
		ProcessEntity procRun = processDao.searchProcessRunByIdExecDate(String.valueOf(processId), execDateStr);
		// 流程当天schedule运行
		if (procRun != null) {
			StatusEnum runStatus = StatusEnum.valueOf(procRun.getProcessStatus());
			switch (runStatus) {
			// 内存排队
			case Q:
				// 正在执行
			case R:
				throw new PriestPlatformException("Process is running, Can't be modified!");
				// 等待执行的job，删除，不允许运行
			case W:
				processDao.deleteProcessRun(procRun.getProcessId(), execDateStr);
				taskDao.deleteProcessTasks(procRun.getProcessId(), execDateStr);
				break;
			default:
				break;
			}

		}

		/**
		 * 2. 流程依赖处理
		 */
		processDepDao.deleteDep(processId);
		if (process.getDeps().size() > 0) {
			processDepDao.insertDeps(process.getDeps());
		}

		/**
		 * 3.更新流程定义
		 */
		processDao.updateProcess(process);

		// 更新业务变量
		updateAppVars(process);

		/**
		 * 4.重新调度流程运行
		 */
		if (PROCESS_STATE_NORMAL.equals(process.getProcessState())) {
			// 调度类型
			ScheduleTypeEnum scheduleType = ScheduleTypeEnum.valueOf(process.getScheduleType());

			// 调度日期
			String scheduleDate = process.getScheduleDate();

			// 调度时间
			String scheduleTime = process.getScheduleTime();

			// 计算调度日期
			ScheduleInfo nextScheduleInfo = CronExpressionUtils.getNextSchedule(scheduleType, scheduleDate, scheduleTime);

			// 当天运行
			if (CronExpressionUtils.shouldRunToday(nextScheduleInfo.getNextScheduleDate())) {
				/**
				 * 删除当天流程实例
				 */
				processDao.deleteProcessRun(processId, execDateStr);
				taskDao.deleteProcessTasks(processId, execDateStr);

				List<ProcessEntity> toRunProcess = new ArrayList<ProcessEntity>();
				// 设置调度日期
				process.setExecDate(nextScheduleInfo.getExecDate());
				insertProcessToRun(process, toRunProcess);
			}
		}
	}

	/**
	 * 更新应用变量
	 * 
	 * @param process
	 *            流程实例
	 */
	private void updateAppVars(ProcessEntity process) {
		Map<String, String> varsMap = new HashMap<String, String>();
		varsMap.put("appID", process.getProcessApp());
		varsMap.put("appVariables", process.getAppVariables());
		applicationDao.updateAppVariables(varsMap);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateProcessState(Integer processId, String processState, HttpSession session) {
		/**
		 * 1.限定只能修改本人创建的流程状态
		 */
		ProcessEntity dbStoredProcess = getProcessDef(String.valueOf(processId));
		// update前检查
		if (dbStoredProcess == null) {
			throw new PriestPlatformException("Can't find the process,Process ID:" + processId);
		}
		// 限定只能修改本人新增的流程
		else if (!dbStoredProcess.getCreatedBy().equals(AccessSession.getAccessUser(session))
				&& !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(session))) {
			throw new PriestPlatformException("Can't modify the process if U aren't the creator, the creator is:" + dbStoredProcess.getCreatedBy());
		}

		// 调度时间，运行时间处理
		Date today = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_PATTENR);
		Calendar execDate = new GregorianCalendar();
		// 业务数据日期为当前调度日期-1,仓库计算时,今天算昨天的数据
		execDate.add(Calendar.DAY_OF_MONTH, -1);
		String execDateStr = sf.format(execDate.getTime());

		/**
		 * 2.流程正在运行，内存排队时，限定修改
		 */
		ProcessEntity procRun = processDao.searchProcessRunByIdExecDate(String.valueOf(processId), execDateStr);
		// 流程当天schedule运行
		if (procRun != null) {
			StatusEnum runStatus = StatusEnum.valueOf(procRun.getProcessStatus());
			switch (runStatus) {
			// 内存排队
			case Q:
				// 正在执行
			case R:
				throw new PriestPlatformException("Process is running, Can't be modified!");
				// 等待执行的job，删除，不允许运行
			case W:
				processDao.deleteProcessRun(procRun.getProcessId(), execDateStr);
				taskDao.deleteProcessTasks(procRun.getProcessId(), execDateStr);
				break;
			default:
				break;
			}
		}

		/**
		 * 3.修改流程状态
		 */
		processDao.updateProcessState(processId, processState, AccessSession.getAccessUser(session));

		/**
		 * 4.当开启流程调度时，重新调度运行
		 */
		if (PROCESS_STATE_NORMAL.equals(processState)) {
			// 调度类型
			ScheduleTypeEnum scheduleType = ScheduleTypeEnum.valueOf(dbStoredProcess.getScheduleType());

			// 调度日期
			String scheduleDate = dbStoredProcess.getScheduleDate();

			// 调度时间
			String scheduleTime = dbStoredProcess.getScheduleTime();

			// 计算调度日期
			ScheduleInfo nextScheduleInfo = CronExpressionUtils.getNextSchedule(scheduleType, scheduleDate, scheduleTime);

			// 当天运行
			if (CronExpressionUtils.shouldRunToday(nextScheduleInfo.getNextScheduleDate())) {
				/**
				 * 调度等待时,删除当天流程调度记录
				 */
				processDao.deleteProcessRun(processId, execDateStr);
				taskDao.deleteProcessTasks(processId, execDateStr);

				List<ProcessEntity> toRunProcess = new ArrayList<ProcessEntity>();
				dbStoredProcess.setExecDate(execDateStr);

				// 设置调度日期
				dbStoredProcess.setScheduleDate(sf.format(today));
				insertProcessToRun(dbStoredProcess, toRunProcess);
			}

		}

	}

	@Override
	public void validateProcess(Integer processId, String resultState, String investigationReason) {
		processDao.validateProcess(processId, resultState, investigationReason);

		Date today = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_PATTENR);
		Calendar execDate = new GregorianCalendar();
		// 业务数据日期为当前调度日期-1,仓库计算时,今天算昨天的数据
		execDate.add(Calendar.DAY_OF_MONTH, -1);
		String execDateStr = sf.format(execDate.getTime());

		ProcessEntity process = getProcessDef(String.valueOf(processId));
		if (PROCESS_STATE_NORMAL.equals(process.getProcessState())) {
			// 调度类型
			ScheduleTypeEnum scheduleType = ScheduleTypeEnum.valueOf(process.getScheduleType());

			// 调度日期
			String scheduleDate = process.getScheduleDate();

			// 调度时间
			String scheduleTime = process.getScheduleTime();

			// 计算调度日期
			ScheduleInfo nextScheduleInfo = CronExpressionUtils.getNextSchedule(scheduleType, scheduleDate, scheduleTime);

			// 当天运行
			if (CronExpressionUtils.shouldRunToday(nextScheduleInfo.getNextScheduleDate())) {
				/**
				 * 删除当天流程实例
				 */
				processDao.deleteProcessRun(process.getProcessId(), execDateStr);
				taskDao.deleteProcessTasks(process.getProcessId(), execDateStr);

				List<ProcessEntity> toRunProcess = new ArrayList<ProcessEntity>();
				// 数据日期设置
				process.setExecDate(execDateStr);
				// 设置调度日期
				process.setScheduleDate(sf.format(today));

				insertProcessToRun(process, toRunProcess);
			}
		}
	}

	private void insertProcessToRun(ProcessEntity process, List<ProcessEntity> toRunProcess) {
		Set<Integer> parentsIds = getProcessParentsIds(process.getProcessId());
		boolean isStandby = scheduleService.checkStandbyProcess(process);
		if (parentsIds.isEmpty()) {
			isStandby = false;
		}
		if (isStandby) {
			process.setProcessStatus(StatusEnum.Q.name());
			toRunProcess.add(process);
			processDao.batchInsertRun(toRunProcess);

			for (ProcessEntity toRun : toRunProcess) {
				scheduleService.submitJbpmProcess(toRun);
			}
		} else {
			toRunProcess.add(process);
			processDao.batchInsertRun(toRunProcess);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void startProcess(String processId, String execDate, Map<String, Object> processVariables) {
		processDao.startProcess(processId, execDate, processVariables);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void terminateProcess(String processId, String execDate) {
		processDao.terminateProcess(processId, execDate);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void failedProcess(String processId, String execDate, String detail) {
		// 错误信息长度超过50的，将错误信息写入日志文件中；反之将信息写入DB中
		if (detail.length() > 50) {
			detail = failProcessToFile(processId, execDate, detail);
		}

		processDao.failedProcess(processId, execDate, detail);
	}

	private String failProcessToFile(String processId, String execDate, String detail) {
		// 流程错误日志文件名格式： process-$(processId)-${execDate}-error.log
		String logFileName = "process-" + processId + "-" + execDate + "-error.log";
		File errLog = new File(ConfigUtil.getContextProperty("process.error.log.location", "/var/lib/priest/logs/priest"));
		if (!errLog.exists()) {
			Assert.isTrue(errLog.mkdirs(), "Failed to create the process error log directory:" + errLog);
		}
		File errLogFile = new File(errLog, logFileName);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(errLogFile);
			bw = new BufferedWriter(fw);
			bw.write(detail);
		} catch (IOException e) {
			logger.warn("Write process error log failed.", e);
		} finally {
			IOUtils.closeQuietly(bw);
			IOUtils.closeQuietly(fw);
		}

		return logFileName;
	}

	/**
	 * 扫描流程定义表,加载当天所有符合运行条件的记录到P_PROCESS_RUN表,准备运行
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Scheduled(cron="0 0 0,1,8,13,20 * * ?")
	public void loadProcessToRunDaily() {
		// 获取锁,防止集群多台机器 重复
		boolean gotLock = lockService.tryLock(LockTypeEnum.C, 300);

		if (!gotLock) {
			logger.warn("Not get load lock, exit!");
			return;
		}

		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_PATTENR);
		String today = sf.format(new Date());

		// 如果当天数据已经加载,退出
		if (lockService.checkProcessInstanceCreated(today)) {
			logger.info("The day of the process has been loaded:" + new Date());
			return;
		}

		logger.info("begin load processes to schedule>>>>>>>>>>>>>>>>>>>>>" + new Date());
		boolean isSuccess = false;
		try {
			// 获取系统内有效流程
			List<ProcessEntity> validProcessList = processDao.getValidProcess(today);

			// 未配制流程
			if (CollectionUtils.isEmpty(validProcessList)) {
				return;
			}

			// 待运行流程实例
			List<ProcessEntity> toRunProcesses = new ArrayList<ProcessEntity>();

			// 需变更调试日期流程实例
			List<ProcessEntity> toChangeScheduleDateProcesses = new ArrayList<ProcessEntity>();

			for (ProcessEntity process : validProcessList) {
				// 调度类型
				ScheduleTypeEnum scheduleType = ScheduleTypeEnum.valueOf(process.getScheduleType());

				// 调度日期
				String scheduleDate = process.getScheduleDate();

				// 调度时间
				String scheduleTime = process.getScheduleTime();

				// 计算调度日期
				ScheduleInfo nextScheduleInfo = CronExpressionUtils.getNextSchedule(scheduleType, scheduleDate, scheduleTime);

				// 当天运行
				if (CronExpressionUtils.shouldRunToday(nextScheduleInfo.getNextScheduleDate())) {
					// 更新流程schedule date，为下次运行做准备
					process.setScheduleDate(today);
					toChangeScheduleDateProcesses.add(process);

					process.setExecDate(nextScheduleInfo.getExecDate());
					toRunProcesses.add(process);

				}

			}

			// 加载流程,准备运行
			if (toRunProcesses.size() > 0) {
				processDao.batchInsertRun(toRunProcesses);

			}

			if (toChangeScheduleDateProcesses.size() > 0) {
				processDao.updateScheduleDate(toChangeScheduleDateProcesses);
			}

			// 标记当天流程实例已经加载完成
			isSuccess = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		} finally {
			// 解锁,同时,成执加载时,DB记录成功加载日期
			lockService.tagProcessInstanceCreated(today, isSuccess);
		}

		logger.info("end load processes to schedule>>>>>>>>" + new Date());
	}

	@Override
	public PagingResult<ProcessEntity> getProcessRuns(ProcessEntity param) {
		// 支持模糊查询
		if (StringUtils.isNotEmpty(param.getProcessName())) {
			param.setProcessName("%" + param.getProcessName() + "%");
		}
		return processDepDao.getProcessRuns(param);
	}
	
	@Override
	public List<ProcessEntity> getProcessFails(ProcessEntity param) {
		// 支持模糊查询
		if (StringUtils.isNotEmpty(param.getProcessName())) {
			param.setProcessName("%" + param.getProcessName() + "%");
		}
		return processDepDao.getProcessFails(param);
	}

	@Override
	public List<ProcessEntity> getProcessRunsIncDepId(ProcessEntity param) {
		// 支持模糊查询
		if (StringUtils.isNotEmpty(param.getProcessName())) {
			param.setProcessName("%" + param.getProcessName() + "%");
		}
		return processDepDao.getProcessRunsIncDepId(param);
	}

	@Override
	public List<ProcessEntity> getScheduleDelayedProcess(String scheduleDate) {
		return processDao.getScheduleDelayedProcess(scheduleDate);
	}

	@Override
	public void abortProcess(Integer processId, String execDate) {
		TaskEntity taskInRun = taskService.getTask(String.valueOf(processId), execDate, StatusEnum.R.name());
		if (taskInRun != null) {
			taskService.failedTask(String.valueOf(taskInRun.getTaskId()), execDate, "Aborted Task");
		}
		try {
			AuditLog.log(String.format("Process[%s], execDate[%s] aborted at [%s]", 
					processId, execDate, DateUtils.parseDate2String(new Date(), DateUtils.getDateFormat())));
		} catch (Exception e) {};
		processDao.abortProcess(processId, execDate);
	}

	@Override
	public void batchUpdateStatus(List<ProcessEntity> processList, StatusEnum status) {
		processDao.batchUpdateStatus(processList, status);
	}

	@Override
	public boolean checkProcessFailed(Integer processId, String execDate) {
		Map<String, Object> taskMap = new HashMap<String, Object>();

		taskMap.put("processId", processId);
		taskMap.put("processName", null);
		taskMap.put("execDate", execDate);
		taskMap.put("taskStatus", StatusEnum.F.name());
		taskMap.put("orderBy", null);
		taskMap.put("sord", null);
		taskMap.put("start", null);
		taskMap.put("offset", null);
		List<TaskEntity> failedTasks = taskDao.searchTaskDef(taskMap);

		return failedTasks != null && failedTasks.size() > 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateRunningProcessVariable(Integer processId, String execDate, Map<String, Object> processVariablesInMemory) {

		if (processVariablesInMemory == null || processVariablesInMemory.isEmpty()) {
			return;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			// 转为json 字符串
			String processVariableJsonStr = objectMapper.valueToTree(processVariablesInMemory).toString();

			// 更新数据库
			processDao.updateRunningProcessVariable(processId, execDate, processVariableJsonStr);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateExpiredProcessRun(String scheduleDate) {
		processDao.updateExpiredProcessRun(scheduleDate);
	}

	@Override
	public Set<Integer> getProcessChildrenIds(Integer processId) {
		return processDepDao.getProcessChildrenIds(processId);
	}

	@Override
	public Set<Integer> getProcessParentsIds(Integer processId) {
		return processDepDao.getProcessParentsIds(processId);
	}

	public ModelMap checkMysqlGrammar(String sql, boolean isAdmin) {
		ModelMap modelMap = new ModelMap();

		// 禁止操作类型
		String[] forbitOpArr = ConfigUtil.getContextProperty("sql.forbid.operations", "").split(",");
		sql = StringUtil.replaceSemicolon(sql);
		String[] sqlArr = sql.trim().replace('"', '\'').split(";");

		boolean isErr = false;
		String errMsg = null;
		sqlLoop: for (String oneSql : sqlArr) {
			// mysql准确性验证
			String checkMsg = SQLParserUtils.checkSQLGrammar(oneSql);
			if (isErr = StringUtils.isNotEmpty(checkMsg)) {
				errMsg = "SQL Syntax Error:\n" + checkMsg;
				break;
			}

			// 禁止危险SQL操作
			if (!isAdmin) {
				SQLStatementEnum opType = SQLParserUtils.getSQLType(oneSql);
				for (String forbitOp : forbitOpArr) {
					if (isErr = forbitOp.equalsIgnoreCase(opType.name())) {
						errMsg = "Disabled use \"" + forbitOp + "\" type of SQL!\nIf U really need it, please contact the administrator!";
						break sqlLoop;
					}
				}
			}
		}

		modelMap.addAttribute("isErr", isErr);
		if (isErr) {
			modelMap.addAttribute("errMsg", errMsg);
		}

		return modelMap;
	}
	

	public ModelMap checkHiveGrammar(String sql, boolean isAdmin) {
		ModelMap modelMap = new ModelMap();

		// 禁止操作类型
		String[] forbitOpArr = ConfigUtil.getContextProperty("sql.forbid.operations", "").split(",");
		sql = StringUtil.replaceSemicolon(sql);
		
		String[] sqlArr = sql.trim().replace('"', '\'').split(";");

		boolean isErr = false;
		String errMsg = null;
		sqlLoop: for (String oneSql : sqlArr) {
			// hive sql准确性验证
			String checkMsg = HiveSqlParserUtil.checkSqlGrammar(oneSql);
			if (isErr = StringUtils.isNotEmpty(checkMsg)) {
				errMsg = "SQL Syntax Error:\n" + checkMsg;
				break;
			}

			// 禁止危险SQL操作
			if (!isAdmin) {
				HiveOperationEnum opType = HiveSqlParserUtil.analyzeHiveOperatorType(oneSql);
				for (String forbitOp : forbitOpArr) {
					if (isErr = forbitOp.equalsIgnoreCase(opType.name())) {
						errMsg = "Disabled use \"" + forbitOp + "\" type of SQL!\nIf U really need it, please contact the administrator!";
						break sqlLoop;
					}
				}
			}
		}

		modelMap.addAttribute("isErr", isErr);
		if (isErr) {
			modelMap.addAttribute("errMsg", errMsg);
		}

		return modelMap;
	}
	
	public ModelMap checkSparkGrammar(String sql, boolean isAdmin) {
		ModelMap modelMap = new ModelMap();

		// 禁止操作类型
		String[] forbitOpArr = ConfigUtil.getContextProperty("sql.forbid.operations", "").split(",");
		sql = StringUtil.replaceSemicolon(sql);
		String[] sqlArr = sql.trim().replace('"', '\'').split(";");

		boolean isErr = false;
		String errMsg = null;
		sqlLoop: for (String oneSql : sqlArr) {
			// hive sql准确性验证
			String checkMsg = HiveSqlParserUtil.checkSqlGrammar(oneSql);
			if (isErr = StringUtils.isNotEmpty(checkMsg)) {
				errMsg = "SQL Syntax Error:\n" + checkMsg;
				break;
			}

			// 禁止危险SQL操作
			if (!isAdmin) {
				HiveOperationEnum opType = HiveSqlParserUtil.analyzeHiveOperatorType(oneSql);
				for (String forbitOp : forbitOpArr) {
					if (isErr = forbitOp.equalsIgnoreCase(opType.name())) {
						errMsg = "Disabled use \"" + forbitOp + "\" type of SQL!\nIf U really need it, please contact the administrator!";
						break sqlLoop;
					}
				}
			}
		}

		modelMap.addAttribute("isErr", isErr);
		if (isErr) {
			modelMap.addAttribute("errMsg", errMsg);
		}

		return modelMap;
	}

	@Override
	public List<ProcessEntity> getRunTimeHistory(String processId, String startScheduleDate, String endScheduleDate) {
		return processDao.searchProcessRunHistory(processId, startScheduleDate, endScheduleDate);
	}

	@Override
	public String downProcessErrLog(String errFileName) {
		StringBuilder sb = new StringBuilder();

		File errLog = new File(ConfigUtil.getContextProperty("process.error.log.location", "/var/lib/priest/logs/priest"));
		if (!errLog.exists()) {
			Assert.isTrue(errLog.mkdirs(), "Failed to create the process error log directory:" + errLog);
		}
		File errLogFile = new File(errLog, errFileName);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(errLogFile);
			br = new BufferedReader(fr);
			String oneLine = null;
			while ((oneLine = br.readLine()) != null) {
				sb.append(oneLine).append(Constants.LINE_SEPARATOR);
			}
		} catch (IOException e) {

		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}

			try {
				fr.close();
			} catch (IOException e) {
			}
		}

		return sb.toString();
	}

	@Override
	public void failedHistoryRunning() {
		processDao.failedHistoryRunning();

	}

	@Override
	public void failedRunningProcess() {
		processDao.failedRunningProcess();

	}

	@Override
	public List<ProcessEntity> pushProcesses(ProcessEntity process) {
		Integer processId = process.getProcessId();
		String execDate = process.getExecDate();
		Set<Integer> childrenIds = getProcessChildrenIds(processId);
		List<ProcessEntity> standbyProcesses = new ArrayList<ProcessEntity>();
		for (Integer childId : childrenIds) {
			ProcessEntity childProcess = getProcessRun(childId, execDate);
			// 子流程不存在或者状态为排队或运行时，不直接驱动
			if (childProcess == null || StatusEnum.Q.name().equals(childProcess.getProcessStatus())
					|| StatusEnum.R.name().equals(childProcess.getProcessStatus()) 
					|| (StatusEnum.F.name().equals(childProcess.getProcessStatus()) && childProcess.getMessage().contains(Constants.COMPONENTS_PARAMS_MSG_HEADER))) {
				continue;
			}
			boolean standbyFlag = true;
			Set<Integer> parentsIds = getProcessParentsIds(childId);
			for (Integer parentId : parentsIds) {
				ProcessEntity parentProcess = getProcessRun(parentId, execDate);
				if (parentProcess == null || !StatusEnum.S.name().equals(parentProcess.getProcessStatus())) {
					standbyFlag = false;
					break;
				}
			}
			if (!standbyFlag) {
				continue;
			}
			if (processDao.pushProcess(childProcess) == 1) {
				standbyProcesses.add(childProcess);
			}
		}

		return standbyProcesses;
	}
	
	@Override
	public String getAlarmPhones(String alarmObject) {
		return processDao.getAlarmPhones(alarmObject);
	}
	
	@Override
	public Map<String, Object> getTaskType(Integer processId, String execDate) {
		return processDao.getTaskType(processId, execDate);
	}
}
