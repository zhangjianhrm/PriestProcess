package com.lenovo.lps.farseer.priest2.platform.session;

import java.util.Date;
import java.util.Map;

public interface SessionService {

	public boolean sessionExists(String id);

	public Map<String, Object> getSession(String id, boolean create);

	public void saveSession(String id, Map<String, Object> session);

	public void saveSession(String id, Map<String, Object> session, Date expiryDate);

	public void removeSession(String id);

	public void updateExpiryDate(String id);
}
