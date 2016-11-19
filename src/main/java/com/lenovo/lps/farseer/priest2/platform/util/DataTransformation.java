package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.drools.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.bpmn2.xml.XmlBPMNProcessDumper;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.ruleflow.core.factory.SplitFactory;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

public final class DataTransformation {
	private final static Logger logger = Logger.getLogger(DataTransformation.class);
	// 多个流程变量间隔符
	public static final String VARIABLES_SPLIT = "\n";
	// 变更名＝变量值分隔符
	public static final String VARIABLE_NAME_VALUE_SPLIT = "=";

	// 变量形式 "${a}"
	public static final Pattern VARIABLE_NAME_PATTERN = Pattern.compile("^\\$\\{(\\w+)\\}$");
	// 流程变量  "${a}"
	public static final Pattern PROCESS_VARIABLE_PATTERN = Pattern.compile("\\$\\{(\\w+)\\}", Pattern.CASE_INSENSITIVE
			| Pattern.DOTALL);

	// 通过now计算日期流程变量如: ${now} + 1 or ${now} -1形式
	public static final Pattern VARIABLE_NOW_PATTERN = Pattern.compile("^\\$\\{now\\}\\s*([\\+,\\-])?\\s*(\\d*)$");
	
	// 通过year|month|weekOfMonth|weekOfYear|dayOfMonth|dayOfWeek计算日期流程变量如: ${**} + 1 or ${**} -1形式
	public static final Pattern VARIABLE_OTHER_PATTERN = Pattern.compile("^\\$\\{(year|month|weekOfMonth|weekOfYear|dayOfMonth|dayOfWeek)\\}\\s*([\\+,\\-])?\\s*(\\d*)$");
	
	/**
	 * 工具类不应该被实例化使用
	 */
	private DataTransformation(){}
public static void main(String[] args) throws UnsupportedEncodingException {
	RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("_123");
	/**
	 * Header
	 */
	factory.name("p123");
	factory.version(Constants.JBPM_PROCESS_VERSION);
	factory.packageName(Constants.JBPM_PROCESS_DEFAULT_PACKAGE);
	
	factory.startNode(1).name(Constants.JBPM_RECT_START).done();
	factory.endNode(2).name(Constants.JBPM_RECT_END).done();
	
	factory.workItemNode(3).workName("workname").name("namemae")
	.workParameter(Constants.JBPM_TASK_PARAMETERS, "hello=vowld")
	.inMapping(Constants.COMPONENTS_PARAMS_IN, Constants.COMPONENTS_PARAMS_IN)
	.outMapping(Constants.COMPONENTS_PARAMS_OUT, Constants.COMPONENTS_PARAMS_OUT).done();
	
	factory.connection(1,3);
	factory.connection(3,2);
	
	RuleFlowProcess p = factory.validate().getProcess();
	System.out.println(new String(XmlBPMNProcessDumper.INSTANCE.dump(p).getBytes("UTF-8")));
}
	public static byte[] jsonToBpmn2(String json) throws JsonParseException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode rootNode = objectMapper.readTree(json);
		JsonNode statesNode = rootNode.get(Constants.JBPM_STATES_NAME);
		JsonNode propsNode = rootNode.get(Constants.JBPM_PROPS_NAME);
		JsonNode subPropsNode = propsNode.get(Constants.JBPM_PROPS_NAME);
		String processId = subPropsNode.get(Constants.JBPM_PROCESS_ID).get(Constants.JBPM_PROCESS_VALUE).getTextValue();
		String processName = subPropsNode.get(Constants.JBPM_PROCESS_NAME).get(Constants.JBPM_PROCESS_VALUE).getTextValue();

		RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess(processId);
		// 流程变量设置
		factory.variable(Constants.COMPONENTS_PARAMS_IN, new ObjectDataType("java.util.HashMap"));
		factory.variable(Constants.COMPONENTS_PARAMS_OUT, new ObjectDataType("java.util.HashMap"));

		// 分支Map
		Map<String, SplitFactory> judgeMap = new HashMap<String, SplitFactory>();

		// 每个判断结点下面的条件
		Map<String, List<String>> judgeNodeConditionMap = new HashMap<String, List<String>>();

		/**
		 * json paths
		 */
		JsonNode pathsNode = rootNode.get(Constants.JBPM_PATHS_NAME);

