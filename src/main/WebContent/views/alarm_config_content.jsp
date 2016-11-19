<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
boolean isAdmin = AccessSession.getUserIsAdmin(request.getSession());
%>
<script src="<%=request.getContextPath()%>/resources/script/jquery.multiselect.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/script/jquery.multiselect.filter.min.js" type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/resources/styles/jquery.multiselect.filter.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/styles/sysConfig.css" rel="stylesheet" type="text/css" />

<div class="configItem single" id="Config_4">
	<div class="tit"><%=bundleJsp.getString("phoneService")%><%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary addConfig" data-type="4"><i class="iconAdd"></i><%=bundleJsp.getString("addConfigLink")%></a>
		</div>
	</div>
	<div class="con single">
		<div class="nullTip"><span class="glyphicon glyphicon-info-sign"></span> <%=bundleJsp.getString("configNullTip")%>，<a href="javascript:;" class="addLink"><%=bundleJsp.getString("addConfig")%></a></div>
		
		<div class="configList"><ul></ul></div>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/script/sysConfig.js" type="text/javascript"></script>
