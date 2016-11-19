<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.lenovo.lps.farseer.priest2.common.util.DateUtils"%>
<%@page import="java.util.Locale"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	Locale localeLogin = AccessSession.getLocale(request);
	String localeTypeLogin = localeLogin.getLanguage().toLowerCase();
	ResourceBundle bundleLogin = ResourceBundle.getBundle("i18n.i18n", localeLogin);
%>
<script type="text/javascript">
	window.i18nValue="<%=localeTypeLogin%>";
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="common/header.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery.i18n.properties-min-1.0.9.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery.capsLockTip.js"></script>
<body>
<div class="wrap login">
	<!-- 页面主体开始 -->
	<%@include file="login_content.jsp"%>
	<!-- 页面主体结束 -->
</div>
</body>
</html>