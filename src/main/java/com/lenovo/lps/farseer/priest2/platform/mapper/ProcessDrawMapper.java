package com.lenovo.lps.farseer.priest2.platform.mapper;

import java.util.List;
import java.util.Map;

import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependDraw;

public interface ProcessDrawMapper extends Mapper {
	/**
	 * 获取执行日期当天流程实例（包括依赖流程ID）
	 * 
	 * @param execDate
	 * @return
	 */
	List<ProcessDependDraw> getProcessRunsIncDepId(Map<String, Object> params);
	
	/**
	 * 获取流程定义实例（包括依赖流程ID）
	 * 
	 * @param execDate
	 * @return
	 */
	List<ProcessDependDraw> getProcessIncDepId(Map<String, Object> params);
}
