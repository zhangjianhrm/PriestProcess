package com.lenovo.lps.farseer.priest2.platform.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;

public class LimittedColumnMapRowMapper extends ColumnMapRowMapper{
	Long maxrow = -1L ;
	
	public LimittedColumnMapRowMapper(long maxrow) {
		this.maxrow = maxrow ;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum)	throws SQLException {
		if ( maxrow > 0 && rowNum > maxrow) {
			throw new SQLException("sql result rowcount more than system configured row:" + maxrow) ;
		}
		// TODO Auto-generated method stub
		return super.mapRow(rs, rowNum);
	}
}
