<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
	String error = request.getAttribute("err") == null ? "":String.valueOf(request.getAttribute("err"));
%>
<script type="text/javascript">
    //登陆
	function login() {
		var userName = $("#j_username").val();
		var password = $("#j_password").val();
		if (userName == null ||userName == "" ) {
			alert("<%=bundleJsp.getString("selUserName")%>");
			$("#j_username").focus();
			return false;
		}
		
		
		if (password == null || password == "" ) {
			alert("<%=bundleJsp.getString("selPwd")%>");
			$("#j_password").focus();
			return false;
		}	
				
	     $("#f").submit();
	}
	
</script>

<div class="loginHeader">
	<div class="con">
		<div class="logo"></div>
		<ul class="nav">
			<li><a href="javascript:;">帮助与文档</a></li>
		</ul>
	</div>
</div>

<div id="contentDiv" class="loginCon">
	<div class="logo"></div>
	<div class="proName">Priest Process</div>
	<form id="f" name="f" action="<%=request.getContextPath()%>/user/login.do" method="post">
		<ul id="J_formFull" class="inputCon">
			<li>
				<i class="icon iconUser"></i>
				<input type="text" id="j_username" name="j_username" class="i-text" placeholder="Username"/>
			</li>

			<li>
				<i class="icon iconPwd"></i>
				<input type="password" id="j_password" name="j_password" class="i-text" onpaste="return false;" oncontextmenu = "return false;" placeholder="password"/>
			</li>
		</ul>

		<input class="btn btn-primary" type="button" onclick="login();" value="<%=bundleJsp.getString("login")%>" id="submitButton" />
	</form>
</div>

<div class="loginFooter">Copyright: 1998~2016 Lenovo Group Limited Beijing ICP 05000462</div>


<script type="text/javascript">
jQuery(document).ready(function() {
	$('#j_password').live('keypress', function(e) {
		// 大写锁定提示
		$('#j_password').capsLockTip();
	});
	
	//按enter登陆
    $('body').live('keypress', function (e) {
	    if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
	    	$('#submitButton').click();
	    	return false;
	    } else {
	    	return true;
	    }	    
    });
    
	//密码输入框禁止control + c / v
    $('#j_password').bind('copy paste', function (e) {
    	e.preventDefault();	    
    }); 
    
 });
    if ("<%=error%>" != "") {
    	alert("<%=error%>");
		$("#j_username").focus();
    }
</script>
