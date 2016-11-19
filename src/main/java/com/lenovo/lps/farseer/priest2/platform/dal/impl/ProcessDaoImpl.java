package com.lenovo.lps.farseer.priest2.platform.dal.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.dal.ProcessDao;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.mapper.ApplicationMapper;
import com.lenovo.lps.farseer.priest2.platform.mapper.ProcessMapper;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.DataTransformation;

public class ProcessDaoImpl implements ProcessDao {
	private final Logger logger = Logger.getLogger(ProcessDaoImpl.class);
	@Autowired
	@Qualifier("processMapper")
	private ProcessMapper processMapper;

	@Autowired
	private ApplicationMapper applicationMapper;

	@Autowired
	private JdbcTemplate jobMySqlJdbcTemplate;

	private final String updateSql = "update P_PROCESS_RUN set process_status= ?,start_time=null,end_time=null,run_time=null,message=null where process_id = ? and exec_date=STR_TO_DATE(?, '%Y-%m-%d')";

	private final String failSql = "update P_PROCESS_RUN set process_status= 'F',end_time=now(),message=? where process_id = ? and exec_date=STR_TO_DATE(?, '%Y-%m-%d')";

	@Override
	public void insertProcess(ProcessEntity process) {
		processMapper.insertProcess(process);
	}

	@Override
	public List<ProcessEntity> searchProcessDef(ProcessEntity requestParam) {
		return processMapper.searchProcessDef(requestParam);
	}

	@Override
	public List<ProcessEntity> searchProcessDefByModifyDate(ProcessEntity requestParam) {
		return processMapper.searchProcessDefByModifyDate(requestParam);
	}

	@Override
	public Long searchProcessDefCount(ProcessEntity requestParam) {
		return processMapper.searchProcessDefCount(requestParam);
	}

	@Override
	public List<ProcessEntity> searchProcessRun(Map<String, String> processRunMap) {
		return processMapper.searchProcessRunById(processRunMap);
	}

	@Override
	public ProcessEntity searchProcessRunByIdExecDate(String processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		return processMapper.searchProcessRunByIdExecDate(params);
	}

