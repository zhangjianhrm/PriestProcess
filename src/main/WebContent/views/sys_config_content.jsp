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

<div class="configItem" id="Config_2">
	<div class="tit">
		Spark <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary addConfig" data-type="2"><i class="iconAdd"></i><%=bundleJsp.getString("addConfigLink")%></a>
		</div>
	</div>
	<div class="con">
		<div class="nullTip hidden"><span class="glyphicon glyphicon-info-sign"></span> <%=bundleJsp.getString("configNullTip")%>，<a href="javascript:;" class="addLink"><%=bundleJsp.getString("addConfig")%></a></div>
		<div class="configList">
			<ul></ul>
		</div>
	</div>
</div>

<div class="configItem" id="Config_3">
	<div class="tit">Redis <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary addConfig" data-type="3"><i class="iconAdd"></i><%=bundleJsp.getString("addConfigLink")%></a>
		</div>
	</div>
	<div class="con">
		<div class="nullTip hidden"><span class="glyphicon glyphicon-info-sign"></span> <%=bundleJsp.getString("configNullTip")%>，<a href="javascript:;" class="addLink"><%=bundleJsp.getString("addConfig")%></a></div>
		
		<div class="configList">
			<ul></ul>
		</div>
	</div>
</div>

<div class="configItem" id="Config_1">
	<div class="tit">
		Hive <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary addConfig" data-type="1"><i class="iconAdd"></i><%=bundleJsp.getString("addConfigLink")%></a>
		</div>
	</div>

	<div class="con">
		<div class="nullTip hidden"><span class="glyphicon glyphicon-info-sign"></span> <%=bundleJsp.getString("configNullTip")%>，<a href="javascript:;" class="addLink"><%=bundleJsp.getString("addConfig")%></a></div>

		<div class="configList">
			<ul></ul>
		</div>
	</div>
</div>


<div class="configItem evn">
	<div class="tit">
		hadoop & hdfs <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary editEvnConfig">
				<span class="glyphicon glyphicon-edit"></span>
				编辑
			</a>
		</div>
	</div>

	<div class="con">
		<div class="configList evnConfig">
			<ul>
				<li data-type="hadoop.security.authentication" data-dis="sel" data-opts="kerberos,simple">
					<div class="name">hadoop安全模式：</div>
					<div class="text">--</div>
				</li>
				<li data-type="realm.krb">
					<div class="name">kerberos域：</div>
					<div class="text">--</div>
				</li>
				<li data-type="hive.metastore.kerberos.principal">
					<div class="name">hive元数据认证角色：</div>
					<div class="text">--</div>
				</li>
				<li data-type="hive.metastore.uris">
					<div class="name">hive元数据thrift url：</div>
					<div class="text">--</div>
				</li>
				<li data-type="hadoop.config.path">
					<div class="name">hadoop配置路径：</div>
					<div class="text">--</div>
				</li>
				<li data-type="hadoop.lib.path" data-ph="用于sqoop mapreduce 和java任务 动态加载lib">
					<div class="name">hadoop包路径：</div>
					<div class="text">--</div>
				</li>
				<li data-type="hive.lib.path" data-ph="用于hiveSql sparkSql和java任务 动态加载lib">
					<div class="name">hive包路径：</div>
					<div class="text">--</div>
				</li>
				
				<li data-type="hdfs.remove.path.forbidden" data-ph="多个目录用,分隔">
					<div class="name">hdfs禁止删除目录：</div>
					<div class="text">--</div>
				</li>
				<li data-type="kill.job.path">
					<div class="name">中止hadoop脚本路径：</div>
					<div class="text">--</div>
				</li>
				<li data-type="mapred.bin.path">
					<div class="name">mapred bin路径：</div>
					<div class="text">--</div>
				</li>
				<li data-type="system.hive.warehouse.location">
					<div class="name">hive warehouse路径：</div>
					<div class="text">--</div>
				</li>
				<li data-type="sql.forbid.operations" data-ph="多个操作限制用,分隔">
					<div class="name">sql操作类型限制：</div>
					<div class="text">--</div>
				</li>
				<li data-type="sqoop.default.dbname">
					<div class="name">sqoop导数临时数据库：</div>
					<div class="text">--</div>
				</li>
			</ul>
			<div class="search-btn hidden">
				<input type="button" value="保存" class="btn btn-primary saveEvnEdit">
				<input type="reset" value="取消" class="btn btn-default cancelEvnEdit">
			</div>
		</div>
	</div>
