package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hive.ql.parse.ASTNode;

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
public class HiveQueryEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4264089561677920084L;

	// 别名
	private String aliasName;

	// from src
	private Object from;
	// inserts
	private List<HiveInsertClause> insertClauses = new LinkedList<HiveInsertClause>();

	private Map<ASTNode, HiveInsertClause> sourceToInsertClauseMap = new HashMap<ASTNode, HiveInsertClause>();

	public Object getFrom() {
		return from;
	}

	public void setFrom(Object from) {
		this.from = from;
	}

	public List<HiveInsertClause> getInsertClauses() {
		return insertClauses;
	}

	public void setInsertClauses(List<HiveInsertClause> insertClauses) {
		this.insertClauses = insertClauses;
	}

	public void setInsertClause(HiveInsertClause insertClause) {
		this.insertClauses.add(insertClause);
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public Map<ASTNode, HiveInsertClause> getSourceToInsertClauseMap() {
		return sourceToInsertClauseMap;
	}

	public void setSourceToInsertClauseMap(Map<ASTNode, HiveInsertClause> sourceToInsertClauseMap) {
		this.sourceToInsertClauseMap = sourceToInsertClauseMap;
	}

	public HiveInsertClause getInsertClause(ASTNode insertNode) {
		return this.sourceToInsertClauseMap.get(insertNode);
	}

	public void putInsertClause(ASTNode insertNode, HiveInsertClause insertClause) {
		this.sourceToInsertClauseMap.put(insertNode, insertClause);
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
