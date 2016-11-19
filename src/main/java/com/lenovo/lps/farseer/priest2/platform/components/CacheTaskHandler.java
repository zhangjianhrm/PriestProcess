package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.service.CacheService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * Cache组件实现代码
 * 
 * @author niexm1
 * 
 */
public class CacheTaskHandler extends AbstractTaskHandler  {
	private static final String OP_GET = "g";

	@Autowired
	private CacheService cacheService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// 输入参数
		// cache操作 s(set), g(get)
		String cacheOp = jsonNode.get(Constants.COMPONENTS_PARAMS_CACHE_OP).getTextValue();

		String key = jsonNode.get(Constants.COMPONENTS_PARAMS_CACHE_KEY).getTextValue();
		JsonNode valueNode = jsonNode.get(Constants.COMPONENTS_PARAMS_CACHE_VALUE);
		String value = valueNode != null ? valueNode.getTextValue() : "";

		Map<String, Object> componentParams = new HashMap<String, Object>();

		componentParams.put("cacheOp", cacheOp);
		componentParams.put("key", key);
		componentParams.put("value", value);
		return componentParams;

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		Object result = null;
		String cacheOp = (String) params.get("cacheOp");
		String key = (String) params.get("key");
		String value = (String) params.get("value");
		if (OP_GET.equals(cacheOp)) {
			result = cacheService.get(key);
		} else {
			cacheService.set(key, value);
		}

		return result;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为cache
		return ComponentsType.CACHE;
	}
}
