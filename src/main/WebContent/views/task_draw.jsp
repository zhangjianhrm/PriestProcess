<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.Locale"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	Locale localeJsp = AccessSession.getLocale(request);
	String localeTypeJsp = localeJsp.getLanguage().toLowerCase();
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", localeJsp);
%>
<script type="text/javascript">
window.i18nValue="<%=localeTypeJsp%>";
</script>

<link type="text/css" href="<%=request.getContextPath()%>/resources/styles/main.css" rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/styles/jquery-ui-1.8.4.custom.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/raphael-min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery-ui-1.8.4.custom.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery.i18n.properties-min-1.0.9.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery.json-2.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/myflow.js?20160908"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/myflow.editors.js?20160908"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/myflow.jpdl4.js?20160908"></script>

<!-- ui time -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/mobiscroll-2.0.1.full.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/mobiscroll-2.0.1.full.min.js"></script>

<!-- context menu -->
<script src="<%=request.getContextPath()%>/resources/script/jquery.ui.position.js" type="text/javascript" ></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery.contextMenu.js" type="text/javascript" ></script>
<script src="<%=request.getContextPath()%>/resources/script/screen.js" type="text/javascript" ></script>
<script src="<%=request.getContextPath()%>/resources/script/prettify/prettify.js" type="text/javascript" ></script>

<link href="<%=request.getContextPath()%>/resources/styles/jquery.contextMenu.css" rel="stylesheet" type="text/css" />
<!--<link href="<%=request.getContextPath()%>/resources/styles/screen.css" rel="stylesheet" type="text/css" /> -->
<link href="<%=request.getContextPath()%>/resources/script/prettify/prettify.sunburst.css" rel="stylesheet" type="text/css" />	
<script src="<%=request.getContextPath()%>/resources/script/bootstrap.min.js" type="text/javascript" ></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-ui-timepicker-addon.min.js"></script>

