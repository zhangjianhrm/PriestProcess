package com.lenovo.lps.farseer.priest2.platform.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.platform.components.WorkSession;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;


public final class StringUtil {
	private static final Logger LOG = Logger.getLogger(StringUtil.class);
	public static final long ONE_KB = 1024;
    public static final long ONE_MB = ONE_KB * ONE_KB;
    public static final long ONE_GB = ONE_KB * ONE_MB;
    public static final long ONE_TB = ONE_KB * ONE_GB;
    public static final long ONE_PB = ONE_KB * ONE_TB;
	public static final DecimalFormat format2num = new DecimalFormat("0.##");
	private static final Pattern urlPattern= Pattern.compile("^http[s]?://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$",Pattern.CASE_INSENSITIVE );
	private static final Pattern timePattern= Pattern.compile("^(?:[01]?\\d|2[0-3]):[0-5]\\d$");
	private static final Pattern phoneP = Pattern.compile("1[3-8]\\d{9}");
	
	/**
	 * 工具类不应该被实例化使用
	 */
	private StringUtil(){}

	public static String getRealFileName(String uploadedFileName) {
		String realFileName = StringUtils.substringAfter(uploadedFileName, "_");
		realFileName = StringUtils.substringAfter(realFileName, "_");
		return realFileName;
	}

	public static String generateNewFileName(String realFileName) {
		return System.currentTimeMillis() + "_" + new Random().nextInt(9999) + "_" + realFileName;
	}
	
	public static String convertBytesToDisplaySize(long obj) {
		String displaySize = null;
		long size = obj;
		if (size < 0) {
			size = -size;
		}

		if (size / ONE_PB > 0) {
			displaySize = String.valueOf(size / ONE_PB) + " PB";
		} else if (size / ONE_TB > 0) {
			displaySize = String.valueOf(size / ONE_TB) + " TB";
		} else if (size / ONE_GB > 0) {
			displaySize = String.valueOf(size / ONE_GB) + " GB";
		} else if (size / ONE_MB > 0) {
			displaySize = String.valueOf(size / ONE_MB) + " MB";
		} else if (size / ONE_KB > 0) {
			displaySize = String.valueOf(size / ONE_KB) + " KB";
		} else {
			displaySize = String.valueOf(size) + " bytes";
		}
		if (obj < 0) {
			displaySize = "-" + displaySize;
		}
		return displaySize;
	}
	
	/**
	 * 检验空字符串
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isEmpty(String toValidate) {
		return toValidate == null || toValidate.trim().length() == 0;
	}
	
	/**
	 * 检验空字符串
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isNotEmpty(String toValidate) {
		return !isEmpty(toValidate);
	}
	
	
	/**
	 * 检验Integer是否大于0
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isValidate(Integer toValidate) {
		return toValidate != null && toValidate > 0;
	}
	
	/**
	 * 解析数字字符串
	 * 
	 * @param num
	 * @return
	 */
	public static int parseInt(Object numObj) {
		int result = 0;
		try {
			String num = String.valueOf(numObj);
			if (isNotEmpty(num)) {
				result = Integer.parseInt(num);
			}
		} catch (Exception e) {
			LOG.error(String.format("Parse[%s] to int error:", numObj), e);
		}
		return result;
	}
	
	/**
	 * 解析数字字符串
	 * 
	 * @param num
	 * @return
	 */
	public static long parseLong(Object numObj) {
		long result = 0;
		try {
			String num = String.valueOf(numObj);
			if (isNotEmpty(num)) {
				result = Long.parseLong(num);
			}
		} catch (Exception e) {
			LOG.error(String.format("Parse[%s] to int error:", numObj), e);
		}
		return result;
	}
	
