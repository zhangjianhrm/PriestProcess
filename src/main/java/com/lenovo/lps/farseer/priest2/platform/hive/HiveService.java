/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.hive;

import java.sql.SQLException;
import java.util.List;

import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;

/**
 * Hive操作
 * 
 * @author niexm1
 * 
 */
public interface HiveService {

	// 数据库与表名分隔符
	String SCHEMA_TABLE_SEPARATOR = ".";

	/**
	 * 获取表在HDFS路径
	 * 
	 * @param tableName
	 * @return
	 */
	String getStorageLocation(String tableName);

	/**
	 * 获取字段间隔符
	 * 
	 * @param schema
	 * @param tableName
	 * @return
	 */
	String getFieldsTerminatedBy(String schema, String tableName);

	/**
	 * 获取字段间隔符
	 * 
	 * @param schema
	 * @param tableName
	 * @return
	 */
	String getFieldsTerminatedBy(String tableName);

	/**
	 * 获取表字段名
	 * 
	 * @param tableName
	 * @return
	 */
	List<String> getColumns(String tableName);

	/**
	 * 执行非查询sql
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	boolean transferExecute(String sql, String appUser);
	
	/**
	 * 执行查询SQL
	 * 
	 * @param sql
	 * @param appUser
	 * @param statParam
	 * @return
	 */
	Object hiveExecute(String sql, StatParam statParam);

	/**
	 * 执行 查询类hive sql
	 * 
	 * @param <T>
	 * @param sql
	 * @param rse
	 * @param appUser
	 * @return
	 */
	<T> T reportQuery(String sql, String appUser);
}