<style type="text/css">
#ui-datepicker-div{display:none}
.ui-dialog .ui-dialog-buttonpane button{display: inline-block; height: 28px; border: 1px solid #f3f3f3; padding: 0 15px;}
.ui-dialog .ui-dialog-buttonpane button:hover{ border-color: #ccc;}
</style>
<script type="text/javascript">
window.DateBJ = new Date((new Date(<%=new java.util.Date().getTime()%>).getTime()+((new Date(<%=new java.util.Date().getTime()%>).getTimezoneOffset()+480)*60000))).getTime();
//增加属性editor
function addItem(dom,key,value){
	var n = parseInt(new Date(DateBJ).getTime() / 1000);
	$(dom).append('<tr id="'+n+'" class="itemList"><td><input type="text" value="' + key + '" class="keyClass"/> = </td><td><input type="text" value="' + value + '" class="valueClass"/></td><td></td></tr>');
}	

	$(function() {
		//jquery ui datepicker中文设置
		$.datepicker.regional['zh-CN'] = {
			closeText : '<%=bundleJsp.getString("close")%>',
			prevText : '<<%=bundleJsp.getString("lastMonth")%>',
			   nextText: '<%=bundleJsp.getString("nextMonth")%>>',
			currentText : '<%=bundleJsp.getString("today")%>',
			monthNames : [ '<%=bundleJsp.getString("january")%>', '<%=bundleJsp.getString("february")%>', '<%=bundleJsp.getString("march")%>', '<%=bundleJsp.getString("april")%>', '<%=bundleJsp.getString("may")%>', '<%=bundleJsp.getString("june")%>', '<%=bundleJsp.getString("july")%>', '<%=bundleJsp.getString("august")%>', '<%=bundleJsp.getString("september")%>', '<%=bundleJsp.getString("october")%>', '<%=bundleJsp.getString("november")%>', '<%=bundleJsp.getString("december")%>' ],
			monthNamesShort : [ '<%=bundleJsp.getString("jan")%>', '<%=bundleJsp.getString("feb")%>', '<%=bundleJsp.getString("mar")%>', '<%=bundleJsp.getString("apr")%>', '<%=bundleJsp.getString("may")%>', '<%=bundleJsp.getString("jun")%>', '<%=bundleJsp.getString("jul")%>', '<%=bundleJsp.getString("aug")%>', '<%=bundleJsp.getString("sep")%>', '<%=bundleJsp.getString("oct")%>', '<%=bundleJsp.getString("nov")%>', '<%=bundleJsp.getString("dec")%>' ],
			dayNames : [ '<%=bundleJsp.getString("sunday")%>', '<%=bundleJsp.getString("monday")%>', '<%=bundleJsp.getString("tuesday")%>', '<%=bundleJsp.getString("wednesday")%>', '<%=bundleJsp.getString("thursday")%>', '<%=bundleJsp.getString("friday")%>', '<%=bundleJsp.getString("saturday")%>' ],
			dayNamesShort : [ '<%=bundleJsp.getString("sun")%>', '<%=bundleJsp.getString("mon")%>', '<%=bundleJsp.getString("tue")%>', '<%=bundleJsp.getString("wed")%>', '<%=bundleJsp.getString("thu")%>', '<%=bundleJsp.getString("fri")%>', '<%=bundleJsp.getString("sat")%>' ],
			dayNamesMin : ['<%=bundleJsp.getString("sunMin")%>', '<%=bundleJsp.getString("monMin")%>', '<%=bundleJsp.getString("tueMin")%>', '<%=bundleJsp.getString("wedMin")%>', '<%=bundleJsp.getString("thuMin")%>', '<%=bundleJsp.getString("friMin")%>', '<%=bundleJsp.getString("satMin")%>' ],
			weekHeader : '<%=bundleJsp.getString("week")%>',
			dateFormat : 'yy-mm-dd',
			firstDay : 1,
			isRTL : false,
			showMonthAfterYear : true,
			yearSuffix : '<%=bundleJsp.getString("year")%>'
		};
		$.datepicker.setDefaults($.datepicker.regional['zh-CN']);

		$('#popupDialog').bind("click", function() {
			//用户在弹出框在输入完数据,或者选择cancel放弃输入时,会触发画板的click事件
			$(window).data("popupClick", "aa");
		});
		
		$('#popupPropertyDialog').bind("click", function() {
			//用户在弹出框在输入完数据,或者选择cancel放弃输入时,会触发画板的click事件
			$(window).data("popupClick", "aa");
		});				

		$('#fileUploadDiv').bind("click", function() {
			//用户在弹出框在输入完数据,或者选择cancel放弃输入时,会触发画板的click事件
			$(window).data("popupClick", "aa");
		});

		//弹出输入框
		$('#popupDialog').dialog(
				{
					modal : true,
					autoOpen : false,
					position : [ 'right', 'top' ],
					title : 'Input please',
					width : 500,
					height : 600,
					buttons : {
						'Cancel' : function() {
							$(window).data("popupClick", "aa");
							$(this).dialog('close');

						},
						'Ok' : function() {
							$(window).data("popupClick", "aa");

							//保存输入值
							$($(this).data('clickInput')).val(
									$(this).find('#widgetName').val());
							
							//调用change事件,通知控件值改变
							$($(this).data('clickInput')).change();

							$(this).dialog('close');

							//清除
							$(this).data('clickInput', null);
						}
					}
				});
		
		//弹出属性框
		$('#popupPropertyDialog').dialog(
				{
					modal : true,
					autoOpen : false,
					position : [ 'right', 'top' ],
					title : 'Input please',
					width : 500,
					height : 600,
					buttons : {
						'Cancel' : function() {
							$(window).data("popupClick", "aa");
							$(this).dialog('close');

						},
						'Ok' : function() {
							$(window).data("popupClick", "aa");

							//job参数
							var jobProperties = '';
							$('.itemList').each(function(){
								var key = $(this).find('.keyClass').val();
								var value= $(this).find('.valueClass').val();
								
								if(key){
									jobProperties +=  key + '=' + value + '\r\n';
								}
							});
							
							//保存输入值
							$($(this).data('clickInput')).val(jobProperties);

							//调用change事件,通知控件值改变
							$($(this).data('clickInput')).change();

							$(this).dialog('close');

							//清除
							$(this).data('clickInput', null);
						}
					}
				});			
		
		var taskJsonDefStr = (document.getElementById)? parent.document.getElementById('taskJsonDef').value:parent.document.all['taskJsonDef'].value;

		var taskJsonDef;
		if (taskJsonDefStr){
			taskJsonDef = eval('(' + taskJsonDefStr + ')');
		}
		
		//流程绘制
		$('#myflow')
				.myflow(
						{
							basePath: "",
							restore: taskJsonDef,
							tools: {
								save : {
									onclick : function(data) {
										alert(data);
									}
								}
							}
						});

		//文件上传
		$('#fileUploadDiv').dialog({
					modal : true,
					autoOpen : false,
					position : [ 'right', 'top' ],
					title : 'Select file please',
					width : 350,
					height : 180,
					buttons : {
						'Cancel' : function() {
							$(window).data("popupClick", "aa");
							$(this).dialog('close');
						},
						'Ok' : function() {
							$(window).data("popupClick", "aa");
							//保存输入值
							$($(this).data('fileInput')).val(
									$(this).find('#uploadFile').val());

							$(this).dialog('close');

							//清除
							$(this).data('fileInput', null);
						}
					}
				});
	});
</script>
<style type="text/css">
select, input {
	display: inline-block;
	height: 28px;
	padding: 3px 4px;
	font-size: 13px;
	line-height: 20px;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #d9e2eb;
    border-radius: 2px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
}

textarea {
	height: 50px;
	border-radius: 0;
	border: 1px solid #d9e2eb;
}

input[disabled], select[disabled], textarea[disabled], input[readonly],
	select[readonly], textarea[readonly] {
	border: 1px solid #d9e2eb
}

textarea:focus, input:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 5px
		rgba(102, 175, 233, .5);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 5px
		rgba(102, 175, 233, .5);
}

.ui-widget-content.tool {
	background: #fff;
	border: 1px solid #ddd;
	box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .1);
}
.ui-widget-header.tool{ position: relative; height: 24px; margin-bottom: 5px; background: #4e9bd7; border: 0; line-height: 24px; color: #fff;}
.node {
	width: 80px;
	text-align: left;
	vertical-align: middle;
	border: 1px solid #fff;
}

.mover {
	border: 1px solid #ddd;
	background-color: #ddd;
}

.selected {
	background-color: #ddd;
}

.state {
	
}
ul .disabled {
    background-color: #eee;
    color: #eee;
    display:none ;
}
#myflow_props th {
	width: 55px;
	text-align: left;
	padding: 4px 5px;
	font-weight: normal;
	color: #165c9d;
	font-size: 13px;
}

