<%@page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<!-- context menu -->
<script src="<%=request.getContextPath()%>/resources/script/jquery.ui.position.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery.contextMenu.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/screen.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/prettify/prettify.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery-svgpan.min.js"
	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/resources/styles/jquery.contextMenu.css"
	rel="stylesheet" type="text/css" />
<!--<link href="<%=request.getContextPath()%>/resources/styles/screen.css" rel="stylesheet" type="text/css" /> -->
<link
	href="<%=request.getContextPath()%>/resources/script/prettify/prettify.sunburst.css"
	rel="stylesheet" type="text/css" />
	
<script type="text/javascript"> 
var SvgData = '';
window.DateBJ = new Date((new Date(<%=new java.util.Date().getTime()%>).getTime()+((new Date(<%=new java.util.Date().getTime()%>).getTimezoneOffset()+480)*60000))).getTime();
	var user='<%=AccessSession.getAccessUser(request.getSession()) %>';

	//流程查询
	function query(){
		var processId = $('#qprocessId').val();
		var processApp = $('#processApp').val();
		var execDate = $('#supplementDataDate').val();
		
		var digitPattern = /^\d+$/;
		if( processId != '' && (!digitPattern.test(processId) || processId<1)){
			alert("<%=bundleJsp.getString("proIdWarning")%>");
			$('#processId').focus();
			return false;
		}
		if (!processApp && 'true' != '<%=AccessSession.getUserIsAdmin(request.getSession()) %>'){
			alert('<%=bundleJsp.getString("selApp")%>');
			$('#processApp').focus();
			return false;
		}
		if (!execDate){
			alert("<%=bundleJsp.getString("selDD")%>");
			$('#supplementDataDate').focus();
			return false;
		}
		
		var postData = {"execDate":execDate,"processId":processId,"processApp":processApp};
		//查询任务执行信息
		if ( $.History ){
    		$.History.record( postData ) ;
		}
		reloadTable(postData);
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
		jQuery("#resultTab").jqGrid({
			url : "<%=request.getContextPath()%>/process/getHistoryRuns.do",
			datatype : "local",
			colNames : [ "<%=bundleJsp.getString("process")%>ID","<%=bundleJsp.getString("rerunDD")%>","<%=bundleJsp.getString("processName")%>","<%=bundleJsp.getString("rerunState")%>" ,"<%=bundleJsp.getString("startTime")%>","<%=bundleJsp.getString("endTime")%>" ,"<%=bundleJsp.getString("runInfo")%>","<%=bundleJsp.getString("operate")%>"],
			colModel : [ {
				name : 'processId',
				index : 'process_id',
				width : 40,
				hidden : false,
				sorttype : 'int'
			},{
				name : 'execDate',
				index : 'exec_date',
				width : 100
			}, 
			{
				name : 'processName',
				index : 'process_name',
				width : 100
			},{
				name : 'processStatus',
				index : 'process_status',
				width : 80
			},			
			 {
				name : 'startTime',
				index : 'start_time',
				width : 110
			}, 
			 {
				name : 'endTime',
				index : 'end_time',
				width : 110
			},  {
				name : 'message',
				index : 'message',
				align : 'center'
			},  {
				name : 'operator',
				index : 'operator',
				sortable: false,
				align:'center'				
			}],
			rowNum : 1000,
			rowList : [ 1000 ],
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
					
					SvgData = '';
					if($('.tabControl li.current').attr('control') == 'DataChart'){
						drawSVG(SvgData);
					}
					
					return;
				}else{
					$('#TableNoData').addClass('hidden');
					$('.ui-jqgrid').removeClass('hidden');
				}
				
				//生成操作列内容
				var ids = jQuery("#resultTab").getDataIDs();
				for(var i = 0;i<ids.length;i++){
					var processStatus = xhr.rows[i]['processStatus'];
					var processApp = xhr.rows[i]['processApp'];
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
						// jQuery("#resultTab").setCell(ids[i], "message", "<img src='<%=request.getContextPath()%>/img/download.jpg' alt='<%=bundleJsp.getString("downErr")%>' title='<%=bundleJsp.getString("downErr")%>' onclick=\"downloadErrLog('" + message + "')\" />");
						jQuery("#resultTab").setCell(ids[i], "message", "<a href='javascript:;' class='glyphicon glyphicon-download' alt='<%=bundleJsp.getString("downErr")%>' title='<%=bundleJsp.getString("downErr")%>' data-toggle='tooltip' data-placement='top' onclick=\"downloadErrLog('" + message + "')\" ></a>");
					}
					
					var execDate = xhr.rows[i]['execDate'];
					var processId = xhr.rows[i]['processId'];
					// var opeAnchor = "<img src='<%=request.getContextPath()%>/img/16/start.png' alt='重跑' title='重跑' onclick=\"reRuns(" + processId + ",'" + execDate + "')\" />" ;

					var opeAnchor = "<a href='javascript:;' class='glyphicon glyphicon-repeat' alt='<%=bundleJsp.getString("rerun")%>' title='<%=bundleJsp.getString("rerun")%>' data-toggle='tooltip' data-placement='top'  onclick=\"reRuns(" + processId + ",'" + execDate + "')\"></a>" ;

					// if(xhr.rows[i]['startTime'] != null){
					//	var _startDate = xhr.rows[i]['startTime'].substring(0, 10),
					//		_endDate = xhr.rows[i]['endTime'].substring(0, 10);
						opeAnchor += '<a href="javascript:;" class="glyphicon glyphicon-remove-circle" alt="<%=bundleJsp.getString("cancelRerun")%>" title="<%=bundleJsp.getString("cancelRerun")%>" data-toggle="tooltip" data-placement="top" onclick="cancelSupplySelect('+ processId +')"></a>';
					// }
					
					//操作列生成"启用/停用"链接
					jQuery("#resultTab").setCell(ids[i],"operator",opeAnchor);	
					
					var processAppValue = null;
					switch (processApp) {
					case '1':
						processAppValue = "Reaper";
						break;
					case '2':
						processAppValue = "Hawaii";
						break;
					case '3':
						processAppValue = "Test";
						break;
					default:
						processAppValue = processApp;
						break;
					}
					jQuery("#resultTab").setCell(ids[i],"processApp",processAppValue);

					$('[data-toggle="tooltip"]').tooltip();
				}
				if (xhr.svgData){
					SvgData = xhr.svgData;
					if($('.tabControl li.current').attr('control') == 'DataChart'){
						drawSVG(SvgData);
					}
				}
				
				$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
		    },
			ondblClickRow : function(rowid,iRow,iCol,e) {
				//流程id
				var processId = $('#resultTab').jqGrid("getCell",rowid,'processId');
	            var execDate = $('#resultTab').jqGrid("getCell",rowid,'execDate');
	            var detailURL = '<%=request.getContextPath()%>/views/task.jsp?click=tk&processId='+processId + '&execDate=' + execDate;  
	            window.parent.window.location.href=detailURL;
			}
		});
		
		$(window).bind('resize', function() {
			$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
		});
	});
	
	function drawSVG(svgData){
		var $svgDiv = $('#svgDiv');
		$svgDiv.html(svgData);
		
		var $svg = $('svg');
		if($svg.width() < $svgDiv.width()){
			$svg.width($svgDiv.width());
		}
		if($svg.height() < $svgDiv.height()){
			$svg.height($svgDiv.height());
		}
		$svg.svgPan($svg.find('.graph').attr('id'));
	}
