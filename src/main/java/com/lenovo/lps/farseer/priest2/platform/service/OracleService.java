package com.lenovo.lps.farseer.priest2.platform.service;

import java.sql.SQLException;

import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;

public interface OracleService {

	/**
	 * 执行oracle语句
	 * 
	 * @param sql
	 * @param dbArgs
	 * @return
	 * @throws SQLException
	 */
	Object executeSql(String sql, DbEntity dbArgs);
}
