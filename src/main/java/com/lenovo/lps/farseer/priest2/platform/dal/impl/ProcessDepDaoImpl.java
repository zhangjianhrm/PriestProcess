package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDepDao;
import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependentEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.mapper.ProcessDepMapper;

public class ProcessDepDaoImpl implements ProcessDepDao {
	@Autowired
	private ProcessDepMapper processDepMapper;

	@Override
	public void insertDeps(List<ProcessDependentEntity> deps) {
		processDepMapper.insertDeps(deps);

	}

	@Override
	public void deleteDep(Integer processId) {
		processDepMapper.deleteDep(processId);
	}

	@Override
	public Long getProcessRunCount(ProcessEntity param) {
		return processDepMapper.getProcessRunCount(param);
	}

	@Override
	public PagingResult<ProcessEntity> getProcessRuns(ProcessEntity param) {
		// 获取符合条件的记录数
		Long totalRecords = getProcessRunCount(param);

		// 总页数
		Long totalPages = (totalRecords.longValue() - 1) / param.getRows() + 1;

		PagingResult<ProcessEntity> result = new PagingResult<ProcessEntity>();
		// 设置当前页
		result.setPageNo(param.getPage());
		// 设置每页大小
		result.setPageSize(param.getRows());
		// 设置总页数
		result.setTotalPages(totalPages);
		// 设置总记录数
		result.setTotalRecords(totalRecords);

		// 设置分页时limit offset
		param.setOffset((param.getPage() - 1) * param.getRows());

		// 获取条件条件的记录
		List<ProcessEntity> processRuns = processDepMapper.getProcessRuns(param);
		result.setResults(processRuns);

		return result;
	}
	
	@Override
	public List<ProcessEntity> getProcessFails(ProcessEntity param) {
		return processDepMapper.getProcessFails(param);
	}

	@Override
	public List<ProcessEntity> getProcessRunsIncDepId(ProcessEntity param){
		return processDepMapper.getProcessRunsIncDepId(param);
	}
	
	@Override
	public Set<Integer> getProcessChildrenIds(Integer processId) {
		Set<Integer> processChildrenIds = new LinkedHashSet<Integer>();
		List<ProcessEntity> processChildrenList = processDepMapper.getProcessChildrenIds(processId);
		for (ProcessEntity processEntity : processChildrenList) {
			processChildrenIds.add(processEntity.getProcessId());
		}
		return processChildrenIds;
	}
	
	@Override
	public Set<Integer> getProcessParentsIds(Integer processId) {
		Set<Integer> processParentsIds = new HashSet<Integer>();
		List<ProcessEntity> processParentsList = processDepMapper.getProcessParentsIds(processId);
		for (ProcessEntity processEntity : processParentsList) {
			processParentsIds.add(processEntity.getDepProcessId());
		}
		return processParentsIds;
	}
	
}
