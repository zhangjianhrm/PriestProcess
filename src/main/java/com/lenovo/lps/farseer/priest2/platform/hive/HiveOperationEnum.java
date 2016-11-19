/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.hive;

/**
 * Hive操作类型
 * 
 * @author niexm1
 * 
 */
public enum HiveOperationEnum {
	QUIT, // quit/exit
	SOURCE, // source执行脚本
	SHELL, // !shell cmd
	LIST, // 浏览session 中add jas /files /archives
	SET, // set 属性操作
	DFS, // DFS文件系统操作
	ADD, // add jar /file /archive操作
	DELETE, // delete jar /file /archive操作
	EXPLAIN, // explain sql
	LOAD, // load data inpath 'xxx' [overwrite] into table
	EXPORT, // export table to path
	IMPORT, // import tableOrPartion from path
	DDL, // database 操作,table操作,index操作 ,lock table,权限操作(create role,grant等)
	FUNC, // create function,drop function
	DML_INSERT, // insert操作
	DML_SELECT, // select操作
	CREATE, // create操作
	DROP, // drop操作
	ALTER, // alter操作
}
