package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;

/**
 * Hive 查询sql 结构如下:
 * 
 * <pre>
 * FROM SRC
 * insert 1
 * insert 2
 * ...
 * insert n
 * ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
 * SRC:
 * table,子查询，union,join,laterview等
 * ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
 * insert :
 *  目的地1
 * select expressions(select 表达式),
 * group by
 * sort by 
 * distribute by
 * cluster by
 * insert 目的地2
 * select expressions(select 表达式),
 * group by
 * sort by 
 * distribute by
 * cluster by
 * ＝＝＝＝＝＝＝＝
 * ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
 * </pre>
 * 
 * @author clive
 * 
 */
public class HiveInsertClause implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7096631898795885818L;

	private HiveDestinationEntity dest;
	Map<String, String> selectColumnAliasMap = new HashMap<String, String>();

	private String where;
	private String having;
	private Integer limit;

	private String hints;

	private String clusterBy;
	private String sortBy;
	private String distributeBy;
	private String orderBy;
	private String groupBy;

	private String insertInto;

	public HiveDestinationEntity getDest() {
		return dest;
	}

	public void setDest(HiveDestinationEntity dest) {
		this.dest = dest;
	}

	public Map<String, String> getSelectColumnAliasMap() {
		return selectColumnAliasMap;
	}

	public void setSelectColumnAliasMap(Map<String, String> selectColumnAliasMap) {
		this.selectColumnAliasMap = selectColumnAliasMap;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getHaving() {
		return having;
	}

	public void setHaving(String having) {
		this.having = having;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getHints() {
		return hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}

	public String getClusterBy() {
		return clusterBy;
	}

	public void setClusterBy(String clusterBy) {
		this.clusterBy = clusterBy;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getDistributeBy() {
		return distributeBy;
	}

	public void setDistributeBy(String distributeBy) {
		this.distributeBy = distributeBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getInsertInto() {
		return insertInto;
	}

	public void setInsertInto(String insertInto) {
		this.insertInto = insertInto;
	}

	@Override
	public String toString() {
		try {
			ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(byteOutStream);

			os.writeObject(this);
			os.flush();

			return new String(byteOutStream.toByteArray(), "UTF-8");
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

	}

}
