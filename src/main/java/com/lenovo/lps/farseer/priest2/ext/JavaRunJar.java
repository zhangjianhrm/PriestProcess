/**
 * 
 */
package com.lenovo.lps.farseer.priest2.ext;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;

/**
 * @author hubin3
 * 
 */
public class JavaRunJar {
	private static Logger logger = Logger.getLogger(JavaRunJar.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		String usage = "JavaRunJar jarFile [mainClass] appuser args...";

		if (args.length < 1) {
			logger.error(usage);
			System.exit(-1);
		}

		int firstArg = 0;
		String fileName = args[firstArg++];
		String mainClassName = null;

		if (mainClassName == null) {
			if (args.length < 2) {
				logger.error(usage);
				System.exit(-1);
			}
			mainClassName = args[firstArg++];
		}
		
		//主方法
		String method = args[firstArg++];
		if (CommUtils.isEmpty(method)) {
			method = "main";
		}
		
		//主方法
		String securityType = args[firstArg++];
		if (CommUtils.isEmpty(securityType)) {
			securityType = "simple";
		}

		String configPath = args[firstArg++];
		if (CommUtils.isEmpty(configPath)) {
			configPath = "/etc/hadoop/conf";
		}
		
		// 业务用户
		String appUser = args[firstArg++];
		if (appUser == null) {
			logger.error(usage);
			System.exit(-1);
		}
		
		ClassLoader preClassLoader = Thread.currentThread().getContextClassLoader();
		// 即将运行的class
		Class<?> runClass = null;
		try {
			runClass = Class.forName(mainClassName, true, preClassLoader);
		} catch (ClassNotFoundException ex) {

		}
		
		URLClassLoader newClassLoader = null;
		try {
			// class尚未加载
			if (runClass == null) {
				URL dir = new File(fileName).getParentFile().toURI().toURL();
				URL jar = new URL("jar:file://" + new File(fileName).getAbsolutePath() + "!/");
				URL[] urls = new URL[] { dir, jar };

				newClassLoader = URLClassLoader.newInstance(urls, preClassLoader);

				runClass = Class.forName(mainClassName, true, newClassLoader);
			}
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException("Class can't found in jar:" + fileName + " .className:" + mainClassName, e);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		try {
			Thread.currentThread().setContextClassLoader(newClassLoader);
			final Method main = getMethod(mainClassName, method, runClass);
			final String[] newArgs = Arrays.asList(args).subList(firstArg, args.length).toArray(new String[0]);
			if ("kerberos".equals(securityType)) {
				HadoopUgiUtil.doAs(new File(configPath), appUser, new PrivilegedExceptionAction<Void>() {
					@Override
					public Void run() {
						try {
							main.invoke(null, new Object[] { newArgs });
						} catch (Exception e) {
							throw new PriestPlatformException(e);
						}
						return null;
					}
				});
			} else {
				try {
					main.invoke(null, new Object[] { newArgs });
				} catch (Exception e) {
					throw new PriestPlatformException(e);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
	}

	private static Method getMethod(String className, String runMethodName, Class<?> runClass) {
		Method[] methods = runClass.getMethods();
		Method method = null;
		if (methods == null || methods.length <= 0) {
			throw new PriestPlatformException("Class doesn't have the method:" + className);
		}
		for (Method m : methods) {
			if (m.getName().equals(runMethodName)) {
				method = m;
				break;
			}
		}
		return method;
	}
}
