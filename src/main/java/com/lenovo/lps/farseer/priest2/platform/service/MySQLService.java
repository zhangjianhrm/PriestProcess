/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.sql.SQLException;

/**
 * 执行sql
 * 
 * @author niexm1
 * 
 */
public interface MySQLService {
	/**
	 * 
	 * @param sql
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 */
	public Object runSql(String sql, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException;
}
