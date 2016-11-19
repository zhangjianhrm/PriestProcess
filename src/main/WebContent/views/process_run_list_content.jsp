<%@page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<!-- context menu -->
<script src="<%=request.getContextPath()%>/resources/script/jquery.ui.position.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery.contextMenu.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/screen.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/prettify/prettify.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery-svgpan.min.js" type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/resources/styles/jquery.contextMenu.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/script/prettify/prettify.sunburst.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
window.DateBJ = new Date((new Date(<%=new java.util.Date().getTime()%>).getTime()+((new Date(<%=new java.util.Date().getTime()%>).getTimezoneOffset()+480)*60000))).getTime();
$(function() {		
	var width = $(window).width() - $('#LeftBox').width() - 60;
	jQuery("#resultTab").jqGrid({
		url : "<%=request.getContextPath()%>/process/getProcessRuns.do",
		datatype : "local",
		colNames : [ "<%=bundleJsp.getString("shortPro")%>ID", "<%=bundleJsp.getString("processName")%>","<%=bundleJsp.getString("processState")%>","<%=bundleJsp.getString("app")%>","<%=bundleJsp.getString("founder")%>","<%=bundleJsp.getString("scheduleDate")%>","<%=bundleJsp.getString("scheduleTime")%>","<%=bundleJsp.getString("dataDate")%>","<%=bundleJsp.getString("startTime")%>","<%=bundleJsp.getString("endTime")%>" ,"<%=bundleJsp.getString("runDur")%>", "<%=bundleJsp.getString("runInfo")%>","<%=bundleJsp.getString("operate")%>"],
		colModel : [ {
			name : 'processId',
			index : 'process_id',
			width : 40,
			hidden : false,
			sorttype : 'int'
		}, 
		{
			name : 'processName',
			index : 'process_name',
			width : 100
		}, 
		{
			name : 'processStatus',
			index : 'process_status',
			width : 60
		},
		{
			name : 'processApp',
			index : 'processApp',
			width : 65,
			sortable : false,
			hidden : true
		},		
		{
			name : 'createdBy',
			index : 'created_by',
			width : 50
		},
		{
			name : 'scheduleDate',
			index : 'schedule_date',
			width : 80
		}, 
		{
			name : 'scheduleTime',
			index : 'schedule_time',
			width : 80
		},
		{
			name : 'execDate',
			index : 'exec_date',
			width : 68
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
			align : 'center',
			width : 60
		},
		{
			name : 'message',
			index : 'message',
			width : 60,
			align : 'center'
		},  
		{
			name : 'operator',
			index : 'operator',
			sortable : false,
			align : 'left',
			width : 180
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
		height: "100%",
		postData : {},
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
			
			if(xhr.rows != undefined && xhr.rows.length == 0){
				$('#TableNoData').removeClass('hidden');
				$('.ui-jqgrid').addClass('hidden');
				return;
			}else{
				$('#TableNoData').addClass('hidden');
				$('.ui-jqgrid').removeClass('hidden');
			}
			
			//生成操作列内容
			var ids = jQuery("#resultTab").getDataIDs();
			for(var i = 0;i<ids.length;i++){
				var processStatus = xhr.rows[i]['processStatus'];
				var statusValue;
				switch (processStatus) {
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
				case 'C':
					statusValue = "<%=bundleJsp.getString("cancelExe")%>";
					break;
				case 'D':
					statusValue = "<%=bundleJsp.getString("disable")%>";
					break;
				case 'H':
					statusValue = "<%=bundleJsp.getString("waitStartRun")%>";
					break;
				default:
					break;
				}
				jQuery("#resultTab").setCell(ids[i],"processStatus",statusValue);
				
				var message =  xhr.rows[i]['message'];
				if(processStatus === 'F' && message != null && message.match(/error.log$/)){
					//jQuery("#resultTab").setCell(ids[i], "message", "<img src='<%=request.getContextPath()%>/img/download.jpg' alt='<%=bundleJsp.getString("downErr")%>' title='<%=bundleJsp.getString("downErr")%>' onclick=\"downloadErrLog('" + message + "')\" />");

					jQuery("#resultTab").setCell(ids[i], "message", '<a href="javascript:;" class="glyphicon glyphicon-download" data-toggle="tooltip" data-placement="top" alt="<%=bundleJsp.getString("downErr")%>" title="<%=bundleJsp.getString("downErr")%>" onclick="downloadErrLog(\'' + message +'\');"></a>');
				} else if (processStatus != 'F' && processStatus != 'C' && message != null) {
					jQuery("#resultTab").setCell(ids[i], "message", ' ');
				}
				
				var execDate = xhr.rows[i]['execDate'];
				var processId = xhr.rows[i]['processId'];
				var scheduleDate = xhr.rows[i]['scheduleDate'];
				// var opeAnchor = "<img src='<%=request.getContextPath()%>/img/16/timer.png' alt='<%=bundleJsp.getString("hisDur")%>' title='<%=bundleJsp.getString("hisDur")%>' onclick=\"showHisTime(this, " + processId + ",'" + scheduleDate +"');\" />  ";

				
				var opeAnchor = '<a href="javascript:;" class="glyphicon glyphicon-time" alt="<%=bundleJsp.getString("hisDur")%>" title="<%=bundleJsp.getString("hisDur")%>" data-toggle="tooltip" data-placement="top" onclick="showHisTime(this, ' + processId + ',\'' + scheduleDate +'\');"></a>';
				
				var createdBy=xhr.rows[i]['createdBy'];
				var _processApp = ',' + xhr.rows[i]['processApp'] + ',';
				if ((createdBy == user || 'true' =='<%=AccessSession.getUserIsAdmin(request.getSession()) %>') && 
					processStatus != 'R'	
				){
					//opeAnchor += "<img src='<%=request.getContextPath()%>/img/16/start.png' alt='<%=bundleJsp.getString("rerun")%>' title='<%=bundleJsp.getString("rerun")%>' onclick=\"reRuns(" + processId + ",'"+ execDate + "')\" />" ;
					opeAnchor += '<a href="javascript:;" class="glyphicon glyphicon-repeat" alt="<%=bundleJsp.getString("rerun")%>" title="<%=bundleJsp.getString("rerun")%>" data-toggle="tooltip" data-placement="top" onclick="reRuns(' + processId + ',\''+ execDate + '\')"></a>';
				}
				
				// 内存排队 OR 正在执行流程，增加取消执行按键
				if (processStatus == 'Q' || processStatus === 'R' || processStatus === 'W'){
					//opeAnchor += "<img src='<%=request.getContextPath()%>/img/16/stop.png' alt='<%=bundleJsp.getString("stop")%>' title='<%=bundleJsp.getString("stop")%>' onclick=\"abortProcess(" + processId + ",'"+ execDate + "')\" />" ;
					opeAnchor += '<a href="javascript:;" class="glyphicon glyphicon-stop" alt="<%=bundleJsp.getString("stop")%>" title="<%=bundleJsp.getString("stop")%>" data-toggle="tooltip" data-placement="top" onclick="abortProcess(' + processId + ',\''+ execDate + '\')"></a>';
				}

				//opeAnchor += '<img src="<%=request.getContextPath()%>/img/16/edit.png" alt="<%=bundleJsp.getString("update")%>" title="<%=bundleJsp.getString("update")%>" onclick="gotoEdit('+ processId +')" />';
				opeAnchor += '<a href="javascript:;" class="glyphicon glyphicon-edit" alt="<%=bundleJsp.getString("update")%>" title="<%=bundleJsp.getString("update")%>" data-toggle="tooltip" data-placement="top" onclick="gotoEdit(' + processId + ')"></a>';
				// opeAnchor += '<a href="">查看依赖</a>';
				// opeAnchor += '<a href="">查看资源消耗</a>';
				//opeAnchor += '<img src="<%=request.getContextPath()%>/img/16/run_detail.png" alt="<%=bundleJsp.getString("exeDetail")%>" title="<%=bundleJsp.getString("exeDetail")%>" onclick="gotoExecuteDetail('+ processId +','+ execDate +')" />';
				opeAnchor += '<a href="javascript:;" class="glyphicon glyphicon-list-alt" alt="<%=bundleJsp.getString("exeDetail")%>" title="<%=bundleJsp.getString("exeDetail")%>" data-toggle="tooltip" data-placement="top" onclick="gotoExecuteDetail('+ processId +',\''+ execDate +'\')"></a>';
				
				//操作列生成"启用/停用"链接
				jQuery("#resultTab").setCell(ids[i],"operator",opeAnchor);

				$('[data-toggle="tooltip"]').tooltip()
			}
			
			$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
	    },
		ondblClickRow : function(rowid,iRow,iCol,e) {
			//流程id
			var processId = $('#resultTab').jqGrid("getCell",rowid,'processId');
            var execDate = $('#resultTab').jqGrid("getCell",rowid,'execDate');
            var detailURL = '<%=request.getContextPath()%>/views/task.jsp?click=prl&processId='+processId + '&execDate=' + execDate;

           // window.parent.document.getElementById('TaskList').style.display = 'none';
           // window.parent.document.getElementById('TaskDetail').style.display = '';

           // window.parent.document.getElementById('TaskId').value = processId;
           // window.parent.document.getElementById('TaskExecDate').value = execDate;
            
			
			window.parent.window.location.href = detailURL;
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

	$('.tabControl li').click(function(){
		$(this).addClass('current').siblings().removeClass('current');
		var _id = $(this).attr('control');
		$('.tableWrap').hide();
		$('#' + _id).show();
		query();
	})
});
</script>

<div id="query" style="position: relative;">
	<form id="taskSearchForm" method="post">
		<div id="J_formFull" class="search-content">
			<div class="search-title"><%=bundleJsp.getString("processRunQ")%></div>
			<div class="search-form">
				<dl>
					<dt><%=bundleJsp.getString("process")%> ID:</dt>
					<dd>
						<input type="text" id="processId" name="processId" class="i-text" />
					</dd>
				</dl>
				
				<dl class="isHide">
					<dt><%=bundleJsp.getString("app")%>:</dt>
					<dd>
						<select id="processApp" name="processApp">
						</select>
					</dd>
				</dl>
				
				<dl>
					<dt><%=bundleJsp.getString("processName")%>:</dt>
					<dd>
						<input type="text" id="processName" name="processName" class="i-text" />
					</dd>
				</dl>
				
				<dl>
					<dt><%=bundleJsp.getString("processState")%>:</dt>
					<dd>
						<select id="processStatus" name="processStatus">
							<option value="" selected="selected"><%=bundleJsp.getString("option")%></option>
							<option value="W"><%=bundleJsp.getString("waitExe")%></option>
							<option value="Q"><%=bundleJsp.getString("memQue")%></option>
							<option value="R"><%=bundleJsp.getString("executing")%></option>
							<option value="S"><%=bundleJsp.getString("sucExe")%></option>
							<option value="F"><%=bundleJsp.getString("failExe")%></option>
							<option value="C"><%=bundleJsp.getString("cancelExe")%></option>
						</select>
					</dd>
				</dl>
				
				<dl>
					<dt><%=bundleJsp.getString("scheduleDate")%>:</dt>
					<dd>
						<input type="text" id="scheduleDate" name="scheduleDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>

				<dl class="w2">
					<dt><%=bundleJsp.getString("founder")%>:</dt>
					<dd>
						<input type="text" id="createdBy" name="createdBy" class="i-text" />
						<input type="checkbox" id="createByMe" value="" /><label for="createByMe"><%=bundleJsp.getString("myCreation")%></label>
					</dd>
				</dl>
			</div>
			
			<div class="search-btn">
				<input type="button" onclick="query();" value="<%=bundleJsp.getString("query")%>" id="searchButton" class="btn btn-primary"> 
				<input id="formReset" type="reset" onclick="resetForm();" value="<%=bundleJsp.getString("reset")%>" class="btn btn-default">
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
		<div id="locateDiv">
			<%=bundleJsp.getString("process")%>ID: <input id="toLocateId" type="text" class="i-text" />
			<input class="btn btn-primary" type="button" onclick="locateProcess()" value="<%=bundleJsp.getString("locate")%>"/>
		</div>
		
		<div id="svgDiv" style="overflow-x: auto; margin: 50px 10px;"></div>
		<div id="loading" style="display:none;">
			<%=bundleJsp.getString("noData")%>
		</div>
		
		<!-- 当前用户 -->
		<input type="hidden" id="currentUserHidden" value="<%=AccessSession.getAccessUser(request.getSession()) %>" />
	</div>
	
</div>	

<!-- 当前用户 -->
<input type="hidden" id="currentUserHidden" value="<%=AccessSession.getAccessUser(request.getSession()) %>" />

<script type="text/javascript"> 
$(function() {
	//根据后台配制绑定"应用名称"下拉框
	bindAppSelect();	
	$('#createByMe').click(function(){
		if($(this).attr("checked")){
			$('#createdBy').val($('#currentUserHidden').val());
		}else{
			$('#createdBy').val("");
		}
	});
	
	//日期控件注册
	$('#scheduleDate').datepicker();
	//通过日期控件更改后,"今天版本与昨天版本radio清除"
	$('#scheduleDate').bind("change",function(){
		$('#tRadio , #yRadio').attr("checked",false);
	})
	//default today
	setDate('T');
	
	//更改创建人时,把我的创建勾去掉
	$('#createdBy').bind("change",function(){
		if($('#createByMe').attr("checked")){
			$('#createByMe').attr("checked",false);
		}
	});
	
	//enter查询
    $('body').live('keypress', function (e) {
	    if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
	    	$('#searchButton').click();
	    	return false;
	    } else {
	    	return true;
	    }	    
    });
	
	//默认创建人为当前用户
	$('#createByMe').attr("checked", true);
    $('#createdBy').val($('#currentUserHidden').val());

    $.contextMenu({
        selector: 'text', 
        callback: function(key, options) {
            //当前控件属性及值
            var props = $(this).parent();
            var processId = props.find("title").text().split(".")[0];
            var execDate = props.attr("id").split("_")[1];
            var processStatus = props.attr("id").split("_")[0];
            var detailURL = '<%=request.getContextPath()%>/views/task.jsp?click=tk&processId='+processId + '&execDate=' + execDate; 
        	
            switch(key){
            case 'abort':
            	abortProcessChart(processId,execDate,processStatus);
            	break;    
            case 'reRun':
            	window.reRuns(processId,execDate);
            	break;
            case 'detail':
            	window.location.href = detailURL;
            	break;
            }
        },
        items: {
        	"detail": {name: "<%=bundleJsp.getString("viewDetail")%>", icon: "info"},
        	"abort": {name: "<%=bundleJsp.getString("stopRun")%>", icon: "stop"},
        	"reRun": {name: "<%=bundleJsp.getString("processRerun")%>", icon: "start"},
        }
    });

    //双击进入任务详情页面
    $("text").live('dblclick', function(){
    	var props = $(this).parent();
        var processId = props.find("title").text().split(".")[0];
        var execDate = props.attr("id").split("_")[1];
        window.location.href = '<%=request.getContextPath()%>/views/task.jsp?click=tk&processId='+processId + '&execDate=' + execDate;
    });
    
    
    
	
});

//根据后台配制绑定"应用名称"下拉框
function bindAppSelect(){
  	var url = '<%=request.getContextPath()%>/config/getApps.do';
	$.ajax({
		type : "get",
		url : url,
		async : true,
		dataType : 'json',
		success : function(ret) {
			// 出错提示
			if (ret.err) {
				alert(ret.err);
			} else {
				var opts = eval(ret).list;
				if (opts && opts.length) {
					var selectElem = $('#processApp');
					for ( var idx = 0; idx < opts.length; idx++) {
						selectElem.append('<option value="' + opts[idx].value + '">' + opts[idx].name + '</option>');
					}    
				}
				query();
			}
		},
		error : function() {
			// 出错提示
			alert('System error!');
		}
	}); 
}

//昨天版本/今天版本选定后,设置日期
function setDate(clickFrom){
	var date = new Date(DateBJ);
	//昨天版本
	if (clickFrom == "Y"){
		date = new Date(Date.parse(date) - (86400000 * 1));
		$('#tRadio').attr("checked",false);
	}
	//今天版本
	else if (clickFrom == "T"){
		date = new Date(Date.parse(date));
		$('#yRadio').attr("checked",false);
	}
	
	var dateStr = date.getFullYear() + "-" +   (date.getMonth()+1) + "-" + (date.getDate());
	$('#scheduleDate').datepicker('setDate', dateStr);
}

var user='<%=AccessSession.getAccessUser(request.getSession()) %>';

function query(){
	if($('.tabControl li').eq(0).hasClass('current')){
		queryTable();
	}else{
		queryChart();
	}
}

//流程查询
function queryTable(){
	var processId = $('#processId').val().trim();
	var processName = $('#processName').val().trim();
	var processStatus = $('#processStatus').val();
    var createdBy = $('#createdBy').val();
	var scheduleDate = $('#scheduleDate').val();
	var processApp = $('#processApp').val();
	
	var digitPattern = /^\d+$/;
	if( processId != '' && (!digitPattern.test(processId) || processId<1)){
		alert("<%=bundleJsp.getString("proIdWarning")%>");
		$('#processId').focus();
		return false;
	}
	
	if (!scheduleDate){
		alert("<%=bundleJsp.getString("selScheduleDate")%>");
		$('#scheduleDate').focus();
		return false;
	}
	
	if (!processApp && 'true' != '<%=AccessSession.getUserIsAdmin(request.getSession()) %>'){
		alert('<%=bundleJsp.getString("selApp")%>');
		$('#processApp').focus();
		return false;
	}	
		
	//查询参数
	var postData = {"scheduleDate":scheduleDate,"processId":processId,"processName":processName,"processStatus":processStatus,"createdBy":createdBy,"processApp":processApp};
	//不绘图，取列表数据
	$.extend(postData, {"isDrawing":"N"});
	//每次查询重置页数为1
	$("#resultTab").setGridParam({page : 1});
	if ( $.History ){
    	$.History.record( postData ) ;
	}
	//查询任务执行信息
	reloadTable(postData);
}

function reloadTable(postData) {
	if (postData) {
		$("#resultTab").setGridParam({
			postData : postData
		});
	}
	$("#resultTab").setGridParam({
		datatype : 'json'
	}).trigger('reloadGrid');
}

//查询SVG数据
function queryChart(){
	var processId = $('#processId').val().trim();
	var processName = $('#processName').val().trim();
	var processStatus = $('#processStatus').val();
    var createdBy = $('#createdBy').val();
	var scheduleDate = $('#scheduleDate').val();
	var processApp = $('#processApp').val();
	
	var digitPattern = /^\d+$/;
	if( processId != '' && (!digitPattern.test(processId) || processId<1)){
		alert("<%=bundleJsp.getString("proIdWarning")%>");
		$('#processId').focus();
		return false;
	}
	
	if (!scheduleDate){
		alert("<%=bundleJsp.getString("selScheduleDate")%>");
		$('#scheduleDate').focus();
		return false;
	}
	
	if (!processApp && 'true' != '<%=AccessSession.getUserIsAdmin(request.getSession()) %>'){
		alert('<%=bundleJsp.getString("selApp")%>');
		$('#processApp').focus();
		return false;
	}	
	
	//查询参数
	var postData = {"scheduleDate":scheduleDate,"processId":processId,"processName":processName,"processStatus":processStatus,"createdBy":createdBy,"processApp":processApp};
	//默认按开始时间倒序排
	$.extend(postData, {"sidx":"start_time","sord":"desc"});
	//绘图标志
	$.extend(postData, {"isDrawing":"Y"});
	if ( $.History ){
    	$.History.record( postData ) ;
	}
	draw(postData);
}

//绘图
function draw(postData){
	var $loading = $('#loading');
	$loading.dialog({
		dialogClass: 'dialogLoading',
		autoOpen : false,
		modal : true,
		draggable : false,
		resizable : false,
		position : [ 'middle', 'center' ],
		width : 100,
		height : 100,
		minWidth: 100,
		minHight: 100
	}).dialog('widget').find('.ui-dialog-titlebar').hide();
	$loading.dialog('open');
	
	$.ajax({
		type : "post",
		url : "<%=request.getContextPath()%>/process/getProcessRuns.do",
		async : true,
		dataType : 'json',
		data : postData,
		success : function(ret) {
			$loading.dialog("close");
			
			// 出错提示
			if (ret.err) {
				alert(ret.err);
			} else {
				var $svgDiv = $('#svgDiv');
				
				$svgDiv.html(ret.svgData);
				
				var $svg = $('svg');
				if($svg.width() < $svgDiv.width()){
					$svg.width($svgDiv.width());
				}
				if($svg.height() < $svgDiv.height()){
					$svg.height($svgDiv.height());
				}
				
				$svg.svgPan($svg.find('.graph').attr('id'));
				
				
				$('#locateDiv').show();
			}
		}
	}); 
}


//流程下载
function download(){
	var processId =$('#processId').val();
	var processName = $('#processName').val();
       var createdBy = $('#createdBy').val();
	var scheduleDate = $('#scheduleDate').val();
	var processApp = $('#processApp').val();
	var sidx=jQuery("#resultTab").getGridParam('sortname');
       var sord=jQuery("#resultTab").getGridParam('sortorder');
	window.location.href="<%=request.getContextPath()%>/process/processExcel.do?scheduleDate=" + scheduleDate+"&processName="+processName+"&processId="+processId+"&createdBy="+createdBy+"&processApp="+processApp+"&sidx="+sidx+"&sord="+sord;
}

//流程运行时长历史
function showHisTime(obj, processId, scheduleDate){
	window.location.href="<%=request.getContextPath()%>/views/run_time_history.jsp?click=rth&processId=" + processId + "&scheduleDate=" + scheduleDate;
}

//流程<%=bundleJsp.getString("rerun")%>（依赖）
function reRuns(processId,execDate){
var msg = '<%=bundleJsp.getString("sureProRun")%>';
	    	$.ajax({
	    		type : "post",
	    		url : '<%=request.getContextPath()%>/process/checkRerunProcess.do',
	    		async : false,
	    		dataType : 'json',
	    		data : {
	    			processId : processId,
	    			execDate : execDate
	    		},
	    		success : function(ret) {
	    			// 出错提示
	    			if (ret.suc) {
						msg = ret.suc+'<%=bundleJsp.getString("sureCheckProRun")%>';
	    			}
	    		}
	    	});
		if(confirm(msg)){
			var url = '<%=request.getContextPath()%>/process/rerunProcesses.do';
	    	$.ajax({
	    		type : "post",
	    		url : url,
	    		async : true,
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
						alert('<%=bundleJsp.getString("rerunSuc")%>');
	    			}
	    		},
	    		error : function() {
	    			// 出错提示
	    			alert('System error!');
	    		}
	    	}); 			
		}
}
//流程<%=bundleJsp.getString("rerun")%>（依赖）
function reRunFails(){
if(confirm('<%=bundleJsp.getString("sureRerunRails")%>')){
			//流程查询
	var processId = $('#processId').val().trim();
	var processName = $('#processName').val().trim();
	var processStatus = $('#processStatus').val();
    var createdBy = $('#createdBy').val();
	var scheduleDate = $('#scheduleDate').val();
	var processApp = $('#processApp').val();
	
	var digitPattern = /^\d+$/;
	if( processId != '' && (!digitPattern.test(processId) || processId<1)){
		alert("<%=bundleJsp.getString("proIdWarning")%>");
		$('#processId').focus();
		return false;
	}
	
	if (!scheduleDate){
		alert("<%=bundleJsp.getString("selScheduleDate")%>");
		$('#scheduleDate').focus();
		return false;
	}
	
	if (!processApp && 'true' != '<%=AccessSession.getUserIsAdmin(request.getSession()) %>'){
		alert('<%=bundleJsp.getString("selApp")%>');
		$('#processApp').focus();
		return false;
	}	
		
	//查询参数
	var postData = {"scheduleDate":scheduleDate,"processId":processId,"processName":processName,"processStatus":processStatus,"createdBy":createdBy,"processApp":processApp};
	var url = '<%=request.getContextPath()%>/process/rerunProcessFails.do';
	    	$.ajax({
	    		type : "post",
	    		url : url,
	    		async : true,
	    		dataType : 'json',
	    		data : postData,
	    		success : function(ret) {
	    			// 出错提示
	    			if (ret.err) {
	    				alert(ret.err);
	    			} else {
						alert('<%=bundleJsp.getString("rerunSuc")%>');
						//不绘图，取列表数据
						$.extend(postData, {"isDrawing":"N"});
						//每次查询重置页数为1
						$("#resultTab").setGridParam({page : 1});
						if ( $.History ){
    						$.History.record( postData ) ;
						}
						//查询任务执行信息
						reloadTable(postData);
	    			}
	    		},
	    		error : function() {
	    			// 出错提示
	    			alert('System error!');
	    		}
	    	});
		}
}

function downloadErrLog(fileName){
	window.location.href="<%=request.getContextPath()%>/process/downProcessErrLog.do?errFileName=" + fileName;
}

//<%=bundleJsp.getString("stop")%>流程运行
function abortProcess(processId, execDate){
	var ids = "";
	var size = 0;
	$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/process/getProcessChildrenIds.do",
			async : false,
			dataType : "json",
			data : {
				processId : processId
			},
			success : function(ret) {
				     //出错
				     if (ret.err){
				    	 alert(ret.err);
				    	 return;
				     }
					ids = ret.ids;
					size = ret.size;
				    
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		});	
	var msg = "<%=bundleJsp.getString("sureProStopR")%>";
	if (ids != "") {
		msg = "<%=bundleJsp.getString("sureWaitCancel1")%>" + size + "<%=bundleJsp.getString("sureWaitCancel2")%>" + ids + "<%=bundleJsp.getString("sureWaitCancel3")%>";
	}
	if (confirm(msg)){
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/process/abortProcess.do",
			async : true,
			dataType : "json",
			data : {
				processId : processId,
				execDate : execDate
			},
			success : function(ret) {
				     //出错
				     if (ret.err){
				    	 alert(ret.err);
				    	 return;
				     }
					
				    alert("<%=bundleJsp.getString("submitStop")%>");
					query();
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		});				
	}
}

