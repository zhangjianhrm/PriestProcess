/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.Set;

/**
 * @author zhongdg1
 *
 */
public interface JobKillerService {

	/**
	 * 
	 * @param jobIds
	 */
	public void killJob(Set<String> jobIds);

	public void killHadoopJob(Integer processId, String execDate);
	
}
