package com.lenovo.lps.farseer.priest2.platform.dal;

import java.util.List;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;

public interface ProcessDao {
	/**
	 * 流程新增
	 * 
	 * @param process
	 */
	void insertProcess(ProcessEntity process);

	/**
	 * 查询流程定义
	 * 
	 * @param processDefMap
	 * @return
	 */
	List<ProcessEntity> searchProcessDef(ProcessEntity requestParam);

	/**
	 * 查询流程定义总记录
	 * 
	 * @param processDefMap
	 * @return
	 */
	Long searchProcessDefCount(ProcessEntity requestParam);

	/**
	 * 查询流程执行记录
	 * 
	 * @param processRunMap
	 *            里面只包含两类数据，1、流程ID，2、执行状态（可选） processRunMap.put("processId","");
	 *            processRunMap.put("processStatus","");
	 * @return
	 */
	List<ProcessEntity> searchProcessRun(Map<String, String> processRunMap);

	/**
	 * 根据执行时间查询流程执行记录
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	ProcessEntity searchProcessRunByIdExecDate(String processId, String execDate);
	
	/**
	 * 根据流程ID和调度时间范围查询流程运行历史
	 * @param processId
	 * @param beginScheduleDate
	 * @param endScheduleDate
	 * @return
	 */
	List<ProcessEntity> searchProcessRunHistory(String processId, String beginScheduleDate, String endScheduleDate);

	/**
	 * 删除流程定义
	 * 
	 * @param processId
	 */
	void deleteProcessDefById(String processId);

	/**
	 * 删除流程执行记录
	 * 
	 * @param processId
	 */
	void deleteProcessRun(Integer processId, String execDate);

	/**
	 * 修改流程
	 * 
	 * @param process
	 */
	void updateProcess(ProcessEntity process);

	/**
	 * 更新流程状态
	 * 
	 * @param processId
	 * @param processStatus
	 */
	void updateProcessState(Integer processId, String processState, String updatedBy);

	/**
	 * 启动流程
	 * 
	 * @param processId
	 * @param execDate
	 * @param processVariables
	 */
	void startProcess(String processId, String execDate, Map<String, Object> processVariables);

	/**
	 * 结束流程
	 * 
	 * @param processId
	 */
	void terminateProcess(String processId, String execDate);

	/**
	 * 流程失败记录
	 * 
	 * @param processId
	 * @param detail
	 */
	void failedProcess(String processId, String execDate, String detail);
	
	/**
	 * 等待流程取消记录
	 * 
	 * @param processId
	 * @param detail
	 */
	void failedWaitProcess(String processId, String execDate, String detail);

	/**
	 * 获取系统内配制的有效流程
	 * 
	 * @return
	 */
	List<ProcessEntity> getValidProcess(String scheduleDate);

	/**
	 * 往P_PROCESS_RUN表批量insert
	 * 
	 * @param processList
	 */
	void batchInsertRun(List<ProcessEntity> processList);

	/**
	 * 获取流程运行数据
	 * 
	 * @param execDate
	 * @param scheduleDate
	 * @return
	 */
	List<ProcessEntity> getProcessRun(String scheduleDate, String processStatus);

	/**
	 * 批量更新流程实例 状态
	 * 
	 * @param processList
	 */
	void batchUpdateStatus(List<ProcessEntity> processList, StatusEnum status);

	/**
	 * 更新流程schedule日期
	 * 
	 * @param process
	 */
	void updateScheduleDate(List<ProcessEntity> processes);

	/**
	 * 用户创建流程时指定了最晚执行时间，本方法获取超过最晚执行时间尚未执行的流程
	 * 
	 * @param params
	 * @return
	 */
	List<ProcessEntity> getScheduleDelayedProcess(String scheduleDate);

	/**
	 * 终止流程运行
	 * 
	 * @param processId
	 * @param execDate
	 */
	void abortProcess(Integer processId, String execDate);

	/**
	 * 更新流程运行过程中产生的流程变量
	 * 
	 * @param processId
	 * @param execDate
	 * @param processVariablesInMemory
	 */
	void updateRunningProcessVariable(Integer processId, String execDate, String processVariableJsonStr);

	/**
	 * 超8小时未调度的流程，标记超时
	 * 
	 * @param scheduleDate
	 */
	void updateExpiredProcessRun(String scheduleDate);

	/**
	 * 审核流程
	 * 
	 * @param processId
	 * @param resultState
	 * @param investigationReason
	 */
	void validateProcess(Integer processId, String resultState, String investigationReason);

	/**
	 * 更新运行流程
	 * 
	 * @param process
	 */
	void updateProcessRun(ProcessEntity process);

	/**
	 * 更新流程状态
	 * 
	 * @param process
	 */
	@Deprecated
	void updateProcessStatus(ProcessEntity process);

	/**
	 * 启动历史流程补跑
	 * 
	 * @param process
	 */
	Integer historyProcess(ProcessEntity process);

	/**
	 * 取消历史数据补跑
	 * 
	 * @param processId
	 * @param execDate
	 */
	void historyCancelProcess(Integer processId, String execDate);
	
	/**
	 * 触发流程
	 * 
	 * @param process
	 */
	Integer pushProcess(ProcessEntity process);

	/**
	 * 查询新修改流程定义
	 * 
	 * @param requestParam
	 * @return
	 */
	List<ProcessEntity> searchProcessDefByModifyDate(ProcessEntity requestParam);

	/**
	 * 批量设置流程实例状态为失败
	 * 
	 * @param processList
	 * @param message
	 */
	void batchFailProcs(List<ProcessEntity> processList, String message);
	
	/**
	 * Jetty关闭hook，清理补跑流程
	 */
	void failedHistoryRunning();
	
	/**
	 * 取消补跑失败后的补充步骤
	 */
	void cancelAgain(String msg, Integer processId, String execDate);
	
	/**
	 * 检查流程是否为补跑流程
	 */
	boolean checkHistoryPro(Integer processId, String execDate);
	
	/**
	 * 获取正在运行流程的任务类型
	 */
	Map<String, Object> getTaskType(Integer processId, String execDate);
	
	/**
	 * 获取告警对象手机号
	 */
	String getAlarmPhones(String alarmObject);
	
	/**
	 * Jetty关闭hook,请理正在运行流程
	 */
	void failedRunningProcess();
}
