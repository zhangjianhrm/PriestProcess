<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	Locale localeHead = AccessSession.getLocale(request);
	String localeTypeHead = localeHead.getLanguage().toLowerCase();
	ResourceBundle bundle = ResourceBundle.getBundle("i18n.i18n", localeHead);
%>
<head>
<script type="text/javascript">
window.contextPath="<%=request.getContextPath()%>";
window.i18nValue="<%=localeTypeHead%>";
</script>
<title>LEAP - Priest Process</title>
<meta name="keywords" content="Priest" />
<meta name="description" content="LEAP - <%=bundle.getString("header")%>(Priest)" />
<link rel="icon" href="<%=request.getContextPath()%>/resources/images/favicon.ico" type="image/x-icon" />
<!--javascript脚本-->

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/main.css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/main.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/content.css?20150311" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/content.js"></script>
<!-- jquery ui -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/jquery-ui-1.8.4.custom.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-ui-1.8.4.custom.min.js"></script>

<!-- jqGrid -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/styles/ui.jqgrid.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery.i18n.properties-min-1.0.9.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/grid.locale-cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-ui-1.8.21.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/chosen.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/chosen.jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/highcharts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/highcharts-more.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/bootstrap_ex.js"></script>

<script>
window.DateBJ = new Date((new Date(<%=new java.util.Date().getTime()%>).getTime()+((new Date(<%=new java.util.Date().getTime()%>).getTimezoneOffset()+480)*60000))).getTime();

//jquery ui datepicker中文设置
jQuery(function($) {
	$.datepicker.regional['zh-CN'] = {
		closeText : '<%=bundle.getString("close")%>',
		prevText : '<<%=bundle.getString("lastMonth")%>',
           nextText: '<%=bundle.getString("nextMonth")%>>',
		currentText : '<%=bundle.getString("today")%>',
		monthNames : [ '<%=bundle.getString("january")%>', '<%=bundle.getString("february")%>', '<%=bundle.getString("march")%>', '<%=bundle.getString("april")%>', '<%=bundle.getString("may")%>', '<%=bundle.getString("june")%>', '<%=bundle.getString("july")%>', '<%=bundle.getString("august")%>', '<%=bundle.getString("september")%>', '<%=bundle.getString("october")%>', '<%=bundle.getString("november")%>', '<%=bundle.getString("december")%>' ],
		monthNamesShort : [ '<%=bundle.getString("jan")%>', '<%=bundle.getString("feb")%>', '<%=bundle.getString("mar")%>', '<%=bundle.getString("apr")%>', '<%=bundle.getString("may")%>', '<%=bundle.getString("jun")%>', '<%=bundle.getString("jul")%>', '<%=bundle.getString("aug")%>', '<%=bundle.getString("sep")%>', '<%=bundle.getString("oct")%>', '<%=bundle.getString("nov")%>', '<%=bundle.getString("dec")%>' ],
		dayNames : [ '<%=bundle.getString("sunday")%>', '<%=bundle.getString("monday")%>', '<%=bundle.getString("tuesday")%>', '<%=bundle.getString("wednesday")%>', '<%=bundle.getString("thursday")%>', '<%=bundle.getString("friday")%>', '<%=bundle.getString("saturday")%>' ],
		dayNamesShort : [ '<%=bundle.getString("sun")%>', '<%=bundle.getString("mon")%>', '<%=bundle.getString("tue")%>', '<%=bundle.getString("wed")%>', '<%=bundle.getString("thu")%>', '<%=bundle.getString("fri")%>', '<%=bundle.getString("sat")%>' ],
		dayNamesMin : ['<%=bundle.getString("sunMin")%>', '<%=bundle.getString("monMin")%>', '<%=bundle.getString("tueMin")%>', '<%=bundle.getString("wedMin")%>', '<%=bundle.getString("thuMin")%>', '<%=bundle.getString("friMin")%>', '<%=bundle.getString("satMin")%>' ],
		weekHeader : '<%=bundle.getString("week")%>',
		dateFormat : 'yy-mm-dd',
		firstDay : 1,
		isRTL : false,
		showMonthAfterYear : true,
		yearSuffix : '<%=bundle.getString("year")%>'
	};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
	$.datepicker.setDefaults({
		defaultDate: new Date(DateBJ)
	});
});
</script>
</head>