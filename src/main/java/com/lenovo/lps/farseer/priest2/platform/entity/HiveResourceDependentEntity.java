/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * @author hubin3
 * 
 */
public class HiveResourceDependentEntity {

	private Integer id;
	private String fromTable;
	private String insertTable;
	private Integer taskId;
	private Integer processId;
	private Integer appId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromTable() {
		return fromTable;
	}

	public void setFromTable(String fromTable) {
		this.fromTable = fromTable;
	}

	public String getInsertTable() {
		return insertTable;
	}

	public void setInsertTable(String insertTable) {
		this.insertTable = insertTable;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof HiveResourceDependentEntity) {
			HiveResourceDependentEntity o = (HiveResourceDependentEntity) obj;
			return this.hashCode() == o.hashCode();
		}

		return false;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

}
