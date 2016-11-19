package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.config.HadoopConfigurationFactory;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveSelectColumn;
import com.lenovo.lps.farseer.priest2.platform.entity.Select;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectColumn;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveService;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;
import com.lenovo.lps.farseer.priest2.platform.service.SqoopDao;
import com.lenovo.lps.farseer.priest2.platform.service.SqoopService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.HiveSqlParserUtil;
import com.lenovo.lps.farseer.priest2.platform.util.OracleSQLParserUtils;
import com.lenovo.lps.farseer.priest2.platform.util.SQLParserUtils;

public class SqoopServiceImpl implements SqoopService {

	private final Logger logger = Logger.getLogger(SqoopServiceImpl.class);

	@Autowired
	@Qualifier("sqoopDao")
	private SqoopDao sqoopDao;

	// 设置mapper数据依据 .按数据量分mapper数目,以每个表平均15个字段,每个字段100字节算,200M内存能存放10-13万左右数据
	private final int mapperNumBarrier = 50000;

	// 每次从库中获取记录数
	private final int nrFetchSize = 1000;

	// SQL检查合法
	public static final String SQL_OK = null;
	// 列名重列错误
	public static final int SQL_ERROR_CODE_DUP_COLUMN = 1060;

	// select * 选择所有列
	private final String allColumn = "*";

	// java临时目录 *nix下为/data windows下为用户昨时目录
	private final String dataDir = File.separator + "data";

