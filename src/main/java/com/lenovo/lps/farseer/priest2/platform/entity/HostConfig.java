package com.lenovo.lps.farseer.priest2.platform.entity;

public class HostConfig {
	private static final int DEFAULT_REDIS_PORT = 6379;
	private String ipAddress;
	private int port;

	public HostConfig(String host) {
		if (host == null || host.length() == 0) {
			return;
		}
		int index = host.indexOf(':');
		if (index == -1) {
			this.ipAddress = host.trim();
			this.port = DEFAULT_REDIS_PORT;
		} else {
			this.ipAddress = host.substring(0, index).trim();
			this.port = Integer.parseInt(host.substring(index + 1).trim());
		}
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getPort() {
		return port;
	}

	public String toString() {
		return new StringBuilder(ipAddress).append(":").append(port).toString();
	}

}
