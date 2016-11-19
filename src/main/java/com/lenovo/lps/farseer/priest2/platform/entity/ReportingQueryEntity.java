/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * @author hubin3
 *
 */
public class ReportingQueryEntity {
	private Integer id;
	private Integer appId;
	private String queryFlag;
	private String query;
	private String priestUser;
	private String startTime;
	private String updateTime;
	private String resultTable;
	private String queryState;
	private String message;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getQueryFlag() {
		return queryFlag;
	}
	public void setQueryFlag(String queryFlag) {
		this.queryFlag = queryFlag;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getPriestUser() {
		return priestUser;
	}
	public void setPriestUser(String priestUser) {
		this.priestUser = priestUser;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getResultTable() {
		return resultTable;
	}
	public void setResultTable(String resultTable) {
		this.resultTable = resultTable;
	}
	public String getQueryState() {
		return queryState;
	}
	public void setQueryState(String queryState) {
		this.queryState = queryState;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
