/**
 * © 2011 Lenovo. All rights reserved
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * The Interface HiveDao.
 */
public interface HiveMetaDao {

	/**
	 * 查询表结构
	 * 
	 * @param schema
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> descTable(String schema, String tableName) throws SQLException, IOException;

	/**
	 * 获取字段间隔符
	 * 
	 * @param schema
	 * @param tableName
	 * @return
	 */
	String getFieldsTerminatedBy(String schema, String tableName) throws SQLException, IOException;

	/**
	 * 获取HDFS存储路径
	 * 
	 * @param schema
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	String getStorageLocation(String schema, String tableName) throws SQLException, IOException;
}
