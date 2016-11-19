package com.lenovo.lps.farseer.priest2.platform.manager.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.manager.ProcessManager;
import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.service.TaskService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.XMLParseUtils;

public class ProcessManagerImpl implements ProcessManager {
	private static final String BPMN_DEF_REF = "/definitions/*[name()='process']/*[name()='sequenceFlow'][@sourceRef='";
	private static final String TARGET_REF = "']/@targetRef";

	private final Logger logger = Logger.getLogger(ProcessManagerImpl.class);

	@Autowired
	@Qualifier("processService")
	private ProcessService processService;

	@Autowired
	@Qualifier("taskService")
	private TaskService taskService;

	@Resource
	private ScheduleService scheduleService;

	@Override
	public boolean regiestProcess(String process) {
		ProcessEntity processEntity = new ProcessEntity();
		processEntity.setBpmnDef(process);
		processService.insertProcess(processEntity);
		return true;
	}

	@Override
	public PagingResult<ProcessEntity> getProcessDef(ProcessEntity requestParam) {
		return processService.getProcessDef(requestParam);
	}

	@Override
	public void retryProcess(String processId, String execDate, String taskStatus, HttpSession session) {
		try {
			// 设置上一次运行流程变量
			ProcessEntity oldProcessRun = processService.getProcessRun(Integer.valueOf(processId), execDate);

			String processStatus = oldProcessRun.getProcessStatus();
			Assert.isTrue(processStatus.equals(StatusEnum.F.name()) || processStatus.equals(StatusEnum.C.name()), "Only failed or canceled process instance can be try again!");
			// 限定只能重试本人新增的流程
			if (!oldProcessRun.getCreatedBy().equals(AccessSession.getAccessUser(session))
					&& !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(session)) && !"pulseRetry".equals(taskStatus)) {
				throw new PriestPlatformException("can't try it again if U aren't the creator, the creator is:" + oldProcessRun.getCreatedBy());
			}
			oldProcessRun.setMessage(null);
			oldProcessRun.setStartTime(null);
			oldProcessRun.setEndTime(null);
			// 设置失败重试标志
			oldProcessRun.setRetry(true);

			TaskEntity taskEntity = taskService.getFirstFailedTask(Integer.valueOf(processId), execDate);
			if (taskEntity != null) {
				// 生成重试的bpmn
				String retryBpmn = generateRetryBpmnDef(oldProcessRun, taskEntity);

				oldProcessRun.setBpmnDef(retryBpmn);

				List<ProcessEntity> toRetryProcs = new ArrayList<ProcessEntity>();
				toRetryProcs.add(oldProcessRun);
				// 更新DB状态:任务已加载到内存排队
				processService.batchUpdateStatus(toRetryProcs, StatusEnum.Q);
				scheduleService.submitJbpmProcess(oldProcessRun);
			} else {
				throw new PriestPlatformException("Can't find the process,Process ID:" + processId + ", Execute Date:" + execDate);
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
	}

	private String generateRetryBpmnDef(ProcessEntity processEntity, TaskEntity taskEntity) {
		// 找出流程中所有任务、分支、开始、结束的ID
		String taskId = String.valueOf(taskEntity.getTaskId());
		String bpmnDef = processEntity.getBpmnDef();
		String startEventId = XMLParseUtils.getNodeAttributeValue(bpmnDef,
				"/definitions/*[name()='process']/*[name()='startEvent']/@id");
		Set<String> endEventId = XMLParseUtils.getAttributeValueSet(bpmnDef,
				"/definitions/*[name()='process']/*[name()='endEvent']/@id");
		String taskEventId = XMLParseUtils.getNodeAttributeValue(bpmnDef, "/definitions/*[name()='process']/*[name()='task'][@name='"
				+ taskId + "']/@id");
		Set<String> sourceRefIdSet = XMLParseUtils.getAttributeValueSet(bpmnDef,
				"/definitions/*[name()='process']/*[name()='sequenceFlow']/@sourceRef");
		Set<String> targetRefIdSet = XMLParseUtils.getAttributeValueSet(bpmnDef,
				"/definitions/*[name()='process']/*[name()='sequenceFlow']/@targetRef");
		Set<String> eventIdSet = new HashSet<String>();
		eventIdSet.addAll(sourceRefIdSet);
		eventIdSet.addAll(targetRefIdSet);
		// 找出需要重跑的任务和分支的ID
		String sourceRef = taskEventId;
		Set<String> retryEventIdSet = new HashSet<String>();
		retryEventIdSet.add(sourceRef);
		retryEventIdSet = findretryEventId(bpmnDef, endEventId, sourceRef, retryEventIdSet);
		eventIdSet.removeAll(retryEventIdSet);
		eventIdSet.remove(startEventId);
		// 重新构造重跑需要的流程
		String retryBpmn = XMLParseUtils.modifyNodeAttribute(bpmnDef, BPMN_DEF_REF + startEventId + TARGET_REF, taskEventId);
		for (String source : eventIdSet) {
			retryBpmn = XMLParseUtils.removeNode(retryBpmn, "/definitions/*[name()='process']/*[name()='sequenceFlow'][@*='" + source
					+ "']");
			retryBpmn = XMLParseUtils.removeNode(retryBpmn, "/definitions/*[name()='process']/*[@id='" + source + "']");
		}
		// 检查并处理重新构造的流程
		Set<String> exclusiveGatewayConvergingId = XMLParseUtils.getAttributeValueSet(retryBpmn,
				"/definitions/*[name()='process']/*[name()='exclusiveGateway'][@gatewayDirection='Converging']/@id");
		for (String convergingId : exclusiveGatewayConvergingId) {
			Set<String> sourceRefOfConvergingSet = XMLParseUtils.getAttributeValueSet(retryBpmn,
					"/definitions/*[name()='process']/*[name()='sequenceFlow'][@targetRef='" + convergingId + "']/@sourceRef");
			if (sourceRefOfConvergingSet.size() == 1) {
				String sourceRefOfConverging = (new ArrayList<String>(sourceRefOfConvergingSet)).get(0);
				String targetRefOfConverging = XMLParseUtils
						.getNodeAttributeValue(retryBpmn, BPMN_DEF_REF + convergingId + TARGET_REF);
				retryBpmn = XMLParseUtils.modifyNodeAttribute(retryBpmn, BPMN_DEF_REF + sourceRefOfConverging + "'][@targetRef='"
						+ convergingId + TARGET_REF, targetRefOfConverging);
				retryBpmn = XMLParseUtils.removeNode(retryBpmn, "/definitions/*[name()='process']/*[name()='sequenceFlow'][@*='"
						+ convergingId + "']");
				retryBpmn = XMLParseUtils.removeNode(retryBpmn, "/definitions/*[name()='process']/*[@id='" + convergingId + "']");
			}
		}
		return retryBpmn;
	}

	private Set<String> findretryEventId(String bpmnDef, Set<String> endEventId, String sourceRef, Set<String> retryEventIdSet) {
		Set<String> sourceRefSet = null;
		Set<String> returnSet = retryEventIdSet;
		if (!endEventId.contains(sourceRef)) {
			sourceRefSet = XMLParseUtils.getAttributeValueSet(bpmnDef, BPMN_DEF_REF + sourceRef + TARGET_REF);
			returnSet.addAll(sourceRefSet);
			for (String string : sourceRefSet) {
				returnSet = findretryEventId(bpmnDef, endEventId, string, returnSet);
			}
		}
		return returnSet;
	}

}