		/**
		 * Header
		 */
		factory.name(processName);
		factory.version(Constants.JBPM_PROCESS_VERSION);
		factory.packageName(Constants.JBPM_PROCESS_DEFAULT_PACKAGE);
		/**
		 * Nodes
		 */
		int i = 1;
		Map<String, Integer> connectionMap = new HashMap<String, Integer>();
		for (Iterator<Entry<String, JsonNode>> iterator = statesNode.getFields(); iterator.hasNext();) {
			Entry<String, JsonNode> rectNodeEntry = iterator.next();
			String rectName = rectNodeEntry.getKey();
			JsonNode rectNode = rectNodeEntry.getValue();
			JsonNode componentType = rectNode.get(Constants.JBPM_COMPONENTS_TYPE);
			String componentTypeName = componentType.getTextValue();
			JsonNode componentPropsNode = rectNode.get(Constants.JBPM_COMPONENTS_PROPS);
			ComponentsType componentsType = ComponentsType.valueOf(componentTypeName.toUpperCase());
			JsonNode componentId = null;
			String taskId = null;

			// 开始结点 START, END, FORK, JOIN, JUDGE, TRANSFER, HDFS, MAPREDUCE, HIVE, MYSQL, SHELL, JAVA, CACHE, KV, DEP
			switch (componentsType) {
			case START:
				factory.startNode(i).name(Constants.JBPM_RECT_START).done();
				break;
			// 结束结点
			case END:
				factory.endNode(i).name(Constants.JBPM_RECT_END).done();
				break;
			// 并发执行结点
			case FORK:
				break;
			// 合并并发结点
			case JOIN:
				componentId = rectNode.get(Constants.JBPM_PROPS_NAME).get(Constants.JBPM_COMPONENTS_PROPS_TASKID);
				taskId = componentId.get(Constants.JBPM_COMPONENTS_ID_PARAM_VALUE).getTextValue();

				factory.joinNode(i).name(taskId).type(Join.TYPE_XOR).done();
				break;
			// 判断结点
			case JUDGE:
				componentId = rectNode.get(Constants.JBPM_PROPS_NAME).get(Constants.JBPM_COMPONENTS_PROPS_TASKID);
				taskId = componentId.get(Constants.JBPM_COMPONENTS_ID_PARAM_VALUE).getTextValue();

				// 分支定义 ,在下面设置分支转移条件
				SplitFactory splitFactory = factory.splitNode(i).name(taskId).type(Split.TYPE_XOR);
				judgeMap.put(rectName, splitFactory);

				break;
			// TRANSFER, HDFS, MAPREDUCE, HIVE, MYSQL, SHELL, JAVA, CACHE, KV,
			// DEP结点
			default:
				componentId = rectNode.get(Constants.JBPM_PROPS_NAME).get(Constants.JBPM_COMPONENTS_PROPS_TASKID);
				taskId = componentId.get(Constants.JBPM_COMPONENTS_ID_PARAM_VALUE).getTextValue();
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				for (Iterator<Entry<String, JsonNode>> iteratorProps = componentPropsNode.getFields(); iteratorProps.hasNext();) {
					Entry<String, JsonNode> entry = iteratorProps.next();
					String name = entry.getKey();
					JsonNode valueNode = entry.getValue();
					String value = valueNode.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE).getTextValue();
					paramsMap.put(name, value);
				}
				paramsMap.put(Constants.JBPM_TASK_TYPE, componentsType.name().toLowerCase());

				ObjectMapper objectMapper2 = new ObjectMapper();
				objectMapper2.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String jsonStr = objectMapper2.valueToTree(paramsMap).toString();

				factory.workItemNode(i).workName(componentTypeName).name(taskId)
						.workParameter(Constants.JBPM_TASK_PARAMETERS, jsonStr)
						.inMapping(Constants.COMPONENTS_PARAMS_IN, Constants.COMPONENTS_PARAMS_IN)
						.outMapping(Constants.COMPONENTS_PARAMS_OUT, Constants.COMPONENTS_PARAMS_OUT).done();
				break;
			}
			connectionMap.put(rectName, i);
			i++;
		}

		/**
		 * 分支条件设置
		 */
		for (Iterator<JsonNode> iterator = pathsNode.getElements(); iterator.hasNext();) {
			JsonNode pathNode = iterator.next();
			setBranchVal(judgeMap, judgeNodeConditionMap, connectionMap, pathNode);
		}

		/**
		 * Connections
		 */
		for (Iterator<JsonNode> iterator = pathsNode.getElements(); iterator.hasNext();) {
			JsonNode pathNode = iterator.next();
			String from = pathNode.get(Constants.JBPM_PATHS_FROM).getTextValue();
			String to = pathNode.get(Constants.JBPM_PATHS_TO).getTextValue();

			factory.connection(connectionMap.get(from), connectionMap.get(to));
		}

		RuleFlowProcess process = factory.validate().getProcess();
		return XmlBPMNProcessDumper.INSTANCE.dump(process).getBytes("UTF-8");
	}

	private static void setBranchVal(Map<String, SplitFactory> judgeMap, Map<String, List<String>> judgeNodeConditionMap,
			Map<String, Integer> connectionMap, JsonNode pathNode) {
		String from = pathNode.get(Constants.JBPM_PATHS_FROM).getTextValue();
		String to = pathNode.get(Constants.JBPM_PATHS_TO).getTextValue();

		// 设置条件分支转移条件分支取值
		if (judgeMap.containsKey(from)) {
			String exp = pathNode.get(Constants.JBPM_PATHS_TEXT).get(Constants.JBPM_PATHS_TEXT).getTextValue();
			Assert.hasLength(exp, "Save failed, judge node condition is empty!");

			// 同一判断结点下面,重复条件检查(存在重复条件时运行会报错)
			List<String> judgeNodeConditions = judgeNodeConditionMap.get(from);
			if (judgeNodeConditions == null) {
				judgeNodeConditions = new ArrayList<String>();
				judgeNodeConditionMap.put(from, judgeNodeConditions);
			} else if (judgeNodeConditions.contains(exp)) {
				throw new PriestPlatformException("Save failed, judge node condition is duplication!:" + exp);
			}
			judgeNodeConditions.add(exp);

			/**
			 * <pre>
			 * 所有流程变更包装在Map<String,Object> processParams;对象中，${xxx}流程变量的获取需要转化为processParams.get("xxx") / mvel processParams.xxx
			 */
			// 条件表达式转换
			exp = replaceConditionVariable(exp);

			// 设置JBPM条件表达式
			judgeMap.get(from).constraint(connectionMap.get(to), "constraint" + connectionMap.get(to), "code", "mvel", exp).done();
		}
	}

	public static String tintProcessDefOfJson(String json, List<String> greenTasks, List<String> redTasks, List<String> yellowTasks)
			throws JsonProcessingException, IOException {
		if (greenTasks.size() <= 0 && redTasks.size() <= 0 && yellowTasks.size() <= 0) {
			return json;
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode rootNode = objectMapper.readTree(json);
		JsonNode statesNode = rootNode.get(Constants.JBPM_STATES_NAME);
		for (Iterator<Entry<String, JsonNode>> iterator = statesNode.getFields(); iterator.hasNext();) {
			Entry<String, JsonNode> rectNodeEntry = iterator.next();
			JsonNode rectNode = rectNodeEntry.getValue();
			JsonNode componentType = rectNode.get(Constants.JBPM_COMPONENTS_TYPE);
			String componentTypeName = componentType.getTextValue();
			if (Constants.JBPM_RECT_START.equalsIgnoreCase(componentTypeName)
					|| Constants.JBPM_RECT_END.equalsIgnoreCase(componentTypeName)) {
				continue;
			}
			JsonNode componentPropsNode = rectNode.get(Constants.JBPM_COMPONENTS_PROPS);
			JsonNode taskIdNode = componentPropsNode.get(Constants.JBPM_COMPONENTS_PROPS_TASKID);
			String taskId = taskIdNode.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE).getTextValue();
			JsonNode componentAttrNode = rectNode.get(Constants.JBPM_COMPONENTS_ATTR);
			if (greenTasks.contains(taskId)) {
				((ObjectNode) componentAttrNode).put("fill", "#449d44");
				((ObjectNode) componentAttrNode).put("stroke", "#398439");
				((ObjectNode) componentAttrNode).put("opacity", "0.6");
			} else if (redTasks.contains(taskId)) {
				((ObjectNode) componentAttrNode).put("fill", "#c9302c");
				((ObjectNode) componentAttrNode).put("stroke", "#ac2925");
				((ObjectNode) componentAttrNode).put("opacity", "0.6");
			} else if (yellowTasks.contains(taskId)) {
				((ObjectNode) componentAttrNode).put("fill", "#ec971f");
				((ObjectNode) componentAttrNode).put("stroke", "#d58512");
				((ObjectNode) componentAttrNode).put("opacity", "0.6");
			} else {
				continue;
			}
		}
		objectMapper.writeValueAsString(rootNode);
		return objectMapper.writeValueAsString(rootNode);
	}

	/**
	 * <pre>
	 * 用户输入流程变更解析，输入形式如下：
	 * ${a}=1
	 * ${b}=2
	 * ${c}=3
	 * 
	 * </pre>
	 * 
	 * @param varStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseProcessVariables(ProcessEntity process) {
		Map<String, Object> variables = null;
		String processVariablesStr = process.getProcessVariables();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			// json定义转为Map<String,Object>对象
			variables = objectMapper.readValue(processVariablesStr, Map.class);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		return variables;
	}

	/**
	 * 从流程实例获取值，替代${xxx}形式
	 * 
	 * @param taskParamsStr
	 * @param processParams
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String placeholderReplace(String taskParamsStr, Map<String, Object> processParams) {
		// 任务out参数值为${var}时,转为var形式,禁止out变量从流程变量获取,只能从任务执行结果获取
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, Object> taskParams;
		String taskParamsVal = taskParamsStr;
		try {
			taskParams = objectMapper.readValue(taskParamsVal, Map.class);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		String outValue = (String) taskParams.get(Constants.COMPONENTS_PARAMS_OUT);
		if (StringUtils.isNotBlank(outValue)) {
			Matcher mat = PROCESS_VARIABLE_PATTERN.matcher(outValue);
			if (mat.find()) {
				outValue = mat.group(1);
				taskParams.put(Constants.COMPONENTS_PARAMS_OUT, outValue);

				taskParamsVal = objectMapper.valueToTree(taskParams).toString();
			}
		}

		// ${xxx}匹配流程变量
		Matcher matcher = PROCESS_VARIABLE_PATTERN.matcher(taskParamsVal);

		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String variableName = matcher.group(1);
			// 值替代
			if (processParams.containsKey(variableName)) {
				Object tmp = processParams.get(variableName);
				String value = tmp == null ? null : tmp.toString();
				matcher.appendReplacement(sb, value);
			}
		}

		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * <pre>
	 * 	  mvel表达式转换:
	 * 	   ${a}==1相应条件，转为processParams.a==1(即processParams.get("a"))
	 * </pre>
	 * 
	 * @param condition
	 * @return
	 */
	public static String replaceConditionVariable(String condition) {
		// ${xxx}匹配流程变量
		Matcher matcher = PROCESS_VARIABLE_PATTERN.matcher(condition);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			String variableName = matcher.group(1);

			/**
			 * 
			 <pre>
			 *  当用户指定${a}==1形式条件时，代码设置的流程变量类型为java.util.HashMap   processParams;(参见本类jsonToBpmn2()方法: 流程变量设置相应代码
			 * 所有的流程变量从processParams获取
			 */
			matcher.appendReplacement(sb, "processParams." + variableName);
		}

		matcher.appendTail(sb);
		return "return (" + sb.toString() + ");";
	}

	/**
	 * 初始化流程变量
	 * 
	 * <pre>
	 * 1.内置流程变量生成：
	 * now
	 * year
	 * month
	 * weekOfMonth/weekOfYear/dayOfMonth
	 * </pre>
	 * 
	 * <pre>
	 * 2.业务应用变量解析，形式同流程变量
	 * 
	 * </pre>
	 * <pre>
	 * 3.用户输入流程变量解析，输入形式如下：
	 * ${a}=1
	 * ${b}=2
	 * ${c}=3
	 * 
	 * </pre>
	 * 
	 * @param process
	 * @return
	 */
	public static void initProcessVariables(ProcessEntity process) {
		Map<String, Object> variables = new HashMap<String, Object>();
		String processVariablesStr = process.getProcessVariables();
		String appVariablesStr = process.getAppVariables();

		// 设置日期为数据日期+1(注:不取process.getScheduleDate(),流程运行时,数据日期不变,调度日期一直在变)
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar scheduleDate = new GregorianCalendar();
		try {
			scheduleDate.setTime(sf.parse(process.getExecDate()));
		} catch (ParseException e) {
			throw new PriestPlatformException(e);
		}
		scheduleDate.add(Calendar.DAY_OF_MONTH, 1);

		/**
		 * 设置内置流程变量now值为流程调度日期
		 */
		variables.put("now", sf.format(scheduleDate.getTime()));
		variables.put("year", scheduleDate.get(Calendar.YEAR));
		variables.put("month", scheduleDate.get(Calendar.MONTH) + 1);
		variables.put("weekOfMonth", scheduleDate.get(Calendar.WEEK_OF_MONTH));
		variables.put("weekOfYear", scheduleDate.get(Calendar.WEEK_OF_YEAR));
		variables.put("dayOfMonth", scheduleDate.get(Calendar.DAY_OF_MONTH));
		// 一周星期几, 1-7,JDK星期天为1,星期一为2...
		int dayOfWeek = scheduleDate.get(Calendar.DAY_OF_WEEK);

		// 转为中国特有的周星期一为1,星期二为2
		dayOfWeek = dayOfWeek - 1;
		// 星期七为1,转为7
		dayOfWeek = dayOfWeek == 0 ? 7 : dayOfWeek;

		variables.put("dayOfWeek", dayOfWeek);

		// 业务变量处理
		String varStr = "";
		if (StringUtils.isNotEmpty(appVariablesStr)) {
			varStr += appVariablesStr;
		}
		
		// 用户设置的流程变量处理
		if (StringUtils.isNotEmpty(processVariablesStr)) {
			varStr += processVariablesStr;
		}
		
		if(StringUtils.isNotEmpty(varStr)){
			String[] vars = varStr.split(VARIABLES_SPLIT);
	
			// ${a}=1
			for (String var : vars) {
				String[] variable = var.split(VARIABLE_NAME_VALUE_SPLIT);
				// 变更名，值
				String variableName, variableValue;
				// 非法流程变量，跳过
				if (variable.length != 2) {
					variableName = variable[0];
					variableValue = "";
					logger.error("Process:" + process.getProcessId() + " exists illegal params:" + var);
				} else {
					// 变更名，值
					variableName = variable[0];
					variableValue = variable[1];
				}

				// 解析{a}输入，获取变更名
				Matcher matcher = VARIABLE_NAME_PATTERN.matcher(variable[0]);
				if (matcher.find()) {
					variableName = matcher.group(1);
				}

				// 计算${now}+x /${now-x}表达式
				variableValue = computeNowExp(process, sf, scheduleDate, variableValue, variables);

				variables.put(variableName, variableValue);
			}

		}

		// 转为json
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			processVariablesStr = objectMapper.writeValueAsString(variables);
			process.setProcessVariables(processVariablesStr);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	private static String computeNowExp(ProcessEntity process, SimpleDateFormat sf, Calendar scheduleDate, String variableValue, Map<String, Object> variables) {
		String variable = variableValue;
		if (StringUtils.isNotBlank(variable)) {
			variable = variable.trim();
			Matcher nowExpressMatcher = VARIABLE_NOW_PATTERN.matcher(variable),
					otherExpressMatcher = VARIABLE_OTHER_PATTERN.matcher(variable);
			if (nowExpressMatcher.find()) {
				// 表达式值
				Calendar expressDay = new GregorianCalendar();
				expressDay.setTime(scheduleDate.getTime());

				// + or -
				String operation = nowExpressMatcher.group(1);
				if (StringUtils.isNotBlank(operation)) {
					// 加减天数
					Integer intervalDays = Integer.valueOf(nowExpressMatcher.group(2));
					if ("+".equals(operation)) {
						expressDay.add(Calendar.DAY_OF_MONTH, intervalDays);
					} else if ("-".equals(operation)) {
						expressDay.add(Calendar.DAY_OF_MONTH, -intervalDays);
					} else {
						throw new PriestPlatformException("Illegal param expression,Process ID:" + process.getProcessId()
								+ ",Legal expression:${now} + x or ${now} -x:" + nowExpressMatcher.group(0));
					}
				}

				variable = sf.format(expressDay.getTime());
			} else if (otherExpressMatcher.find()) {
				String type = otherExpressMatcher.group(1);
				// + or -
				String operation = otherExpressMatcher.group(2);
				if (StringUtil.isNotEmpty(operation)) {
					// 加减天数
					Integer intervalDays = Integer.valueOf(otherExpressMatcher.group(3));
					if ("+".equals(operation)) {
						variable = String.valueOf(StringUtil.parseInt(variables.get(type)) + intervalDays);
					} else if ("-".equals(operation)) {
						variable = String.valueOf(StringUtil.parseInt(variables.get(type)) - intervalDays);
					} else {
						throw new PriestPlatformException("Illegal param expression,Process ID:" + process.getProcessId()
								+ ",Legal expression:${**} + x or ${**} -x:" + nowExpressMatcher.group(0));
					}
				} else {
					variable =String.valueOf(variables.get(type));
				}
			} else {
				for (Entry<String, Object> var: variables.entrySet()) {
					variable = variable.replaceAll("\\$\\{" + var.getKey() + "\\}" , String.valueOf(var.getValue()));
				}
			}
		}
		return variable;
	}
}
