/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lenovo.lps.farseer.priest2.platform.dal.IdDao;
import com.lenovo.lps.farseer.priest2.platform.entity.NewDataStatEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependentEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

/**
 * 流程json定义解析
 * 
 * @author niexm1
 * 
 */
public final class JsonParseUtils {
	/**
	 * 工具类不应该被实例化使用
	 */
	private JsonParseUtils() {
	}

	/**
	 * json定义解析流程属性
	 * 
	 * <pre>
	 * json格式
	 * {states={rect1={type=start, text={text=开始}, attr={x=360, y=51, width=50, height=50}, props={text={value=开始}}}, rect2={type=end, text={text=结束}, attr={x=362, y=424, width=50, height=50}, props={text={value=结束}}}, rect3={type=transfer, text={text=数据迁移}, attr={x=336, y=251, width=100, height=50}, props={componentName={value=数据迁移}, taskId={value=143}, taskName={value=undefined}, transferMode={value=}, sourceData={value=}, dbUser={value=}, dbPass={value=}, connStr={value=}, overWrite={value=}, seperator={value=}, destData={value=}}}}, paths={path4={from=rect1, to=rect3, dots=[], text={text=TO 数据迁移}, textPos={x=0, y=-10}, props={text={value=}}},
	 * path5={from=rect3, to=rect2, dots=[], text={text=TO 结束}, textPos={x=0, y=-10}, props={text={value=}}}},
	 * props={props={processId={value=}, processName={value=abc}, processDesc={value=bde}, validate={value=2012-06-01}, priority={value=L}, appName={value=R}, scheduleType={value=O}, scheduleDate={value=2012-06-01}, scheduleTime={value=10:24 PM}, lateStartTime={value=09:21 PM}, alermMethod={value=E}, alermPerson={value=niexm1@lenovo.com}}}}
	 * </pre>
	 * 
	 * @param jsonDef
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ParseException
	 */
	@SuppressWarnings(Constants.RAWTYPE_REF)
	public static ProcessEntity parseProcessFromJson(String jsonDef) throws JsonParseException, JsonMappingException, IOException,
			ParseException {
		ProcessEntity process = new ProcessEntity();
		process.setJsonDef(jsonDef);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);

		Map states = (Map) obj.get(Constants.JBPM_STATES_NAME), attribMap, propsMap, taskMap;

