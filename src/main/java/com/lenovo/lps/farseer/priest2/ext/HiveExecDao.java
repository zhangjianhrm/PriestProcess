package com.lenovo.lps.farseer.priest2.ext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
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
import com.lenovo.lps.farseer.priest2.platform.dal.HiveColumnRowMapper;
import com.lenovo.lps.farseer.priest2.platform.dal.impl.ApplicationDaoImpl;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveOperationEnum;
import com.lenovo.lps.farseer.priest2.platform.service.impl.HadoopUgiServiceImpl;
import com.lenovo.lps.farseer.priest2.platform.util.HiveSqlParserUtil;
import com.lenovo.lps.farseer.priest2.platform.util.LimittedColumnMapRowMapper;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class HiveExecDao {
	private static final Logger logger = Logger.getLogger(HiveExecDao.class);
	
	/** 获取HiveServer2连接失败后的重试次数 */
	private static final int CONN_RETRY_TIMES = 6;
	private static final String MULTI_SQL_SEPARATOR = ";";
	
	public boolean transferExecute(String sql, String appUser) throws SQLException {
		Connection con = getConnection(appUser, 1);
		Statement stmt = null;
		try {
			
			stmt = con.createStatement();
			// set priest params 	
			try {
				stmt.execute(StringUtil.makeRuntimeInfoQuery());
			}catch(Exception e) {
				logger.error("Error while set runtime info to hive statement :" + e.getMessage()) ;
			}
			return stmt.execute(sql);
		} finally {
			cleanResource(con, stmt, null);
		}
	}

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
	private Connection getConnection(String appUser, int priority) {
		Connection conn = null;
		if (ApplicationDaoImpl.hiveConfigs.get(priority) == null) {
			priority = 1;
		}
		if (ApplicationDaoImpl.hiveConfigs.get(priority) == null) {
			throw new PriestPlatformException("hive db is null, please contact administrator, thanks!");
		}
		try {
			HadoopUgiServiceImpl.priestLogin();
			Class.forName(ApplicationDaoImpl.hiveConfigs.get(priority).getTarget());
			if (!"kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase())) {
				appUser = "";
			} else {
				if (!ApplicationDaoImpl.hiveConfigs.get(priority).getUrl().endsWith("hive.server2.proxy.user=")) {
					throw new PriestPlatformException("hive url must be end with 'hive.server2.proxy.user='!");
				}
			}
			conn = DriverManager.getConnection(ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser);
//			AuditLog.log("Connect success the jdbcUrl :" +  ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser 
//					 + "conn:" + conn);
		} catch (Exception e) {
			AuditLog.error(String.format("hive get connection error, jdbcUrl[%s] classname[%s]",
					ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser,
					ApplicationDaoImpl.hiveConfigs.get(priority).getTarget()), e);
			// 如果异常原因是GSS initiate failed，则重试CONN_RETRY_TIMES次连接
			conn = retryGetConnection(appUser, e.getMessage(), 1, priority);
		}
		
		if (conn == null) {
			throw new RuntimeException(String.format("hive get connection error, jdbcUrl[%s] classname[%s]",
					ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser,
					ApplicationDaoImpl.hiveConfigs.get(priority).getTarget()));
		}

		return conn;
	}

	/**
	 * 重试获取hiveserver2连接, 最多获取CONN_RETRY_TIMES次
	 * 
	 * @param appUser
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

			logger.warn("Start getting connection to " + ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser + " for the " + retryTimes + " time!");
			try {
				if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase()) &&!ApplicationDaoImpl.hiveConfigs.get(priority).getUrl().endsWith("hive.server2.proxy.user=")) {
					throw new PriestPlatformException("hive url must be end with 'hive.server2.proxy.user='!");
				}
				conn = DriverManager.getConnection(ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser);
			} catch (SQLException sqlExp) {
				AuditLog.error(String.format("hive get connection error, jdbcUrl[%s] classname[%s]",
						ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser,
						ApplicationDaoImpl.hiveConfigs.get(priority).getTarget()), sqlExp);
				conn = retryGetConnection(appUser, sqlExp.getMessage(), retryTimes + 1, priority);
			}
		} else {
			priority++;
			if (ApplicationDaoImpl.hiveConfigs.get(priority) == null) {
				priority = 1;
			}
			try {
					if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase()) &&!ApplicationDaoImpl.hiveConfigs.get(priority).getUrl().endsWith("hive.server2.proxy.user=")) {
						throw new PriestPlatformException("hive url must be end with 'hive.server2.proxy.user='!");
					}
					conn = DriverManager.getConnection(ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser);
					AuditLog.log("Connect the other jdbcUrl :" +  ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser);
			} catch (Exception e) {
				AuditLog.error(String.format("hive get connection error, jdbcUrl[%s] classname[%s]",
						ApplicationDaoImpl.hiveConfigs.get(priority).getUrl() + appUser,
						ApplicationDaoImpl.hiveConfigs.get(priority).getTarget()), e);
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
	
	public Object hiveExecute(String sql, StatParam statParam) throws SQLException {
		Connection con = getConnection(statParam.getAppUser(), 1);
		sql = StringUtil.replaceSemicolon(sql);

		String[] hiveSqls = sql.split(MULTI_SQL_SEPARATOR);
		String setruntimeinfo = StringUtil.makeRuntimeInfoQuery(), temp;
		int sqlNum = 0;
		Object value = null;
		try {
			for (String hiveSql : hiveSqls) {
				if (CommUtils.isNotEmpty(hiveSql)) {
					hiveSql = StringUtil.replace2Semicolon(hiveSql);
					
					// new Statement，防止资源泄露 OOM
					Statement stmt = con.createStatement();
					// set priest params 		
					try {
						//stmt.executeQuery(setruntimeinfo);
						stmt.execute(setruntimeinfo);
					}catch(Exception e) {
						logger.error("Error while set runtime info to hive statement :" + setruntimeinfo+e.getMessage()) ;
					}
					try {
						value = executeOneSqlProxy(stmt, hiveSql.trim(), statParam);
						AuditLog.log(setruntimeinfo + "hive execute success!" + sqlNum++);
					} catch (Exception e) {
						//9点前并且未在黑名单的insert任务自动重跑一次
						boolean flagNotRerun = true;
						Connection conOther = null;
						Statement stmtOther = null;
						try {
							conOther = getConnection(statParam.getAppUser(), 2);
							stmtOther = conOther.createStatement();
							Calendar cal = Calendar.getInstance();
				    		int hourLimit=StringUtil.parseInt(ConfigUtil.getContextProperty("process.rerun.hour", "-1"));
				    		hourLimit = hourLimit > 0 ? hourLimit:-1;
				    		int hour = cal.get(Calendar.HOUR_OF_DAY);
				    		if (hour <= hourLimit) {
				    			try {
				    				Pattern setP = Pattern.compile("set\\s[^;]+=[^;]+;", Pattern.CASE_INSENSITIVE);
				    				Matcher setM = setP.matcher(sql);
				    				while (setM.find()) {
				    					temp = StringUtil.replace2Semicolon(setM.group());
				    					stmtOther.execute(temp.substring(0, temp.length() - 1));
				    					AuditLog.log("Rerun the hive sql, set info is :" + temp);
				    				}
				    				Pattern addP = Pattern.compile("add\\s[^;]+;", Pattern.CASE_INSENSITIVE);
				    				Matcher addM = addP.matcher(sql);
				    				while(addM.find()) {
				    					temp = StringUtil.replace2Semicolon(addM.group());
				    					stmtOther.execute(temp.substring(0, temp.length() - 1));
				    					AuditLog.log("Rerun the hive sql, add info is :" + temp);
				    				}
				    				Pattern createP = Pattern.compile("create\\stemporary\\s[^;]+;", Pattern.CASE_INSENSITIVE);
				    				Matcher createM = createP.matcher(sql);
				    				while(createM.find()) {
				    					temp = StringUtil.replace2Semicolon(createM.group());
				    					stmtOther.execute(temp.substring(0, temp.length() - 1));
				    					AuditLog.log("Rerun the hive sql, create temporary info is :" + temp);
				    				}
				    			} catch(Exception eSet) {
				    				logger.error("Rerun hivesql excute set/add error:", eSet);
				    			}
				    			HiveOperationEnum hiveOp = HiveSqlParserUtil.analyzeHiveOperatorType(hiveSql);
				    			if (HiveOperationEnum.DML_INSERT == hiveOp) {
				    				flagNotRerun = false;
				    				TimeUnit.SECONDS.sleep(60);
				    				stmtOther.execute(setruntimeinfo);
				    				value = executeOneSqlProxy(stmtOther, hiveSql.trim(), statParam);
				    				AuditLog.log("Rerun the hive sql before 9:00, process info is :" + setruntimeinfo);
				    			}
				    		}
						} catch (Exception againExp) {
							logger.error("Error while rerun the hive sql :" + setruntimeinfo+againExp.getMessage());
							throw new PriestPlatformException(String.format("sql[%s] statParam[%s]execute error:", hiveSql, statParam), e);
						} finally {
							cleanResource(null, stmtOther, null);
							cleanResource(conOther, null, null);
							AuditLog.log("clean Other connection and stmtment!");
						}
						if (flagNotRerun) {
							throw new PriestPlatformException(String.format("sql[%s] statParam[%s]execute error:", hiveSql, statParam), e);
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
		
		// 执行hive sql语句
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
		HiveOperationEnum hiveOp = HiveSqlParserUtil.analyzeHiveOperatorType(trimmedSql);

		if (HiveOperationEnum.DML_SELECT == hiveOp) {
			// 执行查询语句
			value = executeQuery(stmt, trimmedSql);
		} else {
			// 对于insert操作，hive执行时会统计insert记录数，在此做标记，以便自定义的hive hook把统计信息记录下来，并处理
			if (HiveOperationEnum.DML_INSERT == hiveOp) {
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
		
		//RowMapper<Map<String, Object>> rowMapper = new ColumnMapRowMapper();
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
	
	@SuppressWarnings("unchecked")
	public <T> T reportQuery(final String sql, final String appUser) throws SQLException {
		Connection con = getConnection(appUser, 1);
		Statement stmt = null;
		ResultSet rs = null;
		
		RowMapper<Map<String, Object>> rowMapper = new HiveColumnRowMapper();
		ResultSetExtractor<List<Map<String, Object>>> extractor = new RowMapperResultSetExtractor<Map<String, Object>>(rowMapper);
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			return (T) extractor.extractData(rs);
		} finally {
			cleanResource(con, stmt, rs);
		}
	}
}
