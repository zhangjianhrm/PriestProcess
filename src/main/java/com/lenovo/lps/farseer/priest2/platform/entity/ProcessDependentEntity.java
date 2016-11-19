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
public class ProcessDependentEntity implements Serializable {

    private static final long serialVersionUID = -3845670049836346676L;

    private Integer id;// 主键ID
    private Integer processId;// 流程ID
    private Integer dependentProcessId;// 所依赖其它流程ID
    private String execDate;// 所依赖其它流程执行日期

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getDependentProcessId() {
        return dependentProcessId;
    }

    public void setDependentProcessId(Integer dependentProcessId) {
        this.dependentProcessId = dependentProcessId;
    }

    public String getExecDate() {
        return execDate;
    }

    public void setExecDate(String execDate) {
        this.execDate = execDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
