package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.Serializable;

/**
 * HIVE运行统计信息
 * 
 * @author niexm1
 * 
 */
public class HiveStat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1960675004430374677L;

	String tableName;// 表名
	String execDate;// 数据日期
	String startTime;// 开始时间
	String endTime;// 结束时间
	Long nFileSize;// 文件大小
	Long nRecords;// 记录数
	
	String appName;//应用名
	Integer processId;//流程ID
	Integer taskId;//任务ID
	
	String lastQueryTime;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getExecDate() {
		return execDate;
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

	public Long getnFileSize() {
		return nFileSize;
	}

	public void setnFileSize(Long nFileSize) {
		this.nFileSize = nFileSize;
	}

	public Long getnRecords() {
		return nRecords;
	}

	public void setnRecords(Long nRecords) {
		this.nRecords = nRecords;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
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

	public String getLastQueryTime() {
		return lastQueryTime;
	}

	public void setLastQueryTime(String lastQueryTime) {
		this.lastQueryTime = lastQueryTime;
	}
}
