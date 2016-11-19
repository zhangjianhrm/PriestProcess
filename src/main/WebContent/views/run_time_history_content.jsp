<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<div id="query" style="min-height: 1100px;">
	<form id="runTimeHisForm" method="post">
		<div id="J_formFull" class="search-content">
			<div class="search-title"><%=bundleJsp.getString("queryHisDur")%></div>
			<div class="search-form">
				<dl>
					<dt><%=bundleJsp.getString("process")%>ID:</dt>
					<dd>
						<input type="text" id="processId" name="processId" class="i-text" />
					</dd>
				</dl>
				
				<dl>
					<dt><%=bundleJsp.getString("sScheduleDate")%>:</dt>
					<dd>
						<input type="text" id="startScheduleDate" name="startScheduleDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
				
				<dl>
					<dt><%=bundleJsp.getString("eScheduleDate")%>:</dt>
					<dd>
						<input type="text" id="endScheduleDate" name="endScheduleDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
			</div>
			<div class="search-btn">
				<input type="button" value="<%=bundleJsp.getString("query")%>" onClick="query();" class="btn btn-primary"/>
				<input id="formReset" type="reset" value="<%=bundleJsp.getString("reset")%>" class="btn btn-default"/>
			</div>
		</div>
	</form>
	
	
	<div class="tabControl">
		<ul>
			<li class="current" control="DataTable"><%=bundleJsp.getString("tblView")%></li>
			<li control="DataChart"><%=bundleJsp.getString("graView")%></li>
		</ul>
	</div>
	
	<div class="tableWrap" id="DataTable">
		<table id="resultTab"></table>
		<div id="pageDiv"></div>
		<div class="tableNoData hidden" id="TableNoData"><%=bundleJsp.getString("noData")%></div>
	</div>
	
	<div class="tableWrap" id="DataChart" style="display: none;">
		<div id="container" style="margin-bottom: 20px;"></div>
	</div>
</div>


<script type="text/javascript">
$(function(){
	loadTableStruct();
	
	//日期控件注册
	$('#startScheduleDate').datepicker();
	$('#endScheduleDate').datepicker();
	
	//设置日期默认值
	setDate();
	
	
	$('.tabControl li').click(function(){
		$(this).addClass('current').siblings().removeClass('current');
		var _id = $(this).attr('control');
		$('.tableWrap').hide();
		$('#' + _id).show();
	})
	
});

function setDate(){
	var processId = "${param.processId}";
	var endScheduleDate = "${param.scheduleDate}";
	
	// 开始日期默认为结束日期往前推两周
	if(processId && endScheduleDate){
		// 从流程实例页面跳转过来，自动填充流程ID和结束日期
		$('#processId').val(processId);
		$('#startScheduleDate').datepicker('setDate', getDateString(endScheduleDate, -13));
		$('#endScheduleDate').datepicker('setDate', getDateString(endScheduleDate, 0));
		query();
	} else {
		$('#startScheduleDate').datepicker('setDate', getDateString(null, -13));
		$('#endScheduleDate').datepicker('setDate', getDateString(null, 0));
	}
}

function getDateString(specifyDate, addDay){
	var retDate = new Date();
	if(specifyDate){
		specifyDateArr = specifyDate.split('-');
		retDate.setFullYear(specifyDateArr[0]);
		retDate.setMonth(specifyDateArr[1] - 1);
		retDate.setDate(specifyDateArr[2]);
	}
	
	retDate.setDate(retDate.getDate() + addDay); 
	return retDate.getFullYear() + "-" + (retDate.getMonth()+1) + "-" + retDate.getDate();; 
}

