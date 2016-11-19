package com.lenovo.lps.farseer.priest2.platform.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.quartz.CronExpression;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleInfo;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleTypeEnum;

/**
 * quarz表达式
 * 
 * @author niexm1
 * 
 */
public final class CronExpressionUtils {
	private final static Logger logger = Logger.getLogger(CronExpressionUtils.class);
	public static final String SEPERATOR = " ";

	/**
	 * 工具类不应该被实例化使用
	 */
	private CronExpressionUtils() {
	}

	/**
	 * 根据用户指定的调度参数,构造quarz表达式
	 * 
	 * @param scheduleType
	 * @param scheduleDateStr
	 * @param scheduleTime
	 * @return
	 * @throws ParseException
	 */
	public static String buildQuarzStr(ScheduleTypeEnum scheduleType, String scheduleDateStr, String scheduleTime) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date scheduleDate = getScheduleDate(scheduleDateStr, scheduleTime, sf);

		Calendar cal = new GregorianCalendar();
		cal.setTime(scheduleDate);
		// cron表达式
		StringBuilder sb = new StringBuilder();
		switch (scheduleType) {
		// 只运行一次
		case O:
			sb.append(cal.get(Calendar.SECOND)).append(SEPERATOR).append(cal.get(Calendar.MINUTE)).append(SEPERATOR)
					.append(cal.get(Calendar.HOUR_OF_DAY)).append(SEPERATOR).append(cal.get(Calendar.DAY_OF_MONTH)).append(SEPERATOR)
					.append(cal.get(Calendar.MONTH) + 1).append(SEPERATOR).append("?").append(SEPERATOR)
					.append(cal.get(Calendar.YEAR)).toString();
			break;
		// 每分钟运行
		case I:
			break;
		// 每小时运行
		case H:
			break;
		// 每日运行
		case D:
			sb.append(cal.get(Calendar.SECOND)).append(SEPERATOR).append(cal.get(Calendar.MINUTE)).append(SEPERATOR)
					.append(cal.get(Calendar.HOUR_OF_DAY)).append(SEPERATOR).append("*").append(SEPERATOR).append("*")
					.append(SEPERATOR).append("?").toString();
			break;
		// 每周运行
		case W:
			sb.append(cal.get(Calendar.SECOND)).append(SEPERATOR).append(cal.get(Calendar.MINUTE)).append(SEPERATOR)
					.append(cal.get(Calendar.HOUR_OF_DAY)).append(SEPERATOR).append("?").append(SEPERATOR).append("*")
					.append(SEPERATOR).append(cal.get(Calendar.DAY_OF_WEEK)).toString();
			break;
		// 每月运行
		case M:
			sb.append(cal.get(Calendar.SECOND)).append(SEPERATOR).append(cal.get(Calendar.MINUTE)).append(SEPERATOR)
					.append(cal.get(Calendar.HOUR_OF_DAY)).append(SEPERATOR).append(cal.get(Calendar.DAY_OF_MONTH)).append(SEPERATOR)
					.append("*").append(SEPERATOR).append("?").toString();
			break;
		// 每季度运行
		case Q:
			// 季度月
			String[] quartMonths = new String[4];
			// 用户指定的月份
			int setMonth = cal.get(Calendar.MONTH);
			for (int i = 0; i < 4; i++) {
				quartMonths[i] = String.valueOf((setMonth + 3 * i) % 12 + 1);
			}
			Arrays.sort(quartMonths);

			sb.append(cal.get(Calendar.SECOND)).append(SEPERATOR).append(cal.get(Calendar.MINUTE)).append(SEPERATOR)
					.append(cal.get(Calendar.HOUR_OF_DAY)).append(SEPERATOR).append(cal.get(Calendar.DAY_OF_MONTH)).append(SEPERATOR)
					.append(StringUtils.join(quartMonths, ",")).append(SEPERATOR).append("?").toString();
			break;
		// 每年运行
		case Y:
			sb.append(cal.get(Calendar.SECOND)).append(SEPERATOR).append(cal.get(Calendar.MINUTE)).append(SEPERATOR)
					.append(cal.get(Calendar.HOUR_OF_DAY)).append(SEPERATOR).append(cal.get(Calendar.DAY_OF_MONTH)).append(SEPERATOR)
					.append(cal.get(Calendar.MONTH) + 1).append(SEPERATOR).append("?").append(SEPERATOR).append("*").toString();
		}

		return sb.toString();
	}

	private static Date getScheduleDate(String scheduleDateStr, String scheduleTime, SimpleDateFormat sf) {
		Date scheduleDate;
		try {
			scheduleDate = sf.parse(scheduleDateStr + " " + scheduleTime);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		return scheduleDate;
	}

	/**
	 * 根据用户指定的调试策略,计算任务下一次任务运行时间 ;
	 * 
	 * @param str
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static ScheduleInfo getNextValidTimeAfter(String str, Date date, ScheduleTypeEnum scheduleType) {
		ScheduleInfo scheduleInfo = new ScheduleInfo();

		CronExpression exp;
		try {
			exp = new CronExpression(str);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		Calendar cal = new GregorianCalendar();
		cal.setTime(date);

		// 取全天[0,24]小时调度数据，时分秒设置为0
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		// 计算自date调度之后，下次调度日期
		Date nextScheduleDate = exp.getNextValidTimeAfter(cal.getTime());

		if (nextScheduleDate != null) {
			scheduleInfo.setNextScheduleDate(nextScheduleDate);
			cal.setTime(nextScheduleDate);

			// 业务数据日期为调度日期-1,仓库计算时,今天算昨天的数据
			cal.add(Calendar.DAY_OF_MONTH, -1);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String execDate = sf.format(cal.getTime());

			scheduleInfo.setExecDate(execDate);
		}

		return scheduleInfo;
	}

	/**
	 * 根据用户指定的调试策略,计算任务下一次调度时间 ;
	 * 
	 * @param str
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static ScheduleInfo getNextSchedule(ScheduleTypeEnum scheduleType, String scheduleDate, String scheduleTime) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		if ("00:00:00".equals(scheduleTime)) {
			scheduleTime = "00:01:00";
		}

		// 根据用户指定的调度要求，创建quarz表达式
		String quarzExpression = buildQuarzStr(scheduleType, scheduleDate, scheduleTime);

		try {
			Date scheduleD = sf.parse(scheduleDate);
			Date today = new Date();

			/**
			 * <pre>
			 * 创建日期=========A区==============调度日期===========B区=====
			 * 1.流程创建时，调度时间>=创建当天
			 * 2.流程创建后，后台每天凌晨0点加载一次当天需要调度流程:
			 *   2.1当日期处于A区时(scheduleD after today)，未到触发运行日，触发日期为调度日期
			 *   2.2当日期处于B区时(scheduleD before today)，流程需要触发运行，触发日期为当天
			 *   2.3当日期与调度日期重合时，无所谓随便取一
			 * </pre>
			 */
			Date triggerDate = scheduleD.after(today) ? scheduleD : today;

			return getNextValidTimeAfter(quarzExpression, triggerDate, scheduleType);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
	}

	/**
	 * 判是否当天运行
	 * 
	 * @param nextScheduleDate
	 * @return
	 */
	public static boolean shouldRunToday(Date nextScheduleDate) {
		Date today = new Date();
		return nextScheduleDate != null && DateUtils.isSameDay(nextScheduleDate, today);
	}

}