		/**
		 * 解析依赖
		 */
		if (states != null && states.size() > 0) {
			for (Object stateAttribs : states.values()) {
				attribMap = (Map) stateAttribs;
				if ("dep".equals(attribMap.get(Constants.JBPM_COMPONENTS_TYPE))) {
					String depType = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("depType"))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					if ("process".equals(depType)) {
						String target = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("target"))
								.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
						ProcessDependentEntity dep = new ProcessDependentEntity();
						dep.setDependentProcessId(Integer.valueOf(target));

						process.setDep(dep);
					}
				}
				if (attribMap.get(Constants.JBPM_COMPONENTS_PROPS) != null) {
					propsMap = (Map)attribMap.get(Constants.JBPM_COMPONENTS_PROPS);
					if (propsMap.get(Constants.JBPM_COMPONENTS_PROPS_TASKID) != null) {
						taskMap = (Map)propsMap.get(Constants.JBPM_COMPONENTS_PROPS_TASKID);
						if ("0".equals(taskMap.get("value"))) {
							return null;
						}
					}
				}
			}
		}

		/**
		 * 解析流程属性
		 */
		Map processProps = (Map) ((Map) obj.get(Constants.JBPM_PROPS_NAME)).get(Constants.JBPM_PROPS_NAME);

		String processId = (String) ((Map) processProps.get("processId")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		if (StringUtils.hasText(processId)) {
			process.setProcessId(Integer.parseInt(processId));
		}

		String processName = (String) ((Map) processProps.get("processName")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setProcessName(processName);

		String processDesc = (String) ((Map) processProps.get("processDesc")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setProcessDesc(processDesc);

		String validate = (String) ((Map) processProps.get("validate")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		if (StringUtils.hasText(validate)) {
			process.setValidDate(validate);
		}
		// 用户未指定有效期时，默认2022年过期
		else {
			process.setValidDate("2022-12-1");
		}

		String priority = (String) ((Map) processProps.get("priority")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setProcessPriority(priority);

		String appName = (String) ((Map) processProps.get("appName")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setProcessApp(appName);

		String scheduleType = (String) ((Map) processProps.get("scheduleType")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setScheduleType(scheduleType);

		String scheduleDate = (String) ((Map) processProps.get("scheduleDate")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setScheduleDate(scheduleDate);

		String scheduleTime = (String) ((Map) processProps.get("scheduleTime")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		if (StringUtils.hasText(scheduleTime)) {
			process.setScheduleTime(formatTime(scheduleTime));
		}

		String lateStartTime = (String) ((Map) processProps.get("lateStartTime")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		if (StringUtils.hasText(lateStartTime)) {
			process.setLatestScheduleTime(formatTime(lateStartTime));
		}

		String alermMethod = (String) ((Map) processProps.get("alermMethod")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setAlarmType(alermMethod);

		String alermPerson = (String) ((Map) processProps.get("alermPerson")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setAlarmTarget(alermPerson);

		String processVariables = (String) ((Map) processProps.get("processVariables"))
				.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		process.setProcessVariables(processVariables);

		if (processProps.get("appVariables") != null) {
			String appVariables = (String) ((Map) processProps.get("appVariables")).get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
			process.setAppVariables(appVariables);
		}

		return process;

	}

	/**
	 * 解析出上传到服务器上的流程依赖的文件名称，如jar包、shell文件等
	 * 
	 * @param jsonDef
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings(Constants.RAWTYPE_REF)
	public static List<String> getFileNamesInProcess(String jsonDef) throws JsonParseException, JsonMappingException, IOException {
		List<String> fileNames = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);
		Map states = (Map) obj.get(Constants.JBPM_STATES_NAME);
		if (states != null && states.size() > 0) {
			for (Object stateAttribs : states.values()) {
				Map attribMap = (Map) stateAttribs;
				String type = (String) attribMap.get(Constants.JBPM_COMPONENTS_TYPE);
				if ("shell".equals(type)) {
					String shellFile = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("shellFile"))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					fileNames.add(shellFile);
				}
				if ("java".equals(type)) {
					String jar = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("jar"))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					fileNames.add(jar);
				}
				if ("mapreduce".equals(type)) {
					String mrJar = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("mrJar"))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					fileNames.add(mrJar);
				}
				if ("hdfs".equals(type)) {
					String hdfsOp = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("hdfsOp"))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					if ("upload".equals(hdfsOp)) {
						String srcPath = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("srcPath"))
								.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
						fileNames.add(srcPath);
					}
				}
			}
		}
		return fileNames;
	}

	/**
	 * 更新Process ID
	 * 
	 * @param jsonDef
	 * @param idDao
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static String changeProcessId(String jsonDef, IdDao idDao) throws JsonParseException, JsonMappingException, IOException,
			SQLException {
		String newProcessId = String.valueOf(idDao.genProcessId());
		return changeProcessId(jsonDef, newProcessId);
	}

	/**
	 * 更新Process ID
	 * 
	 * @param jsonDef
	 * @param newProcessId
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings({ Constants.RAWTYPE_REF, Constants.UNCHECK_REF })
	public static String changeProcessId(String jsonDef, String newProcessId) throws JsonParseException, JsonMappingException,
			IOException, SQLException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);
		Map processProps = (Map) ((Map) obj.get(Constants.JBPM_PROPS_NAME)).get(Constants.JBPM_PROPS_NAME);

		Map processId = (Map) processProps.get("processId");
		processId.put(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE, newProcessId);
		return mapper.writeValueAsString(obj);
	}

	// 替换流程依赖中的processId（target）
	@SuppressWarnings({ Constants.RAWTYPE_REF, Constants.UNCHECK_REF })
	public static String changeDependentProcessId(String jsonDef, Map<String, String> processIdMap) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);
		Map states = (Map) obj.get(Constants.JBPM_STATES_NAME);
		if (states != null && states.size() > 0) {
			for (Object stateAttribs : states.values()) {
				Map attribMap = (Map) stateAttribs;
				if ("dep".equals(attribMap.get(Constants.JBPM_COMPONENTS_TYPE))) {
					Map targetMap = (Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("target");
					String target = (String) targetMap.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					if (processIdMap.keySet().contains(target)) {
						targetMap.put(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE, processIdMap.get(target));
					}
				}
			}
		}
		return mapper.writeValueAsString(obj);
	}

	/**
	 * 更新所有Task ID
	 * 
	 * @param jsonDef
	 * @param idDao
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings({ Constants.RAWTYPE_REF, Constants.UNCHECK_REF })
	public static String changeTaskId(String jsonDef, IdDao idDao) throws JsonParseException, JsonMappingException, IOException,
			SQLException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);
		Map states = (Map) obj.get(Constants.JBPM_STATES_NAME);
		if (states != null && states.size() > 0) {
			for (Object stateAttribs : states.values()) {
				Map attribMap = (Map) stateAttribs;
				Map taskId = (Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("taskId");
				if (taskId != null && taskId.size() > 0) {
					String newTaskId = String.valueOf(idDao.genTaskId());
					taskId.put(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE, newTaskId);
				}
			}
		}
		return mapper.writeValueAsString(obj);
	}

	/**
	 * 更新文件名称
	 * 
	 * @param jsonDef
	 * @param fileNames
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings({ Constants.RAWTYPE_REF })
	public static String changeFileName(String jsonDef, Map<String, String> fileNames) throws JsonParseException,
			JsonMappingException, IOException {
		Set<String> oldFileNames = fileNames.keySet();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);
		Map states = (Map) obj.get(Constants.JBPM_STATES_NAME);
		if (states != null && states.size() > 0) {
			for (Object stateAttribs : states.values()) {
				Map attribMap = (Map) stateAttribs;
				String type = (String) attribMap.get(Constants.JBPM_COMPONENTS_TYPE);
				if ("shell".equals(type)) {
					replaceFileName(fileNames, oldFileNames, attribMap, "shellFile");
				}
				if ("java".equals(type)) {
					replaceFileName(fileNames, oldFileNames, attribMap, "jar");
				}
				if ("mapreduce".equals(type)) {
					replaceFileName(fileNames, oldFileNames, attribMap, "mrJar");
				}
				if ("hdfs".equals(type)) {
					String hdfsOp = (String) ((Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get("hdfsOp"))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					if ("upload".equals(hdfsOp)) {
						replaceFileName(fileNames, oldFileNames, attribMap, "srcPath");
					}
				}
			}
		}
		return mapper.writeValueAsString(obj);
	}

	@SuppressWarnings({ Constants.RAWTYPE_REF, Constants.UNCHECK_REF })
	private static void replaceFileName(Map<String, String> fileNames, Set<String> oldFileNames, Map attribMap, String params) {
		Map fileNameMap = (Map) ((Map) attribMap.get(Constants.JBPM_PROPS_NAME)).get(params);
		String oldFileName = (String) fileNameMap.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
		if (oldFileNames.contains(oldFileName)) {
			fileNameMap.put(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE, fileNames.get(oldFileName));
		}
	}

	/**
	 * 12小时时间转为24小时
	 * 
	 * @param time
	 * @return
	 */
	private static String formatTime(String time) {
		return time + ":00";

	}

	/**
	 * 处理json特殊字符
	 * 
	 * @param s
	 * @return
	 */
	public static String replaceSpecialChar(String s) {
		if (!StringUtils.hasText(s)) {
			return "";
		}

		StringBuilder sb = new StringBuilder(s.length() + 20);
		String noVisibles = "\"\\/\b\f\n\r\t\'";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int cIdx = noVisibles.indexOf(c);

			if (cIdx == -1) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static List<NewDataStatEntity> parseNewDataFromJson(String newStatJson) throws JsonParseException, JsonMappingException,
			IOException {
		Gson gson = new Gson();
		List<NewDataStatEntity> newDataList = gson.fromJson(newStatJson, new TypeToken<List<NewDataStatEntity>>() {
		}.getType());
		return newDataList;
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, String> getHsqlsFromJson(String jsonDef) throws JsonParseException, JsonMappingException, IOException {
		Map<String, String> hsqls = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map obj = mapper.readValue(jsonDef, Map.class);
		Map states = (Map) obj.get(Constants.JBPM_STATES_NAME);
		if (states != null && states.size() > 0) {
			for (Object stateAttribs : states.values()) {
				Map attribMap = (Map) stateAttribs;
				String type = (String) attribMap.get(Constants.JBPM_COMPONENTS_TYPE);
				if ("hive".equals(type)) {
					Map props = (Map) attribMap.get(Constants.JBPM_PROPS_NAME);
					String taskId = (String) ((Map) props.get(Constants.JBPM_COMPONENTS_PROPS_TASKID))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					String hsql = (String) ((Map) props.get(Constants.COMPONENTS_PARAMS_HIVE_SQL))
							.get(Constants.JBPM_COMPONENTS_PROPS_PARAM_VALUE);
					hsqls.put(taskId, hsql);
				}
			}
		}
		return hsqls;
	}

}