	/**
	 * 解析数字字符串
	 * 
	 * @param num
	 * @return
	 */
	public static long parseLongWithErr(Object numObj) {
		long result = 0;
		try {
			String num = String.valueOf(numObj);
			if (isNotEmpty(num)) {
				result = Long.parseLong(num);
			}
		} catch (Exception e) {
			LOG.error(String.format("Parse[%s] to int error:", numObj), e);
			throw new RuntimeException(String.format("parse trigger value [%s] error:%s",numObj,  e.getMessage()));
		}
		return result;
	}
	
	
	/**
	 * 解析字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String valueOf(Object obj) {
		String result = "";
		try {
			result = String.valueOf(obj);
		} catch (Exception e) {}
		return result;
	}
	
	/**
	 * 判断手机号
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String phoneNum){
		Matcher m = phoneP.matcher(phoneNum);
		return m.matches();
	}
	
	public static String quoteAndEscape(String source, char quoteChar, String escapeStr) {
		if (source == null) {
			return null;
		}

		return escape(source, new char[]{ quoteChar }, escapeStr);

	}

	public static String escape(String source, final char[] escapedChars, String escapeStr) {
		if (source == null) {
			return null;
		}

		char[] eqc = new char[escapedChars.length];
		System.arraycopy(escapedChars, 0, eqc, 0, escapedChars.length);
		Arrays.sort(eqc);

		StringBuffer buffer = new StringBuffer(source.length());

		for (int i = 0; i < source.length(); i++) {
			final char c = source.charAt(i);
			int result = Arrays.binarySearch(eqc, c);

			if (result > -1) {
				buffer.append(escapeStr);
			}

			buffer.append(c);
		}

		return buffer.toString();
	}
	
	public static String makeRuntimeInfoQuery() {
		String setruntimeinfo = "set "+ Constants.PRIEST_PARAMS_WHOLE+"=" ;
		setruntimeinfo += WorkSession.get().getRuntimeInfoJson();
		return setruntimeinfo ;
	}
	
	public static String getStatusDetail(String status) {
		StatusEnum processStatus = StatusEnum.valueOf(isEmpty(status) ? "W":status);
		switch (processStatus) {
		// 内存排队:浅蓝
		case Q:
			status = "Queuing";
			break;
		// 正在执行:黄色
		case R:
			status = "Running";
			break;
		// 失败,取消执行：红色
		case F:
			status = "Failed";
			break;
		case C:
			status = "Cancel";
			break;
		// 成功：绿色
		case S:
			status = "Successful";
			break;
		// 暂缓：粉色
		case H:
			status = "Paused";
			break;
		// 界面矩形默认填充颜色
		default:
			status = "Waiting";
			break;
		}
		return status ;
	}
	public static boolean checkUrl(String url) {
		Matcher m = urlPattern.matcher(url);
		return !m.matches();
	}
	public static boolean checkTime(String time) {
		Matcher m = timePattern.matcher(time);
		return !m.matches();
	}
	public static String lowerStr(String str) {
		String result = str;
		try {
			result = StringUtils.lowerCase(str);
		} catch (Exception e) {}
		return result;
	}
	
	/**
	 * 正则替换'**;**' "**;**" 中的;号
	 * 
	 * @param sql
	 * @return
	 */
	public static String replaceSemicolon(String sql) {
		Pattern sqlPatt = Pattern.compile("['\"]{1}[^'\"\\s]*;[^'\"\\s]*['\"]{1}", Pattern.CASE_INSENSITIVE);
		Matcher sqlM = sqlPatt.matcher(sql);
		if (sqlM.find()) {
			sqlM.reset();
			StringBuffer sqlSb = new StringBuffer("");
			while(sqlM.find()) {
				sqlM.appendReplacement(sqlSb, sqlM.group().replaceAll(";", "oxxooxxo"));
			}
			sqlM.appendTail(sqlSb);
			sql = sqlSb.toString();
		}
		return sql;
	}
	
	/**
	 * 正则替换'**oxxooxxo**' "**oxxooxxo**" 中的oxxooxxo替换回;号
	 * 
	 * @param sql
	 * @return
	 */
	public static String replace2Semicolon(String hiveSql) {
		Pattern hiveSqlPatt = Pattern.compile("['\"]{1}[^'\"\\s]*oxxooxxo[^'\"\\s]*['\"]{1}", Pattern.CASE_INSENSITIVE);
		Matcher hiveSqlM = hiveSqlPatt.matcher(hiveSql);
		if (hiveSqlM.find()) {
			hiveSqlM.reset();
			StringBuffer hiveSqlSb = new StringBuffer("");
			while(hiveSqlM.find()) {
				hiveSqlM.appendReplacement(hiveSqlSb, hiveSqlM.group().replaceAll("oxxooxxo", ";"));
			}
			hiveSqlM.appendTail(hiveSqlSb);
			hiveSql = hiveSqlSb.toString().trim();
		}
		return hiveSql;
	}
}
