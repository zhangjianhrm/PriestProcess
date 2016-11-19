package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.platform.http.HttpConnectionManager;
import com.lenovo.lps.farseer.priest2.platform.service.HttpClient;

public class HttpClientImpl implements HttpClient {
	private static Logger logger = Logger.getLogger(HttpClientImpl.class);

	@Autowired
	@Qualifier("httpConnectionManager")
	private HttpConnectionManager httpConnectionManager;

	@Override
	public String sendPost(String uri, Map<String, String> paramsMap) throws IOException, HttpException, URISyntaxException {
		return send("POST", uri, paramsMap, null);
	}

	@Override
	public String sendPost(String uri, Map<String, String> paramsMap, String jsonEntity) throws IOException, HttpException,
			URISyntaxException {
		return send("POST", uri, paramsMap, jsonEntity);
	}

	protected String send(final String method, String uri, Map<String, String> paramsMap, String jsonEntity)
			throws URISyntaxException, ClientProtocolException, IOException {
		org.apache.http.client.HttpClient httpClient = httpConnectionManager.getHttpClient();
		HttpEntityEnclosingRequestBase request = new HttpEntityEnclosingRequestBase() {
			@Override
			public String getMethod() {
				return method;
			}
		};
		request.setURI(new URI(uri));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : paramsMap.entrySet()) {
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		if (!params.isEmpty()) {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
			request.setEntity(urlEncodedFormEntity);
		}
		if (null != jsonEntity) {
			HttpEntity httpEntity = new StringEntity(jsonEntity, "UTF-8");
			request.setEntity(httpEntity);
		}
		HttpResponse response = httpClient.execute(request);
		String entityStr = null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			entityStr = StringUtils.trim(EntityUtils.toString(entity));
		}
		logger.info("<< Response: " + entityStr);
		return entityStr;
	}

}
