<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.common.util.DateUtils"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="com.lenovo.lps.farseer.priest2.common.util.ConfigUtil"%>
<!-- 页眉-->
<%
	Locale locale = AccessSession.getLocale(request);
	String localeType = locale.getLanguage().toLowerCase();
	ResourceBundle bundleTop = ResourceBundle.getBundle("i18n.i18n", locale);
%>
<script type="text/javascript">
    window.WEB_BASE = "<%=request.getContextPath()%>";
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/drop-down.css" />

<script type="text/javascript">
	function logout() {
		var flag = confirm('<%=bundleTop.getString("sure_exit")%>');
		if (flag) {
			$('#LogoutForm').submit();
		}
	}
	function showNotices() {
		if ($('#JS_notices_content_box').children('div').length) {
			$('#JS_notices_content_box').slideToggle(100);
			return
		}
	}
	
	function openCreateUserWin(){
		window.open('<%=request.getContextPath()%>/user/gotoUserRegister.do?v=v2','_blank','height=600px,width=400px,top=300px,left=300px,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no,titlebar=no');
	}
	
	// ajax请求完成时，如果session超时，则自动跳到登录页面
	$.ajaxSetup({
		complete : function(xhr){
			var txt = $.trim(xhr.responseText);
			var sessionstatus=xhr.getResponseHeader("sessionstatus"); 
			if(sessionstatus == 'timeout' || txt.startsWith("<!DOCTYPE") || (txt == "" && xhr.statusText == "error")){
				window.location.href="<%=request.getContextPath()%>/views/login.jsp";
			}
		}
	});
	
	$(document).ready(function(){		
		var _userTimer;
		$('#IconUser').click(function(){
			clearTimeout(_userTimer);
			$('#UserExt').slideToggle(150);
		})
		
		$('#UserExt').mouseenter(function(){
			clearTimeout(_userTimer);
		})
		
		$('#UserExt').mouseleave(function(){
			_userTimer = setTimeout(function(){
				$('#UserExt').slideUp(150);
			}, 500);
		})
	});
</script>
<div class="header">
	<a href="<%=request.getContextPath()%>/views/process_run_list.jsp" title="<%=bundleTop.getString("rePortal")%>" class="logo"><i></i></a>
	<a href="javascript:;" class="toggleBar" id="ToggleBar"><i class="iconToggle"></i></a>
	<%
	String userName = AccessSession.getAccessUser(request.getSession()) ;
	%>
	<div class="navRight">
		<ul>
			<li><a href="<%=request.getContextPath()%>/views/process_run_list.jsp"><i class="iconHome"></i></a></li>
			<li>
				<a href="javascript:;" id="IconUser"><i class="iconUser"></i></a>
				<div class="userExt" id="UserExt">
					<p><%=AccessSession.getAccessUser(request.getSession())  %></p>
					<p><a href="javascript:;" class="logoutLink" onclick="logout()" title="<%=bundleTop.getString("logout") %>"><%=bundleTop.getString("logout") %></a></p>
				</div>
			</li>
		</ul>
	</div>
</div>
<form id="LogoutForm" action="<%=request.getContextPath()%>/user/logout.do" hidden="true" method="post"></form>
