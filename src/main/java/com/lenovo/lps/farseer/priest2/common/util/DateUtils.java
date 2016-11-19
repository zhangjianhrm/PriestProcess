/**
 * © 2011 Lenovo. All rights reserved
 */
package com.lenovo.lps.farseer.priest2.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

/**
 * The Class DateUtils.
 */
public final class DateUtils {

	/**
	 * The Enum PARTITION_FLAG.
	 */
	public static enum PARTITION_FLAG {

		/** The DAYOFMONTH. */
		DAYOFMONTH,
		/** The WEEKOFYEAR. */
		WEEKOFYEAR,
		/** The MONTHOFYEAR. */
		MONTHOFYEAR,
		/** The QUARTEROFYEAR. */
		QUARTEROFYEAR,
		/** The YEAR. */
		YEAR
	};

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final String DATE_DAY_FORMAT = "yyyy-MM-dd";
	
	public static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
	
	public static final String TIME_FORMAT = "HH:mm:ss(SSS)";

	/** The Constant DATE_MONTH_FORMAT. */
	private static final String DATE_MONTH_FORMAT = "yyyy-MM";

	/** The Constant DATE_YEAR_FORMAT. */
	private static final String DATE_YEAR_FORMAT = "yyyy";

	/**
	 * Instantiates a new date utils.
	 */
	private DateUtils() {
	}

	public static String getDateFormat() {
		return DATE_FORMAT;
	}

	public static String getDateDayFormat() {
		return DATE_DAY_FORMAT;
	}

	public static String getDateMonthFormat() {
		return DATE_MONTH_FORMAT;
	}

	public static String getDateYearFormat() {
		return DATE_YEAR_FORMAT;
	}

