package com.lenovo.lps.farseer.priest2.common.util;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;

public class AuditLog {

	private static final Logger LOGGER = Logger.getLogger(AuditLog.class);

	public static void log(HttpSession session, String ...messages) {
		String user = "" ;
		if ( session != null && AccessSession.getAccessUser(session) != null){
			user = AccessSession.getAccessUser(session)  ;
		}
		if ( StringUtils.isEmpty(user)){
			user = "UNKOWN User";
		}
		LOGGER.info(user + ":" + StringUtils.join(messages, " "));
	}
	
	public static void log(String ...messages) {
		LOGGER.info(StringUtils.join(messages, " "));
	}
	
	public static void error(String message, Exception e) {
		LOGGER.error(message, e);
	}
}
