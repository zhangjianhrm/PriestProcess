package com.lenovo.lps.farseer.priest2.platform.components;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.JavaService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * JAVA组件实现代码
 * 
 * @author niexm1
 * 
 */
public class JavaTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	@Autowired
	private JavaService javaService;
	
	@Resource
	private ApplicationService applicationService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		try {
			// java文件
			String jar = new File(ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/"), jsonNode.get(Constants.COMPONENTS_PARAMS_JAVA_JAR_FILE).getTextValue())
					.getCanonicalPath();
			// 带包类名
			String className = jsonNode.get(Constants.COMPONENTS_PARAMS_JAVA_CLASS_NAME).getTextValue();
			// 方法名
			String methodName = jsonNode.get(Constants.COMPONENTS_PARAMS_JAVA_METHOD_NAME).getTextValue();
			// 参数
			String params = jsonNode.get(Constants.COMPONENTS_PARAMS_JAVA_PARAMS).getTextValue();

			Map<String, Object> componentParams = new HashMap<String, Object>();

			componentParams.put("jar", jar);
			componentParams.put("className", className);
			componentParams.put("methodName", methodName);
			componentParams.put("params", params);
			return componentParams;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		try {
			String jar = (String) params.get("jar");
			String className = (String) params.get("className");
			String methodName = (String) params.get("methodName");
			String javaParams = (String) params.get("params");
			String appName = (String) params.get("appName");

			javaService.runJavaMethod(jar, className, methodName, javaParams, 
					applicationService.getApp(Integer.valueOf(appName)).get("appUser"));
			return null;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为java
		return ComponentsType.JAVA;
	}
}
