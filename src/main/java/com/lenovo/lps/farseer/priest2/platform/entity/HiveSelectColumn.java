package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.Serializable;

public class HiveSelectColumn implements Serializable {
	private static final long serialVersionUID = 2888138315426565517L;

	private String alias;
	private String columnName;
	private String tableName;
	private String constantValue;
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}
	public boolean isConstant() {
		boolean tag = false;
		if (constantValue != null) {
			tag = true;
		}
		return tag;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("tableName:");
		buffer.append(tableName);
		buffer.append(",columnName:");
		buffer.append(columnName);
		buffer.append(",alias:");
		buffer.append(alias);
		buffer.append(",constantValue:");
		buffer.append(constantValue);
		buffer.append(",isConstant:");
		buffer.append(isConstant());
		return buffer.toString();
	}
}
