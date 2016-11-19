package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.dal.ThreadPoolDao;
import com.lenovo.lps.farseer.priest2.platform.entity.AppEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ThreadPoolEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.UserService;

public class ApplicationServiceImpl implements ApplicationService {
	@Resource
	private ApplicationDao appDao;

	private List<Map<String, String>> apps = new ArrayList<Map<String, String>>();

	private final Map<String, DbEntity> appDbCache = new ConcurrentHashMap<String, DbEntity>();

	@Resource
	private UserService userService;

	@Resource
	private ThreadPoolDao threadPoolDao;

	private List<ThreadPoolEntity> poolCached;

	// app_id ==> thread pool
	private Map<String, ThreadPoolEntity> appThreadPoolMap = new HashMap<String, ThreadPoolEntity>();

	// 流程调度线程池 app_id==>ExecutorService
	private Map<String, ExecutorService> executors = new HashMap<String, ExecutorService>();

	// app id == > 对应线程池队列
	final Map<String, BlockingQueue<Runnable>> threadPoolQueues = new HashMap<String, BlockingQueue<Runnable>>();

	// 建立pool id ==> ExecutorService mapping
	Map<Integer, ExecutorService> poolExecutesMap = new HashMap<Integer, ExecutorService>();
	Map<Integer, BlockingQueue<Runnable>> poolQueueMap = new HashMap<Integer, BlockingQueue<Runnable>>();

	Map<String,String> appId2Name = new HashMap<String,String>();
	/**
	 * 应用信息Cache
	 */
	@PostConstruct
	private void initCache() {
		poolCached = threadPoolDao.loadThreadPools();
		List<AppEntity> aps = appDao.selectApp();

		for (AppEntity app : aps) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", app.getAppName());
			map.put("value", app.getAppId());
			map.put("threadPoolId", String.valueOf(app.getThreadPoolId()));
			map.put("appUser", app.getAppUser());
			apps.add(map);
			appId2Name.put(app.getAppId(), app.getAppName());
			
			for (ThreadPoolEntity pool : poolCached) {
				if (app.getThreadPoolId().intValue() == pool.getPoolId().intValue()) {
					appThreadPoolMap.put(app.getAppId(), pool);
					break;
				}
			}
		}

		List<DbEntity> dbs = appDao.getAppDbConfig(null);
		if (dbs.size() > 0) {
			for (DbEntity db : dbs) {
				StringBuilder sb = new StringBuilder();
				sb.append(db.getAppId()).append("_").append(db.getDbType()).append("_").append(db.getDbName());
				appDbCache.put(sb.toString(), db);
			}
		}

		for (ThreadPoolEntity pool : poolCached) {
			// 创建排队队列
			BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
			// 根据配置创建线程池
			ExecutorService executor = new ThreadPoolExecutor(pool.getCorePoolSize(), pool.getMaxPoolSize(), 15, TimeUnit.MINUTES,
					queue, new PriestThreadFactory(pool.getPoolName()));

			poolExecutesMap.put(pool.getPoolId(), executor);
			poolQueueMap.put(pool.getPoolId(), queue);
		}

