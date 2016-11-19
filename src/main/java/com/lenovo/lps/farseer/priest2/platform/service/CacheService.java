package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.Date;

public interface CacheService {
	/**
	 * 从cache中获取数据
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * cache数据
	 * 
	 * @param key
	 * @param value
	 */
	public boolean set(String key, Object value);

	public boolean set(String key, Object value, Date date);

	public boolean add(String key, Object value, Date date);

	public boolean replace(String key, Object value, Date date);

	public boolean delete(String key);

	public boolean keyExists(String key);
}
