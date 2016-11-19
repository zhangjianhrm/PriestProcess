package com.lenovo.lps.farseer.priest2.platform.entity;

public class HiveTableUsageEntity {
	
	private String appName ;
	private String tableName;
	private Integer inDegree;
	private Integer outDegree;
	private String execDate;
	private Integer processID;
	private Integer taskID;
	private Long tableSize;	
	private String lastModifyTime;
	private String lastQueryTime;
	
	public HiveTableUsageEntity(HiveTableDegreeEntity e) {
		merge(e);
	}

	public HiveTableUsageEntity(NewDataStatEntity e) {
		merge(e);
	}

	public void merge(NewDataStatEntity e) {
		if ( e != null ) {
			if ( this.appName == null ) appName = e.getAppName() ;
			if( this.tableName == null ) tableName = e.getTableName() ;
			execDate = e.getExecDate() ;
			processID = e.getProcessID() ;
			taskID = e.getTaskID() ;
			tableSize = e.getTableSize();
			lastModifyTime = e.getLastModifyTime() ;
			lastQueryTime = e.getLastQueryTime() ;
		}		
	}

	public void merge(HiveTableDegreeEntity e) {
		if ( e != null ) {
			if ( this.appName == null ) appName = e.getAppName(); 
			if ( this.tableName == null ) tableName = e.getTableName() ;
			inDegree = e.getInDegree() ;
			outDegree = e.getOutDegree() ;
		}
	}

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

	public Integer getInDegree() {
		return inDegree;
	}

	public void setInDegree(Integer inDegree) {
		this.inDegree = inDegree;
	}

	public Integer getOutDegree() {
		return outDegree;
	}

	public void setOutDegree(Integer outDegree) {
		this.outDegree = outDegree;
	}

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
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

	public Long getTableSize() {
		return tableSize;
	}

	public void setTableSize(Long tableSize) {
		this.tableSize = tableSize;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastQueryTime() {
		return lastQueryTime;
	}

	public void setLastQueryTime(String lastQueryTime) {
		this.lastQueryTime = lastQueryTime;
	}
	
}
