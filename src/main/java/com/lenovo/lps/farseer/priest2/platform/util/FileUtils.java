package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.HdfsFile;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;

public abstract class FileUtils {
	private final static Logger logger = Logger.getLogger(FileUtils.class);

	public static HdfsFile[] convertFileStatusToHdfsFile(FileStatus fileStatus[]) {
		if (fileStatus == null) {
			return null;
		}
		HdfsFile[] result = new HdfsFile[fileStatus.length];
		for (int i = 0; i < fileStatus.length; i++) {
			FileStatus status = fileStatus[i];
			result[i] = convertFileStatusToHdfsFile(status);
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	public static HdfsFile convertFileStatusToHdfsFile(FileStatus status) {
		if (status == null) {
			return null;
		}
		Path path = status.getPath();
		long length = status.getLen();
		boolean isDir = status.isDir();
		int blockReplication = status.getReplication();
		long blockSize = status.getBlockSize();
		long modificationTime = status.getModificationTime();
		long accessTime = status.getAccessTime();
		String owner = status.getOwner();
		String group = status.getGroup();
		HdfsFile hdfsFile = new HdfsFile(length, isDir, blockReplication, blockSize, modificationTime, path.toUri(),
				accessTime, owner, group);
		return hdfsFile;
	}
	
	/**
	 * 获取Jar path(.jar中的类) 或者 classes path(文件夹中的类)
	 * 
	 * @param classObj
	 * @return
	 */
	public static String getJarPathForClass(Class<? extends Object> classObj) {
		try {
			URL url = classObj.getProtectionDomain().getCodeSource().getLocation();
			String jarFileFullName = null;
			if ("file".equals(url.getProtocol())) {
				jarFileFullName = URLDecoder.decode(org.apache.commons.io.FileUtils.toFile(url).getCanonicalPath(), "utf-8");
			} else if ("jar".equals(url.getProtocol())) {
				// file:/pathToFile!/
				// *nix
				if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") == -1) {
					jarFileFullName = URLDecoder.decode(url.getFile().substring(5, url.getFile().length() - 2), "utf-8");
				}
				// windows
				else {
					jarFileFullName = URLDecoder.decode(url.getFile().substring(6, url.getFile().length() - 2), "utf-8");
				}
			}
			return jarFileFullName;
		} catch (IOException e) {
			throw new PriestPlatformException(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(FileUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile());
	}
	
	public static String getAdminPwd() {
		BufferedReader reader= null;
		InputStreamReader read= null;
		InputStream in = null;
		String result;
		try {
			File pwdFile = new File(FileUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile()+"adminPwdFile");
			if (!pwdFile.exists()) {
				result = Constants.USER_ADMIN;
			} else {
				in = new FileInputStream(pwdFile);
				read = new InputStreamReader(in);
				reader = new BufferedReader(read);
				result = reader.readLine();
				if (result != null && CommUtils.isNotNull(result)) {
					result = result.trim();
				} else {
					result = Constants.USER_ADMIN;
				}
			}
		} catch (Exception e) {
			AuditLog.log("Get admin pwd error:" + e.getMessage());
			throw new RuntimeException("Get admin pwd error, please contact the administator!");
		} finally {
			closeReaderStream(reader, read, in);
		}
		return result;
	}
	
	public static boolean copyFile(File oldFile, File newFile) {  
		InputStream in = null;
		OutputStream out = null;
		boolean result = false;
		try {
			if (oldFile.exists()) {
				newFile.deleteOnExit();
				byte[] buffer = new byte[1444];
				int byteRead = 0;
				in = new FileInputStream(oldFile);
				out = new FileOutputStream(newFile);
				while ((byteRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, byteRead);
				}
				result = true;
			}
		} catch (Exception e) {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e1) {}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e1) {}
			}
		}
	    return result;
	}
	
	public static void setAdminPwd(String pwd) {
		BufferedWriter writer= null;
		OutputStreamWriter write= null;
		OutputStream out = null;
		try {
			File pwdFile = new File(FileUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile()+"adminPwdFile");
			if (pwdFile.exists()) {
				pwdFile.delete();
			}
			pwdFile.createNewFile();
			out = new FileOutputStream(pwdFile);
			write = new OutputStreamWriter(out);
			writer = new BufferedWriter(write);
			writer.write(pwd);
			writer.flush();
		} catch (Exception e) {
			AuditLog.log("Set admin pwd error:" + e.getMessage());
			throw new RuntimeException("Set admin pwd error, please contact the administator!");
		} finally {
			closeWriterStream(writer, write, out);
		}
	}
	
