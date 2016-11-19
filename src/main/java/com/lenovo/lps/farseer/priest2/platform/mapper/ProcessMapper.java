package com.lenovo.lps.farseer.priest2.platform.mapper;

import java.util.List;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.common.entity.IdGen;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public interface ProcessMapper extends Mapper {
	/**
	 * 获取自增processId
	 * 
	 * @return
	 */
	void sqlGenProcessId(IdGen idGen);
	/**
	 * 获取自增taskId
	 * 
	 * @return
	 */
	void sqlGenTaskId(IdGen idGen);
	/**
	 * 流程新增
	 * 
	 * @param process
	 */
	void insertProcess(ProcessEntity process);

	/**
	 * 查询定义流程数量
	 * 
	 * @param processDefMap
	 * @return
	 */
	Long searchProcessDefCount(ProcessEntity requestParam);

	/**
	 * 查询流程定义
	 * 
	 * @param processDefMap
	 * @return
	 */
	List<ProcessEntity> searchProcessDef(ProcessEntity requestParam);

	/**
	 * 查询新修改流程定义
	 * 
	 * @param requestPraam
	 * @return
	 */
	List<ProcessEntity> searchProcessDefByModifyDate(ProcessEntity requestParam);
	
	/**
	 * 根据ID查询流程执行记录
	 * 
	 * @param processRunMap
	 *            里面只包含两类数据，1、流程ID，2、执行状态（可选） processRunMap.put("processId","");
	 *            processRunMap.put("processStatus","");
	 * @return
	 */
	List<ProcessEntity> searchProcessRunById(Map<String, String> processRunMap);

	/**
	 * 根据执行时间查询流程执行记录
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	ProcessEntity searchProcessRunByIdExecDate(Map<String, Object> params);
	
	/**
	 * 根据流程ID和调度时间范围查询流程运行历史
	 * @param params
	 * @return
	 */
	List<ProcessEntity> searchProcessRunHistory(Map<String, String> params);

	/**
	 * 根据流程ID删除流程定义
	 * 
	 * @param processId
	 */
	void deleteProcessDefById(String processId);

	/**
	 * 删除流程实例
	 * 
	 * @param params
	 */
	void deleteProcessRun(Map<String, Object> params);

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
	void updateProcessState(Map<String, Object> params);

	/**
	 * 启动流程
	 * 
	 * @param processId
	 * @param execDate
	 */
	void startProcess(Map<String, Object> params);

	/**
	 * 结束流程
	 * 
	 * @param processId
	 */
	void terminateProcess(Map<String, Object> params);

	/**
	 * 流程失败记录
	 * 
	 * @param processId
	 * @param detail
	 */
	void failedProcess(Map<String, Object> params);
	
	/**
	 * 等待流程失败记录
	 * 
	 * @param processId
	 * @param detail
	 */
	void failedWaitProcess(Map<String, Object> params);

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
	 * @param params
	 * @return
	 */
	List<ProcessEntity> getProcessRun(Map<String, Object> params);

	/**
	 * 更新流程schedule日期
	 * 
	 * @param process
	 */
	void updateScheduleDate(ProcessEntity process);

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
	void abortProcess(Map<String, Object> params);

	/**
	 * 更新流程运行过程中产生的流程变量
	 * 
	 * @param params
	 */
	void updateRunningProcessVariable(Map<String, Object> params);

	/**
	 * 超8小时未调度的流程，标记超时
	 * 
	 * @param scheduleDate
	 */
	void updateExpiredProcessRun(String scheduleDate);

	/**
	 * 审核流程
	 * 
	 * @param params
	 */
	void validateProcess(Map<String, Object> params);

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
	 * @param params
	 */
	void historyCancelProcess(Map<String, Object> params);
	
	/**
	 * 取消指定流程历史数据补跑
	 * 
	 * @param params
	 */
	void failedHistoryPro(Map<String, Object> params);
	
	/**
	 * 检查流程是否为补跑流程
	 * 
	 * @param params
	 */
	int checkHistoryPro(Map<String, Object> params);
	
	/**
	 * 获取告警的手机号
	 * 
	 * @param params
	 */
	String getAlarmPhones(Map<String, Object> params);
	
	/**
	 * 获取流程正在执行任务的任务类型
	 * 
	 * @param params
	 */
	Map<String, Object> getTaskType(Map<String, Object> params);

	/**
	 * 触发流程
	 * 
	 * @param process
	 * @return 
	 */
	Integer pushProcess(ProcessEntity process);
	
	/**
	 * Jetty关闭hook，清理补跑流程
	 */
	void failedHistoryRunning();
	/**
	 * Jetty关闭hook,请理正在运行流程
	 */
	void failedRunningProcess();
}