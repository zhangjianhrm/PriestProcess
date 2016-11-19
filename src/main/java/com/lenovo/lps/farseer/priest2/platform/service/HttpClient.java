package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.HttpException;

public interface HttpClient {

	/**
	 * 发送HTTP请求，POST方法
	 * 
	 * @param uri
	 * @param paramsMap
	 * @return String 返回响应结果
	 * @throws IOException
	 * @throws HttpException
	 * @throws URISyntaxException
	 */
	String sendPost(String uri, Map<String, String> paramsMap) throws IOException, HttpException, URISyntaxException;

	/**
	 * 发送HTTP请求，POST方法,传json数据
	 * 
	 * @param uri
	 * @param paramsMap
	 * @param jsonEntity
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws URISyntaxException
	 */
	String sendPost(String uri, Map<String, String> paramsMap, String jsonEntity) throws IOException, HttpException,
			URISyntaxException;
}
