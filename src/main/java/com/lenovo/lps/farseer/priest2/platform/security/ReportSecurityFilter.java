package com.lenovo.lps.farseer.priest2.platform.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.service.UserService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * @author nazhiwei
 * 
 * 报表页面过滤器，没有配置用户与应用映射的，拒绝访问
 */
public class ReportSecurityFilter implements Filter{
//    private static final Logger CALOG = Logger.getLogger(ReportSecurityFilter.class);

	@Autowired
	private UserService userService;
	
	private static List<String> filterPages;
	
	private static List<String> passPages;
	private static final String errPage = "/views/403.jsp";
	
	static {
		filterPages = new ArrayList<String>();
		passPages = new ArrayList<String>();
		passPages.add("/resources/");
		passPages.add("/user/logout.do");
		passPages.add("/user/login.do");
		passPages.add("/views/403.jsp");
		passPages.add("/views/login.jsp");
		passPages.add("/pulse/");
		passPages.add("/sms/sendMessage.do");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		String servletPath = httpRequest.getServletPath();
		
		for (String passPage: passPages) {
			if (servletPath.contains(passPage)) {
				chain.doFilter(request, response);
				return;
			}
		}
		// 登录控制
        String user = AccessSession.getAccessUser(httpRequest.getSession());
 		// 登陆用户为空，无权限，跳转至登陆页面
    	if (CommUtils.isEmpty(user) || "\"\"".equals(user)) {
    		if (httpRequest.getHeader("x-requested-with") != null 
                      && httpRequest.getHeader("x-requested-with").
                      equalsIgnoreCase("XMLHttpRequest")){//如果是ajax请求响应头会有，x-requested-with； 
    			  httpResponse.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
    			  response.setContentType("application/json;charset=utf-8");
				  response.getWriter().write("{\"code\":-200}");
    			  return;
           } else {
        	   httpRequest.getRequestDispatcher("/user/login.do").forward(request, response);
				return;
           }
    	}
 		
 		if (servletPath.contains("/views/login.jsp") || servletPath.contains("/user/login.do")) {
 			httpRequest.getRequestDispatcher("/user/index.do").forward(request, response);
 			return;
 		}
 		
 		if ("/".equals(servletPath) || servletPath.endsWith("/priest/") || servletPath.endsWith("/priest")) {
 			httpRequest.getRequestDispatcher("/user/index.do").forward(request, response);
 			return;
 		}
		if(filterPages.contains(servletPath)){
			if(!Constants.USER_ADMIN.equals(AccessSession.getAccessUser(httpRequest.getSession()))){
				request.getRequestDispatcher(errPage).forward(request, response);
				return;
			}
		}
		httpRequest.getSession().setMaxInactiveInterval(360*60);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getServletContext());
		userService = (UserService) context.getBean("userService");
	}

	@Override
	public void destroy() {}
}
