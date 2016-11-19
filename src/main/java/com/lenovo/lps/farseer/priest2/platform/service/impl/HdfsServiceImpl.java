package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.fs.shell.PathData;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.HdfsFile;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.components.WorkSession;
import com.lenovo.lps.farseer.priest2.platform.config.HadoopConfigurationFactory;
import com.lenovo.lps.farseer.priest2.platform.entity.HdfsOpEnum;
import com.lenovo.lps.farseer.priest2.platform.service.HdfsService;
import com.lenovo.lps.farseer.priest2.platform.util.FileUtils;

public class HdfsServiceImpl implements HdfsService {
	private final Logger logger = Logger.getLogger(HdfsServiceImpl.class);

    private String[] getForbiddenArray() {
    	String[] forbiddenArray = null;
		List<String> list = new ArrayList<String>();
		String[] paths = StringUtils.split(ConfigUtil.getContextProperty("hdfs.remove.path.forbidden",
				"/tmp,/user/hive/071/warehouse/,/hadoop/mapred/system/,/data/hadoop/tmp/mapred/"),",");
		if ( paths != null) {
			for ( String p : paths) {
				String xp = StringUtils.stripToNull(p) ;
				if ( xp != null ){
					if ( !xp.endsWith(File.separator)){
						xp = xp + File.separator; 
					}
					list.add(xp);
				}
			}
		}
		forbiddenArray = list.size() == 0 ? new String[0] : list.toArray(new String[0]) ;     
		for( String s : forbiddenArray) {
			logger.info("forbidden remove path:" + s) ;
		}
		return forbiddenArray;
    }
	@Override
	public Object runHdfsOperator(HdfsOpEnum hdfsOp, String... path) {
		try {
			FileSystem fileSystem = FileSystem.get(HadoopConfigurationFactory.getHadoopConfiguration());
			
			switch (hdfsOp) {
			case ls:
				return listOp(fileSystem, path);
			case fileCount:
				return fileCount(path[0], fileSystem);
			case fileSize:
				return fileSize(path[0], fileSystem);
			case isFile:
				return fileSystem.isFile(new Path(path[0]));
			case upload:
				String[] paths = path[0].split(";");
				String uploadFilePath = ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/");
				for (String pathStr: paths) {
					if (CommUtils.isNull(pathStr)) {
						continue;
					}
					File localFile = new File(uploadFilePath, pathStr);
					if (localFile.exists()) {
						String localFileFullName = localFile.getCanonicalPath();
						fileSystem.copyFromLocalFile(false, new Path(localFileFullName), new Path(path[1]));
					} else {
						if (CommUtils.isNotNull(pathStr)) {
							int index = (uploadFilePath + pathStr).lastIndexOf(File.separator);
							if (index >= 0) {
								localFile = new File((uploadFilePath + pathStr).substring(0, index+1));
								if (localFile.exists() && localFile.isDirectory()) {
									Pattern p = Pattern.compile(checkRegexStr((uploadFilePath + pathStr).substring(index+1)));
									Matcher m;
									int fileNum = 0;
									for (File fss: localFile.listFiles()) {
										m = p.matcher(fss.getName());
										if (m.find()) {
											fileSystem.copyFromLocalFile(false, new Path(fss.getCanonicalPath()), 
													new Path(path[1].endsWith(File.separator) ? path[1]+fss.getName():path[1]+File.separator+fss.getName()));
											fileNum++;
										}
									}
									if (fileNum == 0) {
										throw new PriestPlatformException("Local file does not exist:" + uploadFilePath + pathStr);
									}
								} else {
									throw new PriestPlatformException("Local file does not exist:" + uploadFilePath + pathStr);
								}
							} else {
								throw new PriestPlatformException("Local file does not exist:" + uploadFilePath + pathStr);
							}
						}
					}
				}

				return true;
			case download:
				return downloadOp(fileSystem, path);

			case remove:
				return removeOp(fileSystem, path);
			case remove_quiet:
				return removeQuietOp(fileSystem, path) ;
			case createFile:
				Path toCreatedFilePath = new Path(path[0]);
				Assert.isTrue(!fileSystem.exists(toCreatedFilePath), "The file already exists,can't be created:" + path[0]);

				return fileSystem.create(toCreatedFilePath);
			case createDir:
				Path toCreatedDirPath = new Path(path[0]);
				Assert.isTrue(!fileSystem.exists(toCreatedDirPath), "The directory already exists,can't be created:" + path[0]);
				return fileSystem.mkdirs(toCreatedDirPath);
			case exist:
				return fileSystem.exists(new Path(path[0]));
			case move:
				return moveOp(fileSystem, path);

			case copy:
				String[] pathStrs = path[0].split(";");
				for (String pathStr: pathStrs) {
					if (CommUtils.isNull(pathStr)) {
						continue;
					}
					Path toCopy = new Path(path[0]);
					if (fileSystem.exists(toCopy)) {
						FileUtil.copy(fileSystem, toCopy, fileSystem, new Path(path[1]), false, HadoopConfigurationFactory.getHadoopConfiguration());
					} else {
						if (CommUtils.isNotNull(pathStr)) {
							int index = pathStr.lastIndexOf(File.separator);
							if (index >= 0) {
								Path dpath = new Path(pathStr.substring(0, index+1));
								if (fileSystem.exists(dpath) && fileSystem.getFileStatus(dpath).isDirectory()) {
									Pattern p = Pattern.compile(checkRegexStr(pathStr.substring(index+1)));
									Matcher m;
									int fileNum = 0;
									for (FileStatus fss: fileSystem.listStatus(dpath)) {
										m = p.matcher(fss.getPath().getName());
										if (m.find()) {
											FileUtil.copy(fileSystem, fss.getPath(), fileSystem, new Path(path[1]), false, HadoopConfigurationFactory.getHadoopConfiguration());
											fileNum++;
										}
									}
									if (fileNum == 0) {
										throw new PriestPlatformException("File does not exist:" + pathStr);
									}
								} else {
									throw new PriestPlatformException("File does not exist:" + pathStr);
								}
							} else {
								throw new PriestPlatformException("File does not exist:" + pathStr);
							}
						}
					}
				}
				return true;
			default:
				throw new IllegalArgumentException("no implement op:" + hdfsOp.name());
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
	}
	
	private Object listOp(FileSystem fileSystem, String... path) throws IOException {
		List<HdfsFile> result = new ArrayList<HdfsFile>();
		//FileStatus[] fileStatus = fileSystem.listStatus(new Path(path[0]));
		FileStatus[] fileStatus = expandAsGlob(new Path(path[0]), fileSystem);
		HdfsFile[] hdfsFiles = FileUtils.convertFileStatusToHdfsFile(fileStatus);
		if (hdfsFiles != null) {
			Long maxrowcnt = WorkSession.get().getMaxResultRowCount() ;
			if ( maxrowcnt > 0 && hdfsFiles.length > maxrowcnt ){
				throw new IOException("result count more than "+ maxrowcnt + " ,while list "+ path[0]);
			}
			for (HdfsFile hdfsFile : hdfsFiles) {
				result.add(hdfsFile);
			}
		}
		return result;
	}
	
	private int fileCount(String pathStr, FileSystem fileSystem) throws IOException {
		int count = 0;
		String[] paths = pathStr.split(";");
		Path path;
		for (String sgPath: paths) {
			if (CommUtils.isNull(sgPath)) {
				continue;
			}
			path = new Path(sgPath);
			boolean exists = fileSystem.exists(path);
			if (exists) {
				if (fileSystem.getFileStatus(path).isDirectory()) {
					FileStatus[] fileList = fileSystem.listStatus(path);
					if (fileList != null) {
						count += fileList.length;
					}
				} else {
					count += 1;
				}
			} else {
				if (CommUtils.isNotNull(sgPath)) {
					int index = sgPath.lastIndexOf(File.separator);
					if (index >= 0) {
						path = new Path(sgPath.substring(0, index+1));
						if (fileSystem.exists(path) && fileSystem.getFileStatus(path).isDirectory()) {
							Pattern p = Pattern.compile(checkRegexStr(sgPath.substring(index+1)));
							Matcher m;
							for (FileStatus fss: fileSystem.listStatus(path)) {
								m = p.matcher(fss.getPath().getName());
								if (m.find()) {
									count++;
								}
							}
						} else {
							throw new PriestPlatformException("File does not exist:" + sgPath.substring(0, index+1));
						}
					} else {
						throw new PriestPlatformException("File does not exist:" + sgPath);
					}
				}
			}
		}
		
		return count;
	}
	
	private long fileSize(String pathStr, FileSystem fileSystem) throws IOException {
		long size = 0l;
		String[] paths = pathStr.split(";");
		Path path;
		for (String sgPath: paths) {
			if (CommUtils.isNull(sgPath)) {
				continue;
			}
			path = new Path(sgPath);
			if (fileSystem.exists(path)) {
				size += fileSystem.getContentSummary(path).getLength();
			} else {
				if (CommUtils.isNotNull(sgPath)) {
					int index = sgPath.lastIndexOf(File.separator);
					if (index >= 0) {
						path = new Path(sgPath.substring(0, index + 1));
						if (fileSystem.exists(path) && fileSystem.getFileStatus(path).isDirectory()) {
							Pattern p = Pattern.compile(checkRegexStr(sgPath.substring(index+1)));
							Matcher m;
							int fileNum = 0;
							for (FileStatus fss: fileSystem.listStatus(path)) {
								m = p.matcher(fss.getPath().getName());
								if (m.find()) {
									size += fileSystem.getContentSummary(fss.getPath()).getLength();
									fileNum++;
								}
							}
							if (fileNum == 0) {
								throw new PriestPlatformException("File does not exist:" + sgPath);
							}
						} else {
							throw new PriestPlatformException("File does not exist:" + sgPath);
						}
					} else {
						throw new PriestPlatformException("File does not exist:" + sgPath);
					}
				}
			}
		}
		return size;
	}

	private Object moveOp(FileSystem fileSystem, String... path) throws IOException, FileNotFoundException {
		// 目标文件不能为根目前
		Assert.isTrue(!"/".equals(path[1]), "Can't move to /");
		/*
		Path source = new Path(path[0]);
		// move /source/path/* /dest/path
		if (path[0].endsWith(ALL_FILES)) {
			// 源目录存在检查
			if (!fileSystem.exists(source.getParent())) {
				throw new FileNotFoundException("File not found " + source.getParent());
			}

			FileStatus[] fs = fileSystem.listStatus(source.getParent());

			if (fs != null && fs.length > 0) {
				for (FileStatus f : fs) {
					fileSystem.rename(f.getPath(), new Path(path[1], f.getPath().getName()));
				}
			}

			return true;
		}
		// 移动普通文件/目录
		else {
			// 源文件/目录存在检查
			if (!fileSystem.exists(source)) {
				throw new FileNotFoundException("File not found " + source);
			}

			return fileSystem.rename(source, new Path(path[1]));
		}
		*/
		String[] paths = path[0].split(";");
		for (String pathStr: paths) {
			if (CommUtils.isNull(pathStr)) {
				continue;
			}
			Path src = new Path(pathStr);
			Path dst = new Path(path[1]);
			String str_s = src.toString() ;
			String str_d = dst.toString() ;
			if ( str_d.startsWith(str_s) && str_d.charAt(str_s.length())=='/'){
				throw new IOException("can't to move to subdir of source:"+ src + ", dest is " + dst);
			}
			if (fileSystem.exists(src)) {
				moveOp(src, dst, fileSystem);
			} else {
				if (CommUtils.isNotNull(pathStr)) {
					int index = pathStr.lastIndexOf(File.separator);
					if (index >= 0) {
						Path dpath = new Path(pathStr.substring(0, index+1));
						if (fileSystem.exists(dpath) && fileSystem.getFileStatus(dpath).isDirectory()) {
							Pattern p = Pattern.compile(checkRegexStr(pathStr.substring(index+1)));
							Matcher m;
							int fileNum = 0;
							for (FileStatus fss: fileSystem.listStatus(dpath)) {
								m = p.matcher(fss.getPath().getName());
								if (m.find()) {
									moveOp(fss.getPath(), dst, fileSystem);
									fileNum++;
								}
							}
							if (fileNum == 0) {
								throw new PriestPlatformException("File does not exist:" + pathStr);
							}
						} else {
							throw new PriestPlatformException("File does not exist:" + pathStr);
						}
					} else {
						throw new PriestPlatformException("File does not exist:" + pathStr);
					}
				}
			}
		}
		return true ;
	}
	
	private void moveOp(Path src, Path dst, FileSystem fileSystem) throws IOException {
		FileStatus []srcStats = expandAsGlob(src, fileSystem);
		if( srcStats == null || srcStats.length == 0 ) {
			throw new FileNotFoundException("File not found " + src);
		}
		
		if (srcStats.length == 1){ // single file or dir
			boolean b = fileSystem.rename(src, dst);
			if( !b ){
				throw new IOException("can't to move to from src :"+ src + " to dest: " + dst);
			}
		}else { // multiple file and dirs 
			FileStatus []dstStats = expandAsGlob(dst, fileSystem);
			if ( dstStats == null || dstStats.length != 1 || !dstStats[0].isDirectory()){
				throw new IOException("move dest :"+ dst + " must exsit and must Directory ");
			}
			for( FileStatus f : srcStats) {
				boolean b = fileSystem.rename(f.getPath(), dst);
				if( !b ){
					throw new IOException("can't to move to from src :"+ src + " to dest: " + dst);
				}
			}
		}
	}

	private Object removeOp(FileSystem fileSystem, String... path) throws IOException {
		String[] paths = path[0].split(";");
		for (String pathStr: paths) {
			if (CommUtils.isNull(pathStr)) {
				continue;
			}
			Path toRemove = new Path(pathStr);
			if (fileSystem.exists(toRemove)) {
				removeOp(toRemove, fileSystem);
			} else {
				if (CommUtils.isNotNull(pathStr)) {
					int index = pathStr.lastIndexOf(File.separator);
					if (index >= 0) {
						Path dpath = new Path(pathStr.substring(0, index+1));
						if (fileSystem.exists(dpath) && fileSystem.getFileStatus(dpath).isDirectory()) {
							Pattern p = Pattern.compile(checkRegexStr(pathStr.substring(index+1)));
							Matcher m;
							int fileNum = 0;
							for (FileStatus fss: fileSystem.listStatus(dpath)) {
								m = p.matcher(fss.getPath().getName());
								if (m.find()) {
									removeOp(fss.getPath(), fileSystem);
									fileNum++;
								}
							}
							if (fileNum == 0) {
								throw new PriestPlatformException("File does not exist:" + toRemove.toString());
							}
						} else {
							throw new PriestPlatformException("File does not exist:" + toRemove.toString());
						}
					} else {
						throw new PriestPlatformException("File does not exist:" + toRemove.toString());
					}
				}
			}
		}
		return true ;
	}
	
	private void removeOp(Path toRemove, FileSystem fileSystem) throws IOException {
		FileStatus[] stats = expandAsGlob(toRemove, fileSystem) ;
		if ( stats == null || stats.length == 0 ) {
			throw new PriestPlatformException("File does not exist:" + toRemove.toString());
		}
		for( FileStatus file : stats ) {
			remove(file.getPath(),file.isDirectory(),true, fileSystem) ;
		}
	}
	
	private void removeQuietOp(Path toRemove, FileSystem fileSystem) throws IOException {
		FileStatus[] stats = expandAsGlob(toRemove, fileSystem) ;
		for( FileStatus file : stats ) {
			remove(file.getPath(),file.isDirectory(),true, fileSystem) ;
		}
	}
	
	private Object removeQuietOp(FileSystem fileSystem, String ...path) throws IOException{
		String[] paths = path[0].split(";");
		for (String pathStr: paths) {
			if (CommUtils.isNull(pathStr)) {
				continue;
			}
			Path toRemove = new Path(pathStr);
			if (fileSystem.exists(toRemove)) {
				removeQuietOp(toRemove, fileSystem);
			} else {
				if (CommUtils.isNotNull(pathStr)) {
					int index = pathStr.lastIndexOf(File.separator);
					if (index >= 0) {
						Path dpath = new Path(pathStr.substring(0, index+1));
						if (fileSystem.exists(dpath) && fileSystem.getFileStatus(dpath).isDirectory()) {
							Pattern p = Pattern.compile(checkRegexStr(pathStr.substring(index+1)));
							Matcher m;
							for (FileStatus fss: fileSystem.listStatus(dpath)) {
								m = p.matcher(fss.getPath().getName());
								if (m.find()) {
									removeQuietOp(fss.getPath(), fileSystem);
								}
							}
						}
					}
				}
			}
		}
		return true ;
	}
	
	private boolean remove(Path path,boolean isDir,boolean includeSubdir, FileSystem fileSystem) throws IOException {
		if ( isDir && !isDirRemovedable(path)) {
			throw new IOException(path +" can't be removed as " + path +" is forbidden be removed!") ;
		}		
		return fileSystem.delete(path,includeSubdir) ;
	}
	private boolean isDirRemovedable(Path path){
		String src = path.toUri().getPath().toString();
		if ( !src.endsWith(File.separator)) {
			src += File.separator ;
		}
		String[] forbiddenArray = getForbiddenArray();
		for( String p : forbiddenArray ) {
			if ( p.startsWith(src)) {
				return false;
			}
		}
		return true ;
	}
	private Object downloadOp(FileSystem fileSystem, String... path) throws IOException {
		String[] paths = path[0].split(";");
		for (String pathStr: paths) {
			if (CommUtils.isNull(pathStr)) {
				continue;
			}
			Path toDownload = new Path(pathStr);

			File targetDir = new File(path[1]);
			if ( !targetDir.getAbsolutePath().startsWith(ConfigUtil.getContextProperty("file.download.path", "/var/lib/priest/remote_share"))) {
				throw new IOException("download target must under " + ConfigUtil.getContextProperty("file.download.path", "/var/lib/priest/remote_share")+ targetDir.getAbsolutePath() + " is not permitted!");
			}
			if (!targetDir.exists()) {
				boolean ret = targetDir.mkdirs();
				if (!ret) {
					logger.warn("Create target directory failed.");
				}
			}
			/*
			Path savedPath = null;

			// 要下载的文件为源文件时,保存到服务器的路径为:目标路径/源文件名
			if (!fileSystem.getFileStatus(toDownload).isDirectory()) {
				savedPath = new Path(new File(targetDir, toDownload.getName()).getCanonicalPath());
			}
			// 下载目录
			else {
				savedPath = new Path(path[1]);
			}
			
			boolean delete = false;
			return FileUtil.copy(fileSystem, toDownload, FileSystem.getLocal(hadoopConfiguration), savedPath, delete, hadoopConfiguration);
			*/
			if (fileSystem.exists(toDownload)) {
				downloadOp(toDownload, targetDir, fileSystem);
			} else {
				if (CommUtils.isNotNull(pathStr)) {
					int index = pathStr.lastIndexOf(File.separator);
					if (index >= 0) {
						Path dpath = new Path(pathStr.substring(0, index+1));
						if (fileSystem.exists(dpath) && fileSystem.getFileStatus(dpath).isDirectory()) {
							Pattern p = Pattern.compile(checkRegexStr(pathStr.substring(index+1)));
							Matcher m;
							int fileNum = 0;
							for (FileStatus fss: fileSystem.listStatus(dpath)) {
								m = p.matcher(fss.getPath().getName());
								if (m.find()) {
									downloadOp(fss.getPath(), targetDir, fileSystem);
									fileNum++;
								}
							}
							if (fileNum == 0) {
								throw new PriestPlatformException("File does not exist:" + pathStr);
							}
						} else {
							throw new PriestPlatformException("File does not exist:" + pathStr);
						}
					} else {
						throw new PriestPlatformException("File does not exist:" + pathStr);
					}
				}
			}
		}
		return true;
	}
	
	private void downloadOp(Path path, File targetDir, FileSystem fileSystem) throws IOException {
		FileStatus[] stats = expandAsGlob(path, fileSystem) ;
		if ( stats == null || stats.length == 0 ) {
			throw new IOException("File not found:" +path );
		}
		Path savedPath = new Path(targetDir.getAbsolutePath());
		boolean delete = false;
		boolean overwrite = false ;
		Path srcpath[] = new Path[stats.length];
		for(int i = 0 ; i< stats.length; i++){
			srcpath[i] = stats[i].getPath();
		}
		FileUtil.copy(fileSystem, srcpath, FileSystem.getLocal(HadoopConfigurationFactory.getHadoopConfiguration()), 
				savedPath, delete, overwrite, HadoopConfigurationFactory.getHadoopConfiguration()) ;
	}
	 /** 
	   * Expand the given path as a glob pattern.  Non-existent paths do not 
	   * throw an exception because creation commands like touch and mkdir need 
	   * to create them.  The "stat" field will be null if the path does not
	   * exist.
	   * @param pattern the pattern to expand as a glob
	   * @param conf the hadoop configuration
	   * @return list of {@link PathData} objects.  if the pattern is not a glob,
	   * and does not exist, the list will contain a single PathData with a null
	   * stat 
	   * @throws IOException anything else goes wrong...
	   */
	  private FileStatus[] expandAsGlob(Path globPath, FileSystem fileSystem)  throws IOException {
	    URI globUri = globPath.toUri();
	    if (!new File(globUri.getPath()).isAbsolute()){
	    	throw new IOException("all path parameters of hdfs opertor must start with '/' ") ;
	    }
	    FileStatus[] stats = fileSystem.globStatus(globPath);	 	  
	    return stats == null ? new FileStatus[0] : stats ;
	  }
	

	@Override
	public Long getLen(Path hdfsPath) {
		Long len = 0L;
		try {
			FileSystem fileSystem = FileSystem.get(HadoopConfigurationFactory.getHadoopConfiguration());
			if (!fileSystem.exists(hdfsPath)) {
				return len;
			}

			FileStatus status = fileSystem.getFileStatus(hdfsPath);

			// Dir
			if (status.isDirectory()) {
				FileStatus[] subStatuses = fileSystem.listStatus(hdfsPath);

				if (subStatuses != null && subStatuses.length > 0) {
					for (FileStatus subStatus : subStatuses) {
						len += getLen(subStatus.getPath());
					}
				}
			}
			// File
			else {
				len = status.getLen();
			}

			return len;
		} catch (IOException e) {
			throw new PriestPlatformException(e);
		}
	}

	@Override
	public Long getLocalLen(String path) {
		Long len = 0L;

		File pathFile = new File(path);
		if (!pathFile.exists()) {
			return len;
		}

		// Dir
		if (pathFile.isDirectory()) {
			File[] subFiles = pathFile.listFiles();

			if (subFiles != null && subFiles.length > 0) {
				for (File subFile : subFiles) {
					len += getLocalLen(subFile.getAbsolutePath());
				}
			}
		}
		// File
		else {
			len = pathFile.length();
		}

		return len;
	}
	@Override
	public Long getFileSize(String path) {
		Long size = 0L;
		try {
			FileSystem fileSystem = FileSystem.get(HadoopConfigurationFactory.getHadoopConfiguration());
			size = fileSize(path, fileSystem);
		} catch (Exception e) {}
		return size;
	}
	
	@Override
	public void chmod777(String path) {
		try {
			FileSystem fileSystem = FileSystem.get(HadoopConfigurationFactory.getHadoopConfiguration());
			Path pathFile = new Path(path);
			if (!fileSystem.exists(pathFile)) {
				return;
			}
			FsPermission fp = new FsPermission("777");
			fileSystem.setPermission(pathFile, fp);
			FileStatus status = fileSystem.getFileStatus(pathFile);

			// Dir
			if (status.isDirectory()) {
				FileStatus[] subStatuses = fileSystem.listStatus(pathFile);
				for (FileStatus fss: subStatuses) {
					fileSystem.setPermission(fss.getPath(), fp);
				}
			}
		} catch (Exception e) {}
	}
	@Override
	public boolean fileExists(String path) {
		boolean result = false;
		try {
			FileSystem fileSystem = FileSystem.get(HadoopConfigurationFactory.getHadoopConfiguration());
			result = fileSystem.exists(new Path(path));
		} catch (Exception e) {}
		return result;
	}
	
	private static String checkRegexStr(String str) {
		if (!(str.startsWith("^")&& str.endsWith("$"))) {
			str = "^" + str + "$";
		}
		return str;
	}
}
