package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.AppEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.SysMapEntity;
import com.lenovo.lps.farseer.priest2.platform.manager.RedisSourceManager;
import com.lenovo.lps.farseer.priest2.platform.mapper.ApplicationMapper;

public class ApplicationDaoImpl implements ApplicationDao {
	private final Logger logger = Logger.getLogger(ApplicationDaoImpl.class);
	
	public static Map<Integer, SysConfigEntity> hiveConfigs = new HashMap<Integer, SysConfigEntity>();
	
	public static Map<Integer, SysConfigEntity> sparkConfigs = new HashMap<Integer, SysConfigEntity>();
	
	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Autowired
	private RedisSourceManager manager;

	@PostConstruct
	private void postInit()	{
		initHive();
		initSpark();
		reloadSysMap();
	}
	
	@Override
	public List<AppEntity> selectApp() {
		return applicationMapper.selectApp();
	}

	@Override
	public Integer getAppId(String appName) {
		return applicationMapper.getAppId(appName);
	}

	@Override
	public Map<String, String> getAppInfo(Integer appId) {
		return applicationMapper.getAppInfo(appId);
	}

	@Override
	public List<DbEntity> getAppDbConfig(DbEntity entity) {
		return applicationMapper.getAppDbConfig(entity);
	}

	@Override
	public void updateAppVariables(Map<String, String> appVarsMap) {
		applicationMapper.updateAppVariables(appVarsMap);
	}

	@Override
	public List<AppEntity> getAppInfos(AppEntity entity) {
		return applicationMapper.getAppInfos(entity);
	}

	@Override
	public void addAppInfo(AppEntity entity) {
		applicationMapper.addAppInfo(entity);
	}

	@Override
	public void addAppDbConfig(DbEntity entity) {
		applicationMapper.addAppDbConfig(entity);
	}

	@Override
	public void updateAppInfo(AppEntity entity) {
		applicationMapper.updateAppInfo(entity);
	}

	@Override
	public void updateAppDbConfig(DbEntity entity) {
		applicationMapper.updateAppDbConfig(entity);
	}

	@Override
	public String getAppUser(Integer appId) {
		return applicationMapper.getAppUser(appId);
	}
	
	@Override
	public List<SysConfigEntity> getSysConfig(SysConfigEntity entity) {
		return applicationMapper.getSysConfig(entity);
	}
	@Override
	public synchronized void addSysConfig(SysConfigEntity entity) {
		applicationMapper.addSysConfig(entity);
		resetSysConfig(entity);
	}
	
	private void initSpark() {
		SysConfigEntity config = new SysConfigEntity();
		sparkConfigs.clear();
		AuditLog.log("initSpark Config.");
		config.setType(String.valueOf(SysConfigTypeEnum.SPARK.getValue()));
		List<SysConfigEntity> sysConfs = getSysConfig(config);
		if (sysConfs != null) {
			for (SysConfigEntity sysConfig: sysConfs) {
				sparkConfigs.put(sysConfig.getPriority(), sysConfig);
			}
		}
	}
	
	private synchronized void initHive() {
		SysConfigEntity config = new SysConfigEntity();
		hiveConfigs.clear();
		AuditLog.log("initHive Config.");
		config.setType(String.valueOf(SysConfigTypeEnum.HIVE.getValue()));
		List<SysConfigEntity> sysConfs = getSysConfig(config);
		if (sysConfs != null) {
			for (SysConfigEntity sysConfig: sysConfs) {
				hiveConfigs.put(sysConfig.getPriority(), sysConfig);
			}
		}
	}
	
	public synchronized void reloadSysMap() {
		List<SysMapEntity> sysConfs = getSysMap("");
		AuditLog.log("reloadSysMap Config.");
		if (sysConfs != null) {
			for (SysMapEntity sysMap: sysConfs) {
				ConfigUtil.setContextProperty(sysMap.getKey(), sysMap.getValue());
			}
		}
	}
	
	@Override
	public void updateSysMap() {
		reloadSysMap();
	}
	
	private void resetSysConfig(SysConfigEntity entity) {
		try {
			SysConfigTypeEnum type = SysConfigTypeEnum.fromValue(Integer.valueOf(entity.getType()));
			switch (type) {
				case HIVE:
					initHive();
					break;
				case SPARK:
					initSpark();
					break;
				case REDIS:
					manager.resetMannager();
					break;
				default:
					break;
			}
		} catch (Exception e) {
			logger.error(String.format("addSysConfig init method error[%s]", entity), e);
		}
	}
	
	
	/**
	 * 增加/更新key|value系统配置信息
	 * 
	 * @param entity
	 */
	@Override
	public void addSysMap(String key, String value) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", key);
		params.put("value", value);
		applicationMapper.addSysMap(params);
	}
	
	/**
	 * 获取系统key|value配置信息
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<SysMapEntity> getSysMap(String key) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", key);
		return applicationMapper.getSysMap(params);
	}
	
	@Override
	public int getMaxPriority(SysConfigEntity entity) {
		return applicationMapper.getMaxPriority(entity);
	}
	@Override
	public void delSysConfig(SysConfigEntity entity) {
		applicationMapper.delSysConfig(entity);
		resetSysConfig(entity);
	}
}
