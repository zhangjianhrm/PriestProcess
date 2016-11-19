/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;

/**
 * @author hubin3
 * 
 */
public class NewDataStatEntity extends RequestParam implements Serializable, Comparable<NewDataStatEntity> {

	private static final long serialVersionUID = -7469218514130829200L;
	private Integer id;
	private String tableName;
	private String execDate;
	private String partition;
	private String startTime;
	private String endTime;
	private String durationNewDate;
	private Long nrNewRecords;
	private Long sizeNewData;
	private String statMode;
	
	private String appName;
	private Integer processID;
	private Integer taskID;
	private Long tableSize;
	private String lastModifyTime;
	
	private String lastQueryTime;

	protected Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
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

	public String getDurationNewDate() {
		return durationNewDate;
	}

	public void setDurationNewDate(String durationNewDate) {
		this.durationNewDate = durationNewDate;
	}

	public Long getNrNewRecords() {
		return nrNewRecords;
	}

	public void setNrNewRecords(Long nrNewRecords) {
		this.nrNewRecords = nrNewRecords;
	}

	public Long getSizeNewData() {
		return sizeNewData;
	}

	public void setSizeNewData(Long sizeNewData) {
		this.sizeNewData = sizeNewData;
	}

	public String getStatMode() {
		return statMode;
	}

	public void setStatMode(String statMode) {
		this.statMode = statMode;
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof NewDataStatEntity) {
			NewDataStatEntity o = (NewDataStatEntity) obj;
			return this.hashCode() == o.hashCode();
		}

		return false;
	}

	@Override
	public int hashCode() {
		return (this.tableName + "_" + this.execDate).hashCode();
	}

	@Override
	public int compareTo(NewDataStatEntity anotherNewDataStatEntity) {
		String anotherTableName = anotherNewDataStatEntity.getTableName();
		String thisTableName = this.getTableName();
		if (!thisTableName.equals(anotherTableName)) {
			return thisTableName.compareTo(anotherTableName);
		} else {
			Date thisExecDate;
			Date anotherExecDate;
			try {
				thisExecDate = DateUtils.parseString2Date(this.getExecDate(), DateUtils.getDateDayFormat());
				anotherExecDate = DateUtils.parseString2Date(anotherNewDataStatEntity.getExecDate(), DateUtils.getDateDayFormat());
			} catch (ParseException e) {
				throw new PriestPlatformException(e);
			}
			return thisExecDate.compareTo(anotherExecDate);
		}
	}

}
