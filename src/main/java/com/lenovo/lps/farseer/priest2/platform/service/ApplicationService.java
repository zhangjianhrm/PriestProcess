package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

import javax.servlet.http.HttpSession;

import com.lenovo.lps.farseer.priest2.platform.entity.AppEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ThreadPoolEntity;

public interface ApplicationService {
	/**
	 * 获取所有应用信息
	 * 
	 * @return 应用信息列表
	 */
	List<AppEntity> getAppInfos(AppEntity entity);
	/**
	 * 获取应用Id
	 * 
	 * @return 应用名称
	 */
	String getAppId(String appName);
	/**
	 * 获取应用
	 * 
	 * @return 应用Id
	 */
	Map<String, String> getApp(Integer appId);
	/**
	 * 获取应用组PoolId
	 * 
	 * @return pool名称
	 */
	Integer getPoolId(String poolName) ;

	/**
	 * 增加新的应用
	 * 
	 * @param entity
	 */
	void addAppInfo(AppEntity entity);

	/**
	 * 更新应用信息
	 * 
	 * @param entity
	 */
	void updateAppInfo(AppEntity entity);

	/**
	 * 
	 * @param appId
	 * @param dbType
	 * @param dbName
	 * @return
	 */
	public DbEntity getAppDbConfig(Integer appId, DbTypeEnum dbType, String dbName);

	/**
	 * 获取所有应用信息
	 * 
	 * @return 应用信息列表
	 */
	List<DbEntity> getDatabases(DbEntity entity);

	/**
	 * 增加新的应用
	 * 
	 * @param entity
	 */
	void addDatabase(DbEntity entity);

	/**
	 * 更新应用信息
	 * 
	 * @param entity
	 */
	void updateDatabase(DbEntity entity);

	/**
	 * 获取所有业务应用信息
	 * 
	 * @return
	 */
	List<Map<String, String>> selectApp(HttpSession session);

	/**
	 * 获取应用下所有数据源名
	 * 
	 * @param appId
	 * @param dbType
	 * @return
	 */
	public List<Map<String, String>> getAppDbNames(Integer appId, DbTypeEnum dbType);

	/**
	 * 获取线程池配置
	 * 
	 * @return
	 */
	public List<ThreadPoolEntity> getThreadPoolCached();

	/**
	 * 获取应用对应的线程池设置
	 * 
	 * @param appId
	 * @return
	 */
	public ThreadPoolEntity getAppThreadPool(String appId);

	/**
	 * 获取所有应用对应的线程池设置
	 * 
	 * @param appId
	 * @return
	 */
	public Map<String, ThreadPoolEntity> getAppThreadPools();

	public Map<String, ExecutorService> getExecutors();

	public Map<String, BlockingQueue<Runnable>> getThreadPoolQueues();

	public String getAppNameById(String appId);
}
