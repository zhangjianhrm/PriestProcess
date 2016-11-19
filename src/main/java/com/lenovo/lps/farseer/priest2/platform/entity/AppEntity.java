package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * 应用信息
 * 
 */
public class AppEntity extends RequestParam {
	private String appId;
	private String appName;
	private String appDesc;
	private String appVars;
	private String appUser;
	// 应用调度时，对应的线程池ID
	private Integer threadPoolId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppVars() {
		return appVars;
	}

	public void setAppVars(String appVars) {
		this.appVars = appVars;
	}

	public String getAppUser() {
		return appUser;
	}

	public void setAppUser(String appUser) {
		this.appUser = appUser;
	}

	public Integer getThreadPoolId() {
		return threadPoolId;
	}

	public void setThreadPoolId(Integer threadPoolId) {
		this.threadPoolId = threadPoolId;
	}
	
	@Override
	public String toString() {
		return "AppEntity{appId:"+ appId+",appName:"+appName+"}";
}
}
