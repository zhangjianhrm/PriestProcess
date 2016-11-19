package com.lenovo.lps.farseer.priest2.platform.entity;


public class HiveSqlStatEntity extends RequestParam {
	private String sql;
	private float cpuTotal;
	private int jobTotal;
	private int mapsTotal;
	private int reducesTotal;
	private long hdfsReads;
	private long hdfsWrites;
	private String detail;
	private String endTime;
	private String execDate;
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getCpuTotal() {
		return cpuTotal + " ms";
	}
	public void setCpuTotal(float cpuTotal) {
		this.cpuTotal = cpuTotal;
	}
	public int getJobTotal() {
		return jobTotal;
	}
	public void setJobTotal(int jobTotal) {
		this.jobTotal = jobTotal;
	}
	public int getMapsTotal() {
		return mapsTotal;
	}
	public void setMapsTotal(int mapsTotal) {
		this.mapsTotal = mapsTotal;
	}
	public int getReducesTotal() {
		return reducesTotal;
	}
	public void setReducesTotal(int reducesTotal) {
		this.reducesTotal = reducesTotal;
	}
	public long getHdfsReads() {
		return hdfsReads;
	}
	public void setHdfsReads(long hdfsReads) {
		this.hdfsReads = hdfsReads;
	}
	public long getHdfsWrites() {
		return hdfsWrites;
	}
	public void setHdfsWrites(long hdfsWrites) {
		this.hdfsWrites = hdfsWrites;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
}
