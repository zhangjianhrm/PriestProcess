/**
 * © 2011 Lenovo. All rights reserved
 */
package com.lenovo.lps.farseer.priest2.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * The Class CommUtils.
 */
public final class CommUtils {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(CommUtils.class);

	/**
	 * Instantiates a new comm utils.
	 */
	private CommUtils() {
	}

	/**
	 * Gets the date by year and month.
	 *
	 * @param year the year
	 * @param month the month
	 * @return the date by year and month
	 */
	public static String getDateByYearAndMonth(int year, int month) {
		StringBuilder sb = new StringBuilder().append(year).append("-");
		if (month < 10) {
			sb.append("0").append(month);
		} else {
			sb.append(month);
		}
		return sb.toString();
	}
	
	/**
	 * Convert date2 string.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String convertDate2String(Date date) {
		return new SimpleDateFormat(Constants.DATE_PATTENR).format(date);
	}

	/**
	 * Convert string2 date.
	 *
	 * @param str the str
	 * @return the date
	 */
	public static Date convertString2Date(String str) {
		try {
			return new SimpleDateFormat(Constants.DATE_PATTENR).parse(str);
		} catch (ParseException e) {
			LOGGER.error("convert to date exception", e);
		}
		return null;
	}

	/**
	 * Compare date besed on day.
	 *
	 * @param date the date
	 * @param anotherDate the another date
	 * @return the int
	 */
	public static int compareDateBesedOnDay(Date date, Date anotherDate) {
		if (date == null) {
			return -1;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Calendar anotherCalendar = Calendar.getInstance();
		anotherCalendar.setTime(anotherDate);
		if (calendar.get(Calendar.YEAR) != anotherCalendar.get(Calendar.YEAR)) {
			return calendar.get(Calendar.YEAR) - anotherCalendar.get(Calendar.YEAR);
		}
		if (calendar.get(Calendar.MONTH) != anotherCalendar.get(Calendar.MONTH)) {
			return calendar.get(Calendar.MONTH) - anotherCalendar.get(Calendar.MONTH);
		}
		if (calendar.get(Calendar.DAY_OF_YEAR) != anotherCalendar.get(Calendar.DAY_OF_YEAR)) {
			return calendar.get(Calendar.DAY_OF_YEAR) - anotherCalendar.get(Calendar.DAY_OF_YEAR);
		}
		return 0;
	}

	/**
	 * Gets the stack trace.
	 *
	 * @param throwable the throwable
	 * @return the stack trace
	 */
	public static String getStackTrace(Throwable throwable) {
		if (throwable == null) {
			return null;
		}
		StackTraceElement[] stackTraceElements = throwable.getStackTrace();
		StringBuilder sb = new StringBuilder();
		sb.append(throwable.getClass().getName()).append(": ").append(throwable.getMessage());
		sb.append("\n");
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			sb.append("\tat ");
			sb.append(stackTraceElement.getClassName());
			sb.append(":");
			sb.append(stackTraceElement.getLineNumber());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * 检验空字符串
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isEmpty(String toValidate) {
		if (toValidate == null || toValidate.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检验空字符串
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isNull(String toValidate) {
		if (toValidate == null || toValidate.trim().length() == 0 
				|| "null".equals(toValidate.trim()) || "Null".equals(toValidate.trim()) || "NULL".equals(toValidate.trim())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 解析数字
	 * 
	 * @param intStr
	 * @return
	 */
	public static int parseInt(String intStr) {
		int result = 0;
		try {
			result = Integer.parseInt(intStr);
		} catch(Exception e) {}
		return result;
	}
	
	/**
	 * 检验非空字符串
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isNotEmpty(String toValidate) {
		return !isEmpty(toValidate);
	}
	
	/**
	 * 检验非空字符串
	 * 
	 * @param toValidate
	 * @return
	 */
	public static boolean isNotNull(String toValidate) {
		return !isNull(toValidate);
	}
}
