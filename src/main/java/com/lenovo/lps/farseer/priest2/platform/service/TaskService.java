package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.List;

import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;

public interface TaskService {
	/**
	 * 获取任务运行数据
	 * 
	 * @param taskId
	 * @param execDate
	 * @return
	 */
	TaskEntity getTaskRun(Integer taskId, String execDate);

	/**
	 * 获取任务信息
	 * 
	 * @param processId
	 * @param execDate
	 * @param taskStatus
	 * @return
	 */
	TaskEntity getTask(String processId, String execDate, String taskStatus);

	/**
	 * 获取任务信息
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	List<TaskEntity> getTask(String processId, String execDate);

	/**
	 * 获取任务信息
	 * 
	 * @param processId
	 * @param processName
	 * @param execDate
	 * @param taskStatus
	 * @param orderByCol
	 * @param sord
	 * @param start
	 * @param offset
	 * @return
	 */
	List<TaskEntity> getTask(String processId, String processName, String execDate, String taskStatus, String orderByCol,
			String sord, Integer start, Integer offset);

	/**
	 * 获取任务信息
	 * 
	 * @param processId
	 * @param processName
	 * @param execDate
	 * @param taskStatus
	 * @param orderByCol
	 * @param sord
	 * @param start
	 * @param offset
	 * @return
	 */
	List<TaskOfProcessEntity> getTaskOfProcess(String processId, String processName, String execDate, String taskStatus,
			String orderByCol, String sord, Integer start, Integer offset);

	/**
	 * 获取任务总数
	 * 
	 * @param processId
	 * @param processName
	 * @param execDate
	 * @param taskStatus
	 * @return
	 */
	Integer getTaskCount(String processId, String processName, String execDate, String taskStatus);

	/**
	 * 启动任务
	 * 
	 * @param processId
	 * @param taskId
	 * @param taskName
	 * @param taskType
	 * @param execDate
	 */
	void startTask(String processId, String taskId, String taskName, ComponentsType taskType, String execDate);

	/**
	 * 结束任务运行
	 * 
	 * @param taskId
	 */
	void terminateTask(String taskId, String execDate);

	/**
	 * 任务失败记录
	 * 
	 * @param taskId
	 * @param detail
	 */
	void failedTask(String taskId, String execDate, String detail);

	/**
	 * 终止任务运行
	 * 
	 * @param taskId
	 * @param execDate
	 */
	void abortTask(Long taskId, String execDate);
	
	/**
	 * 删除流程某天执行任务
	 * 
	 * @param processId
	 * @param execDate
	 */
	void deleteProcessTasks(Integer processId, String execDate);
	
	/**
	 * 获取流程第一个失败task
	 * @param params
	 */
	TaskEntity getFirstFailedTask(Integer processId, String execDate);
	
	/**
	 * 下载任务错误日志
	 * @param errFileName
	 * @return
	 */
	String downTaskErrLog(String errFileName);
}
