package com.lenovo.lps.farseer.priest2.platform.entity;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;

public class TableSize {
	private String dbName;
	
	private String tblName;
	
	private long initSize;
	
	private long addSize;
	
	private long lastSize;
	
	private String p_event_date;
	
	private String owner;
	
	private String insertProes;
	
	private String selectProes;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTblName() {
		return CommUtils.isNotNull(tblName) ? tblName:"全部表";
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}

	public long getInitSize() {
		return initSize;
	}

	public void setInitSize(long initSize) {
		this.initSize = initSize;
	}

	public long getAddSize() {
		return addSize;
	}

	public void setAddSize(long addSize) {
		this.addSize = addSize;
	}

	public long getLastSize() {
		return lastSize;
	}

	public void setLastSize(long lastSize) {
		this.lastSize = lastSize;
	}

	public String getP_event_date() {
		return p_event_date;
	}

	public void setP_event_date(String p_event_date) {
		this.p_event_date = p_event_date;
	}

	public String getOwner() {
		return CommUtils.isNotNull(owner) ? owner:"全部应用";
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getInsertProes() {
		return insertProes;
	}

	public void setInsertProes(String insertProes) {
		this.insertProes = insertProes;
	}

	public String getSelectProes() {
		return selectProes;
	}

	public void setSelectProes(String selectProes) {
		this.selectProes = selectProes;
	}
	
}
