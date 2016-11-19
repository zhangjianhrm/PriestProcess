package com.lenovo.lps.farseer.priest2.platform.entity;

import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class TableProfileEntity extends RequestParam{
	private String appName;
	private int tableNum;
	private long spaceSize;
	
	private String execDate;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public String getSpaceSize() {
		return StringUtil.convertBytesToDisplaySize(spaceSize);
	}
	public void setSpaceSize(long spaceSize) {
		this.spaceSize = spaceSize;
	}
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	
}
