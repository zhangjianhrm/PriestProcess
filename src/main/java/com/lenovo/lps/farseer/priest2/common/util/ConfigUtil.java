package com.lenovo.lps.farseer.priest2.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 读取配置文件工具类
 * 
 * @author yujianwei
 * 
 */
public class ConfigUtil extends PropertyPlaceholderConfigurer {
	private static Map<String, String> ctxPropertiesMap = new HashMap<String, String>();
	
//	private static long last_modify = 0l;
//	private static String file_name = "process-config.properties";

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}
	
//	public static synchronized void reload() {
//		try {
//			InputStream in = null;
//			try {
//				File f = new File(ConfigUtil.class.getClassLoader().getResource(file_name).getFile());
//				if (last_modify < f.lastModified()) {
//					in = ConfigUtil.class.getClassLoader().getResourceAsStream(file_name);
//					Properties props = new Properties();
//					props.load(in);
//					for (Object key : props.keySet()) {
//						String keyStr = key.toString();
//						String value = props.getProperty(keyStr);
//						ctxPropertiesMap.put(keyStr, value);
//					}
//					last_modify = f.lastModified();
//					AuditLog.log("reload process-config.properties success");
//				}
//			} catch (Exception e) {
//				AuditLog.log("reload process-config.properties error:" + e.getMessage());
//			} finally {
//				if (in != null) {
//					try {
//						in.close();
//					} catch (IOException e) {}
//				}
//			}
//		} catch (Exception e) {}
//	}

	public static String getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}
	
	public static void setContextProperty(String name, String value) {
		ctxPropertiesMap.put(name, value);
	}
	
	public static String getContextProperty(String name, String defaultValue) {
		return CommUtils.isNull(ctxPropertiesMap.get(name)) ? defaultValue:ctxPropertiesMap.get(name);
	}

}
