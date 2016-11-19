/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.dal;

import java.sql.SQLException;

/**
 * ID生成dao
 * 
 * @author niexm1
 * 
 */
public interface IdDao {
	/**
	 * 生成 task id
	 * 
	 * @return
	 */
	public Long genTaskId()  throws SQLException;

	/**
	 * 生成 process id
	 * 
	 * @return
	 */
	public Long genProcessId()  throws SQLException;
}
