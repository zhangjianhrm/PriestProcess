/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

/**
 * 运行java代码
 * 
 * @author niexm1
 * 
 */
public interface JavaService {
	/**
	 * 运行java代码
	 * 
	 * @param jarOrClassFile
	 * @param className
	 * @param methodName
	 * @param args
	 * @return
	 */
	public void runJavaMethod(String jarOrClassFile, String className, String methodName, String args, String user);
}
