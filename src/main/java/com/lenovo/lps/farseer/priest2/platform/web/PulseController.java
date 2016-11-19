/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.manager.ProcessManager;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.service.UserService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.RequestUtils;

/**
 * @author hubin3
 * 
 */
@Controller
@RequestMapping("/pulse")
public class PulseController {
	private final Logger logger = Logger.getLogger(PulseController.class);

	private static final String ERROR = "err";

	@Resource
	private ScheduleService scheduleService;
	
	@Autowired
	private ProcessService processService ;
	
	@Autowired
	@Qualifier("processManager")
	private ProcessManager processManager;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = "cancelProcesses")
	public ModelAndView cancelProcesses(HttpServletRequest request, Integer firstProcessId, String userName, String passwd) {
		ModelMap modelMap = new ModelMap();
		try {
			validateUser(userName, passwd);
			
			validateUserPermission(request.getSession(), userName, firstProcessId) ;
			
			String execDate = DateUtils.getExecDateFromScheduleDate(DateUtils.getDayNow());
			Set<Integer> rerunProcessIds = new HashSet<Integer>();
			String message = "cancelProcesses:" + userName + "," + firstProcessId;
			logger.info(message);
			scheduleService.abortRunningProcesses(firstProcessId, execDate, rerunProcessIds);
			AuditLog.log(request.getSession(), "pulse.cancelProcesses",message);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	private void validateUser(String userName, String passwd) {
		if (!userService.checkUser(userName, passwd)){
			new PriestPlatformException("User Name doesn't exists or password error!");
		}
	}
	private void validateUserPermission(HttpSession session, String userName,Integer processId){
		if (Constants.USER_ADMIN.equals(userName)) {
			return ;
		}
		ProcessEntity pe = processService.getProcessDef(String.valueOf(processId)) ;
		if (pe.getCreatedBy().equals(userName)){
			return ;
		}
		throw new PriestPlatformException("Process:"+processId+" doesn't exists or user["+userName+"] has no permissions!" );
	}
	
	@RequestMapping(value = "pulseProcesses")
	public ModelAndView pulseProcesses(HttpServletRequest request) {
		Map<String, String> requestParam = getRequestParam(request);
		ModelMap modelMap = new ModelMap();
		try {
			String userName = requestParam.get("userName");
			String passwd = requestParam.get("passwd");
			Integer firstProcessId = Integer.valueOf(requestParam.get("firstProcessId"));
			
			validateUser(userName, passwd);			
			validateUserPermission(request.getSession(), userName, firstProcessId) ;
			
			requestParam.remove("userName");
			requestParam.remove("passwd");
			String message = "pulseProcesses:" + userName + "," + requestParam;
			logger.info(message);
			scheduleService.pulseProcesses(requestParam);
			AuditLog.log(request.getSession(), "pulse.pulseProcesses",message);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}
	
	@RequestMapping(value = "processRunInfo")
	public ModelAndView processRunInfo(HttpServletRequest request) {
		Map<String, String> requestParam = getRequestParam(request);
		String processIdStr = requestParam.get("processId"), execDate = requestParam.get("execDate");
		ModelMap modelMap = new ModelMap();
		try {
			Integer processId = Integer.valueOf(processIdStr);
			ProcessEntity process = processService.getProcessRun(processId, execDate);
			if (process != null) {
				modelMap.addAttribute("processId", process.getProcessId());
				modelMap.addAttribute("execDate", process.getExecDate());
				modelMap.addAttribute("startTime", process.getStartTime());
				modelMap.addAttribute("endTime", process.getEndTime());
				modelMap.addAttribute("status", process.getProcessStatus());
			} else {
				modelMap.addAttribute("info", String.format("the processId [%s] execDate [%s] running info is not exists, please send parameters (processId, execDate)!", processId, execDate));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, String.format("please send parameters (processId, execDate), the processId [%s] execDate [%s] running info error[%s]",
					processIdStr, execDate, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString()));
		}
		String ipAddr = RequestUtils.getIpAddr(request);
		if (CommUtils.isEmpty(ipAddr)) {
			ipAddr = "unkown";
		}
		AuditLog.log(request.getSession(), String.format("pulse ip address[%s] get process running info [%s]", ipAddr, modelMap));
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}
	
	@RequestMapping(value = "pulseProcessTask")
	public ModelAndView pulseProcessTask(HttpServletRequest request) {
		Map<String, String> requestParam = getRequestParam(request);
		ModelMap modelMap = new ModelMap();
		try {
			String userName = requestParam.get("userName");
			String passwd = requestParam.get("passwd");
			String firstProcessId = requestParam.get("firstProcessId");
			
			validateUser(userName, passwd);			
			validateUserPermission(request.getSession(), userName, Integer.valueOf(firstProcessId)) ;
			
			requestParam.remove("userName");
			requestParam.remove("passwd");
			String message = "pulseProcessTask:" + userName + "," + requestParam;
			logger.info(message);
			String execDate = DateUtils.getExecDateFromScheduleDate(DateUtils.getDayNow());
			processManager.retryProcess(firstProcessId, execDate, "pulseRetry", request.getSession());
			AuditLog.log(request.getSession(), "pulse.pulseProcessTask",message);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	private Map<String, String> getRequestParam(HttpServletRequest request) {
		Map<String, String> requestParam = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String key = names.nextElement();
			String value = request.getParameter(key);
			if (value == null || value.trim().equals("")) {
				continue;
			}
			requestParam.put(key, value);
		}
		return requestParam;
	}
}
