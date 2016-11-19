package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.apache.log4j.Logger;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.ProcessPriorityEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleKey;

public class ScheduleKeyComparator implements Comparator<ScheduleKey> {
	private static Logger logger = Logger.getLogger(ScheduleKeyComparator.class);

	@Override
	public int compare(ScheduleKey o1, ScheduleKey o2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 按H,N,L顺序选择
		int res = Integer.signum(ProcessPriorityEnum.valueOf(o1.getProcessPriority()).ordinal()
				- ProcessPriorityEnum.valueOf(o2.getProcessPriority()).ordinal());

		// 相同优先级，对比schedule_time时间，选择最早调度时间的任务
		if (res == 0) {
			try {
				Date today = new Date();
				String todayStr = dateFormat.format(today);

				res = Long.signum(dateTimeFormat.parse(todayStr + " " + o1.getScheduleTime()).getTime()
						- dateTimeFormat.parse(todayStr + " " + o2.getScheduleTime()).getTime());
			} catch (ParseException e) {
				logger.error(e.getMessage(), e);
				throw new PriestPlatformException(e);
			}

			// 调度时间相同，按process id 对比
			if (res == 0) {
				res = o1.getProcessId() - o2.getProcessId();
			}
		}

		return res;
	}

}
