<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.common.util.ConfigUtil"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ResourceBundle bundle = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title><%=bundle.getString("title403")%></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<style type="text/css">
.prompt{position: relative;top: -20px;}
.txt{
    background-color: #a0adc6;
    font-family: 'Microsoft YaHei';
    font-size: 24px;
    color: #e6eaf2;
    margin: 5px 0;
    display: inline-block;
    padding: 0 5px;
    height: 35px;
    line-height: 35px;
}
.loginout_box{
    background-color: #b2c9f3;
    box-shadow: inset 0px 1px rgba(0,0,0,.4);
    width: 200px;
    height: 55px;
    display: inline-block;
    line-height: 55px;
    border-radius: 30px;
    color: #ffffff;
    font-family: 'Microsoft YaHei';
    font-weight: 700;
    position: relative;
}
.loginout_box .loginout{
    display: inline-block;
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3c99e3', endColorstr='#0b6db8', GradientType=0 );
    background: -webkit-linear-gradient(top, #3c99e3,#0b6db8);
    background: -moz-linear-gradient(top, #3c99e3,#0b6db8);
    background: -o-linear-gradient(top, #3c99e3,#0b6db8);
    background: -ms-linear-gradient(top, #3c99e3,#0b6db8);
    border: 1px solid #134699;
    border-radius: 30px;
    width: 186px;
    height: 43px;
    line-height: 43px;
    margin-top: 5px;
    box-shadow: inset 0px 1px rgba(255,255,255,.7);
}
.loginout_box:hover{
    background-color: #b8ddf6;
}
.loginout_box:hover .loginout{
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#62baff', endColorstr='#0b6db8', GradientType=0 );
    background: -webkit-linear-gradient(top, #62baff,#0b6db8);
    background: -moz-linear-gradient(top, #62baff,#0b6db8);
    background: -o-linear-gradient(top, #62baff,#0b6db8);
    background: -ms-linear-gradient(top, #62baff,#0b6db8);
}
.loginout_box:active{
    background-color: #b2c9f3;
}
.loginout_box:active .loginout{
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0b6db8', endColorstr='#58b1f7', GradientType=0 );
    background: -webkit-linear-gradient(top, #0b6db8,#58b1f7);
    background: -moz-linear-gradient(top, #0b6db8,#58b1f7);
    background: -o-linear-gradient(top, #0b6db8,#58b1f7);
    background: -ms-linear-gradient(top, #0b6db8,#58b1f7);
}
.loginout_box .icon{
    background: url("resources/images/arrlow_right.png") no-repeat;
    overflow: hidden;
    width: 40px;
    height: 35px;
    display: inline-block;
    position: absolute;
    right: 5px;
    top: 10px;
}
.loginout_box .tt{margin-left: -35px;}
</style>

<body style="text-align:center;background-color: #e6eaf2;">
    <div>
        <img src="<%=path %>/resources/images/403.png">
    </div>
    <div class="prompt">
        <div><span class="txt"><%=bundle.getString("noPermission")%></span></div>
        <div><span class="txt"><%=bundle.getString("contactUs")%></span></div>
    </div>
    <div class="login_out">
        <a href="<%=path %>/user/logout.do" class="loginout_box">
            <span class="loginout"><span class="tt"><%=bundle.getString("switch")%></span><i class="icon"></i></span>
        </a>
    </div>
</body>
</html>