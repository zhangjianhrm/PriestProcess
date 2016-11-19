/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDao;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDepDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.service.JbpmProcessService;

/**
 * @author hubin3
 * 
 */
public class SupplementProcessRunWork implements Runnable {

	private Logger logger = Logger.getLogger(SupplementProcessRunWork.class);

	private final String threadName = "supplement_process_run_thread";

	/**
	 * <pre>
	 * 最外层Map:   processId_startDate_endDate ==>多天需要补跑的流程(补跑时，界面指定多天）
	 *  里层Map:         日期 ==>该日期下需要补跑的流程
	 * </pre>
	 */
	private Map<String, Map<String, List<ProcessEntity>>> historyWaittingRunMap;

	/**
	 * 运行记录Map processId_startDate_endDate ==> 运行中的日期
	 */
	private Map<String, String> historyRunningMap;

	private ProcessDao processDao;
	
	private ProcessDepDao processDepDao;

	private JbpmProcessService jbpmProcessService;

	public SupplementProcessRunWork(Map<String, Map<String, List<ProcessEntity>>> historyWaittingRunMap, ProcessDao processDao,
			JbpmProcessService jbpmProcessService, Map<String, String> historyRunningMap, ProcessDepDao processDepDao) {
		this.processDao = processDao;
		this.historyWaittingRunMap = historyWaittingRunMap;
		this.jbpmProcessService = jbpmProcessService;
		this.historyRunningMap = historyRunningMap;
		this.processDepDao = processDepDao;
	}

