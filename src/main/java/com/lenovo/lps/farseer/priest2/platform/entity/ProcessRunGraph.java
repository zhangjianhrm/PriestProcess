/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.platform.util.GraphViz;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

/**
 * @author hubin3
 * 
 */
public class ProcessRunGraph {

	private String height = "2000";
	private String width = "60";
	private String boundary = "800" ;

	public ProcessRunGraph() {
	}

	public ProcessRunGraph(String height, String width) {
		this.height = height;
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		if (StringUtils.isNotBlank(height)) {
			this.height = height;
		}
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		if (StringUtils.isNotBlank(width)) {
			this.width = width;
		}
	}
	public void setBoundary(String boundary) {
		if (StringUtils.isNotBlank(width)) {
			this.boundary = boundary;
		}		
	}
	public String getBoundary() {
		return boundary;
	}

	// 界面节点默认颜色:灰
	private static final String DEFAULT_COLOR = "lightgray";

	private static final String LINE_FORMAT = "%s -> %s;";
	private static final String NODE_FORMAT = "%s [color= \"%s\", label=\"%s\", id=\"%s\"];";

	public String generateGraph(List<ProcessEntity> processRuns) throws UnsupportedEncodingException {
		// processTag由processId.processExecDateTag组成
		// processExecDateTag由processExecDate去掉所有"-"
		Set<String> processTagSet = new HashSet<String>();
		Integer processId;
		String processExecDate, execDateTag, processTag;
		for (ProcessEntity processEntity : processRuns) {
			processId = processEntity.getProcessId();
			processExecDate = processEntity.getExecDate();
			if (StringUtil.isNotEmpty(processExecDate)) {
				execDateTag = processExecDate.replaceAll("-", "");
				processTag = processId + "." + execDateTag;
				processTagSet.add(processTag);
			} else {
				processTagSet.add(String.valueOf(processId));
			}
			
		}
		
		GraphViz gv = new GraphViz();
		gv.addln(gv.startGraph());
		gv.addln("id=viewport;");
		int preWidth = processRuns.size() / 5;
		int iWidth = Integer.parseInt(width);
		int iBoundary = Integer.parseInt(boundary);
		
		preWidth = preWidth > iWidth ? preWidth : iWidth;
		if (processRuns.isEmpty()) {
			gv.addln("size=\"" + preWidth + "," + height + "\";fontsize=11;rankdir=TB;ranksep=1.25;");
		} if ( processRuns.size() < iBoundary) {
			gv.addln("size=\"" + preWidth + "," + height + "\";fontsize=11;rankdir=TB;ranksep=1.25;splines=ortho;nslimit1=3;nslimit=3;maxiter=12;");
		} else {
			// too much size , then get rid of property "splines=ortho;" 
			gv.addln("size=\"" + preWidth + "," + height + "\";fontsize=11;rankdir=TB;ranksep=1.25;nslimit1=3;nslimit=3;maxiter=12;");
		}
		gv.addln("node [style=filled, width=0.5, height=0.25, fontsize=11];");
		
		String depProcessTag, processName, processStatus, lable, nodeColor;
		Integer depProcessId;
		// 设置有向图的节点和有向边
		for (ProcessEntity processRun : processRuns) {
			processId = processRun.getProcessId();
			depProcessId = processRun.getDepProcessId();
			if (CommUtils.isNotNull(processRun.getScheduleType())) {
				processName = "(" + processRun.getScheduleType() + ")" + processRun.getProcessName();
				lable = processName.length() > 8 ? processName.substring(0, 8) + "..." : processName;
			} else {
				processName = processRun.getProcessName();
				lable = processName.length() > 6 ? processName.substring(0, 6) + "..." : processName;
			}
			processExecDate = processRun.getExecDate();
			
			processStatus = processRun.getProcessStatus();
			
			nodeColor = colorOfNode(processRun);
			if (StringUtil.isNotEmpty(processExecDate)) {
				execDateTag = processExecDate.replaceAll("-", "");
				processTag = processId + "." + execDateTag;
				depProcessTag = depProcessId + "." + execDateTag;
			} else {
				processTag = String.valueOf(processId);
				depProcessTag = String.valueOf(depProcessId);
			}
			gv.addln(String.format(NODE_FORMAT, processTag, nodeColor, lable, processStatus + "_" + processExecDate));
			
			if (processTagSet.contains(depProcessTag)) {
				// 创建一条有向边
				gv.addln(String.format(LINE_FORMAT, depProcessTag, processTag));
			}
		}
		
		gv.addln(gv.endGraph());
		String fileType = "svg";
		byte[] svgbyte = gv.getGraph(gv.getDotSource(), fileType);
		String svg = new String(svgbyte, "utf-8");
		String  svgXML = svg.trim() ;
		int idx = svg.indexOf("<svg") ;
		if ( idx > -1 ) {
			svgXML = svg.substring(idx).trim();
		}
		//去除svg标签的viewBox部分是为了保证前端的svgpan插件可以使用
		return svgXML.replaceFirst("viewBox.*?(?=xmlns)", "");
	}

	private String colorOfNode(ProcessEntity process) {
		StatusEnum processStatus = StatusEnum.valueOf(StringUtil.isEmpty(process.getProcessStatus()) ? "W":process.getProcessStatus());
		String color = DEFAULT_COLOR;
		switch (processStatus) {
		// 内存排队:浅蓝
		case Q:
			color = "#d3e7f6";
			break;
		// 正在执行:黄色
		case R:
			color = "#fcd356";
			break;
		// 失败,取消执行：红色
		case F:
		case C:
			color = "#f16363";
			break;
		// 成功：绿色
		case S:
			color = "#1ac597";
			break;
		// 暂缓：粉色
		case H:
			color = "#fb9def";
			break;
		// 界面矩形默认填充颜色
		default:
			break;
		}
		return color;
	}

}