/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.dal;

import java.util.Map;

import com.lenovo.lps.farseer.priest2.platform.entity.LockTypeEnum;

/**
 * 独占锁DB实现
 * 
 * @author niexm1
 * 
 */
public interface LockDao {
	/**
	 * 获取锁 ,锁获取成功场景:1.类型锁未被占用;2.类型锁被占用,时间超lockExpiredSeconds,视为锁过期
	 * 
	 * @param lockType
	 * @param lockExpiredSeconds
	 *            锁最长时间 ,单位:秒
	 * @return
	 */
	public boolean tryLock(LockTypeEnum lockType, Integer lockExpiredSeconds);

	/**
	 * 释放锁
	 * 
	 * @param lockType
	 * @return
	 */
	boolean releaseLock(LockTypeEnum lockType);

	/**
	 * 检查流程实例是否已经创建
	 * 
	 * @param execDate
	 * @return
	 */
	boolean checkProcessInstanceCreated(String execDate);

	/**
	 * 标记实例实例是否已经创建
	 * 
	 * @param execDate
	 * @return
	 */
	boolean tagProcessInstanceCreated(String execDate, boolean isSuccess);

	/**
	 * 获取lock信息
	 * 
	 * @param lockType
	 * @return
	 */
	Map<String, String> getLockInfo(LockTypeEnum lockType);

	/**
	 * 本次执行异常时，将锁信息重置为上一次成功释放时的锁信息
	 * 
	 * @param lockInfo
	 */
	public void rebackLock(Map<String, String> lockInfo);

	/**
	 * 初始化hive resource dependen生成锁I
	 */
	public void initLockI();
}
