<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	ResourceBundle bundleLeft = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<!--(begin)| 导航-->
<div class="leftBox" id="LeftBox">
	<dl>
		<dt><i class="icon_01"></i><%=bundleLeft.getString("processDef")%><span class="arrow"><span></span></span></dt>
		<dd>
			<ul>
				<li><a id="pdHref" href="<%=request.getContextPath()%>/views/process_def.jsp?click=pd"><%=bundleLeft.getString("processNew")%></a></li>
				<li><a id="pdeHref" href="<%=request.getContextPath()%>/views/process_edit.jsp?click=pde"><%=bundleLeft.getString("processQuery")%></a></li>
			</ul>
		</dd>
	</dl>
	<dl>
		<dt><i class="icon_02"></i><%=bundleLeft.getString("processManage")%><span class="arrow"><span></span></span></dt>
		<dd>
			<ul>
				<li><a id="prlHref" href="<%=request.getContextPath()%>/views/process_run_list.jsp?click=prl"><%=bundleLeft.getString("processList")%></a></li>
				<li><a id="rhHref" href="<%=request.getContextPath()%>/views/run_history.jsp?click=rh"><%=bundleLeft.getString("processRunup")%></a></li>
				<!-- <li><a id="runHref" href="<%=request.getContextPath()%>/views/process_actual_status.jsp?click=run"><%=bundleLeft.getString("proRunDraw")%></a></li> -->
			</ul>
		</dd>
	</dl>
	
	
	<dl style="display:none;">
		<dt><i class="icon_03"></i><%=bundleLeft.getString("dataManage")%><span class="arrow"><span></span></span></dt>
		<dd>
			<ul>
				<li><a id="arHref" href="<%=request.getContextPath()%>/views/alarm_rules_manage.jsp?click=ar"><%=bundleLeft.getString("alarmManage")%></a></li>
				<li><a id="siHref" href="<%=request.getContextPath()%>/views/status_interface.jsp?click=si"><%=bundleLeft.getString("interfaceAlarm")%></a></li>
			</ul>
		</dd>
	</dl>
	

	
	<dl style="display:none;">
		<dt><i class="icon_05"></i><%=bundleLeft.getString("adReport")%><span class="arrow"><span></span></span></dt>
		<dd>
			<ul>
				<li><a id="aqHref" href="<%=request.getContextPath()%>/views/ad_hoc_queries.jsp?click=aq"><%=bundleLeft.getString("adQuery")%></a></li>
			</ul>
		</dd>
	</dl>
	
    <%if(AccessSession.getUserIsAdmin(request.getSession())){ %>
	<dl>
		<dt><i class="icon_06"></i><%=bundleLeft.getString("adminArea")%><span class="arrow"><span></span></span></dt>
		<dd>
			<ul>
				<!--<li style="display:none;"><a id="dnHref" href="<%=request.getContextPath()%>/views/dfsnodelist.jsp?click=dn">NameNode <%=bundleLeft.getString("info")%></a></li>
				<li style="display:none;"><a id="jtHref" href="<%=request.getContextPath()%>/views/jobtracker.jsp?click=jt">JobTracker <%=bundleLeft.getString("info")%></a></li>
				<li><a id="tpHref" href="<%=request.getContextPath()%>/views/table_profile.jsp?click=tp"><%=bundleLeft.getString("tableDistri")%></a></li>-->
				<!-- <li><a id="cpHref" href="<%=request.getContextPath()%>/views/cluster_profile.jsp?click=cp"><%=bundleLeft.getString("clusterSpace")%></a></li>
				<li><a id="amHref" href="<%=request.getContextPath()%>/config/gotoAppManage.do?click=am"><%=bundleLeft.getString("appManage")%></a></li>-->
				<li><a id="dmHref" href="<%=request.getContextPath()%>/views/database_manage.jsp?click=dm"><%=bundleLeft.getString("dbManage")%></a></li>
				<!-- <li><a id="umHref" href="<%=request.getContextPath()%>/user/gotoUserManager.do?click=um"><%=bundleLeft.getString("userManage")%></a></li>-->
				<li><a id="scHref" href="<%=request.getContextPath()%>/views/sys_config.jsp?click=sc"><%=bundleLeft.getString("sysConfig")%></a></li>
				<li><a id="alHref" href="<%=request.getContextPath()%>/views/alarm_config.jsp?click=al"><%=bundleLeft.getString("alarmConfig")%></a></li>
			</ul>
		</dd>
	</dl>
<%}%>	
</div>
<a href="javascript:;" class="toggleBar" id="ToggleBar"><span></span></a>

<!--(end) 导航-->
<script>
//初始化左边导航展开
$(function(){
	$('#LeftBox dt').click(function(){
		if($('#LeftBox').hasClass('hideMenu')){
    		$('#ToggleBar').removeClass('hideMenu');
    		$('#LeftBox').removeClass('hideMenu');
	    	$('.wrap').removeClass('hideMenu');
	    	return;
    	}
		
    	var _dl = $(this).parent();
    	_dl.toggleClass('open');
    	_dl.find('dd').slideToggle(150);

		/*
    	_dl.siblings().each(function(){
        	if(!$(this).find('dt .arrow').hasClass('close')){
	        	$(this).find('dt .arrow').addClass('close');
	        	$(this).find('dd').slideUp(150);
        	}
    	});
    	*/
    });

	$('#ToggleBar').click(function(){
    	if(!$('#LeftBox').hasClass('hideMenu')){
    		$('#ToggleBar').addClass('hideMenu');
	    	$('#LeftBox').addClass('hideMenu');
	    	$('.wrap').addClass('hideMenu');
    	}else{
    		$('#ToggleBar').removeClass('hideMenu');
    		$('#LeftBox').removeClass('hideMenu');
	    	$('.wrap').removeClass('hideMenu');
    	}
    	
    	$(window).resize();
    });
    
	//左边导航点击来源
	var click = '<%=request.getParameter("click")%>';
	//默认 显示"流程运行实例"界面
	if (click == 'null'){
		click = 'prl';
	}
	//<a  id="prHref'>
	var anchorId = '#' + click + 'Href';
	var anchor = $(anchorId);
	var li = anchor.parent();
	//<div class="top-ele">
	var div = li.parent().parent();
	
	//初始化点击anchor颜色
	if (!anchor.hasClass('active')){
		// div.find('li.current').removeClass('current');
		anchor.addClass('active');
	}
	anchor.parents('dl').addClass('open');
	anchor.parents('dl').find('dd').show();
	
	
	//初始化左边导航展开
	div.addClass("current");
});

</script>
