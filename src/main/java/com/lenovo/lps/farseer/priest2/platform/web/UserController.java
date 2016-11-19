package com.lenovo.lps.farseer.priest2.platform.web;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Resource
	private ApplicationService appService;
	
	@RequestMapping(value = "setI18n", method = RequestMethod.GET)
	public ModelAndView setI18n(HttpServletRequest request, HttpServletResponse response, String i18nType) {
		ModelAndView result = null;
		try {
			Locale locale = request.getLocale();
			if (CommUtils.isNotEmpty(i18nType)) {
				String[] i18ns = i18nType.split("_"); 
				locale = i18ns.length > 1 ? new Locale(i18ns[0], i18ns[1]):new Locale(i18nType);
			}
			AccessSession.saveI18n(request.getSession(), locale);
			AuditLog.log(request.getSession(), "change the i18n!", i18nType);
			result = new ModelAndView("redirect:/views/process_run_list.jsp");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return result;
	}
	
    // 首页
    @RequestMapping(value = "index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	ModelAndView result = null;
    	try {
    		result = new ModelAndView("redirect:/views/process_run_list.jsp");
    	} catch (Exception e) {
    		logger.error("Single Login Error:", e);
    		result = new ModelAndView("redirect:/views/403.jsp");
    	}
    	return result;
    }
	
    /**
     * 登出
     */
    @RequestMapping(value = "logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)  throws IOException {
    	ModelAndView result = null;
		try {
			AccessSession.removeAccessInfo(request.getSession());
			result = new ModelAndView("login");
		} catch (Exception e) {
			logger.error("Logout Lenovoid Error!", e);
			result = new ModelAndView("redirect:/views/403.jsp");
		}
		return result;
    }
    
    /**
     * 登录
     */
    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String j_username, String j_password) {
    	ModelAndView result = null;
        try {
        	if (CommUtils.isNull(j_username) && CommUtils.isNull(j_password)) {
        		 result =  new ModelAndView("login");
        	} else {
        		if(userService.login(request, response, j_username, j_password)) {
        			result = new ModelAndView("redirect:/user/index.do");
                } else {
                	result =  new ModelAndView("login", "err", "Login failed, username or password error!");
                }
        	}
        } catch (Exception e) {
			logger.error("Login Lenovoid Error!", e);
			result =  new ModelAndView("login", "err", "Login Error, please contact the administator!");
		}
        return result;
    }
	
	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "modifyByUser", method = RequestMethod.POST)
	public ModelAndView modifyByUser(HttpServletRequest request, String j_username, String j_origin_pwd, String j_password) {
		ModelMap modelMap = new ModelMap();
		
		try {
			int result = userService.updateUserInfo(j_username, j_origin_pwd, j_password);
			modelMap.put("result", result);
			AuditLog.log(request.getSession(), "modifyByUser", j_username, j_origin_pwd, j_password);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("err", "Modify Error:" + e.getMessage());
		}
		
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}
}
