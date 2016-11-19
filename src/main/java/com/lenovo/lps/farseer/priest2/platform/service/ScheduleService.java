/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;

/**
 * 流程运行调度
 * 
 * @author niexm1
 * 
 */
public interface ScheduleService {
	/**
	 * 终止运行流程
	 * 
	 * @param processId
	 * @param execDate
	 */
	public void abortRunningProcess(Integer processId, String execDate);

	/**
	 * 向线程池提交jbpm流程
	 * 
	 * @param toRunProcess
	 */
	public void submitJbpmProcess(ProcessEntity toRunProcess);

	/**
	 * 重运行流程实例
	 * 
	 * @param processId
	 * @param execDate
	 */
	public void rerunProcess(Integer processId, String execDate, HttpSession session);

	/**
	 * 重运行整条流程依赖实例
	 * 
	 * @param processId
	 * @param execDate
	 */
	public void rerunProcesses(Integer processId, String execDate);

	/**
	 * 中止当前的流程节点以及该节点的所有子孙节点的运行
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	public Set<Integer> abortRunningProcesses(Integer processId, String execDate, Set<Integer> rerunProcessIds);
	
	/**
	 * 获取子流程id
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	public Set<Integer> getProcessChildrenIds(Integer processId, int depth);
	
	/**
	 * 获取父流程id
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	public Set<Integer> getProcessParentIds(Integer processId, int depth);
	
	/**
	 * 中止当前的等待流程节点
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	public void abortWaitProcess(Integer processId, String execDate, String userName, Set<Integer> abortProcessIds);

	/**
	 * 检查当前流程及其后续流程状态是否适合重跑
	 * 
	 * @param processId
	 * @param execDate
	 * @param rerunProcessIds
	 * @return
	 */
	public Set<Integer> checkRunningProcesses(Integer processId, String execDate, Set<Integer> rerunProcessIds);

	/**
	 * 补跑历史数据
	 * 
	 * @param processId
	 * @param startDataDate
	 * @param endDataDate
	 * @param dFlagState
	 * @throws ParseException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws Exception
	 */
	public void historyRunProcesses(Integer processId, String startDataDate, String endDataDate, String dFlagState)
			throws ParseException, JsonParseException, JsonMappingException, IOException;

	/**
	 * 检查流程是否处于可运行状态
	 * 
	 * @param process
	 * @return
	 */
	public boolean checkStandbyProcess(ProcessEntity process);

	/**
	 * 主动驱动流程
	 * 
	 * @param requestParam
	 * @throws ParseException
	 */
	public void pulseProcesses(Map<String, String> requestParam) throws ParseException;

	/**
	 * 取消补跑历史数据
	 * 
	 * @param processId
	 * @param startDataDate
	 * @param endDataDate
	 * @throws ParseException
	 */
	public void historyCancelProcesses(Integer processId, String startDataDate, String endDataDate, String userName) throws ParseException;

}
