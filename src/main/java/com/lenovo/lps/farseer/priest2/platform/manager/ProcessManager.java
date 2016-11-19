package com.lenovo.lps.farseer.priest2.platform.manager;

import javax.servlet.http.HttpSession;

import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public interface ProcessManager {

	/**
	 * 注册流程
	 * 
	 * @param process
	 * @return
	 */
	boolean regiestProcess(String process);

	/**
	 * 查询流程定义
	 * 
	 * @param requestParam
	 * @return
	 */
	PagingResult<ProcessEntity> getProcessDef(ProcessEntity requestParam);

	/**
	 * 流程失败或暂停后，从停止的TASK开始执行
	 * 
	 * @param processId
	 * @param execDate
	 * @param taskStatus
	 * @return
	 */
	void retryProcess(String processId, String execDate, String taskStatus, HttpSession session);
}
