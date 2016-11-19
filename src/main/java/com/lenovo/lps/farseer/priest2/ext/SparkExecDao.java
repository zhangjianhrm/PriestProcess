package com.lenovo.lps.farseer.priest2.ext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.components.WorkSession;
import com.lenovo.lps.farseer.priest2.platform.dal.impl.ApplicationDaoImpl;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveOperationEnum;
import com.lenovo.lps.farseer.priest2.platform.util.HiveSqlParserUtil;
import com.lenovo.lps.farseer.priest2.platform.util.LimittedColumnMapRowMapper;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class SparkExecDao {
	private static final Logger logger = Logger.getLogger(SparkExecDao.class);
	
	/** 获取HiveServer2连接失败后的重试次数 */
	private static final int CONN_RETRY_TIMES = 6;
	private static final String MULTI_SQL_SEPARATOR = ";";
	
	/**
	 * 获取连接
	 * 
	 * @param jdbcUrl
	 * @param driverName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection getConnection(String appUser, int priority) throws ClassNotFoundException {
		Connection conn = null;
		if (ApplicationDaoImpl.sparkConfigs.get(priority) == null) {
			priority = 1;
		}
		if (ApplicationDaoImpl.sparkConfigs.get(priority) == null) {
			throw new PriestPlatformException("spark db is null, please contact administrator, thanks!");
		}
		try {
			Class.forName(ApplicationDaoImpl.sparkConfigs.get(priority).getTarget());
			if (!"kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase())) {
				appUser = "";
			} else {
				if (!ApplicationDaoImpl.sparkConfigs.get(priority).getUrl().endsWith("hive.server2.proxy.user=")) {
					throw new PriestPlatformException("hive url must be end with 'hive.server2.proxy.user='!");
				}
			}
			conn = DriverManager.getConnection(ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser);
			AuditLog.log("Connect the first spark jdbcUrl :" +  ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser);
		} catch (Exception e) {
			// 如果异常原因是GSS initiate failed，则重试CONN_RETRY_TIMES次连接
			conn = retryGetConnection(appUser, e.getMessage(), 1, priority);
		}
		if (conn == null) {
			throw new RuntimeException(String.format("spark get connection error, jdbcUrl[%s]", ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser));
		}
		return conn;
	}

	/**
	 * 重试获取spark jdbc连接, 最多获取CONN_RETRY_TIMES次
	 * 
	 * @param jdbcUrl
	 * @param msg
	 * @param retryTimes
	 *            重试次数
	 * @return
	 */
	private Connection retryGetConnection(String appUser, String msg, int retryTimes, int priority) {
		// 最多重试5次
		if (retryTimes > CONN_RETRY_TIMES) {
			return null;
		}
		Connection conn = null;
		if (StringUtils.isNotEmpty(msg) && msg.contains("GSS initiate failed")) {
			// 每次重试sleep秒数翻倍
			try {
				TimeUnit.SECONDS.sleep(retryTimes * 5);
			} catch (InterruptedException iptExp) {
				// sleep 中断继续执行
			}

			logger.warn("Start getting connection to " + ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser + " for the " + retryTimes + " time!");
			try {
				if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase()) && !ApplicationDaoImpl.sparkConfigs.get(priority).getUrl().endsWith("hive.server2.proxy.user=")) {
					throw new PriestPlatformException("hive url must be end with 'hive.server2.proxy.user='!");
				}
				conn = DriverManager.getConnection(ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser);
			} catch (SQLException sqlExp) {
				conn = retryGetConnection(appUser, sqlExp.getMessage(), retryTimes + 1, priority);
			}
		} else {
			priority++;
			if (ApplicationDaoImpl.sparkConfigs.get(priority) == null) {
				priority = 1;
			}
			try {
				if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase()) &&!ApplicationDaoImpl.sparkConfigs.get(priority).getUrl().endsWith("hive.server2.proxy.user=")) {
					throw new PriestPlatformException("hive url must be end with 'hive.server2.proxy.user='!");
				}
				conn = DriverManager.getConnection(ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser);
				AuditLog.log("Connect the other spark jdbcUrl :" +  ApplicationDaoImpl.sparkConfigs.get(priority).getUrl() + appUser);
			} catch (Exception e) {
				conn = retryGetConnection(appUser, e.getMessage(), retryTimes + 1, priority);
			}
		}

		return conn;
	}

	/**
	 * 清理资源，防止资源泄露
	 * 
	 * @param con
	 * @param stmt
	 * @throws SQLException
	 */
	private void cleanResource(Connection con, Statement stmt, ResultSet rs) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	
	public Object sparkExecute(String sql, StatParam statParam) throws SQLException, ClassNotFoundException, IOException {
		logger.info(String.format("spark sql: [%s], param:[%s]", sql, statParam));
		Connection con = getConnection(statParam.getAppUser(), 1);
		
		sql = StringUtil.replaceSemicolon(sql);
		String[] sparkSqls = sql.split(MULTI_SQL_SEPARATOR);
		Object value = null;
		String setruntimeinfo = StringUtil.makeRuntimeInfoQuery(), temp;
		try {
			for (String sparkSql : sparkSqls) {
				if (CommUtils.isNotEmpty(sparkSql)) {
					sparkSql = StringUtil.replace2Semicolon(sparkSql);
					// new Statement，防止资源泄露 OOM
					Statement stmt = con.createStatement();
					try {
						stmt.execute("set hive.exec.dynamic.partition.mode=nonstrict");
						stmt.execute(setruntimeinfo);
					} catch (Exception e) {}
					try {
						value = executeOneSqlProxy(stmt, sparkSql.trim(), statParam);
					} catch(Exception e) {
						//未在黑名单的insert任务自动重跑一次
						boolean flagNotRerun = true;
						Connection conOther = null;
						Statement stmtOther = null;
						try {
//			    			if (hiveStatRecordService.checkProcessTaskRerun(statParam.getProcessId(), statParam.getTaskId()) <= 0) {
			    				flagNotRerun = false;
		    					conOther = getConnection(statParam.getAppUser(), 2);
		    					stmtOther = conOther.createStatement();
		    					stmtOther.execute("set hive.exec.dynamic.partition.mode=nonstrict");
		    					stmt.execute(setruntimeinfo);
			    				try {
				    				Pattern setP = Pattern.compile("set\\s[^;]+=[^;]+;", Pattern.CASE_INSENSITIVE);
				    				Matcher setM = setP.matcher(sql);
				    				while (setM.find()) {
				    					temp = StringUtil.replace2Semicolon(setM.group());
				    					stmtOther.execute(temp.substring(0, temp.length() - 1));
				    					AuditLog.log("Rerun the spark sql, set info is :" + temp);
				    				}
				    				Pattern addP = Pattern.compile("add\\s[^;]+;", Pattern.CASE_INSENSITIVE);
				    				Matcher addM = addP.matcher(sql);
				    				while(addM.find()) {
				    					temp = StringUtil.replace2Semicolon(addM.group());
				    					stmtOther.execute(temp.substring(0, temp.length() - 1));
				    					AuditLog.log("Rerun the spark sql, add info is :" + temp);
				    				}
				    				Pattern createP = Pattern.compile("create\\stemporary\\s[^;]+;", Pattern.CASE_INSENSITIVE);
				    				Matcher createM = createP.matcher(sql);
				    				while(createM.find()) {
				    					temp = StringUtil.replace2Semicolon(createM.group());
				    					stmtOther.execute(temp.substring(0, temp.length() - 1));
				    					AuditLog.log("Rerun the hive sql, create temporary info is :" + temp);
				    				}
				    			} catch(Exception eSet) {
				    				logger.error("Rerun sparksql excute set/add error:", eSet);
				    			}
			    				value = executeOneSqlProxy(stmtOther, sparkSql.trim(), statParam);
//			    			}
						} catch (Exception againExp) {
							logger.error("Error while rerun the spark sql :" + statParam.getProcessId() + ",execdate:" + statParam.getExecDate()+againExp.getMessage());
							throw new RuntimeException(String.format("spark sql[%s] statParam[%s]execute error:", sparkSql, statParam), e);
						} finally {
							cleanResource(null, stmtOther, null);
							cleanResource(conOther, null, null);
							AuditLog.log("clean Other spark connection and stmtment!");
						}
						if (flagNotRerun) {
							throw new RuntimeException(String.format("spark sql[%s] statParam[%s]execute error:", sparkSql, statParam), e);
						}
					} finally {
						cleanResource(null, stmt, null);
					}
				}
			}
		} finally {
			cleanResource(con, null, null);
		}
		return value;
	}
	
	/**
	 * 执行代理，在SQL执行前后记录统计信息
	 * 
	 * @param stmt
	 * @param trimmedSql
	 * @param statParam
	 * @return
	 * @throws SQLException
	 */
	private Object executeOneSqlProxy(Statement stmt, String trimmedSql, StatParam statParam) throws SQLException{
		// 删除sql语句中注释
		if (trimmedSql.startsWith("--")) {
			trimmedSql = trimmedSql.substring(trimmedSql.indexOf('\n') + 1);
		}
		
		// 执行spark sql语句
		Object value = null;
		try {
			value = executeOneSql(stmt, trimmedSql, statParam);
		} catch (SQLException e) {
			throw e;
		}
		
		return value;
	}
	
	/**
	 * 执行单条SQL
	 * 
	 * @param stmt
	 * @param trim
	 * @param statParam
	 * @return
	 * @throws SQLException 
	 */
	private Object executeOneSql(Statement stmt, String trimmedSql, StatParam statParam) throws SQLException {
		Object value = null;
		// 分析sql操作类型(ddl,select or insert)
		HiveOperationEnum sparkOp = HiveSqlParserUtil.analyzeHiveOperatorType(trimmedSql);

		if (HiveOperationEnum.DML_SELECT == sparkOp) {
			// 执行查询语句
			value = executeQuery(stmt, trimmedSql);
		} else {
			// 对于insert操作，hive执行时会统计insert记录数，在此做标记，以便自定义的hive hook把统计信息记录下来，并处理
			if (HiveOperationEnum.DML_INSERT == sparkOp) {
				long magicNumber = Math.abs(UUID.randomUUID().getMostSignificantBits());
				trimmedSql = new StringBuilder("--execdate").append(statParam.getExecDate()).append(":").append(magicNumber)
						.append(":").append(statParam.getAppName()).append(":").append(statParam.getProcessId()).append(":")
						.append(statParam.getTaskId()).append("\n").append(trimmedSql).toString();
			}

			// 执行load、insert语句
			value = stmt.execute(trimmedSql);
		}
		return value;
	}

	/**
	 * 执行select查询语句
	 * 
	 * @param stmt
	 * @param trimmedSql
	 * @return
	 * @throws SQLException
	 */
	private static Object executeQuery(Statement stmt, String trimmedSql) throws SQLException {
		Object value = null;
		ResultSet rs = null;
		
//		RowMapper<Map<String, Object>> rowMapper = new ColumnMapRowMapper();
		long maxrow = WorkSession.get().getMaxResultRowCount() ;
		RowMapper<Map<String, Object>> rowMapper =  maxrow <=0 ? new ColumnMapRowMapper() : new LimittedColumnMapRowMapper(maxrow);
		
		ResultSetExtractor<List<Map<String, Object>>> extractor = new RowMapperResultSetExtractor<Map<String, Object>>(rowMapper);
		try {
			rs = stmt.executeQuery(trimmedSql);
			value = extractor.extractData(rs);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}

		/**
		 * 只有一个结果：e.g　select count(*) from a，结果从List<Map>抽出
		 */
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> tmp = (List<Map<String, Object>>) value;
		if (tmp != null && tmp.size() >= 1) {
			Object v = tmp.get(0).values().iterator().next();
			if (v instanceof String || v instanceof Number || v instanceof Date) {
				value = v;
			} else {
				value = null;
			}
		} else {
			value = null;
		}
		return value;
	}
}
