package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.SQLStatementEnum;
import com.lenovo.lps.farseer.priest2.platform.components.WorkSession;
import com.lenovo.lps.farseer.priest2.platform.service.MySQLService;
import com.lenovo.lps.farseer.priest2.platform.util.LimittedColumnMapRowMapper;
import com.lenovo.lps.farseer.priest2.platform.util.SQLParserUtils;

public class MySQLServiceImpl implements MySQLService {
	private static Logger logger = Logger.getLogger(MySQLServiceImpl.class);

	@Override
	public Object runSql(String sql, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException {
		return executeSql(sql, dbUserName, dbPassword, connectionUrl, driverClassName);
	}

	@SuppressWarnings("incomplete-switch")
	public Object executeSql(String sql, String dbUserName, String dbPassword, String connectionUrl, String driverClassName) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			SQLStatementEnum sqlType = SQLParserUtils.getSQLType(sql);

			conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);

			statement = conn.prepareStatement(sql);

			switch (sqlType) {
			// ddl
			case alter:
			case create:
			case drop:
				// 返回值为false
				statement.execute();
				// 由于上面语句成功执行create,drop返回值都为false，在此返回true
				return true;
				// dml insert/update/replace/delete/truncate
			case insert:
			case update:
			case replace:
			case delete:
			case truncate:
				return statement.executeUpdate();

				// dml select
			case select:
				rs = statement.executeQuery();
				long maxrow = WorkSession.get().getMaxResultRowCount() ;
				RowMapper<Map<String, Object>> rowMapper =  maxrow <=0 ? new ColumnMapRowMapper() : new LimittedColumnMapRowMapper(maxrow);
				ResultSetExtractor<List<Map<String, Object>>> extractor = new RowMapperResultSetExtractor<Map<String, Object>>(
						rowMapper);

				return extractor.extractData(rs);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}

		return null;
	}

	/**
	 * 获取指定连接
	 * 
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 * @throws SQLException
	 */
	private Connection makeConnection(String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException cnfe) {
			throw new PriestPlatformException("Could not load mysql driver class: ", cnfe);
		}

		return DriverManager.getConnection(connectionUrl, dbUserName, dbPassword);
	}
}
