package com.lenovo.lps.farseer.priest2.platform.service;

import java.util.List;

import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public interface ZipOperateOfProcessService {

	public ProcessEntity unzipProcess(String zipFileName);

	public List<ProcessEntity> unzipProcesses(String zipFileName);

	public String zipProcess(ProcessEntity processEntity);

	public String zipProcesses(ProcessEntity processEntity);

	public boolean isMultipleProcesses(String zipFileName);

}
