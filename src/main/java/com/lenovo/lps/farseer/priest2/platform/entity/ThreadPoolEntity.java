package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * 线程池对象
 * 
 * @author niexm1
 * 
 */
public class ThreadPoolEntity extends RequestParam {
	// 线程池ID，与应用绑定时使用
	private Integer poolId;
	// 线程池名称
	private String poolName;
	// 线程池初始大小
	private Integer corePoolSize;
	// 线程池最大线程数
	private Integer maxPoolSize;

	public Integer getPoolId() {
		return poolId;
	}

	public void setPoolId(Integer poolId) {
		this.poolId = poolId;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public Integer getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(Integer corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

}
