package com.lenovo.lps.farseer.priest2.platform.entity;

public class StatParam {
	private String appName;
	private String appUser;
	private String execDate;
	private Integer processId;
	private Integer taskId;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppUser() {
		return appUser;
	}
	public void setAppUser(String appUser) {
		this.appUser = appUser;
	}
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public Integer getProcessId() {
		return processId;
	}
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	@Override
	public String toString() {
		return "StatParam [appName=" + appName + ", appUser=" + appUser
				+ ", execDate=" + execDate + ", processId=" + processId
				+ ", taskId=" + taskId + "]";
	}
}
