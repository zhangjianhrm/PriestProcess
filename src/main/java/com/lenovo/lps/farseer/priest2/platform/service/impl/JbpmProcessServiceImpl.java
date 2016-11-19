package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.io.impl.ByteArrayResource;
import org.drools.rule.builder.dialect.java.JavaDialectConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestCommThreadFactory;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.common.util.SparkKillThread;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ScheduleTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.JbpmProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.JobKillerService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.SMService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.DataTransformation;
import com.lenovo.lps.farseer.priest2.platform.util.JbpmCallLock;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

public class JbpmProcessServiceImpl implements JbpmProcessService {
	private static Logger logger = Logger.getLogger(JbpmProcessServiceImpl.class);
	
	@Autowired
	@Qualifier("notifyTaskHandler")
	private WorkItemHandler notifyTaskHandler;

	@Autowired
	@Qualifier("mySqlTaskHandler")
	private WorkItemHandler mySqlTaskHandler;

	@Autowired
	@Qualifier("oracleTaskHandler")
	private WorkItemHandler oracleTaskHandler;

	@Autowired
	@Qualifier("sparkSqlTaskHandler")
	private WorkItemHandler sparkSqlTaskHandler;

	@Autowired
	@Qualifier("sparkJarTaskHandler")
	private WorkItemHandler sparkJarTaskHandler;

	@Autowired
	@Qualifier("javaTaskHandler")
	private WorkItemHandler javaTaskHandler;

	@Autowired
	@Qualifier("shellTaskHandler")
	private WorkItemHandler shellTaskHandler;

	@Autowired
	@Qualifier("cacheTaskHandler")
	private WorkItemHandler cacheTaskHandler;

	@Autowired
	@Qualifier("depTaskHandler")
	private WorkItemHandler depTaskHandler;

	@Autowired
	@Qualifier("hdfsTaskHandler")
	private WorkItemHandler hdfsTaskHandler;

	@Autowired
	@Qualifier("hiveTaskHandler")
	private WorkItemHandler hiveTaskHandler;

	@Autowired
	@Qualifier("dataTransferHandler")
	private WorkItemHandler dataTransferHandler;

	@Autowired
	@Qualifier("mapReduceTaskHandler")
	private WorkItemHandler mapReduceTaskHandler;

	// processId_execDate==> future
	private volatile Map<String, Future<?>> runningSession = new ConcurrentHashMap<String, Future<?>>();

	// processId_execDate==> thread
	private volatile Map<String, JbpmCall> runningThreads = new ConcurrentHashMap<String, JbpmCall>();
	
	// 存储中断的流程
	public static Map<String, String> INTERRUPT_PROCESSES = new HashMap<String, String>();

	@Resource
	private ApplicationService applicationService;
	
	@Resource
	private ApplicationDao applicationDao;

	@Resource
	private ProcessService processService;

	@Resource
	private JobKillerService jobKillerService;

	// 失败告警方式N:不告警E:邮件告警S:短信告警
	private static final String ALARM_TYPE_SMS = "S";

	public static final String ALARM_TYPE_SPLIT = "\\s";

	// 多个告警对象间分隔符：邮件";",短信","
	private static final String ALARM_TARGET_CONCATE_CHAR_SMS = ",";

	@Resource
	private SMService smService;

	// 流程运行超时执行器
	ScheduledExecutorService timeOutExecutor = Executors.newScheduledThreadPool(1);
	
    private static BlockingQueue<Runnable> queueSparkKill = new LinkedBlockingQueue<Runnable>();
    
    private static ExecutorService executorSparkKill = new ThreadPoolExecutor(2, 8, 5, TimeUnit.MINUTES,
    		queueSparkKill, new PriestCommThreadFactory("killSparkJob"));

	@PostConstruct
	private void init() {
		// 设置超期检查
		timeOutExecutor.scheduleAtFixedRate(new TimeOutChecker(), 1, 15, TimeUnit.MINUTES);
	}

	/**
	 * 向线程池提交jbpm流程
	 * 
	 * @param toRunProcess
	 */
	public void submitJbpmProcess(ProcessEntity toRunProcess) {
		String key = toRunProcess.getProcessId() + "_" + toRunProcess.getExecDate();

		if (!runningSession.containsKey(key)) {
			JbpmCall jbpmCall = new JbpmCall(toRunProcess, processService);
			// 提交任务
			Future<?> future = applicationService.getExecutors().get(toRunProcess.getProcessApp()).submit(jbpmCall);
			// 记录运行线程,以备用户手工终止
			runningSession.put(key, future);

			runningThreads.put(key, jbpmCall);
		}
	}

