package com.lenovo.lps.farseer.priest2.platform.service;

import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public interface JbpmProcessService {
	/**
	 * 向线程池提交jbpm流程
	 * 
	 * @param toRunProcess
	 */
	public void submitJbpmProcess(ProcessEntity toRunProcess);

	/**
	 * 终止运行流程
	 * 
	 * @param processId
	 * @param execDate
	 */
	public void cancelRunningProcess(Integer processId, String execDate);

	/**
	 * 检查流程是否正在排队OR运行
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	public boolean checkRunningProcess(Integer processId, String execDate);
}
