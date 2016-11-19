/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.DataTransferModeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveService;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.DataTransferService;
import com.lenovo.lps.farseer.priest2.platform.service.HdfsService;
import com.lenovo.lps.farseer.priest2.platform.service.SqoopService;
import com.lenovo.lps.farseer.priest2.platform.util.HiveSqlParserUtil;

/**
 * @author niexm1
 * 
 */
public class DataTransferServiceImpl implements DataTransferService {

	/**
	 * 迁移目标正则:
	 * 
	 * <pre>
	 * 对于分区表,Hive格式为:表名(字段1,字段2,字段3)[分区1=XXX,分区2=YYY] ,mysql/oracle格式为:表名(字段1,字段2,字段3)
	 * </pre>
	 * 
	 * <pre>
	 * 对于非分区表,格式为:表名(字段1,字段2,字段3)
	 * </pre>
	 * 
	 * <pre>
	 * 导入全表时,无须指定字段,格式简化为:表名或者表名[分区1=XXX,动态分区1]
	 * </pre>
	 */
	private final String resourceRegex = "^([\\w_\\-\\.]+)(\\(.+\\))?(\\[.+\\])?$";
	private final Pattern resourcePattern = Pattern.compile(resourceRegex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	@Resource
	private SqoopService sqoopService;

	@Resource
	private HiveService hiveService;

	@Resource
	private HdfsService hdfsService;

	@Resource
	private ApplicationService applicationService;

	@Override
	public void transferData(DataTransferModeEnum transMode, String source, String destination, boolean overWrite, DbEntity dbEntity,
			String processId, String execDate, Integer appId, String taskId) {
		// 去空格
		String trimDestination = destination == null ? "" : destination.trim();
		String trimSource = source == null ? "" : source.trim();

		// 获取hiveserver2连接URL和用户
		Map<String, String> app = applicationService.getApp(Integer.valueOf(appId));

		try {
			switch (transMode) {
			case H2M:  // hive 数据迁移到mysql
			case H2D:  // Hive数据迁移到hdfs
			case H2O:  // hive 数据迁移到oracle
				transferFromHiveProxy(transMode, dbEntity, trimDestination, trimSource, processId, execDate, app.get("appUser"));
				break;
			case M2H:  // mysql数据迁移到hive
				mysqlToHive(overWrite, dbEntity, trimDestination, trimSource, processId, execDate, app.get("appUser"),
						 taskId);
				break;
			case D2H:  // HDFS数据迁移到Hive
				hdfsToHive(overWrite, trimDestination, trimSource, execDate, app.get("appUser"), processId,
						taskId);
				break;
			case O2H:  // oracle数据迁移到hive
				oracleToHive(overWrite, dbEntity, trimDestination, trimSource, processId, execDate,  app.get("appUser"),
						 taskId);
				break;
			// 非法参数
			default:
				throw new IllegalArgumentException("transMode Illegal");
			}
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

	}

	private void transferFromHiveProxy(DataTransferModeEnum mode, DbEntity dbEntity, String trimDestination, String trimSource, String processId, String execDate,
			String appUser) throws IOException, SQLException, PriestPlatformException, InterruptedException{
		String source = trimSource;
		// 去掉最后";"
		if (source.endsWith(";")) {
			source = source.substring(0, source.length() - 1);
		}
		
		switch(mode){
		case H2M:
			hiveToMysql(dbEntity, trimDestination, source, processId, execDate, appUser);
			break;
		case H2O:
			hiveToOracle(dbEntity, trimDestination, source, processId, execDate, appUser);
			break;
		case H2D:
			hiveToHdfs(trimDestination, source, appUser);
			break;
		default:
			break;
		}
	}
	
	private void oracleToHive(boolean overWrite, DbEntity dbEntity, String trimDestination, String trimSource, String processId,
			String execDate, String appUser, String taskId) throws IOException {
		mysqlToHive(overWrite, dbEntity, trimDestination, trimSource, processId, execDate, appUser, taskId);
	}

	private void hiveToOracle(DbEntity dbEntity, String trimDestination, String source, String processId, String execDate,
			String appUser) throws IOException, SQLException, PriestPlatformException, InterruptedException {
		hiveToMysql(dbEntity, trimDestination, source, processId, execDate, appUser);
	}

	private void hdfsToHive(boolean overWrite, String trimDestination, final String trimSource, String execDate, String appUser,
			 String processId, String taskId) throws InterruptedException {
		String tab = null;

		try {
			ResourceDesc hiveDes = parseResource(trimDestination);

			// select from 中的表名
			tab = hiveDes.getTableName();

			StringBuilder loadSql = new StringBuilder();
			hdfsService.chmod777(trimSource);
			if (overWrite) {
				loadSql.append(String.format("LOAD DATA INPATH '%s' %s INTO TABLE %s", new Object[] { trimSource, "OVERWRITE", tab }));
			} else {
				loadSql.append(String.format("LOAD DATA INPATH '%s' INTO TABLE %s", new Object[] { trimSource, tab }));
			}

			// load到分区
			if (StringUtils.isNotBlank(hiveDes.getPartColsString())) {
				loadSql.append(String.format(" PARTITION (%s)", hiveDes.getPartColsString()));
			}


			// 执行hive sql
			hiveService.transferExecute(loadSql.toString(), appUser);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		Thread.sleep(20000);
	}

	private void hiveToHdfs(String trimDestination, String source, String appUser) {
		List<String> hiveTab = HiveSqlParserUtil.getFromTableName(source);
		Assert.isTrue(hiveTab != null && hiveTab.size() == 1, "Hive SQL did not specify a query table or specify lots!");

		String exportSql = String.format("INSERT OVERWRITE DIRECTORY '%s' %s", new Object[] { trimDestination, source });
		// 执行hive sql
		hiveService.transferExecute(exportSql, appUser);
	}

	private void mysqlToHive(boolean overWrite, DbEntity dbEntity, String trimDestination, String trimSource, String processId,
			String execDate, String appUser, String taskId) throws IOException {
		try {
			String source = trimSource;
			// 去掉最后";"
			if (source.endsWith(";")) {
				source = source.substring(0, source.length() - 1);
			}
			String tmpFilePath = null;
			ResourceDesc hiveDest = parseResource(trimDestination);
			String splitBy = null;
			// mysql连接信息
			String dbUserName = dbEntity.getUserName(), dbPassword = dbEntity.getPassword(), connectionUrl = dbEntity.getUrl(), driverClassName = dbEntity
					.getDriverClassName();
			String hiveTableName = hiveDest.getTableName();
			String separator = hiveService.getFieldsTerminatedBy(hiveTableName);
			boolean isResource = isResource(source);
			if (isResource) {
				ResourceDesc sourceDesc = parseResource(source);
				tmpFilePath = sqoopService.importDirect2Hdfs(hiveTableName, separator, connectionUrl, sourceDesc.getTableName(),
						dbUserName, dbPassword, driverClassName, processId, execDate, appUser);
			} else {
				// 通过Sqoop ,MySQL数据>>>HDFS
				tmpFilePath = sqoopService.importFromDatabase(source, separator, dbUserName, dbPassword, connectionUrl,
						driverClassName, splitBy, processId, execDate, appUser);
			}
			
			hdfsService.chmod777(tmpFilePath);
			
			String sql;
			if (overWrite) {
				sql = String
						.format("LOAD DATA INPATH '%s' %S INTO TABLE %s", new Object[] { tmpFilePath, "OVERWRITE", hiveTableName });
			} else {
				sql = String.format("LOAD DATA INPATH '%s' INTO TABLE %s", new Object[] { tmpFilePath, hiveTableName });
			}
			if (StringUtils.isNotBlank(hiveDest.getPartColsString())) {
				sql += String.format(" PARTITION (%s)", hiveDest.getPartColsString());
			}

			// 执行hive sql
			hiveService.transferExecute(sql, appUser);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	private void hiveToMysql(DbEntity dbEntity, String trimDestination, String source, String processId, String execDate,
			String appUser) throws IOException, SQLException, PriestPlatformException, InterruptedException {
		ResourceDesc dest = parseResource(trimDestination);
		String dbTable = dest.getTableName();
		boolean isResource = isResource(source);
		if (isResource) {
			ResourceDesc sourceDesc = parseResource(source);
			String hiveTable = sourceDesc.getTableName();
			String separator = hiveService.getFieldsTerminatedBy(hiveTable);
			String hivePath = hiveService.getStorageLocation(hiveTable);
			StringBuffer hiveSource = new StringBuffer(hivePath);
			if (!hivePath.endsWith("/")) {
				hiveSource.append("/");
			}
			// 没有判断分区的先后顺序，默认为按路径等级排列
			String partColsString = sourceDesc.getPartColsString();
			if (partColsString == null) {
				hivePath = new String(hiveSource);
			} else {
				hivePath = new String(hiveSource.append(partColsString.replaceAll("'", "").replaceAll(",", "/")));
			}
			sqoopService.exportDirect2Database(hivePath, separator, dbTable, dbEntity, processId, execDate, appUser);
		} else {
			List<String> hiveTables = HiveSqlParserUtil.getFromTableName(source);
			Assert.isTrue(hiveTables != null && hiveTables.size() == 1, "Hive SQL did not specify a query table or specify lots!");
			Map<String, Object> defaultFields = null;
			// 通过sqoop 调用,HIVE数据>>>到Database
			sqoopService.exportToDatabase(source, dbTable, defaultFields, dbEntity, processId, execDate, appUser);
		}
	}

	/**
	 * @param source
	 * @return
	 */
	private boolean isResource(String source) {
		boolean isParsable;
		try {
			parseResource(source);
			isParsable = true;
		} catch (IllegalArgumentException e) {
//			logger.info(e.getMessage(), e);
			isParsable = false;
		}
		return isParsable;
	}

	private ResourceDesc parseResource(String destination) {
		Matcher matcher = resourcePattern.matcher(destination);

		if (matcher.matches()) {
			ResourceDesc desc = new ResourceDesc();
			for (int i = 1, c = matcher.groupCount() + 1; i < c; i++) {
				String text = matcher.group(i);
				if (text == null) {
					continue;
				}

				text = text.trim();
				// 用户指定迁移目的地字段:(col1,col2,col3)
				if (text.startsWith("(")) {
					// 去掉()号
					text = text.substring(1, text.length() - 1);
					String[] cols = text.split(",");
					desc.setCols(cols);
				}
				// 用户指定迁移目的地分区字段:[part_col1=xxx,part_col2=yyy]
				else if (text.startsWith("[")) {
					// 去掉[]号
					text = text.substring(1, text.length() - 1);
					String[] partCols = text.split(",");
					desc.setPartCols(partCols);
				}
				// 表名
				else {
					desc.setTableName(text);
				}
			}

			return desc;
		}
		// 输入迁移目的地非法
		else {
			throw new IllegalArgumentException("Transfer Source or Dest Path error, Should be:tableName(col1,col2,col3)[part_col1=xxx,part_col2=yyy]");
		}

	}

	/**
	 * 导数源位置和目的位置描述
	 * 
	 * @author niexm1
	 * 
	 */
	class ResourceDesc {
		// 表名
		String tableName;
		// 列
		String[] cols;
		// 分区列
		String[] partCols;

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public String[] getCols() {
			return cols;
		}

		public void setCols(String[] cols) {
			this.cols = (cols == null ? new String[0] : Arrays.copyOf(cols, cols.length));
		}

		public String[] getPartCols() {
			return partCols;
		}

		public void setPartCols(String[] partCols) {
			this.partCols = (partCols == null ? new String[0] : Arrays.copyOf(partCols, partCols.length));
		}

		public String getPartColsString() {
			return (partCols == null || partCols.length == 0) ? null : StringUtils.join(partCols, ",");
		}

	}

}
