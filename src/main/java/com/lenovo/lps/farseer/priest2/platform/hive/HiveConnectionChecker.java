package com.lenovo.lps.farseer.priest2.platform.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.InitializingBean;

public class HiveConnectionChecker implements InitializingBean {

	private String driverClass;
	private String jdbcUrl;

	@Override
	public void afterPropertiesSet() throws Exception {
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(jdbcUrl);
		Statement statement = null;
		try {
			statement = connection.createStatement();
			/**
			 * 只运行一条测试SQL modified by niexiaoming 2012/08/10
			 */
			statement.execute("show databases like 'default'");
		} 
		finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
}
