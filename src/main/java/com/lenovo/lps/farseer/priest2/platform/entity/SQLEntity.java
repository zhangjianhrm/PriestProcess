package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author clive SQL解析对象
 */
public class SQLEntity {
	// select a,b,c 列表达式与列别名对照
	private Map<Object, String> selectItems;
	// insert into table
	private Object into;
	// from table or from subquery,如果是表，则为TableEntity,否则为SQLEntity
	private List<Object> fromItems = new LinkedList<Object>();
	private List<Object> joins;
	private Object where;
	private Object having;
	private Integer limit;

	private Object hints;

	private Object clusterBy;
	private Object sortBy;
	private Object distributeBy;
	private Object orderBy;
	private Object groupBy;

	public Map<Object, String> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(Map<Object, String> selectItems) {
		this.selectItems = selectItems;
	}

	public Object getInto() {
		return into;
	}

	public void setInto(Object into) {
		this.into = into;
	}

	public List<Object> getFromItems() {
		return fromItems;
	}

	public void setFromItems(List<Object> fromItems) {
		this.fromItems = fromItems;
	}

	public List<Object> getJoins() {
		return joins;
	}

	public void setJoins(List<Object> joins) {
		this.joins = joins;
	}

	public Object getWhere() {
		return where;
	}

	public void setWhere(Object where) {
		this.where = where;
	}

	public Object getClusterBy() {
		return clusterBy;
	}

	public void setClusterBy(Object clusterBy) {
		this.clusterBy = clusterBy;
	}

	public Object getSortBy() {
		return sortBy;
	}

	public void setSortBy(Object sortBy) {
		this.sortBy = sortBy;
	}

	public Object getDistributeBy() {
		return distributeBy;
	}

	public void setDistributeBy(Object distributeBy) {
		this.distributeBy = distributeBy;
	}

	public Object getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Object orderBy) {
		this.orderBy = orderBy;
	}

	public Object getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(Object groupBy) {
		this.groupBy = groupBy;
	}

	public Object getHaving() {
		return having;
	}

	public void setHaving(Object having) {
		this.having = having;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Object getHints() {
		return hints;
	}

	public void setHints(Object hints) {
		this.hints = hints;
	}

	// 新增 from
	public void addFromItem(Object fromItem) {
		this.fromItems.add(fromItem);
	}

	// 新增 from
	public void addFromItems(List<Object> fromItems) {
		this.fromItems.addAll(fromItems);
	}
}
