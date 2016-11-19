package com.lenovo.lps.farseer.priest2.platform.entity;

import org.drools.core.util.StringUtils;

public class Table implements FromItem {
	private String tableName;
	private String alias;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String getAlias() {
		return alias;
	}

	@Override
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString(){
		String table = tableName;
		if(!StringUtils.isEmpty(alias)){
			table += " " + alias;
		}
		return table;
	}
}
