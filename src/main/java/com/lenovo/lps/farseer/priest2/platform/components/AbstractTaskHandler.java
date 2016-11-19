/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.JbpmProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.service.impl.JbpmProcessServiceImpl;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.DataTransformation;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

/**
 * 组件抽象类
 * 
 * @author niexm1
 * 
 */
public abstract class AbstractTaskHandler implements WorkItemHandler {
	// 动态获取子类logger
	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected TaskService taskService;

	@Resource
	protected JbpmProcessService jbpmProcessService;

	@Resource
	private ProcessService processService;
	
	/**
	 * 获取组件相关参数
	 * 
	 * @param jsonNode
	 * @return
	 */
	protected abstract Map<String, Object> getComponentParams(JsonNode jsonNode);

	/**
	 * 调用具体组件方法
	 * 
	 * @param params
	 * @return
	 */
	protected abstract Object invokeComponentMethod(Map<String, Object> params);

	/**
	 * 获取组件类型
	 * 
	 * @return
	 */
	protected abstract ComponentsType getComponetType();

	/**
	 * 调用组件模板方法
	 * ,注:需要每步运行之前,判断用户是否手工中止流程运行(通过Thread.currentThread().isInterrupted()判断)
	 * 
	 * @param 流程变量
	 * @param 任务
	 *            /组件变量 json串
	 * @throws InterruptedException
	 */
	protected void doExecuteWorkItem(Map<String, Object> processParams, String taskParamsStr) throws InterruptedException {
		String taskParams = taskParamsStr;
		// 根据流程变量名，获取实际流程变量值
		if (StringUtils.hasText(taskParams)) {
			taskParams = DataTransformation.placeholderReplace(taskParams, processParams);
		}

		// 输入processId
		String processId = (String) processParams.get(Constants.COMPONENTS_PARAMS_PROCESS_ID);

		// 输入exec date
		String execDate = (String) processParams.get(Constants.COMPONENTS_PARAMS_EXEC_DATE);

		// 输入appId
		String appName = (String) processParams.get(Constants.COMPONENTS_PARAMS_APP);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode jsonNode;

		try {
			jsonNode = objectMapper.readTree(taskParams);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		// 输入taskId
		String taskId = jsonNode.get(Constants.COMPONENTS_PARAMS_TASK_ID).getTextValue();
		// 输入taskName
		String taskName = jsonNode.get(Constants.COMPONENTS_PARAMS_TASK_NAME).getTextValue();

		// 组件计算结果传入流程做为流程变量,其流程变量名
		String out = jsonNode.get(Constants.COMPONENTS_PARAMS_OUT) != null ? jsonNode.get(Constants.COMPONENTS_PARAMS_OUT)
				.getTextValue() : null;

		// 获取组件特有输入参数
		Map<String, Object> componentParams = getComponentParams(jsonNode);

		componentParams.put("processId", processId);
		componentParams.put("execDate", execDate);
		componentParams.put("appName", appName);
		componentParams.put("taskId", taskId);
		
		// 用户取消流程运行，失败返回
		String interrupteKey = processId + "_" + execDate;
		if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
			JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
			throw new InterruptedException();
		}
		WorkSession ws = WorkSession.get() ;
		ws.setRuntimeInfo(processId, taskId, execDate) ;
		if (StringUtils.hasText(out)) {
			ws.setMaxResultDatasize(StringUtil.parseLong(ConfigUtil.getContextProperty("job.result.max.datasize",
						"1048576")));
		}else{
			ws.setMaxResultDatasize(StringUtil.parseLong(ConfigUtil.getContextProperty("job.result.limit.datasize",
					"52428800")));
		}
		ws.setMaxResultRowCount(StringUtil.parseLong(ConfigUtil.getContextProperty("job.result.max.rowcount",
				"100")));
		
		try {
			// DB记录task run
			taskService.startTask(processId, taskId, taskName, getComponetType(), execDate);

			// 调用具体组件方法
			Object result = invokeComponentMethod(componentParams);

			// 计算结果返回到流程
			if (StringUtils.hasText(out)) {
				processParams.put(out, result);

				// 流程变更更新到库,以防流程失败时,redo需要
				processService.updateRunningProcessVariable(Integer.valueOf(processId), execDate, processParams);
			}
		} catch (Exception e) {
			// 用户取消流程运行，失败返回
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				taskService.failedTask(taskId, execDate, "Task Aborted.");
				throw new InterruptedException();
			} else {
				taskService.failedTask(taskId, execDate, org.apache.hadoop.util.StringUtils.stringifyException(e));
				throw new PriestPlatformException(e);
			}
		}

