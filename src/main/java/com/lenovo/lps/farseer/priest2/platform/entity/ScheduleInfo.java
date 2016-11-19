/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.Date;

/**
 * 调度信息
 * 
 * @author niexm1
 * 
 */
public class ScheduleInfo {
	// 下次调度日期
	private Date nextScheduleDate;
	// 数据日期
	private String execDate;

	public Date getNextScheduleDate() {
		if (nextScheduleDate == null) {
			return null;
		} else {
			return (Date) nextScheduleDate.clone();
		}
	}

	public void setNextScheduleDate(Date nextScheduleDate) {
		if (nextScheduleDate == null) {
			this.nextScheduleDate = null;
		} else {
			this.nextScheduleDate = (Date) nextScheduleDate.clone();
		}
	}

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

}
