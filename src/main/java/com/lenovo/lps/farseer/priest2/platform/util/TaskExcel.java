package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.platform.entity.TaskOfProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.manager.TaskManager;

public class TaskExcel {

	@Autowired
	@Qualifier("taskManager")
	private TaskManager taskManager;
	private static Logger logger = Logger.getLogger(TaskExcel.class);

	public void taskexcel(OutputStream output, String execDate, String processName, Integer processId, Integer rows, Integer page,
			String sidx, String sord) throws SQLException, IOException {

		String processIdStr = processId == null ? null : String.valueOf(processId);

		List<TaskOfProcessEntity> entities = taskManager.getTaskOfProcess(processIdStr, processName, execDate, 65535, 1, sidx, sord);

		// 指定execl中的字段数
		int countColumnNum = 11;

		// 创建Excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// sheet 对应一个工作页
		HSSFSheet sheet = wb.createSheet("Task Running Information");
		// 设置单元格的对齐方式为居中
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		// 设置单元格的对齐方式为左边对齐
		HSSFCellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		// 设置不同列的宽度
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 2500);
		sheet.setColumnWidth(5, 3000);
		sheet.setColumnWidth(6, 5000);
		sheet.setColumnWidth(7, 5000);
		sheet.setColumnWidth(8, 3000);
		sheet.setColumnWidth(9, 3000);
		sheet.setColumnWidth(10, 10000);

		HSSFRow firstrow = sheet.createRow(0); // 下标为0的行开始
		HSSFCell[] firstcell = new HSSFCell[countColumnNum];
		// 为首行写入字段
		for (int j = 0; j < countColumnNum; j++) {
			String[] names = { "ProcessID", "ProcessName", "TaskID", "TaskType", "TaskStatus", "ExecDate", "StartTime", "EndTime", "RunTime",  "RetryTimes", "Detail" };
			firstcell[j] = firstrow.createCell(j);
			firstcell[j].setCellValue(new HSSFRichTextString(names[j]));
			// 应用了居中对齐
			firstcell[j].setCellStyle(cellStyle);
		}
		int i = 1;
		if (entities != null && entities.size() > 0) {
			for (int k = 0; k < entities.size(); k++) {
				HSSFRow row = sheet.createRow(i++);
				// 从list中获取到实体类TaskEntity的对象array1
				TaskOfProcessEntity array1 = entities.get(k);
				// 循环把每个从list中取出的TaskEntity放到excel的每一行
				String status = getStatus(array1);
				
				String str1 = array1.getTaskType();
				String tasktype = getTaskType(str1);
				
				HSSFCell cell0 = row.createCell(0);
				cell0.setCellValue(array1.getProcessId());
				cell0.setCellStyle(cellStyle1);
				HSSFCell cell1 = row.createCell(1);
				cell1.setCellValue(array1.getProcessName());
				HSSFCell cell2 = row.createCell(2);
				cell2.setCellValue(array1.getTaskId());
				cell2.setCellStyle(cellStyle1);
				HSSFCell cell3 = row.createCell(3);
				cell3.setCellValue(tasktype);
				HSSFCell cell4 = row.createCell(4);
				cell4.setCellValue(status);
				HSSFCell cell5 = row.createCell(5);
				cell5.setCellValue(array1.getExecDate());
				HSSFCell cell6 = row.createCell(6);
				cell6.setCellValue(array1.getStartTime());
				HSSFCell cell7 = row.createCell(7);
				cell7.setCellValue(array1.getEndTime());
				HSSFCell cell8 = row.createCell(8);
				cell8.setCellValue(array1.getRunTime());
				HSSFCell cell9 = row.createCell(9);
				cell9.setCellValue(array1.getRemedyTimes());
				cell9.setCellStyle(cellStyle1);
				HSSFCell cell10 = row.createCell(10);
				cell10.setCellValue(array1.getMessage());

			}
		}

		OutputStream outputbuffer = null;
		try {
			outputbuffer = new BufferedOutputStream(output);// 写入到缓冲流
			wb.write(outputbuffer);
			outputbuffer.flush();

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(outputbuffer);
		}
	}

	private String getTaskType(String str1) {
		String tasktype = null;
		if ("TRANSFER".equals(str1)) {
			tasktype = "Transfer";
		}
		if ("HDFS".equals(str1)) {
			tasktype = "HDFS";
		}
		if ("MAPREDUCE".equals(str1)) {
			tasktype = "Map Reduce";
		}
		if ("HIVE".equals(str1)) {
			tasktype = "Hive";
		}
		if ("MYSQL".equals(str1)) {
			tasktype = "MySQL";
		}
		if ("SHELL".equals(str1)) {
			tasktype = "Shell";
		}
		if ("JAVA".equals(str1)) {
			tasktype = "JAVA";
		}
		if ("CACHE".equals(str1)) {
			tasktype = "Memcached";
		}
		if ("DEP".equals(str1)) {
			tasktype = "Dependency";
		}
		return tasktype;
	}

	private String getStatus(TaskOfProcessEntity array1) {
		String status = null;
		String str = array1.getTaskStatus();
		if ("W".equals(str)) {
			status = "Waiting";
		}
		if ("Q".equals(str)) {
			status = "Queuing";
		}
		if ("R".equals(str)) {
			status = "Running";
		}
		if ("S".equals(str)) {
			status = "Successful";
		}
		if ("F".equals(str)) {
			status = "Failed";
		}
		if ("P".equals(str)) {
			status = "Paused";
		}
		if ("C".equals(str)) {
			status = "Cancel";
		}
		if ("D".equals(str)) {
			status = "Disabled";
		}
		return status;
	}
}
