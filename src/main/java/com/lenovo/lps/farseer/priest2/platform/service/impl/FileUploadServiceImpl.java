/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.service.FileUploadService;

/**
 * @author niexm1
 * 
 */
public class FileUploadServiceImpl implements FileUploadService {
	private final Logger logger = Logger.getLogger(FileUploadServiceImpl.class);

	// 上传文件路径,临时文件目录
	private String tmpFilePath = System.getProperty("java.io.tmpdir");

	@Override
	public String uploadTmpFile(String fileName, InputStream is) throws IOException {
		// 上传文件存储目录
		File storeDir = new File(tmpFilePath);
		// 创建目录
		if (!storeDir.exists()) {
			Assert.isTrue(storeDir.mkdirs(), "Failed to create the upload directory:" + storeDir);
		}

		// 文件名规则:system ticks_随机数_上传文件名,避免文件被覆盖
		File storeFile = new File(storeDir, System.currentTimeMillis() + "_" + new Random().nextInt(9999) + "_" + fileName);
		OutputStream os = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(storeFile);
			os = new BufferedOutputStream(fos);
			byte[] buffer = new byte[4096];// 4k读写buffer
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			fos.close();
			is.close();
			return storeFile.getName();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		} finally {
			if (os != null) {
				os.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (is != null) {
				is.close();
			}

		}

	}

	@Override
	public void downloadFile(OutputStream toClient, String downLoadFilePath) throws IOException {
		BufferedInputStream bis = null;
		OutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 以流的形式下载文件。
			fis = new FileInputStream(downLoadFilePath);
			bis = new BufferedInputStream(fis);
			fos = new BufferedOutputStream(toClient);
			byte[] buffer = new byte[8192];
			int count = 0;
			while ((count = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		} finally {
			if (fos != null) {
				fos.close();
			}
			if (bis != null) {
				bis.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}

	@Override
	public String uploadFile(String fileName, InputStream is) throws IOException {
		// 上传文件存储目录
		File storeDir = new File(ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/"));
		// 创建目录
		if (!storeDir.exists()) {
			Assert.isTrue(storeDir.mkdirs(), "Failed to create the upload directory:" + storeDir);
		}

		// 文件名规则:s上传文件名_uuid,避免文件被覆盖
		File storeFile = new File(storeDir, fileName + "_" + Math.abs(UUID.randomUUID().getMostSignificantBits()));
		OutputStream os = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(storeFile);
			os = new BufferedOutputStream(fos);
			byte[] buffer = new byte[4096];// 4k读写buffer
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			return storeFile.getName();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		} finally {
			if (os != null) {
				os.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (is != null) {
				is.close();
			}

		}

	}

}