#myflow_props td {
	padding: 4px 5px;
}

#pointer {
	background-repeat: no-repeat;
	background-position: center;
}

#path {
	background-repeat: no-repeat;
	background-position: center;
}

#task {
	background-repeat: no-repeat;
	background-position: center;
}

#state {
	background-repeat: no-repeat;
	background-position: center;
}

body {
	overflow-x: hidden;
	overflow-y: hidden;
}
.ui-widget-header.tool.myflowToolHeader{ cursor: move; height: 30px; line-height: 30px; text-align: center; font-size: 14px;}
.modal-backdrop {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 1040;
  background-color: #000000;
}

.modal-backdrop.fade {
  opacity: 0;
}

.modal-backdrop,
.modal-backdrop.fade.in {
  opacity: 0.8;
  filter: alpha(opacity=80);
}

.modal {
  position: fixed;
  top: 10%;
  bottom: auto;
  left: 50%;
  z-index: 1050;
  width: 560px;
  margin-left: -280px;
  background-color: #ffffff;
  border: 1px solid #999;
  border: 1px solid rgba(0, 0, 0, 0.3);
  *border: 1px solid #999;
  -webkit-border-radius: 6px;
     -moz-border-radius: 6px;
          border-radius: 6px;
  outline: none;
  -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
     -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
          box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
  -webkit-background-clip: padding-box;
     -moz-background-clip: padding-box;
          background-clip: padding-box;
}

.modal.fade {
  top: -25%;
  -webkit-transition: opacity 0.3s linear, top 0.3s ease-out;
     -moz-transition: opacity 0.3s linear, top 0.3s ease-out;
       -o-transition: opacity 0.3s linear, top 0.3s ease-out;
          transition: opacity 0.3s linear, top 0.3s ease-out;
}

.modal.fade.in {
  top: 10%;
}

.modal-header {
	border: 0; background: #4e9bd7; color: #222222; font-weight: bold; color: #fff;
}

