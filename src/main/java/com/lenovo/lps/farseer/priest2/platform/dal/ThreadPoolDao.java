/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.dal;

import java.util.List;

import com.lenovo.lps.farseer.priest2.platform.entity.ThreadPoolEntity;

/**
 * 线程池Dao类
 * @author niexm1
 *
 */
public interface ThreadPoolDao {
	public List<ThreadPoolEntity> loadThreadPools();
}