	/**
	 * 注册组件处理类 START, END, FORK, JOIN, JUDGE, TRANSFER, HDFS, MAPREDUCE, HIVE,
	 * MYSQL, SHELL, JAVA, CACHE, KV, DEP;
	 * 
	 * @param session
	 */
	private void registerComponentHandler(StatefulKnowledgeSession session) {
		WorkItemManager workItemManager = session.getWorkItemManager();
		for (ComponentsType componentsType : ComponentsType.values()) {
			switch (componentsType) {
			case TRANSFER:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), dataTransferHandler);
				break;
			case HDFS:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), hdfsTaskHandler);
				break;
			case MAPREDUCE:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), mapReduceTaskHandler);
				break;
			case SPARKSQL:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), sparkSqlTaskHandler);
				break;
			case SPARKJAR:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), sparkJarTaskHandler);
				break;
			case HIVE:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), hiveTaskHandler);
				break;
			case MYSQL:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), mySqlTaskHandler);
				break;
			case ORACLE:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), oracleTaskHandler);
				break;
			case SHELL:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), shellTaskHandler);
				break;
			case JAVA:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), javaTaskHandler);
				break;
			case CACHE:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), cacheTaskHandler);
				break;
			case KV:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), null);
				break;
			case DEP:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), depTaskHandler);
				break;
			case NOTIFY:
				workItemManager.registerWorkItemHandler(componentsType.name().toLowerCase(), notifyTaskHandler);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void cancelRunningProcess(Integer processId, String execDate) {
		String key = processId + "_" + execDate;

		if (runningSession.containsKey(key)) {
			Future<?> future = runningSession.get(key);

			ProcessEntity process = processService.getProcessDef(String.valueOf(processId));

			BlockingQueue<Runnable> poolQueue = applicationService.getThreadPoolQueues().get(process.getProcessApp());
			// 内存排队
			if (poolQueue.contains(future)) {
				poolQueue.remove(future);
				runningSession.remove(key);
				runningThreads.remove(key);

				processService.abortProcess(processId, execDate);
			} else {
				Map<String, Object> task = processService.getTaskType(processId, execDate);
				if (task != null) {
					String taskType = StringUtil.valueOf(task.get("taskType"));
					if (ComponentsType.HIVE.name().equals(taskType) || ComponentsType.MAPREDUCE.name().equals(taskType) 
							|| ComponentsType.TRANSFER.name().equals(taskType)) {
						// ADD KILL HADOOP JOB by zdy
						this.jobKillerService.killHadoopJob(processId, execDate);
						// end for kill hadoop job
					} else if (ComponentsType.SPARKSQL.name().equals(taskType)) {
						executorSparkKill.submit(new SparkKillThread(processId, StringUtil.valueOf(task.get("taskId")), execDate));
					}
					//添加中断流程标示
					INTERRUPT_PROCESSES.put(processId + "_" + execDate, "interrupt");
				} else {
					ProcessEntity processRun = processService.getProcessRun(processId, execDate);
					if ("Q".equals(processRun.getProcessStatus())) {
						runningSession.remove(key);
						runningThreads.remove(key);

						processService.abortProcess(processId, execDate);
					}
				}
				
				
				//oldCode 2015-10-23
//				boolean mayInterruptIfRunning = true;
//				future.cancel(mayInterruptIfRunning);
			}
		}
	}

	/**
	 * 通过单独线程启动JBPM流程,方便流程终止
	 * 
	 * @author niexm1
	 * 
	 */
	class JbpmCall implements Runnable {
		private ProcessService processService;
		private ProcessEntity toRunProcess;
		private String processId;
		private String execDate;
		// 流程变量
		private Map<String, Object> processValuables;

		// 开始时间
		private Calendar startTime;
		// 结束时间
		private Calendar endTime;
		// 执行异常
		private Throwable ex;

		// 线程状态：Q 队列排队 ;R 正在执行; S 成功执行; F 失败执行
		private volatile char status;

		private String threadBakName = null;

		JbpmCall(ProcessEntity toRunProcess, ProcessService processService) {
			this.toRunProcess = toRunProcess;
			this.processId = String.valueOf(toRunProcess.getProcessId());
			this.execDate = toRunProcess.getExecDate();
			this.processService = processService;
			this.status = 'Q';

		}

		@Override
		public void run() {
			// 开始执行
			try {
				begin();
			}
			// 更新流程实例DB状态失败
			catch (Exception e) {
				failed(e);
				return;
			}

			// 防止classpath加载JDT错误(容器自身带有JDT,与JBPM使用的JDT版本不一致)　JBPM使用JDT编译Dialect表达式
			Properties properties = new Properties();
			properties.setProperty(JavaDialectConfiguration.JAVA_COMPILER_PROPERTY, "JANINO");

			PackageBuilderConfiguration pkgBuilderCfg = new PackageBuilderConfiguration(properties);
			pkgBuilderCfg.setDefaultDialect("java");

			// drools规则/流程定义 build类
			KnowledgeBuilder kbuilder = null;
			// drools规则/流程定义库
			KnowledgeBase knowledgeBase = null;
			// drools session
			StatefulKnowledgeSession session = null;

			/**
			 * JbpmProcessServiceImpl.java类 kbuilder.add(new
			 * ByteArrayResource(bpmnDef.getBytes("utf-8")),
			 * ResourceType.BPMN2);有线程安全问题 触发时会报Process has no begin/end node．
			 * workaroud:调用kbuilder.add()前须获取锁,结束后释放锁(单JVM)
			 */
			try {
				JbpmCallLock.getKnowledgeBuilderAddLock();
			} catch (InterruptedException interruptedException) {
				failed(interruptedException);
				return;
			}

			try {
				kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(pkgBuilderCfg);
				/**
				 * 一．编译Bpmn define process
				 */
				kbuilder.add(new ByteArrayResource(toRunProcess.getBpmnDef().getBytes("utf-8")), ResourceType.BPMN2);

				// 流程定义错误检查
				KnowledgeBuilderErrors processDefErrors = kbuilder.getErrors();
				Assert.isTrue(processDefErrors.isEmpty(), "process define error:"
						+ (processDefErrors.size() > 0 ? processDefErrors.iterator().next().getMessage() : ""));
			} catch (Throwable e) {
				failed(e);
				return;
			} finally {
				JbpmCallLock.releaseKnowledgeBuilderAddLock();
			}

			try {
				// 实例化drools规则/流程定义库
				knowledgeBase = kbuilder.newKnowledgeBase();
				session = knowledgeBase.newStatefulKnowledgeSession();

				/**
				 * 二．注册组件类型==>handler代码
				 */
				registerComponentHandler(session);

				// 传入流程变更
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(Constants.COMPONENTS_PARAMS_IN, processValuables);

				/**
				 * 三．启动流程
				 */
				session.startProcess(processId, params);
				// 结束执行
				finish();
			} catch (Throwable e) {
				failed(e);
				return;
			} finally {
				// 关闭session
				if (session != null) {
					session.dispose();
				}

			}

			// 流程成功运行完成,主动触发后续流程启动
			if (!ProcessTypeEnum.H.name().equals(toRunProcess.getProcessType()) || toRunProcess.getRemedyTimes() > 0) {
				List<ProcessEntity> subProcesses = processService.pushProcesses(toRunProcess);

				for (ProcessEntity subProcess : subProcesses) {
					submitJbpmProcess(subProcess);
				}
			}
		}

		// 开始运行
		private void begin() {
			this.status = 'R';
			this.startTime = new GregorianCalendar();
			// 备份老线程名
			this.threadBakName = Thread.currentThread().getName();

			// 线程池名称
			String poolName = applicationService.getAppThreadPools().get(toRunProcess.getProcessApp()).getPoolName();
			// 设置线程名,方便调试
			Thread.currentThread().setName(poolName + "-thread-" + toRunProcess.getProcessId() + "-" + toRunProcess.getExecDate());

			// 解析流程变量
			this.processValuables = DataTransformation.parseProcessVariables(toRunProcess);
			// 流程ID,执行日期传入任务/组件
			processValuables.put("processId", String.valueOf(toRunProcess.getProcessId()));
			processValuables.put("execDate", toRunProcess.getExecDate());
			processValuables.put("appName", toRunProcess.getProcessApp());

			processService.startProcess(processId, execDate, processValuables);
		}

		// 结束运行
		private void finish() {
			this.status = 'S';
			this.endTime = new GregorianCalendar();

			// 恢复线程名
			Thread.currentThread().setName(this.threadBakName);

			String key = toRunProcess.getProcessId() + "_" + toRunProcess.getExecDate();
			runningSession.remove(key);
			runningThreads.remove(key);

			// DB记录成功运行
			processService.terminateProcess(processId, execDate);
		}

		// 失败运行
		private void failed(Throwable e) {
			this.status = 'F';
			this.ex = e;
			this.endTime = new GregorianCalendar();
			// 恢复线程名
			Thread.currentThread().setName(this.threadBakName);

			String key = toRunProcess.getProcessId() + "_" + toRunProcess.getExecDate();
			runningSession.remove(key);
			runningThreads.remove(key);
			logger.error(e.getMessage(), e);

			// 用户手动中止运行
			boolean isUserKilled = checkUserManualKill(Integer.valueOf(processId), execDate, e);
			// 运行时异常
			if (!isUserKilled) {
				// DB记录流程运行失败
				processService.failedProcess(processId, execDate, org.apache.hadoop.util.StringUtils.stringifyException(e));
				/**
				 * 根据用户配置的告警方式出错告警
				 */
				String emailSubject = "Error in process running.Process ID:" + processId;

				StringBuilder sb = new StringBuilder();
				sb.append("Error in process running.Process ID:").append(processId).append(",Name:").append(toRunProcess.getProcessName()).append(",execDate:")
						.append(execDate);
				alarm(processId, emailSubject, sb.toString());
			}
			// 用户手工中止运行,吞掉异常
			else {
				// DB记录流程运行中止
				processService.abortProcess(toRunProcess.getProcessId(), execDate);
			}

		}

		public Calendar getStartTime() {
			return startTime;
		}

		public Calendar getEndTime() {
			return endTime;
		}

		public Throwable getEx() {
			return ex;
		}

		public char getStatus() {
			return status;
		}

		/**
		 * 由于JAVA不提供明确kill线程方法(只能设置线程interrupt状态,由运行线程自已检查并throw
		 * interruptexception来中止
		 * ),本方法通过判断exception是否由InterruptedException触发,来判断运行是否由用户手工中止
		 * 
		 * @param e
		 * @return
		 */
		private boolean checkUserManualKill(Integer processId, String execDate, Throwable e) {
			boolean isUserKilled = false;
			if (e instanceof InterruptedException) {
				isUserKilled = true;
			} else {
				Throwable causedEx = e;
				do {
					causedEx = causedEx.getCause();
					if (causedEx instanceof InterruptedException) {
						isUserKilled = true;
						break;
					}

				} while (causedEx != null);
			}

			return isUserKilled;
		}

	}

	private void alarm(String processId, String subject, String message) {
		try {
			ProcessEntity process = processService.getProcessDef(processId);
			Assert.notNull(process, "Can't find the process,Process ID:" + processId);

			String alarmTarget = process.getAlarmTarget();
			String[] alarmTargets = alarmTarget.split(ALARM_TYPE_SPLIT);

			// 多个联系人通过分隔符组织在一块,一块发送
			String receivers;

			// 告警
			if (ALARM_TYPE_SMS.equals(process.getAlarmType())) {
				receivers = org.apache.commons.lang.StringUtils.join(alarmTargets, ALARM_TARGET_CONCATE_CHAR_SMS);
				smService.sendMessage("processError", receivers, message);
			}
			
			String commonAlarm = "";
			try {
				commonAlarm = processService.getAlarmPhones("common");
			} catch (Exception e) {
				logger.error("get common alarm phones error:", e);
			}
			if (CommUtils.isNotNull(commonAlarm) && !ScheduleTypeEnum.O.name().equals(process.getScheduleType()) 
					&& DateUtils.getBeforeDate(1).compareTo(process.getCreatedDate()) > 0 && DateUtils.getBeforeDate(1).compareTo(process.getUpdatedDate()) > 0  ) {
				smService.sendMessage("processErrorAlarm", commonAlarm, message);
			}
			// else　不告警或者未设置 告警
		}
		// 告警出错异常吞掉,不影响正常业务运行
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean checkRunningProcess(Integer processId, String execDate) {
		return runningSession.containsKey(processId + "_" + execDate);
	}

	/**
	 * 流程过期检查,防止长时间耗线程池资源
	 * 
	 * @author niexm1
	 * 
	 */
	class TimeOutChecker implements Runnable {

		@Override
		public void run() {
			Thread.currentThread().setName("TimeOutChecker_Thread");

			try {
				for (String key : runningThreads.keySet()) {
					JbpmCall call = runningThreads.get(key);
					if (call.status == 'R') {
						// 6小时前
						Calendar hours6Before = new GregorianCalendar();
						// 往前推6小时
						hours6Before.add(Calendar.HOUR_OF_DAY, -6);

						// 已经执行6个小时,超时,取消执行
						if (call.getStartTime().before(hours6Before)) {
							runningSession.get(key).cancel(true);
						}
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}

	}
}
