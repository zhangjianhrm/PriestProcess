package com.lenovo.lps.farseer.priest2.platform.components;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * Shell组件实现代码
 * 
 * @author niexm1
 * 
 */
public class ShellTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	@Autowired
	private ShellService shellService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		try {
			// Shell脚本文件
			String shellScript = new File(ConfigUtil.getContextProperty("file.upload.path", "/var/lib/priest/file_uploads/"), jsonNode.get(Constants.COMPONENTS_PARAMS_SHELL_FILE).getTextValue())
					.getCanonicalPath();
			// 参数
			String params = jsonNode.get(Constants.COMPONENTS_PARAMS_SHELL_PARAMS).getTextValue();

			Map<String, Object> componentParams = new HashMap<String, Object>();

			componentParams.put("shellScript", shellScript);
			componentParams.put("params", params);
			return componentParams;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		String shellScript = (String) params.get("shellScript");
		String shellParams = (String) params.get("params");
		try {
			return shellService.runCommand(shellScript, shellParams);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为java
		return ComponentsType.SHELL;
	}
}
