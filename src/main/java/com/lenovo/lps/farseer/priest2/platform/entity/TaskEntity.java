package com.lenovo.lps.farseer.priest2.platform.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.lenovo.lps.farseer.priest2.platform.util.JsonStringDateSerializer;

public class TaskEntity {
    private Integer processId;
    private Integer taskId;
    private String taskName;
    private String taskStatus;
    private String execDate;
    private String startTime;
    private String endTime;
    private String taskType;
    private Integer remedyTimes;
    private String message;

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getExecDate() {
        return execDate;
    }

    public void setExecDate(String execDate) {
        this.execDate = execDate;
    }

    @JsonSerialize(using = JsonStringDateSerializer.class)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonSerialize(using = JsonStringDateSerializer.class)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    public Integer getRemedyTimes() {
        return remedyTimes;
    }

    public void setRemedyTimes(Integer remedyTimes) {
        this.remedyTimes = remedyTimes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
