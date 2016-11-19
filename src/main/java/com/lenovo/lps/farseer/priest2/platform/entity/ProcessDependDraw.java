package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.Serializable;

public class ProcessDependDraw implements Serializable {

	private static final long serialVersionUID = -229746751778402438L;

	private Integer processId;// 流程id
	private String processName;// 流程名称
	private String processApp;// 流程所属应用
	private String scheduleDate;// 调度日期
	private String processState;// 流程状态:N正常,D禁止,I待审核,R审核不通过
	
	private String scheduleType;

	private String execDate;
	
	private Integer depProcessId;// 依赖流程ID

	// 流程状态
	private String processStatus;// 流程执行状态:W:等待执行R:正在执行S:成功执行F:失败执行P:暂停执行C:取消执行H:等待补跑

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessApp() {
		return processApp;
	}

	public void setProcessApp(String processApp) {
		this.processApp = processApp;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public Integer getDepProcessId() {
		return depProcessId;
	}

	public void setDepProcessId(Integer depProcessId) {
		this.depProcessId = depProcessId;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof ProcessDependDraw) {
			ProcessDependDraw o = (ProcessDependDraw) obj;
			return this.hashCode() == o.hashCode();
		}

		return false;
	}

	@Override
	public int hashCode() {
		// 当存在数据日期时，表示流程实例，通过流程ID与数据日期标志唯一
		if (org.springframework.util.StringUtils.hasText(this.execDate)) {
			return (this.processId + "_" + this.depProcessId + "_" + this.execDate).hashCode();
		}
		// 具体流程，只有流程ID
		else {
			return this.processId.hashCode();
		}
	}
}
