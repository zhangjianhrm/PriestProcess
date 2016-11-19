package com.lenovo.lps.farseer.priest2.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ABHandlerInterceptor extends HandlerInterceptorAdapter  {

	String getVerionPrefix(HttpServletRequest request) {
		String ver = null ;
		for( Cookie ck : request.getCookies()){
			if ( "ver".equals(ck.getName())) {
				ver = ck.getValue() ;
				break ;
			}			
		}
		if ( "resources".equals(ver)){
			return "../../views/" ;
		}
		return null ;
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if ( modelAndView != null && modelAndView.getViewName() != null  ){
			String prefix = getVerionPrefix(request) ;
			if ( prefix != null ) {
				modelAndView.setViewName(prefix + modelAndView.getViewName() ) ;
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}
