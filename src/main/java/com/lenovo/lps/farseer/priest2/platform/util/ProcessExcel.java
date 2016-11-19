package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;

public class ProcessExcel {
	private static Logger logger = Logger.getLogger(ProcessExcel.class);
	
	@Autowired
	private ProcessService processService;

	public void processexcel(OutputStream output, ProcessEntity param) throws SQLException, IOException {
		// 获取数据库中的数据
		PagingResult<ProcessEntity> processRuns = processService.getProcessRuns(param);
		// 指定的字段数
		int countColumnNum = 10;

		// 创建Excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// sheet 对应一个工作页
		HSSFSheet sheet = wb.createSheet("The data of process running");
		// 设置单元格的对齐方式为居中
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		// 设置单元格的对齐方式为左边对齐
		HSSFCellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		// 分别设置不同列的宽度
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(3, 3000);
		sheet.setColumnWidth(4, 2700);
		sheet.setColumnWidth(5, 3000);
		sheet.setColumnWidth(6, 4700);
		sheet.setColumnWidth(7, 4700);
		sheet.setColumnWidth(8, 3000);
		sheet.setColumnWidth(9, 10000);
		HSSFRow firstrow = sheet.createRow(0); // 下标为0的行开始
		HSSFCell[] firstcell = new HSSFCell[countColumnNum];
		// 为第一行，写入字段
		for (int j = 0; j < countColumnNum; j++) {
			String[] names = { "Process ID", "Name", "Status", "Schedule Date", "Schedule Time", "ExecDate", "Start Time",
						"End Time", "Run time", "Run Info" };
			firstcell[j] = firstrow.createCell(j);
			firstcell[j].setCellValue(new HSSFRichTextString(names[j]));
			// 应用了居中对齐
			firstcell[j].setCellStyle(cellStyle);
		}
		int i = 1;
		if (processRuns.getTotalRecords().longValue() > 0) {
			for (int k = 0; k < processRuns.getTotalRecords().longValue(); k++) {
				HSSFRow row = sheet.createRow(i++);// 从第一行开始创建
				// 获取到list的一项，类型为processEntity实体类
				ProcessEntity array1 = processRuns.getResults().get(k);
				String str = array1.getProcessStatus();
				String status = getStatus(str);

				// 循环的方式把取出的每个array1中的数据写入到单元格中
				HSSFCell cell0 = row.createCell(0);
				// 应用了左边对齐
				cell0.setCellStyle(cellStyle1);
				cell0.setCellValue(array1.getProcessId());
				HSSFCell cell1 = row.createCell(1);
				cell1.setCellValue(array1.getProcessName());
				HSSFCell cell2 = row.createCell(2);
				cell2.setCellValue(status);
				HSSFCell cell3 = row.createCell(3);
				cell3.setCellValue(array1.getScheduleDate());
				HSSFCell cell4 = row.createCell(4);
				cell4.setCellValue(array1.getScheduleTime());
				HSSFCell cell5 = row.createCell(5);
				cell5.setCellValue(array1.getExecDate());
				HSSFCell cell6 = row.createCell(6);
				cell6.setCellValue(array1.getStartTime());
				HSSFCell cell7 = row.createCell(7);
				cell7.setCellValue(array1.getEndTime());
				HSSFCell cell8 = row.createCell(8);
				cell8.setCellValue(array1.getRunTime());
				HSSFCell cell9 = row.createCell(9);
				cell9.setCellValue(array1.getMessage());

			}

		}

		try {

			OutputStream outputbuffer = new BufferedOutputStream(output);// 写入数据缓冲流
			wb.write(outputbuffer);
			outputbuffer.flush();

		} catch (IOException e) {
			logger.error(e.getMessage(), e);

		}
	}

	private String getStatus(String str) {
		char[] ch = str.toCharArray();
		String status = null;
		switch (ch[0]) {
		case 'W':
			status = "Waiting";
			break;
		case 'Q':
			status = "Queuing";
			break;
		case 'R':
			status = "Running";
			break;
		case 'S':
			status = "Successful";
			break;
		case 'F':
			status = "Failed";
			break;
		case 'P':
			status = "Paused";
			break;
		case 'C':
			status = "Canceled";
			break;
		case 'D':
			status = "Disabled";
			break;
		default:
			break;
		}
		return status;
	}

}
