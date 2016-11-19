package com.lenovo.lps.farseer.priest2.platform.service;

import org.apache.hadoop.fs.Path;

import com.lenovo.lps.farseer.priest2.platform.entity.HdfsOpEnum;

/**
 * 提供HDFS操作
 * 
 * @author niexm1
 * 
 */
public interface HdfsService {
	/**
	 * hdfs文件操作
	 * 
	 * @param hdfsOp
	 * @param path
	 * @return
	 */
	public Object runHdfsOperator(HdfsOpEnum hdfsOp, String... path);

	/**
	 * 获取文件大小，当hdfsPath为dir时，获取其下所有文件大小
	 * 
	 * @param hdfsPath
	 * @return
	 */
	public Long getLen(Path hdfsPath);

	/**
	 * 获取本机文件大小，当path为DIR时，获取其下所有文件大小
	 * 
	 * @param path
	 * @return
	 */
	public Long getLocalLen(String path);
	
	/**
	 * 获取hdfs文件大小 支持正则
	 * 
	 * @param path
	 * @return
	 */
	public Long getFileSize(String path);
	
	/**
	 * 变更目录权限
	 * 
	 * @param path
	 * @return
	 */
	public void chmod777(String path);
	
	/**
	 * 判断文件是否存在
	 * 
	 * @param path
	 * @return
	 */
	public boolean fileExists(String path);
}
