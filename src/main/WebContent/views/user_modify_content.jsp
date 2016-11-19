<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<style>
.addForm .search-form dl{ float: none; margin-left: 100px;}
.addForm .search-btn{ margin-left: 210px; margin-bottom: 20px; text-align: left;}
</style>
<script src="<%=request.getContextPath()%>/resources/script/jquery.multiselect.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery.multiselect.filter.min.js"
	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/resources/styles/jquery.multiselect.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/styles/jquery.multiselect.filter.css"
	rel="stylesheet" type="text/css" />
<div style="min-height: 1200px;">
	<form id="userForm" method="post">
		<div id="J_formFull" class="addForm" >
			<div id="appInfo" class="search-form">
				<dl id="userJsId" class="userSearch">
					<dt><%=bundleJsp.getString("userName")%>:</dt>
					<dd>
						<input type="text" id="userName" name="userName" class="i-text" disabled="disabled" value="<%=AccessSession.getAccessUser(request.getSession())%>"/>
					</dd>
				</dl>
				<dl >
					<dt><%=bundleJsp.getString("pwd")%>:</dt>
					<dd>
						<input type="password" id="password" name="password" class="i-text" />
					</dd>
				</dl>
				<dl >
					<dt><%=bundleJsp.getString("confPwd")%>:</dt>
					<dd>
						<input type="password" id="passwordRe" name="password" class="i-text" />
					</dd>
				</dl>
			</div>
			
			<div class="search-btn">
				<input id="opBtn" type="button" value="<%=bundleJsp.getString("update")%>" onClick="modifyUser();" class="btn btn-primary"/>
				<input id="resetBtn" type="button" value="<%=bundleJsp.getString("reset")%>" onClick="resetFields()" class="btn btn-default"/>	
			</div>
		</div>
	</form>
	
	<table id="resultTab"></table>
	<div id="pageDiv"></div>
</div>


<script type="text/javascript">

function resetFields(){
	$('#password').val('');
	$('#passwordRe').val('');
	$('#phone').val('');
}

function modifyUser(){
	var lenovoId = $('#lenovoId').val();
	var userName = $('#userName').val();
	var password = $("#password").val();
	var confirmPass = $("#passwordRe").val();
	if (!lenovoId){
		alert('<%=bundleJsp.getString("selLenovoId")%>');
		return false;
	}
	if (!userName){
		alert('<%=bundleJsp.getString("selUserName")%>');
		return false;
	}
	
	if (password == null || password == "" ) {
		alert("<%=bundleJsp.getString("selPwd")%>");
		$("#password").focus();
		return false;
	}	
	
	if (confirmPass == null || confirmPass == "" ) {
		alert("<%=bundleJsp.getString("selConfPwd")%>");
		$("#passwordRe").focus();
		return false;
	}
	
	if (password != confirmPass) {
		alert("<%=bundleJsp.getString("pwdError")%>");
		$("#passwordRe").focus();
		return false;			
	}
	
	$.ajax({
		type : "POST",
		url : '<%=request.getContextPath()%>/user/modifyByUser.do',
		dataType : 'json',
		data : {
			password : password,
			userName : $('#userName').val(),
			lenovoId : $('#lenovoId').val(),
			phone : $('#phone').val()
		},
		success : function(ret) {
		     //出错
		     if (ret.err){
		    	 alert(ret.err);
		    	 return;
		     }
		     
			alert("<%=bundleJsp.getString("dbUpdateSuc")%>");
			resetFields();
		},
		error : function() {
	   		alert("<%=bundleJsp.getString("dbUpdateFail")%>");
		}
	});
}
</script>