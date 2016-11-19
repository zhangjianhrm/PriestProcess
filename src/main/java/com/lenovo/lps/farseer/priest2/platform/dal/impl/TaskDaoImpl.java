package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.platform.dal.TaskDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.mapper.TaskMapper;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

public class TaskDaoImpl implements TaskDao {

	@Autowired
	@Qualifier("taskMapper")
	private TaskMapper taskMapper;

	@Override
	public Integer searchTaskDefCount(Map<String, Object> taskDefMap) {
		return taskMapper.searchTaskDefCount(taskDefMap);
	}

	@Override
	public List<TaskEntity> searchTaskDef(Map<String, Object> taskDefMap) {
		return taskMapper.searchTaskDef(taskDefMap);
	}

	@Override
	public List<TaskOfProcessEntity> searchTaskOfProcessDef(Map<String, Object> taskDefMap) {
		return taskMapper.searchTaskOfProcessDef(taskDefMap);
	}

	@Override
	public void startTask(String processId, String taskId, String taskName, ComponentsType taskType, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_TASK_ID, taskId);
		params.put("taskName", taskName);
		params.put("taskType", taskType);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		taskMapper.startTask(params);
	}

	@Override
	public void terminateTask(String taskId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_TASK_ID, taskId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		taskMapper.terminateTask(params);

	}

	@Override
	public void failedTask(String taskId, String execDate, String detail) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_TASK_ID, taskId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		params.put("detail", detail);
		try {
			taskMapper.failedTask(params);
		} catch (Exception e) {
			AuditLog.log(String.format("taskId[%s] execDate[%s] detail[%s] failedTask error!", taskId, execDate, detail));
			throw new RuntimeException(e);
		}
	}

	@Override
	public void abortTask(Long taskId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_TASK_ID, taskId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		taskMapper.abortTask(params);
	}

	@Override
	public void deleteProcessTasks(Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		taskMapper.deleteProcessTasks(params);
	}
	
	@Override
	public TaskEntity getFirstFailedTask(Integer processId, String execDate){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		return taskMapper.getFirstFailedTask(params);
	}
}
