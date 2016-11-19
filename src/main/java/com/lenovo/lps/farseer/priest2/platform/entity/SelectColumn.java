package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * 查询列 select table.col as b 解析后,columnName :col alias b ;tableName: table
 * 
 * @author niexm1
 * 
 */
public class SelectColumn {
	private String columnName;
	private String alias;
	private String tableName;
	private String constantValue;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getConstantValue() {
		return constantValue;
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
