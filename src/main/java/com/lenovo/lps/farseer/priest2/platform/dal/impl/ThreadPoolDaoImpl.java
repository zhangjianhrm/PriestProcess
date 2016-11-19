package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import java.util.List;

import javax.annotation.Resource;

import com.lenovo.lps.farseer.priest2.platform.dal.ThreadPoolDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ThreadPoolEntity;
import com.lenovo.lps.farseer.priest2.platform.mapper.ThreadPoolMapper;

public class ThreadPoolDaoImpl implements ThreadPoolDao {
	@Resource
	private ThreadPoolMapper threadPoolMapper;

	@Override
	public List<ThreadPoolEntity> loadThreadPools() {
		return threadPoolMapper.loadThreadPools();
	}

}
