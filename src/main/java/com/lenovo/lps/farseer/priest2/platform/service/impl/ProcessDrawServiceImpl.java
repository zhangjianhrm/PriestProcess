package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependDraw;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessRunGraph;
import com.lenovo.lps.farseer.priest2.platform.mapper.ProcessDrawMapper;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessDrawService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class ProcessDrawServiceImpl implements ProcessDrawService {
	@Autowired
	private ProcessDrawMapper mapper;

	@Resource
	private ScheduleService scheduleService;
	
	private void getProcessChildrenProes(int proId, List<ProcessDependDraw> proes, int depth, int flagDepth, List<ProcessDependDraw> result) {
		if (flagDepth > depth) {
			return;
		}
		for (ProcessDependDraw pro: proes) {
			if (pro.getDepProcessId() != null && proId == pro.getDepProcessId() && !result.contains(pro)) {
				result.add(pro);
				getProcessChildrenProes(pro.getProcessId(), proes, depth, flagDepth + 1, result);
			}
		}
	}
	
	private void getProcessParentProes(int proId, List<ProcessDependDraw> proes, int depth, int flagDepth, List<ProcessDependDraw> result) {
		if (flagDepth > (depth + 1)) {
			return;
		}
		for (ProcessDependDraw pro: proes) {
			if (proId == pro.getProcessId() && !result.contains(pro)) {
				result.add(pro);
				if (pro.getDepProcessId() != null && pro.getDepProcessId() > 0) {
					getProcessParentProes(pro.getDepProcessId(), proes, depth, flagDepth + 1, result);
				}
			}
		}
	}
	
	private void getProessEntitys(int proId, String queryType, int depth, List<ProcessDependDraw> proes, List<ProcessDependDraw> result) {
		if (StringUtil.isEmpty(queryType)) {
			getProcessChildrenProes(proId, proes, depth, 1, result);
			getProcessParentProes(proId, proes, depth, 1, result);
		} else if ("son".equals(queryType))	{
			getProcessChildrenProes(proId, proes, depth, 1, result);
			for (ProcessDependDraw pro: proes) {
				if (proId == pro.getProcessId() && !result.contains(pro)) {
					result.add(pro);
				}
			}
		} else if ("parent".equals(queryType)) {
			getProcessParentProes(proId, proes, depth, 1, result);
		} else {
			getProcessChildrenProes(proId, proes, depth, 1, result);
			getProcessParentProes(proId, proes, depth, 1, result);
			List<ProcessDependDraw> tmpProes = new ArrayList<ProcessDependDraw>();
			for (ProcessDependDraw pro: result) {
				tmpProes.add(pro);
			}
			for (ProcessDependDraw pro: tmpProes) {
				if (pro.getDepProcessId() != null && pro.getDepProcessId() > 0)
				getProcessParentProes(pro.getDepProcessId(), proes, depth, 1, result);
			}
		}
	}

	private String getExecDate(String scheduleDate) {
		String execDate =DateUtils.getBeforeDate(new Date());
		try {
			if (StringUtil.isNotEmpty(scheduleDate)) {
				execDate = DateUtils.getBeforeDate(DateUtils.parseString2Date(scheduleDate, DateUtils.getDateDayFormat()));
			}
		} catch (Exception e) {}
		return execDate;
	}

	@Override
	public String getSvgXml(HttpSession session, String processId, String queryType, String appId,
			String scheduleDate, boolean isRun, int depth) throws UnsupportedEncodingException {
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<ProcessDependDraw> proes, result = new ArrayList<ProcessDependDraw>();
		params.put("execDate", getExecDate(scheduleDate));
		if (isRun) {
			proes = mapper.getProcessRunsIncDepId(params);
		} else {
			proes = mapper.getProcessIncDepId(params);
		}
		int proId = StringUtil.parseInt(processId);
		if (proId > 0 && proes != null && proes.size() > 0) {
			getProessEntitys(proId, queryType, depth, proes, result);
		} else {
			result = proes;
		}
		String svg = "";
		if (proes.size() > 0) {
			svg = drawSVG(result);
		}
		return svg;
	}
	
	private String drawSVG(List<ProcessDependDraw> result) throws UnsupportedEncodingException {
		ProcessRunGraph processRunGraph = new ProcessRunGraph(
				ConfigUtil.getContextProperty("process.run.graph.height", "2000"), 
				ConfigUtil.getContextProperty("process.run.graph.width", "100"));
		List<ProcessEntity> svgEntitys = new ArrayList<ProcessEntity>();
		ProcessEntity pro;
		for (ProcessDependDraw res: result) {
			pro = new ProcessEntity(res);
			svgEntitys.add(pro);
		}
		return processRunGraph.generateGraph(svgEntitys);
	}
}
