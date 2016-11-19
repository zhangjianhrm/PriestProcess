package com.lenovo.lps.farseer.priest2.platform.mapper;

import java.util.Map;

public interface LockMapper extends Mapper {
	/**
	 * 获取锁
	 * 
	 * @param param
	 * @return
	 */
	int tryLock(Map<String, Object> param);

	/**
	 * 释放锁
	 * 
	 * @param lockType
	 * @return
	 */
	int releaseLock(String lockType);

	/**
	 * 检查实例实例是否已经创建
	 * 
	 * @param execDate
	 * @return
	 */
	Map<Object, Object> checkProcessInstanceCreated(String execDate);

	/**
	 * 标记实例实例是否已经创建
	 * 
	 * @param exec_date
	 * @return
	 */
	int tagProcessInstanceCreated(Map<String, Object> params);

	/**
	 * 获取lock信息
	 * 
	 * @param name
	 * @return
	 */
	Map<String, String> getLockInfo(String name);

	/**
	 * 本次执行异常时，将锁信息重置为上一次成功释放时的锁信息
	 * 
	 * @param lockInfo
	 */
	void rebackLock(Map<String, String> lockInfo);

	/**
	 * 初始化hive resource dependence生成锁I
	 * 
	 */
	void initialLockI();
	
	/**
	 * 存储process短信
	 * 
	 */
	void saveSendMsg(Map<String, String> sendMsg);
	
	/**
	 * 获取手机发送短信数量
	 * 
	 */
	int phoneSendNum(Map<String, String> phoneMsg);
}
