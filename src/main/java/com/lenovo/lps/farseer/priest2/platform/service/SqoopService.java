package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;

public interface SqoopService {

	/**
	 * 从Mysql导入数据到HIVE
	 * 
	 * @param selectSql
	 * @param separator
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @param splitBy
	 * @param appUser
	 * @return
	 * @throws IOException
	 */
	public String importFromDatabase(String selectSql, String separator, String dbUserName, String dbPassword, String connectionUrl,
			String driverClassName, String splitBy, String processId, String execDate, String appUser) throws PriestPlatformException, InterruptedException, IOException, SQLException;

	/**
	 * 数据从HIVE导入到MYSQL中（分布式模式）
	 * 
	 * @param hiveSql
	 * @param mysqlTableName
	 * @param separator
	 * @param defaultFields
	 * @param dbConnectionEntity
	 * @param appUser
	 * @throws IOException
	 * @throws SQLException
	 */
	public void exportToDatabase(String hiveSql, String mysqlTableName, Map<String, Object> defaultFields,
			DbEntity dbConnectionEntity, String processId, String execDate, String appUser) throws PriestPlatformException, InterruptedException, IOException, SQLException;

	public void deleteFile(String fullFileName);

	/**
	 * 检查SQL合法性
	 * 
	 * @param selectSQL
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 * @throws SQLException
	 */
	public String checkSql(String selectSQL, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws PriestPlatformException, InterruptedException, SQLException, IOException;

	/**
	 * 数据直接导入HDFS指定路径
	 * 
	 * @param hiveTable
	 * @param separator
	 * @param connectionUrl
	 * @param dbTable
	 * @param dbUserName
	 * @param dbPassword
	 * @param driverClassName
	 * @param appUser
	 * @return
	 * @throws SQLException
	 */
	public String importDirect2Hdfs(String hiveTable, String separator, String connectionUrl, String dbTable, String dbUserName,
			String dbPassword, String driverClassName, String processId, String execDate, String appUser) throws PriestPlatformException, InterruptedException, IOException, SQLException;

	/**
	 * 數據直接導入Database
	 * 
	 * @param hivePath
	 * @param separator
	 * @param dbTable
	 * @param dbConnectionEntity
	 * @param appUser
	 */
	public void exportDirect2Database(String hivePath, String separator, String dbTable, DbEntity dbConnectionEntity,
			String processId, String execDate, String appUser) throws PriestPlatformException, InterruptedException, IOException, SQLException;
}
