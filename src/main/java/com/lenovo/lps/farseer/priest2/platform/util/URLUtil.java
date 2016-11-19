package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.apache.log4j.Logger;

public final class URLUtil {
	private final static Logger logger = Logger.getLogger(URLUtil.class);
	
	/**
	 * 工具类不应该被实例化使用
	 */
	private URLUtil(){}
	
	/**
	 * 取得当前类所在的文件
	 * 
	 * @param clazz
	 * @return
	 */
	public static File getClassFile(Class<?> clazz) {
		URL path = clazz.getResource(clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + ".class");
		if (path == null) {
			String name = clazz.getName().replaceAll("[.]", "/");
			path = clazz.getResource("/" + name + ".class");
		}
		return new File(path.getFile());
	}

	/**
	 * 同getClassFile 解决中文编码问题
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getClassFilePath(Class<?> clazz) {
		try {
			return java.net.URLDecoder.decode(getClassFile(clazz).getAbsolutePath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			return "";
		}
	}

	/**
	 * 取得当前类所在的ClassPath目录
	 * 
	 * @param clazz
	 * @return
	 */
	public static File getClassPathFile(Class<?> clazz) {
		File file = getClassFile(clazz);
		for (int i = 0, count = clazz.getName().split("[.]").length; i < count; i++) {
			file = file.getParentFile();
		}
		if (file.getName().toUpperCase().endsWith(".JAR!")) {
			file = file.getParentFile();
		}
		return file;
	}

	/**
	 * 
	 * 同getClassPathFile 解决中文编码问题
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getClassPath(Class<?> clazz) {
		try {
			return java.net.URLDecoder.decode(getClassPathFile(clazz).getAbsolutePath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			return "";
		}
	}

}
