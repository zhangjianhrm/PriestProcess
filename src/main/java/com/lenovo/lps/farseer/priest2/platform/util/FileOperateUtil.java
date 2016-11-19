package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

public final class FileOperateUtil {
	private final static Logger logger = Logger.getLogger(FileOperateUtil.class);

	/**
	 * 工具类不应该被实例化使用
	 */
	private FileOperateUtil() {
	}

	/**
	 * 将解压后的文件进行重命名
	 * 
	 * @param name
	 * @return
	 */
	private static String rename(String name) {
		// 抹去文件名的随机数前缀
		String realFileName = StringUtil.getRealFileName(name);
		// 重新生成文件名，增加随机数前缀
		return System.currentTimeMillis() + "_" + new Random().nextInt(9999) + "_" + realFileName;
	}

	/**
	 * 字符串生成文件
	 * 
	 * @param filePath
	 * @param content
	 * @throws IOException
	 */
	public static void string2File(String filePath, String content) throws IOException {
		// 生成文件
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
			bw.write(content);
		} finally {
			if (bw != null) {
				bw.close();
			}

		}
	}

	/**
	 * 文件生成字符串
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String file2String(String filePath) throws IOException {
		BufferedReader br = null;
		StringBuilder content = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			String line = "";
			while (line != null) {
				line = br.readLine();
				content.append(line);
			}

		} finally {
			if (br != null) {
				br.close();
			}
		}

		return content.toString();
	}

	/**
	 * 生成文件绝对路径
	 * 
	 * @param directory
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String generateFileAbsolutePath(String directory, String fileName) throws IOException {
		// 生成文件的絕對路徑
		return (new File(directory, fileName)).getCanonicalPath();
	}

	/**
	 * 压缩文件操作
	 * 
	 * @param uploadDir
	 * @param zipFileName
	 * @param filePaths
	 * @return
	 * @throws IOException
	 */
	public static String zipFilesOperation(String tmpDir, String zipFileName, Map<String, String> filePaths) throws IOException {
		// 压缩文件的保存绝对路径
		String zipFilePath = generateFileAbsolutePath(tmpDir, zipFileName);

		ZipOutputStream out = null;
		InputStream in = null;
		try {
			byte buffer[] = new byte[8192];
			// 声明输出zip流
			out = new ZipOutputStream(new File(zipFilePath));

			for (Entry<String, String> filePathEntry : filePaths.entrySet()) {
				String filePath = filePathEntry.getKey();
				String name = filePathEntry.getValue();
				ZipEntry e = new ZipEntry(name);
				out.putNextEntry(e);
				in = new FileInputStream(filePath);
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
				out.closeEntry();
				in.close();
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		return zipFilePath;
	}

	/**
	 * 解压文件操作
	 * 
	 * @param tmpDir
	 * @param zipFileName
	 * @return fileNames：key为压缩包中解压前原文件名，value为解压出的文件名
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> unzipFileOperationg(String tmpDir, String zipFileName) throws IOException {
		Map<String, String> fileNames = new HashMap<String, String>();
		String zipFilePath = generateFileAbsolutePath(tmpDir, zipFileName);

		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			ZipFile zipFile = new ZipFile(zipFilePath);
			Enumeration<ZipEntry> entries = zipFile.getEntries();
			while (entries.hasMoreElements()) {
				ZipEntry zipEntry = entries.nextElement();
				String oldFileName = zipEntry.getName();
				String newFileName = rename(oldFileName);
				fileNames.put(oldFileName, newFileName);
				File temp = new File(tmpDir, newFileName);
				File parentFile = temp.getParentFile();
				if (parentFile != null && !parentFile.isDirectory()) {
					boolean ret = parentFile.mkdirs();
					if (!ret) {
						logger.warn("Create parent directory failed");
					}
				}
				bos = new BufferedOutputStream(new FileOutputStream(temp));
				// 通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
				bis = new BufferedInputStream(zipFile.getInputStream(zipEntry));
				int len = 0;
				while ((len = bis.read()) != -1) {
					bos.write(len);
				}
				bos.close();
				bis.close();
			}
			zipFile.close();
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (bis != null) {
				bis.close();
			}
		}
		return fileNames;
	}

	/**
	 * 刪除多個文件
	 * 
	 * @param directory
	 * @param fileNames
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static int removeFiles(String directory, List<String> fileNames) throws InterruptedException, IOException {
		int count = 0;
		for (String fileName : fileNames) {
			File file = new File(directory, fileName);
			boolean ret = FileUtils.deleteQuietly(file);
			if (!ret) {
				logger.warn("Delete file failed.");
			}
			if (!file.exists()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param directory
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static boolean removeFile(String directory, String fileName) throws IOException {
		File file = new File(directory, fileName);
		return file.delete();
	}

	/**
	 * 在系统退出时删除单个文件
	 * 
	 * @param directory
	 * @param fileName
	 * @throws IOException
	 */
	public static void tagRemoveFile(String directory, String fileName) throws IOException {
		File file = new File(directory, fileName);
		file.deleteOnExit();
	}

	/**
	 * 将临时文件从tmpDir移动到uploadDir
	 * 
	 * @param srcDir
	 * @param destDir
	 * @param filesOfMoves
	 * @return
	 * @throws IOException
	 */
	public static int moveFiles(String srcDir, String destDir, List<String> filesOfMoves) throws IOException {
		int count = 0;
		for (String filesOfMove : filesOfMoves) {
			File destFile = new File(destDir, filesOfMove);
			File srcFile = new File(srcDir, filesOfMove);
			FileUtils.moveFile(srcFile, destFile);
			count++;
		}
		return count;
	}

}
