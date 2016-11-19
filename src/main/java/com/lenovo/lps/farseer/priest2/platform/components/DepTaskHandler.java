package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.DependentService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * 依赖组件实现代码
 * 
 * @author niexm1
 * 
 */
public class DepTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	@Autowired
	private DependentService depService;
	@Resource
	private ApplicationService aplicationService;
	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// 依赖其它流程id
		String target = jsonNode.get(Constants.COMPONENTS_PARAMS_DEP_PROCESS_ID).getTextValue();
		String depType = jsonNode.get("depType").getTextValue(), targetNum = "", depDbType = "", rdbmsDB = "";
		if ("hdfs_size".equals(depType)) {
			targetNum = jsonNode.get("targetNum").getTextValue();
		} else if ("tbl_count".equals(depType)) {
			targetNum = jsonNode.get("targetNum").getTextValue();
			depDbType = jsonNode.get("depDbType").getTextValue();
			if ("oracle".equals(depDbType) || "mysql".equals(depDbType)) {
				rdbmsDB = jsonNode.get("rdbmsDB").getTextValue();
			}
		}
		
		Map<String, Object> componentParams = new HashMap<String, Object>();

		componentParams.put("target", target);
		componentParams.put("depType", depType);
		componentParams.put("targetNum", targetNum);
		componentParams.put("rdbmsDB", rdbmsDB);
		componentParams.put("depDbType", depDbType);
		return componentParams;
	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		Object value = null;
		String depDate = (String) params.get("execDate");
		String depType = (String) params.get("depType");
		String target = (String) params.get("target");
		String targetNum = (String) params.get("targetNum");
		String processId = String.valueOf(params.get("processId"));
		String interrupteKey = processId + "_" + depDate;
		try {
			if ("process".equals(depType)) {
				depService.waitProcess(Integer.valueOf(target), depDate, interrupteKey);
			} else if ("hdfs_dir".equals(depType)) {
				depService.waitHdfsDir(target, interrupteKey);
			} else if ("hdfs_size".equals(depType)) {
				depService.waitHdfsSize(target, targetNum, interrupteKey);
			} else if ("tbl_count".equals(depType)) {
				String depDbType = (String) params.get("depDbType");
				String rdbmsDB = (String) params.get("rdbmsDB");
				String appId = (String) params.get("appName");
				if ("mysql".equals(depDbType)) {
					DbEntity mysql = aplicationService.getAppDbConfig(Integer.valueOf(appId), DbTypeEnum.MySQL, rdbmsDB);
					depService.waitMysqlNum(target, targetNum, mysql, interrupteKey);
				} else if ("oracle".equals(depDbType)) {
					DbEntity oracle = aplicationService.getAppDbConfig(Integer.valueOf(appId), DbTypeEnum.Oracle, rdbmsDB);
					depService.waitOracleNum(target, targetNum, oracle, interrupteKey);
				} else if ("spark".equals(depDbType)) {
					Map<String, String> app = aplicationService.getApp(Integer.valueOf(appId));
					// 统计信息对象
					StatParam statParam = new StatParam();
					statParam.setAppName(app.get("name").toLowerCase());
					statParam.setAppUser(app.get("appUser"));
					statParam.setExecDate(depDate);
					statParam.setProcessId(Integer.valueOf(processId));
					statParam.setTaskId(Integer.valueOf(String.valueOf(params.get("taskId"))));
					depService.waitSparkNum(target, targetNum, statParam, interrupteKey);
				}
			}
		}
		// Exception抛到AbstractTaskHandler处理
		catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		return value;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为依赖类型
		return ComponentsType.DEP;
	}
}