.modal-header .close {
  margin-top: 2px;
}
.modal-header button {
	float: right;
    width: 30px;
    background: none;
    border: 0;
    font-size: 24px;
    height: 24px;
    line-height: 0;
    color: #fff;
}

.modal-header h3 {
  margin: 0;
  line-height: 30px;
  text-align: center;
}

.modal-body {
  position: relative;
  max-height: 400px;
  padding: 15px;
  overflow-y: auto;
}

.modal-form {
  margin-bottom: 0;
}

.modal-footer {
  padding: 14px 15px 15px;
  margin-bottom: 0;
  text-align: right;
  background-color: #f5f5f5;
  border-top: 1px solid #ddd;
  -webkit-border-radius: 0 0 6px 6px;
     -moz-border-radius: 0 0 6px 6px;
          border-radius: 0 0 6px 6px;
  *zoom: 1;
  -webkit-box-shadow: inset 0 1px 0 #ffffff;
     -moz-box-shadow: inset 0 1px 0 #ffffff;
          box-shadow: inset 0 1px 0 #ffffff;
}

.modal-footer:before,
.modal-footer:after {
  display: table;
  line-height: 0;
  content: "";
}

.modal-footer:after {
  clear: both;
}

.modal-footer .btn + .btn {
  margin-bottom: 0;
  margin-left: 5px;
}

.modal-footer .btn-group .btn + .btn {
  margin-left: -1px;
}

.modal-footer .btn-block + .btn-block {
  margin-left: 0;
}

.modalLoad {
  position: absolute;
  top: 26%;
  left: 75%;
  z-index: 1050;
  width: 160px;
  margin-left: -280px;
  background-color: #ffffff;
  border: 1px solid #999;
  border: 1px solid rgba(0, 0, 0, 0.3);
  *border: 1px solid #999;
  -webkit-border-radius: 6px;
     -moz-border-radius: 6px;
          border-radius: 6px;
  outline: none;
  -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
     -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
          box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
  -webkit-background-clip: padding-box;
     -moz-background-clip: padding-box;
          background-clip: padding-box;
}

.modalLoad-body {
  position: relative;
  max-height: 400px;
  padding: 8px;
  overflow-y: auto;
}
</style>

<!-- 工具栏 -->
<div id="myflow_tools"
	style="position: absolute; left: 1px; background-color: #fff; width: 80px; cursor: default; padding: 3px;visibility:hidden;"
	class="ui-widget-content tool">
	<div id="myflow_tools_handle" style="text-align: center;"
		class="ui-widget-header"><%=bundleJsp.getString("componentSet")%></div>

	<div class="node" id="myflow_save">
		<img src="../resources/img/save.gif" />&nbsp;&nbsp;<%=bundleJsp.getString("save")%>
	</div>
	<div>
		<hr />
	</div>
	<div class="node selectable" id="pointer">
		<img src="../resources/img/select16.gif" />&nbsp;&nbsp;<%=bundleJsp.getString("opt")%>
	</div>
	<div class="node selectable" id="path">
		<img src="../resources/img/16/flow_sequence.png" />&nbsp;&nbsp;<%=bundleJsp.getString("line")%>
	</div>
	<div>
		<hr />
	</div>
	<div class="node state" id="start" type="start">
		<img src="../resources/img/16/start_event_empty.png" />&nbsp;&nbsp;<%=bundleJsp.getString("start")%>
	</div>
	<div class="node state" id="end" type="end">
		<img src="../resources/img/16/end_event_terminate.png" />&nbsp;&nbsp;<%=bundleJsp.getString("end")%>
	</div>
    <!--  
	<div class="node state" id="fork" type="fork">
		<img src="../resources/img/16/gateway_parallel.png" />&nbsp;&nbsp;并发
	</div>
	-->	
	<div class="node state" id="judge" type="judge">
		<img src="../resources/img/16/gateway_exclusive.png" />&nbsp;&nbsp;<%=bundleJsp.getString("branch")%>
	</div>	
	<div class="node state" id="join" type="join">
		<img src="../resources/img/16/gateway_parallel.png" />&nbsp;&nbsp;<%=bundleJsp.getString("merger")%>
	</div>
	<div>
		<hr />
	</div>
	<div class="node state" id="transfer" type="transfer">
		<img src="../resources/img/16/sqoop.jpg" />&nbsp;&nbsp;<%=bundleJsp.getString("derivative")%>
	</div>
	<div class="node state" id="hdfs" type="hdfs">
		<img src="../resources/img/16/hadoop.jpg" />&nbsp;&nbsp;Hdfs
	</div>
	<div class="node state" id="mapreduce" type="mapreduce">
		<img src="../resources/img/16/mr.jpg" />&nbsp;&nbsp;M/R
	</div>
	<div class="node state" id="hive" type="hive">
		<img src="../resources/img/16/hive.jpg" />&nbsp;&nbsp;Hive
	</div>
	<div class="node state" id="sparkjar" type="sparkjar">
		<img src="../resources/img/16/spark.png" />&nbsp;&nbsp;SparkJar
	</div>
	<div class="node state" id="sparksql" type="sparksql">
		<img src="../resources/img/16/spark.png" />&nbsp;&nbsp;SparkSql
	</div>
	<div class="node state" id="mysql" type="mysql">
		<img src="../resources/img/16/mysql.jpg" />&nbsp;&nbsp;Mysql
	</div>
	<div class="node state" id="shell" type="shell">
		<img src="../resources/img/16/shell.jpg" />&nbsp;&nbsp;Shell
	</div>
	<div class="node state" id="java" type="java">
		<img src="../resources/img/16/java.jpg" />&nbsp;&nbsp;Java
	</div>
	<div class="node state" id="cache" type="cache">
		<img src="../resources/img/16/memcached.jpg" />&nbsp;&nbsp;Cache
	</div>
	<div class="node state" id="dep" type="dep">
		<img src="../resources/img/16/task_wait.png" />&nbsp;&nbsp;<%=bundleJsp.getString("depend")%>
	</div>
