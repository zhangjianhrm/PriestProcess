<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<script type="text/javascript">
//本页面查询结果表格中展现的流程JSON定义
	var jsonDefs = [];
	var user='<%=AccessSession.getAccessUser(request.getSession()) %>';

	//流程查询
	function queryProcess() {
		var processId = $('#processId').val().trim();
		var processName = $('#processName').val().trim();
		var processApp = $('#processApp').val();
		var createdBy = $('#createdBy').val();
		var createdDateStart = $('#createdDateStart').val();
		var createdDateEnd = $('#createdDateEnd').val();
		var processState = $('#processState').val();
		
		var digitPattern = /^\d+$/;
		if (processId != '' && (!digitPattern.test(processId) || processId<1)){
			alert("<%=bundleJsp.getString("proIdWarning")%>");
			$('#processId').focus();
			return false;
		}
		
		//日期正则
		var datePattern = /(\d{4})-(\d{1,2})-(\d{1,2})/;
		
		if (createdDateStart && !createdDateEnd){
			alert("<%=bundleJsp.getString("endCreateDate")%>");
			$('#createdDateEnd').focus();
			return false;
		}
		
		if (createdDateEnd && !createdDateStart){
			alert("<%=bundleJsp.getString("startCreateDate")%>");
			$('#createdDateStart').focus();
			return false;
		}
		
		//查询起止日期检查
		if(createdDateStart && createdDateEnd){
			var startDays = createdDateStart.match(datePattern);
			var endDays = createdDateEnd.match(datePattern);
			var startDay = new Date(startDays[1],startDays[2] -1 ,startDays[3]);
			var endDay = new Date(endDays[1],endDays[2] -1 ,endDays[3]);
			
			if (startDay > endDay){
				alert("<%=bundleJsp.getString("endStartCreate")%>");
				$('#createdDateEnd').focus();
				return false;
			}
		}
		
		if (!processApp && 'true' != '<%=AccessSession.getUserIsAdmin(request.getSession()) %>'){
			alert('<%=bundleJsp.getString("selApp")%>');
			$('#processApp').focus();
			return false;
		}
		
		jQuery("#resultTab").setGridParam({
			page : '1'
		});
		var postData = {"processId":processId, "processName":processName, "processApp":processApp, "createdBy":createdBy, "createdDateStart":createdDateStart,"createdDateEnd":createdDateEnd,"processState":processState};
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

	// 查看详情
	function gotoDetail(self){
	    $(self).parents('tr').dblclick();
	}
	
	//打开文件上传对话框
	function openUploadDialog(){
		$('#importUploadDiv').dialog('open');
	}
</script>
<div id="ChartCon" style="display: none;">
<iframe id="pIframe" width="100%" src="<%=request.getContextPath()%>/views/process_def_draw.jsp" height="670" frameborder="0" scrolling="auto"></iframe>
</div>

<div id="query">
	<form id="taskSearchForm" method="post">
		<input type="hidden" name="action" value="TaskScheduleAction"/>
		<input type="hidden" name="event_submit_do_search" value="true"/>
		<input type="hidden" id="displayExt" value="simple"/>
		<div id="J_formFull" class="search-content">
			<div class="search-title"><%=bundleJsp.getString("processQuery")%></div>
			<div class="search-form">
				<div class="group">
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
						<dt><%=bundleJsp.getString("processState")%>:</dt>
						<dd>
							<select id="processState" name="processState">
								<option value="" selected="selected"><%=bundleJsp.getString("option")%></option>
								<option value="N"><%=bundleJsp.getString("normal")%></option>
								<option value="D"><%=bundleJsp.getString("disable")%></option>
							</select>
						</dd>
					</dl>
				</div>
				<dl class="isHide">
					<dt><%=bundleJsp.getString("app")%>:</dt>
					<dd>
						<select id="processApp" name="processApp">
						</select>
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("createDate")%>:</dt>
					<dd>
						<input type="text" id="createdDateStart" class="i-text i-text-time short" readonly /> - <input type="text"
							id="createdDateEnd" class="i-text i-text-time short" readonly />
					</dd>
				</dl>
				<dl class="w2">
					<dt><%=bundleJsp.getString("founder")%>:</dt>
					<dd>
						<input type="text" id="createdBy" name="createdBy" class="i-text" />
						<input type="checkbox" id="createByMe" value="" /><%=bundleJsp.getString("myCreation")%>
					</dd>
				</dl>
			</div>
			<div class="search-btn">
				<input type="button" onclick="queryProcess();" value="<%=bundleJsp.getString("query")%>" class="btn btn-primary">
				<input id="formReset" type="reset" onclick="resetForm();" value="<%=bundleJsp.getString("reset")%>" class="btn btn-default">
			</div>
		</div>
	</form>
	
	
	<div class="tableWrap">
		<table id="resultTab"></table>
		<div id="pageDiv"></div>
		<div class="tableNoData hidden" id="TableNoData"><%=bundleJsp.getString("noData")%></div>
	</div>

	<!-- 向iframe传递任务json -->
	<input type="hidden" id="taskJsonDef" />
	
	<!-- 当前用户 -->
	<input type="hidden" value="<%= AccessSession.getAccessUser(request.getSession())  %>" id="currentUserHidden" />
	
	<div id="importUploadDiv">
		<form id="fileUpload">
			<input type="file" id="zipFile" name="zipFile" />
		</form>
	</div>
</div>
<script type="text/javascript">
    //根据后台配制绑定"应用名称"下拉框
    function bindAppSelect(){
      	var url = '<%=request.getContextPath()%>/config/getApps.do';
    	$.ajax({
    		type : "get",
    		url : url,
    		async : false,
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
    			getTableData();
    		},
    		error : function() {
    			// 出错提示
    			alert('System error!');
    		}
    	}); 
    }
    
    
    function getTableData(){
    	var width = $(window).width() - $('#LeftBox').width() - 60;
	    var dayNames = [ '<%=bundleJsp.getString("sun")%>', '<%=bundleJsp.getString("mon")%>', '<%=bundleJsp.getString("tue")%>', '<%=bundleJsp.getString("wed")%>', '<%=bundleJsp.getString("thu")%>', '<%=bundleJsp.getString("fri")%>', '<%=bundleJsp.getString("sat")%>' ] ;
	
		var url = '<%=request.getContextPath()%>/process/searchProcess.do';
		jQuery("#resultTab").jqGrid({
			url : url,
			datatype : "json",
			colNames : [ "<%=bundleJsp.getString("shortPro")%>ID", "<%=bundleJsp.getString("processName")%>", "<%=bundleJsp.getString("discription")%>","<%=bundleJsp.getString("processState")%>", "<%=bundleJsp.getString("scheduleType")%>","<%=bundleJsp.getString("app")%>","<%=bundleJsp.getString("founder")%>","<%=bundleJsp.getString("createTime")%>","<%=bundleJsp.getString("modifyPer")%>","<%=bundleJsp.getString("updateTime")%>","<%=bundleJsp.getString("operate")%>"],
			colModel : [ {
				name : 'processId',
				index : 'process_id',
				width : 60,
				hidden : false,
				sorttype : 'int'
			}, {
				name : 'processName',
				index : 'process_name',
				width : 150
			}, 
			{
				name : 'processDesc',
				index : 'process_desc'
			},
			{
				name : 'processState',
				index : 'process_state'
			},
			{
				name : 'scheduleType',
				index : 'schedule_type'
			},
			{
				name : 'processApp',
				index : 'process_app',
				width : 100,
				hidden : true
			}, 
			 {
				name : 'createdBy',
				index : 'created_by',
				width : 80
			}, 
			 {
				name : 'createdDate',
				index : 'created_date'
			}, 
			 {
				name : 'updatedBy',
				index : 'updated_by',
				width : 80
			}, 
			 {
				name : 'updatedDate',
				index : 'updated_date'
			},					
            {
				name : 'operator',
				index : 'operator',
				sortable: false,
				align:'center'
			
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
			sortname : 'process_name',
			viewrecords : true,
			sortorder : "desc",
			caption : "",
			width: width,
			height: "100%",
			postData : {},
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
				
				if(xhr.rows.length == 0){
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
					var processApp = xhr.rows[i]['processApp'];
					//流程状态
					var processState = xhr.rows[i]['processState'];
					//流程ID
					var processId = xhr.rows[i]['processId'];
                    var scheduleType = xhr.rows[i]['scheduleType'] ;
					//json串
					var jsonDef = xhr.rows[i]['jsonDef'];
					//初始化数组
					jsonDefs[i]=jsonDef;
					//根据状态生成启用/停用链接
					var opeAnchor ;
					//状态为停用
				    if (processState == 'D'){
				    	// opeAnchor = "<img src='../img/16/start.png' alt='启用流程' title='启用流程' onclick=\"updateState('" + processId + "','N');\" />" ;
				    	opeAnchor = '<a href="javascript:;" class="glyphicon glyphicon-play-circle" alt="<%=bundleJsp.getString("processEnable")%>" title="<%=bundleJsp.getString("processEnable")%>" data-toggle="tooltip" data-placement="top" onclick="updateState(' + processId + ',\'N\')"></a>';    	
				    }
				    //正常状态
				    else if(processState == 'N'){
				    	// opeAnchor = "<img src='../img/16/stop.png'  alt='停用流程' title='停用流程' onclick=\"updateState('" + processId + "','D');\" />" ;
				    	opeAnchor = '<a href="javascript:;" class="glyphicon glyphicon-stop" alt="<%=bundleJsp.getString("processDisable")%>" title="<%=bundleJsp.getString("processDisable")%>" data-toggle="tooltip" data-placement="top" onclick="updateState('+ processId + ',\'D\');"></a>';	
				    }
					//待审核状态
				    else{
				    	opeAnchor = "";
				    }
					

					opeAnchor += '<a href="javascript:;" class="glyphicon glyphicon-list-alt" alt="<%=bundleJsp.getString("detail")%>" title="<%=bundleJsp.getString("detail")%>" data-toggle="tooltip" data-placement="top" onclick="gotoDetail(this)"></a>';
					
					
					//操作列生成"启用/停用/待审核"链接
					jQuery("#resultTab").setCell(ids[i],"operator",opeAnchor);
					var stateValue = null;
					switch (processState) {
					case 'N':
						stateValue = "<%=bundleJsp.getString("normal")%>";
						break;
					case 'D':
						stateValue = "<%=bundleJsp.getString("disable")%>";
						break;
					case 'I':
						stateValue = "<%=bundleJsp.getString("underV")%>";
						break;
					case 'R':
						stateValue = "<%=bundleJsp.getString("notApproved")%>";
						break;
					default:
						break;
					}
					jQuery("#resultTab").setCell(ids[i],"processState",stateValue);
                    var schtype = null ;
                    var schdate = null ;
                    try {
                        schdate = new Date(xhr.rows[i]['scheduleDate']) ;
                    }catch(e) {
                    }
                    switch(scheduleType){
                        case 'Y' : schtype = '<%=bundleJsp.getString("everyY")%>' ; break ;
                        case 'I' : schtype = '<%=bundleJsp.getString("everym")%>' ; break ;
                        case 'H' : schtype = '<%=bundleJsp.getString("everyH")%>' ; break ;
                        case 'D' : schtype = '<%=bundleJsp.getString("everyD")%>' ; break ;
                        case 'O' : schtype = '<%=bundleJsp.getString("once")%> [' + schdate.toLocaleDateString() +"]" ; break ; 
                        case 'W' : schtype = '<%=bundleJsp.getString("every")%> ' + dayNames[schdate.getDay()]  ; break ;
                        case 'M' : schtype = '<%=bundleJsp.getString("everyM")%> [' + schdate.getDate() +"] <%=bundleJsp.getString("day")%>" ; break ;
                        case 'Q' : 
                            var d = schdate.getDate() ;
                            var s = "";
                            for ( var j = schdate.getMonth() ; j < 12 + schdate.getMonth()  ; j+= 3 ){
                                var m = j % 12 + 1 ;
                                s = s + m + "-" + d +"  " ;
                            }
                            schtype = '<%=bundleJsp.getString("everyQ")%>[' + s +"]" ;
                            break ;
                        default: schtype = scheduleType ;
                    }
					jQuery("#resultTab").setCell(ids[i],"scheduleType",schtype);
					
					//将应用ID对应为应用名称
					var processAppName = $("#processApp option[value=" + processApp + "]").text();
					$("#resultTab").setCell(ids[i], "processApp", processAppName);

					$('[data-toggle="tooltip"]').tooltip();
				}
				$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
		    },
			ondblClickRow : function(rowid,iRow,iCol,e) {
				//流程图json表示
				var taskJsonDef =  jsonDefs[rowid-1];
				//设置隐藏字段值,方便iframe获取
				$('#taskJsonDef').val(taskJsonDef);

				$('#ChartCon').show();
				$('html,body').animate({scrollTop: 0}, 300);
			
				//iframe刷新
				var iframeObj = (document.getElementById)?document.getElementById('pIframe'):document.all['pIframe'];
				iframeObj.src = iframeObj.src;
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
		
		var processId ='<%=request.getParameter("processId")%>';
		//从流程实例页面跳转过来，刷新页面
		if (processId != 'null'){
			$("#processId").val(processId);
			//更新表格数据
			var postData = {"processId": processId};

			if('<%=request.getParameter("fromlist")%>' == 'null'){
				//查询任务执行信息
				reloadTable(postData);
			}else{
				$('#query').hide();
				$('#ChartCon').show();
				
				$.ajax({
					type: 'POST',
					url: '<%=request.getContextPath()%>/process/searchProcess.do',
					data: postData,
					dataType: 'json',
					success: function(data){
						jsonDefs[0] = data.rows[0]['jsonDef'];
						
						//流程图json表示
						var taskJsonDef = jsonDefs[0];
						//设置隐藏字段值,方便iframe获取
						$('#taskJsonDef').val(taskJsonDef);
						//iframe刷新
						var iframeObj = (document.getElementById)?document.getElementById('pIframe'):document.all['pIframe'];
						iframeObj.src = iframeObj.src;
					}
				});
			}
		}
    }
    
	$(function() {
		//根据后台配制绑定"应用名称"下拉框
		bindAppSelect();

		
		//文件上传
		$('#importUploadDiv').dialog(
				{
					modal : true,
					autoOpen : false,
					title : 'Select file please',
					width : 350,
					height : 180,
					buttons : {
						'Cancel' : function() {
							$(this).dialog('close');
						},
						'Ok' : function() {
							//文件上传,并传回
							upload();
							$(this).dialog('close');
						}
					}
				});	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		$('#createdDateStart').datepicker();
		$('#createdDateEnd').datepicker();
		$('#createByMe').click(function(){
			if($(this).attr("checked")){
				$('#createdBy').val($('#currentUserHidden').val());
			}else{
				$('#createdBy').val("");
			}
		});
		
		//更改创建人时,把我的创建勾去掉
		$('#createdBy').bind("change",function(){
			if($('#createByMe').attr("checked")){
				$('#createByMe').attr("checked",false);
			}
		});
	});
	
	//启用/停用/审核流程
	function updateState(processId,processState){
		//请求地址
		var modUrl = '<%=request.getContextPath()%>/process/updateState.do?processId='+ processId + '&processState=' + processState;
    	$.ajax({
    		type : "get",
    		url : modUrl,
    		async : true,
    		dataType : 'json',
    		success : function(ret) {
    			// 出错提示
    			if (ret.err) {
    				alert(ret.err);
    			} else {
					alert('<%=bundleJsp.getString("operateSuc")%>');
					//刷新表格
					queryProcess();
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
	
	//删除流程
	function delProcess(processId){
		//请求地址
    	$.ajax({
    		type : "post",
    		url : "<%=request.getContextPath()%>/process/deleteProcess.do",
    		async : true,
    		data : {
    			processId : processId
    		},
    		dataType : 'json',
    		success : function(ret) {
   				alert(ret.messages);
				queryProcess();
    		},
    		error : function() {
    			// 出错提示
    			alert('System error!');
    		}
    	}); 	
    	//防止事件向上冒
    	return false;
	}	
	
	function dataoutput(processId)
	{
	    window.location.href="<%=request.getContextPath()%>/process/exportProcesses.do?processId=" +processId;
	}	
	
	function upload()
	{	var url = "<%=request.getContextPath()%>/process/importProcess.do";
	  	var data = new FormData();
	  	jQuery.each($('#zipFile')[0].files, function(i, file) {
	  	    data.append('file-'+i, file);
	  	});  	
	    var processJsonDef;
	    var processIds;
		$.ajax({
			type : "POST",
			url : url,
			async : false,
			cache: false,
		    contentType: false,
		    processData: false,		
		    data:data,
			success : function(ret) {
				// 出错提示
				if (ret.err) {
					alert(ret.err);
				} else {
					processJsonDef = ret.processJsonDef;
					processIds = ret.processIds;
					if (processIds != null){
						alert("<%=bundleJsp.getString("importPro")%>:" + processIds);
					}
					if (processJsonDef != null){
						alert('<%=bundleJsp.getString("importProSuc")%>');
					}
				}
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		});  
		
		$('#taskJsonDef').val(processJsonDef);
		//iframe刷新
		var iframeObj = (document.getElementById)?document.getElementById('pIframe'):document.all['pIframe'];
		iframeObj.src = iframeObj.src;
	}
	
	function popInvestigationPage(window){
		var currentJsonDef = $('#taskJsonDef').val();
		//将json字符串转换为json数据
		var jsonDatas = eval("(" + currentJsonDef + ")");
		var processId = jsonDatas.props.props.processId.value;
		var processIdtd = $("[aria-describedby='resultTab_processId']").filter(function(idx) {
			return this.textContent.trim() === processId;
		});
		var processState = processIdtd.next().next().next().text();
		if (processState != '<%=bundleJsp.getString("underV")%>'){
			alert('<%=bundleJsp.getString("proWarning")%>');
			return false;
		}
		window.showModalDialog("process_investigation.jsp",processId,"dialogLeft:150px;dialogTop:250px;dialogWidth:660px; dialogHeight:400px;help:no;resizable:no;status:no;scrollbars:no;");
	}
</script>
