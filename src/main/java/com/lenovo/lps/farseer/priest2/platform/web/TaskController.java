package com.lenovo.lps.farseer.priest2.platform.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.manager.TaskManager;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.TaskExcel;

@Controller
@RequestMapping("/task")
public class TaskController {
	private static final String CONTENT_DISPOSITION = "Content-Disposition";

	private final Logger logger = Logger.getLogger(TaskController.class);

	@Autowired
	private TaskManager taskManager;

	@Autowired
	private TaskExcel taskExcel;
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "searchTask", method = RequestMethod.POST)
	public ModelAndView searchTask(Integer processId, String processName, String execDate, Integer rows, Integer page, String sidx,
			String sord) {
		ModelMap modelMap = new ModelMap();

		try {
			String processIdStr = processId == null ? null : String.valueOf(processId);
			List<TaskOfProcessEntity> entities = null;
			Integer totalPages = 0, totalRecords = 0;

			Map<String, Integer> records = taskManager.getTaskTotalPage(processIdStr, processName, execDate, rows);

			if (records.get(Constants.RESPONSE_RESULT_TOTALRECORDS) > 0) {
				entities = taskManager.getTaskOfProcess(processIdStr, processName, execDate, rows, page, sidx, sord);
			}

			totalPages = records.get(Constants.RESPONSE_RESULT_TOTALPAGES);
			totalRecords = records.get(Constants.RESPONSE_RESULT_TOTALRECORDS);

			modelMap.put(Constants.RESPONSE_RESULT_TOTALPAGES, totalPages);
			modelMap.put(Constants.RESPONSE_RESULT_TOTALRECORDS, totalRecords);
			modelMap.put(Constants.RESPONSE_RESULT_CURRENTPAGE, page);
			modelMap.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, entities);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("err", StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "searchProcessOnExecDate", method = RequestMethod.POST)
	public ModelAndView searchProcessOnExecDate(String processId, String execDate) {
		ModelMap modelMap = new ModelMap();
		String tintProcess = null;
		try {
			tintProcess = taskManager.tintProcess(processId, execDate);

			modelMap.put(Constants.RESPONSE_MESSAGES, tintProcess);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("err", StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
		}

		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	@RequestMapping(value = "taskExcel11")
	public void taskexcel(HttpServletResponse response, String execDate, String processName, Integer processId, Integer rows,
			Integer page, String sidx, String sord) throws IOException {
		response.setHeader(CONTENT_DISPOSITION, "filename=task_" + execDate + ".xls");// 指定下载的文件名
		response.setContentType("application/vnd.ms-excel");

		try {
			taskExcel.taskexcel(response.getOutputStream(), execDate, processName, processId, rows, page, sidx, sord);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.getWriter().print(e.toString());
		}

	}

	@RequestMapping(value = "downTaskErrLog")
	public void downTaskErrLog(String errFileName, HttpServletResponse response) throws IOException{
		response.setHeader(CONTENT_DISPOSITION, "filename=" + errFileName);
		response.setContentType("application/x-msdownload");

		response.getWriter().write(taskService.downTaskErrLog(errFileName));
	}
}