		// 建立 app id == > ExecutorService mapping
		for (String appId : appThreadPoolMap.keySet()) {
			Integer poolId = appThreadPoolMap.get(appId).getPoolId();

			executors.put(appId, poolExecutesMap.get(poolId));
			threadPoolQueues.put(appId, poolQueueMap.get(poolId));
		}

	}

	@Override
	public List<AppEntity> getAppInfos(AppEntity entity) {
		return appDao.getAppInfos(entity);
	}
	
	@Override
	public String getAppId(String appName) {
		String appId = "";
		for (Map<String, String> app: apps) {
			if (appName.equals(app.get("name"))) {
				appId = app.get("value");
			}
		}
		return appId;
	}
	
	@Override
	public Map<String, String> getApp(Integer appId) {
		Map<String, String> result = null;
		for (Map<String, String> app: apps) {
			if (app.get("value").equals(String.valueOf(appId))) {
				result = app;
			}
		}
		return result;
	}
	
	@Override
	public Integer getPoolId(String poolName) {
		Integer poolId = 3;
		for (ThreadPoolEntity pool : poolCached) {
			if (pool.getPoolName().equals(poolName)) {
				poolId = pool.getPoolId();
			}
		}
		return poolId;
	}

	@Override
	@Transactional
	public void addAppInfo(AppEntity entity) {
		entity.setAppName(entity.getAppName().toLowerCase());
		entity.setAppUser("u_" + entity.getAppName());
		appDao.addAppInfo(entity);

		// 更新cache
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", entity.getAppId());
		map.put("name", entity.getAppName());
		
		map.put("threadPoolId", String.valueOf(entity.getThreadPoolId()));
		map.put("appUser", entity.getAppUser());
		apps.add(map);
		
		appId2Name.put(entity.getAppId(), entity.getAppName());

		// 应用线程池缓存
		for (ThreadPoolEntity pool : poolCached) {
			if (entity.getThreadPoolId().intValue() == pool.getPoolId().intValue()) {
				appThreadPoolMap.put(entity.getAppId(), pool);
				executors.put(entity.getAppId(), poolExecutesMap.get(pool.getPoolId()));
				threadPoolQueues.put(entity.getAppId(), poolQueueMap.get(pool.getPoolId()));
				break;
			}
		}
	}

	@Override
	@Transactional
	public void updateAppInfo(AppEntity entity) {
		appDao.updateAppInfo(entity);
		
		// 更新cache
		for (Map<String, String> app: apps) {
			if (app.get("value").equals(entity.getAppId())) {
				if (CommUtils.isNotNull(entity.getAppName())) {
					app.put("name", entity.getAppName());
				}
				if (entity.getThreadPoolId() != null && entity.getThreadPoolId() != 0) {
					app.put("threadPoolId", String.valueOf(entity.getThreadPoolId()));
				}
				if (CommUtils.isNotNull(entity.getAppUser())) {
					app.put("appUser", entity.getAppUser());
				}
			}
		}
		
		// 应用线程池变更，更应缓存
		if (entity.getThreadPoolId().intValue() != appThreadPoolMap.get(entity.getAppId()).getPoolId().intValue()) {
			for (ThreadPoolEntity pool : poolCached) {
				if (entity.getThreadPoolId().intValue() == pool.getPoolId().intValue()) {
					appThreadPoolMap.put(entity.getAppId(), pool);
					executors.put(entity.getAppId(), poolExecutesMap.get(pool.getPoolId()));
					threadPoolQueues.put(entity.getAppId(), poolQueueMap.get(pool.getPoolId()));
					break;
				}
			}
		}
	}

	@Override
	public DbEntity getAppDbConfig(Integer appId, DbTypeEnum dbType, String dbName) {
		return appDbCache.get(appId + "_" + dbType.getValue() + "_" + dbName);
	}

	@Override
	public List<DbEntity> getDatabases(DbEntity entity) {
		return appDao.getAppDbConfig(entity);
	}

	@Override
	public void addDatabase(DbEntity entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(entity.getAppId()).append("_").append(entity.getDbType()).append("_").append(entity.getDbName());
		String key = sb.toString();

		// 同应用下，同名数据源检查
		if (appDbCache.get(key) != null) {
			throw new PriestPlatformException("Under the same app, there is the same name of the data source!");
		}

		appDao.addAppDbConfig(entity);
		// 设置到cache
		appDbCache.put(key, entity);
	}

	@Override
	public void updateDatabase(DbEntity entity) {
		appDao.updateAppDbConfig(entity);

		StringBuilder sb = new StringBuilder();
		sb.append(entity.getAppId()).append("_").append(entity.getDbType()).append("_").append(entity.getDbName());

		String key = sb.toString();

		if (appDbCache.containsKey(key)) {
			DbEntity cached = appDbCache.get(key);
			// 不更新密码时，恢复旧密码
			if (!StringUtils.hasText(entity.getPassword())) {
				entity.setPassword(cached.getPassword());
			}

			entity.setDriverClassName(cached.getDriverClassName());
		}
		// 更新至cache
		appDbCache.put(key, entity);
	}

	@Override
	public List<Map<String, String>> selectApp(HttpSession session) {
		Collections.sort(apps, new Comparator<Map<String, String>>() {
		    public int compare(Map<String, String> r1, Map<String, String> r2) {
		    	return r1.get("name").toLowerCase().compareTo(r2.get("name").toLowerCase());
		    }
		  });
		return apps;
	}

	@Override
	public List<Map<String, String>> getAppDbNames(Integer appId, DbTypeEnum dbType) {
		List<Map<String, String>> dbNames = new ArrayList<Map<String, String>>();

		String key = appId + "_" + dbType.getValue();
		for (String k : appDbCache.keySet()) {
			if (k.startsWith(key)) {
				Map<String, String> entry = new HashMap<String, String>();
				String dbName = appDbCache.get(k).getDbName();
				entry.put("name", dbName);
				entry.put("value", dbName);
				dbNames.add(entry);
			}
		}

		return dbNames;
	}

	@Override
	public String getAppNameById(String appId){
		return appId2Name.get(appId);
	}
	@Override
	public List<ThreadPoolEntity> getThreadPoolCached() {
		return poolCached;
	}

	@Override
	public ThreadPoolEntity getAppThreadPool(String appId) {
		return appThreadPoolMap.get(appId);
	}

	@Override
	public Map<String, ThreadPoolEntity> getAppThreadPools() {
		return appThreadPoolMap;
	}

	public Map<String, ExecutorService> getExecutors() {
		return executors;
	}

	public Map<String, BlockingQueue<Runnable>> getThreadPoolQueues() {
		return threadPoolQueues;
	}

	class PriestThreadFactory implements ThreadFactory {
		final ThreadGroup group;
		final String namePrefix;
		volatile AtomicInteger threadNumber = new AtomicInteger(1);

		PriestThreadFactory(String poolName) {
			SecurityManager s = System.getSecurityManager();
			group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
			namePrefix = poolName + "-thread-";
		}

		public Thread newThread(Runnable r) {
			Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
			if (t.isDaemon())
				t.setDaemon(false);
			if (t.getPriority() != Thread.NORM_PRIORITY)
				t.setPriority(Thread.NORM_PRIORITY);
			return t;
		}
	}
}
