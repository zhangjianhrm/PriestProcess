package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveService;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

public class HiveTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	@Resource
	private HiveService hiveService;

	@Resource
	private ApplicationService applicationService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// 输入hive sql
		String hiveSql = jsonNode.get(Constants.COMPONENTS_PARAMS_HIVE_SQL).getTextValue();

		Map<String, Object> componentParams = new HashMap<String, Object>();
		hiveSql = hiveSql == null ? "" : hiveSql.trim();
		componentParams.put("hiveSql", hiveSql);

		return componentParams;

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		String hiveSql = (String) params.get("hiveSql");
		String appId = (String) params.get("appName");

		Map<String, String> app = applicationService.getApp(Integer.valueOf(appId));
		
		if (app == null || CommUtils.isNull(app.get("appUser"))) {
			throw new PriestPlatformException("hive db is null, please contact administrator, thanks!");
		}

		// 统计信息对象
		StatParam statParam = new StatParam();
		statParam.setAppName(app.get("name").toLowerCase());
		statParam.setAppUser(app.get("appUser"));
		statParam.setExecDate(String.valueOf(params.get("execDate")));
		statParam.setProcessId(Integer.valueOf(String.valueOf(params.get(Constants.COMPONENTS_PARAMS_PROCESS_ID))));
		statParam.setTaskId(Integer.valueOf(String.valueOf(params.get("taskId"))));
		
		return hiveService.hiveExecute(hiveSql, statParam);
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为HIVE SQL执行
		return ComponentsType.HIVE;
	}
}