	/**
	 * 得到当前日期所在周的第一天，时间格式到dd.
	 * 
	 * @param date
	 *            the date
	 * @return the start date of week
	 * @throws ParseException
	 *             the parse exception
	 */
	public static final String getStartDateOfWeek(Date date) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_WEEK, 1 - dayOfWeek);
		return parseDate2String(c.getTime(), Constants.DATE_PATTENR);
	}

    /**
     * 预期时间戳
     * 
     * @param date
     * @return
     */
    public static long getTimeInMillis(String date, String format) {
    	
        Calendar time = Calendar.getInstance();
        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			time.setTime(dateFormat.parse(date));
		} catch (Exception e) {}
        return time.getTimeInMillis();
    }
    
	/**
	 * 得到当前日期所在周的下一周的第一天，时间格式到dd.
	 * 
	 * @param date
	 *            the date
	 * @return the end date of week
	 * @throws ParseException
	 *             the parse exception
	 */
	public static final String getEndDateOfWeek(Date date) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_WEEK, 8 - dayOfWeek);
		return parseDate2String(c.getTime(), Constants.DATE_PATTENR);
	}

	/**
	 * 得到当前日期所在周的周分区名称.
	 * 
	 * @param date
	 *            the date
	 * @return the week partiton name
	 */
	public static final String getWeekPartitonName(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append("-");
		if (weekOfYear < 10) {
			sb.append("0");
		}
		sb.append(weekOfYear);
		return sb.toString();
	}

	/**
	 * 得到当前日期所在月.
	 * 
	 * @param date
	 *            the date
	 * @return the current month
	 * @throws ParseException
	 *             the parse exception
	 */
	public static final String getCurrentMonth(Date date) throws ParseException {
		return parseDate2String(date, "yyyy-MM");
	}

	/**
	 * 得到明天的日期.
	 * 
	 * @param date
	 *            the date
	 * @return the next day
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * Gets the next date as string
	 * 
	 * @param dateAsString
	 * @return
	 * @throws ParseException
	 */
	public static String getNextDayAsString(String dateAsString) throws ParseException {
		Date date = parseString2Date(dateAsString, DATE_DAY_FORMAT);
		Date nextDate = getNextDay(date);
		return parseDate2String(nextDate, DATE_DAY_FORMAT);
	}

	/**
	 * 得到当前日期所在月的下一月.
	 * 
	 * @param date
	 *            the date
	 * @return the next month
	 * @throws ParseException
	 *             the parse exception
	 */
	public static final String getNextMonth(Date date) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		return parseDate2String(c.getTime(), "yyyy-MM");
	}

	/**
	 * 得到当前日期所在的季度的第一天.
	 * 
	 * @param date
	 *            the date
	 * @return the start date of quarter
	 */
	public static final String getStartDateOfQuarter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int remain = (c.get(Calendar.MONTH) + 1) % 3;
		int tmp = (c.get(Calendar.MONTH) + 1) / 3;
		int startMonthOfQuarter = remain == 0 ? (tmp - 1) * 3 + 1 : tmp * 3 + 1;
		return CommUtils.getDateByYearAndMonth(year, startMonthOfQuarter);
	}

	/**
	 * 得到当前日期所在的季度的下一季度.
	 * 
	 * @param date
	 *            the date
	 * @return the end date of quarter
	 */
	public static final String getEndDateOfQuarter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int remain = (c.get(Calendar.MONTH) + 1) % 3;
		int tmp = (c.get(Calendar.MONTH) + 1) / 3;
		int endMonthOfQuarter = remain == 0 ? tmp * 3 + 1 : (tmp + 1) * 3 + 1;
		return CommUtils.getDateByYearAndMonth(year, endMonthOfQuarter);
	}

	/**
	 * 得到当前日期所在的季度的季度分区名.
	 * 
	 * @param date
	 *            the date
	 * @return the quarter partiton name
	 */
	public static final String getQuarterPartitonName(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int remain = (c.get(Calendar.MONTH) + 1) % 3;
		int tmp = (c.get(Calendar.MONTH) + 1) / 3;
		int quarter = remain == 0 ? tmp : tmp + 1;
		return new StringBuilder().append(year).append("-").append(quarter).toString();
	}

	/**
	 * 得到年.
	 * 
	 * @param date
	 *            the date
	 * @return the year
	 */
	public static final int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 将某个时间转换成毫秒.
	 * 
	 * @param time
	 *            the time
	 * @return the long
	 * @throws ParseException
	 *             the parse exception
	 */
	public static long parseStringToLong(String time) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT).parse(time).getTime();
	}
	
	/**
	 * 将某个时间转换成yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 *            the time
	 * @return yyyy-MM-dd HH:mm:ss time
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String parseStrToStr(String time) {
		String result = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
			result = format.format(format.parse(time));
		} catch (Exception e) {
			AuditLog.log(time + "parseStrToStr error.");
		}
		return result;
	}

	/**
	 * Parses the string2 date.
	 * 
	 * @param time
	 *            the time
	 * @param format
	 *            the format
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date parseString2Date(String time, String format) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.parse(time);
	}

	/**
	 * Parses the date2 string.
	 * 
	 * @param time
	 *            the time
	 * @param format
	 *            the format
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String parseDate2String(Date time, String format) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(time);
	}
	
	/**
	 * Parses the date to time string.
	 * 
	 * @param time
	 *            the time
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String parseDate2Time(Date time) {
		SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT);
		return df.format(time);
	}

	/**
	 * 将毫秒转换成相应格式的时间字符串.
	 * 
	 * @param time
	 *            the time
	 * @param format
	 *            :比如 "yyyy-MM-dd HH:mm:ss"
	 * @return the string
	 */
	public static String parseLongToDate(long time, String format) {
		Date dNow = new Date(time);
		SimpleDateFormat myFormatter = new SimpleDateFormat(format);
		return myFormatter.format(dNow);
	}

	/**
	 * 比较两个日期的先后.
	 * 
	 * @param firstDate
	 *            the first date
	 * @param secDate
	 *            the sec date
	 * @param format
	 *            :比如 "yyyy-MM-dd"
	 * @return -1：小于 0：等于 1：大于
	 * @throws ParseException
	 *             the parse exception
	 */
	public static int timeCompare(String firstDate, String secDate, String format) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return (df.parse(firstDate)).compareTo(df.parse(secDate));
	}

	/**
	 * Gets the now.
	 * 
	 * @return the now
	 */
	public static String getNow() {
		Date dNow = new Date();
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATE_FORMAT);
		return myFormatter.format(dNow);
	}

	/**
	 * get the day of this time
	 * 
	 * @return
	 */
	public static String getDayNow() {
		Date dNow = new Date();
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATE_DAY_FORMAT);
		return myFormatter.format(dNow);
	}

	public static String getTimeNow() {
		String now = getNow();
		String dayNow = getDayNow();
		return StringUtils.remove(now, dayNow).trim();
	}

	/**
	 * Gets the before date.
	 * 
	 * @param days
	 *            the days
	 * @return the before date
	 */
	public static String getBeforeDate(int days) {
		Date dNow = new Date();
		return getBeforeDate(dNow, days);
	}

	/**
	 * Gets the before date.
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            the days
	 * @return the before date
	 */
	public static String getBeforeDate(Date date, int days) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - days);
		return df.format(calendar.getTime());
	}

	/**
	 * Gets the after date.
	 * 
	 * @param days
	 *            the days
	 * @return the after date
	 */
	public static String getAfterDate(int days) {
		Date dNow = new Date();
		return getAfterDate(dNow, days);
	}

	/**
	 * Gets the after date.
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            the days
	 * @return the after date
	 */
	public static String getAfterDate(Date date, int days) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + days);
		return df.format(calendar.getTime());
	}

	/**
	 * Get the execute date from schedule date
	 * 
	 * @param scheduleDateAsString
	 * @return
	 * @throws ParseException
	 */
	public static String getExecDateFromScheduleDate(String scheduleDateAsString) throws ParseException {
		Date scheduleDate = DateUtils.parseString2Date(scheduleDateAsString, DateUtils.getDateDayFormat());
		Calendar cal = Calendar.getInstance();
		cal.setTime(scheduleDate);
		cal.add(Calendar.DATE, -1);
		return DateUtils.parseDate2String(cal.getTime(), DateUtils.getDateDayFormat());
	}

	/**
	 * 判断日期格式是否合法 形如：2011-07-06.
	 * 
	 * @param date
	 *            the date
	 * @return true, if successful
	 */
	public static boolean regexDate(String date) {
		String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-"
				+ "(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-"
				+ "(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|"
				+ "((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		return date.matches(regex);
	}

	/**
	 * Gets the partition by flag.
	 * 
	 * @param date
	 *            the date
	 * @param flag
	 *            the flag
	 * @return the partition by flag
	 */
	public static String getPartitionByFlag(Date date, PARTITION_FLAG flag) {
		Map<PARTITION_FLAG, String> maps;
		try {
			maps = getPartitionMappings(date);
			if (maps.containsKey(flag)) {
				return maps.get(flag);
			} else {
				return null;
			}
		} catch (ParseException e) {
			throw new PriestPlatformException(e);
		}

	}

	/**
	 * Gets the partition mappings.
	 * 
	 * @param date
	 *            the date
	 * @return the partition mappings
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Map<PARTITION_FLAG, String> getPartitionMappings(Date date) throws ParseException {
		Map<PARTITION_FLAG, String> partitionMaps = new HashMap<PARTITION_FLAG, String>();
		partitionMaps.put(PARTITION_FLAG.DAYOFMONTH, parseDate2String(date, Constants.DATE_PATTENR));
		partitionMaps.put(PARTITION_FLAG.WEEKOFYEAR, getWeekPartitonName(date));
		partitionMaps.put(PARTITION_FLAG.MONTHOFYEAR, parseDate2String(date, DateUtils.DATE_MONTH_FORMAT));
		partitionMaps.put(PARTITION_FLAG.QUARTEROFYEAR, getQuarterPartitonName(date));
		partitionMaps.put(PARTITION_FLAG.YEAR, parseDate2String(date, DateUtils.DATE_YEAR_FORMAT));
		return partitionMaps;
	}

	/**
	 * Gets the list of date as string between start date and end date given
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getDateAsStringList(String startDate, String endDate) throws ParseException {
		List<String> dateList = new LinkedList<String>();
		
		Calendar cal = Calendar.getInstance();
		Date startDateOfData = DateUtils.parseString2Date(startDate, getDateDayFormat());
		Date endDateOfData = DateUtils.parseString2Date(endDate, getDateDayFormat());
		cal.setTime(startDateOfData);
		for (cal.setTime(startDateOfData); !cal.getTime().after(endDateOfData);) {
			Date executeDate = cal.getTime();
			String execDate = parseDate2String(executeDate, getDateDayFormat());
			dateList.add(execDate);
			cal.add(Calendar.DATE, 1);
		}
		return dateList;
	}
	
	public static String getBeforeDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		String result = "";
		try {
			result = parseDate2String(calendar.getTime(),DATE_DAY_FORMAT);
		} catch (ParseException e) {
		}
		return result;
	}
}
