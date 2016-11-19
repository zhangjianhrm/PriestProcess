package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.CacheClient;
import com.lenovo.lps.farseer.priest2.platform.service.JobKillerService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;

public class JobKillerServiceImpl implements JobKillerService {
	private static Logger logger = Logger.getLogger(JobKillerServiceImpl.class);

	private static final String DEFAULT_SHELL_PATH = "/var/lib/priest/scripts/kill.sh";
	private static final String DEFAULT_MAPRED_COMMAND_PATH = "/usr/bin/mapred";
	private static final String TASK_TYPE_MAPR = "mapr";

	private static final String ARGS_CONNECTOR = " ";
	private static final String MAPRED_COMMAND_PATH = "mapred.bin.path";
	private static final String SHELL_PATH = "kill.job.path";

	@Autowired
	private ShellService shellService;
	@Resource
	private CacheClient cacheClient;
	@Resource
	private ProcessService processService;

	@Override
	public void killJob(Set<String> jobIds) {
		if (null == jobIds || jobIds.isEmpty()) {
			logger.warn("No hadoop job collected !");
			return;
		}
		StringBuffer commonArgs = new StringBuffer();
		commonArgs
				.append(TASK_TYPE_MAPR)
				.append(ARGS_CONNECTOR)
				.append(ConfigUtil.getContextProperty(MAPRED_COMMAND_PATH,
						DEFAULT_MAPRED_COMMAND_PATH)).append(ARGS_CONNECTOR);
		for (String jobId : jobIds) {
			try {
				StringBuffer fullArgs = new StringBuffer();
				String ret = this.shellService.runCommand(ConfigUtil
						.getContextProperty(SHELL_PATH, DEFAULT_SHELL_PATH),
						fullArgs.append(commonArgs).append(jobId).toString());
				logger.warn("Execute shell command ret: " + ret);
			} catch (IOException e) {
				logger.error(jobIds, e);
			} catch (InterruptedException e) {
				logger.error(jobIds, e);
			}
		}
	}

	@Override
	public void killHadoopJob(Integer processId, String execDate) {
		new KillerExecutor(processId, execDate).start();
	}

	private boolean isRunning(String status) {
		return status.equalsIgnoreCase("R");
	}

	class KillerExecutor extends Thread {

		private Integer processId;
		private String execDate;

		public KillerExecutor(Integer proccessId, String execDate) {
			this.processId = proccessId;
			this.execDate = execDate;
		}

		@Override
		public void run() {
			String key = new StringBuffer().append(processId).append("_")
					.append(execDate).toString();
			try {
				Set<String> jobIds = cacheClient.getRunningHadoopJobs(
						processId, execDate);
				if (null == jobIds || jobIds.isEmpty()) {
					logger.warn("No running hadoop job find in redis :" + key);
					ProcessEntity record = processService.getProcessRun(
							processId, execDate);

					if (!isRunning(record.getProcessStatus())) {
						return;
					}

					// 重试3次， 需要注意process重启情况
					int tryTimes = 3;
					for (int i = 0; i < tryTimes; i++) {
						logger.warn("But process is running, will sleep and try: "
								+ key);
						Thread.sleep(1000 * 30);
						ProcessEntity record2 = processService.getProcessRun(
								processId, execDate);
						if (!record2.getStartTime().equals(
								record.getStartTime())) {
							logger.warn("Maybe process has restarted, will interrupt killing action, "
									+ key
									+ ", "
									+ record.getStartTime()
									+ ", "
									+ record2.getStartTime());
							return;
						}
						jobIds = cacheClient.getRunningHadoopJobs(processId,
								execDate);
						if (null != jobIds && !jobIds.isEmpty()
								&& isRunning(record2.getProcessStatus())) {
							killJob(jobIds);
							break;
						}
					}
				}
				if(null != jobIds && !jobIds.isEmpty()) {
					killJob(jobIds);
				}
			} catch (Exception e) {
				logger.error(key, e);
			}
		}
	}

}
