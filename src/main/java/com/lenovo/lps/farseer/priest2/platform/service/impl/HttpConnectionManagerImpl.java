package com.lenovo.lps.farseer.priest2.platform.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.lenovo.lps.farseer.priest2.platform.http.HttpConnectionManager;

public class HttpConnectionManagerImpl implements HttpConnectionManager {

    private HttpParams httpParams;
    private ThreadSafeClientConnManager connectionManager;
    private boolean isProxy;
    private String proxyIp, userName, password;
    private int proxyPort;

    /**
     * @param maxTotalConnections
     *            最大连接数
     * @param waitTimeout
     *            获取连接的最大等待时间
     * @param maxRouteConnections
     *            每个路由最大连接数
     * @param connectTimeout
     *            连接超时时间
     * @param httpPort
     *            http注册端口
     * @param sslPort
     *            https注册端口
     * @param isProxy
     *            是否使用代理
     */
    public HttpConnectionManagerImpl(int maxTotalConnections, int waitTimeout, int maxRouteConnections, int connectTimeout,
            int httpPort, int sslPort, boolean isProxy, String proxyIp, int proxyPort, String userName, String password) {
        httpParams = new BasicHttpParams();
        HttpConnectionParams.setSoTimeout(httpParams, waitTimeout);
        HttpConnectionParams.setConnectionTimeout(httpParams, connectTimeout);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", httpPort, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", sslPort, SSLSocketFactory.getSocketFactory()));
        connectionManager = new ThreadSafeClientConnManager(schemeRegistry);
        connectionManager.setMaxTotal(maxTotalConnections);
        connectionManager.setDefaultMaxPerRoute(maxRouteConnections);
        this.isProxy = isProxy;
        this.proxyIp = proxyIp;
        this.proxyPort = proxyPort;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public HttpClient getHttpClient() {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(connectionManager, httpParams);
        if (isProxy) {
            if (StringUtils.isNotEmpty(userName)) {
                defaultHttpClient.getCredentialsProvider().setCredentials(new AuthScope(proxyIp, proxyPort),
                        new UsernamePasswordCredentials(userName, password));
            } else {
                HttpHost host = new HttpHost(proxyIp, proxyPort);
                defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, host);
            }
        }
        return defaultHttpClient;
    }

}
