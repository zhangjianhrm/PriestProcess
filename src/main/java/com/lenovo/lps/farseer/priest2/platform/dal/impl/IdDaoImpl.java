package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.IdGen;
import com.lenovo.lps.farseer.priest2.platform.dal.IdDao;
import com.lenovo.lps.farseer.priest2.platform.mapper.ProcessMapper;

public class IdDaoImpl implements IdDao {

	private static Logger logger = Logger.getLogger(IdDaoImpl.class);

	@Autowired
	@Qualifier("processMapper")
	private ProcessMapper processMapper;
	
	@Override
	public Long genTaskId() {
		Long taskId = null;
		try {
			IdGen idGen = new IdGen();
			processMapper.sqlGenTaskId(idGen);
			taskId = idGen.getTask_id();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		return taskId;
	}

	@Override
	public Long genProcessId() {
		Long processId = null;
		try {
			IdGen idGen = new IdGen();
			processMapper.sqlGenProcessId(idGen);
			processId = idGen.getProcess_id();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		return processId;
	}
}