	// select 表达式
	private final String selectRegex = "^\\s*(select)\\s+";
	private final Pattern selectPattern = Pattern.compile(selectRegex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	@Resource
	private HiveService hiveService;

	private final String pathSeparatorKey = "path.separator";
	// 是否是windows标记
	private final boolean isWindows = System.getProperty("os.name").indexOf("Windows") > -1;

	// database 字段 封装字符: select col from a中的字段col,可以封闭为col
	private final String encloseColumnChar = "";

	private final Random random = Constants.RANDOM;
	
	@Resource
	private ShellService shellService;
	
	private String submit(String[] sqoopArgs, String appUser) throws PriestPlatformException, InterruptedException, IOException{
		HadoopConfigurationFactory.copyConfigToClasspath();
		
		//指定priest工程classPath
		
		StringBuffer commandLine = new StringBuffer();
		commandLine.append(ConfigUtil.getContextProperty("java.path", "/var/lib/priest/jdk1.7.0_67-cloudera/bin/java"));
		commandLine.append(" -DUSER.KERBEROS.REALM=");
		commandLine.append(ConfigUtil.getContextProperty("realm.krb", "@AVATAR.LENOVOMM.COM"));
		//引用priest工程bean
		commandLine.append(" -classpath ");
		commandLine.append(com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getJarPathForClass(SqoopServiceImpl.class));
		//引用指定jar
		String runtimeClassPath = com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getHadoopProcessClassPath();
		if (CommUtils.isNotNull(runtimeClassPath)) {
			commandLine.append(File.pathSeparator);
			commandLine.append(runtimeClassPath);
		}
		
		//指定运行class
		commandLine.append(" ");
		commandLine.append("-Xmx512m -XX:MaxPermSize=128M -XX:-UseGCOverheadLimit");
		
		//指定运行class
		commandLine.append(" ");
		commandLine.append("com.lenovo.lps.farseer.priest2.ext.JavaRunSqoop");

		//指定运行用户
		commandLine.append(" ");
		commandLine.append(appUser);
		
		commandLine.append(" ");
		commandLine.append(com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getHadoopConfigPath().getAbsolutePath());
		
		commandLine.append(" ");
		commandLine.append(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase());
		//指定sqoop运行参数
		commandLine.append(" ");
		int size = sqoopArgs.length;
		String sqoopArg;
		for (int i = 0; i < size; i++) {
			sqoopArg = sqoopArgs[i];
			if (sqoopArg.contains(Constants.SQOOP_FIELD_TERMINATED)) {
				sqoopArgs[i] = sqoopArg.replace(Constants.SQOOP_FIELD_TERMINATED, Constants.SQOOP_FIELD_TERMINATED_REPLACE);
			}
		}
		commandLine.append(StringUtils.join(sqoopArgs, Constants.SQOOP_FIELD_TERMINATED));
		
		String command = commandLine.toString() + Constants.SQOOP_FIELD_TERMINATED + "--verbose";
		AuditLog.log("Jar qoop job:" + command);
		return shellService.runCommand(null, command);
	}

	@Override
	public String importFromDatabase(String selectSql, String separator, String dbUserName, String dbPassword, String connectionUrl,
			String driverClassName, String splitBy, String processId, String execDate, String appUser) throws PriestPlatformException, InterruptedException, IOException, SQLException {
		Select select;
		if (driverClassName.toLowerCase().contains("mysql")) {
			select = SQLParserUtils.parseSelectSQL(selectSql);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			select = OracleSQLParserUtils.parseSelectSQL(selectSql);
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}
		String tmpTableName = createTmpTable(selectSql, dbUserName, dbPassword, connectionUrl, driverClassName, select);
		String warehouseDir = ConfigUtil.getContextProperty("system.hive.warehouse.location", "/apps/hive/warehouse/");
		// 导入hdfs目标目录 :hive ware house dir/importFromSQL/表名/当前ticks_[0-99999]随机数
		String importTargetDir = new StringBuffer(warehouseDir).append(warehouseDir.endsWith("/") ? "" : "/").append("importFromSQL")
				.append("/").append(StringUtils.isNotEmpty(tmpTableName) ? tmpTableName : select.getFromItem()).append("/")
				.append(System.currentTimeMillis()).append("_").append(Math.abs(random.nextInt(99999))).toString();

		String dir = dataDir + File.separator + "SQOOP_JAVA" + File.separator + appUser + File.separator + processId + "_" + execDate
				+ File.separator + System.currentTimeMillis() + File.separator;
		// 构造调用sqoop参数
		String[] args;
		args = makeImportArgs(selectSql, tmpTableName, separator, dbUserName, dbPassword, connectionUrl, driverClassName,
				importTargetDir, splitBy, dir, appUser);

		int sqoopResult = 0;

		try {
			/**
			 * <pre>
			 * 			sqoop 提交map reduce job时,会设置mapred.job.classpath.archives,值为sqoop-x.y.z.jar与mysql-connector-java-x.y.z.jar,
			 * 			Map/Reduce运行时从classpath加载,多个jar以System.getProperty("path.separator")分隔,
			 * 			windows下为";"与hadoop环境的":"不一致,导致找不到jar.
			 *          windows系统提交JOB前,设置为:,与hadoop同步(测试目的,不影响生产linux系统)
			 * </pre>
			 **/
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ":");
			}

			logger.info("Database >>> HIVE SQL:" + selectSql);
			logger.info("Database >>> HIVE sqoop parameters:" + StringUtils.join(args, ","));
			submit(args, appUser);
		} catch (Exception e) {
			logger.error("Sqoop Arguments : " + StringUtils.join(args, " "));	
			StringBuilder sb = new StringBuilder("Sqoop Arguments : " + StringUtils.join(args, " "));
			for (StackTraceElement st : e.getStackTrace()){
				sb.append("\n") ;
				sb.append(st.toString());
			}
			throw new PriestPlatformException("Sqoop Error:", e ) ;
		} finally {
				if (isWindows) {
					System.setProperty(pathSeparatorKey, ";");
				}
				// 连表查询时,清除临时表
				if (tmpTableName != null) {
					new Thread(new DropTmpTableThread(tmpTableName, dbUserName, dbPassword, connectionUrl, driverClassName)).start();
				}
				FileUtils.deleteQuietly(new File(dir).getParentFile());
	
			}
	
			if (sqoopResult != 0) {
				String err = " retcode:" + sqoopResult;
				throw new PriestPlatformException("Database>>>Hive,Sqoop Exception :" + err);
			}
	
