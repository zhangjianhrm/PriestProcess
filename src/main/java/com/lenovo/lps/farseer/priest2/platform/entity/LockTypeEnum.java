/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

/**
 * 数据库独占锁类型
 * 
 * @author niexm1
 * 
 */
public enum LockTypeEnum {
	C// 创建流程实例锁
	, L// 加载流程实例准备运行锁
	, R// 运行流程实例锁
	, J// 加载失败JOB锁
	, I// Hive Resource Dependent创建锁
}
