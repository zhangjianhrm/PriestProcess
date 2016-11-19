/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * 流程调度类型 调度类型:O:只运行一次D:每日运行W:每周运行M:每月运行Q:每季运行Y:每年运行
 * 
 * @author niexm1
 * 
 */
public enum ScheduleTypeEnum {
	O// 只运行一次
	, I// 每分钟运行
	, H// 每小时运行
	, D// 每日运行
	, W// 每周运行
	, M// 每月运行
	, Q// 每季运行
	, Y// 每年运行
}