</div>

<!-- 流程绘制区 -->
<div id="myflow"
	style="position: absolute; left: 50px; top: 10px; width: 100%; height: 100%;"></div>

<!-- 属性区 -->
<div id="myflow_props"
	style="position: absolute; right: 10px; top: 5px; width: 280px; padding: 3px;"
	class="ui-widget-content tool">
	<div id="myflow_props_handle" class="ui-widget-header" style="cursor:move; height: 30px; padding-left: 10px; line-height: 30px; text-align: center; font-size: 14px;"><%=bundleJsp.getString("property")%></div>
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	</table>
	<div>&nbsp;</div>
</div>

<!-- 弾出输入框 -->
<div id="popupDialog">
	<textarea rows="100" cols="100" id="widgetName" style="width: 475px; height: 480px;"></textarea>
</div>

<!-- 弾出属性编辑框 -->
<div id="popupPropertyDialog">
	<h2><%=bundleJsp.getString("inputPara")%>:</h2>
	<div style="overflow:hidden; border-bottom:1px solid #D7EAE2 ">
		<table cellspacing="0" cellpadding="0" border="0">
			<tbody><tr>
				<td valign="top" style=" width:600px; border-right:1px solid #D7EAE2 ">
					<div style="height:400px; overflow-y:auto">
						<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable" >
						</table>
					</div>
				</td>
			</tr></tbody>
	  </table>	
	</div>
</div>


<!-- 弹出文件上传 -->
<div id="fileUploadDiv">
	<form id="fileUpload" action="">
		<input type="file" id="uploadFile" name="mrJar" />
	</form>
</div>

<!-- 弹出实时日志 -->
<div id="runningLog" class="modal hide fade">
	<div class="modal-header">
    	<button type="button" data-dismiss="modal" onclick="closeLogs();" aria-hidden="true" >&times;</button>
    	<h3 id="logTitle"></h3>
  	</div>
  <div class="modal-body" id = "logBody">
  		<div id="loading" class="modalLoad" style="display:none;">
  			<%=bundleJsp.getString("noData")%>
		</div>
  		<p id="logs"></p>
  </div>
</div>





