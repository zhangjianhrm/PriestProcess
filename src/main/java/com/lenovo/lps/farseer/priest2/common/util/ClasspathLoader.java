package com.lenovo.lps.farseer.priest2.common.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lenovo.lps.farseer.priest2.platform.util.FileUtils;

public final class ClasspathLoader {
	private static Map<String, MyURLClassLoader> loaderMap = new ConcurrentHashMap<String, MyURLClassLoader>();
	
	private static Map<String, Long> fileChange = new ConcurrentHashMap<String, Long>();
    
	public static MyURLClassLoader loadDircClasspath(String type) {
		
		return loadClasspath(FileUtils.getHiveLibPath(), type);
	}
	private static void closeLoder(MyURLClassLoader cl) {
		if (cl != null) {
			try {
				cl.close();
			} catch (IOException e) {}
		}
	}
	public static synchronized MyURLClassLoader loadClasspath(File file, String dbType) {
		if(!file.exists()){
			throw new RuntimeException(String.format("%s %s file don't exists, please contact the administator!", dbType, file));
		}
		
		MyURLClassLoader classloader  = loaderMap.get(dbType);
		if(classloader == null || isChange(dbType,file)){
			closeLoder(classloader);
			classloader = new MyURLClassLoader();
			AuditLog.log("loadClasspath classloader is change, and new one");
			if (file.isDirectory()) {
				File[] tmps = file.listFiles();
				for (File tmp : tmps) {
					if (!tmp.isDirectory() && tmp.getAbsolutePath().endsWith(".jar")) {
						String abPath = "";
						try {
							abPath = tmp.toURI().toURL().getPath();
							abPath.replaceAll(",", "%2C");
							abPath.replaceAll(";", "%3B");
							classloader.addURLFile(new URL("jar:file:"+abPath+"!/"));
						} catch (MalformedURLException e) {
						}
					}
				}
			} else {
				if (file.getAbsolutePath().endsWith(".jar")) {
					String abPath = "";
					try {
						abPath = file.toURI().toURL().getPath();
						abPath.replaceAll(",", "%2C");
						abPath.replaceAll(";", "%3B");
						classloader.addURLFile(new URL("jar:file:"+abPath+"!/"));
					} catch (MalformedURLException e) {
					}
				}
			}
			FileUtils.getJarPathForClass(ClasspathLoader.class);
			file = new File(FileUtils.getJarPathForClass(ClasspathLoader.class), "../lib_ext");
			if (file.isDirectory() && file.exists()) {
				File[] tmps = file.listFiles();
				for (File tmp : tmps) {
					if (!tmp.isDirectory() && tmp.getAbsolutePath().endsWith(".jar") && tmp.getName().startsWith("process-")) {
						String abPath = "";
						try {
							abPath = tmp.toURI().toURL().getPath();
							abPath.replaceAll(",", "%2C");
							abPath.replaceAll(";", "%3B");
							classloader.addURLFile(new URL("jar:file:"+abPath+"!/"));
						} catch (MalformedURLException e) {
						}
					}
				}
			}
			loaderMap.put(dbType, classloader);
		}
		return classloader;
	}
	
	private static boolean isChange(String dbType, File filePath){
		long lastModified = filePath.lastModified();
		Long cu = fileChange.get(dbType);
		boolean result = false;
		if(null==cu){
			AuditLog.log(String.format("%s %s record last modified time: %s", dbType, filePath, lastModified));
			fileChange.put(dbType, lastModified);
			result = true;
		} else if(lastModified != cu){
			AuditLog.log(String.format("%s %s record change last modified time from[%s] to[%s]", dbType, filePath, cu, lastModified));
			fileChange.put(dbType, lastModified);
			result = true;
		}
		FileUtils.getJarPathForClass(ClasspathLoader.class);
		File file = new File(FileUtils.getJarPathForClass(ClasspathLoader.class), "../lib_ext");
		if (file.exists()) {
			lastModified = file.lastModified();
			cu = fileChange.get("common");
			if(null==cu){
				AuditLog.log(String.format("%s %s record last modified time: %s", "common", file, lastModified));
				fileChange.put("common", lastModified);
				result = true;
			} else if(lastModified != cu){
				AuditLog.log(String.format("%s %s record change last modified time from[%s] to[%s]", "common", file, cu, lastModified));
				fileChange.put("common", lastModified);
				result = true;
			}
		}
		return result;
	}
}
