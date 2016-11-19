<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>

<script type="text/javascript">
window.PostStr = 0,
	GoBack = -1;

$(function(){
	var refer = document.referrer;
	
	if(refer.indexOf('run_history') > 0 || refer.indexOf('process_run_list') > 0){
		if(refer.indexOf('run_history') > 0){
			window.parent.document.getElementById('refer').innerHTML = '<%=bundleJsp.getString("rerunIns")%>';
			window.parent.document.getElementById('rhHref').className = 'active';
		}else{
			window.parent.document.getElementById('refer').innerHTML = '<%=bundleJsp.getString("processList")%>';
		}
	}else{
		window.parent.document.getElementById('refer').href = "<%=request.getContextPath()%>/views/process_run_list.jsp?click=prl";
	}
	
	window.parent.document.getElementById('refer').onclick = function(){
		window.history.go(GoBack);
	}

})


var processId = '<%=request.getParameter("processId")%>';
var execDate = '<%=request.getParameter("execDate")%>';
var queryParam = {};
	//任务查询
	function query() {
		var processId = $('#processId').val().trim();
		var processName = $('#processName').val().trim();
		var execDate = $('#execDate').val();
		$('#taskJsonDef').val('');
		var digitPattern = /^\d+$/;
		if (processId == '' || !digitPattern.test(processId) || processId<1){
			alert("<%=bundleJsp.getString("proIdWarning")%>");
			$('#processId').focus();
			return false;
		}
		
		//iframe刷新
		var iframeObj = (document.getElementById)?document.getElementById('pIframe'):document.all['pIframe'];
		iframeObj.src = iframeObj.src;
		
		var postData = {"processId":processId,"processName":processName,"execDate":execDate};
		jQuery("#resultTab").setGridParam({
			page : '1'
		});
		//查询任务执行信息
		if ( $.History ){
    		$.History.record( postData ) ;
		}
		tmpStr = JSON.stringify(postData);
		if ( tmpStr != PostStr ) {
			window.GoBack -= 1 ;
			PostStr = tmpStr;
		}
		reloadTable(postData);
	}
	
	function download(){
		var processId = $('#processId').val();
		var processName = $('#processName').val();
		var execDate = $('#execDate').val();
		var sidx=jQuery("#resultTab").getGridParam('sortname');
        var sord=jQuery("#resultTab").getGridParam('sortorder'); 
        if (!processId&&!processName&&!execDate){
			alert("<%=bundleJsp.getString("selCondi")%>");
			return false;
		}
		window.location.href="<%=request.getContextPath()%>/task/taskExcel11.do?execDate=" + execDate+"&processName="+processName+"&processId="+processId+"&sidx="+sidx+"&sord="+sord;
	}

	function reloadTable(postData) {
		if (postData) {
			jQuery("#resultTab").setGridParam({
				postData : postData
			});
		}
		
		jQuery("#resultTab").setGridParam({
			datatype : 'json'
		});
		jQuery("#resultTab").trigger('reloadGrid');
	}

	$(function() {
		var width = $(window).width() - $('#LeftBox').width() - 60;
		
		//如果从其它页面跑转过来，需从后台查询为数据，否则空表格
		var dataType = pageFromOther?"json":"local";
		
		jQuery("#resultTab").jqGrid({
			url : "<%=request.getContextPath()%>/task/searchTask.do",
			postData:queryParam,
			datatype : dataType,
			colNames : ["<%=bundleJsp.getString("process")%>ID","<%=bundleJsp.getString("taskName")%>" , "<%=bundleJsp.getString("task")%>ID", "<%=bundleJsp.getString("taskType")%>", "<%=bundleJsp.getString("taskState")%>","<%=bundleJsp.getString("dataDate")%>", "<%=bundleJsp.getString("startTime")%>","<%=bundleJsp.getString("endTime")%>","<%=bundleJsp.getString("runDur")%>", "<%=bundleJsp.getString("rerunTime")%>","<%=bundleJsp.getString("runInfo")%>"],
			colModel : [ 
			{
				name : 'processId',
				index : 'process_id',
				width : 30,
				hidden : false
			},
			{
				name : 'taskName',
				index : 'task_name',
				width : 120,
				hidden : false
			},			            
			{
				name : 'taskId',
				index : 'task_id',
				width : 40,
				hidden : false,
				sorttype : 'int'
			}, {
				name : 'taskType',
				index : 'task_type',
				width : 60
			}, 
			{
				name : 'taskStatus',
				index : 'task_status',
				width : 45
			},{
				name : 'execDate',
				index : 'exec_date',
				width : 65
			}, 
			 {
				name : 'startTime',
				index : 'start_time',
				width : 120
			}, 
			 {
				name : 'endTime',
				index : 'end_time',
				width : 120
			},
			 {
				name : 'runTime',
				index : 'run_time',
				width : 60,
				align : 'center'
			},
			 {
				name : 'remedyTimes',
				index : 'remedy_times',
				width : 50,
				hidden : true
			},					
             {
				name : 'message',
				index : 'message',
				align : 'center'
			}],
			rowNum : 20,
			rowList : [ 10, 20, 30 ],
			loadonce : false,
			mtype : "POST",
			rownumbers : false,
			rownumWidth : 40,
			gridview : true,
			pager : '#pageDiv',
			footerrow : true,
			sortname : 'start_time',
			viewrecords : true,
			sortorder : "desc",
			caption : "",
			width : width,
			height:"100%",
			viewrecords : true,
			jsonReader : {
				root : "rows",
				total : "totalPages",
				page : "currentPage",
				records : "totalRecords",
				repeatitems : false
			},
			loadComplete: function(xhr){
				
				//查询出错
				if (xhr.err){
					alert(xhr.err);
					return false;
				}
				
				if(xhr.rows == null){
					$('#TableNoData').removeClass('hidden');
					$('.ui-jqgrid').addClass('hidden');
					return;
				}else{
					$('#TableNoData').addClass('hidden');
					$('.ui-jqgrid').removeClass('hidden');
				}
				
				//生成操作列内容
				var ids = jQuery("#resultTab").getDataIDs();
				//数据转为json字段
				if (xhr.rows){
					var tableData = JSON.stringify(xhr.rows);
					$('#tableData').val(tableData);
				}
				
				for(var i = 0;i<ids.length;i++){
					var taskStatus = xhr.rows[i]['taskStatus'];
					var statusValue = null;
					switch (taskStatus) {
					case 'W':
						statusValue = "<%=bundleJsp.getString("waitExe")%>";
						break;
					case 'Q':
						statusValue = "<%=bundleJsp.getString("memQue")%>";
						break;						
					case 'R':
						statusValue = "<%=bundleJsp.getString("executing")%>";
						break;
					case 'S':
						statusValue = "<%=bundleJsp.getString("sucExe")%>";
						break;
					case 'F':
						statusValue = "<%=bundleJsp.getString("failExe")%>";
						break;
					case 'P':
						statusValue = "<%=bundleJsp.getString("stopRun")%>";
						break;
					case 'C':
						statusValue = "<%=bundleJsp.getString("cancelExe")%>";
						break;
					case 'D':
						statusValue = "<%=bundleJsp.getString("disable")%>";
						break;
					default:
						break;
					}
					jQuery("#resultTab").setCell(ids[i],"taskStatus",statusValue);
					
					var message =  xhr.rows[i]['message'];
					if(taskStatus === 'F' && message != null && message.match(/error.log$/)){
						// jQuery("#resultTab").setCell(ids[i], "message", "<img src='<%=request.getContextPath()%>/img/download.jpg' alt='下载错误日志' title='下载错误日志' onclick=\"downloadErrLog('" + message + "')\" />");
						jQuery("#resultTab").setCell(ids[i], "message", "<a href='javascript:;' class='glyphicon glyphicon-download' alt='下载错误日志' title='下载错误日志' data-toggle='tooltip' data-placement='top' onclick=\"downloadErrLog('" + message + "')\"></a>");
					} else if (taskStatus != 'F' && taskStatus != 'C' && message != null) {
						jQuery("#resultTab").setCell(ids[i], "message", '');
					}
					
					var taskType = xhr.rows[i]['taskType'];
					var taskTypeValue = null;
					switch (taskType) {
					case 'TRANSFER':
						taskTypeValue = "<%=bundleJsp.getString("derivative")%>";
						break;
					case 'HDFS':
						taskTypeValue = "HDFS<%=bundleJsp.getString("operate")%>";
						break;						
					case 'MAPREDUCE':
						taskTypeValue = "Map Reduce<%=bundleJsp.getString("calculate")%>";
						break;
					case 'HIVE':
						taskTypeValue = "Hive<%=bundleJsp.getString("calculate")%>";
						break;
					case 'MYSQL':
						taskTypeValue = "MySQL<%=bundleJsp.getString("calculate")%>";
						break;
					case 'ORACLE':
						taskTypeValue = "Oracle<%=bundleJsp.getString("calculate")%>";
						break;
					case 'SHELL':
						taskTypeValue = "Shell<%=bundleJsp.getString("script")%>";
						break;
					case 'JAVA':
						taskTypeValue = "JAVA";
						break;
					case 'CACHE':
						taskTypeValue = "Memcached<%=bundleJsp.getString("operate")%>";
						break;
					case 'DEP':
						taskTypeValue = "<%=bundleJsp.getString("processDep")%>";
						break;
					case 'NOTIFY':
						taskTypeValue = "<%=bundleJsp.getString("noticeOpr")%>";
						break;
					case 'SPARKSQL':
						taskTypeValue = "Spark Sql";
						break;
					case 'SPARKJAR':
						taskTypeValue = "Spark Jar";
						break;
					default:
						break;
					}	
					
					jQuery("#resultTab").setCell(ids[i],"taskType",taskTypeValue);

					// 如果只有一条记录，就选第一条内容显示
					if(xhr.totalRecords == 1){
						$('#resultTab').find('tr').eq(1).dblclick();
					}
					$('[data-toggle="tooltip"]').tooltip()
				}
				$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
		    },
			ondblClickRow : function(rowid,iRow,iCol,e) {
				//流程图json表示
				var processId =  $('#resultTab').jqGrid("getCell",rowid,'processId');
				var execDate =  $('#resultTab').jqGrid("getCell",rowid,'execDate');
				queryProcOnExecDate(processId, execDate);
			},
			beforeRequest: function(){
				var page = $('#resultTab').getGridParam('page');
				if(page > 1){
					var totalPages = $('#resultTab').getGridParam('lastpage');
					if(page > totalPages){
						alert("<%=bundleJsp.getString("maxPage")%>" + totalPages + ",<%=bundleJsp.getString("equalPage")%>" + totalPages + "!");
						return false;
					}
				}
				
				return true;
			}			
		});
		
		$(window).bind('resize', function() {
			$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
		});
		
	});

	function queryProcOnExecDate(processId, execDate){
    	$.ajax({
    		type : "post",
    		url : "<%=request.getContextPath()%>/task/searchProcessOnExecDate.do",
    		async : false,
    		dataType : 'json',
    		data : {
    			processId : processId,
    			execDate : execDate
    		},
    		success : function(ret) {
    			// 出错提示
    			if (ret.err) {
    				alert(ret.err);
    			} else {
    				$('#taskJsonDef').val(ret.messages);
    				//iframe刷新
    				var iframeObj = (document.getElementById)?document.getElementById('pIframe'):document.all['pIframe'];
    				iframeObj.src = iframeObj.src;
    			}
    		},
    		error : function() {
    			// 出错提示
    			alert('System error!');
    		}
    	});    	
    }
	
	function downloadErrLog(fileName){
		window.location.href="<%=request.getContextPath()%>/task/downTaskErrLog.do?errFileName=" + fileName;
	}
