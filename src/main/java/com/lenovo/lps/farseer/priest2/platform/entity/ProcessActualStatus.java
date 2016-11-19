package com.lenovo.lps.farseer.priest2.platform.entity;

import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class ProcessActualStatus {
	private String processName;
	
	private String processId;
	
	private String processStatus;
	
	private String execDate;

	private String startTime;
	
	private String endTime;
	
	private String appName;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getStartTime() {
		return startTime != null && startTime.length()>19?startTime.substring(0, 19):startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime != null && endTime.length()>19?endTime.substring(0, 19):endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAppName() {
		return appName == null ? "":appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = StringUtil.getStatusDetail(processStatus);
	}
}
