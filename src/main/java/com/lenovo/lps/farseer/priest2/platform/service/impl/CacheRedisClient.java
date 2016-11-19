package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.hadoop.conf.Configuration;

import redis.clients.jedis.Jedis;

import com.lenovo.lps.farseer.priest.job.hooker.RedisAbstract;
import com.lenovo.lps.farseer.priest2.common.util.RedisUtil;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.HostConfig;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.service.CacheClient;

public class CacheRedisClient implements CacheClient {
	static final String RUNNING_JOBID_PRIFIX = "rjid_";
	static final String COMPLETED_JOBID_PRIFIX = "cjid_";
	static final String COUNTER_TASKID_PRIFIX = "cnt_";
	static final String LOG_TASKID_PRIFIX = "tlog_";
	
	static final String UNDERLINE = "_";
	static final String TERMINAL = "\n";
	
	

	final static String priest_param_tid = "priest_param_tid";
	final static String priest_param_execdate = "priest_param_execdate";
	static final String priest_param_pid = "priest_param_pid";
	
	@Resource
	private ApplicationDao applicationDao;
	
	final static String redis_servers = "redis_servers";
	
	@Override
	public Set<String> getRunningHadoopJobs(Integer processId, String execDate) {
		Configuration conf = new Configuration();
		conf.set(priest_param_pid, processId.toString());
		conf.set(priest_param_tid, "nil");
		conf.set(priest_param_execdate, execDate);
		String masterRedisServers = "", masterPort = "", slaveRedisServers = "", slavePort= "";
		SysConfigEntity config = new SysConfigEntity();
		config.setType(String.valueOf(SysConfigTypeEnum.REDIS.getValue()));
		List<SysConfigEntity> scs =  applicationDao.getSysConfig(config);
		List<HostConfig> servers = null;
		if (scs != null && scs.size() > 0) {
			servers = RedisUtil.parseHostConfig(scs.get(0).getUrl());
			if (servers.size() == 1) {
				masterRedisServers = servers.get(0).getIpAddress();
				masterPort = String.valueOf(servers.get(0).getPort());
			} else if (servers.size() > 1) {
				masterRedisServers = servers.get(0).getIpAddress();
				masterPort = String.valueOf(servers.get(0).getPort());
				slaveRedisServers = servers.get(1).getIpAddress();
				slavePort = String.valueOf(servers.get(1).getPort());
			}
		}
		conf.set("redis.server.ip", masterRedisServers);
		conf.set("redis.server.port", masterPort);
		conf.set("redis.slave.server.ip", slaveRedisServers);
		conf.set("redis.slave.server.port", slavePort);
		conf.set("redis.max.total", "20");
		conf.set("redis.max.idel", "10");
		conf.set("redis.max.waitmillis", "1000");
		return popRunningJobs(processId.toString(), execDate, conf);
	}

	private Set<String> popRunningJobs(final String processId, final String execDate, Configuration conf) {
		final Set<String> sets = new HashSet<String>();
		new RedisAbstract(conf) {
			@Override
			public void operateRedis(Jedis redis) {
				String pattern = new StringBuffer().append(RUNNING_JOBID_PRIFIX).append(processId).append(UNDERLINE).append(execDate).append(UNDERLINE).append("*").toString();
				Set<String> keys = redis.keys(pattern);
				for(String key : keys) {
					sets.addAll(redis.smembers(key));
					redis.expire(key, 1);
				}
			}
		}.doWork();
		
		return sets;
		
	}
}
