package com.lenovo.lps.farseer.priest2.platform.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.lenovo.leapid.common.Leapid;
import com.lenovo.leapid.common.LeapidDao;
import com.lenovo.leapid.common.LeapidService;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;
import com.lenovo.lps.farseer.priest2.platform.service.UserService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.FileUtils;

public class UserServiceImpl implements UserService {
	
    private static DataSource devDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(ConfigUtil.getContextProperty("leapid.database.driver", "com.mysql.jdbc.Driver"));
        ds.setUrl(ConfigUtil.getContextProperty("leapid.database.url", "jdbc:mysql://10.109.5.203:3306/leapid?"
        		+ "autoReconnect=true&useUnicode=true&characterEncoding=UTF-8"
        		+ "&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true"));
        ds.setUsername(ConfigUtil.getContextProperty("leapid.database.username", "root"));
        ds.setPassword(ConfigUtil.getContextProperty("leapid.database.password", "root"));
        return ds;
    }
	
	private LeapidService getLeapidService() {
		DataSource ds = devDataSource();
        LeapidDao dao  = new LeapidDao(ds);
        return new LeapidService(dao);
	}

	@Override
	public int updateUserInfo(String userName, String originPassword, String newPassword) {
		int result = 0;
		if (Constants.USER_ADMIN.equals(userName.toLowerCase())) {
			if (FileUtils.getAdminPwd().equals(originPassword)) {
				FileUtils.setAdminPwd(newPassword);
				result = 1;
			}
		} else {
			try {
				getLeapidService().updatePassword(userName, originPassword, newPassword);
				result = 1;
			} catch (Exception e) {
				result = 0;
			}
		}
		return result;
	}
	
    
    /**
     * 系统登录验证
     */
    public boolean checkUser(String userName, String passwd) {
    	Leapid user = null;
    	if (Constants.USER_ADMIN.equals(userName.toLowerCase())) {
    		if (FileUtils.getAdminPwd().equals(passwd)) {
    			user = new Leapid();
    			user.setUsername("admin");
    		}
    	} else {
    		user = getLeapidService().getLeapid(userName, passwd);
    	}
        
        // 用户不存在
        if(user == null || CommUtils.isEmpty(user.getUsername())) {
            // 用户名或密码不正确
            return false;
        } 
        AuditLog.log(String.format("Check user [%s]!", user.getUsername()));
        return true;
    }
    
    /**
     * 系统登录验证
     */
    public boolean login(HttpServletRequest request, HttpServletResponse response, String userName, String passwd) {
    	Leapid user = null;
    	if (Constants.USER_ADMIN.equals(userName.toLowerCase())) {
    		if (ConfigUtil.getContextProperty("user.admin.passwd", "admin").equals(passwd)) {
    			user = new Leapid();
    			user.setUsername("admin");
    		}
    	} else {
    		user = getLeapidService().getLeapid(userName, passwd);
    	}
        
        // 用户不存在
        if(user == null || CommUtils.isEmpty(user.getUsername())) {
            // 用户名或密码不正确
            return false;
        } 
        
        AccessSession.saveAccessInfo(request.getSession(), userName);
        AuditLog.log(request.getSession(), String.format("User [%s] access this system!", user.getUsername()));
        return true;
    }
}
