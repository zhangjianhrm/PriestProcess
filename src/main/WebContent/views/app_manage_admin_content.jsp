<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>

<style type="text/css">
#appVars{
	width:202px;
	line-height:22px;
	height: 22px;
	overflow-y:hidden;
}
</style>
<div>
	<form id="appForm" method="post">
		<div id="J_formFull" class="search-content">
			<div class="search-title"><%=bundleJsp.getString("appManage")%></div>
			<div id="appInfo" class="search-form">
				<dl>
					<dt><%=bundleJsp.getString("appName")%>:</dt>
					<dd>
						<input type="text" id="appName" name="appName" class="i-text" onBlur="checkApp();" />
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("appDesc")%>:</dt>
					<dd>
						<input type="text" id="appDesc" name="appDesc" class="i-text" />
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("appVars")%>:</dt>
					<dd>
						<textarea id="appVars" rows="1" class="i-text" onClick="modifyAppVars();"></textarea>
					</dd>
				</dl>
				<dl>
					<dt><%=bundleJsp.getString("appThreadPool")%>:</dt>
					<dd>
					    <select id="threadPoolId" name="threadPoolId">
							<option value="" selected="selected"><%=bundleJsp.getString("option")%></option>
                           <c:forEach items="${list}" var="pool">  
                           	 	<option value="${pool.poolId }">${pool.poolName }</option>  
                       		</c:forEach> 								
						</select>
					</dd>
				</dl>
				<dl style="display: none;" id="appUserJsId">
					<dt><%=bundleJsp.getString("appUser")%>:</dt>
					<dd>
						<input type="text" id="appUser" name="appUser" class="i-text" />
					</dd>
				</dl>				
			</div>
		
			
			<div class="search-btn">
				<input type="hidden" id="appId" value="" />
				<input type="hidden" id="opType" value="insert" />
				
				<input id="opBtn" type="button" value="<%=bundleJsp.getString("add")%>" onClick="appInfoOps();" class="btn btn-primary"/>
				<input id="resetBtn" type="button" value="<%=bundleJsp.getString("cancel")%>" onClick="resetAppInfo();" class="btn btn-default"/>
			</div>
		</div>
	</form>
	
	<div class="tableWrap">
		<table id="resultTab" style="width: 100%"></table>
		<div id="pageDiv"></div>
	</div>
</div>

<div id="popupPropertyDialog" style="display: none;">
	<h2><%=bundleJsp.getString("parameters")%>:</h2>
	<div style="overflow:hidden; border-bottom:1px solid #D7EAE2 ">
		<table cellspacing="0" cellpadding="0" border="0">
			<tbody><tr>
				<td valign="top" style=" width:600px; border-right:1px solid #D7EAE2 ">
					<div class="itemTitle">
						<div class="addItem"><a onclick="addItem('.Item2')" href="javascript:;"><%=bundleJsp.getString("add")%></a></div>
					</div>
					<div style="height:340px; overflow-y:auto">
						<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable" >
						</table>
					</div>
				</td>
			</tr></tbody>
	  </table>	
	</div>
</div>

<div id="popupDialog" style="display: none;">
	<textarea rows="24" cols="53" id="widgetName" style="width: 500;"></textarea>
</div>

<script type="text/javascript">
var threadPools={};

<c:forEach items="${list}" var="pool">  
    threadPools['${pool.poolId}']='${pool.poolName}'; 
</c:forEach> 

