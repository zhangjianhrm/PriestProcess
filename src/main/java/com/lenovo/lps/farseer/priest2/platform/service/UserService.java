package com.lenovo.lps.farseer.priest2.platform.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	
	int updateUserInfo(String userName, String originPassword, String newPassword);
    
    /**
     * checkUser
     */
    public boolean checkUser(String userName, String passwd);
    
    /**
     * 系统登录验证
     */
    public boolean login(HttpServletRequest request, HttpServletResponse response, String userName, String passwd);
}
