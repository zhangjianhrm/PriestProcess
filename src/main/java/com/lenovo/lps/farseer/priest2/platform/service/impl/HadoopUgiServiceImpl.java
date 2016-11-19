/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.net.URL;
import java.security.PrivilegedExceptionAction;

import javax.annotation.PostConstruct;

import org.apache.hadoop.security.UserGroupInformation;
import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.config.HadoopConfigurationFactory;
import com.lenovo.lps.farseer.priest2.platform.service.HadoopUgiService;

/**
 * @author niexm1
 * 
 */
public class HadoopUgiServiceImpl implements HadoopUgiService {
	private final static Logger logger = Logger.getLogger(HadoopUgiServiceImpl.class);
	public final static boolean isWindows = System.getProperty("os.name").startsWith("Windows");
	
	// priest工程使用的kerberos用户名
	public final static String PRIEST_KERBEROS_USER_NAME = "priest";

	/**
	 * 用hadoop configuration初始化UserGroupInformation类
	 * 
	 * @throws IOException
	 */
	@PostConstruct
	private void initUGI() throws IOException {
		/**
		 * <pre>
		 * 本段代码比较重要，
		 * 通过本行设置priest工程请求hadoop cluster时，相关用户配置从项目hadoop目录下配置文件中获取
		 * 　　否则applicationContext-platform.xml实例化org.apache.hadoop.fs.FileSystem时，
		 * 　　使用hadoop默认configuration，默认使用simple认证，取当前ＯＳ登陆用户
		 * </pre>
		 */
		priestLogin();

	}

	/**
	 * 为业务创建proxy user
	 * 
	 * @param appUser
	 * @param action
	 * @return
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static <T extends Object> T doAs(String appUser, PrivilegedExceptionAction<T> action) throws IOException, InterruptedException {
		// 当前系统用户，在initUGI()方法中指定priest账户登陆
		if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase())) {
			loginUser(PRIEST_KERBEROS_USER_NAME);
			UserGroupInformation currentUser;
			try {
				currentUser = UserGroupInformation.getCurrentUser();

			} catch (IOException e) {
				throw new PriestPlatformException(e);
			}

			if (currentUser == null){
				throw new PriestPlatformException("priest not login kerberos");
			}
			
			if (!PRIEST_KERBEROS_USER_NAME.equals(currentUser.getShortUserName())){
				throw new PriestPlatformException("priest not login kerberos");
			}
			
			/**
			 * 
			 <pre>
			 * 		 创建代理用户
			 * 		 代理用户使用场景：假设u_vctl账户没有ticket/keytab，想提交mapred job或者操作hdfs文件.
			 * 		 代理用户使用Real User(priest)的ticket/keytab，提交job时，用户设置为u_vctl,
			 *      代理用户使用Real User(priest)的ticket/keytab，创建hdfs的用户属主为u_vctl
			 * </pre>
			 * 
			 */
			AuditLog.log(String.format("doas currentUser[%s] appUser[%s]", currentUser, appUser));
			UserGroupInformation proxyUser = UserGroupInformation.createProxyUser(appUser, currentUser);

			return proxyUser.doAs(action);
		} else {
			try {
				return action.run();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

	/**
	 * 登陆用户
	 * 
	 * @param user
	 * @throws IOException
	 */
	public static void loginUser(String userName) throws IOException {

		URL keytab = Thread.currentThread().getContextClassLoader().getResource("keytab/" + userName + ".keytab");
		if (keytab == null) {
			throw new PriestPlatformException("Can't get kertab for user:" + userName);
		}

		// windows路径以也以"/"开头,如/d:/xxx,需要去掉
		String keytabFullPath = isWindows ? keytab.getFile().substring(1) : keytab.getFile();
		// 为当前线程登陆用户
		if (logger.isInfoEnabled()){			
			logger.info("loginUserFromKeytab :" + userName+":"+keytabFullPath );
		}
		try {
			HadoopConfigurationFactory.copyConfigToClasspath();
			UserGroupInformation.loginUserFromKeytab(userName + "/`hostname -f`", keytabFullPath);
		} catch (Exception e) {
			logger.error(String.format("kinit [%s] keytab [%s] error:", userName + "/`hostname -f`", keytabFullPath));
			UserGroupInformation.loginUserFromKeytab(userName, keytabFullPath);
		}

	}

	/**
	 * priest工程登陆kerberos
	 * 
	 * @throws IOException
	 */
	public static void priestLogin() throws IOException {
		if ("kerberos".equals(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase())) {
			loginUser(PRIEST_KERBEROS_USER_NAME);
		}
	}

}
