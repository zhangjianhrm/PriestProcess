/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;

/**
 * Spark Sql操作
 * 
 * @author yujw
 * 
 */
public interface SparkJdbcService {
	// 默认数据库
	String DEFAULT_SCHEMA = "default";

	// 数据库与表名分隔符
	String SCHEMA_TABLE_SEPARATOR = ".";
	
	/**
	 * 执行查询SQL
	 * 
	 * @param sql
	 * @param hs2JdbcUrl
	 * @param statParam
	 * @return
	 */
	Object sparkExecute(String sql, StatParam statParam);
}
