package com.lenovo.lps.farseer.priest2.platform.entity;

import org.drools.core.util.StringUtils;

public class SubQuery implements FromItem {
	private Select subSelect;
	private String alias;

	public Select getSubSelect() {
		return subSelect;
	}

	public void setSubSelect(Select subSelect) {
		this.subSelect = subSelect;
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
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(subSelect.toString());
		sb.append(")");
		if(!StringUtils.isEmpty(alias)){
			sb.append(" " + alias);
		}
		
		return sb.toString();
		
	}
}
