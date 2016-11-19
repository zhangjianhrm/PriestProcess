package com.lenovo.lps.farseer.priest2.platform.entity;

public enum DataTransferModeEnum {
	// hive 到 mysql迁移
	H2M,
	// mysql数据迁移到hive
	M2H,
	// hive数据迁移到hdfs
	H2D,
	// hdfs数据迁移到hive
	D2H,
	// hive数据迁移到oracle
	H2O,
	// oracle数据迁移到hive
	O2H
}
