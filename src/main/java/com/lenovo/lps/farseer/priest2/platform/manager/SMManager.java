package com.lenovo.lps.farseer.priest2.platform.manager;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpException;

public interface SMManager {

	boolean sendMessage(String context) throws IOException, HttpException, URISyntaxException;

	/**
	 * 发送短信
	 * 
	 * @param phoneNumbers
	 *            多个手机号码用,分隔
	 * @param context
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws URISyntaxException
	 */
	boolean sendMessage(String ipAddr, String phoneNumbers, String context) throws IOException, HttpException, URISyntaxException;
}
