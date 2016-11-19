/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lenovo.lps.farseer.priest2.platform.dal.LockDao;
import com.lenovo.lps.farseer.priest2.platform.entity.LockTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.service.LockService;

/**
 * @author niexm1
 * 
 */
public class LockServiceImpl implements LockService {
	@Autowired
	private LockDao lockDao;

	@Override
	public Map<String, String> getLockInfo(LockTypeEnum lockType) {
		return lockDao.getLockInfo(lockType);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean tryLock(LockTypeEnum lockType, Integer lockExpiredSeconds) {
		return lockDao.tryLock(lockType, lockExpiredSeconds);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean releaseLock(LockTypeEnum lockType) {
		return lockDao.releaseLock(lockType);
	}

	@Override
	public boolean checkProcessInstanceCreated(String execDate) {
		return lockDao.checkProcessInstanceCreated(execDate);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean tagProcessInstanceCreated(String execDate, boolean isSuccess) {
		return lockDao.tagProcessInstanceCreated(execDate, isSuccess);
	}

	@Override
	public boolean checkScheduleProcessToRun() {
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void rebackLock(Map<String, String> lockInfo) {
		lockDao.rebackLock(lockInfo);
	}

	@Override
	public void initialLockI() {
		lockDao.initLockI();
	}

}
