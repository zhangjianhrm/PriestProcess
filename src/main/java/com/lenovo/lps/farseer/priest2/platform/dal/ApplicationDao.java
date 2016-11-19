package com.lenovo.lps.farseer.priest2.platform.dal;

import java.util.List;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.platform.entity.AppEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysMapEntity;

public interface ApplicationDao {
	/**
	 * 查询应用配制表
	 * 
	 * @return
	 */
	List<AppEntity> selectApp();
	
	/**
	 * 获取应用ID
	 * @param appName
	 * @return
	 */
	Integer getAppId(String appName);

	/**
	 * 获取应用信息
	 * 
	 * @param appId
	 * @return
	 */
	Map<String, String> getAppInfo(Integer appId);
	
	/**
	 * 获取数据库配置信息
	 * @param param
	 * @return
	 */
	List<DbEntity> getAppDbConfig(DbEntity entity);
	
	/**
	 * 更新应用变量
	 * @param appVariables 应用变量
	 */
	void updateAppVariables(Map<String, String> appVarsMap);

	/**
	 * 获取所有应用信息
	 * @return 应用信息列表
	 */
	List<AppEntity> getAppInfos(AppEntity entity);
	
	/**
	 * 增加新的应用
	 * @param entity
	 */
	void addAppInfo(AppEntity entity);
	
	/**
	 * 增加新的数据库配置
	 * @param entity
	 */
	void addAppDbConfig(DbEntity entity);

	/**
	 * 更新应用信息
	 * @param entity
	 */
	void updateAppInfo(AppEntity entity);
	
	/**
	 * 更新数据库配置
	 * @param entity
	 */
	void updateAppDbConfig(DbEntity entity);
	
	/**
	 * 根据应用ID获取应用用户
	 * @param appId
	 * @return
	 */
	String getAppUser(Integer appId);
	/**
	 * 获取系统配置信息
	 * 
	 * @param param
	 * @return
	 */
	List<SysConfigEntity> getSysConfig(SysConfigEntity entity);

	/**
	 * 获取最大优先级
	 * 
	 * @param entity
	 */
	int getMaxPriority(SysConfigEntity entity);

	/**
	 * 删除系统配置信息
	 * 
	 * @param entity
	 */
	void delSysConfig(SysConfigEntity entity);
	
	/**
	 * 增加/更新系统配置信息
	 * 
	 * @param entity
	 */
	void addSysConfig(SysConfigEntity entity);
	
	/**
	 * 增加/更新key|value系统配置信息
	 * 
	 * @param entity
	 */
	void addSysMap(String key, String value);
	
	/**
	 * 更新key|value系统配置信息
	 * 
	 * @param entity
	 */
	void updateSysMap();
	/**
	 * 获取系统key|value配置信息
	 * 
	 * @param param
	 * @return
	 */
	List<SysMapEntity> getSysMap(String key);
}
