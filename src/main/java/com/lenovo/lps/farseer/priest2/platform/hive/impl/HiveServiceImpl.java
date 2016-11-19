/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.hive.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ClasspathLoader;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.MyURLClassLoader;
import com.lenovo.lps.farseer.priest2.platform.dal.impl.ApplicationDaoImpl;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveService;
import com.lenovo.lps.farseer.priest2.platform.service.HiveMetaDao;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * @author niexm1
 * 
 */
public class HiveServiceImpl implements HiveService {
	@Resource
	private HiveMetaDao hiveMetaDao;
	
	@Override
	public String getStorageLocation(String tableName) {
		// hive数据存hdfs时,表名统一小写
		String lowerTableName = tableName.toLowerCase();

		String schema, table, defaultDn = defaultHiveDbName(1);
		// "."位置 (default.table)
		int pos = lowerTableName.indexOf(SCHEMA_TABLE_SEPARATOR);

		// .tableName
		if (pos == 0) {
			schema = defaultDn;
			table = lowerTableName.substring(1);
		}
		// schema.table
		else if (pos > 0) {
			schema = lowerTableName.substring(0, pos);
			table = lowerTableName.substring(pos + 1);
		}
		// 只有表名
		else {
			schema = defaultDn;
			table = lowerTableName;
		}

		try {
			return hiveMetaDao.getStorageLocation(schema, table);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	@Override
	public String getFieldsTerminatedBy(String schema, String tableName) {
		try {
			String fieldsTerminated = hiveMetaDao.getFieldsTerminatedBy(schema, tableName);
			// 默认\u0001
			if (fieldsTerminated == null || "".equals(fieldsTerminated)
					|| "null".equals(fieldsTerminated) || "NULL".equals(fieldsTerminated)) {
				fieldsTerminated = Constants.HIVE_DEFAULT_FIELD_TERMINATED;
			} else if (fieldsTerminated.contains("\\s")) {
				if ("\t".equals(fieldsTerminated)) {
					fieldsTerminated = "\t";
				} else if ("\r".equals(fieldsTerminated)) {
					fieldsTerminated = "\r";
				} else if ("\0".equals(fieldsTerminated)) {
					fieldsTerminated = "\0";
				}
			} else if (fieldsTerminated.contains("\\")) {
				fieldsTerminated = "\\";
			}

			return fieldsTerminated;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
	
	/**
	 * 获取连接指定数据库名称
	 * 
	 * @param jdbcUrl
	 * @param driverName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static String defaultHiveDbName(int priority) {
		String result = "";
		if (ApplicationDaoImpl.hiveConfigs.get(priority) == null) {
			priority = 1;
		}
		if (ApplicationDaoImpl.hiveConfigs.get(priority) == null) {
			throw new PriestPlatformException("hive db is null, please contact administrator, thanks!");
		}
		result = retryGetDbName(priority);
		if (CommUtils.isNull(result)) {
			throw new RuntimeException(String.format("hive jdbcUrl get default hive dbname error, jdbcUrl[%s] classname[%s]",
					ApplicationDaoImpl.hiveConfigs.get(priority).getUrl(),
					ApplicationDaoImpl.hiveConfigs.get(priority).getTarget()));
		}
		
		return result;
	}

	/**
	 * 重试获取hiveserver2连接数据库名称, 最多获取5次
	 * 
	 * @param appUser
	 * @param msg
	 * @param retryTimes
	 *            重试次数
	 * @return
	 */
	private static String retryGetDbName(int priority) {
		String result = "";
		
		if (ApplicationDaoImpl.hiveConfigs.get(priority) != null) {
			try {
				result = ApplicationDaoImpl.hiveConfigs.get(priority).getUrl();
				result = result.split(";")[0];
				result = result.substring(result.lastIndexOf("/")+1);
			} catch (Exception e) {
			}
			
			if (CommUtils.isNull(result)) {
				retryGetDbName(priority+1);
			} 
		}
		return result;
	}

	@Override
	public String getFieldsTerminatedBy(String tableName) {
		// hive数据存hdfs时,表名统一小写
		String lowerTableName = tableName.toLowerCase();

		String schema, table, defaultDn = defaultHiveDbName(1);
		// "."位置 (default.table)
		int pos = lowerTableName.indexOf(SCHEMA_TABLE_SEPARATOR);

		// .tableName
		if (pos == 0) {
			schema = defaultDn;
			table = lowerTableName.substring(1);
		}
		// schema.table
		else if (pos > 0) {
			schema = lowerTableName.substring(0, pos);
			table = lowerTableName.substring(pos + 1);
		}
		// 只有表名
		else {
			schema = defaultDn;
			table = lowerTableName;
		}
		return getFieldsTerminatedBy(schema, table);
	}

	@Override
	public List<String> getColumns(String tableName) {
		// hive数据存hdfs时,表名统一小写
		String lowerTableName = tableName.toLowerCase();

		String schema, table, defaultDn = defaultHiveDbName(1);
		// "."位置 (default.table)
		int pos = lowerTableName.indexOf(SCHEMA_TABLE_SEPARATOR);

		// .tableName
		if (pos == 0) {
			schema = defaultDn;
			table = lowerTableName.substring(1);
		}
		// schema.table
		else if (pos > 0) {
			schema = lowerTableName.substring(0, pos);
			table = lowerTableName.substring(pos + 1);
		}
		// 只有表名
		else {
			schema = defaultDn;
			table = lowerTableName;
		}

		List<Map<String, Object>> columns;
		try {
			columns = hiveMetaDao.descTable(schema, table);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		List<String> results = new ArrayList<String>();
		if (columns != null && columns.size() > 0) {
			for (Map<String, Object> column : columns) {
				// 列名
				String columnName = (String) column.get("COLUMN_NAME");
				results.add(columnName);
			}
		}

		return results;
	}
	
	@Override
	public boolean transferExecute(String sql, String appUser) {
		try {
			MyURLClassLoader cl = ClasspathLoader.loadDircClasspath("hive");
			Class<?> hiveDaoCla = cl.loadClass("com.lenovo.lps.farseer.priest2.ext.HiveExecDao");
			Object hiveDao = hiveDaoCla.newInstance();
			return (Boolean)hiveDaoCla.getMethod("transferExecute", new Class<?>[]{String.class, String.class}).invoke(hiveDao, sql, appUser);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
	
	@Override
	public Object hiveExecute(String sql, StatParam statParam){
		try {
			MyURLClassLoader cl = ClasspathLoader.loadDircClasspath("hive");
			Class<?> hiveDaoCla = cl.loadClass("com.lenovo.lps.farseer.priest2.ext.HiveExecDao");
			Object hiveDao = hiveDaoCla.newInstance();
			return hiveDaoCla.getMethod("hiveExecute", new Class<?>[]{String.class, StatParam.class}).invoke(hiveDao, sql, statParam);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T reportQuery(String sql, String appUser) {
		try {
			MyURLClassLoader cl = ClasspathLoader.loadDircClasspath("hive");
			Class<?> hiveDaoCla = cl.loadClass("com.lenovo.lps.farseer.priest2.ext.HiveExecDao");
			Object hiveDao = hiveDaoCla.newInstance();
			return (T)hiveDaoCla.getMethod("reportQuery", new Class<?>[]{String.class, String.class}).invoke(hiveDao, sql, appUser);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
}