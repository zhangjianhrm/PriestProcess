/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;


/**
 * @author hubin3
 * 
 */
public class NewDataStatByAppEntity extends RequestParam  {

	private String appName;
	private String tableName;
	private String execDate;
	private Integer processID;
	private Integer taskID;
	private String partition;
	private Long sizeNewData;
	private Long nrNewRecords;
	private Long tableSize;	
	private String lastModifyTime;
	private Integer retain;
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getProcessID() {
		return processID;
	}

	public void setProcessID(Integer processID) {
		this.processID = processID;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public Long getSizeNewData() {
		return sizeNewData;
	}

	public void setSizeNewData(Long sizeNewData) {
		this.sizeNewData = sizeNewData;
	}

	public Long getTableSize() {
		return tableSize;
	}

	public void setTableSize(Long tableSize) {
		this.tableSize = tableSize;
	}

	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public Long getNrNewRecords() {
		return nrNewRecords;
	}

	public void setNrNewRecords(Long nrNewRecords) {
		this.nrNewRecords = nrNewRecords;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getRetain() {
		return retain;
	}

	public void setRetain(Integer retain) {
		this.retain = retain;
	}

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

}
