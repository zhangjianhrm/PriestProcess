/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.Map;

import com.lenovo.lps.farseer.priest2.platform.entity.LockTypeEnum;

/**
 * 独占锁实现
 * 
 * @author niexm1
 * 
 */
public interface LockService {
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
	 * 标记实例是否已经创建
	 * 
	 * @param execDate
	 * @param isSuccess
	 * @return
	 */
	boolean tagProcessInstanceCreated(String execDate, boolean isSuccess);

	/**
	 * <pre>
	 * 多机部署时，限制单机调度
	 * 1.当有master,slave机器时，只有master机器才能调度
	 * 2.当只有master机器时，master机器调度
	 * 3.master挂，只有slave机器时，slave调度
	 * </pre>
	 * 
	 * @return
	 */
	boolean checkScheduleProcessToRun();

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
	 * 初始化hive resource dependence生成锁I
	 * 
	 */
	public void initialLockI();

}
