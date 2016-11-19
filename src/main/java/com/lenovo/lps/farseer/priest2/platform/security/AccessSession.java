package com.lenovo.lps.farseer.priest2.platform.security;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * SESSION管理
 * 
 * @author liyi7
 */
public final class AccessSession {
    private static final String I18N = "_I18N";
    
    /**
     * 获取访问用户
     */
    public static Locale getLocale(HttpServletRequest request) {
    	Object obj = request.getSession().getAttribute(request.getSession().getId() + I18N);
    	Locale i18n = request.getLocale();
    	if (obj != null) {
    		i18n = (Locale)obj;
    	} else {
    		if (!"zh".equals(i18n.getLanguage().toLowerCase())) {
    			i18n = new Locale("en");
    		} else {
    			i18n = new Locale("zh");
    		}
    		saveI18n(request.getSession(), i18n);
    	}
    	return i18n;
    }
    
    /**
     * 获取访问用户
     */
    public static String getAccessUser(HttpSession session) {
    	Object obj = session.getAttribute(session.getId());
    	String user = "";
    	if (obj != null) {
    		user = String.valueOf(obj);
    	}
    	return user;
    }
    
	
	/**
	 * 获取登陆用户角色id
	 */
	public static boolean getUserIsAdmin(HttpSession session) {
		return Constants.USER_ADMIN.equals(getAccessUser(session).toLowerCase());
	}

	/**
     * 保存访问信息
     */
    public static void saveAccessInfo(HttpSession session, String userName) {
        session.setAttribute(session.getId(), userName);
    }
    
    /**
     * 保存国际化信息
     */
    public static void saveI18n(HttpSession session, Locale locale) {
        session.setAttribute(session.getId() + I18N, locale);
    }
    
    /**
     * 清除访问信息
     */
    public static void removeAccessInfo(HttpSession session) {
        session.removeAttribute(session.getId());
        session.removeAttribute(session.getId() + I18N);
    }
}
