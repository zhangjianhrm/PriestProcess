package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.SparkJdbcService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

public class SparkSqlTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	@Resource
	private SparkJdbcService sparkJdbcService;

	@Resource
	private ApplicationService applicationService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// 输入hive sql
		String hiveSql = jsonNode.get(Constants.COMPONENTS_PARAMS_SPARK_SQL).getTextValue();

		Map<String, Object> componentParams = new HashMap<String, Object>();
		hiveSql = hiveSql == null ? "" : hiveSql.trim();
		componentParams.put("ssql", hiveSql);

		return componentParams;

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		String sparkSql = (String) params.get("ssql");
		String appId = (String) params.get("appName");

		Map<String, String> app = applicationService.getApp(Integer.valueOf(appId));
		if (app == null || CommUtils.isNull(app.get("appUser"))) {
			throw new RuntimeException("no spark database find, please contact the administrator to Add.");
		}
		// 统计信息对象
		StatParam statParam = new StatParam();
		statParam.setAppName(app.get("name").toLowerCase());
		statParam.setAppUser(app.get("appUser"));
		statParam.setExecDate(String.valueOf(params.get("execDate")));
		statParam.setProcessId(Integer.valueOf(String.valueOf(params.get(Constants.COMPONENTS_PARAMS_PROCESS_ID))));
		statParam.setTaskId(Integer.valueOf(String.valueOf(params.get("taskId"))));
		
		return sparkJdbcService.sparkExecute(sparkSql, statParam);
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为HIVE SQL执行
		return ComponentsType.SPARKSQL;
	}
}