</script>

<!--
<div id="supplementAdd">
	
	<form id="supplementAddForm" method="post">
		<div id="d_formFull" class="search-content">
			<div class="search-title"><%=bundleJsp.getString("reHis")%></div>
			<div class="search-form">
				<dl>
					<dt><%=bundleJsp.getString("process")%>ID:</dt>
					<dd>
						<input type="text" id="processId" name="processId" class="i-text" />
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("sDataDate")%>:</dt>
					<dd>
						<input type="text" id="startDataDate" name="startDataDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("eDataDate")%>:</dt>
					<dd>
						<input type="text" id="endDataDate" name="endDataDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
				<dl>
					<dt style="width: 160px;"><%=bundleJsp.getString("reDependPro")%>:</dt>
					<dd>
						<input type="radio" id="dN" name="dFlag" value="N" /><label for="dN"><%=bundleJsp.getString("no")%></label>&nbsp;&nbsp;&nbsp;&nbsp;
					</dd>
					<dd>
						<input type="radio" id="dY" name="dFlag" value="Y" /><label for="dY"><%=bundleJsp.getString("yes")%></label>
					</dd>
				</dl>
			</div>
			<div class="search-btn">
				<input type="button" onclick="supplyData();" value="<%=bundleJsp.getString("processRerun")%>" id="supplyButton" class="btn btn-primary">
				<input id="formReset" type="reset" onclick="resetForm();" value="<%=bundleJsp.getString("reset")%>" class="btn btn-default">
			</div>
		</div>

	</form>
