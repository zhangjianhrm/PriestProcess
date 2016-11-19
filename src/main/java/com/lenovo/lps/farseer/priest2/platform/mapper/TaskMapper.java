package com.lenovo.lps.farseer.priest2.platform.mapper;

import java.util.List;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;

public interface TaskMapper extends Mapper {
	/**
	 * 查询流程包含的任务数
	 * 
	 * @param taskDefMap
	 * @return
	 */
	Integer searchTaskDefCount(Map<String, Object> taskDefMap);

	/**
	 * 查询流程包含的任务
	 * 
	 * @param taskDefMap
	 * @return
	 */
	List<TaskEntity> searchTaskDef(Map<String, Object> taskDefMap);

	/**
	 * 查询流程包含的任务(with process name)
	 * 
	 * @param taskDefMap
	 * @return
	 */
	List<TaskOfProcessEntity> searchTaskOfProcessDef(Map<String, Object> taskDefMap);

	/**
	 * 启动任务
	 * 
	 * @param processId
	 * @param taskId
	 * @param taskName
	 * @param taskType
	 * @param execDate
	 */
	public void startTask(Map<String, Object> params);

	/**
	 * 结束任务运行
	 * 
	 * @param taskId
	 */
	public void terminateTask(Map<String, Object> params);

	/**
	 * 任务失败记录
	 * 
	 * @param taskId
	 * @param detail
	 */
	public void failedTask(Map<String, Object> params);

	/**
	 * 终止任务执行
	 * 
	 * @param taskId
	 * @param detail
	 */
	public void abortTask(Map<String, Object> params);

	/**
	 * 删除流程某天执行任务
	 * 
	 * @param taskId
	 * @param execDate
	 */
	public void deleteProcessTasks(Map<String, Object> params);
	
	/**
	 * 获取流程第一个失败task
	 * @param params
	 */
	public TaskEntity getFirstFailedTask(Map<String, Object> params);
}
