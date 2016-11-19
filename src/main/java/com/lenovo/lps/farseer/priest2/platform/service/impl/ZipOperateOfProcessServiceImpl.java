package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.dal.IdDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependentEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ZipOperateOfProcessService;
import com.lenovo.lps.farseer.priest2.platform.util.FileOperateUtil;
import com.lenovo.lps.farseer.priest2.platform.util.JsonParseUtils;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class ZipOperateOfProcessServiceImpl implements ZipOperateOfProcessService {
	private static final String IN_REF = " in ";

	private final Logger logger = Logger.getLogger(ZipOperateOfProcessServiceImpl.class);

	@Autowired
	private ProcessService processService;

	@Autowired
	private IdDao idDao;

	// 临时文件目录
	private String tmpDir = System.getProperty("java.io.tmpdir");

	@Override
	public String zipProcess(ProcessEntity processEntity) {
		String zipFileAbsolutePath;
		try {
			String jsonDef = processEntity.getJsonDef();
			Integer processId = processEntity.getProcessId();
			String processName = processEntity.getProcessName();
			// 将json写入文本文件
			String fileName = processId + "_" + processName.trim().replaceAll(" ", "_");
			fileName = StringUtil.generateNewFileName(fileName);
			String jsonDefFileName = fileName + "_jsonDef";
			String jsonDefFilePath = FileOperateUtil.generateFileAbsolutePath(tmpDir, jsonDefFileName);
			FileOperateUtil.string2File(jsonDefFilePath, jsonDef);
			List<String> fileNames = JsonParseUtils.getFileNamesInProcess(jsonDef);
			Map<String, String> filePaths = new HashMap<String, String>();
			filePaths.put(jsonDefFilePath, jsonDefFileName);
			for (String name : fileNames) {
				String filePath = FileOperateUtil.generateFileAbsolutePath(ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/"), name);
				filePaths.put(filePath, name);
			}
			// 压缩流程中使用的文件
			zipFileAbsolutePath = FileOperateUtil.zipFilesOperation(tmpDir, fileName, filePaths);
			// 删除jsonDef文件
			if (FileOperateUtil.removeFile(tmpDir, jsonDefFileName)) {
				logger.info(jsonDefFileName + IN_REF + tmpDir + " is already removed.");
			}
			// 设置在系统退出时删除zip文件
			FileOperateUtil.tagRemoveFile(tmpDir, fileName);
			logger.info(fileName + IN_REF + tmpDir + " will be removed when priest shutdown.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e.getMessage(), e);
		}
		return zipFileAbsolutePath;
	}

	@Override
	public String zipProcesses(ProcessEntity processEntity) {
		String zipFileAbsolutePath;
		Map<String, String> zipFilePaths = new HashMap<String, String>();
		try {
			Set<Integer> processIdSet = new HashSet<Integer>();
			processIdSet = findAllDependentProcessIds(processIdSet, processEntity);
			for (Integer processId : processIdSet) {
				ProcessEntity pEntity = processService.getProcessDef(String.valueOf(processId));
				String zipFilePath = zipProcess(pEntity);
				File zipFile = new File(zipFilePath);
				zipFilePaths.put(zipFilePath, zipFile.getName());
			}
			String fileName = String.valueOf(processEntity.getProcessId()) + "_and_its_dependent_processes";
			String zipFileName = StringUtil.generateNewFileName(fileName);
			zipFileAbsolutePath = FileOperateUtil.zipFilesOperation(tmpDir, zipFileName, zipFilePaths);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e.getMessage(), e);
		} finally {
			// 删除压缩过程中使用的文件
			List<String> deleteFiles = new ArrayList<String>();
			deleteFiles.addAll(zipFilePaths.values());
			int delCount = 0;
			try {
				delCount = FileOperateUtil.removeFiles(tmpDir, deleteFiles);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new PriestPlatformException(e.getMessage(), e);
			}
			if (deleteFiles.size() == delCount) {
				logger.info(deleteFiles + IN_REF + tmpDir + " is(are) already removed.");
			}
		}
		return zipFileAbsolutePath;
	}

	// 获取流程ID以及该流程的依赖树中的所有流程的ID(采用递归的方式遍历依赖树)
	private Set<Integer> findAllDependentProcessIds(Set<Integer> processIdSet, ProcessEntity processEntity) throws JsonParseException,
			JsonMappingException, IOException, ParseException {
		ProcessEntity procEntity = processEntity;
		processIdSet.add(procEntity.getProcessId());
		String jsonDef = procEntity.getJsonDef();
		procEntity = JsonParseUtils.parseProcessFromJson(jsonDef);
		List<ProcessDependentEntity> processDependentEntities = procEntity.getDeps();
		for (ProcessDependentEntity processDependentEntity : processDependentEntities) {
			Integer dependentProcessId = processDependentEntity.getDependentProcessId();
			ProcessEntity dependentEntity = processService.getProcessDef(String.valueOf(dependentProcessId));
			// modified by niexiaoming 2012-12-15 :修复被依赖流程不存在bug
			Assert.isTrue(dependentEntity != null, "Depended process not exists for id:" + dependentProcessId);
			findAllDependentProcessIds(processIdSet, dependentEntity);
		}
		return processIdSet;
	}

	@Override
	public ProcessEntity unzipProcess(String zipFileName) {
		ProcessEntity process = null;
		String jsonDef = "";
		String newJsonDef = "";
		List<String> filesOfMove = new ArrayList<String>();
		List<String> filesOfRemove = new ArrayList<String>();
		filesOfRemove.add(zipFileName);
		try {
			// 解压上传后的压缩包
			Map<String, String> fileNames = FileOperateUtil.unzipFileOperationg(tmpDir, zipFileName);
			filesOfMove.addAll(fileNames.values());
			for (String fileName : fileNames.values()) {
				if (fileName.contains("jsonDef")) {
					filesOfRemove.add(fileName);
					filesOfMove.remove(fileName);
					String filePath = FileOperateUtil.generateFileAbsolutePath(tmpDir, fileName);
					jsonDef = FileOperateUtil.file2String(filePath);
				}
			}
			// 重写json文件：修改流程ID和任务ID，更改流程中的文件名
			String jsonDefWithNewProcessId = JsonParseUtils.changeProcessId(jsonDef, idDao);
			String jsonDefWithNewTaskId = JsonParseUtils.changeTaskId(jsonDefWithNewProcessId, idDao);
			String jsonDefWithNewFileName = JsonParseUtils.changeFileName(jsonDefWithNewTaskId, fileNames);
			newJsonDef = jsonDefWithNewFileName;
			process = JsonParseUtils.parseProcessFromJson(newJsonDef);
			// 验证process是否同名
			String processName = process.getProcessName();
			ProcessEntity existProcess = processService.getProcessDefByName(processName);
			if (existProcess != null) {
				return null;
			}
			// 流程依赖处理
			List<ProcessDependentEntity> deps = process.getDeps();
			if (deps.size() > 0) {
				for (ProcessDependentEntity processDependentEntity : deps) {
					processDependentEntity.setProcessId(process.getProcessId());
				}
			}
			// 删除jsonDef和zip文件
			int delCount = FileOperateUtil.removeFiles(tmpDir, filesOfRemove);
			if (filesOfRemove.size() == delCount) {
				logger.info(filesOfRemove + IN_REF + tmpDir + " is(are) already removed.");
			}
			moveTmpToUpload(filesOfMove);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e.getMessage(), e);
		}
		return process;
	}

	@Override
	public List<ProcessEntity> unzipProcesses(String zipFileName) {
		Map<String, String> processIdMap = new HashMap<String, String>();// key为旧ID，value为新ID
		List<String> filesOfMove = new ArrayList<String>();
		List<String> filesOfRemove = new ArrayList<String>();
		List<String> jsonDefs = new ArrayList<String>();
		List<ProcessEntity> processEntities = new ArrayList<ProcessEntity>();
		filesOfRemove.add(zipFileName);
		try {
			// fileNames：key为压缩包中解压前原文件名，value为解压出的文件名
			Map<String, String> fileNames = FileOperateUtil.unzipFileOperationg(tmpDir, zipFileName);
			List<String> fileNamesValuesList = new ArrayList<String>();
			fileNamesValuesList.addAll(fileNames.values());
			filesOfRemove.addAll(fileNamesValuesList);
			for (String fileName : fileNamesValuesList) {
				Map<String, String> fileNamesMap = FileOperateUtil.unzipFileOperationg(tmpDir, fileName);
				fileNames.putAll(fileNamesMap);
				filesOfMove.addAll(fileNamesMap.values());
			}
			// 重写json文件：修改流程ID和任务ID，更改流程中的文件名
			for (String fileName : fileNames.values()) {
				if (fileName.contains("jsonDef")) {
					filesOfRemove.add(fileName);
					filesOfMove.remove(fileName);
					String filePath = FileOperateUtil.generateFileAbsolutePath(tmpDir, fileName);
					String jsonDef = FileOperateUtil.file2String(filePath);
					ProcessEntity processEntity = JsonParseUtils.parseProcessFromJson(jsonDef);
					String oldProcessId = String.valueOf(processEntity.getProcessId());
					// 验证process是否同名：如果有同名process，将该process的ID获取，并且不导入该process；如果没有同名process，新生成process的ID，并重写json文件
					String processName = processEntity.getProcessName();
					ProcessEntity existProcess = processService.getProcessDefByName(processName);
					String newProcessId = "";
					if (existProcess != null) {
						newProcessId = String.valueOf(existProcess.getProcessId());
					} else {
						newProcessId = String.valueOf(idDao.genProcessId());
						jsonDef = JsonParseUtils.changeProcessId(jsonDef, newProcessId);
						jsonDef = JsonParseUtils.changeTaskId(jsonDef, idDao);
						jsonDef = JsonParseUtils.changeFileName(jsonDef, fileNames);
						jsonDefs.add(jsonDef);
					}
					processIdMap.put(oldProcessId, newProcessId);
				}
			}
			// 修改依赖流程的ID
			for (String jsonDef : jsonDefs) {
				jsonDef = JsonParseUtils.changeDependentProcessId(jsonDef, processIdMap);
				ProcessEntity processEntity = JsonParseUtils.parseProcessFromJson(jsonDef);
				// 流程依赖处理
				List<ProcessDependentEntity> deps = processEntity.getDeps();
				if (deps.size() > 0) {
					for (ProcessDependentEntity processDependentEntity : deps) {
						processDependentEntity.setProcessId(processEntity.getProcessId());
					}
				}
				processEntities.add(processEntity);
			}
			// 删除jsonDef和zip文件
			int delCount = FileOperateUtil.removeFiles(tmpDir, filesOfRemove);
			if (filesOfRemove.size() == delCount) {
				logger.info(filesOfRemove + IN_REF + tmpDir + " is(are) already removed.");
			}
			moveTmpToUpload(filesOfMove);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e.getMessage(), e);
		}
		return processEntities;
	}

	private void moveTmpToUpload(List<String> filesOfMove) throws IOException {
		// 将解压后的文件如jar和shell文件从tmpDir移到uploadDir
		int size = filesOfMove.size();
		if (size > 0) {
			int mvCount = FileOperateUtil.moveFiles(tmpDir, ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/"), filesOfMove);
			if (size == mvCount) {
				logger.info(filesOfMove + IN_REF + tmpDir + " is(are) already moved to " + ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/") + ".");
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isMultipleProcesses(String zipFileName) {
		boolean flag = false;
		// 文件后缀名
		CharSequence[] suffixes = { "_jsonDef", ".jar", ".sh" };
		try {
			String zipFilePath = FileOperateUtil.generateFileAbsolutePath(tmpDir, zipFileName);
			ZipFile zipFile = new ZipFile(zipFilePath);
			Enumeration<ZipEntry> entries = zipFile.getEntries();
			while (entries.hasMoreElements()) {
				ZipEntry zipEntry = entries.nextElement();
				String fileName = zipEntry.getName();
				if (!StringUtils.endsWithAny(fileName, suffixes)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e.getMessage(), e);
		}
		return flag;
	}
}
