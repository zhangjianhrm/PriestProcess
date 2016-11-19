package com.lenovo.lps.farseer.priest2.platform.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.manager.SMManager;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.RequestUtils;

@Controller
@RequestMapping("/sms")
public class SMSController {

	@Autowired
	@Qualifier("smManager")
	private SMManager smManager;

	private static Logger logger = Logger.getLogger(SMSController.class);

	@RequestMapping(value = "sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(HttpServletRequest request, String phoneNumbers, String context) {
		String ipAddr = RequestUtils.getIpAddr(request);
		if (CommUtils.isEmpty(ipAddr)) {
			ipAddr = "unkown";
		}
		logger.warn(String.format("Ip address:[%s] send message[%s] to [%s]", ipAddr, context, phoneNumbers));
		String phoneNums = null, message = "sucessfull";
		if (StringUtils.isNotEmpty(phoneNumbers)) {
			phoneNums = phoneNumbers;
		}
		try {
			smManager.sendMessage(ipAddr, phoneNums, context);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			message = e.getMessage();
			AuditLog.log(request.getSession(), "sms.sendMessage Exceptions",phoneNumbers,context);
		}
		ModelMap modelMap = new ModelMap();
		modelMap.put(Constants.RESPONSE_MESSAGES, message);
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}
}
