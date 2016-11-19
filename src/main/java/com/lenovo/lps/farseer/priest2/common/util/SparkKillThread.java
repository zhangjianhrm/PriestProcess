package com.lenovo.lps.farseer.priest2.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class SparkKillThread implements Runnable {
	
	private static final Logger LOG = Logger.getLogger(SparkKillThread.class);
	
	private Integer processId;
	
	private String taskId;
	
	private String execDate;
	

	public SparkKillThread(Integer processId, String taskId, String execDate) {
		this.processId = processId;
		this.taskId = taskId;
		this.execDate = execDate;
	}
	

	public void run() {
		String result = httpGetSend("http://" + ConfigUtil.getContextProperty("cluster.monitor.addr") + "/cluster/apps/RUNNING");
		String runPage, jobId = "", stageId, killUrl;
		if (CommUtils.isNotNull(result)) {
			String jobIdRegex = "<a href='/cluster/app/([a-zA-Z0-9_]+)'>([a-zA-Z0-9_]+)</a>\",\"" + ConfigUtil.getContextProperty("spark.user.name") + "\",\"\",\"\",\"\",\"" 
						+ ConfigUtil.getContextProperty("spark.name") + "\",\"" + ConfigUtil.getContextProperty("spark.app.type") + "\"";
			Pattern jobIdPatt = Pattern.compile(jobIdRegex, Pattern.CASE_INSENSITIVE);
			String stageIdRegex = "id=\"stage-([0-9]+)-([0-9]+)\"><td>([0-9]+)</td><td><div><span class=\"description-input\" title=\"--execdate"
						+ execDate + ":([0-9]+):([a-zA-Z_]+):" + processId + ":" + taskId;
			Pattern stageIdPatt = Pattern.compile(stageIdRegex, Pattern.CASE_INSENSITIVE);
			String stageIdRegex1 = "id=\"stage-([0-9]+)-([0-9]+)\"><td>([0-9]+)</td><td><div><span class=\"description-input\">--execdate"
					+ execDate + ":([0-9]+):([a-zA-Z_]+):" + processId + ":" + taskId;
			Pattern stageIdPatt1 = Pattern.compile(stageIdRegex1, Pattern.CASE_INSENSITIVE);
			Matcher matcher = jobIdPatt.matcher(result), stageMatcher;
			while(matcher.find()) {
				try {
					jobId = matcher.group(1);
					runPage = httpGetSend("http://" + ConfigUtil.getContextProperty("cluster.monitor.addr") + "/proxy/" + jobId + "/stages/");
					if (CommUtils.isNotNull(runPage)) {
						int index = runPage.indexOf("id=\"completed\"");
						if (index > 1) {
							runPage = runPage.substring(0, index);
						}
						stageMatcher = stageIdPatt.matcher(runPage);
						stageId = "";
						while (stageMatcher.find()) {
							if ("".equals(stageId)) {
								stageId = stageMatcher.group(1);
							}
						}
						if (CommUtils.isNull(stageId)) {
							stageMatcher = stageIdPatt1.matcher(runPage);
							while (stageMatcher.find()) {
								if ("".equals(stageId)) {
									stageId = stageMatcher.group(1);
								}
							}
						}
						if (CommUtils.isNotNull(stageId)) {
							killUrl = "http://" + ConfigUtil.getContextProperty("cluster.monitor.addr") + "/proxy/"+jobId + "/stages/stage/kill/?id="+stageId + "&terminate=true";
							HttpRequestUtil.httpGetSend(killUrl);	
							AuditLog.log(String.format("kill spark task processId[%s] taskId[%s] execDate[%s] killUrl[%s]", processId, taskId, execDate, killUrl));
						}
					}
				} catch (Exception e) {
					LOG.error(String.format("kill spark task processId[%s] taskId[%s] execDate[%s] jobId[%s] error", 
							processId, taskId, execDate, jobId), e);
				}
			}
		}
	}
	
	private static String httpGetSend(String url) {
		String result = "";
		try {
			result = HttpRequestUtil.httpGetSend(url);
		} catch (Exception e) {
			try {
				result = HttpRequestUtil.httpGetSend(url);
			} catch (Exception e2) {}
		}
		if (result == null) {
			try {
				result = HttpRequestUtil.httpGetSend(url);
			} catch (Exception e2) {}
		}
		return result;
	}
}