			return importTargetDir;
		}

	private String createTmpTable(String selectSql, String srcDbUserName, String srcDbPassword, String srcConnectionUrl,
			String srcDriverClassName, Select select) throws SQLException {
		String tmpTableName = null;
		// 连表查询标志
		boolean isJoinSelect = CollectionUtils.isNotEmpty(select.getJoins());

		// 是否select t1.c1 + t2.c2 表达式列 ,如果存在的话,不能直接dump,需要生成临时表再dump,否则
		boolean isExpressionSelect;

		String tmp;
		if (srcDriverClassName.toLowerCase().contains("mysql")) {
			isExpressionSelect = SQLParserUtils.checkExpressionSelect(selectSql);
			tmp = "tmp_";
		} else if (srcDriverClassName.toLowerCase().contains("oracle")) {
			isExpressionSelect = OracleSQLParserUtils.checkExpressionSelect(selectSql);
			tmp = "TMP_";
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}
		// 连表查询 或者　单表select列值通过运算(如a.c1 + b.c1)获取时，查询结果到临时表,从临时表dump
		if (isJoinSelect || isExpressionSelect) {
			tmpTableName = tmp + System.currentTimeMillis() + "_" + Math.abs(random.nextInt(99999));
			String createTableSql = "CREATE TABLE " + tmpTableName + " AS " + selectSql;
			sqoopDao.execute(createTableSql, srcDbUserName, srcDbPassword, srcConnectionUrl, srcDriverClassName);
		}
		return tmpTableName;
	}

	@Override
	public void exportToDatabase(String hiveSql, String tableName, Map<String, Object> defaultFields,
			DbEntity dbConnectionEntity, String processId, String execDate, String appUser)
			throws IOException, SQLException, PriestPlatformException, InterruptedException {

		String hql = hiveSql;
		// join检查
		boolean isJoin = HiveSqlParserUtil.isJoinQL(hql);
		if (isJoin) {
			throw new PriestPlatformException("Join is not support when export data to database");
		}

		// 从SQL中,获取查询列名,这些列为做为写database表时的列名
		Map<String, String> map = generateFields(hql, defaultFields);
		// 如果用户指定默认值,把默认值也写入查询SQL中
		hql = map.get("hiveSQL");

		/**
		 * <pre>
		 * 数据存储到hive临时表,原因如下:
		 * 1.对于分区表,sqoop不支持分区导数,必须通过create table as select创建临时表,数据存储到非分区临时表
		 * 2.对于非分区字段,hive sql查询时,可能不按HDFS上存储顺序(E.g HDFS顺序为col1,col2,col3),当select col3,col1时,Sqoop只会按存储顺序取col1,col2
		 * </pre>
		 */

		// 临时表名:原表名_随机数_当前ticks
		String fromTable = HiveSqlParserUtil.getFromTableName(hql).get(0);
		String abs = String.valueOf(random.nextLong()).replace("-", "");
		int pointIndex = fromTable.indexOf(".");
		if (pointIndex != -1) {
			fromTable = StringUtils.substring(fromTable, pointIndex + 1);
		}
		String hiveTmpTable, defaultName = ConfigUtil.getContextProperty("sqoop.default.dbname", "tmp");
		hiveTmpTable = defaultName + "." + fromTable + "_" + abs + "_" + System.currentTimeMillis();
		String dropTmpTable = " drop table " + hiveTmpTable;
		// 创建临时表
		String createTmpTable = "create table " + hiveTmpTable + " stored as textfile as " + hql;
		hiveService.transferExecute(createTmpTable, appUser);

		// .java/.class/.jar存放目录
		String dir = dataDir + File.separator + "SQOOP_JAVA" + File.separator + appUser + File.separator + processId + "_" + execDate
				+ File.separator + System.currentTimeMillis() + File.separator;
		int sqoopResult = 0;
		String sqoopArgs = "";
		try {
			List<String> columns = hiveService.getColumns(hiveTmpTable);
			String selectColumnStr = StringUtils.join(columns, ",");
			// Hive数据导入database时,在select中必须指明导入哪个字段,如果字段在database中不存在,报错
			checkDatabaseColumn(tableName, dbConnectionEntity, selectColumnStr);

			// 从hive临时表导数,取其在hdfs上路径
			String hivePath = hiveService.getStorageLocation(hiveTmpTable);

			final String[] args = new String[] { Constants.SQOOP_EXPORT_TOOLNAME, Constants.DB_CONNECT_PROPETY,
					dbConnectionEntity.getUrl(), Constants.DB_USERNAME_PROPETY, dbConnectionEntity.getUserName(),
					Constants.DB_PASSWORD_PROPETY, dbConnectionEntity.getPassword(), Constants.TABLE_PROPETY, tableName,
					Constants.EXPORT_DIR_PROPETY, hivePath, Constants.FIELDS_SEPARATOR_PROPETY,
					Constants.HIVE_DEFAULT_FIELD_TERMINATED, Constants.INPUT_NULL_STRING, Constants.HIVE_NULL_STRING,
					Constants.INPUT_NULL_NON_STRING, Constants.HIVE_NULL_STRING, "--outdir", dir, "--bindir", dir, "--columns",
					selectColumnStr, "--num-mappers", "16" };

			sqoopArgs = StringUtils.join(args, ",");
			/**
			 * <pre>
			 * 			sqoop 提交map reduce job时,会设置mapred.job.classpath.archives,值为sqoop-x.y.z.jar与mysql-connector-java-x.y.z.jar,
			 * 			Map/Reduce运行时从classpath加载,多个jar以System.getProperty("path.separator")分隔,
			 * 			windows下为";"与hadoop环境的":"不一致,导致找不到jar.
			 *          windows系统提交JOB前,设置为:,与hadoop同步(测试目的,不影响生产linux系统)
			 * </pre>
			 **/
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ":");
			}

			logger.info("HIVE >>> Database SQL:" + hql);
			logger.info("HIVE >>> Database sqoop parameters:" + sqoopArgs);
			submit(args, appUser);
		}
		// 删除临时表
		finally {
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ";");
			}
			hiveService.transferExecute(dropTmpTable, appUser);
			FileUtils.deleteQuietly(new File(dir).getParentFile());
		}

		if (sqoopResult != 0) {
			throw new PriestPlatformException("Hive>>>Database,Sqoop Exeception");
		}

	}

	/**
	 * Hive数据导入database时,在select中必须指明导入哪个字段,如果字段在database中不存在,报错
	 * 
	 * @param tableName
	 * @param dbConnectionEntity
	 * @param hiveSelectColumns
	 * @throws SQLException 
	 */
	private void checkDatabaseColumn(String tableName, DbEntity dbConnectionEntity, String hiveSelectColumns) throws SQLException {
		// 查询表tableName所有列
		String selectSQL = "select * from " + tableName + " limit 1";
		String[] databaseColumnNames = null;
		databaseColumnNames = sqoopDao.getColumnNames(selectSQL, dbConnectionEntity.getUserName(),
				dbConnectionEntity.getPassword(), dbConnectionEntity.getUrl(), dbConnectionEntity.getDriverClassName());

		// 用户select 时指定列,多个用","分隔
		String[] selectColumns = hiveSelectColumns.split(",");

		// Hive数据导入database时,在select中必须指明导入哪个字段,如果字段在database中不存在,报错
		for (String selectColumn : selectColumns) {
			boolean contains = false;
			for (String databaseColumnName : databaseColumnNames) {
				if (selectColumn.equalsIgnoreCase(databaseColumnName)) {
					contains = true;
					break;
				}
			}

			if (!contains) {
				throw new PriestPlatformException("HIVE SQL query field/alias:" + selectColumn + " doesn't exists in database, please check the table:" + tableName);
			}
		}
	}

	/**
	 * 通过hive SQL与默认值,汇总导入database目标表中的列
	 * 
	 * @param hiveSQL
	 * @param defaultFields
	 * @return
	 * @throws IOException
	 */
	private Map<String, String> generateFields(String hiveSQL, Map<String, Object> defaultFields) {
		String hql = hiveSQL;
		Map<String, String> result = new HashMap<String, String>();

		// 获取select column
		HiveSelectColumn[] selectColumns = HiveSqlParserUtil.getColumn(hql);

		// select * 时,数据不能insert 到database
		if ("*".equals(selectColumns[0].getColumnName())) {
			throw new PriestPlatformException("SQL doesn't order the column,select * query data cause the insert operation error!");
		}

		// 查询常量时,必须必须指定别名,其值为database表相应列名
		for (HiveSelectColumn column : selectColumns) {
			// select 1常量查询时,必须指定别名,否则无法insert到database表
			if (column.isConstant() && StringUtils.isEmpty(column.getAlias())) {
				throw new PriestPlatformException("Constant in select(ex:Select 1),must order an alias, the value is column name!");
			}

		}

		// select col1,col2,col3等
		StringBuilder selectColumnsStr = new StringBuilder();

		StringBuilder newSql = new StringBuilder("SELECT");

		if (defaultFields != null && defaultFields.size() > 0) {
			for (Entry<String, Object> entry : defaultFields.entrySet()) {
				addFields(selectColumnsStr, newSql, entry);
			}

			// 由于用户指定了某些列上有默认值,在此改写输入的SQL,加上输入的默认值做为查询列
			Matcher matcher = selectPattern.matcher(hql);
			StringBuffer sb = new StringBuffer();
			if (matcher.find()) {
				matcher.appendReplacement(sb, newSql.toString());
			}
			matcher.appendTail(sb);

			// 改写hive sql
			hql = sb.toString();
		}

		for (HiveSelectColumn column : selectColumns) {
			String alias = column.getAlias();
			// select col1,2 as col2 from hive_table, insert到database时,列为
			// col1,col2
			selectColumnsStr.append(StringUtils.isNotBlank(alias) ? alias : column.getColumnName()).append(",");
		}

		result.put("columns", selectColumnsStr.substring(0, selectColumnsStr.length() - 1).toLowerCase());
		result.put("hiveSQL", hql);
		return result;
	}

	private void addFields(StringBuilder selectColumnsStr, StringBuilder newSql, Entry<String, Object> entry) {
		String key = entry.getKey();
		selectColumnsStr.append(key).append(",");

		Object constantValue = entry.getValue();
		// 值为Date,varchar型时,用"'"号引起 ,别名为key,构造成select 'abc' col1形式,
		if (constantValue instanceof String || constantValue instanceof java.util.Date || constantValue instanceof java.sql.Date) {
			newSql.append(" '").append(constantValue).append("'").append(" ").append(key).append(", ");
		}
		// 值为数字时,构造成select 1 col1形式,
		else {
			newSql.append(" ").append(constantValue).append(" ").append(key).append(", ");
		}
	}

	private String[] makeImportArgs(String selectSql, String tmpTableName, String separator, String dbUserName, String dbPass,
			String connectionStr, String driverClassName, String importTargetDir, String splitBy, String dir, String appUser)
			throws SQLException {
		List<String> args = new LinkedList<String>();
		args.add("import");

		/** database config **/
		args.add("--connect");
		args.add(connectionStr);

		// table主键
		String primaryKey = null;

		/** import config **/
		Select select = null;
		if (driverClassName.toLowerCase().contains("mysql")) {
			select = SQLParserUtils.parseSelectSQL(selectSql);
			args.add("--driver");
			args.add(driverClassName);
			args.add("--username");
			args.add(dbUserName);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			select = OracleSQLParserUtils.parseSelectSQL(selectSql);
			args.add("--username");
			args.add(dbUserName.toUpperCase());
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}

		args.add("--password");
		args.add(dbPass);
		boolean isJoinSelect = CollectionUtils.isNotEmpty(select.getJoins());

		// 直接sql查询,分shard分布式导数
		if (isJoinSelect && StringUtils.isEmpty(tmpTableName)) {
			args.add("--query");
			args.add(selectSql);

			if (select.getWhere() != null) {
				args.add("--where");
				String where = select.getWhere().toString();
				args.add(where);
			}

			SelectColumn[] selectColumns;
			if (driverClassName.toLowerCase().contains("mysql")) {
				selectColumns = SQLParserUtils.getColumn(selectSql);
			} else if (driverClassName.toLowerCase().contains("oracle")) {
				selectColumns = OracleSQLParserUtils.getColumn(selectSql);
			} else {
				throw new PriestPlatformException("Database driver class name is not supported");
			}
			selectColumns = buildSelectColumn(selectColumns, dbUserName, dbPass, connectionStr, driverClassName);
			Assert.notEmpty(selectColumns, "SQL format error:" + selectSql);

			// 取第一列为主键 注:数据分布很有可能不均衡,用来分shard性能太慢!!!!!!!!!!!!,后继版本需用户指定
			primaryKey = selectColumns[0].getColumnName();
		}
		// 通过mysqldump导数
		else {
			args.add("--direct");
			args.add("--table");
			String tableName = null;
			if (driverClassName.toLowerCase().contains("mysql")) {
				tableName = SQLParserUtils.getTableName(selectSql)[0];
			} else if (driverClassName.toLowerCase().contains("oracle")) {
				tableName = OracleSQLParserUtils.getTableName(selectSql)[0];
			} else {
				throw new PriestPlatformException("Database driver class name is not supported");
			}
			args.add(StringUtils.isEmpty(tmpTableName) ? tableName : tmpTableName);

			// 获取原表主键
			primaryKey = sqoopDao.getPrimaryKey(tableName, dbUserName, dbPass, connectionStr, driverClassName);

			// 从原表导数，可能不会选择所有的列，需要指定列
			if (StringUtils.isEmpty(tmpTableName)) {
				// 整表查询时，需要指定查询列
				args.add("--columns");
				// 解析SQL中的select部分
				SelectColumn[] selectColumns;
				if (driverClassName.toLowerCase().contains("mysql")) {
					selectColumns = SQLParserUtils.getColumn(selectSql);
					selectColumns = buildSelectColumn(selectColumns, dbUserName, dbPass, connectionStr, driverClassName);
					args.add(StringUtils.join(SQLParserUtils.getColumnNames(selectColumns), ","));
				} else if (driverClassName.toLowerCase().contains("oracle")) {
					selectColumns = OracleSQLParserUtils.getColumn(selectSql);
					selectColumns = buildSelectColumn(selectColumns, dbUserName, dbPass, connectionStr, driverClassName);
					args.add(StringUtils.join(OracleSQLParserUtils.getColumnNames(selectColumns), ","));
				} else {
					throw new PriestPlatformException("Database driver class name is not supported");
				}
				if (select.getWhere() != null) {
					args.add("--where");
					String where = select.getWhere().toString();

					args.add(where);
				}

				// 表不存在主键 取第一列.注:数据分布很有可能不均衡,用来分shard性能太慢!!!!!!!!!!!!,后继版本需用户指定
				if (StringUtils.isEmpty(primaryKey)) {
					primaryKey = selectColumns[0].getColumnName();
				}
			}
			// 从临时表导数
			else {
				String[] colNames = sqoopDao.getColumnNames("select * from " + tmpTableName + " where 1= 0", dbUserName, dbPass,
						connectionStr, driverClassName);
				primaryKey = getTmpTableCols(primaryKey, colNames);
			}
		}

		/** config split-by **/
		args.add("--split-by");
		// 调用方指定splitBy
		if (StringUtils.isNotEmpty(splitBy)) {
			args.add(splitBy);
		}
		// 从表中获取主键，如果主键不存在随机取第一个select
		// column做分shard列；注：由于随机获取列，列域数据分布可能非常不均，性能特慢
		else {
			args.add(primaryKey);
		}

		args.add("--target-dir");
		args.add(importTargetDir);
		args.add("--num-mappers");

		Long records = sqoopDao.countRecords(selectSql, dbUserName, dbPass, connectionStr, driverClassName);

		// 每5万左右数据一个mapper,占100M左右内存
		int nrMapper = Long.valueOf(records.longValue() / mapperNumBarrier).intValue();

		// bug fixed 防止小数据量导数重复
		if (nrMapper == 0) {
			nrMapper = 1;
		}

		args.add(String.valueOf(nrMapper));

		args.add("--fetch-size");
		args.add(String.valueOf(nrFetchSize));

		/** hive config **/

		/** output format config **/
		if (StringUtils.isNotEmpty(separator)) {
			args.add("--fields-terminated-by");
			args.add(separator);
		}

		/** code generate config **/
		// .java文件存放目录
		args.add("--outdir");
		args.add(dir);
		// .class和.jar文件存放目录
		args.add("--bindir");
		args.add(dir);

		/** null deal **/
		args.add("--null-string");
		args.add(Constants.HIVE_NULL_STRING);
		args.add("--null-non-string");
		args.add(Constants.HIVE_NULL_STRING);

		return args.toArray(new String[args.size()]);
	}

	private String getTmpTableCols(String key, String[] colNames) {
		String primaryKey = key;
		int size = colNames.length;
		for (int i = 0; i < size; ++i) {
			colNames[i] = colNames[i].toLowerCase();
		}
		// 原表不存在主键 或者
		// 主键未被select时,取第一列.注:数据分布很有可能不均衡,用来分shard性能太慢!!!!!!!!!!!!,后继版本需用户指定
		Arrays.sort(colNames);
		if (StringUtils.isEmpty(primaryKey) || Arrays.binarySearch(colNames, primaryKey.toLowerCase()) < 0) {
			// 需要用``封装列,如table a有一列列名为count(*),不封闭的话,后台会报错
			primaryKey = encloseColumnChar + colNames[0] + encloseColumnChar;
		}
		return primaryKey;
	}

	/**
	 * 删除临时表线程
	 * 
	 * @author niexm1
	 * 
	 */
	class DropTmpTableThread implements Runnable {
		String tmpTableName, userName, password, connectionUrl, driverClassName;

		public DropTmpTableThread(String tmpTableName) {
			this.tmpTableName = tmpTableName;
		}

		public DropTmpTableThread(String tmpTableName, String userName, String password, String connectionStr, String driverClassName) {
			this.tmpTableName = tmpTableName;
			this.userName = userName;
			this.password = password;
			this.connectionUrl = connectionStr;
			this.driverClassName = driverClassName;
		}

		public void run() {
			try {
				sqoopDao.dropTmpTable(tmpTableName, userName, password, connectionUrl, driverClassName);

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public String checkSql(String selectSQL, String dbUserName, String dbPassword, String connectionUrl, String driverClassName)
			throws SQLException {
		// 1.SQL合法性检查
		if (driverClassName.toLowerCase().contains("mysql")) {
			SQLParserUtils.parseSelectSQL(selectSQL);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			OracleSQLParserUtils.parseSelectSQL(selectSQL);
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}
		// 2.重复列检查
		Set<String> columns = new HashSet<String>();
		String[] columnNames = null;
		try {
			columnNames = sqoopDao.getColumnNames(selectSQL, dbUserName, dbPassword, connectionUrl, driverClassName);
		} catch (SQLException e) {
			if (SQL_ERROR_CODE_DUP_COLUMN == e.getErrorCode()) {
				return e.getMessage();
			} else {
				throw e;
			}
		}

		for (String columnName : columnNames) {
			if (columns.contains(columnName)) {
				return "SQL is invalid,  Repeated column:" + columnName;
			} else {
				columns.add(columnName);
			}
		}

		// 3 别名检查
		String msg = null;
		if (driverClassName.toLowerCase().contains("mysql")) {
			msg = SQLParserUtils.checkSelect(selectSQL);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			msg = OracleSQLParserUtils.checkSelect(selectSQL);
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}
		if (msg != null && msg.length() > 0) {
			return msg;
		}

		return SQL_OK;

	}

	/**
	 * 删除结果文件
	 * 
	 * @author niexm1
	 * 
	 */
	class DeleteResultFileThread implements Runnable {
		String fullFileName;

		public DeleteResultFileThread(String fullFileName) {
			this.fullFileName = fullFileName;
		}

		public void run() {
			// 删除结果文件
			try {
				URI uri = new URI(fullFileName);
				FileSystem fs = FileSystem.get(uri, HadoopConfigurationFactory.getHadoopConfiguration());
				fs.delete(new Path(fullFileName), true);
			} catch (URISyntaxException e) {
				logger.error(e.getMessage(), e);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void deleteFile(String fullFileName) {
		new Thread(new DeleteResultFileThread(fullFileName)).start();
	}

	private SelectColumn[] buildSelectColumn(SelectColumn[] selectColumns, String dbUserName, String dbPass, String connectionStr,
			String driverClassName) throws SQLException {
		List<SelectColumn> columns = new ArrayList<SelectColumn>(selectColumns.length);
		for (SelectColumn selectColumn : selectColumns) {

			// select * 选择所有列
			if (allColumn.equals(selectColumn.getColumnName())) {
				String sql = "select * from " + selectColumn.getTableName() + " where 1=0 ";
				String[] colNames = sqoopDao.getColumnNames(sql, dbUserName, dbPass, connectionStr, driverClassName);

				for (String colName : colNames) {
					SelectColumn column = new SelectColumn();
					column.setColumnName(colName);
					column.setTableName(selectColumn.getTableName());
					columns.add(column);
				}
			} else {
				columns.add(selectColumn);
			}
		}

		return columns.toArray(new SelectColumn[columns.size()]);

	}

	@Override
	public String importDirect2Hdfs(String hiveTable, String separator, String connectionUrl, String dbTable, String dbUserName,
			String dbPassword, String driverClassName, String processId, String execDate, String appUser) throws SQLException, PriestPlatformException, InterruptedException, IOException {
		/** 1.导入路径 */
		String warehouseDir = ConfigUtil.getContextProperty("system.hive.warehouse.location", "/apps/hive/warehouse/");
		String importTargetDir = new StringBuffer(warehouseDir).append(warehouseDir.endsWith("/") ? "" : "/").append("importFromSQL")
				.append("/").append(hiveTable).append("/").append(System.currentTimeMillis()).append("_")
				.append(Math.abs(random.nextInt(99999))).toString();
		/** 2.获取split by字段 */
		// 获取原表主键
		String primaryKey = sqoopDao.getPrimaryKey(dbTable, dbUserName, dbPassword, connectionUrl, driverClassName);
		// 表不存在主键 取第一列.注:数据分布很有可能不均衡,用来分shard性能太慢!!!!!!!!!!!!,后继版本需用户指定
		if (StringUtils.isEmpty(primaryKey)) {
			primaryKey = sqoopDao.getTableColumnNames(dbTable, dbUserName, dbPassword, connectionUrl, driverClassName).get(0);
		}
		/** 3.获取mapper数 */
		Long records = sqoopDao.countRecords("select * from " + dbTable, dbUserName, dbPassword, connectionUrl, driverClassName);
		// 每5万左右数据一个mapper,占100M左右内存
		int nrMapper = Long.valueOf(records.longValue() / mapperNumBarrier).intValue();
		// bug fixed 防止小数据量导数重复
		if (nrMapper == 0) {
			nrMapper = 1;
		}
		/** 4.合成sqoop導數參數 */
		List<String> args = new LinkedList<String>();
		args.add("import");
		args.add("--direct");
		args.add("--connect");
		args.add(connectionUrl);
		args.add("--table");
		args.add(dbTable);
		if (driverClassName.toLowerCase().contains("mysql")) {
			args.add("--driver");
			args.add(driverClassName);
			args.add("--username");
			args.add(dbUserName);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			args.add("--username");
			args.add(dbUserName.toUpperCase());
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}
		args.add("--password");
		args.add(dbPassword);
		args.add("--target-dir");
		args.add(importTargetDir);
		args.add("--num-mappers");
		args.add(String.valueOf(nrMapper));
		/** config split-by **/
		args.add("--split-by");
		args.add(primaryKey);
		/** hive config **/
		/** output format config **/
		if (StringUtils.isNotEmpty(separator)) {
			args.add("--fields-terminated-by");
			args.add(separator);
		}
		/** code generate config **/
		String dir = dataDir + File.separator + "SQOOP_JAVA" + File.separator + appUser + File.separator + processId + "_" + execDate
				+ File.separator + System.currentTimeMillis() + File.separator;
		// .java文件存放目录
		args.add("--outdir");
		args.add(dir);
		// .class和.jar文件存放目录
		args.add("--bindir");
		args.add(dir);
		/** null deal **/
		args.add("--null-string");
		args.add(Constants.HIVE_NULL_STRING);
		args.add("--null-non-string");
		args.add(Constants.HIVE_NULL_STRING);

		int sqoopResult = 0;
		try {
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ":");
			}
			logger.info("Database >>> HIVE sqoop parameters:" + StringUtils.join(args, ","));
			submit(args.toArray(new String[0]), appUser);
		} finally {
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ";");
			}
			FileUtils.deleteQuietly(new File(dir).getParentFile());
		}

		if (sqoopResult != 0) {
			throw new PriestPlatformException("Database>>>Hive,Sqoop Exception!");
		}

		return importTargetDir;
	}

	@Override
	public void exportDirect2Database(String hivePath, String separator, String dbTable, DbEntity dbConnectionEntity,
			String processId, String execDate, String appUser) throws PriestPlatformException, InterruptedException, IOException {
		List<String> args = new LinkedList<String>();
		args.add("export");
		args.add("--direct");
		args.add("--connect");
		args.add(dbConnectionEntity.getUrl());
		args.add("--table");
		args.add(dbTable);
		String driverClassName = dbConnectionEntity.getDriverClassName();
		String dbUserName = dbConnectionEntity.getUserName();
		if (driverClassName.toLowerCase().contains("mysql")) {
			args.add("--driver");
			args.add(driverClassName);
			args.add("--username");
			args.add(dbUserName);
		} else if (driverClassName.toLowerCase().contains("oracle")) {
			args.add("--username");
			args.add(dbUserName.toUpperCase());
		} else {
			throw new PriestPlatformException("Database driver class name is not supported");
		}
		args.add("--password");
		args.add(dbConnectionEntity.getPassword());
		args.add("--export-dir");
		args.add(hivePath);
		args.add("--num-mappers");
		args.add("16");
		/** hive config **/
		/** input format config **/
		args.add("--input-fields-terminated-by");
		args.add(separator);
		/** code generate config **/
		String dir = dataDir + File.separator + "SQOOP_JAVA" + File.separator + appUser + File.separator + processId + "_" + execDate
				+ File.separator + System.currentTimeMillis() + File.separator;
		// .java文件存放目录
		args.add("--outdir");
		args.add(dir);
		// .class和.jar文件存放目录
		args.add("--bindir");
		args.add(dir);
		/** null deal **/
		args.add("--null-string");
		args.add(Constants.HIVE_NULL_STRING);
		args.add("--null-non-string");
		args.add(Constants.HIVE_NULL_STRING);
		int sqoopResult = 0;
		try {
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ":");
			}

			logger.info("HIVE >>> Database sqoop parameters:" + StringUtils.join(args, ","));
			submit(args.toArray(new String[0]), appUser);
		} finally {
			if (isWindows) {
				System.setProperty(pathSeparatorKey, ";");
			}
			FileUtils.deleteQuietly(new File(dir).getParentFile());
		}

		if (sqoopResult != 0) {
			throw new PriestPlatformException("Hive>>>Database,Sqoop Exception!");
		}
	}

}