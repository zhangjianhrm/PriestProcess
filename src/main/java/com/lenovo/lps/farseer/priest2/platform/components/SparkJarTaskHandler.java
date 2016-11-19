package com.lenovo.lps.farseer.priest2.platform.components;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.SparkJarService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

public class SparkJarTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	private final Logger logger = Logger.getLogger(SparkJarTaskHandler.class);
	@Autowired
	@Qualifier("sparkJarService")
	private SparkJarService sparkJarService;

	@Resource
	private ApplicationService applicationService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		try {
			String mainClass = jsonNode.get(Constants.COMPONENTS_PARAMS_SPARKJAR_MAINCLASS).getTextValue();
			String params = jsonNode.get(Constants.COMPONENTS_PARAMS_SPARKJAR_PARAMES).getTextValue();
			String mrJar = jsonNode.get(Constants.COMPONENTS_PARAMS_SPARKJAR_JAR).getTextValue();
			String mrJarPath = new File(ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/"), mrJar).getCanonicalPath();
			String taskName = jsonNode.get("taskName").getTextValue();

			Map<String, Object> componentParams = new HashMap<String, Object>();
			componentParams.put("mainClass", mainClass);
			componentParams.put("params", params);
			componentParams.put("jar", mrJarPath);
			componentParams.put("taskName", taskName);

			return componentParams;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		String mainClass = (String) params.get("mainClass");
		String jobParams = (String) params.get("params");
		String jarPath = (String) params.get("jar");
		String taskName = (String) params.get("taskName");
		String appName = (String) params.get("appName");

		// 前端属性传过来形式为:key1=value1\nkey2=value2\n
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (StringUtils.hasText(jobParams)) {
			String[] props = jobParams.split("\n");
			// key=value
			for (String prop : props) {
				int index = prop.indexOf("=");
				String key = prop.substring(0, index);
				String value = prop.substring(index + 1);
				map.put(key, value);
			}
		}

		sparkJarService.submit(taskName, jarPath, mainClass, map, 
				applicationService.getApp(Integer.valueOf(appName)).get("appUser"));

		return null;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为map reduce任务
		return ComponentsType.SPARKJAR;
	}

}