	@Override
	public List<ProcessEntity> searchProcessRunHistory(String processId, String beginScheduleDate, String endScheduleDate) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put("beginDate", beginScheduleDate);
		params.put("endDate", endScheduleDate);
		return processMapper.searchProcessRunHistory(params);
	}

	@Override
	public void deleteProcessDefById(String processId) {
		processMapper.deleteProcessDefById(processId);
	}

	@Override
	public void deleteProcessRun(Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.deleteProcessRun(params);
	}

	@Override
	public void updateProcess(ProcessEntity process) {
		processMapper.updateProcess(process);
	}

	@Override
	public void updateProcessState(Integer processId, String processState, String updatedBy) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put("processState", processState);
		params.put("updatedBy", updatedBy);
		processMapper.updateProcessState(params);
	}

	@Override
	public void startProcess(String processId, String execDate, Map<String, Object> processVariables) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);

		if (processVariables != null && processVariables.size() > 0) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			try {
				// 转为json 字符串
				String processVariableJsonStr = objectMapper.valueToTree(processVariables).toString();
				params.put("processVariables", processVariableJsonStr);
			} catch (Exception e) {
				throw new PriestPlatformException(e);
			}
		}

		processMapper.startProcess(params);

	}

	@Override
	public void terminateProcess(String processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.terminateProcess(params);

	}

	@Override
	public void failedProcess(String processId, String execDate, String detail) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("detail", detail);
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.failedProcess(params);
	}
	
	@Override
	public void failedWaitProcess(String processId, String execDate, String detail) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("detail", detail);
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.failedWaitProcess(params);
	}

	@Override
	public List<ProcessEntity> getValidProcess(String scheduleDate) {
		return processMapper.getValidProcess(scheduleDate);
	}

	@Override
	public void batchInsertRun(List<ProcessEntity> processList) {
		// 初始化流程变量
		for (ProcessEntity process : processList) {
			Map<String, String> appInfo = applicationMapper.getAppInfo(Integer.parseInt(process.getProcessApp()));
			process.setAppVariables(appInfo.get("appVariables"));
			try {
				DataTransformation.initProcessVariables(process);
			}
			// 异常subpress，防止影响其它流程
			catch (Exception e) {
				logger.error("Parse Process Parameter Error:" + process.getProcessId());
			}
		}

		processMapper.batchInsertRun(processList);
	}

	@Override
	public List<ProcessEntity> getProcessRun(String scheduleDate, String processStatus) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("scheduleDate", scheduleDate);
		params.put("processStatus", processStatus);

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = dateFormat.format(new Date());
		params.put("time", time);

		return processMapper.getProcessRun(params);

	}

	@Override
	public void batchUpdateStatus(final List<ProcessEntity> processList, final StatusEnum status) {
		jobMySqlJdbcTemplate.batchUpdate(updateSql, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return processList.size();
			}

			@Override
			public void setValues(PreparedStatement statment, int i) throws SQLException {
				ProcessEntity process = processList.get(i);
				statment.setString(1, status.name());
				statment.setInt(2, process.getProcessId());
				statment.setString(3, process.getExecDate());
			}

		});
	}

	@Override
	public void updateScheduleDate(List<ProcessEntity> processes) {
		for (ProcessEntity process : processes) {
			processMapper.updateScheduleDate(process);
		}

	}

	/**
	 * 用户创建流程时指定了最晚执行时间，本方法获取超过最晚执行时间尚未执行的流程
	 * 
	 * @param params
	 * @return
	 */
	public List<ProcessEntity> getScheduleDelayedProcess(String scheduleDate) {
		return processMapper.getScheduleDelayedProcess(scheduleDate);
	}

	/**
	 * 终止流程运行
	 * 
	 * @param processId
	 * @param execDate
	 */
	public void abortProcess(Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.abortProcess(params);
	}

	@Override
	public void updateRunningProcessVariable(Integer processId, String execDate, String processVariableJsonStr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		params.put("processVariable", processVariableJsonStr);
		processMapper.updateRunningProcessVariable(params);
	}

	@Override
	public void updateExpiredProcessRun(String scheduleDate) {
		processMapper.updateExpiredProcessRun(scheduleDate);
	}

	@Override
	public void validateProcess(Integer processId, String resultState, String investigationReason) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put("processState", resultState);
		params.put("investigationResult", investigationReason);
		processMapper.validateProcess(params);
	}

	@Override
	public void updateProcessRun(ProcessEntity process) {
		processMapper.updateProcessRun(process);
	}

	@Deprecated
	@Override
	public void updateProcessStatus(ProcessEntity process) {
		processMapper.updateProcessStatus(process);
	}

	@Override
	public Integer historyProcess(ProcessEntity process) {
		return processMapper.historyProcess(process);
	}

	@Override
	public void historyCancelProcess(Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.historyCancelProcess(params);
	}

	@Override
	public Integer pushProcess(ProcessEntity process) {
		return processMapper.pushProcess(process);
	}

	@Override
	public void batchFailProcs(final List<ProcessEntity> processList, final String message) {
		jobMySqlJdbcTemplate.batchUpdate(failSql, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return processList.size();
			}

			@Override
			public void setValues(PreparedStatement statment, int i) throws SQLException {
				ProcessEntity process = processList.get(i);
				statment.setString(1, message);
				statment.setInt(2, process.getProcessId());
				statment.setString(3, process.getExecDate());
			}
		});
	}

	@Override
	public void failedHistoryRunning() {
		processMapper.failedHistoryRunning();
	}
	
	@Override
	public void cancelAgain(String msg, Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("msg", msg);
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		processMapper.failedHistoryPro(params);
	}
	
	@Override
	public boolean checkHistoryPro(Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.COMPONENTS_PARAMS_PROCESS_ID, processId);
		params.put(Constants.COMPONENTS_PARAMS_EXEC_DATE, execDate);
		return processMapper.checkHistoryPro(params) > 0;
	}
	
	@Override
	public String getAlarmPhones(String alarmObject) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", alarmObject);
		return processMapper.getAlarmPhones(params);
	}
	
	@Override
	public Map<String, Object> getTaskType(Integer processId, String execDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("processId", processId);
		params.put("execDate", execDate);
		return processMapper.getTaskType(params);
	}

	@Override
	public void failedRunningProcess() {
		processMapper.failedRunningProcess();
	}
}
