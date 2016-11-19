package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.dal.TaskDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

public class TaskServiceImpl implements TaskService {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	@Qualifier("taskDao")
	private TaskDao taskDao;
	
	@Override
	public TaskEntity getTaskRun(Integer taskId, String execDate) {
		return null;
	}

	@Override
	public TaskEntity getTask(String processId, String execDate, String taskStatus) {
		TaskEntity entity = null;
		List<TaskEntity> entities = getTask(processId, null, execDate, taskStatus, null, null, null, null);
		if (entities != null) {
			if (entities.size() == 1) {
				entity = entities.get(0);
			}
		}
		return entity;
	}

	@Override
	public List<TaskEntity> getTask(String processId, String execDate) {
		return getTask(processId, null, execDate, null, null, null, null, null);
	}

	@Override
	public List<TaskEntity> getTask(String processId, String processName, String execDate, String taskStatus, String orderByCol,
			String sord, Integer start, Integer offset) {
		Map<String, Object> taskMap = new HashMap<String, Object>();
		String wrapedProcessName = StringUtils.isNotEmpty(processName) ? "%" + processName + "%" : null;

		taskMap.put("processId", processId);
		taskMap.put("processName", wrapedProcessName);
		taskMap.put("execDate", execDate);
		taskMap.put("taskStatus", taskStatus);
		taskMap.put("orderBy", orderByCol);
		taskMap.put("sord", sord);
		taskMap.put("start", start);
		taskMap.put("offset", offset);
		return taskDao.searchTaskDef(taskMap);
	}

	@Override
	public List<TaskOfProcessEntity> getTaskOfProcess(String processId, String processName, String execDate, String taskStatus,
			String orderByCol, String sord, Integer start, Integer offset) {
		Map<String, Object> taskMap = new HashMap<String, Object>();
		String wrapedProcessName = StringUtils.isNotEmpty(processName) ? "%" + processName + "%" : null;

		taskMap.put("processId", processId);
		taskMap.put("processName", wrapedProcessName);
		taskMap.put("execDate", execDate);
		taskMap.put("taskStatus", taskStatus);
		taskMap.put("orderBy", orderByCol);
		taskMap.put("sord", sord);
		taskMap.put("start", start);
		taskMap.put("offset", offset);
		return taskDao.searchTaskOfProcessDef(taskMap);
	}

	@Override
	public Integer getTaskCount(String processId, String processName, String execDate, String taskStatus) {
		Map<String, Object> taskMap = new HashMap<String, Object>();
		String wrapedProcessName = null;

		if (StringUtils.isNotEmpty(processName)) {
			wrapedProcessName = "%" + processName + "%";
		}

		taskMap.put("processId", processId);
		taskMap.put("processName", wrapedProcessName);
		taskMap.put("execDate", execDate);
		taskMap.put("taskStatus", taskStatus);
		return taskDao.searchTaskDefCount(taskMap);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void startTask(String processId, String taskId, String taskName, ComponentsType taskType, String execDate) {
		taskDao.startTask(processId, taskId, taskName, taskType, execDate);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void terminateTask(String taskId, String execDate) {
		taskDao.terminateTask(taskId, execDate);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void failedTask(String taskId, String execDate, String detail) {
		// 错误信息长度超过50的，将错误信息写入日志文件中；反之将信息写入DB中
		if (detail.length() > 50) {
			detail = failTaskToFile(taskId, execDate, detail);
		} 
		
		taskDao.failedTask(taskId, execDate, detail);
	}
	
	private String failTaskToFile(String taskId, String execDate, String detail) {
		// 任务错误日志文件名格式： task-$(taskId)-${execDate}-error.log
		String logFileName = "task-" + taskId + "-" + execDate + "-error.log";
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
			logger.warn("Write task error log failed.", e);
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				logger.warn(e);
			}

			try {
				fw.close();
			} catch (IOException e) {
				logger.warn(e);
			}
		}
		
		return logFileName;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void abortTask(Long taskId, String execDate) {
		taskDao.abortTask(taskId, execDate);
	}

	@Override
	public TaskEntity getFirstFailedTask(Integer processId, String execDate) {
		return taskDao.getFirstFailedTask(processId, execDate);
	}

	@Override
	public void deleteProcessTasks(Integer processId, String execDate) {
		taskDao.deleteProcessTasks(processId, execDate);
	}

	@Override
	public String downTaskErrLog(String errFileName) {
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
}
