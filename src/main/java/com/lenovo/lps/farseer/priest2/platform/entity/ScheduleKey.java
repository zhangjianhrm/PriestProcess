package com.lenovo.lps.farseer.priest2.platform.entity;

public class ScheduleKey {
	private Integer processId;// 流程id
	private String processPriority;// 流程优先级
	private String scheduleDate;// 调度日期
	private String scheduleTime;// 调度时间

	// 数据日期
	private String execDate;

	public ScheduleKey(Integer processId, String processPriority, String scheduleDate, String scheduleTime, String execDate) {
		this.processId = processId;
		this.processPriority = processPriority;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
		this.execDate = execDate;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public String getProcessPriority() {
		return processPriority;
	}

	public void setProcessPriority(String processPriority) {
		this.processPriority = processPriority;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

}
