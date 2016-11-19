package com.lenovo.lps.farseer.priest2.platform.mapper;

import java.util.List;

import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependentEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public interface ProcessDepMapper extends Mapper {
	/**
	 * 批量插入流程依赖
	 * 
	 * @param deps
	 */
	void insertDeps(List<ProcessDependentEntity> deps);

	/**
	 * 删除流程依赖
	 * 
	 * @param processId
	 */
	void deleteDep(Integer processId);

	/**
	 * 统计执行日期当天流程实例
	 * 
	 * @param execDate
	 * @return
	 */
	Long getProcessRunCount(ProcessEntity param);
	
	/**
	 * 获取执行日期当天流程实例
	 * 
	 * @param execDate
	 * @return
	 */
	List<ProcessEntity> getProcessRuns(ProcessEntity param);
	
	/**
	 * 获取执行日期当天失败流程实例
	 * 
	 * @param execDate
	 * @return
	 */
	List<ProcessEntity> getProcessFails(ProcessEntity param);

	/**
	 * 获取执行日期当天流程实例（包括依赖流程ID）
	 * 
	 * @param execDate
	 * @return
	 */
	List<ProcessEntity> getProcessRunsIncDepId(ProcessEntity param);

	/**
	 * 获取流程的子节点流程ID
	 * 
	 * @param processId
	 * @return
	 */
	List<ProcessEntity> getProcessChildrenIds(Integer dependentProcessId);

	/**
	 * 获取流程的父节点流程ID
	 * 
	 * @param processId
	 * @return
	 */
	List<ProcessEntity> getProcessParentsIds(Integer processId);
}