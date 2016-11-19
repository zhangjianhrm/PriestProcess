package com.lenovo.lps.farseer.priest2.platform.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonProcessingException;

import com.lenovo.lps.farseer.priest2.platform.entity.TaskEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;

public interface TaskManager {

    /**
     * 查询流程任务
     * 
     * @param processId
     * @param processName
     * @param execDate
     * @param rows
     * @param page
     * @param sidx
     * @param sord
     * @return
     */
    List<TaskEntity> getTask(String processId, String processName, String execDate, Integer rows, Integer page, String sidx,
            String sord);

    /**
     * 查询流程任务(with process name)
     * 
     * @param processId
     * @param processName
     * @param execDate
     * @param rows
     * @param page
     * @param sidx
     * @param sord
     * @return
     */
    List<TaskOfProcessEntity> getTaskOfProcess(String processId, String processName, String execDate, Integer rows, Integer page, String sidx,
            String sord);
    /**
     * 查询总页数
     * 
     * @param processId
     * @param processName
     * @param execDate
     * @param rows
     * @return
     */
    Map<String, Integer> getTaskTotalPage(String processId, String processName, String execDate, Integer rows);

    /**
     * @param processId
     * @param execDate
     * @return
     * @throws ParseException
     * @throws JsonProcessingException
     * @throws IOException
     */
    String tintProcess(String processId, String execDate) throws ParseException, JsonProcessingException, IOException;
}