$(function(){
	var width = $(window).width();
	$("#resultTab").jqGrid({
		url : '<%=request.getContextPath()%>/config/getAppInfos.do',
		datatype : 'json',
		colNames : ["<%=bundleJsp.getString("app")%>ID", "<%=bundleJsp.getString("appName")%>", "<%=bundleJsp.getString("appDesc")%>", "<%=bundleJsp.getString("appVars")%>","<%=bundleJsp.getString("appThread")%>ID", "<%=bundleJsp.getString("appThreadPool")%>","<%=bundleJsp.getString("appUser")%>"],
		colModel :[
			{
				name : "appId",
				index : "app_id",
				width : 50
			},
			{
				name : "appName",
				index : "app_name",
				width : 100
			},
			{
				name : "appDesc",
				index : "app_desc",
				width : 80
			},
			{
				name : "appVars",
				index : "app_variables",
				width : 100
			},
			{
				name : "threadPoolId",
				index : "threadPoolId",
				width : 100,
				hidden : true
			},	
			{
				name : "threadPoolName",
				index : "thread_pool_id",
				width : 100
			},				
			{
				name : "appUser",
				index : "app_user",
				align : "center",
			}
		],
		rowNum : 1000,
		rowList : [ 1000 ],
		loadonce : false,
		sortname : 'app_id',
		sortorder : 'asc',
		mtype : "POST",
		gridview : true,
		pager : '#pageDiv',
		viewrecords : true,
		width : width * 0.78,
		height: "100%",
		jsonReader : {
			root : "rows",
			repeatitems : false
		},
		loadComplete: function(xhr){
			//查询出错
			if (xhr.err){
				alert(xhr.err);
				return false;
			}
			
			//生成操作列内容
			var ids = jQuery("#resultTab").getDataIDs();
			
			for(var i = 0;i<ids.length;i++) {
				var threadPoolId = xhr.rows[i]['threadPoolId'];
				var threadPoolName = threadPools[threadPoolId];
				jQuery("#resultTab").setCell(ids[i],"threadPoolName",threadPoolName);
			}
							
	    },			
		ondblClickRow : function(rowid,iRow,iCol,e) {
			$('div.title h2').text("<%=bundleJsp.getString("appModify")%>");			
			$('#appId').val($('#resultTab').jqGrid('getCell',rowid,'appId'));
			$('#appName').val($('#resultTab').jqGrid('getCell',rowid,'appName')).attr('disabled', true);
			$('#appDesc').val($('#resultTab').jqGrid('getCell',rowid,'appDesc'));
			$('#appVars').val($('#resultTab').jqGrid('getCell',rowid,'appVars'));
			$('#threadPoolId').val($('#resultTab').jqGrid('getCell',rowid,'threadPoolId'));
			
			$('#opType').val("update");
			$('#appUserJsId').show();
			$('#appUser').val($('#resultTab').jqGrid('getCell',rowid,'appUser'));
			$('#opBtn').val("<%=bundleJsp.getString("update")%>");
			$('#resetBtn').val("<%=bundleJsp.getString("cancel")%>");
		}
	});
});


function appInfoOps(){
	var namePtn = /^[\w-]+$/;

	if($('#opType').val() == 'insert'){
		var appName = $('#appName').val();
		if(!(namePtn.test(appName))){
			alert("<%=bundleJsp.getString("appNameWarning")%>");
			$('#appName').focus();
			return false;
		}
		
		var ids = $("#resultTab").getDataIDs();
		for(var i=0; i<ids.length; i++){
			var row = $('#resultTab').getRowData(ids[i]);
			if(appName.toLowerCase() == row['appName'].toLowerCase()){
				alert('<%=bundleJsp.getString("appNameRepeat")%>');
				$('#appName').focus();
				return false;
			}
		}
		
		addAppInfo();
	} else {
		updateAppInfo();
	}
}

function addAppInfo(){
	var appName = $('#appName').val();
	if (appName == null || appName == "" ) {
		alert("<%=bundleJsp.getString("selAppName")%>");
		$("#appName").focus();
		return false;
	}
	var threadPoolId = $('#threadPoolId').val();
	if (threadPoolId == null || threadPoolId == "" ) {
		alert("<%=bundleJsp.getString("selThreadPool")%>");
		$("#threadPoolId").focus();
		return false;
	}
	$.ajax({
		type : "POST",
		url : '<%=request.getContextPath()%>/config/addAppInfo.do',
		dataType : 'json',
		data : {
			appName : appName,
			appDesc : $('#appDesc').val(),
			appVars : $('#appVars').val(),
			threadPoolId : threadPoolId
		},
		success : function() {
			alert("<%=bundleJsp.getString("appAddSuc")%>");
			reload();
		},
		error : function() {
	   		alert("<%=bundleJsp.getString("appAddFail")%>");
		}
	});
}

