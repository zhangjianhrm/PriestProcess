package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.OracleService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class OracleTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	@Resource
	private ProcessService processService;

	@Resource
	private ApplicationService aplicationService;

	@Resource
	private OracleService oracleService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		String sql = jsonNode.get("sql").getTextValue();
		sql = (sql == null) ? "" : sql.trim();

		// Oracle库
		JsonNode rdbmsDBNode = jsonNode.get(Constants.COMPONENTS_PARAMS_RDBMS);
		/**
		 * <pre>
		 * 历史版本界面不能选择多数据源，历史数据没有数据源信息。
		 * 本版本上线时，会在P_DATABASE表加db_name字段，历史数据源统一叫default
		 * </pre>
		 */
		String rdbmsDB = rdbmsDBNode != null ? rdbmsDBNode.getTextValue() : Constants.DATABASE_DEFAULT_NAME;

		Map<String, Object> componentParams = new HashMap<String, Object>();
		componentParams.put("sql", sql);
		componentParams.put("rdbmsDB", rdbmsDB);
		return componentParams;
	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		String sql = (String) params.get("sql");

		// 查询数据库配置
		String processId = (String) params.get("processId");
		ProcessEntity process = processService.getProcessDef(processId);
		String rdbmsDB = (String) params.get("rdbmsDB");

		DbEntity oracle = aplicationService.getAppDbConfig(Integer.valueOf(process.getProcessApp()), DbTypeEnum.Oracle, rdbmsDB);

		Object result = null;
		// 多条SQL，通过";"分割
		if (sql.indexOf(';') != -1) {
			String[] sqls = StringUtil.replaceSemicolon(sql).split(";");
			for (String oneSql : sqls) {
				if (StringUtils.hasText(oneSql)) {
					oneSql = StringUtil.replace2Semicolon(oneSql);
					result = execOneSql(oneSql, oracle);
				}
			}
		} else {
			result = execOneSql(sql, oracle);
		}

		return result;
	}

	private Object execOneSql(String sql, DbEntity dbArgs) {
		Object result = oracleService.executeSql(sql, dbArgs);

		// select只有一个结果时，从List<Map<String, Object>>中取出结果
		if (result instanceof List) {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> tmp = (List<Map<String, Object>>) result;
			if (tmp.size() >= 1) {
				Object v = tmp.get(0).values().iterator().next();
				if (v instanceof String || v instanceof Number || v instanceof Date) {
					result = v;
				} else {
					result = null;
				}
			} else {
				result = null;
			}
		}

		return result;
	}

	@Override
	protected ComponentsType getComponetType() {
		return ComponentsType.ORACLE;
	}

}
