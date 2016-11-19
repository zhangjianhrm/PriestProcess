package com.lenovo.lps.farseer.priest2.platform.dal;

import java.util.List;
import java.util.Set;

import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependentEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public interface ProcessDepDao {
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
	 * @param param
	 * @return
	 */
	PagingResult<ProcessEntity> getProcessRuns(ProcessEntity param);
	
	/**
	 * 获取执行日期当天失败流程实例
	 * 
	 * @param param
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
	 */
	Set<Integer> getProcessChildrenIds(Integer processId);

	/**
	 * 获取流程的父节点流程ID
	 * 
	 * @param processId
	 * @return
	 */
	Set<Integer> getProcessParentsIds(Integer processId);
}
