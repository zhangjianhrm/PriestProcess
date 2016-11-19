package com.lenovo.lps.farseer.priest2.platform.entity;

public class HiveTableDegreeEntity {
	private int app_id ;
	private String appName ;
	private String tableName;
	private Integer inDegree;
	private Integer outDegree;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getInDegree() {
		return inDegree == null ? 0 : inDegree;
	}

	public void setInDegree(Integer inDegree) {
		this.inDegree = inDegree;
	}

	public Integer getOutDegree() {
		return outDegree == null ? 0 : outDegree;
	}

	public void setOutDegree(Integer outDegree) {
		this.outDegree = outDegree;
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}	
	
}