// 流程<%=bundleJsp.getString("stop")%>
function abortProcessChart(processId,execDate,processStatus){
	if (confirm("<%=bundleJsp.getString("sureProStop")%>")){
	    switch(processStatus){
	    case 'Q':
		case 'R':
			if(confirm('<%=bundleJsp.getString("sureProStopR")%>')){
				$.ajax({
					type : "post",
					url : "<%=request.getContextPath()%>/process/abortProcess.do",
					async : true,
					dataType : "json",
					data : {
						processId : processId,
						execDate : execDate
					},
					success : function(ret) {
						     //出错
						     if (ret.err){
						    	 alert(ret.err);
						    	 return;
						     }
							
						    alert("<%=bundleJsp.getString("submitStop")%>");
					},
					error : function() {
						// 出错提示
						alert('System error!');
					}
				});	
			}
			break;
		case 'W':				
		case 'S':
		case 'F':
		case 'C':
			alert('<%=bundleJsp.getString("onlyProStop")%>');
			break;
	    }
	}
}	

function locateProcess(){
	var toLocateId = $('#toLocateId').val();
	//校验是否为空
	if(toLocateId == ''){
		alert("<%=bundleJsp.getString("selLocation")%>");
		$('#toLocateId').focus();
		return false;
	}
	
	//校验是否为大于0的数字
	if(!/^\d+$/.test(toLocateId) || toLocateId < 1){
		alert("<%=bundleJsp.getString("locateNum")%>");
		$('#toLocateId').focus();
		return false;
	}
	
	$('#locateId').attr("stroke", "").removeAttr("id");
	var idExist = false;
	$('text').each(function(){
		var props = $(this).parent();
        var processId = props.find("title").text().split(".")[0];
        if(toLocateId === processId){
        	idExist = true;
        	var node = props.find("ellipse").attr("id", "locateId");
        	node.attr({'fill': '#d9534f', "stroke": "red", "stroke-width":"4px", 'opacity': '0.5'});
        	moveGraph(props);
        } 
	});
	if(!idExist){
		alert("<%=bundleJsp.getString("selLocate")%>");
		$('#toLocateId').val("").focus();
		return false;
	}
}

