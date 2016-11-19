package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.util.Date;

import com.lenovo.lps.farseer.priest2.platform.service.CacheService;

public class CacheServiceImpl implements CacheService {

	// @Autowired
	// private MemCachedClient memCachedClient;

	@Override
	public Object get(String key) {
		return null;
	}

	@Override
	public boolean set(String key, Object value) {
		return true;
	}

	@Override
	public boolean set(String key, Object value, Date date) {
		return true;
	}

	@Override
	public boolean add(String key, Object value, Date date) {
		return true;
	}

	@Override
	public boolean replace(String key, Object value, Date date) {
		return true;
	}

	@Override
	public boolean delete(String key) {
		return true;
	}

	@Override
	public boolean keyExists(String key) {
		return true;
	}
}