</div>

 -->
	<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>取消補跑<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
<!-- div id="supplementCancel">
	<div class="commonTitle">
		<h2>历史数据补跑取消</h2>
	</div>
	<form id="supplementCancelForm" method="post">
		<div id="d_formFull" class="search-content">
			<div class="search-form">
				<dl>
					<dt>流程ID:</dt>
					<dd>
						<input type="text" id="cprocessId" name="processId" class="i-text" />
					</dd>
				</dl>
				<dl>
					<dt>开始数据日期:</dt>
					<dd>
						<input type="text" style="width: 163px;" id="cancelStartDataDate"
							name="startDataDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
				<dl>
					<dt>结束数据日期:</dt>
					<dd>
						<input type="text" style="width: 163px;" id="cancelEndDataDate"
							name="endDataDate" class="i-text i-text-time" readonly />
					</dd>
				</dl>
			</div>
			<div class="search-btn">
				<input type="button" onclick="cancelSupply();" value="取消补跑" id="cancelButton" class="btn btn-primary">
				<input id="formReset" type="reset" onclick="resetForm();" value="重置" class="btn btn-default"> 
			</div>
		</div>

	</form>
</div>
 -->
	<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始查询<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
	
<div id="query">
	<form id="supplementSearchForm" method="post">
		<div id="J_formFull" class="search-content">
			<div class="search-title">
				<%=bundleJsp.getString("queryHis")%>
				<div class="opts">
					<a href="javascript:;" class="btn btn-primary" id="AddNew"><i class="iconAdd"></i>添加重跑流程</a>
				</div>
			</div>
			<div class="search-form">
				<dl>
					<dt><%=bundleJsp.getString("process")%>ID:</dt>
					<dd>
						<input type="text" id="qprocessId" name="processId" class="i-text" />
					</dd>
				</dl>
				<dl class="isHide">
					<dt><%=bundleJsp.getString("app")%>:</dt>
					<dd>
						<select id="processApp" name="processApp"></select>
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("rerunDD")%>:</dt>
					<dd>
						<input type="text" id="supplementDataDate" name="supplementDataDate" class="i-text i-text-time" readonly />
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
		<div id="svgDiv" style="min-height: 300px;"></div>
	</div>
	
	<!-- 当前用户 -->
	<input type="hidden" value="<%=AccessSession.getAccessUser(request.getSession()) %>" id="currentUserHidden" />
