package com.lenovo.lps.farseer.priest2.platform.manager.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.manager.TaskManager;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.DataTransformation;

public class TaskManagerImpl implements TaskManager {

	@Autowired
	@Qualifier("taskService")
	private TaskService taskService;

	@Autowired
	@Qualifier("processService")
	private ProcessService processService;

	@Override
	public List<TaskEntity> getTask(String processId, String processName, String execDate, Integer rows, Integer page, String sidx,
			String sord) {
		Integer pageNum = 1, start = null;
		if (page != null) {
			pageNum = page;
		}
		if (rows != null) {
			start = rows * (pageNum - 1);
		}
		return taskService.getTask(processId, processName, execDate, null, sidx, sord, start, rows);
	}

	@Override
	public Map<String, Integer> getTaskTotalPage(String processId, String processName, String execDate, Integer rows) {
		Integer rowNum = rows;
		// 默认50 条
		if (rowNum == null || rowNum.intValue() == 0) {
			rowNum = 50;
		}

		Integer count = taskService.getTaskCount(processId, processName, execDate, null);
		Integer totalPage = (count - 1) / rowNum + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(Constants.RESPONSE_RESULT_TOTALPAGES, totalPage);
		map.put(Constants.RESPONSE_RESULT_TOTALRECORDS, count);
		return map;
	}

	@Override
	public String tintProcess(String processId, String execDate) throws ParseException, JsonProcessingException, IOException {
		ProcessEntity processEntity = processService.getProcessDef(processId);

		if (processEntity == null) {
			throw new PriestPlatformException("The processId is not exit");
		}

		List<TaskEntity> entities = taskService.getTask(processId, execDate);
		List<String> greenTasks = new ArrayList<String>();
		List<String> redTasks = new ArrayList<String>();
		List<String> yellowTasks = new ArrayList<String>();
		for (TaskEntity entity : entities) {
			String taskId = String.valueOf(entity.getTaskId());
			if (StatusEnum.S.name().equalsIgnoreCase(entity.getTaskStatus())) {
				greenTasks.add(taskId);
			} else if (StatusEnum.F.name().equalsIgnoreCase(entity.getTaskStatus())
					|| StatusEnum.C.name().equalsIgnoreCase(entity.getTaskStatus())) {
				redTasks.add(taskId);
			} else if (StatusEnum.R.name().equalsIgnoreCase(entity.getTaskStatus())) {
				yellowTasks.add(taskId);
			}
		}
		return DataTransformation.tintProcessDefOfJson(processEntity.getJsonDef(), greenTasks, redTasks, yellowTasks);
	}

	@Override
	public List<TaskOfProcessEntity> getTaskOfProcess(String processId, String processName, String execDate, Integer rows,
			Integer page, String sidx, String sord) {
		Integer pageNum = 1, start = null;
		if (page != null) {
			pageNum = page;
		}
		if (rows != null) {
			start = rows * (pageNum - 1);
		}
		return taskService.getTaskOfProcess(processId, processName, execDate, null, sidx, sord, start, rows);
	}

}
