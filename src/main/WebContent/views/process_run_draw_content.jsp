<%@page contentType = "text/html;charset=UTF-8" %> 
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

<div id="query">
	<div class="commonTitle">
		<h2><%=bundleJsp.getString("processRunQ")%></h2>
	</div>
	<form id="taskSearchForm" method="post">
		<div id="J_formFull" class="search-content">
			<div class="search-form">
				<div class="group">
					<dl>
						<dt><%=bundleJsp.getString("process")%>ID:</dt>
						<dd>
							<input type="text" id="processId" name="processId" class="i-text" />
						</dd>
					</dl>
					
					<dl>
						<dt><%=bundleJsp.getString("app")%>:</dt>
						<dd>
							<select id="processApp" name="processApp">
								<option value="" selected="selected"><%=bundleJsp.getString("option")%></option>
							</select>
						</dd>
					</dl>
					
					<dl>
						<dt><%=bundleJsp.getString("processName")%>:</dt>
						<dd>
							<input type="text" id="processName" name="processName" class="i-text" />
						</dd>
					</dl>
				</div>
				
				<div class="group">
					<dl>
						<dt><%=bundleJsp.getString("scheduleDate")%>:</dt>
						<dd>
							<input type="text" id="scheduleDate" name="scheduleDate" class="i-text i-text-time" readonly />
						</dd>
					</dl>
					<dl>
						<dt>
							<input type="radio" id="tRadio" onclick="setDate('T');" /><%=bundleJsp.getString("todayVer")%>
						</dt>
						<dt>
							<input type="radio" id="yRadio" onclick="setDate('Y');" /><%=bundleJsp.getString("yesVer")%>
						</dt>
					</dl>
				</div>
				
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
				
				<dl class="w2">
					<dt><%=bundleJsp.getString("founder")%>:</dt>
					<dd>
						<input type="text" id="createdBy" name="createdBy" class="i-text" />
						<input type="checkbox" id="createByMe" value=""/><%=bundleJsp.getString("myCreation")%>
					</dd>
				</dl>
			</div>
			
			<div class="search-btn">
				<input type="button" class="btn btn-primary" onclick="query();" value="<%=bundleJsp.getString("query")%>" id="searchButton"> 
				<input id="formReset" type="reset" class="btn btn-default" onclick="resetForm();" value="<%=bundleJsp.getString("reset")%>"> 
			</div>
		</div>
	</form>
	
	<div class="line line-gray"></div>

	<br/>
	<div id="locateDiv" style="display:none">
		<%=bundleJsp.getString("process")%>ID: <input id="toLocateId" type="text" class="i-text" />
		<input class="btn btn-primary" type="button" onclick="locateProcess()" value="<%=bundleJsp.getString("locate")%>"/>
	</div>
	<br/>

</div>

<div id="svgDiv" style="overflow-x: auto; margin: 50px 10px;"></div>
<div id="loading" style="display:none;">
	<%=bundleJsp.getString("noData")%>
</div>

<!-- 当前用户 -->
<input type="hidden" id="currentUserHidden" value="<%=AccessSession.getAccessUser(request.getSession()) %>" />

<script type="text/javascript">
window.DateBJ = new Date((new Date(<%=new java.util.Date().getTime()%>).getTime()+((new Date(<%=new java.util.Date().getTime()%>).getTimezoneOffset()+480)*60000))).getTime();
$(function() {
	// 根据后台配制绑定"应用名称"下拉框
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
	
	//创建人默认为当前用户
	$('#createByMe').attr("checked", true);
    $('#createdBy').val($('#currentUserHidden').val());
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

//查询SVG数据
function query(){
	var processId = $('#processId').val();
	var processName = $('#processName').val();
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
		autoOpen : false,
		modal : true,
		draggable : false,
		resizable : false,
		position : [ 'middle', 'center' ],
		width : 98,
		height : 98
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
				$svg.svgPan('viewport');
				
				$('#locateDiv').show();
			}
		}
	}); 
}

//注册右键上下文菜单
$(function(){
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
            	abortProcess(processId,execDate,processStatus);
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

//流程中止
function abortProcess(processId,execDate,processStatus){
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

//流程重跑（依赖）
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
        	node.attr({"stroke":"purple", "stroke-width":"10px"});
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

</script>