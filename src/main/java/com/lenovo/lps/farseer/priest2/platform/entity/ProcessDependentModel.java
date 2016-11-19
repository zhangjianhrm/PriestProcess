/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.Serializable;

/**
 * 流程依赖
 * 
 * @author niexm1
 * 
 */
public class ProcessDependentModel implements Serializable {

    private static final long serialVersionUID = -3845670049836346676L;

    private Integer processId;// 流程ID
    private Integer dependentId;// 所依赖其它流程ID
    private String processName;// 赖流程名称
    private String dependentName;//所依赖其他流程名称

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

	public Integer getDependentId() {
		return dependentId;
	}

	public void setDependentId(Integer dependentId) {
		this.dependentId = dependentId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
}