function updateAppInfo(){
	var appName = $('#appName').val();
	if (appName == null || appName == "" ) {
		alert("<%=bundleJsp.getString("selAppName")%>");
		$("#appName").focus();
		return false;
	}
	var appUser = $('#appUser').val();
	if (appUser == null || appUser == "" ) {
		alert("<%=bundleJsp.getString("selAppUser")%>");
		$("#appUser").focus();
		return false;
	}
	var threadPoolId = $('#threadPoolId').val();
	if (threadPoolId == null || threadPoolId == "" ) {
		alert("<%=bundleJsp.getString("selThreadPool")%>");
		$("#threadPoolId").focus();
		return false;
	}
	$.ajax({
		type : "POST",
		url : '<%=request.getContextPath()%>/config/updateAppInfo.do',
		dataType : 'json',
		data : {
			appId : $('#appId').val(),
			appName : appName,
			appDesc : $('#appDesc').val(),
			appVars : $('#appVars').val(),
			appUser : appUser,
			threadPoolId : threadPoolId
		},
		success : function() {
			alert("<%=bundleJsp.getString("appUpdateSuc")%>");
			reload();
		},
		error : function() {
	   		alert("<%=bundleJsp.getString("appUpdateFail")%>");
		}
	});
}

function reload(){
	resetAppInfo();
	$('#resultTab').trigger('reloadGrid');
}

function resetAppInfo(){
	$('#appForm')[0].reset();
	
	if($('#opType').val() == "update"){
		$('div.title h2').text("<%=bundleJsp.getString("appAdds")%>");
		$('#appName').attr('disabled', false);
		$('#opType').val("insert");
		$('#appUserJsId').hide();
		$('#opBtn').val("<%=bundleJsp.getString("add")%>");
		$('#resetBtn').val("<%=bundleJsp.getString("reset")%>");
	} 
}

function modifyAppVars(){
	var vars = $('#appVars').val().split('\n');
	
	$('.itemList').remove();
	$.each(vars, function(idx,val){
		var index = val.indexOf('=');
		var key = val.substring(0,index);
		var value = val.substring(index+1);
		if(key && key!=''){
			addItem('.Item2',key,value);
		}
	});
	
	$('#popupPropertyDialog').dialog({
		modal : true,
		autoOpen : true,
		position : [ 'middle', 'center' ],
		title : 'Input please',
		width : 420,
		height : 500,
		buttons : {
			Cancel : function() {
	          	$(this).dialog( "close" );
	        },
	        OK : function() {
	        	var jobProperties = '';
				$('.itemList').each(function(){
					var key = $(this).find('.keyClass').val();
					var value= $(this).find('.valueClass').val();
					
					if(key){
						jobProperties +=  key + '=' + value + '\n';
					}
				});
	        	$('#appVars').val(jobProperties);
	        	$(this).dialog( "close" );
	        }
		}
	});
}

function addItem(dom,key,value){
	var n = parseInt(new Date().getTime());
	n = n*parseInt(Math.random()*1000+1);
	if (key){
		$(dom).append('<tr id="'+n+'" class="itemList"><td><input type="text" value="' + key + '" class="keyClass"/> =&nbsp; </td><td><input type="text" value="' + value + '" class="valueClass"/></td><td><a href="javascript:;" onclick="delItem('+n+')"><%=bundleJsp.getString("delete")%></a></td></tr>');
	}
	else{
		$(dom).append('<tr id="'+n+'" class="itemList"><td><input type="text" value="" class="keyClass"/> =&nbsp; </td><td><input type="text" value="" class="valueClass"/></td><td><a href="javascript:;" onclick="delItem('+n+')"><%=bundleJsp.getString("delete")%></a></td></tr>');
	}
}	

function delItem(dom){
	$('#'+dom).remove();
}	

</script>
