package com.lenovo.lps.farseer.priest2.platform.entity;

public enum StatusEnum {
	// 等待执行
	W,
	// 内存排队
	Q,
	// 正在执行
	R,
	// 执行成功
	S,
	// 执行失败
	F,
	// 取消执行
	C,
	//暂缓执行
	H
}
