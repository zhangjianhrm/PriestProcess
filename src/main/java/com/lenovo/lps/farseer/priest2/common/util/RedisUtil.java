package com.lenovo.lps.farseer.priest2.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import com.lenovo.lps.farseer.priest2.platform.entity.HostConfig;

public class RedisUtil {
    
    public static List<String> SPLIT_TASK_IDS = new ArrayList<String>();
    
    public static List<String> DEL_TASK_IDS = new ArrayList<String>();
    
	private static final Pattern patt = Pattern.compile("[0-9a-zA-Z_\\.]+:[0-9]+", Pattern.CASE_INSENSITIVE);
    
	public static List<JedisShardInfo> parseShardConfig(String servers) {
		if (servers == null || servers.length() == 0) {
			return null;
		}
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		String[] serverList = servers.split(";");
		for (int i = 0; i < serverList.length; i++) {
			Matcher m = patt.matcher(serverList[i]);
			if (m.matches()) {
				HostConfig config = new HostConfig(serverList[i]);
				JedisShardInfo si = new JedisShardInfo(config.getIpAddress(), 
						config.getPort());
				shards.add(si);
			}
		}

		return shards;
	}
	
	public static Map<String, String> parseWriteReadMap(String servers) {
		if (servers == null || servers.length() == 0) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		String[] serverList = servers.split(";");
		for (String wr: serverList) {
			String[] writeRead = wr.split(",");
			map.put(writeRead[0], writeRead[1]);
		}
		return map;
	}

	public static List<JedisShardInfo> parseShardConfig(String servers, int timeout) {
		if (servers == null || servers.length() == 0) {
			return null;
		}
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		String[] serverList = servers.split(";");
		for (int i = 0; i < serverList.length; i++) {
			Matcher m = patt.matcher(serverList[i]);
			if (m.matches()) {
				HostConfig config = new HostConfig(serverList[i]);
				JedisShardInfo si = new JedisShardInfo(config.getIpAddress(), config.getPort(), timeout);
				shards.add(si);
			}
		}

		return shards;
	}
	
	public static List<HostConfig> parseHostConfig(String servers) {
		List<HostConfig> hosts = new ArrayList<HostConfig>();
		if (CommUtils.isNotNull(servers)) {
			String[] serverList = servers.split(";");
			for (int i = 0; i < serverList.length; i++) {
				Matcher m = patt.matcher(serverList[i]);
				if (m.matches()) {
					HostConfig config = new HostConfig(serverList[i]);
					hosts.add(config);
				}
			}
		}
		return hosts;
	}

	public static void reconnectJedis(List<Jedis> jedisPool, int currentJedisIndex, Jedis jedis) {
		Client client = jedis.getClient();
		String host = client.getHost();
		int port = client.getPort();
		int timeout = client.getTimeout();
		synchronized (jedisPool) {
			try {
				jedis.disconnect();
			} catch (Exception e) {
			}
			jedisPool.set(currentJedisIndex, new Jedis(host, port, timeout));
		}
	}
	
	public static Map<String, Long> sumMap(Map<String, Long> sumMap, Map<String, String> map2) {
		for (Entry<String, String> entry : map2.entrySet()) {
			if (sumMap.containsKey(entry.getKey())) {
				sumMap.put(entry.getKey(), sumMap.get(entry.getKey()) + Long.parseLong(entry.getValue()));
			} else {
				sumMap.put(entry.getKey(), Long.parseLong(entry.getValue()));
			}
		}
		return sumMap;
	}
}
