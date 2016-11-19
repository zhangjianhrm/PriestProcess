package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class WorkSession {
	
	public static  final Logger logger = Logger.getLogger(WorkSession.class);
	static final ThreadLocal<WorkSession> threadlocal = new ThreadLocal<WorkSession>(){
		protected WorkSession initialValue() {
			return new WorkSession();
		};
	};
	
	String pid;
	String tid;
	String execdate;
	Long  maxResultRowCount = -1L ;
	Long  maxResultDatasize = -1L ; // in bytes.
	
	WorkSession(){		
	}
	
	WorkSession(String pid,String tid,String execdate){
		this.pid = pid ;
		this.tid = tid ;
		this.execdate = execdate ;
	}
	public String getProcessId() {
		return pid ;
	}
	public String getTaskId() {
		return tid ;
	}	
	public String getExecdate(){
		return execdate ;
	}
	public void setMaxResultDatasize(Long maxResultDatasize) {
		this.maxResultDatasize = maxResultDatasize;
	}
	public Long getMaxResultDatasize() {
		return maxResultDatasize;
	}
	public void setMaxResultRowCount(Long maxResultRowCount) {
		this.maxResultRowCount = maxResultRowCount;
	}
	public Long getMaxResultRowCount() {
		return maxResultRowCount;
	}
	
	public void setRuntimeInfo(String pid,String tid,String execdate){
		this.pid = pid ;
		this.tid = tid ;
		this.execdate = execdate ;
	}
	
	public static WorkSession start(String pid,String tid,String execdate){
		return new WorkSession(pid,tid,execdate);
	}
	
	public static void setCurrentSession(WorkSession ss){
		threadlocal.set(ss);
	}
	
	public static WorkSession get(){
		return threadlocal.get();
	}

	public Map<String ,String> getRuntimeInfo(){
		Map<String, String> paramsMap = new HashMap<String, String>();
		if ( pid != null ){			
			paramsMap.put("pid", pid);
		}
		if ( tid != null ){
			paramsMap.put("tid", tid);
		}
		if ( execdate != null ){
			paramsMap.put("execdate", execdate);
		}
		return paramsMap ;
	}
	public String getRuntimeInfoJson() {
		ObjectMapper objectMapper2 = new ObjectMapper();
		objectMapper2.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper2.valueToTree(getRuntimeInfo()).toString();
	}

}
