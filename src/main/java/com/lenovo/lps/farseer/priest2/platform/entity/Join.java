package com.lenovo.lps.farseer.priest2.platform.entity;

import org.drools.core.util.StringUtils;

public class Join {
	private String qualifier;
	private FromItem rightItem;
	private String onExpression;

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public FromItem getRightItem() {
		return rightItem;
	}

	public void setRightItem(FromItem rightItem) {
		this.rightItem = rightItem;
	}

	public String getOnExpression() {
		return onExpression;
	}

	public void setOnExpression(String onExpression) {
		this.onExpression = onExpression;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (!StringUtils.isEmpty(qualifier)) {
			sb.append(qualifier + " ");
		}
		sb.append("JOIN ");
		sb.append(rightItem.toString() + " ");
		if (!StringUtils.isEmpty(onExpression)) {
			sb.append("ON " + onExpression + " ");
		}

		return sb.toString();
	}
}
