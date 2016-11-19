package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public final class Constants {
	private static final String VALUE_LITERAL = "value";

	public static final String DATE_PATTENR = "yyyy-MM-dd";
	public static final Random RANDOM = new Random();

	/**
	 * for annotation SuppressWarnings
	 */
	public static final String UNCHECK_REF = "unchecked";
	public static final String RAWTYPE_REF = "rawtypes";

	/**
	 * session
	 */
	public static final String SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY = "SPRING_SECURITY_REMEMBER_ME_COOKIE";
	public static final String SERVER_NAME = "priest";
	public static final String SESSION_KEY_FLAG_OF_COOKIE = "session_key";
	public static final String USER_SESSION_FLAG = "user_session_flag";
	public static final String USER_ADMIN = "admin";

	public static final String TASK_LOAD_AND_SPLIT = "loadAndSplit";
	public static final String TASK_GEN_INFO_TABLE = "genInfoTable";
	public static final String TASK_GEN_A_TABLE = "genATable";
	public static final String CHARACTER_ENCODING = "UTF-8";

	public static final String UNSUBMIT = "UNSUBMIT";
	public static final String SUBMIT = "SUBMIT";
	public static final String JVM = "JVM";
	public static final String MR = "MR";
	public static final String HIVE_TRANSFER = "HIVE_TRANSFER";
	public static final String IO = "IO";

	public static final String SQOOP_EXPORT_TOOLNAME = "export";
	public static final String SQOOP_PACKAGE_NAME_PROPETY = "--package-name";
	public static final String DB_CONNECT_PROPETY = "--connect";
	public static final String DB_USERNAME_PROPETY = "--username";
	public static final String DB_PASSWORD_PROPETY = "--password";
	public static final String TABLE_PROPETY = "--table";
	public static final String EXPORT_DIR_PROPETY = "--export-dir";
	public static final String FIELDS_SEPARATOR_PROPETY = "--input-fields-terminated-by";
	public static final String INPUT_NULL_STRING = "--input-null-string";
	public static final String INPUT_NULL_NON_STRING = "--input-null-non-string";
	public static final String HIVE_NULL_STRING = "\\\\N";
	// 默认hive字段分隔符'001'(^A)
	public static final String HIVE_DEFAULT_FIELD_TERMINATED = "\u0001";
	public static final String SQOOP_FIELD_TERMINATED = "\u0005";
	public static final String SQOOP_FIELD_TERMINATED_REPLACE = "##priest(@(@sqoop))";
	

	public static final String SQOOP_DEFAULT_CODE_GENERATE_PACKAGE_NAME = "com.lenovo.lps.farseer.priest2.sqoop";
	public static final String SQOOP_DEFAULT_DB_CONNECTION_URL = "sqoop.default.db.connection.url";
	public static final String SQOOP_DEFAULT_DB_CONNECTION_USERNAME = "sqoop.default.db.connection.username";
	public static final String SQOOP_DEFAULT_DB_CONNECTION_PASSWORD = "sqoop.default.db.connection.password";
	public static final String SQOOP_DEFAULT_CODEGEN_OUTPUT_DIR = "codegen.output.dir";
	public static final String SQOOP_DEFAULT_CODEGEN_COMPILE_DIR = "codegen.compile.dir";

	public static final String RESPONSE_RESULT_COLLECTION = "rows";
	public static final String RESPONSE_RESULT_CURRENTPAGE = "currentPage";
	public static final String RESPONSE_RESULT_TOTALPAGES = "totalPages";
	public static final String RESPONSE_RESULT_TOTALRECORDS = "totalRecords";
	public static final String RESPONSE_MESSAGES = "messages";
	public static final String RESPONSE_ERRORS = "response_errors";

	public static final String JBPM_PROCESS_DEFAULT_PACKAGE = "com.lenovo";
	public static final String JBPM_PROCESS_VERSION = "1.0.0";
	public static final String JBPM_PROCESS_NAME = "processName";
	public static final String JBPM_PROCESS_VALUE = VALUE_LITERAL;
	public static final String JBPM_PROCESS_ID = "processId";
	public static final String JBPM_TASK_PARAMETERS = "taskParams";
	public static final String JBPM_STATES_NAME = "states";
	public static final String JBPM_RECT_START = "start";
	public static final String JBPM_RECT_END = "end";
	public static final String JBPM_COMPONENTS_TYPE = "type";
	public static final String JBPM_TASK_TYPE = "taskType";
	public static final String JBPM_COMPONENTS_PROPS_TASKID = "taskId";
	public static final String JBPM_COMPONENTS_ID_PARAM_VALUE = VALUE_LITERAL;
	public static final String JBPM_COMPONENTS_ATTR = "attr";
	public static final String JBPM_COMPONENTS_PROPS = "props";
	public static final String JBPM_COMPONENTS_PROPS_PARAM_VALUE = VALUE_LITERAL;
	public static final String JBPM_PATHS_NAME = "paths";
	public static final String JBPM_PATHS_FROM = "from";
	public static final String JBPM_PATHS_TO = "to";
	public static final String JBPM_PATHS_TEXT = "text";
	public static final String JBPM_PROPS_NAME = "props";
	public static final String JBPM_PROPS_PROCESS_VARIABLES = "processVariables";

	/**
	 * 流程日志常量
	 */
	// 任务日志标示
	public static final String TASK_LOG_LABEL = "tlog";
	// spark任务日志标示
	public static final String SPARK_LOG_LABEL = "spark";
	public static final String SPARK_JOB_SET = "-job-set";
	// _连接号
	public static final String PROCESS_CONNECTOR = "_";
	
	/**
	 * 组件参数
	 */
	// 任务执行日期
	public static final String COMPONENTS_PARAMS_EXEC_DATE = "execDate";
	// 任务ID
	public static final String COMPONENTS_PARAMS_TASK_ID = "taskId";
	// 任务名称
	public static final String COMPONENTS_PARAMS_TASK_NAME = "taskName";
	// 流程ID
	public static final String COMPONENTS_PARAMS_PROCESS_ID = "processId";
	// 流程所属应用
	public static final String COMPONENTS_PARAMS_APP = "appName";
	// 取消流程信息头
	public static final String COMPONENTS_PARAMS_MSG_HEADER = "Cancel by ";

	/**
	 * hive组件参数
	 */
	public static final String COMPONENTS_PARAMS_HIVE_SQL = "hsql";
	
	/**
	 * spark sql组件参数
	 */
	public static final String COMPONENTS_PARAMS_SPARK_SQL = "ssql";

	/**
	 * mapreduce组件参数
	 */
	public static final String COMPONENTS_PARAMS_MAPREDUCE_MAINCLASS = "mainClass";
	public static final String COMPONENTS_PARAMS_MAPREDUCE_PARAMES = "params";
	public static final String COMPONENTS_PARAMS_MAPREDUCE_MRJAR = "mrJar";
	
	/**
	 * spark jar组件参数
	 */
	public static final String COMPONENTS_PARAMS_SPARKJAR_MAINCLASS = "mainClass";
	public static final String COMPONENTS_PARAMS_SPARKJAR_PARAMES = "params";
	public static final String COMPONENTS_PARAMS_SPARKJAR_JAR = "jar";

	/**
	 * mysql组件参数
	 */
	public static final String COMPONENTS_PARAMS_MYSQL_SQL = "sql";
	public static final String COMPONENTS_PARAMS_MYSQL_DB_USER = "dbUser";
	public static final String COMPONENTS_PARAMS_MYSQL_DB_PASS = "dbPass";
	public static final String COMPONENTS_PARAMS_MYSQL_DB_CONNSTR = "connStr";

	/**
	 * java组件参数
	 */
	public static final String COMPONENTS_PARAMS_JAVA_JAR_FILE = "jar";
	public static final String COMPONENTS_PARAMS_JAVA_CLASS_NAME = "className";
	public static final String COMPONENTS_PARAMS_JAVA_METHOD_NAME = "methodName";
	public static final String COMPONENTS_PARAMS_JAVA_PARAMS = "params";
	public static final String COMPONENTS_PARAMS_JAVA_OUT = "javaOut";

	/**
	 * Shell组件参数
	 */
	public static final String COMPONENTS_PARAMS_SHELL_FILE = "shellFile";
	public static final String COMPONENTS_PARAMS_SHELL_PARAMS = "params";

	/**
	 * Cache组件参数
	 */
	public static final String COMPONENTS_PARAMS_CACHE_KEY = "key";
	public static final String COMPONENTS_PARAMS_CACHE_VALUE = VALUE_LITERAL;
	public static final String COMPONENTS_PARAMS_CACHE_OP = "cacheOp";

	/**
	 * 依赖组件参数
	 */
	public static final String COMPONENTS_PARAMS_DEP_PROCESS_ID = "target";
	public static final String COMPONENTS_PARAMS_DEP_EXEC_DATE = "depDate";

	/**
	 * HDFS组件参数
	 */
	public static final String COMPONENTS_PARAMS_HDFS_SRC_PATH = "srcPath";
	public static final String COMPONENTS_PARAMS_HDFS_DEST_PATH = "destPath";
	public static final String COMPONENTS_PARAMS_HDFS_OP = "hdfsOp";

	/**
	 * 数据迁移组件参数
	 */
	public static final String COMPONENTS_PARAMS_TRANSFER_MODE = "transferMode";
	public static final String COMPONENTS_PARAMS_TRANSFER_SOURCE_DATA = "sourceData";
	public static final String COMPONENTS_PARAMS_TRANSFER_DEST_DATA = "destData";
	public static final String COMPONENTS_PARAMS_TRANSFER_DB_USER = "dbUser";
	public static final String COMPONENTS_PARAMS_TRANSFER_DB_PASS = "dbPass";
	public static final String COMPONENTS_PARAMS_TRANSFER_DB_CONN_STR = "connStr";
	public static final String COMPONENTS_PARAMS_TRANSFER_OVERWRITE = "overWrite";
	public static final String COMPONENTS_PARAMS_TRANSFER_SEPERATOR = "seperator";

	/**
	 * 流程与组件之间的参数映射
	 */
	public static final String COMPONENTS_PARAMS_IN = "processParams";// 流程传入组件变量名
	public static final String COMPONENTS_PARAMS_OUT = "out";// 组件计算结果传入流程做为流程变量,其流程变量名

	public static final String CONFIG_RET_KEY = "list";

	// 换行符
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * <pre>
	 * 历史版本界面不能选择多数据源，历史数据没有数据源信息。
	 * 本版本上线时，会在P_DATABASE表加db_name字段，历史数据源统一叫default
	 * </pre>
	 */
	public static final String DATABASE_DEFAULT_NAME = "default";
	
	public static final String COMPONENTS_PARAMS_RDBMS = "rdbmsDB";
	
	/**
	 * 报表结果表DB
	 */
	public static final String REPORT_HIVE_DB = "d_report";

	public static final String PRIEST_PARAM_PRIFIX = "priest_param_";

	public static final String PRIEST_PARAMS_WHOLE = "priest.params";
	
	private Constants() {
	}

	public static String getThefilePath(String jarPath, String taskName, String version) {
		StringBuffer filePath = new StringBuffer();
		filePath.append(jarPath);
		filePath.append("/");
		filePath.append(taskName);
		filePath.append("-");
		filePath.append(version);
		filePath.append(".jar");
		return filePath.toString();
	}

	public static void combinationMap(Map<String, String> map, String value) throws JsonParseException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonParser jsonParser = objectMapper.getJsonFactory().createJsonParser(value);
		JsonNode jsonNode = jsonParser.readValueAsTree();

		for (Iterator<Entry<String, JsonNode>> iterator = jsonNode.getFields(); iterator.hasNext();) {
			Entry<String, JsonNode> entry = iterator.next();
			String k = entry.getKey();
			String v = entry.getValue().getTextValue();
			map.put(k, v);
		}
	}
}
