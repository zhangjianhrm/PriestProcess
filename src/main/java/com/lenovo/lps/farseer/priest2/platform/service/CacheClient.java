/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.Set;

/**
 * @author zhongdg1
 *
 */
public interface CacheClient {

	public Set<String> getRunningHadoopJobs(Integer processId, String execDate);
}
