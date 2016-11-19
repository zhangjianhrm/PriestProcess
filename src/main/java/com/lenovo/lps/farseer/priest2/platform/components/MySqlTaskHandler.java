package com.lenovo.lps.farseer.priest2.platform.components;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.MySQLService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

/**
 * mysql组件实现代码
 * 
 * @author niexm1
 * 
 */
public class MySqlTaskHandler extends AbstractTaskHandler implements WorkItemHandler {
	private final Logger logger = Logger.getLogger(MySqlTaskHandler.class);
	@Autowired
	private MySQLService mySQLService;
	@Resource
	private ApplicationService aplicationService;
	@Resource
	private ProcessService processService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// 输入SQL
		String sql = jsonNode.get(Constants.COMPONENTS_PARAMS_MYSQL_SQL).getTextValue();
		sql = sql == null ? "" : sql.trim();

		// MySQL库
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

		// 实时从数据库中查询应用mysql配置信息
		String processId = (String) params.get("processId");
		ProcessEntity process = processService.getProcessDef(processId);
		String rdbmsDB = (String) params.get("rdbmsDB");

		DbEntity mysql = aplicationService.getAppDbConfig(Integer.valueOf(process.getProcessApp()), DbTypeEnum.MySQL, rdbmsDB);

		Object value = null;
		// 多条 SQL,通过";"分隔
		if (sql.indexOf(';') > -1) {
			String[] sqls = StringUtil.replaceSemicolon(sql).split(";");
			for (String mysqlSql : sqls) {
				if (StringUtils.hasText(mysqlSql)) {
					mysqlSql = StringUtil.replace2Semicolon(mysqlSql);
					value = execOneSql(mysqlSql, mysql.getUserName(), mysql.getPassword(), mysql.getUrl(), mysql.getDriverClassName());
				}
			}
		}
		// 单条SQL
		else {
			value = execOneSql(sql, mysql.getUserName(), mysql.getPassword(), mysql.getUrl(), mysql.getDriverClassName());
		}

		return value;
	}

	/**
	 * 执行单条SQL
	 * 
	 * @param sql
	 * @param dbUserName
	 * @param dbPassword
	 * @param connectionUrl
	 * @param driverClassName
	 * @param value
	 * @return
	 */
	private Object execOneSql(String sql, String dbUserName, String dbPassword, String connectionUrl, String driverClassName) {
		Object value = null;
		try {
			value = mySQLService.runSql(sql, dbUserName, dbPassword, connectionUrl, driverClassName);

			if (value instanceof List) {
				/**
				 * 只有一个结果：e.g　select count(*) from a，结果从List<Map>抽出
				 */
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> tmp = (List<Map<String, Object>>) value;
				if (tmp.size() >= 1) {
					Object v = tmp.get(0).values().iterator().next();
					if (v instanceof String || v instanceof Number || v instanceof Date) {
						value = v;
					} else {
						value = null;
					}
				} else {
					value = null;
				}
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		return value;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为mysql
		return ComponentsType.MYSQL;
	}
}
