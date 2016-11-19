package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.platform.dal.LockDao;
import com.lenovo.lps.farseer.priest2.platform.entity.LockTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.mapper.LockMapper;

public class LockDaoImpl implements LockDao {
	@Autowired
	private LockMapper lockMapper;

	@Override
	public boolean tryLock(LockTypeEnum lockType, Integer lockExpiredSeconds) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lockType", lockType.name());
		param.put("lockExpiredSeconds", lockExpiredSeconds);
		int updateRecords = lockMapper.tryLock(param);
		return updateRecords == 1;
	}

	@Override
	public boolean releaseLock(LockTypeEnum lockType) {
		int updateRecords = lockMapper.releaseLock(lockType.name());
		return updateRecords == 1;
	}

	@Override
	public boolean checkProcessInstanceCreated(String execDate) {
		Map<Object, Object> obj = lockMapper.checkProcessInstanceCreated(execDate);
		return obj != null && obj.size() > 0;
	}

	@Override
	public boolean tagProcessInstanceCreated(String execDate, boolean isSuccess) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("execDate", execDate);
		params.put("isSuccess", isSuccess ? "true" : "false");
		int updateRecords = lockMapper.tagProcessInstanceCreated(params);
		return updateRecords == 1;
	}

	@Override
	public Map<String, String> getLockInfo(LockTypeEnum lockType) {
		return lockMapper.getLockInfo(lockType.name());
	}

	@Override
	public void rebackLock(Map<String, String> lockInfo) {
		lockMapper.rebackLock(lockInfo);
	}

	@Override
	public void initLockI() {
		lockMapper.initialLockI();
	}
}
