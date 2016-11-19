package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

public interface ProcessDrawService {
	String getSvgXml(HttpSession session, String processId, String queryType, String appId, String scheduleDate, boolean isRun, int depth) throws UnsupportedEncodingException;
}
