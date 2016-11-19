package com.lenovo.lps.farseer.priest2.platform.session.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.platform.service.CacheService;
import com.lenovo.lps.farseer.priest2.platform.session.SessionService;

public class SessionServiceImpl implements SessionService {

	@Autowired
	@Qualifier("cacheService")
	private CacheService cacheService;
	// minutes
	private int expiryTime = 60;

	private Date getExpiryDate() {
		Calendar calendar = Calendar.getInstance();
		long time = calendar.getTimeInMillis();
		time += expiryTime * 60 * 1000L;
		calendar.setTimeInMillis(time);
		return calendar.getTime();
	}

	public boolean sessionExists(String id) {
		return cacheService.keyExists(id);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSession(String id, boolean create) {
		Map<String, Object> session = (Map<String, Object>) cacheService.get(id);
		if (session == null) {
			if (create) {
				session = new HashMap<String, Object>(5);
				cacheService.set(id, session, getExpiryDate());
			}
		}
		return session;
	}

	public void saveSession(String id, Map<String, Object> session) {
		if (cacheService.keyExists(id)) {
			cacheService.replace(id, session, getExpiryDate());
		} else {
			cacheService.add(id, session, getExpiryDate());
		}
	}

	public void saveSession(String id, Map<String, Object> session, Date expiryDate) {
		if (cacheService.keyExists(id)) {
			cacheService.replace(id, session, expiryDate);
		} else {
			cacheService.add(id, session, expiryDate);
		}
	}

	public void removeSession(String id) {
		cacheService.delete(id);
	}

	@SuppressWarnings("unchecked")
	public void updateExpiryDate(String id) {
		Map<String, Object> session = (Map<String, Object>) cacheService.get(id);
		if (session != null) {
			cacheService.replace(id, session, getExpiryDate());
		}
	}

}
