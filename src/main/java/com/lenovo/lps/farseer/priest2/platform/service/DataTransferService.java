/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import com.lenovo.lps.farseer.priest2.platform.entity.DataTransferModeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;

/**
 * @author niexm1 数据迁移服务
 * 
 */
public interface DataTransferService {

	/**
	 * 数据迁移
	 * 
	 * @param transMode
	 *            数据迁移方式
	 * @param source
	 *            数据源,hive与mysql之间数据迁移为sql/hsql
	 * @param destination
	 *            迁移目的地
	 * 
	 * @param overWrite
	 *            是否覆盖已存在的目标数据标记
	 * @param dbEntity
	 *            mysql连接信息
	 * @param processId
	 *            流程id
	 * @param execDate
	 *            数据日期
	 */
	public void transferData(DataTransferModeEnum transMode, String source, String destination, boolean overWrite,
			DbEntity dbEntity, String processId, String execDate, Integer appId, String taskId);
}