<script>
	var timeOutVar, proIdVar, execDateVar, taskIdVar, jobIdVar;
    function closeLogs() {
    	clearInterval(timeOutVar);
    }
    function getLogs() {
    	$('#loading').css('display', '');
    	$.ajax({
    		type : "post",
    		url : '<%=request.getContextPath()%>/process/getRunningLog.do',
    		async : false,
    		data:{
				'processId' : proIdVar,
				'execDate' : execDateVar,
				'jobId' : jobIdVar,
				'taskId' : taskIdVar
			},
    		dataType : 'json',
    		success : function(ret) {
    			$('#loading').css('display', 'none');
    			// 出错提示
    			if (ret.err) {
    				alert(ret.err);
    			} else {
					$('#logs').html(ret.logs);
					$('#logBody').scrollTop($('#logBody')[0].scrollHeight);
    			}
    		},
    		error : function() {
    			// 出错提示
    			alert('System error!');
    		}
    	}); 
    }
	//显示实时日志
	function showRunningLog(processId, execDate, taskId, taskName, taskStatus, jobId){
		clearInterval(timeOutVar);
		$('#logTitle').html(taskName + ' <%=bundleJsp.getString("taskLog")%>');
		$('#runningLog').modal({
			backdrop:false,
			keyboard:true,
			show:true
		});
		$('#loading').css('display', '');
		var url = '<%=request.getContextPath()%>/process/getRunningLog.do';		
		
		$.ajax({
    		type : "post",
    		url : url,
    		async : false,
    		data:{
				'processId' : processId,
				'execDate' : execDate,
				'jobId' : jobId,
				'taskId' : taskId
			},
    		dataType : 'json',
    		success : function(ret) {
    			$('#loading').css('display', 'none');
    			// 出错提示
    			if (ret.err) {
    				alert(ret.err);
    			} else {
					$('#logs').html(ret.logs);
					$('#logBody').scrollTop($('#logBody')[0].scrollHeight);
    			}
    		},
    		error : function() {
    			// 出错提示
    			alert('System error!');
    		}
    	}); 
    	taskIdVar = taskId;
    	proIdVar = processId;
    	jobIdVar = jobId;
    	execDateVar = execDate;
    	if (taskStatus == 'R') {
    		timeOutVar = setInterval('getLogs()', 5000);
    	}
	}
	
//注册右键上下菜单
$(function(){
    $.contextMenu({
        selector: 'rect,tspan', 
        callback: function(key, options) {
            //当前控件属性及值
            var props = $(window).data("currProps");
            //任务ID
            var taskId = props.taskId.value;

    		var tableDataStr = $(window.parent.document).find('#tableData').val();
    		if(!tableDataStr || tableDataStr == ''){
    			alert("<%=bundleJsp.getString("sonTaskW")%>");
    			return;
    		}
    		var tableData = JSON.parse(tableDataStr);
    		var taskStatus = null;
    		var taskName = null;
    		var processId = null;
    		var execDate = null;
    		var message = null;
    		var taskType = null;
    		for(var i = 0 ; i < tableData.length;i++){
    			var taskIdStore = tableData[i]['taskId'];
    			if (taskId == taskIdStore){
    				taskStatus = tableData[i]['taskStatus'];
    				taskName = tableData[i]['taskName'];
    				processId = tableData[i]['processId'];
    				execDate = tableData[i]['execDate'];
    				message = tableData[i]['message'];
    				taskType = tableData[i]['taskType'];
    				break;
    			}
    		}	
    		
    		var jobId = '';
    		if (taskType == 'SPARKSQL') {
    			jobId = "sparksql";
    		}
    		
    		//未运行分支,后台没有运行记录
    		if(processId==null){
				taskStatus = 'W';
				processId = tableData[0]['processId'];
				execDate = tableData[0]['execDate'];
				message = '';
    		}
    		            
            switch(key){
            case 'retry':
            	retryTask(processId,taskId,execDate,taskStatus);
            	break; 
            case 'abort':
            	abortTask(processId,taskId,execDate,taskStatus);
            	break;             	
            case 'msg':
            	showRunningLog(processId, execDate, taskId, taskName, taskStatus, jobId);
            	break;             	
            case 'appjump':
                var target = props["target"] ;
                redirectToProcess( target.value , execDate ) ;
                break ;
            }
        },
        items: {
            "retry": {name: "<%=bundleJsp.getString("rerunTask")%>", icon: "start",disabled:function(key, opt){
            		var props = $(window).data("currProps");
            		var taskId = props.taskId.value;
            		var tableDataStr = $(window.parent.document).find('#tableData').val();
		    		if(!tableDataStr || tableDataStr == ''){
		    			return true;
		    		}
		    		var taskStatus = 'W';
		    		var tableData = JSON.parse(tableDataStr);
		    		for(var i = 0 ; i < tableData.length;i++){
		    			var taskIdStore = tableData[i]['taskId'];
		    			if (taskId == taskIdStore){
		    				taskStatus = tableData[i]['taskStatus'];
		    				break;
		    			}
		    		}
                    return !(taskStatus == 'F' || taskStatus == 'C');
                }},
            "abort": {name: "<%=bundleJsp.getString("stopTask")%>", icon: "stop"},
            "msg": {name: "<%=bundleJsp.getString("taskLog")%>", icon: "info", disabled:function(key, opt){
            		var props = $(window).data("currProps");
            		var taskId = props.taskId.value;
            		var tableDataStr = $(window.parent.document).find('#tableData').val();
		    		if(!tableDataStr || tableDataStr == ''){
		    			return true;
		    		}
		    		var taskStatus = 'W';
		    		var taskType;
		    		var tableData = JSON.parse(tableDataStr);
		    		for(var i = 0 ; i < tableData.length;i++){
		    			var taskIdStore = tableData[i]['taskId'];
		    			if (taskId == taskIdStore){
		    				taskStatus = tableData[i]['taskStatus'];
		    				taskType = tableData[i]['taskType'];
		    				break;
		    			}
		    		}
		    		if (taskType == 'TRANSFER' || taskType == 'MAPREDUCE' || taskType == 'HIVE' || taskType == 'SPARKSQL') {
		    			return !(taskStatus == 'R' || taskStatus == 'F' || taskStatus == 'C' || taskStatus == 'S');
		    		} else {
		    			return true;
		    		}
                }},
            "appjump": {name: "<%=bundleJsp.getString("returnPro")%>", icon: "related"
                ,disabled:function(key, opt){
                    var props = $(window).data("currProps");
                    return props["target"] == undefined || props["depType"].value != 'process';
                }
            },
        }
    });
});

