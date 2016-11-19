package com.lenovo.lps.farseer.priest2.platform.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;

public interface ProcessService {
	/**
	 * 获取流程运行数据
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	ProcessEntity getProcessRun(Integer processId, String execDate);

	/**
	 * 流程新增
	 * 
	 * @param process
	 */
	void insertProcess(ProcessEntity process);

	/**
	 * 查询定义流程
	 * 
	 * @param processId
	 * @return
	 * @throws ParseException
	 */
	ProcessEntity getProcessDef(String processId);

	/**
	 * 查询定义流程
	 * 
	 * @param requestParam
	 * @return
	 * @throws ParseException
	 */
	PagingResult<ProcessEntity> getProcessDef(ProcessEntity requestParam);

	/**
	 * 查询流程执行记录
	 * 
	 * @param processId
	 * @param processStatus
	 * @return
	 */
	List<ProcessEntity> getProcessRun(String processId, String processStatus);

	/**
	 * 获取执行日期当天流程实例（包括依赖流程ID）
	 * 
	 * @param execDate
	 * @return
	 */
	List<ProcessEntity> getProcessRunsIncDepId(ProcessEntity param);
	
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
	 * @param processState
	 */
	void updateProcessState(Integer processId, String processState, HttpSession session);

	/**
	 * 审核流程
	 * 
	 * @param processId
	 * @param processState
	 * @param investigationResult
	 */
	void validateProcess(Integer processId, String resultState, String investigationReason);

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
	 * 扫描流程定义表,加载当天所有符合运行条件的记录到P_PROCESS_RUN表,准备运行
	 */
	void loadProcessToRunDaily();

	/**
	 * 获取流程运行数据
	 * 
	 * @param execDate
	 * @param processStatus
	 * @return
	 */
	List<ProcessEntity> getProcessFails(ProcessEntity param);
	
	/**
	 * 获取流程运行数据
	 * 
	 * @param execDate
	 * @param processStatus
	 * @return
	 */
	PagingResult<ProcessEntity> getProcessRuns(ProcessEntity param);

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
	 * 批量更新流程实例 状态
	 * 
	 * @param processList
	 */
	void batchUpdateStatus(List<ProcessEntity> processList, StatusEnum status);

	/**
	 * 判断流程是否执行失败(是否有失败子任务)
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	boolean checkProcessFailed(Integer processId, String execDate);

	/**
	 * 更新流程运行过程中产生的流程变量
	 * 
	 * @param processId
	 * @param execDate
	 * @param processVariablesInMemory
	 */
	void updateRunningProcessVariable(Integer processId, String execDate, Map<String, Object> processVariablesInMemory);

	/**
	 * 通过流程名查询定义流程
	 * 
	 * @param processName
	 * @return
	 */
	ProcessEntity getProcessDefByName(String processName);

	/**
	 * 超8小时未调度的流程，标记超时
	 * 
	 * @param scheduleDate
	 */
	void updateExpiredProcessRun(String scheduleDate);

	/**
	 * 获取流程的子节点流程
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	Set<Integer> getProcessChildrenIds(Integer processId);

	/**
	 * 获取流程的父节点流程
	 * 
	 * @param processId
	 * @return
	 */
	Set<Integer> getProcessParentsIds(Integer processId);
	
	/**
	 * mysql语句验证
	 * @return
	 */
	ModelMap checkMysqlGrammar(String sql, boolean isAdmin);
	
	/**
	 * Hive语句验证
	 * @return
	 */
	ModelMap checkHiveGrammar(String sql, boolean isAdmin);
	
	/**
	 * Spark语句验证
	 * @return
	 */
	ModelMap checkSparkGrammar(String sql, boolean isAdmin);
	
	/**
	 * 根据流程ID获取流程运行历史时长
	 * @param processId
	 * @param startScheduleDate
	 * @param endScheduleDate 
	 * @return
	 */
	List<ProcessEntity> getRunTimeHistory(String processId, String startScheduleDate, String endScheduleDate);
	
	/**
	 * 下载流程错误日志
	 * @param errFileName
	 * @return
	 */
	String downProcessErrLog(String errFileName);
	
	/**
	 * Jetty关闭hook，清理补跑流程
	 */
	void failedHistoryRunning();
	/**
	 * Jetty关闭hook,请理正在运行流程
	 */
	void failedRunningProcess();
	
	/**
	 * 主动触发后续流程
	 * 
	 * @param process
	 * @throws Exception
	 */
	public List<ProcessEntity> pushProcesses(ProcessEntity process);
	
	/**
	 * 获取告警对象手机号
	 * 
	 * @param alarmObject
	 */
	public String getAlarmPhones(String alarmObject);
	
	/**
	 * 获取正在运行流程任务的任务类型
	 * 
	 * @param processId
	 * @param execDate
	 */
	public Map<String, Object> getTaskType(Integer processId, String execDate);
}
