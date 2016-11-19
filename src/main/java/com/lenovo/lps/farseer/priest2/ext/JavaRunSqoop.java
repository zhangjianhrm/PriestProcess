/**
 * 
 */
package com.lenovo.lps.farseer.priest2.ext;

import java.io.File;
import java.net.MalformedURLException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.sqoop.Sqoop;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * @author yujw
 * 
 */
public class JavaRunSqoop {
	private static Logger logger = Logger.getLogger(JavaRunSqoop.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		String usage = "JavaRunSqoop jarFile  appuser args...";

		if (args.length < 1) {
			logger.error(usage + "args.length < 1");
			System.exit(-1);
		}

		int firstArg = 0;

		// 业务用户
		String appUser = args[firstArg++];
		if (appUser == null) {
			logger.error(usage + "appUser is null");
			System.exit(-1);
		}
		
		// 业务路径
		String configPath = args[firstArg++];
		if (configPath == null) {
			logger.error(usage + "configPath is null");
			System.exit(-1);
		}
		// 业务路径
		String securityType = args[firstArg++];
		if (securityType == null) {
			logger.error(usage + "securityType is null");
			System.exit(-1);
		}
		// sqoop运行参数
		StringBuffer sqoopArgStrBuf = new StringBuffer("");
		int size = args.length - 1;
		for (int i = firstArg; i < size; i++) {
			sqoopArgStrBuf.append(args[i]).append(" ");
		}
		sqoopArgStrBuf.append(args[size]);
		String sqoopArgStr = sqoopArgStrBuf.toString();
		if (sqoopArgStr == null || CommUtils.isEmpty(sqoopArgStr)) {
			logger.error(usage + "sqoopArgStr is null");
			System.exit(-1);
		}
		
		final String[] sqoopArgs = sqoopArgStr.split(Constants.SQOOP_FIELD_TERMINATED);
		int saSize = sqoopArgs.length;
		if (saSize <= 1) {
			logger.error(usage + "sqoopArgs length <= 1" + sqoopArgStr);
			System.exit(-1);
		}
		String sqoopArg;
		for (int i = 0; i < saSize; i++) {
			sqoopArg = sqoopArgs[i];
			if (sqoopArg.contains(Constants.SQOOP_FIELD_TERMINATED_REPLACE)) {
				sqoopArgs[i] = sqoopArg.replace(Constants.SQOOP_FIELD_TERMINATED_REPLACE, Constants.SQOOP_FIELD_TERMINATED);
			}
		}
		int sqoopResult = 0;
		try {
			final File file = new File(configPath);
			AuditLog.log(String.format("User:[%s], HIVE sqoop parameters: %s, sqoop params:[%s]", appUser, sqoopArgStr,
					 Arrays.toString(sqoopArgs)));
			if ("kerberos".equals(securityType)) {
				sqoopResult = (Integer) HadoopUgiUtil.doAs(file, appUser, new PrivilegedExceptionAction<Object>() {
					@Override
					public Object run() throws MalformedURLException {
						return Sqoop.runTool(sqoopArgs, HadoopSqoopConfigFactory.getHadoopConfiguration(file));
					}
				});
			} else {
				sqoopResult = (Integer) Sqoop.runTool(sqoopArgs, HadoopSqoopConfigFactory.getHadoopConfiguration(file));
			}
		} catch (Exception e) {
			AuditLog.log(e.getMessage());
			throw new PriestPlatformException(e);
		}
		if (sqoopResult != 0) {
			throw new PriestPlatformException(String.format("Database>>>Hive,Sqoop Exception[%s]", sqoopResult));
		}
	}
}
