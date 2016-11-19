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
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.service.OracleService;
import com.lenovo.lps.farseer.priest2.platform.util.LimittedColumnMapRowMapper;
import com.lenovo.lps.farseer.priest2.platform.util.OracleSQLParserUtils;

public class OracleServiceImpl implements OracleService {
	private static Logger logger = Logger.getLogger(OracleServiceImpl.class);

	@SuppressWarnings("incomplete-switch")
	@Override
	public Object executeSql(String sql, DbEntity dbArgs) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			conn = getConnection(dbArgs);
			statement = conn.prepareStatement(sql);

			SQLStatementEnum sqlType = OracleSQLParserUtils.getSQLType(sql);
			switch (sqlType) {
			// DDL
			case create:
			case alter:
			case drop:
				statement.execute();
				return true;
			// DML
			case update:
			case insert:
			case merge:
			case delete:
			case truncate:
				return statement.executeUpdate();
			case select:
				rs = statement.executeQuery();
				//RowMapper<Map<String, Object>> rowMapper = new ColumnMapRowMapper();
				long maxrow = WorkSession.get().getMaxResultRowCount() ;
				RowMapper<Map<String, Object>> rowMapper =  maxrow <=0 ? new ColumnMapRowMapper() : new LimittedColumnMapRowMapper(maxrow);
				
				ResultSetExtractor<List<Map<String, Object>>> extractor = new RowMapperResultSetExtractor<Map<String, Object>>(
						rowMapper);
				return extractor.extractData(rs);
			}

		} catch (SQLException e) {
			logger.error(e);
			throw new PriestPlatformException(e);
		} finally {
			clearResource(conn, statement, rs);
		}

		return null;
	}

	private Connection getConnection(DbEntity dbArgs) throws SQLException {
		try {
			Class.forName(dbArgs.getDriverClassName());
		} catch (ClassNotFoundException e) {
			throw new PriestPlatformException("Could not load oracle driver class", e);
		}

		return DriverManager.getConnection(dbArgs.getUrl(), dbArgs.getUserName(), dbArgs.getPassword());
	}

	private void clearResource(Connection conn, PreparedStatement statement, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