function dictFromQuery( params,sep ) {
   console.debug("dictF",params);
   if( params.constructor == Object ){
       return params ;    
   }
   var d = {} ; 
   var sep = sep || '&' ;
   var kvs = params.split( sep );
   for(var i = 0; i < kvs.length; i ++) {
       var kv = kvs[i].split("=");
       if ( kv[0].length > 0 ) {
           if ( kv.length == 1 ){
               d[kv[0]] = undefined ;
           }else if ( kv.length == 2) {
               d[kv[0]] = unescape(kv[1]);
           }
       }
   }
   return d ;
}
function QueryFromDict( params,sep){
      if ( params.constructor == String ){
          return params ;
      }
      var sep = sep || '&' ;
      var arr = [] ;
      for ( var k in params ){
          arr.push( k+'='+params[k] ) ; 
      }
      return arr.join(sep);
}

function redirectToProcess( target , execDate ){
    var location = window.parent.location ;
    var params = dictFromQuery( location.search.substr(1) ) ;
    params["processId"] = target  ;
    params["execDate"] = execDate ;
    var query = QueryFromDict( params ) ;
    href = location.origin + location.pathname + "?" + query ;
    window.parent.location.href=href ;
}

//任务重试
function retryTask(processId,taskId,execDate,taskStatus){
    switch(taskStatus){
	case 'F':
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/process/retryProcess.do",
			async : true,
			dataType : "json",
			data : {
				processId : processId,
				execDate : execDate,
				taskStatus : taskStatus
			},
			success : function(ret) {
					alert(ret.messages);
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		});		
		break;
	case 'W':
	case 'Q':
	case 'R':
	case 'S':
	case 'C':
		alert('<%=bundleJsp.getString("notFail")%>');	
		break;
    }	
}

//任务中止
function abortTask(processId,taskId,execDate,taskStatus){
	if (confirm("<%=bundleJsp.getString("sureProStop")%>")){
	    switch(taskStatus){
	    case 'Q':
		case 'R':
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

//根据界面保存的数据,获取任务状态
function getTaskStatus(taskId){
	var tableDataStr = $(window.parent.document).find('#tableData').val();
	var tableData = JSON.parse(tableDataStr);
	for(var i = 0 ; i < tableData.length;i++){
		var taskIdStore = tableData[i]['taskId'];
		if (taskId == taskIdStore){
			return tableData[i]['taskStatus'];
		}
	}
}
</script>
