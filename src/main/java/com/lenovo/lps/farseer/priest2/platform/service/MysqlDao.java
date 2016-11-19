package com.lenovo.lps.farseer.priest2.platform.service;

import java.sql.SQLException;

public interface MysqlDao {
	/**
	 * 在指定数据库中，使用指定SQL创建临时表
	 * 
	 * @param sql
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 * @throws SQLException
	 */
	public void execute(String sql, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException;

	/**
	 * drop临时表
	 * 
	 * @param tableName
	 * @param dbUserName
	 * @param dbPassword
	 * @param connStr
	 * @param driverClassName
	 * @throws SQLException
	 */
	public void dropTmpTable(String tableName, String dbUserName, String dbPassword, String connStr, String driverClassName)
			throws SQLException;

	/**
	 * 获取表的主键
	 * 
	 * @param tableName
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 * @throws SQLException
	 */
	public String getPrimaryKey(String tableName, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException;

	/**
	 * 获取select 列名
	 * 
	 * @param selectSQL
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 * @throws SQLException
	 */
	public String[] getColumnNames(String selectSQL, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException;

	/**
	 * 获取本次查询数据
	 * 
	 * @param selectSQL
	 * @return
	 */
	public Long countRecords(String selectSQL) throws SQLException;

	/**
	 * 获取本次查询数据
	 * 
	 * @param selectSQL
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 */
	public Long countRecords(String selectSQL, String dbUserName, String dbPassword, String connectionUrl, String driverClassName) throws SQLException;
}
