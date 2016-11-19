/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import com.lenovo.lps.farseer.priest2.common.util.ClasspathLoader;
import com.lenovo.lps.farseer.priest2.common.util.MyURLClassLoader;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.service.SparkJdbcService;

/**
 * @author yujw
 * 
 */
public class SparkJdbcServiceImpl implements SparkJdbcService {
	
	@Override
	public Object sparkExecute(String sql, StatParam statParam){
		try {
			MyURLClassLoader cl = ClasspathLoader.loadDircClasspath("hive");
			Class<?> hiveDaoCla = cl.loadClass("com.lenovo.lps.farseer.priest2.ext.SparkExecDao");
			Object hiveDao = hiveDaoCla.newInstance();
			return hiveDaoCla.getMethod("sparkExecute", 
					new Class<?>[]{String.class, StatParam.class}).invoke(hiveDao, sql, statParam);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}