</script>

<iframe id="pIframe" width="100%" src="<%=request.getContextPath()%>/views/task_draw.jsp" height="700" frameborder="0" scrolling="auto"></iframe>

<div id="query">
	<form id="taskSearchForm" method="post">
		<input type="hidden" name="action" value="TaskScheduleAction" /> <input
			type="hidden" name="event_submit_do_search" value="true" /> <input
			type="hidden" id="displayExt" value="simple" />
		<div id="J_formFull" class="search-content">
			<div class="search-title"><%=bundleJsp.getString("queryTask")%></div>
			<div class="search-form">
				<dl>
					<dt><%=bundleJsp.getString("process")%>ID:</dt>
					<dd>
						<input type="text" id="processId" name="processId" class="i-text" />
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("processName")%>:</dt>
					<dd>
						<input type="text" id="processName" name="processName" class="i-text" />
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("dataDate")%>:</dt>
					<dd>
						<input type="text" id="execDate" name="execDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
			</div>
			<div class="search-btn">
				<input type="button" onclick="query();" value="<%=bundleJsp.getString("query")%>" id="searchButton" class="btn btn-primary">
				<input id="formReset" type="reset" onclick="resetForm();" value="<%=bundleJsp.getString("reset")%>" class="btn btn-default">
				<input type="button" onclick="download();" value="<%=bundleJsp.getString("down")%>" class="btn btn-default">
			</div>
		</div>
	</form>
	
	<div class="tableWrap">
		<table id="resultTab"></table>
		<div id="pageDiv"></div>
		<div class="tableNoData hidden" id="TableNoData"><%=bundleJsp.getString("noData")%></div>
	</div>

	<!-- 向iframe传递任务json -->
	<input type="hidden" id="taskJsonDef">
	<input type="hidden" id="tableData">
</div>
<script type="text/javascript">
	$(function() {
		//日期控件注册
		$('#execDate').datepicker();
		
		//enter查询
	    $('body').live('keypress', function (e) {
		    if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
		    	$('#searchButton').click();
		    	return false;
		    } else {
		    	return true;
		    }	    
	    });		
	});
	

	//从其它页跳转过来,刷新页面 processId execDate在本页面进来时已经获取(line 4,5)
	var pageFromOther = false;
	//从流程实例页面跳转过来，刷新页面
	if (processId != 'null'){
		$("#processId").val(processId);
		$("#execDate").val(execDate);
		//更新表格数据
		var postData = {"processId":processId,"execDate":execDate};
		//查询任务执行信息
		queryParam=postData;
		
		//画执行图
		queryProcOnExecDate(processId,execDate);
		//标记从其它页跳转过来
		pageFromOther = true;
	}	
</script>
