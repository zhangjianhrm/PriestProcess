package com.lenovo.lps.farseer.priest2.platform.components;

import java.security.PrivilegedExceptionAction;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.drools.runtime.process.WorkItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.HdfsOpEnum;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.HdfsService;
import com.lenovo.lps.farseer.priest2.platform.service.impl.HadoopUgiServiceImpl;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * HDFS组件代码
 * 
 * @author niexm1
 * 
 */
public class HdfsTaskHandler extends AbstractTaskHandler implements WorkItemHandler {

	@Autowired
	private HdfsService hdfsService;

	@Autowired
	private ApplicationService applicationService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {

		// HDFS源路径
		String srcPath = jsonNode.get(Constants.COMPONENTS_PARAMS_HDFS_SRC_PATH).getTextValue();
		JsonNode destNode = jsonNode.get(Constants.COMPONENTS_PARAMS_HDFS_DEST_PATH);
		// HDFS路径
		String destPath = destNode != null ? destNode.getTextValue() : "";

		// HDFS操作
		String hdfsOp = jsonNode.get(Constants.COMPONENTS_PARAMS_HDFS_OP).getTextValue();

		Map<String, Object> componentParams = new HashMap<String, Object>();

		componentParams.put("srcPath", srcPath);
		componentParams.put("destPath", destPath);
		componentParams.put("hdfsOp", hdfsOp);
		return componentParams;

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		final String srcPath = (String) params.get("srcPath");
		final String destPath = (String) params.get("destPath");
		final String hdfsOp = (String) params.get("hdfsOp");
		Integer appId = Integer.valueOf((String) params.get("appName"));
		Object value;
		try {
			value = HadoopUgiServiceImpl.doAs(applicationService.getApp(appId).get("appUser"), new PrivilegedExceptionAction<Object>() {

				@Override
				public Object run() {
					Object v = null;
					if (StringUtils.hasLength(destPath)) {
						v = hdfsService.runHdfsOperator(HdfsOpEnum.valueOf(hdfsOp), srcPath, destPath);
					} else {
						v = hdfsService.runHdfsOperator(HdfsOpEnum.valueOf(hdfsOp), srcPath);
					}
					return v;
				}
			});
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		return value;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为hdfs
		return ComponentsType.HDFS;
	}
}