function loadTableStruct(){
	var width = $(window).width() - $('#LeftBox').width() - 60;
	$("#resultTab").jqGrid({
		url : "<%=request.getContextPath()%>/process/getRunTimeHistory.do",
		datatype : "local",
		colNames : ["<%=bundleJsp.getString("scheduleDate")%>", "<%=bundleJsp.getString("startTime")%>", "<%=bundleJsp.getString("endTime")%>", "<%=bundleJsp.getString("runDur")%>"],
		colModel : [ 
	    	{ 
	    		name : 'scheduleDate',
				index : 'schedule_date',
				align : 'center',
				sortable : false  //因为列表排序会影响曲线图，这里禁止排序
	    	},
			{ 
	    		name : 'startTime',
				index : 'start_time',
				align : 'center',
				sortable : false  
	    	},
			{ 
	    		name : 'endTime',
				index : 'end_time',
				align : 'center',
				sortable : false  
	    	},
	    	{
	    		name : 'runTime',
				index : 'runTime',
				align : 'center',
				sortable : false
	    	}
	    ],
	    rowNum : 1000,
		rowList : [ 1000 ],
		loadonce : false,
		mtype : "POST",
		gridview : true,
		pager : '#pageDiv',
		viewrecords : true,
		width : width,
		height: "100%",
		postData : {},
		jsonReader : {
			root : "rows",
			repeatitems : false
		},
		loadComplete: function(ret){
			var ids = jQuery("#resultTab").getDataIDs();
			for(var i = 0;i<ids.length;i++){
				var runTime = ret.rows[i]['runTime'];
				if(runTime === ''){
					$("#resultTab").setCell(ids[i],"runTime", "00:00:00");
				}
			}
			
			if(ret.rows != undefined && ret.rows.length == 0){
				$('#TableNoData').removeClass('hidden');
				$('.ui-jqgrid').addClass('hidden');
				return;
			}else{
				$('#TableNoData').addClass('hidden');
				$('.ui-jqgrid').removeClass('hidden');
			}
			
			$('#container').highcharts({
		        chart: {
		            type: 'line',
		            width: $(window).width() - $('#LeftBox').width() - 60
		        },
		        title: {
		    		text: '<%=bundleJsp.getString("hisDur")%>',
		    		x: -20 //center
		    	},
		        xAxis: {
		        	title: {
		                text: '<%=bundleJsp.getString("scheduleDate")%>'
		             },
		             categories: ret.scheduleDateList,
		             labels: {
		                 rotation: -25,
		                 y: 30
		             }
		        },
		        yAxis: {
		        	title: {
		                text: '<%=bundleJsp.getString("runDur")%>'
	             	},
	             	min : 0,
		            labels: { 
		                formatter: function() {
		                	return  Highcharts.dateFormat('%H:%M:%S', this.value); 
		                }
			        }
		        },
		    	tooltip: {
		    		formatter: function() {
		    				return '<%=bundleJsp.getString("scheduleDate")%>:'+'<b>'+ this.x +'</b><br/>'+
		    				'<%=bundleJsp.getString("runDur")%>:'+'<b>'+ Highcharts.dateFormat('%H:%M:%S', this.y) +'</b>';
		    		}
		    	},
		        series: [{
		        	showInLegend: false, 
		        	name: "<%=bundleJsp.getString("runDur")%>",
		            data: ret.runTimeList
		        }],
				credits: {
					enabled: false
				}
			});
			
			$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
		}
	});
}
	
function reloadTable(postData) {
	if (postData) {
		$("#resultTab").setGridParam({
			datatype : 'json',
			postData : postData
		}).trigger('reloadGrid');
	}
}

function query(){
	var processId = $('#processId').val();
	if(!/^\d+$/.test(processId)){
		alert("<%=bundleJsp.getString("proIdWarning")%>");
		$('#processId').focus();
		return false;
	}
	var startScheduleDate = $('#startScheduleDate').val();
	if(!startScheduleDate){
		alert("<%=bundleJsp.getString("selSSD")%>");
		$('#startScheduleDate').focus();
		return false;
	}
	var endScheduleDate = $('#endScheduleDate').val();
	if(!endScheduleDate){
		alert("<%=bundleJsp.getString("selESD")%>");
		$('#endScheduleDate').focus();
		return false;
	}
	
	var postData = {'processId' : processId, 'startScheduleDate' : startScheduleDate, 'endScheduleDate' : endScheduleDate};
	if ( $.History ){
    	$.History.record( postData ) ;
	}
	reloadTable(postData);
}
</script>
