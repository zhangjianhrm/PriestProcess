package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;

public class SysConfigEntity {
	private Integer priority;
	private String type;
	private String url;
	private String user;
	private String passwd;
	private String target;
	private String ip;
	private String port;
	private String dbName;
	private String principal;
	private List<Map<String, String>> redises = new ArrayList<Map<String, String>>();

	public List<Map<String, String>> getRedises() {
		if (type != null && SysConfigTypeEnum.REDIS.getValue() == Integer.parseInt(type)) {
			Map<String, String> ips;
			if (CommUtils.isNotNull(url)) {
				String[] strs = url.split(";"), ipport;
				for (String str: strs) {
					ipport = str.split(":");
					if (ipport.length == 2) {
						ips = new HashMap<String, String>();
						ips.put("ip", ipport[0]);
						ips.put("port", ipport[1]);
						redises.add(ips);
					}
				}
			}
		}
		return redises;
	}
	public Integer getPriority() {
		return priority == null ? 0:priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user == null ? "":user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	/**
	 * appId + dbType + dbName 为逻辑主键
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + priority;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SysConfigEntity other = (SysConfigEntity) obj;
		if (priority != other.priority)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DbEntity{priority:"+priority+",type:"+type+",url:"+url+"}";
}
}
