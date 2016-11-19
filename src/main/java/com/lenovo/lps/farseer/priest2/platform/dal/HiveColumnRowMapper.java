package com.lenovo.lps.farseer.priest2.platform.dal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * 由于hiveserver2查出来的ResultSet列名中带有表名，无法满足使用要求（查出的列不带schema），这里重新实现一个RowMapper
 * 该类与ColumnMapRowMapper中唯一的不同就是去掉了列名中的表名部分
 * 
 * @author NA
 */
public class HiveColumnRowMapper extends ColumnMapRowMapper {
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Map<String, Object> mapOfColValues = createColumnMap(columnCount);
		for (int i = 1; i <= columnCount; i++) {
			String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
			Object obj = getColumnValue(rs, i);
			
			// key去掉表名部分
			key = key.substring(key.indexOf('.') + 1);
			mapOfColValues.put(key, obj);
		}
		return mapOfColValues;
	}
}