	@Override
	public void run() {
		try {
			// 设置线程名,方便jstack等工具调试
			Thread.currentThread().setName(threadName);

			/**
			 * 下面开始每天日常调度
			 */

			/**
			 * <pre>
			 * processId_startDate_endDate ==>多天需要补跑的流程(补跑时，界面可以指定多天）
			 * </pre>
			 */
			if (historyWaittingRunMap.size() > 0) {
				// process4OneTime 日期 ==>该日期下需要补跑的流程
				Iterator<Entry<String, Map<String, List<ProcessEntity>>>> historyWaittingRunIte = historyWaittingRunMap.entrySet()
						.iterator();
				// 迭代提交的所有补跑:
				while (historyWaittingRunIte.hasNext()) {
					Entry<String, Map<String, List<ProcessEntity>>> wait = historyWaittingRunIte.next();
					String uniqKey = wait.getKey();
					Map<String, List<ProcessEntity>> process4OneTime = wait.getValue();

					// 本次补跑已经开始调度，检查调度完成度，完成后，准备下一天调度
					if (historyRunningMap.containsKey(uniqKey)) {
						String execDate = historyRunningMap.get(uniqKey);
						
						if (CommUtils.isNull(execDate) || process4OneTime == null || process4OneTime.get(execDate) == null) {
							historyRunningMap.remove(uniqKey);
							AuditLog.log(String.format("History process[%s] info[%s] remove [%s] is running but no!", uniqKey, process4OneTime, execDate));
							if (process4OneTime == null || process4OneTime.isEmpty()) {
								historyWaittingRunIte.remove();
								// 流程都补跑完了，返回
								if (historyWaittingRunMap.isEmpty()) {
									return;
								}
							}
							// 本次补跑已经完成，开始下一个补跑调度
							continue;
						}

						// 单天流程是否全部被调度标志
						boolean isAllScheduled = true;
						for (ProcessEntity process : process4OneTime.get(execDate)) {
							if(!process.isScheduled()){
								isAllScheduled = false;
								break;
							}
						}
							
						// 当天流程全部调度完再判断是否清理资源
						if (isAllScheduled) {
							// 单天流程是否跑完标记
							boolean finished = true;
							for (ProcessEntity process : process4OneTime.get(execDate)) {
								if (jbpmProcessService.checkRunningProcess(process.getProcessId(), process.getExecDate())) {
									finished = false;
									break;
								}
							}
							
							// 当天补跑完成，内存资源清理
							if (finished) {
								historyRunningMap.remove(uniqKey);
								AuditLog.log(String.format("History process[%s] info[%s] remove [%s] by finish", uniqKey, process4OneTime, execDate));
								process4OneTime.remove(execDate);
								if (process4OneTime.isEmpty()) {
									historyWaittingRunIte.remove();
									// 流程都补跑完了，返回
									if (historyWaittingRunMap.isEmpty()) {
										return;
									}

									// 本次补跑已经完成，开始下一个补跑调度
									continue;
								}
								// else进入下面代码，调度本次补跑其它日期流程
							}
							// 补跑中:调度其它补跑
							else {
								continue;
							}
						}
					}

					/**
					 * else
					 */
					if (process4OneTime == null || process4OneTime.isEmpty()) {
						historyWaittingRunIte.remove();
						// 流程都补跑完了，返回
						if (historyWaittingRunMap.isEmpty()) {
							return;
						}

						// 本次补跑已经完成，开始下一个补跑调度
						continue;
					}

					// 尚未调度，或者经过上一步检查后，已经调度完成，准备下一天调度
					Iterator<String> ite = process4OneTime.keySet().iterator();
					// 调度第一天流程
					String execDate = ite.next();
					List<ProcessEntity> process4OneDay = process4OneTime.get(execDate);

					// 未调度流程列表
					List<ProcessEntity> toRunProcess = new ArrayList<ProcessEntity>();
					boolean flagRemove = true;
					for (ProcessEntity process : process4OneDay) {
						if ((!process.isScheduled()) && isParentsFinished(execDate, process.getProcessId())) {
							if (!StatusEnum.F.name().equals(process.getProcessStatus())) {
								toRunProcess.add(process);
								flagRemove = false;
							}
						} else if((!process.isScheduled()) && isParentsRunning(execDate, process.getProcessId())) {
							flagRemove = false;
						}
					}
					if (flagRemove) {
						historyRunningMap.remove(uniqKey);
						AuditLog.log(String.format("History process[%s] info[%s] remove [%s] by parentRun or processFail", uniqKey, process4OneTime, execDate));
					}
					if(!toRunProcess.isEmpty()){
						// 更新DB，流程标记为正在排队
						processDao.batchUpdateStatus(toRunProcess, StatusEnum.Q);
						// 提交运行
						for(ProcessEntity process : toRunProcess){
							process.setScheduled(true);
							jbpmProcessService.submitJbpmProcess(process);
						}
						AuditLog.log(String.format("History process[%s] info[%s] add [%s]", uniqKey, process4OneTime, execDate));
					
						// 内存标记运行
						historyRunningMap.put(uniqKey, execDate);
					} else if (!historyRunningMap.containsKey(uniqKey)) {
						AuditLog.log(String.format("History process[%s] info[%s] remove [%s] by no running", uniqKey, process4OneTime, execDate));
						process4OneTime.remove(execDate);
						if (process4OneTime.isEmpty()) {
							historyWaittingRunIte.remove();
							// 流程都补跑完了，返回
							if (historyWaittingRunMap.isEmpty()) {
								return;
							}
						}
					}
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 取消正在执行，待调度补跑
	 */
//	private void cancelRunning(Integer startTime, Integer endTime) {
//		List<ProcessEntity> supplyProcs = new ArrayList<ProcessEntity>();
//
//		// 取消所有正在补跑的流程
//		if (historyRunningMap.size() > 0) {
//			Iterator<Entry<String, String>> historyRunningIte = historyRunningMap.entrySet().iterator();
//
//			while (historyRunningIte.hasNext()) {
//				Entry<String, String> historyRunningEntry = historyRunningIte.next();
//				String uniqKey = historyRunningEntry.getKey();
//				String runningExecDate = historyRunningEntry.getValue();
//
//				Map<String, List<ProcessEntity>> process4OneTime = historyWaittingRunMap.get(uniqKey);
//				List<ProcessEntity> process4OneDay = process4OneTime.get(runningExecDate);
//
//				// 加null判断，有可能补跑运行完后，被补跑线程清除内存状态
//				for (ProcessEntity p : process4OneDay) {
//					jbpmProcessService.cancelRunningProcess(p.getProcessId(), p.getExecDate());
//				}
//				logger.info(String.format("History process[%s] info[%s] remove [%s] by 0-8 can't run!", uniqKey, process4OneTime, runningExecDate));
//
//				process4OneTime.remove(runningExecDate);
//				if (process4OneTime.isEmpty()) {
//					historyWaittingRunMap.remove(uniqKey);
//				}
//
//				historyRunningIte.remove();
//			}
//		}
//
//		// 取消待补跑的流程
//		if (historyWaittingRunMap.size() > 0) {
//			// 清空内存中数据
//			// 迭代多次补跑
//			for (Map<String, List<ProcessEntity>> process4OneTime : historyWaittingRunMap.values())
//				// 按天迭代
//				for (List<ProcessEntity> processPerday : process4OneTime.values()) {
//					supplyProcs.addAll(processPerday);
//				}
//			// 数据中设置状态为失败
//			processDao.batchFailProcs(supplyProcs, String.format("Can't rerun process of the historical data between %d To %d", startTime, endTime));
//
//			historyWaittingRunMap.clear();
//		}
//	}
	
	/**
	 * 检查父流程是否都执行成功
	 * @param execDate
	 * @param processId
	 * @return
	 */
	private boolean isParentsFinished(String execDate, Integer processId) {
		Set<Integer> parentsIdSet = processDepDao.getProcessParentsIds(processId);
		
		// 根结点直接返回成功
		if(parentsIdSet.isEmpty()){
			return true;
		}
		
		for(Integer parentId : parentsIdSet){
			ProcessEntity parentEntity = processDao.searchProcessRunByIdExecDate(String.valueOf(parentId), execDate);
			if (parentEntity == null || !StatusEnum.S.name().equals(parentEntity.getProcessStatus())) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 检查父流程是否正在执行
	 * @param execDate
	 * @param processId
	 * @return
	 */
	private boolean isParentsRunning(String execDate, Integer processId) {
		Set<Integer> parentsIdSet = processDepDao.getProcessParentsIds(processId);
		
		// 根结点直接返回成功
		if(parentsIdSet.isEmpty()){
			return false;
		}
		
		for(Integer parentId : parentsIdSet){
			ProcessEntity parentEntity = processDao.searchProcessRunByIdExecDate(String.valueOf(parentId), execDate);
			if (StatusEnum.R.name().equals(parentEntity.getProcessStatus())) {
				return true;
			}
		}
		
		return false;
	}
}
