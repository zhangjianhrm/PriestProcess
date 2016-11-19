package com.lenovo.lps.farseer.priest2.platform.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.lenovo.lps.farseer.priest2.platform.dal.IdDao;

@Controller
@RequestMapping("/idGen")
public class IdGeneratorController {
	private final Logger logger = Logger.getLogger(IdGeneratorController.class);
	private static final String TASK_ID = "T";
	private static final String PROCESS_ID = "P";
	private static final String ERR_RETURN = "IdType must be 'T' or 'P'";
	@Autowired
	private IdDao idDao;

	@RequestMapping(value = "genId", method = RequestMethod.GET)
	public ModelAndView genId(String idType) {
		ModelMap modelMap = new ModelMap();
		try {
			Object id = null;
			// task id
			if (TASK_ID.equals(idType)) {
				id = idDao.genTaskId();
			}
			// process id
			else if (PROCESS_ID.equals(idType)) {
				id = idDao.genProcessId();
			}
			// 异常数据
			else {
				modelMap.addAttribute("err", ERR_RETURN);
			}

			modelMap.addAttribute("id", id);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

}
