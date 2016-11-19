package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class Select {
	private List<String> selectOptions;
	private List<SelectItem> selectItems;
	private List<FromItem> fromItems;
	private List<Join> joins;
	private String where;
	private List<String> groupByColumnReferences;
	private String having;
	private List<String> orderBys;
	
	/**
	 * table列表，用于分析表名，列所属表等
	 */
	private List<Table> tableList;

	public List<String> getSelectOptions() {
		return selectOptions;
	}

	public void setSelectOptions(List<String> selectOptions) {
		this.selectOptions = selectOptions;
	}

	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

	public List<FromItem> getFromItems() {
		return fromItems;
	}
	
	public String getFromItem(){
		FromItem item = fromItems.get(0);
		if(item instanceof Table){
			Table table = (Table)item;
			return table.getTableName();
		}
	
		return item.getAlias();
	}

	public void setFromItems(List<FromItem> fromItems) {
		this.fromItems = fromItems;
	}

	public List<Join> getJoins() {
		return joins;
	}

	public void setJoins(List<Join> joins) {
		this.joins = joins;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public List<String> getGroupByColumnReferences() {
		return groupByColumnReferences;
	}

	public void setGroupByColumnReferences(List<String> groupByColumnReferences) {
		this.groupByColumnReferences = groupByColumnReferences;
	}

	public String getHaving() {
		return having;
	}

	public void setHaving(String having) {
		this.having = having;
	}

	public List<String> getOrderBys() {
		return orderBys;
	}

	public void setOrderBys(List<String> orderBys) {
		this.orderBys = orderBys;
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SELECT ");

		if (CollectionUtils.isNotEmpty(selectOptions)) {
			for (String opt : selectOptions) {
				sb.append(opt + " ");
			}
		}

		if (CollectionUtils.isNotEmpty(selectItems)) {
			for (SelectItem item : selectItems) {
				sb.append(item.toString() + ", ");
			}
			sb.replace(sb.lastIndexOf(","), sb.length(), " ");
		}

		if (CollectionUtils.isNotEmpty(fromItems)) {
			sb.append("FROM ");
			for(FromItem item : fromItems){
				sb.append(item.toString() + ", ");
			}
			sb.replace(sb.lastIndexOf(","), sb.length(), " ");
		}
		
		addConditions(sb);

		return sb.toString().trim();
	}

	private void addConditions(StringBuilder sb) {
		if(CollectionUtils.isNotEmpty(joins)){
			for(Join join : joins){
				sb.append(join.toString());
			}
		}

		if (StringUtils.isNotEmpty(where)) {
			sb.append("WHERE ");
			sb.append(where + " ");
		}

		if (CollectionUtils.isNotEmpty(groupByColumnReferences)) {
			sb.append("GROUP BY ");
			for (String groupBy : groupByColumnReferences) {
				sb.append(groupBy + ", ");
			}
			sb.replace(sb.lastIndexOf(","), sb.length(), " ");
		}

		if (StringUtils.isNotEmpty(having)) {
			sb.append("HAVING ");
			sb.append(having + " ");
		}

		if (CollectionUtils.isNotEmpty(orderBys)) {
			sb.append("ORDER BY ");
			for (String orderBy : orderBys) {
				sb.append(orderBy + ", ");
			}
			sb.replace(sb.lastIndexOf(","), sb.length(), " ");
		}
	}
}