function moveGraph(props){
	var g = $('#viewport')[0];
	var stateTf = g.getCTM().inverse();
	var start = getObjPoint(props).matrixTransform(stateTf);
	var end = getObjPoint($('#svgDiv')).matrixTransform(stateTf);
	
	var matrix = stateTf.inverse().translate(end.x - start.x + 10, end.y - start.y + 10);
	g.setAttribute("transform", "matrix(" + matrix.a + "," + matrix.b + "," + matrix.c + "," + matrix.d + "," + matrix.e + "," + matrix.f + ")");
}

function getObjPoint(obj) {
	var point = $('svg')[0].createSVGPoint();
	
	var offset = obj.offset();
	point.x = offset.left;
	point.y = offset.top;

	return point;
}

//<%=bundleJsp.getString("update")%>流程跳转
function gotoEdit(processId){
	var detailURL = '<%=request.getContextPath()%>/views/process_edit.jsp?click=pde&fromlist=1&processId=' + processId;  
    window.parent.window.location.href = detailURL;
}

// 查看<%=bundleJsp.getString("exeDetail")%>跳转
function gotoExecuteDetail(processId, execDate){
    var detailURL = '<%=request.getContextPath()%>/views/task.jsp?click=prl&processId='+processId + '&execDate=' + execDate;
	window.parent.window.location.href = detailURL;
}
</script>