</div>
<script type="text/javascript">
	$(function() {
		bindAppSelect();
		//日期控件注册
		
		$('#cancelStartDataDate').datepicker();	
		$('#cancelEndDataDate').datepicker();
		
		$('#supplementDataDate').datepicker();
		
		setDate('Y');
		
		$('.tabControl li').click(function(){
			$(this).addClass('current').siblings().removeClass('current');
			var _id = $(this).attr('control');
			$('.tableWrap').hide();
			$('#' + _id).show();
			
			if(_id = 'DataChart'){
				drawSVG(SvgData);
			}
		})
		
		$('#AddNew').click(function(){
			
			var _dialog = BootstrapDialog.show({
				title: '添加',
				cssClass: 'width_500_dialog',
				message: '<div class="form-horizontal">'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-4 control-label">流程ID:</label>'
						+'<div class="col-sm-8">'
							+'<input type="text" id="processId" name="processId" class="i-text">'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-4 control-label">开始数据日期:</label>'
						+'<div class="col-sm-8">'
							+'<input type="text" id="startDataDate" name="startDataDate" class="i-text i-text-time" readonly />'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-4 control-label">结束数据日期:</label>'
						+'<div class="col-sm-8">'
							+'<input type="text" id="endDataDate" name="endDataDate" class="i-text i-text-time" readonly />'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-4 control-label"><%=bundleJsp.getString("reDependPro")%></label>'
						+'<div class="col-sm-8 single">'
							+'<input type="radio" id="dN" name="dFlag" value="N" /><label for="dN"><%=bundleJsp.getString("no")%></label>&nbsp;&nbsp;&nbsp;&nbsp;'
							+'<input type="radio" id="dY" name="dFlag" value="Y" /><label for="dY"><%=bundleJsp.getString("yes")%></label>'
						+'</div>'
					+'</div>'
					+'<div class="dialogBtns">'
						+'<button type="submit" class="btn btn-primary" id="DialogSubmit">提交</button>'
						+'<button type="submit" class="btn btn-default" id="DialogCancel">取消</button>'
					+'</div>',
				onshown: function(){
					$('#startDataDate').datepicker();	
					$('#endDataDate').datepicker();
					
					$('#DialogSubmit').click(function(){
						supplyData(_dialog);
					})
					
					$('#DialogCancel').click(function(){
						_dialog.close();
					})
				}
			})
		})
	});
	
	function setDate(clickFrom){
		var date = new Date(DateBJ);
		//昨天版本
		if (clickFrom == "Y"){
			date = new Date(Date.parse(date) - (86400000 * 1));
		}
		//今天版本
		else if (clickFrom == "T"){
			date = new Date(Date.parse(date));
		}
		
		var dateStr = date.getFullYear() + "-" +   (date.getMonth()+1) + "-" + (date.getDate());
		$('#supplementDataDate').datepicker('setDate', dateStr);
	}
	
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
	
	function supplyData(_dialog) {
		var processId = $('#processId').val();
		
		var digitPattern = /^\d+$/;
		if (!processId){
			alert("<%=bundleJsp.getString("selProId")%>");
			$('#processId').focus();
			return false;
		} else if( !digitPattern.test(processId) || processId<1){
			alert("<%=bundleJsp.getString("proIdWarning")%>");
			$('#processId').focus();
			return false;
		}
		
		var startDataDate = $('#startDataDate').val();
		if (!startDataDate){
			alert("<%=bundleJsp.getString("selSDD")%>");
			$('#startDataDate').focus();
			return false;
		}
		var endDataDate = $('#endDataDate').val();
		if (!endDataDate){
			alert("<%=bundleJsp.getString("selEDD")%>");
			$('#endDataDate').focus();
			return false;
		}
		
		var startDate = new Date(Date.parse(startDataDate.replace(/-/g,   "/")));
		var endDate = new Date(Date.parse(endDataDate.replace(/-/g,   "/")));
		if(startDate > endDate){
			alert("<%=bundleJsp.getString("ddWarning")%>");
			return false;
		}
		
		var today = new Date(Date.parse(new Date(DateBJ)));
		if(startDate >= today || endDate >= today){
			alert("<%=bundleJsp.getString("beforeToday")%>");
			return false;
		}
		
		var dFlagState = '';
		var dFlag=document.getElementsByName("dFlag");
		  for(var i=0;i<dFlag.length;i++){
			  if(dFlag.item(i).checked){
				  dFlagState=dFlag.item(i).getAttribute("value");
				  break;
				  }
		  }
		if (dFlagState == ''){
			alert("<%=bundleJsp.getString("selReDepend")%>");
			return false;
		}
		
		//请求地址
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/process/historyRunProcesses.do",
			async : true,
			data : {
				processId : processId,
				startDataDate : startDataDate,
				endDataDate : endDataDate,
				dFlagState : dFlagState
			},
			dataType : 'json',
			success : function(ret) {
				if (ret.err) {
					alert(ret.err);
				} else {
					alert("<%=bundleJsp.getString("rerunProSuc")%>");
				}
				_dialog.close();
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		});
		//防止事件向上冒
		return false;
	}

	function cancelSupplySelect(id){
		$('#cancelProcessId').val(id);
		var dateStr = $('#supplementDataDate').val();
		
		$('#cancelStartDataDate').datepicker('setDate', dateStr);	
		$('#cancelEndDataDate').datepicker('setDate', dateStr);
		
		$('#CancelSupplySelect').dialog({
			title: '<%=bundleJsp.getString("selCancelDate")%>',
			modal : true,
			autoOpen : true,
			width : 450,
			height : 280,
			buttons : {
				'Cancel' : function() {
					$(this).dialog('close');
				},
				'Ok' : function() {
					//文件上传,并传回
					cancelSupply($('#cancelStartDataDate').val(), $('#cancelEndDataDate').val(), $('#cancelProcessId').val());
					$(this).dialog('close');
				}
			}
		});
	}
	
	function cancelSupply(startDate, endDate, processId) {
		/*
		var processId = $('#cprocessId').val();
		
		var digitPattern = /^\d+$/;
		if (!processId){
			alert("流程ID为空,请输入");
			$('#cprocessId').focus();
			return false;
		} else if( !digitPattern.test(processId) || processId<1){
			alert("流程ID请输入有效数字");
			$('#cprocessId').focus();
			return false;
		}
		
		var startDataDate = $('#cancelStartDataDate').val();
		if (!startDataDate){
			alert("开始数据日期为空,请输入");
			$('#cancelStartDataDate').focus();
			return false;
		}
		var endDataDate = $('#cancelEndDataDate').val();
		if (!endDataDate){
			alert("结束数据日期为空,请输入");
			$('#cancelEndDataDate').focus();
			return false;
		}
		
		var startDate = new Date(Date.parse(startDataDate.replace(/-/g,   "/")));
		var endDate = new Date(Date.parse(endDataDate.replace(/-/g,   "/")));
		if(startDate > endDate){
			alert("开始数据日期不能在结束数据日期之后");
			return false;
		}
		
		var today = new Date(Date.parse(new Date()));
		if(startDate >= today || endDate >= today){
			alert("开始数据日期和结束数据日期只能在今天之前");
			return false;
		}
		*/
		
		//请求地址
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/process/historyCancelProcesses.do",
			async : true,
			data : {
				processId : processId,
				startDataDate : startDate,
				endDataDate : endDate
			},
			dataType : 'json',
			success : function(ret) {
				if (ret.err) {
					alert(ret.err);
				} else {
					alert("<%=bundleJsp.getString("rerunProCS")%>");
					window.close();
				}
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		});
		//防止事件向上冒
		return false;
	}
	
		//注册右键上下菜单
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
	            //转转到任务详情页
	            case 'detail':
	            	window.location.href=detailURL;
	            	break;
	            //case 'reRuns':
	            //	window.reRuns(processId,execDate);
	            //	break;
	            }
	        },
	        items: {
	        	"detail": {name: "<%=bundleJsp.getString("viewDetail")%>", icon: "info"},
	        	"abort": {name: "<%=bundleJsp.getString("stopRun")%>", icon: "stop"},
	        	"reRun": {name: "<%=bundleJsp.getString("processRerun")%>", icon: "start"},
	        	//"reRuns": {name: "流程重跑(依赖)", icon: "fastforward"}
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
			case 'H':
			case 'W':				
			case 'S':
			case 'F':
			case 'C':
				alert('<%=bundleJsp.getString("onlyProStop")%>');
				break;
		    }
		}
	}
	
		function reRun(processId,execDate,processStatus){
	    switch(processStatus){
	    case 'Q':
		case 'R':
			alert('<%=bundleJsp.getString("cantRerun")%>');	
			break;
		case 'H':
		case 'W':				
		case 'S':
		case 'F':
		case 'C':
			if(confirm('<%=bundleJsp.getString("overWrite")%>')){
				var url = '<%=request.getContextPath()%>/process/rerunProcess.do';
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
			break;
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
	
	function downloadErrLog(fileName){
		window.location.href="<%=request.getContextPath()%>/process/downProcessErrLog.do?errFileName=" + fileName;
	}
</script>

<div id="CancelSupplySelect" style="display:none;">
	<div class="search-form">
		<dl>
			<dt><%=bundleJsp.getString("process")%>ID:</dt>
			<dd>
				<input type="text" id="cancelProcessId" name="processId" class="i-text" readonly/>
			</dd>
		</dl>
		<dl>
			<dt><%=bundleJsp.getString("sDataDate")%>:</dt>
			<dd>
				<input type="text" class="i-text i-text-time" id="cancelStartDataDate" readonly/>
			</dd>
		</dl>
		<dl>
			<dt><%=bundleJsp.getString("eDataDate")%>:</dt>
			<dd>
				<input type="text" class="i-text i-text-time" id="cancelEndDataDate" readonly/>
			</dd>
		</dl>
	</div>
</div>