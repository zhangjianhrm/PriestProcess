package com.lenovo.lps.farseer.priest2.platform.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 集群概况bean
 * 
 * @author nazhiwei
 */
public class ClusterProfileEntity{
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 日期
	 */
	private Date scanDate;
	
	/**
	 * 存储新增量
	 */
	private long dataGrowth;
	
	/**
	 * 存储相对前一天的增量
	 */
	private long dataGrowthVsYday;
	
	/**
	 * 集群总空间
	 */
	private long clusterTotalSpace;
	
	/**
	 * 集群已使用空间
	 */
	private long clusterUsedSpace;
	
	public String getScanDate() {
		return (scanDate != null ? df.format(scanDate) : "");
	}

	public void setScanDate(Date scanDate) {
		this.scanDate = scanDate;
	}

	public long getDataGrowth() {
		return dataGrowth;
	}

	public void setDataGrowth(long dataGrowth) {
		this.dataGrowth = dataGrowth;
	}

	public long getDataGrowthVsYday() {
		return dataGrowthVsYday;
	}

	public void setDataGrowthVsYday(long dataGrowthVsYday) {
		this.dataGrowthVsYday = dataGrowthVsYday;
	}
	
 	public long getClusterTotalSpace() {
		return clusterTotalSpace;
	}

	public void setClusterTotalSpace(long clusterTotalSpace) {
		this.clusterTotalSpace = clusterTotalSpace;
	}

	public long getClusterUsedSpace() {
		return clusterUsedSpace;
	}

	public void setClusterUsedSpace(long clusterUsedSpace) {
		this.clusterUsedSpace = clusterUsedSpace;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
