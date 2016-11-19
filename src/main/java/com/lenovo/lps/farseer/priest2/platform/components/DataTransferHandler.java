package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.DataTransferModeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.DataTransferService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * 数据迁移组件代码
 * 
 * @author niexm1
 * 
 */
public class DataTransferHandler extends AbstractTaskHandler implements WorkItemHandler {
	// 是否覆盖旧数据标记
	private static final String IS_OVERRITE = "Y";
	@Autowired
	private DataTransferService dataTransferService;
	@Resource
	private ApplicationService applicationService;

	@Resource
	private ProcessService processService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// transfer mode
		String transferMode = jsonNode.get(Constants.COMPONENTS_PARAMS_TRANSFER_MODE).getTextValue();
		// 迁移源
		String srcData = jsonNode.get(Constants.COMPONENTS_PARAMS_TRANSFER_SOURCE_DATA).getTextValue();
		// 迁移目的地
		String destData = jsonNode.get(Constants.COMPONENTS_PARAMS_TRANSFER_DEST_DATA).getTextValue();

		// 从Hive迁移数据至RDBMS（Mysql/Oracle)，覆盖旧数据没有意义，本次版本些应用场景隐藏是否覆盖选择项
		JsonNode overWriteNode = jsonNode.get(Constants.COMPONENTS_PARAMS_TRANSFER_OVERWRITE);

		// 是否overrite
		String overWrite = overWriteNode != null ? jsonNode.get(Constants.COMPONENTS_PARAMS_TRANSFER_OVERWRITE).getTextValue() : "N";

		JsonNode rdbmsDBNode = jsonNode.get(Constants.COMPONENTS_PARAMS_RDBMS);
		// Oracle/MySQL库
		/**
		 * <pre>
		 * 历史版本界面不能选择多数据源，历史数据没有数据源信息。
		 * 本版本上线时，会在P_DATABASE表加db_name字段，历史数据源统一叫default
		 * </pre>
		 */		
		String rdbmsDB = rdbmsDBNode != null ? rdbmsDBNode.getTextValue() : Constants.DATABASE_DEFAULT_NAME;
		Map<String, Object> componentParams = new HashMap<String, Object>();

		componentParams.put("transferMode", transferMode);
		componentParams.put("srcData", srcData);
		componentParams.put("destData", destData);
		componentParams.put("overWrite", overWrite);
		componentParams.put("rdbmsDB", rdbmsDB);
		return componentParams;

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		String transferMode = (String) params.get("transferMode");
		String srcData = (String) params.get("srcData");
		String destData = (String) params.get("destData");
		String overWrite = (String) params.get("overWrite");
		String processId = (String) params.get("processId");
		String execDate = (String) params.get("execDate");
		String appName = (String) params.get("appName"); // 取到的其实是应用ID
		String taskId = (String) params.get("taskId");
		String rdbmsDB = (String) params.get("rdbmsDB");

		DbEntity db = null;

		// 应用数据迁入,迁出mysql时,需要查询应用mysql连接信息
		ProcessEntity process = processService.getProcessDef(processId);
		if ("M2H".equals(transferMode) || "H2M".equals(transferMode)) {
			db = applicationService.getAppDbConfig(Integer.valueOf(process.getProcessApp()), DbTypeEnum.MySQL, rdbmsDB);
			// 应用数据迁入,迁出oracle时,需要查询应用oracle连接信息
		} else if ("O2H".equals(transferMode) || "H2O".equals(transferMode)) {
			db = applicationService.getAppDbConfig(Integer.valueOf(process.getProcessApp()), DbTypeEnum.Oracle, rdbmsDB);
		}

		// 开始数据迁移
		dataTransferService.transferData(DataTransferModeEnum.valueOf(transferMode), srcData, destData, IS_OVERRITE.equals(overWrite),
				db, processId, execDate, Integer.valueOf(appName), taskId);

		return null;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为数据迁移
		return ComponentsType.TRANSFER;
	}
}
