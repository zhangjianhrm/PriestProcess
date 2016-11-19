package com.lenovo.lps.farseer.priest2.platform.entity;

public class DbEntity extends RequestParam {
	private Integer appId;
	private String url;
	private String appIds;
	private String userName;
	private String password;
	private String driverClassName;
	private String dbName;
	private String dbType;
	private String appName;
	private String ip;
	private String port;
	private String realDbName;
	private String connectType;
	private String serviceName;
	private String failover;
	private String loadBalance;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppIds() {
		return appIds;
	}

	public void setAppIds(String appIds) {
		this.appIds = appIds;
	}

	/**
	 * appId + dbType + dbName 为逻辑主键
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appId;
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
		result = prime * result + ((dbType == null) ? 0 : dbType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DbEntity other = (DbEntity) obj;
		if (appId != other.appId)
			return false;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!dbName.equals(other.dbName))
			return false;
		if (dbType == null) {
			if (other.dbType != null)
				return false;
		} else if (!dbType.equals(other.dbType))
			return false;
		return true;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRealDbName() {
		return realDbName;
	}

	public void setRealDbName(String realDbName) {
		this.realDbName = realDbName;
	}

	public String getConnectType() {
		return connectType;
	}

	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getFailover() {
		return failover;
	}

	public void setFailover(String failover) {
		this.failover = failover;
	}

	public String getLoadBalance() {
		return loadBalance;
	}

	public void setLoadBalance(String loadBalance) {
		this.loadBalance = loadBalance;
	}

	@Override
	public String toString() {
		return "DbEntity{appId:"+appId+",dbName:"+dbName+",dbType:"+dbType+"}";
}
}
