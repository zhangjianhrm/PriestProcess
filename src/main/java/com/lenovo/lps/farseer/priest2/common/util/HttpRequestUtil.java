package com.lenovo.lps.farseer.priest2.common.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;


/**
 * 
 * @author chenfei4
 * 
 */
public final class HttpRequestUtil {
	private static final Logger LOG = Logger.getLogger(HttpRequestUtil.class);
	private static int CONNECT_TIMEOUT = 5000;

	private HttpRequestUtil() {
	}
	
	 /**
     * Trust every server - dont check for any certificate
     */
    public static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[] {};
                    }
 
                    public void checkClientTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }
 
                    public void checkServerTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }
                }
        };
     
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public static String httpGetSend(String url) {
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECT_TIMEOUT);
		HttpMethod getMethod = new GetMethod(url);
	    // 设置 get 请求超时为 5 秒
	    getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, CONNECT_TIMEOUT);
	    // 设置请求重试处理，用的是默认的重试处理：请求三次
	    getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,	new DefaultHttpMethodRetryHandler());
		String result = null;
		try {
			trustAllHosts();
			int statuCode = httpClient.executeMethod(getMethod);
			if (statuCode == 200) {
				result =  getMethod.getResponseBodyAsString();
			} else {
				LOG.warn("Bad Request " + url + ", Response status is " + statuCode);
			}
		} catch (Exception e) {
			LOG.error("Send request to " + url + " error", e);
		} finally {
			// 关闭连接
			getMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return result;
	}
	
	
	public static String retryHttpGetSend(String url, int retryTimes) {
		String result = null;
		if (retryTimes < 3) {
			result = httpGetSend(url);
			if (result == null) {
				result = retryHttpGetSend(url, retryTimes + 1);
			}
		}
		return result;
	}
	
	public static String retryHttpSend(String url, Map<String, Object> propsMap, String jsonEntity, int retryTimes) {
		String result = null;
		if (retryTimes < 3) {
			result = httpSend(url, propsMap, jsonEntity);
			if (result == null) {
				result = retryHttpSend(url, propsMap, jsonEntity, retryTimes + 1);
			}
		}
		return result;
	}

	public static String httpSend(String url, Map<String, Object> propsMap, String jsonEntity) {
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECT_TIMEOUT);
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, CONNECT_TIMEOUT);
		 // 设置请求重试处理，用的是默认的重试处理：请求三次
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,	new DefaultHttpMethodRetryHandler());
		try {
			if (propsMap != null && propsMap.size() > 0) {
				if ("json".equals(jsonEntity)) {
					packJsonParams(postMethod, propsMap);
				} else {
					packParams(postMethod, propsMap);
				}
			}
			return excute(httpClient, postMethod, url);
		} catch (Exception e) {
			LOG.error("Send request to " + url + " error", e);
			return null;
		} finally {
			// 关闭连接
			postMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
	}

	private static String excute(HttpClient httpClient, PostMethod postMethod, String url) throws PriestPlatformException {
		// 发送请求
		int statuCode;
		try {
			statuCode = httpClient.executeMethod(postMethod);
			if (statuCode == 200) {
				String result = postMethod.getResponseBodyAsString();
				return CommUtils.isNotNull(result) ? result:"";
			}
			LOG.warn("Bad Request " + url + ", Response status is " + statuCode);
			return null;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	private static void packJsonParams(PostMethod postMethod, Map<String, Object> propsMap) throws PriestPlatformException {
		// 参数设置
		StringRequestEntity entity;
		try {
			entity = new StringRequestEntity(JacksonUtils.writeJson(propsMap), "application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			postMethod.getParams().setContentCharset("UTF-8");
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
	
	private static void packParams(PostMethod postMethod, Map<String, Object> propsMap) {
		// 参数设置
		NameValuePair[] postData = new NameValuePair[propsMap.size()];
		Set<String> keySet = propsMap.keySet();
		int index = 0;
		for (String key : keySet) {
			postData[index++] = new NameValuePair(key, propsMap.get(key).toString());
		}
		postMethod.addParameters(postData);
		postMethod.getParams().setContentCharset("UTF-8");
	}
}
