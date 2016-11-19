package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.service.JbpmProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.LockService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;

/**
 * 从数据库加载流程实例 到调度队列
 * 
 * @author niexm1
 * 
 */
public class ProcessInstanceFetchWork implements Runnable {
	private Logger logger = Logger.getLogger(ProcessInstanceFetchWork.class);

	private final String threadName = "fetch_process_instance_thread";

	@Autowired
	private ProcessDao processDao;

	@Autowired
	private LockService lockService;

	@Autowired
	private ScheduleService scheduleService;

	@Resource
	private JbpmProcessService jbpmProcessService;

	@Override
	public void run() {
		try {
			// 设置线程名,方便jstack等工具调试
			Thread.currentThread().setName(threadName);

			// 防止集群多台机器 重复操作，只有master机器方可调度
			boolean canSchedule = lockService.checkScheduleProcessToRun();

			if (!canSchedule) {
				logger.warn("Not master web server, can't schedule!");
				return;
			}

			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			// 当前调度日期
			Calendar currentScheduleDate = new GregorianCalendar();
			String currentScheduleDateStr = sf.format(currentScheduleDate.getTime());

			// 获取等待运行的流程
			List<ProcessEntity> waittingProcs = processDao.getProcessRun(currentScheduleDateStr, StatusEnum.W.name());

			if (CollectionUtils.isNotEmpty(waittingProcs)) {
				// 更新DB状态:任务已加载到内存排队
				processDao.batchUpdateStatus(waittingProcs, StatusEnum.Q);

				// 提交线程池执行
				for (ProcessEntity waittingProc : waittingProcs) {
					jbpmProcessService.submitJbpmProcess(waittingProc);
				}
			}
		}
		// 异常吞掉,防止throw exception suppress后继操作
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
