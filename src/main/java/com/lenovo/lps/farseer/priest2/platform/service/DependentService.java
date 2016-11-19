package com.lenovo.lps.farseer.priest2.platform.service;

import java.sql.SQLException;

import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;


/**
 * 任务依赖服务
 * 
 * @author niexm1
 * 
 */
public interface DependentService {
	/**
	 * 等待依赖的任务执行完
	 * 
	 * @param taskId
	 * @param execDate
	 */
	public void waitTask(Integer taskId, String execDate) throws InterruptedException;

	/**
	 * 等待依赖的流程执行完
	 * 
	 * @param processId
	 * @param execDate
	 */
	public void waitProcess(Integer processId, String execDate, String interrupteKey) throws InterruptedException;
	
	/**
	 * 等待指定hdfs路径 是否传完文件  远程调用判断传完接口
	 * 
	 * @param targetPath
	 * @param execDate
	 */
	public void waitHdfsDir(String targetPath, String interrupteKey) throws InterruptedException;
	
	/**
	 * 判断hdfs正则匹配路径文件大小是否满足指定大小
	 * 
	 * @param targetPath
	 * @param execDate
	 */
	public void waitHdfsSize(String targetPath, String targetNum, String interrupteKey) throws InterruptedException;
	
	/**
	 * 判断mysql查询数据条数是否满足指定条数
	 * 
	 * @param targetPath
	 * @param execDate
	 */
	public void waitMysqlNum(String sql, String targetNum, DbEntity entity, String interrupteKey) throws InterruptedException, SQLException;
	
	/**
	 * 判断Oracle查询数据条数是否满足指定条数
	 * 
	 * @param targetPath
	 * @param execDate
	 */
	public void waitOracleNum(String sql, String targetNum, DbEntity entity, String interrupteKey) throws InterruptedException, SQLException;
	
	/**
	 * 判断Spark查询数据条数是否满足指定条数
	 * 
	 * @param targetPath
	 * @param execDate
	 */
	public void waitSparkNum(String sql, String targetNum, StatParam statParam, String interrupteKey);
}
