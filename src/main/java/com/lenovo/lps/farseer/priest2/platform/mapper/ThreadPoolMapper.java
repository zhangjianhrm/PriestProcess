package com.lenovo.lps.farseer.priest2.platform.mapper;

import java.util.List;

import com.lenovo.lps.farseer.priest2.platform.entity.ThreadPoolEntity;

public interface ThreadPoolMapper extends Mapper {
	public List<ThreadPoolEntity> loadThreadPools();
}
