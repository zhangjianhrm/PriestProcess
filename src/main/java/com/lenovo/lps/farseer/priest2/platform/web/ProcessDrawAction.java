package com.lenovo.lps.farseer.priest2.platform.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessDrawService;

@Controller
public class ProcessDrawAction {
	
	private static final Logger LOG = Logger.getLogger(ProcessDrawAction.class);
	
	@Autowired
	private ProcessDrawService processDrawService;
	
	@RequestMapping("drawRun")
	public ModelAndView drawRun(HttpServletRequest request, String processId, String queryType, String appId, String scheduleDate, String depth) {
		ModelMap result = new ModelMap();
			try {
				int depthInt = CommUtils.parseInt(depth);
				result.put("svgData", processDrawService.getSvgXml(request.getSession(), processId, queryType, appId, scheduleDate, true, depthInt > 0 ? depthInt:100));
			} catch (Exception e) {
				LOG.error("get draw running process error:", e);
				result.put("err", "draw running processes error, please contact the administrator!");
			}
		return new ModelAndView(new MappingJacksonJsonView(), result);
	}
	
	@RequestMapping("drawDef")
	public ModelAndView drawDef(HttpServletRequest request, String processId, String queryType, String appId, String depth, String scheduleDate) {
		ModelMap result = new ModelMap();
		try {
			int depthInt = CommUtils.parseInt(depth);
			String svgData = processDrawService.getSvgXml(request.getSession(), processId, queryType, appId, scheduleDate, false, depthInt > 0 ? depthInt:100);
			if (CommUtils.isNotNull(svgData)) {
				result.put("svgData", svgData);
			} else {
				result.put("err", "The process has not any dependency relation of the process!!");
			}
		} catch (Exception e) {
			LOG.error("get draw running process error:", e);
			result.put("err", "draw running processes error, please contact the administrator!");
		}
		return new ModelAndView(new MappingJacksonJsonView(), result);
	}
}