		// 用户取消流程运行，失败返回
		if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
			JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
			taskService.failedTask(taskId, execDate, "Process is aborted!");
			throw new InterruptedException();
		} else {
			// DB记录task success
			taskService.terminateTask(taskId, execDate);
		}

	}

	private boolean tagWeakDependent(String processId, String taskId) {
		ProcessEntity process = processService.getProcessDef(processId);
		String jsonDef = process.getJsonDef();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode rootNode;
		try {
			rootNode = objectMapper.readTree(jsonDef);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		JsonNode statesNode = rootNode.get(Constants.JBPM_STATES_NAME);
		JsonNode pathsNode = rootNode.get(Constants.JBPM_PATHS_NAME);
		// 找出当前taskId对应的rectName
		String rectName = "";
		for (Iterator<Entry<String, JsonNode>> iterator = statesNode.getFields(); iterator.hasNext();) {
			Entry<String, JsonNode> rectNodeEntry = iterator.next();
			JsonNode taskIdJsonNode = rectNodeEntry.getValue().get(Constants.JBPM_COMPONENTS_PROPS)
					.get(Constants.JBPM_COMPONENTS_PROPS_TASKID);
			if (taskIdJsonNode != null) {
				String taskIdInJson = taskIdJsonNode.get(Constants.JBPM_COMPONENTS_ID_PARAM_VALUE).getTextValue();
				if (taskId.equals(taskIdInJson)) {
					rectName = rectNodeEntry.getKey();
					break;
				}
			}
		}
		// 当前task与后续task的连线是否是弱依赖
		for (Iterator<JsonNode> iterator = pathsNode.getElements(); iterator.hasNext();) {
			JsonNode pathNode = iterator.next();
			String text = pathNode.get(Constants.JBPM_PATHS_TEXT).get(Constants.JBPM_PATHS_TEXT).getTextValue();
			String from = pathNode.get(Constants.JBPM_PATHS_FROM).getTextValue();
			if (rectName.equals(from) && (text.contains("(弱依赖)") || text.contains("(Low Depend)"))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 任务中止
	 * 
	 * @param workItem
	 * @param manager
	 */
	protected void doAbortWorkItem(Map<String, Object> processParams) { // 中止任务运行
		// do nothing
	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		// 流程变量
		@SuppressWarnings("unchecked")
		Map<String, Object> processParams = (Map<String, Object>) workItem.getParameter(Constants.COMPONENTS_PARAMS_IN);

		// 任务/组件变量
		String taskParamsStr = (String) workItem.getParameter(Constants.JBPM_TASK_PARAMETERS);
		// 输入processId
		String processId = (String) processParams.get(Constants.COMPONENTS_PARAMS_PROCESS_ID);

		try {
			// 输入exec date
			String execDate = (String) processParams.get(Constants.COMPONENTS_PARAMS_EXEC_DATE);
			// 用户手动中止流程运行
			String interrupteKey = processId + "_" + execDate;
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				throw new InterruptedException();
			}

			doExecuteWorkItem(processParams, taskParamsStr);
			// 继续流程下一任务
			workItemManager.completeWorkItem(workItem.getId(), new HashMap<String, Object>());

			// 用户手动中止流程运行
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				throw new InterruptedException();
			}
		} catch (Exception e) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode jsonNode;

			try {
				jsonNode = objectMapper.readTree(taskParamsStr);
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				logger.error(e.getMessage(), e);
				throw new PriestPlatformException(e);
			}

			// 输入taskId
			String taskId = jsonNode.get(Constants.COMPONENTS_PARAMS_TASK_ID).getTextValue();

			// 弱引用
			if (tagWeakDependent(processId, taskId)) {
				workItemManager.abortWorkItem(workItem.getId());
			}
			// 非弱引用
			else {
				// 中止任务运行
				abortWorkItem(workItem, workItemManager);
				// 抛出异常,防止继续跑下面流程
				throw new PriestPlatformException(e);
			}
		}
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		@SuppressWarnings("unchecked")
		Map<String, Object> processParams = (Map<String, Object>) workItem.getParameter(Constants.COMPONENTS_PARAMS_IN);
		doAbortWorkItem(processParams);
		// 不能调用WorkItemManager.abortWorkItem(),否则会无视异常继续跑下面任务
	}

}
