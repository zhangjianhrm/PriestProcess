/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.Map;

/**
 * Map reduce任务管理
 * 
 * @author niexm1
 * 
 */
public interface SparkJarService {
	/**
	 * 提交spark jar
	 * 
	 * @param jobName
	 * @param jarFullFileName
	 * @param mainClass
	 * @param params
	 */
	public void submit(String jobName, String jarFullFileName, String mainClass, Map<String, String> params, String appUser);
}
