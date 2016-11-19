package com.lenovo.lps.farseer.priest2.platform.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.RedisUtil;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class RedisSourceManager{
	private static final Logger LOGGER = Logger.getLogger(RedisSourceManager.class);
	public static final int DB1 = 1;
	public static final int DEFAULT_DB = 0;

	private String servers;

	private int poolTimeout;

	private int poolMaxIdle;

	private ShardedJedisPool shardedJedisPool;
	
	@Resource
	private ApplicationDao applicationDao;

	private List<Jedis> jedisPool = new ArrayList<Jedis>();

	public RedisSourceManager(){
//		initParam();
	}
	
	@PostConstruct
	private void initParam() {
		SysConfigEntity config = new SysConfigEntity();
		config.setType(String.valueOf(SysConfigTypeEnum.REDIS.getValue()));
		List<SysConfigEntity> scs =  applicationDao.getSysConfig(config);
		if (scs != null && scs.size() > 0) {
			servers = scs.get(0).getUrl();
			poolMaxIdle = StringUtil.parseInt(60);
			poolTimeout = StringUtil.parseInt(60);
		}
	}

	public void init() {
		if (CommUtils.isNotNull(servers)) {
			JedisPoolConfig poolConfig = new JedisPoolConfig();
			poolConfig.setMaxIdle(poolMaxIdle);
			List<JedisShardInfo> jedisShardInfoList = RedisUtil.parseShardConfig(servers, poolTimeout);
			shardedJedisPool = new ShardedJedisPool(poolConfig, jedisShardInfoList);

			Jedis jedis = null;
			if (jedisShardInfoList == null) {
				return;
			}
			for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
				jedis = new Jedis(jedisShardInfo);
				jedisPool.add(jedis);
			}
		}
	}

	
	public List<Jedis> getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(List<Jedis> jedisPool) {
		this.jedisPool = jedisPool;
	}

	public String get(String key) {
		String info = "";
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = getShardedJedis();
			Jedis jedis = shardedJedis.getShard(key);
			info = jedis.get(key);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (shardedJedis != null) {
				returnShardedJedisResource(shardedJedis);
			}
		}
		return info;
	}
	
	public List<String> lrange(String key) {
		List<String> infos = new ArrayList<String>();
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = getShardedJedis();
			Jedis jedis = shardedJedis.getShard(key);
			infos = jedis.lrange(key, 0, -1);
			
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (shardedJedis != null) {
				returnShardedJedisResource(shardedJedis);
			}
		}
		return infos;
	}
	
	public Set<String> smembers(String key) {
		Set<String> infos = new HashSet<String>();
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = getShardedJedis();
			Jedis jedis = shardedJedis.getShard(key);
			infos = jedis.smembers(key);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (shardedJedis != null) {
				returnShardedJedisResource(shardedJedis);
			}
		}
		return infos;
	}
	

	public String set(String key, String info) {
		String value = "";
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = getShardedJedis();
			Jedis jedis = shardedJedis.getShard(key);
			value = jedis.set(key, info);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (shardedJedis != null) {
				returnShardedJedisResource(shardedJedis);
			}
		}
		return value;
	}

	public ShardedJedis getShardedJedis() {
		return shardedJedisPool.getResource();
	}

	public void returnShardedJedisResource(ShardedJedis resource) {
		shardedJedisPool.returnResource(resource);
	}
	
	public void resetMannager() {
		try {
			initParam();
			synchronized (jedisPool) {
				shutdownPool();
				init();
				LOGGER.info("Switch redis pool success: ");
			}
		} catch (Exception e) {
			LOGGER.error("Switch redis pool fail: ", e);
		}
	}
	

	private void shutdownPool() {
		if (shardedJedisPool != null) {
			shardedJedisPool.destroy();
		}
		for (Jedis jedis : jedisPool) {
			if (jedis != null) {
				jedis.disconnect();
			}
		}
		jedisPool.clear();
	}
}