	public static String getRuntimeClassPath(File file) {
		Map<String, String> pathsMap = new HashMap<String, String>();
		
		getRuntimeClassPath(file, pathsMap);
		StringBuffer runtimeClassPath = new StringBuffer("");
		for (Entry<String, String> path: pathsMap.entrySet()) {
			runtimeClassPath.append(path.getValue() + File.pathSeparator);
		}
		String result = runtimeClassPath.toString();
		if (result.endsWith(File.pathSeparator)) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
	
	/**
	 * 获取指定文件目录所有
	 * 
	 * @param classObj
	 * @return
	 */
	private static void getRuntimeClassPath(File file, Map<String, String> pathsMap) {
		if (file.isDirectory()) {
			File[] tmps = file.listFiles();
			for (File tmp : tmps) {
				getRuntimeClassPath(tmp, pathsMap);
			}
		} else {
			if (file.getAbsolutePath().endsWith(".jar")) {
				try {
					pathsMap.put(file.getName(), file.getCanonicalPath());
				} catch (Exception e) {
					logger.error(String.format("runtimeClassPath get error, when get file[%s], error[%s]",
							file.getAbsolutePath(), e.getMessage()));
				}
			}
		}
	}
	
	public static void closeReaderStream(BufferedReader reader, InputStreamReader read, InputStream in) {
		  if(reader != null) {
		   try {
		    reader.close();
		   } catch (IOException e) {}
		  }
		  if(read != null) {
		   try {
		    read.close();
		   } catch (IOException e) {}
		  }
		  if(in != null) {
		   try {
		    in.close();
		   } catch (IOException e) {}
		  }
	 }
	
	public static void closeWriterStream(BufferedWriter writer, OutputStreamWriter write, OutputStream out) {
		if(writer != null) {
			try {
				writer.close();
			} catch (IOException e) {}
		}
		if(write != null) {
			try {
				write.close();
			} catch (IOException e) {}
		}
		if(out != null) {
			try {
				out.close();
			} catch (IOException e) {}
		}
	}
	
	public static File getHadoopLibPath() {
		String hadoopLibPath = ConfigUtil.getContextProperty("hadoop.lib.path");
		File hadoopLibFile;
		if (CommUtils.isNull(hadoopLibPath)) {
			hadoopLibFile = new File(getJarPathForClass(FileUtils.class), "../lib_hadoop_ext");
		} else {
			hadoopLibFile = new File(hadoopLibPath);
		}
		if(!hadoopLibFile.exists()) {
			throw new RuntimeException(String.format(
				"Environment hadoop.lib.path[%s] file does not exist, please contact the administator!", hadoopLibPath));
		};
		return hadoopLibFile;
	}
	
	public static File getHiveLibPath() {
		String envPath = ConfigUtil.getContextProperty("hive.lib.path");
		File envPathFile;
		if (CommUtils.isNull(envPath)) {
			envPathFile = new File(getJarPathForClass(FileUtils.class), "../lib_hive_ext");
		} else {
			envPathFile = new File(envPath);
		}
		if(!(envPathFile.exists() && envPathFile.isDirectory())) {
			throw new RuntimeException(String.format(
					"Environment hive.lib.path[%s] file does not exist or is not directory, please contact the administator!", envPath));
		};
		return envPathFile;
	}
	
	public static File getHadoopConfigPath() {
		String hadoopConfPath = ConfigUtil.getContextProperty("hadoop.config.path");
		File hadoopConfigFile;
		if (CommUtils.isNull(hadoopConfPath)) {
			hadoopConfigFile = new File("/etc/hadoop/conf");
		} else {
			hadoopConfigFile = new File(hadoopConfPath);
		}
		if(!(hadoopConfigFile.exists() && hadoopConfigFile.isDirectory())) {
			throw new RuntimeException(String.format(
					"Environment hadoop.config.path[%s] file does not exist or is not directory, please contact the administator!", hadoopConfPath));
		};
		return hadoopConfigFile;
	}
	
	public static String getClassFilePath(String classFile) {
		return new File(getJarPathForClass(FileUtils.class), classFile).getAbsolutePath();
	}
	
	public static String getHadoopProcessClassPath() {
		String cp = getRuntimeClassPath(getHadoopLibPath()),
				processExt = getRuntimeClassPath(new File(getJarPathForClass(FileUtils.class), "../lib_ext"));
		if (CommUtils.isNotNull(processExt)) {
			cp += File.pathSeparator + processExt;
		}
		return cp;
	}
	
	public static List<String> getAllLibClassPath() {
		String classpath = getRuntimeClassPath(new File(getJarPathForClass(FileUtils.class), "../lib")),
			   hadooppath = getRuntimeClassPath(getHadoopLibPath()),
			   hivepath = getRuntimeClassPath(getHiveLibPath()),
			   processExt = getRuntimeClassPath(new File(getJarPathForClass(FileUtils.class), "../lib_ext"));
		List<String> result = new ArrayList<String>();
		result.add(classpath);
		if (CommUtils.isNotNull(hadooppath)) {
			result.add(hadooppath);
		}
		
		if (CommUtils.isNotNull(hivepath)) {
			result.add(hivepath);
		}
		
		if (CommUtils.isNotNull(processExt)) {
			result.add(processExt);
		}
		return result;
	}
}
