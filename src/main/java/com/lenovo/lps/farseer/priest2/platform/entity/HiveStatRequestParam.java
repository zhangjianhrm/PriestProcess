package com.lenovo.lps.farseer.priest2.platform.entity;

public class HiveStatRequestParam extends RequestParam {
	/**
	 * 查询模式：0-按数据日期查询； 1-按未被查询天数查询
	 */
	private int queryMode;
	
	private String appName ;
	private String tableName ;	
	private String execDate;
	private Integer nonQueryDays;
	
	public int getQueryMode() {
		return queryMode;
	}
	public void setQueryMode(int queryMode) {
		this.queryMode = queryMode;
	}
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public Integer getNonQueryDays() {
		return nonQueryDays;
	}
	public void setNonQueryDays(Integer nonQueryDays) {
		this.nonQueryDays = nonQueryDays;
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
	
	
}
