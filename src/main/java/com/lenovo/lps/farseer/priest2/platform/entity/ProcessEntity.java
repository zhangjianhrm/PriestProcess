package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.lenovo.lps.farseer.priest2.platform.util.JsonStringDateSerializer;

public class ProcessEntity extends RequestParam implements Serializable {

	private static final long serialVersionUID = -229746751778402438L;

	private Integer processId;// 流程id
	private String processName;// 流程名称
	private String processDesc;// 流程描述
	private String validDate;// 流程有效期
	private String processPriority;// 流程优先级
	private String processApp;// 流程所属应用
	private String scheduleType;// 调度类型 O:只运行一次D:每日运行W:每周运行M:每月运行Q:每季运行Y:每年运行
	private String scheduleDate;// 调度日期
	private String scheduleTime;// 调度时间
	private String latestScheduleTime;// 最晚调度时间
	private String alarmType;// 失败告警方式N:不告警E:邮件告警S:短信告警
	private String alarmTarget;// 告警对象
	private String bpmnDef;// 流程的BPMN定义
	private String jsonDef;// 流程的JSON定义,用于页面展现
	private String createdBy;// 创建人
	private String createdDate;// 创建时间
	private String updatedBy;// 更新人
	private String updatedDate;// 更新时间
	private String processState;// 流程状态:N正常,D禁止,I待审核,R审核不通过
	private String investigationResult;//流程审核结果备注
	private String processType;// 流程类型:H:补跑流程N:正常流程

	private String execDate;
	private String startTime;
	private String endTime;
	private Integer runTime;//运行时长
	private String message;
	private int remedyTimes;

	private List<ProcessDependentEntity> deps = new ArrayList<ProcessDependentEntity>();
	private Integer depProcessId;// 依赖流程ID
	private String depExecDate;// 依赖流程执行日期

	// 流程状态
	private String processStatus;// 流程执行状态:W:等待执行R:正在执行S:成功执行F:失败执行P:暂停执行C:取消执行H:等待补跑

	// 流程变量 ${a}=1 换行 ${b}=2
	private String processVariables;
	
	// 应用变量，格式同流程变量
	private String appVariables;

	// 前端查询条件:创建时间段
	private String createdDateStart;
	private String createdDateEnd;

	// 流程失败重试或者流程重新运行
	private boolean isRetry = false;
	
	// 补跑流程使用，标志是否已经补跑过
	private boolean isScheduled = false;

	public ProcessEntity(ProcessDependDraw pdd) {
		super();
		this.processId = pdd.getProcessId();
		this.processName = pdd.getProcessName();
		this.processApp = pdd.getProcessApp();
		this.scheduleType = pdd.getScheduleType();
		this.scheduleDate = pdd.getScheduleDate();
		this.processState = pdd.getProcessState();
		this.execDate = pdd.getExecDate();
		this.depProcessId = pdd.getDepProcessId();
		this.processStatus = pdd.getProcessStatus();
	}

	public ProcessEntity() {
		super();
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public List<ProcessDependentEntity> getDeps() {
		return deps;
	}

	public void setDeps(List<ProcessDependentEntity> deps) {
		this.deps = deps;
	}

	public void setDep(ProcessDependentEntity dep) {
		this.deps.add(dep);
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessDesc() {
		return processDesc;
	}

	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getProcessPriority() {
		return processPriority;
	}

	public void setProcessPriority(String processPriority) {
		this.processPriority = processPriority;
	}

	public String getProcessApp() {
		return processApp;
	}

	public void setProcessApp(String processApp) {
		this.processApp = processApp;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
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

	public String getLatestScheduleTime() {
		return latestScheduleTime;
	}

	public void setLatestScheduleTime(String latestScheduleTime) {
		this.latestScheduleTime = latestScheduleTime;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getAlarmTarget() {
		return alarmTarget;
	}

	public void setAlarmTarget(String alarmTarget) {
		this.alarmTarget = alarmTarget;
	}

	public String getBpmnDef() {
		return bpmnDef;
	}

	public void setBpmnDef(String bpmnDef) {
		this.bpmnDef = bpmnDef;
	}

	public String getJsonDef() {
		return jsonDef;
	}

	public void setJsonDef(String jsonDef) {
		this.jsonDef = jsonDef;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonSerialize(using = JsonStringDateSerializer.class)
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@JsonSerialize(using = JsonStringDateSerializer.class)
	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getProcessState() {
		return processState;
	}
	
	public String getInvestigationResult() {
		return investigationResult;
	}
	
	public void setInvestigationResult(String investigationResult) {
		this.investigationResult = investigationResult;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getExecDate() {
		return execDate == null ? "":execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 获取运行时长的毫秒数
	 * @return milliseconds
	 */
	public Integer getIntRunTime(){
		return (runTime != null ? runTime * 1000 : 0);
	}

	public String getRunTime() {
		return (runTime != null ? formatRunTime(runTime) : "");
	}

	public void setRunTime(Integer runTime) {
		this.runTime = runTime;
	}

	public String getMessage() {
		return message == null ? "":message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRemedyTimes() {
		return remedyTimes;
	}

	public void setRemedyTimes(int remedyTimes) {
		this.remedyTimes = remedyTimes;
	}

	public Integer getDepProcessId() {
		return depProcessId;
	}

	public void setDepProcessId(Integer depProcessId) {
		this.depProcessId = depProcessId;
	}

	public String getProcessVariables() {
		return processVariables;
	}

	public void setProcessVariables(String processVariables) {
		this.processVariables = processVariables;
	}
	
	public String getAppVariables() {
		return appVariables;
	}

	public void setAppVariables(String appVariables) {
		this.appVariables = appVariables;
	}

	public String getDepExecDate() {
		return depExecDate;
	}

	public void setDepExecDate(String depExecDate) {
		this.depExecDate = depExecDate;
	}

	public String getCreatedDateStart() {
		return createdDateStart;
	}

	public void setCreatedDateStart(String createdDateStart) {
		this.createdDateStart = createdDateStart;
	}

	public String getCreatedDateEnd() {
		return createdDateEnd;
	}

	public void setCreatedDateEnd(String createdDateEnd) {
		this.createdDateEnd = createdDateEnd;
	}

	public boolean isRetry() {
		return isRetry;
	}

	public void setRetry(boolean isRetry) {
		this.isRetry = isRetry;
	}

	public boolean isScheduled() {
		return isScheduled;
	}

	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof ProcessEntity) {
			ProcessEntity o = (ProcessEntity) obj;
			return this.hashCode() == o.hashCode();
		}

		return false;
	}

	@Override
	public int hashCode() {
		// 当存在数据日期时，表示流程实例，通过流程ID与数据日期标志唯一
		if (org.springframework.util.StringUtils.hasText(this.execDate)) {
			return (this.processId + "_" + this.execDate).hashCode();
		}
		// 具体流程，只有流程ID
		else {
			return this.processId.hashCode();
		}
	}
	
	/**
	 * 格式化运行时间
	 * 
	 * @param runTime 运行时间（单位为秒）
	 * @return 格式化后的运行时间字符串
	 */
	public static String formatRunTime(int runTime) {
		int hours = runTime / 3600;
		int minutes = (runTime - hours * 3600) / 60;
		int seconds = runTime - hours * 3600 - minutes * 60;

		StringBuilder sb = new StringBuilder();
		sb.append(StringUtils.leftPad(Integer.toString(hours), 2, '0') + ":");
		sb.append(StringUtils.leftPad(Integer.toString(minutes), 2, '0') + ":");
		sb.append(StringUtils.leftPad(Integer.toString(seconds), 2, '0'));

		return sb.toString();
	}
}
