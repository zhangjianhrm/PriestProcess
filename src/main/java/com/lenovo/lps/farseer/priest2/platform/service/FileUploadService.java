/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件上传
 * 
 * @author niexm1
 * 
 */
public interface FileUploadService {
	/**
	 * 文件上传
	 * 
	 * @param fileName
	 * @param is
	 * @return
	 */
	public String uploadTmpFile(String fileName, InputStream is) throws IOException;

	/**
	 * 文件下载
	 * 
	 * @param response
	 * @param directory
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public void downloadFile(OutputStream toClient, String downLoadPath) throws IOException;

	/**
	 * 文件上传
	 * 
	 * @param fileName
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public String uploadFile(String fileName, InputStream is) throws IOException;
}
