package com.lenovo.lps.farseer.priest2.platform.entity;

import org.apache.commons.lang.StringUtils;

public class SelectItem {
	private SelectItemEnum itemType;
	private String table;
	private String column;
	private String alias;
	
	public SelectItemEnum getItemType() {
		return itemType;
	}
	public void setItemType(SelectItemEnum itemType) {
		this.itemType = itemType;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		if(StringUtils.isNotEmpty(table)){
			sb.append(table + ".");
		}
		sb.append(column);
		if(StringUtils.isNotEmpty(alias)){
			sb.append(" " + alias);
		}
		
		return sb.toString();
	}
}
