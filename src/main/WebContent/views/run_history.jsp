<%@page contentType = "text/html;charset=UTF-8" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@include file="common/header.jsp"%> 
<body>
	
	<div class="wrap">
		<!-- 页面头 -->
        <%@include file="common/top.jsp"%>
        <div class="mainBox">
		<!-- 左边导航-->
        <%@include file="common/leftBar.jsp"%> 
		<div class="rightBox">
			<div class="crumb">
				<%=bundle.getString("proInsManage")%>
				<span>>> <%=bundle.getString("historyTitle")%></span>
			</div>
			<div class="content">
				<!-- 页面主体开始 -->
				<%@include file="run_history_content.jsp"%> 
				<!-- 页面主体结束 -->
			</div>
		</div>
		</div>
		<!-- 页脚开始 -->
		<%@include file="common/footer.jsp"%>
		<!-- 页脚结束 -->
	</div>
</body>
</html>