</div>			

<div class="configItem evn">
	<div class="tit">
		process service <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary editEvnConfig">
				<span class="glyphicon glyphicon-edit"></span>
				编辑
			</a>
		</div>
	</div>

	<div class="con">
		<div class="configList evnConfig">
			<ul>		
				<li data-type="job.result.max.datasize" data-ph="byte">
					<div class="name">任务结果变量大小限制：</div>
					<div class="text">--</div>
				</li>
				<li data-type="job.result.limit.datasize" data-ph="byte">
					<div class="name">任务结果大小限制：</div>
					<div class="text">--</div>
				</li>
				<li data-type="job.result.max.rowcount">
					<div class="name">任务结果条数限制：</div>
					<div class="text">--</div>
				</li>
				<li data-type="file.upload.path">
					<div class="name">文件上传目录：</div>
					<div class="text">--</div>
				</li>
				<li data-type="file.download.path">
					<div class="name">文件下载目录：</div>
					<div class="text">--</div>
				</li>
				<li data-type="process.error.log.location">
					<div class="name">流程错误日志目录：</div>
					<div class="text">--</div>
				</li>
				<li data-type="process.run.graph.height">
					<div class="name">流程graph绘图高度设置：</div>
					<div class="text">--</div>
				</li>
				<li data-type="process.run.graph.width">
					<div class="name">流程graph绘图宽度设置：</div>
					<div class="text">--</div>
				</li>
				<li data-type="process.rerun.hour" data-ph="22 表示每天22点前错误的hive、spark任务会自动重跑">
					<div class="name">错误任务自动重跑时间限制：</div>
					<div class="text">--</div>
				</li>
			</ul>
			<div class="search-btn hidden">
				<input type="button" value="保存" class="btn btn-primary saveEvnEdit">
				<input type="reset" value="取消" class="btn btn-default cancelEvnEdit">
			</div>
		</div>
	</div>
</div>			

<div class="configItem evn">
	<div class="tit">
		SMS <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary editEvnConfig">
				<span class="glyphicon glyphicon-edit"></span>
				编辑
			</a>
		</div>
	</div>

	<div class="con">
		<div class="configList evnConfig">
			<ul>	
				<li data-type="system.priest.sms.limit">
					<div class="name">每天同一个手机号发送条数限制：</div>
					<div class="text">--</div>
				</li>
				<li data-type="system.priest.sms.content.limit">
					<div class="name">每条短信拆分字数限制：</div>
					<div class="text">--</div>
				</li>
				<li data-type="subfix_of_mail_and_message">
					<div class="name">短信发送工程标示：</div>
					<div class="text">--</div>
				</li>
			</ul>
			<div class="search-btn hidden">
				<input type="button" value="保存" class="btn btn-primary saveEvnEdit">
				<input type="reset" value="取消" class="btn btn-default cancelEvnEdit">
			</div>
		</div>
	</div>
</div>			



<div class="configItem evn">
	<div class="tit">
		leapid mysql-jdbc <%=bundleJsp.getString("config")%>
		<div class="opts">
			<a href="javascript:;" class="btn btn-primary editEvnConfig">
				<span class="glyphicon glyphicon-edit"></span>
				编辑
			</a>
		</div>
	</div>

	<div class="con">
		<div class="configList evnConfig">
			<ul>
				<li data-type="user.admin.passwd">
					<div class="name">系统管理员admin密码：</div>
					<div class="text">--</div>
				</li>
				<li data-type="leapid.database.driver">
					<div class="name">leapid数据库驱动类：</div>
					<div class="text">--</div>
				</li>
				<li data-type="leapid.database.url">
					<div class="name">leapid数据库jdbc连接：</div>
					<div class="text">--</div>
				</li>
				<li data-type="leapid.database.username">
					<div class="name">leapid数据库用户名：</div>
					<div class="text">--</div>
				</li>
				<li data-type="leapid.database.password">
					<div class="name">leapid数据库密码：</div>
					<div class="text">--</div>
				</li>
			</ul>
			<div class="search-btn hidden">
				<input type="button" value="保存" class="btn btn-primary saveEvnEdit">
				<input type="reset" value="取消" class="btn btn-default cancelEvnEdit">
			</div>
		</div>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/script/sysConfig.js" type="text/javascript"></script>
