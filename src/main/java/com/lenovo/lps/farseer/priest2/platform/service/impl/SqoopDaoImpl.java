package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.Select;
import com.lenovo.lps.farseer.priest2.platform.service.SqoopDao;
import com.lenovo.lps.farseer.priest2.platform.util.OracleSQLParserUtils;
import com.lenovo.lps.farseer.priest2.platform.util.SQLParserUtils;

public class SqoopDaoImpl implements SqoopDao {
	private static Logger logger = Logger.getLogger(SqoopDaoImpl.class);

	/**
	 * @see com.lenovo.lps.farseer.priest2.platform.service.SqoopDao#execute(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void execute(String sql, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException {
		Connection conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.execute();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} finally {
					conn.close();
				}
			}

		}
	}

	/**
	 * @see com.lenovo.lps.farseer.priest2.platform.service.SqoopDao#dropTmpTable(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void dropTmpTable(String tableName, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException {
		// drop table * ...
		String dropTmpTableSQL = "DROP TABLE " + tableName;

		Connection conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(dropTmpTableSQL);
			statement.execute();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} finally {
					conn.close();
				}
			}

		}

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

	/**
	 * @see com.lenovo.lps.farseer.priest2.platform.service.SqoopDao#getPrimaryKey(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String getPrimaryKey(String tableName, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException {
		Map<String, String> tableParameters = getTableParameters(tableName);

		Connection conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);

		ResultSet results = null;
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			results = metaData.getPrimaryKeys(null, tableParameters.get("tableSchema"), tableParameters.get("tableName"));
			if (results != null && results.next()) {
				return results.getString("COLUMN_NAME");
			} else {
				return null;
			}
		} finally {
			try {
				if (results != null) {
					results.close();
				}
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
		}
	}

	@Override
	public List<String> getTableColumnNames(String tableName, String dbUserName, String dbPassword, String connectionUrl,
			String driverClassName) throws SQLException {
		Map<String, String> tableParameters = getTableParameters(tableName);
		Connection conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);
		ResultSet results = null;
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			results = metaData.getColumns(null, tableParameters.get("tableSchema"), tableParameters.get("tableName"), null);
			List<String> columns = new ArrayList<String>();
			while (results.next()) {
				columns.add(results.getString("COLUMN_NAME"));
			}
			return columns;
		} finally {
			try {
				if (results != null) {
					results.close();
				}
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
		}
	}

	/**
	 * @param tableName
	 * @return
	 */
	private Map<String, String> getTableParameters(String tableName) {
		String tableSchema = null;
		String tableNameWithoutSchema = null;
		int pos = tableName.indexOf('.');
		if (pos > -1) {
			tableSchema = tableName.substring(0, pos).toUpperCase();
			tableNameWithoutSchema = tableName.substring(pos + 1);
		} else {
			tableNameWithoutSchema = tableName;
		}
		Map<String, String> tableParameters = new HashMap<String, String>();
		tableParameters.put("tableSchema", tableSchema);
		tableParameters.put("tableName", tableNameWithoutSchema);
		return tableParameters;
	}

	/**
	 * @see com.lenovo.lps.farseer.priest2.platform.service.SqoopDao#getColumnNames(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String[] getColumnNames(String selectSQL, String dbUserName, String dbPassword, String connectionUrl, String driverClassName) {
		String sql = null;
		if (driverClassName.toLowerCase().contains("mysql")) {
			sql = SQLParserUtils.buildGetMetaDataSql(selectSQL);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			sql = OracleSQLParserUtils.buildGetMetaDataSql(selectSQL);
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}

		Connection conn = null;
		ResultSet results = null;
		PreparedStatement statement = null;
		try {
			conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);

			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			return getColumns(results);
		} catch (SQLException e) {
			logger.error("Error SQL:select SQL=" +selectSQL+", column SQL=" + sql) ;
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		} finally {
			if (results != null) {
				try {
					results.close();
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
	}

	private String[] getColumns(ResultSet results) throws SQLException {
		int cols = results.getMetaData().getColumnCount();
		List<String> columns = new ArrayList<String>();
		ResultSetMetaData metadata = results.getMetaData();
		for (int i = 1; i < cols + 1; i++) {
			String colName = metadata.getColumnName(i);
			if (colName == null || colName.equals("")) {
				colName = metadata.getColumnLabel(i);
				if (null == colName) {
					colName = "_RESULT_" + i;
				}
			}
			columns.add(colName);
		}
		return columns.toArray(new String[0]);
	}

	/**
	 * 获取本次查询数据
	 * 
	 * @param selectSQL
	 * @return
	 */
	public Long countRecords(String selectSQL) throws SQLException {
		return countRecords(selectSQL, null, null, null, null);
	}

	/**
	 * 获取本次查询数据
	 * 
	 * @param selectSQL
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @return
	 * @throws SQLException
	 */
	public Long countRecords(String selectSQL, String dbUserName, String dbPassword, String connectionUrl, String driverClassName) {
		Long recordsCount = Long.valueOf(0L);

		String countSql = null;
		if (driverClassName.toLowerCase().contains("mysql")) {
			countSql = buildCountSql(selectSQL);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			countSql = buildCountSqlOfOracle(selectSQL);
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			conn = makeConnection(dbUserName, dbPassword, connectionUrl, driverClassName);

			statement = conn.prepareStatement(countSql);
			rs = statement.executeQuery();
			if (rs.next()) {
				recordsCount = rs.getLong(1);
			}
		} catch (SQLException e) {
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

		return recordsCount;

	}

	private String buildCountSql(String selectSQL) {
		String countSql;
		Select select = SQLParserUtils.parseSelectSQL(selectSQL);
		// select col1,col2 from table 模式, 转为select count(*) from table模式
		if (org.apache.commons.collections.CollectionUtils.isEmpty(select.getGroupByColumnReferences())) {
			countSql = SQLParserUtils.buildCountSql(selectSQL);
		}
		// select col1,col2 from table group by col1,col2模式,须在外面包一层,性能比较慢
		else {
			countSql = "select count(*) from ( " + selectSQL + " ) as tab";
		}
		return countSql;
	}

	private String buildCountSqlOfOracle(String selectSQL) {
		String countSql;
		Select select = OracleSQLParserUtils.parseSelectSQL(selectSQL);
		// select col1,col2 from table 模式, 转为select count(*) from table模式
		if (org.apache.commons.collections.CollectionUtils.isEmpty(select.getGroupByColumnReferences())) {
			countSql = OracleSQLParserUtils.buildCountSql(selectSQL);
		}
		// select col1,col2 from table group by col1,col2模式,须在外面包一层,性能比较慢
		else {
			countSql = "select count(*) from ( " + selectSQL + " ) as tab";
		}
		return countSql;
	}

}