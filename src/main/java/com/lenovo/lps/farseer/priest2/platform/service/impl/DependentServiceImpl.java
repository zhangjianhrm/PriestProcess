package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.ClasspathLoader;
import com.lenovo.lps.farseer.priest2.common.util.MyURLClassLoader;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatParam;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.service.DependentService;
import com.lenovo.lps.farseer.priest2.platform.service.HdfsService;
import com.lenovo.lps.farseer.priest2.platform.service.MySQLService;
import com.lenovo.lps.farseer.priest2.platform.service.OracleService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class DependentServiceImpl implements DependentService {
	private static final String EXEC_DATE_LITERAL = ", Execute Date:";
	
	// 5秒sleep
	private static final long SLEEP_TIME = 5000;
	// 8小时过期
	private static final long WAIT_TIMEOUT = 8 * 60 * 60 * 1000;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
	private TaskService taskService;
	
	@Resource
	private MySQLService mysqlService;
	
	@Resource
	private HdfsService hdfsService;
	
	@Resource
	private OracleService oracleService;

	@Override
	public void waitTask(Integer taskId, String execDate) throws InterruptedException {
		TaskEntity task = taskService.getTaskRun(taskId, execDate);

		Assert.notNull(task, "Can't find the task, Task ID:" + taskId + EXEC_DATE_LITERAL + execDate);

		StatusEnum taskStatus = StatusEnum.valueOf(task.getTaskStatus().toUpperCase());

		// 开始时间
		long waitBeginTime = System.currentTimeMillis();

		while (true) {
			switch (taskStatus) {
			// 成功退出
			case S:
				return;
				// 被依赖流程处于失败,取消,内存排队,正在执行状态时,本流程等待其执行完成 ,等待上限 :8小时
			case F:
			case C:
			case Q:
			case R:
				// 8小时超时检查
				if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
					throw new PriestPlatformException("Dependency process timeout,Dependency Process ID:" + taskId + EXEC_DATE_LITERAL + execDate);
				}

				Thread.sleep(SLEEP_TIME);
				break;
			// 被依赖流程尚未被调度时,本流程无限制时间等待
			case W:
				Thread.sleep(SLEEP_TIME);
				break;
			default:
				throw new PriestPlatformException("Unknown Process Status,Process ID:" + taskId + " Execute Date:" + execDate + " Status:" + taskStatus);
			}

			task = taskService.getTaskRun(taskId, execDate);
			taskStatus = StatusEnum.valueOf(task.getTaskStatus().toUpperCase());

		}
	}

	@Override
	public void waitProcess(Integer processId, String execDate, String interrupteKey) throws InterruptedException {
		ProcessEntity process = processService.getProcessRun(processId, execDate);
		Assert.notNull(process, "Can't find the process,Process ID:" + processId + EXEC_DATE_LITERAL + execDate);

		StatusEnum processStatus = StatusEnum.valueOf(process.getProcessStatus().toUpperCase());

		// 开始时间
		long waitBeginTime = System.currentTimeMillis();

		while (true) {
			switch (processStatus) {
			// 成功退出
			case S:
				return;
				// 被依赖流程处于失败,取消,内存排队,正在执行状态时,本流程等待其执行完成 ,等待上限: 8小时
			case F:
			case C:
			case Q:
			case R:
				// 8小时超时检查
				if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
					throw new PriestPlatformException("Dependency process timeout,Dependency Process ID:" + processId + EXEC_DATE_LITERAL + execDate);
				}
				
				// 用户手动中止流程运行
				if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
					JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
					throw new InterruptedException();
				}
				Thread.sleep(SLEEP_TIME);
				break;
			// 被依赖流程尚未被调度时,本流程无限制时间等待
			case W:
				// 用户手动中止流程运行
				if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
					JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
					throw new InterruptedException();
				}
				Thread.sleep(SLEEP_TIME);
				break;
			default:
				throw new PriestPlatformException("Unknown Process Status,Process ID:" + processId + " Execute Date:" + execDate + " Status:" + processStatus);
			}

			process = processService.getProcessRun(processId, execDate);
			processStatus = StatusEnum.valueOf(process.getProcessStatus().toUpperCase());
		}
	}

	@Override
	public void waitHdfsDir(String targetPath, String interrupteKey) throws InterruptedException {
		// 开始时间
		long waitBeginTime = System.currentTimeMillis();
		while (true) {
			// 8小时超时检查
			if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
				throw new PriestPlatformException("Dependency process timeout,Dependency Hdfs File exists:" + targetPath);
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("path", targetPath);
			if (hdfsService.fileExists(targetPath)) {
				break;
			}
			// 用户手动中止流程运行
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				throw new InterruptedException();
			}
			Thread.sleep(SLEEP_TIME);
		}
	}

	@Override
	public void waitHdfsSize(String targetPath, String targetNum, String interrupteKey) throws InterruptedException {
		// 开始时间
		long waitBeginTime = System.currentTimeMillis();
		while (true) {
			// 8小时超时检查
			if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
				throw new PriestPlatformException("Dependency process timeout,Dependency Hdfs Size:" + targetPath + "targetNum:" + targetNum);
			}
			long least = StringUtil.parseLongWithErr(targetNum);
			if (hdfsService.getFileSize(targetPath) >= least) {
				break;
			}
			// 用户手动中止流程运行
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				throw new InterruptedException();
			}
			Thread.sleep(SLEEP_TIME);
		}
	}
	

	@Override
	public void waitMysqlNum(String sql, String targetNum, DbEntity entity, String interrupteKey)
			throws InterruptedException, SQLException {
		// 开始时间
		long waitBeginTime = System.currentTimeMillis();
		while (true) {
			// 8小时超时检查
			if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
				throw new PriestPlatformException(
						String.format("Dependency process timeout,Dependency MysqlNum sql[%s] targetNum[%s] entity[%s]。",
								sql, targetNum, entity));
			}
			long least = StringUtil.parseLongWithErr(targetNum);
			Object value = mysqlService.runSql(checkSql(sql), entity.getUserName(), entity.getPassword(), entity.getUrl(), entity.getDriverClassName());
			if (value instanceof List) {
				/**
				 * 只有一个结果：e.g　select count(*) from a，结果从List<Map>抽出
				 */
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> tmp = (List<Map<String, Object>>) value;
				if (tmp.size() == 1) {
					Object v = tmp.get(0).values().iterator().next();
					if (v instanceof String || v instanceof Number || v instanceof Date) {
						value = v;
					}
				}
			}
			
			if (StringUtil.parseLong(value) >= least) {
				break;
			}
			// 用户手动中止流程运行
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				throw new InterruptedException();
			}
			Thread.sleep(SLEEP_TIME);
		}
	}
	
	/**
	 * sql去掉末尾;
	 * 
	 * @param sql
	 * @return
	 */
	private String checkSql(String sql) {
		sql = sql.trim();
		try {
			if (sql.endsWith(";")) {
				sql = sql.substring(0, sql.length() -1);
			}
		} catch (Exception e) {}
		return sql;
	}

	@Override
	public void waitOracleNum(String sql, String targetNum, DbEntity entity, String interrupteKey)
			throws InterruptedException, SQLException {
		// 开始时间
		long waitBeginTime = System.currentTimeMillis();
		while (true) {
			// 8小时超时检查
			if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
				throw new PriestPlatformException(
						String.format("Dependency process timeout,Dependency OracleNum sql[%s] targetNum[%s] entity[%s]。",
								sql, targetNum, entity));
			}
			long least = StringUtil.parseLongWithErr(targetNum);
			Object value = oracleService.executeSql(checkSql(sql), entity);
			if (value instanceof List) {
				/**
				 * 只有一个结果：e.g　select count(*) from a，结果从List<Map>抽出
				 */
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> tmp = (List<Map<String, Object>>) value;
				if (tmp.size() == 1) {
					Object v = tmp.get(0).values().iterator().next();
					if (v instanceof String || v instanceof Number || v instanceof Date) {
						value = v;
					}
				}
			}
			
			if (StringUtil.parseLong(value) >= least) {
				break;
			}
			// 用户手动中止流程运行
			if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
				JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
				throw new InterruptedException();
			}
			Thread.sleep(SLEEP_TIME);
		}
	}

	@Override
	public void waitSparkNum(String sql, String targetNum, StatParam statParam, String interrupteKey) {
		// 开始时间
		try {
			long waitBeginTime = System.currentTimeMillis();
			while (true) {
				// 8小时超时检查
				if ((System.currentTimeMillis() - waitBeginTime) > WAIT_TIMEOUT) {
					throw new PriestPlatformException(
							String.format("Dependency process timeout,Dependency HiveNum sql[%s] targetNum[%s] statParam[%s]。",
									sql, targetNum, statParam));
				}
				long least = StringUtil.parseLongWithErr(targetNum);
				MyURLClassLoader cl = ClasspathLoader.loadDircClasspath("hive");
				Class<?> sparkDaoCla = cl.loadClass("com.lenovo.lps.farseer.priest2.ext.SparkExecDao");
				Object sparkDao = sparkDaoCla.newInstance();
				Object value = sparkDaoCla.getMethod("sparkExecute", 
						new Class<?>[]{String.class, StatParam.class}).invoke(sparkDao, sql, statParam);
				if (StringUtil.parseLong(value) >= least) {
					break;
				}
				// 用户手动中止流程运行
				if (JbpmProcessServiceImpl.INTERRUPT_PROCESSES.containsKey(interrupteKey)) {
					JbpmProcessServiceImpl.INTERRUPT_PROCESSES.remove(interrupteKey);
					throw new InterruptedException();
				}
				Thread.sleep(SLEEP_TIME);
			}
		} catch (Exception e) {
			throw new RuntimeException("wait spark num error", e);
		}
	}

}
