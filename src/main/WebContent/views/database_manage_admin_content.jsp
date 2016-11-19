<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", AccessSession.getLocale(request));
%>
<script type="text/javascript">
//根据后台配制绑定"应用名称"下拉框
function bindAppSelect(){
  	var url = '<%=request.getContextPath()%>/config/getApps.do';
	$.ajax({
		type : "get",
		url : url,
		async : true,
		dataType : 'json',
		success : function(ret) {
			// 出错提示
			if (ret.err) {
				alert(ret.err);
			} else {
				var opts = eval(ret).list;
				if (opts && opts.length) {
					var selectElem = $('#appId');
					for ( var idx = 0; idx < opts.length; idx++) {
						selectElem.append('<option value="' + opts[idx].value + '">' + opts[idx].name + '</option>');
					}    
				}
			}
		},
		error : function() {
			// 出错提示
			alert('System error!');
		}
	}); 
}

function modifyDbUrl(){
	var originDbUrl = $('#url').val();
	$('#widgetName').val(originDbUrl);
	
	$('#popupDialog').dialog({
		modal : true,
		autoOpen : true,
		position : [ 'middle', 'center' ],
		title : 'Input please',
		width : 420,
		height : 500,
		buttons : {
			Cancel : function() {
	          	$(this).dialog( "close" );
	        },
	        OK : function() {
	        	var newDbUrl = $('#widgetName').val();
	        	$('#url').val(newDbUrl);
	        	$(this).dialog( "close" );
	        }
		}
	});
}

$(function() {
	//根据后台配制绑定"应用名称"下拉框
	bindAppSelect();

	$('.search-title li').click(function(){
		$(this).addClass('current').siblings().removeClass('current');
		if($(this).attr('type') == 'search'){
			$('#opBtn').hide();
			$('#queryBtn').show();
			$('#gbox_resultTab').show();
			query()
		}else{
			resetFields();
			$('#opBtn').show();
			$('#queryBtn').hide();
			$('#gbox_resultTab').hide();
		}
	})
	
	$('#AddNew').click(function(){
		var _dialog = BootstrapDialog.show({
			title: '新增数据库',
			cssClass: 'newPro-dialog',
			message: '<div class="form-horizontal">'
				+'<div class="form-group isHide">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>所属应用：</label>'
					+'<div class="col-sm-9">'
						+'<select class="form-control" id="EditAppId">'
						+'</select>'
					+'</div>'
				+'</div>'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库类型：</label>'
					+'<div class="col-sm-9">'
						+'<select class="form-control" id="EditDbType">'
							+'<option value="" selected="selected">请选择</option>'
							+'<option value="1">MySQL</option>'
							+'<option value="2">Oracle</option>'
						+'</select>'
					+'</div>'
				+'</div>'
				
				+'<div class="optCon hidden" id="MysqlCon">'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机名或IP地址：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="MysqlUrlIP">'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>端口：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="MysqlUrlPort" value="3306">'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="MysqlUrlDB">'
						+'</div>'
					+'</div>'
				+'</div>'
				
				+'<div class="optCon hidden" id="OracleCon">'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>连接类型：</label>'
						+'<div class="col-sm-9">'
							+'<select class="form-control" id="OracleType">'
								+'<option value="1">Basic</option>'
								+'<option value="2">TNS</option>'
							+'</select>'
						+'</div>'
					+'</div>'

					+'<div id="OracleTypeBasic">'
						+'<div class="form-group">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机名或IP地址：</label>'
							+'<div class="col-sm-9">'
								+'<input type="text" class="form-control" id="OracleBasicIP">'
							+'</div>'
						+'</div>'
						+'<div class="form-group">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>端口：</label>'
							+'<div class="col-sm-9">'
								+'<input type="text" class="form-control" id="OracleBasicPort" value="1521">'
							+'</div>'
						+'</div>'
						+'<div class="form-group">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>Service Name：</label>'
							+'<div class="col-sm-9">'
								+'<input type="text" class="form-control" id="OracleBasicName" value="ORCL">'
							+'</div>'
						+'</div>'
					+'</div>'

					+'<div class="hidden" id="OracleTypeTNS">'
						+'<div id="TnsList">'
							+'<div class="form-group tnsList">'
								+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机：</label>'
								+'<div class="col-sm-4">'
									+'<input type="text" class="form-control oracleTNSIP" placeholder="主机名或IP地址">'
								+'</div>'
								+'<div class="col-sm-3">'
									+'<input type="text" class="form-control oracleTNSPort" placeholder="端口">'
								+'</div>'
								+'<div class="col-sm-2">'
									+'<a href="javascript:;" class="btn btn-primary addTNS" style="height: 24px; line-height: 24px;">添加</a>'
								+'</div>'
							+'</div>'
						+'</div>'


						+'<div class="form-group">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>Service Name：</label>'
							+'<div class="col-sm-9">'
								+'<input type="text" class="form-control" id="OracleTNSName">'
							+'</div>'
						+'</div>'
						+'<div class="form-group">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>负载均衡：</label>'
							+'<div class="col-sm-9">'
								+'<select class="form-control" id="OracleLoadBalance">'
									+'<option value="-1">请选择</option>'
									+'<option value="1">是</option>'
									+'<option value="0">否</option>'
								+'</select>'
							+'</div>'
						+'</div>'
						+'<div class="form-group">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>故障转移：</label>'
							+'<div class="col-sm-9">'
								+'<select class="form-control" id="OracleFailover">'
									+'<option value="-1">请选择</option>'
									+'<option value="1">是</option>'
									+'<option value="0">否</option>'
								+'</select>'
							+'</div>'
						+'</div>'
					+'</div>'
				+'</div>'
				
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库连接串：</label>'
					+'<div class="col-sm-9">'
						+'<textarea class="form-control" rows="3" id="EditUrl"></textarea>'
					+'</div>'
				+'</div>'
				
				
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库标识：</label>'
					+'<div class="col-sm-9">'
						+'<input type="text" class="form-control" id="EditDbName">'
					+'</div>'
				+'</div>'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>用户：</label>'
					+'<div class="col-sm-9">'
						+'<input type="text" class="form-control" id="EditUserName">'
					+'</div>'
				+'</div>'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>密码：</label>'
					+'<div class="col-sm-9">'
						+'<input type="password" class="form-control" id="EditPassword">'
					+'</div>'
				+'</div>'
				
				
				+'<div class="dialogBtns">'
					+'<button type="submit" class="btn btn-primary" id="DialogSubmit">提交</button>'
					+'<button type="submit" class="btn btn-default" id="DialogCancel">取消</button>'
				+'</div>',
			onshown: function(){
				$('#EditDbType').change(function(){
					if($('#EditDbType').val() == 1){
						$('#MysqlCon').removeClass('hidden');
						$('#OracleCon').addClass('hidden');
					}else if($('#EditDbType').val() == 2){
						$('#MysqlCon').addClass('hidden');
						$('#OracleCon').removeClass('hidden');
					}else{
						$('#MysqlCon').addClass('hidden');
						$('#OracleCon').addClass('hidden');
					}
				})

				$('#OracleType').change(function(){
					if($('#OracleType').val() == 1){
						$('#OracleTypeBasic').removeClass('hidden');
						$('#OracleTypeTNS').addClass('hidden');
					}else{
						$('#OracleTypeBasic').addClass('hidden');
						$('#OracleTypeTNS').removeClass('hidden');
					}
				})

				$('.form-control').change(function(){
					$(this).removeClass('inputError');
				})

				$('.addTNS').click(function(){
					$('#TnsList').append('<div class="form-group tnsList">'
							+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机：</label>'
							+'<div class="col-sm-4">'
								+'<input type="text" class="form-control oracleTNSIP" placeholder="主机名或IP地址">'
							+'</div>'
							+'<div class="col-sm-3">'
								+'<input type="text" class="form-control oracleTNSPort"  placeholder="端口">'
							+'</div>'
							+'<div class="col-sm-2">'
								+'<a href="javascript:;" class="delTNS" style="margin-left: -22px; line-height: 28px;">删除</a>'
							+'</div>'
						+'</div>');
					changeVal();
				})
				
				$('.form-horizontal').on('click', '.delTNS', function(){
					$(this).parents('.form-group').remove();
					setUrl();
				})
				
				function setUrl(){
					var _url = '';
					if(!$('#MysqlCon').hasClass('hidden')){
						_url = 'jdbc:mysql://'+$('#MysqlUrlIP').val()+':'+$('#MysqlUrlPort').val()+'/'+$('#MysqlUrlDB').val()+'?useUnicode=true&characterEncoding=UTF-8'
					}else{
						if(!$('#OracleTypeBasic').hasClass('hidden')){
							_url = 'jdbc:oracle:thin:@'+ $('#OracleBasicIP').val() +':'+ $('#OracleBasicPort').val() +':'+ $('#OracleBasicName').val()
						}else{
							_url += 'jdbc:oracle:thin:@(DESCRIPTION=';

							$('.tnsList').each(function(){
								if($(this).find('.oracleTNSIP').val() != ''){
									_url += '(ADDRESS=(PROTOCOL=TCP)(HOST='+$(this).find('.oracleTNSIP').val()+')(PORT='+$(this).find('.oracleTNSPort').val()+'))';
								}
							})


							_url += '(CONNECT_DATA=(SERVICE_NAME='+$('#OracleTNSName').val()+'))';

							if($('#OracleLoadBalance').val() != -1){
								var _v = $('#OracleLoadBalance').val() == 1 ? 'on' : 'off';
								_url += '(LOAD_BALANCE='+_v+')';
							}

							if($('#OracleFailover').val() != -1){
								var _v = $('#OracleFailover').val() == 1 ? 'on' : 'off';
								_url += '(FAILOVER='+_v+')';
							}
							
							_url += ')'
						}
					}

					$('#EditUrl').val(_url);
				}

				function changeVal(){
					$('.optCon input').keyup(function(){
						setUrl();
					})

					$('.optCon select').change(function(){
						setUrl();
					})
				}

				changeVal()
				

				$('#EditAppId').html($('#appId').html());
				
				$('#DialogSubmit').click(function(){
					addDatabase(_dialog);
				})
				
				$('#DialogCancel').click(function(){
					_dialog.close();
				})
			}
		})
	})
});
</script>

<div>
	<form id="databaseForm" method="post">
		<div id="J_formFull" class="search-content">
			<div class="search-title">
				<%=bundleJsp.getString("dbManage")%>
				<div class="opts">
					<a href="javascript:;" class="btn btn-primary" id="AddNew"><i class="iconAdd"></i><%=bundleJsp.getString("dbNew")%></a>
				</div>
			</div>
			<div id="appInfo" class="search-form">
				<dl class="isHide">
					<dt><%=bundleJsp.getString("app")%>:</dt>
					<dd>
						<select id="appId" name="appId">
						</select>
					</dd>
				</dl>				
				<dl>
					<dt><%=bundleJsp.getString("dbType")%>:</dt>
					<dd>
						<select id="dbType">
							<option value="" selected="selected"><%=bundleJsp.getString("option")%></option>
							<option value="1">MySQL</option>
							<option value="2">Oracle</option>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>数据库标识:</dt>
					<dd>
						<input type="text" id="dbName" name="dbName" class="i-text" />
					</dd>
				</dl>							
				<dl>
					<dt><%=bundleJsp.getString("dbUser")%>:</dt>
					<dd>
						<input type="text" id="userName" name="userName" class="i-text" />
					</dd>
				</dl>
				<dl class="isHide">
					<dt><%=bundleJsp.getString("dbPwd")%>:</dt>
					<dd>
						<input type="password" id="password" name="password" class="i-text" />
					</dd>
				</dl>
				<dl class="isHide">
					<dt><%=bundleJsp.getString("dbConn")%>:</dt>
					<dd>
						<input type="text" id="url" name="url" class="i-text" value="" onClick="modifyDbUrl();" />
					</dd>
				</dl>
			</div>
		
			
			<div class="search-btn">
				<input id="queryBtn" type="button" value="<%=bundleJsp.getString("query")%>" onClick="query();" class="btn btn-primary"/>
				<input id="opBtn" type="button" value="<%=bundleJsp.getString("add")%>" onClick="opDatabases();" class="btn btn-primary" style="display: none;"/>
				<input id="resetBtn" type="button" value="<%=bundleJsp.getString("reset")%>" onClick="resetFields();" class="btn btn-default"/>
			</div>
		</div>
	</form>
	
	<div class="tableWrap">
		<table id="resultTab" style="width: 100%"></table>
		<div id="pageDiv"></div>
		<div class="tableNoData hidden" id="TableNoData"><%=bundleJsp.getString("noData")%></div>
	</div>
</div>

<div id="popupPropertyDialog" style="display: none;">
	<h2><%=bundleJsp.getString("parameters")%>:</h2>
	<div style="overflow:hidden; border-bottom:1px solid #D7EAE2 ">
		<table cellspacing="0" cellpadding="0" border="0">
			<tbody><tr>
				<td valign="top" style=" width:600px; border-right:1px solid #D7EAE2 ">
					<div class="itemTitle">
						<div class="addItem"><a onclick="addItem('.Item2')" href="javascript:;"><%=bundleJsp.getString("add")%></a></div>
					</div>
					<div style="height:340px; overflow-y:auto">
						<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable" >
						</table>
					</div>
				</td>
			</tr></tbody>
	  </table>	
	</div>
</div>

<div id="popupDialog" style="display: none;">
	<textarea rows="24" cols="53" id="widgetName" style="width: 500;"></textarea>
</div>

<script type="text/javascript">
$(function(){
	var width = $(window).width() - $('#LeftBox').width() - 60;
	$("#resultTab").jqGrid({
		url : '<%=request.getContextPath()%>/config/getDatabases.do',
		datatype : 'json',
		colNames : ["<%=bundleJsp.getString("app")%>id","dbtype","<%=bundleJsp.getString("app")%>", "<%=bundleJsp.getString("dbType")%>","数据库标识","<%=bundleJsp.getString("dbUser")%>", "<%=bundleJsp.getString("dbConn")%>", '--','--','--','--','--','--','--',  "<%=bundleJsp.getString("operate")%>"],
		colModel :[
			{
				name : "appId",
				index : "appId",
				width : 100,
				hidden : true
			},	
			{
				name : "dbType",
				index : "dbType",
				width : 100,
				hidden : true
			},				
			{
				name : "appName",
				index : "appName",
				width : 100,
				hidden : true
			},
			{
				name : "dbTypeStr",
				index : "dbTypeStr",
				width : 150,
				sortable : false
			},			
			{
				name : "dbName",
				index : "dbName",
				wdith : 100
			},
			{
				name : "userName",
				index : "userName",
				wdith : 100
			},
			{
				name : "url",
				index : "url",
				width : 280,
				sortable : false
			},
			{
				name : "ip",
				index : "ip",
				width : 0,
				hidden : true
			},
			{
				name : "port",
				index : "port",
				width : 0,
				hidden : true
			},
			{
				name : "realDbName",
				index : "realDbName",
				width : 0,
				hidden : true
			},
			{
				name : "connectType",
				index : "connectType",
				width : 0,
				hidden : true
			},
			{
				name : "serviceName",
				index : "serviceName",
				width : 0,
				hidden : true
			},
			{
				name : "failover",
				index : "failover",
				width : 0,
				hidden : true
			},
			{
				name : "loadBalance",
				index : "loadBalance",
				width : 0,
				hidden : true
			},
            {
				name : 'operator',
				index : 'operator',
				sortable: false,
				align:'center'
			}
		],
		rowNum : 1000,
		rowList : [ 1000 ],
		loadonce : false,
		sortname : 'appName',
		sortorder : 'asc',
		mtype : "POST",
		gridview : true,
		pager : '#pageDiv',
		viewrecords : true,
		width: width,
		height: "100%",
		jsonReader : {
			root : "rows",
			total : "totalPages",
			page : "currentPage",
			records : "totalRecords",
			repeatitems : false
		},
		loadComplete: function(xhr){
			//查询出错
			if (xhr.err){
				alert(xhr.err);
				return false;
			}
			
			if(xhr.rows.length == 0){
				$('#TableNoData').removeClass('hidden');
				$('.ui-jqgrid').addClass('hidden');
				return;
			}else{
				$('#TableNoData').addClass('hidden');
				$('.ui-jqgrid').removeClass('hidden');
			}
			
			//生成操作列内容
			var ids = jQuery("#resultTab").getDataIDs();
			for(var i = 0;i<ids.length;i++){
				var dbType = xhr.rows[i]['dbType'];
				var dbTypeStr;
				switch (dbType) {
				case '1':
					dbTypeStr = "MySQL";
					break;
				case '2':
					dbTypeStr = "Oracle";
					break;						
				default:
					break;
				}
				jQuery("#resultTab").setCell(ids[i],"dbTypeStr",dbTypeStr);	
				var opeAnchor = '<a href="javascript:;" class="glyphicon glyphicon-edit" alt="<%=bundleJsp.getString("update")%>" title="<%=bundleJsp.getString("update")%>" data-toggle="tooltip" data-placement="top" onclick="editThis(this)"></a>';
				
				//操作列生成"启用/停用/待审核"链接
				jQuery("#resultTab").setCell(ids[i],"operator",opeAnchor);

			}
            $("#password").val("");
            
            $("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
            
            $('[data-toggle="tooltip"]').tooltip()
	    },		
		ondblClickRow: function(rowid,iRow,iCol,e) {
			editDatabase(
				$('#resultTab').jqGrid('getCell',rowid,'appId'),
				$('#resultTab').jqGrid('getCell',rowid,'dbType'),
				$('#resultTab').jqGrid('getCell',rowid,'dbName'),
				$('#resultTab').jqGrid('getCell',rowid,'userName'),
				$('#resultTab').jqGrid('getCell',rowid,'url'),
				$('#resultTab').jqGrid('getCell',rowid,'ip'),
				$('#resultTab').jqGrid('getCell',rowid,'port'),
				$('#resultTab').jqGrid('getCell',rowid,'realDbName'),
				$('#resultTab').jqGrid('getCell',rowid,'connectType'),
				$('#resultTab').jqGrid('getCell',rowid,'serviceName'),
				$('#resultTab').jqGrid('getCell',rowid,'failover'),
				$('#resultTab').jqGrid('getCell',rowid,'loadBalance')
				
				
			);
		}		
	});
	
	$(window).bind('resize', function() {
		$("#resultTab").setGridWidth($(window).width() - $('#LeftBox').width() - 60);
	});
});


function editThis(self){
	$(self).dblclick();
}

function editDatabase(appId, dbType, dbName, userName, url, ip, port, realDbName, connectType, serviceName, failover, loadBalance){
	var _dialog = BootstrapDialog.show({
		title: '编辑数据库',
		cssClass: 'newPro-dialog',
		message: '<div class="form-horizontal">'
			+'<div class="form-group isHide">'
				+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>所属应用</label>'
				+'<div class="col-sm-9">'
					+'<select class="form-control" disabled id="EditAppId">'
					+'</select>'
				+'</div>'
			+'</div>'
			+'<div class="form-group">'
				+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库类型</label>'
				+'<div class="col-sm-9">'
					+'<select class="form-control" disabled id="EditDbType">'
						+'<option value="" selected="selected">请选择</option>'
						+'<option value="1">MySQL</option>'
						+'<option value="2">Oracle</option>'
					+'</select>'
				+'</div>'
			+'</div>'
			
			+'<div class="optCon hidden" id="MysqlCon">'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机名或IP地址：</label>'
					+'<div class="col-sm-9">'
						+'<input type="text" class="form-control" id="MysqlUrlIP">'
					+'</div>'
				+'</div>'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>端口：</label>'
					+'<div class="col-sm-9">'
						+'<input type="text" class="form-control" id="MysqlUrlPort" value="3306">'
					+'</div>'
				+'</div>'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库：</label>'
					+'<div class="col-sm-9">'
						+'<input type="text" class="form-control" id="MysqlUrlDB">'
					+'</div>'
				+'</div>'
			+'</div>'
			
			+'<div class="optCon hidden" id="OracleCon">'
				+'<div class="form-group">'
					+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>连接类型：</label>'
					+'<div class="col-sm-9">'
						+'<select class="form-control" id="OracleType">'
							+'<option value="1">Basic</option>'
							+'<option value="2">TNS</option>'
						+'</select>'
					+'</div>'
				+'</div>'
	
				+'<div id="OracleTypeBasic">'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机名或IP地址：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="OracleBasicIP">'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>端口：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="OracleBasicPort" value="1521">'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>Service Name：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="OracleBasicName" value="ORCL">'
						+'</div>'
					+'</div>'
				+'</div>'
	
				+'<div class="hidden" id="OracleTypeTNS">'
					+'<div id="TnsList">'
					+'</div>'
	
	
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>Service Name：</label>'
						+'<div class="col-sm-9">'
							+'<input type="text" class="form-control" id="OracleTNSName">'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>负载均衡：</label>'
						+'<div class="col-sm-9">'
							+'<select class="form-control" id="OracleLoadBalance">'
								+'<option value="-1">请选择</option>'
								+'<option value="1">是</option>'
								+'<option value="0">否</option>'
							+'</select>'
						+'</div>'
					+'</div>'
					+'<div class="form-group">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>故障转移：</label>'
						+'<div class="col-sm-9">'
							+'<select class="form-control" id="OracleFailover">'
								+'<option value="-1">请选择</option>'
								+'<option value="1">是</option>'
								+'<option value="0">否</option>'
							+'</select>'
						+'</div>'
					+'</div>'
				+'</div>'
			+'</div>'
			
			
			+'<div class="form-group">'
				+'<label for="exampleInputName2" disabled class="col-sm-3 control-label"><i>*</i>数据库标识</label>'
				+'<div class="col-sm-9">'
					+'<input type="text" class="form-control" disabled id="EditDbName" >'
				+'</div>'
			+'</div>'
			+'<div class="form-group">'
				+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库用户</label>'
				+'<div class="col-sm-9">'
					+'<input type="text" class="form-control" id="EditUserName">'
				+'</div>'
			+'</div>'
			+'<div class="form-group">'
				+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库密码</label>'
				+'<div class="col-sm-9">'
					+'<input type="password" class="form-control" id="EditPassword">'
				+'</div>'
			+'</div>'
			+'<div class="form-group">'
				+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>数据库连接串</label>'
				+'<div class="col-sm-9">'
					+'<textarea class="form-control" rows="3" id="EditUrl"></textarea>'
				+'</div>'
			+'</div>'
			+'<div class="dialogBtns">'
				+'<button type="submit" class="btn btn-primary" id="DialogSubmit">提交</button>'
				+'<button type="submit" class="btn btn-default" id="DialogCancel">取消</button>'
			+'</div>',
		onshown: function(){
			if(dbType == 1){
		    	$('#MysqlUrlIP').val(ip);
		    	$('#MysqlUrlPort').val();
		    	$('#MysqlUrlDB').val(realDbName);
		    }else{
		    	$('#MysqlCon').addClass('hidden');
		    	$('#OracleCon').removeClass('hidden');

		    	$('#OracleType').val(connectType);

		    	if(connectType == 1){
		        	$('#OracleBasicIP').val(ip);
		        	$('#OracleBasicPort').val(port);
		        	$('#OracleBasicName').val(serviceName);
		    	}else{
		    		$('#OracleTypeBasic').addClass('hidden');
		    		$('#OracleTypeTNS').removeClass('hidden');

		   			var _ip = ip.split(',');
		        	var _port = port.split(',');
		        	var _html = '';

		        	$.each(_ip, function(k, v){
		        		var _addHtml = k == 0 ? '<div class="col-sm-2">'
										+'<a href="javascript:;" class="btn btn-primary addTNS" style="height: 24px; line-height: 24px;">添加</a>'
									+'</div>' : '<div class="col-sm-2"><a href="javascript:;" class="delTNS" style="margin-left: -22px; line-height: 28px;">删除</a></div>';
		        		_html += '<div class="form-group tnsList">'
									+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机：</label>'
									+'<div class="col-sm-4">'
										+'<input type="text" class="form-control oracleTNSIP" placeholder="主机名或IP地址" value="'+v+'">'
									+'</div>'
									+'<div class="col-sm-3">'
										+'<input type="text" class="form-control oracleTNSPort" placeholder="端口" value="'+_port[k]+'">'
									+'</div>'
									+_addHtml
								+'</div>'
		        	})
		        	
		        	$('#TnsList').html(_html);

		        	$('#OracleTNSName').val(serviceName);
		        	$('#OracleLoadBalance').val(loadBalance);
		        	$('#OracleFailover').val(failover);

		    	}
		    }
			
			
			$('#EditDbType').change(function(){
				if($('#EditDbType').val() == 1){
					$('#MysqlCon').removeClass('hidden');
					$('#OracleCon').addClass('hidden');
				}else if($('#EditDbType').val() == 2){
					$('#MysqlCon').addClass('hidden');
					$('#OracleCon').removeClass('hidden');
				}else{
					$('#MysqlCon').addClass('hidden');
					$('#OracleCon').addClass('hidden');
				}
			})

			$('#OracleType').change(function(){
				if($('#OracleType').val() == 1){
					$('#OracleTypeBasic').removeClass('hidden');
					$('#OracleTypeTNS').addClass('hidden');
				}else{
					$('#OracleTypeBasic').addClass('hidden');
					$('#OracleTypeTNS').removeClass('hidden');
				}
			})

			$('.form-control').change(function(){
				$(this).removeClass('inputError');
			})

			$('.addTNS').click(function(){
				$('#TnsList').append('<div class="form-group tnsList">'
						+'<label for="exampleInputName2" class="col-sm-3 control-label"><i>*</i>主机：</label>'
						+'<div class="col-sm-4">'
							+'<input type="text" class="form-control oracleTNSIP" placeholder="主机名或IP地址">'
						+'</div>'
						+'<div class="col-sm-3">'
							+'<input type="text" class="form-control oracleTNSPort"  placeholder="端口">'
						+'</div>'
						+'<div class="col-sm-2">'
							+'<a href="javascript:;" class="delTNS" style="margin-left: -22px; line-height: 28px;">删除</a>'
						+'</div>'
					+'</div>');
				changeVal();
			})
			
			$('.form-horizontal').on('click', '.delTNS', function(){
				$(this).parents('.form-group').remove();
				setUrl();
			})
			
			function setUrl(){
				var _url = '';
				if(!$('#MysqlCon').hasClass('hidden')){
					_url = 'jdbc:mysql://'+$('#MysqlUrlIP').val()+':'+$('#MysqlUrlPort').val()+'/'+$('#MysqlUrlDB').val()+'?useUnicode=true&characterEncoding=UTF-8'
				}else{
					if(!$('#OracleTypeBasic').hasClass('hidden')){
						_url = 'jdbc:oracle:thin:@'+ $('#OracleBasicIP').val() +':'+ $('#OracleBasicPort').val() +':'+ $('#OracleBasicName').val()
					}else{
						_url += 'jdbc:oracle:thin:@(DESCRIPTION=';

						$('.tnsList').each(function(){
							if($(this).find('.oracleTNSIP').val() != ''){
								_url += '(ADDRESS=(PROTOCOL=TCP)(HOST='+$(this).find('.oracleTNSIP').val()+')(PORT='+$(this).find('.oracleTNSPort').val()+'))';
							}
						})


						_url += '(CONNECT_DATA=(SERVICE_NAME='+$('#OracleTNSName').val()+'))';

						if($('#OracleLoadBalance').val() != -1){
							var _v = $('#OracleLoadBalance').val() == 1 ? 'on' : 'off';
							_url += '(LOAD_BALANCE='+_v+')';
						}

						if($('#OracleFailover').val() != -1){
							var _v = $('#OracleFailover').val() == 1 ? 'on' : 'off';
							_url += '(FAILOVER='+_v+')';
						}
						
						_url += ')'
					}
				}

				$('#EditUrl').val(_url);
			}
			

			function changeVal(){
				
				$('.optCon input').keyup(function(){
					setUrl();
				})

				$('.optCon select').change(function(){
					setUrl();
				})
			}

			changeVal()
			

			$('#EditAppId').html('<option>'+ appId +'</option>');
			$('#EditDbType').val(dbType);
			$('#EditDbName').val(dbName);
			$('#EditUserName').val(userName);
			$('#EditUrl').val(url);


			
			$('#DialogSubmit').click(function(){
				updateDatabase(_dialog)
			})
			
			$('#DialogCancel').click(function(){
				_dialog.close();
			})
		}
	})
}

function addDatabase(_dialog){
	//var err = validateInput() ;
    //if ( err != null ) {
    //    alert(err) ;
   //     return; 
   // }
    
    if($('#EditDbType').val() == ''){
    	alert('请选择数据库类型！');
    	$('#EditDbType').addClass('inputError');
    	return;
    }
    
    var _ip,
    	_port,
    	_realDbName,
    	_connectType,
    	_serviceName,
    	_failover,
    	_loadBalance;
    
    if($('#EditDbType').val() == 1){
    	if($('#MysqlUrlIP').val() == ''){
    		alert('请填写主机名或IP地址！');
    		$('#MysqlUrlIP').addClass('inputError');
        	return;
    	}
    	if($('#MysqlUrlPort').val() == ''){
    		alert('请填写端口！');
    		$('#MysqlUrlPort').addClass('inputError');
        	return;
    	}
    	if(isNaN(parseInt($('#MysqlUrlPort').val()))){
    		alert('端口必须是数字！');
    		$('#MysqlUrlPort').addClass('inputError');
        	return;
    	}
    	if($('#MysqlUrlDB').val() == ''){
    		alert('请填写数据库！');
    		$('#MysqlUrlDB').addClass('inputError');
        	return;
    	}
    	
    	_ip = $('#MysqlUrlIP').val();
    	_port = $('#MysqlUrlPort').val();
    	_realDbName = $('#MysqlUrlDB').val();
    }else{
    	_connectType = $('#OracleType').val();
    	if($('#OracleType').val() == 1){
    		if($('#OracleBasicIP').val() == ''){
        		alert('请填写主机名或IP地址！');
        		$('#OracleBasicIP').addClass('inputError');
            	return;
        	}
        	if($('#OracleBasicPort').val() == ''){
        		alert('请填写端口！');
        		$('#OracleBasicPort').addClass('inputError');
            	return;
        	}
        	if(isNaN(parseInt($('#OracleBasicPort').val()))){
        		alert('端口必须是数字！');
        		$('#OracleBasicPort').addClass('inputError');
            	return;
        	}
        	if($('#OracleBasicName').val() == ''){
        		alert('请填写Service Name！');
        		$('#OracleBasicName').addClass('inputError');
            	return;
        	}
        	
        	_ip = $('#OracleBasicIP').val();
        	_port = $('#OracleBasicPort').val();
        	_serviceName = $('#OracleBasicName').val();
    	}else{
    		if($('.oracleTNSIP').eq(0).val() == ''){
        		alert('请填写主机名或IP地址！');
        		$('.oracleTNSIP').eq(0).addClass('inputError');
            	return;
        	}
        	if(isNaN(parseInt($('.oracleTNSPort').eq(0).val()))){
        		alert('端口必须是数字！');
        		$('.oracleTNSPort').eq(0).addClass('inputError');
            	return;
        	}
   			if($('#OracleTNSName').val() == ''){
           		alert('请填写Service Name！');
           		$('#OracleTNSName').addClass('inputError');
               	return;
           	}
   			
   			_ip = [];
        	_port = [];
        	
        	$('#TnsList .tnsList').each(function(){
        		_ip.push($(this).find('.oracleTNSIP').val());
        		_port.push($(this).find('.oracleTNSPort').val());
        	})

        	_ip = _ip.join(',');
        	_port = _port.join(',');
        	
        	_serviceName = $('#OracleTNSName').val();
        	_loadBalance = $('#OracleLoadBalance').val();
        	_failover = $('#OracleFailover').val();
    	}
    }
    if($('#EditDbName').val() == ''){
    	alert('请填写数据库标识！');
    	$('#EditDbName').addClass('inputError');
    	return;
    }
    if($('#EditUserName').val() == ''){
    	alert('请填写用户名！');
    	$('#EditUserName').addClass('inputError');
    	return;
    }
    if($('#EditPassword').val() == ''){
    	alert('请填写密码！');
    	$('#EditPassword').addClass('inputError');
    	return;
    }
    
	$.ajax({
		type: "POST",
		url: '<%=request.getContextPath()%>/config/addDatabase.do',
		dataType: 'json',
		data: {
			appId : $('#EditAppId').val(),
            appName: $('#EditAppId option:selected').text(),
			dbType : $('#EditDbType').val(),
			dbName : $('#EditDbName').val(),
			userName : $('#EditUserName').val(),
			password : $('#EditPassword').val(),
			url: $('#EditUrl').val(),
			ip: _ip,
			port: _port,
			realDbName: _realDbName,
			connectType: _connectType,
			serviceName: _serviceName,
			failover: _failover,
			loadBalance: _loadBalance
		},
		success: function(ret) {
		     //出错
		     if (ret.err){
		    	 alert(ret.err);
		    	 return;
		     }
		     
			alert("<%=bundleJsp.getString("dbSuc")%>");

			_dialog.close();
			reload();
		},
		error: function() {
	   		alert("<%=bundleJsp.getString("dbFail")%>");
		}
	});
}

function updateDatabase(_dialog){
	if($('#EditDbType').val() == ''){
    	alert('请选择数据库类型！');
    	$('#EditDbType').addClass('inputError');
    	return;
    }
    
    var _ip,
    	_port,
    	_realDbName,
    	_connectType,
    	_serviceName,
    	_failover,
    	_loadBalance;
    
    if($('#EditDbType').val() == 1){
    	if($('#MysqlUrlIP').val() == ''){
    		alert('请填写主机名或IP地址！');
    		$('#MysqlUrlIP').addClass('inputError');
        	return;
    	}
    	if($('#MysqlUrlPort').val() == ''){
    		alert('请填写端口！');
    		$('#MysqlUrlPort').addClass('inputError');
        	return;
    	}
    	if(isNaN(parseInt($('#MysqlUrlPort').val()))){
    		alert('端口必须是数字！');
    		$('#MysqlUrlPort').addClass('inputError');
        	return;
    	}
    	if($('#MysqlUrlDB').val() == ''){
    		alert('请填写数据库！');
    		$('#MysqlUrlDB').addClass('inputError');
        	return;
    	}
    	
    	_ip = $('#MysqlUrlIP').val();
    	_port = $('#MysqlUrlPort').val();
    	_realDbName = $('#MysqlUrlDB').val();
    }else{
    	_connectType = $('#OracleType').val();
    	if($('#OracleType').val() == 1){
    		if($('#OracleBasicIP').val() == ''){
        		alert('请填写主机名或IP地址！');
        		$('#OracleBasicIP').addClass('inputError');
            	return;
        	}
        	if($('#OracleBasicPort').val() == ''){
        		alert('请填写端口！');
        		$('#OracleBasicPort').addClass('inputError');
            	return;
        	}
        	if(isNaN(parseInt($('#OracleBasicPort').val()))){
        		alert('端口必须是数字！');
        		$('#OracleBasicPort').addClass('inputError');
            	return;
        	}
        	if($('#OracleBasicName').val() == ''){
        		alert('请填写Service Name！');
        		$('#OracleBasicName').addClass('inputError');
            	return;
        	}
        	
        	_ip = $('#OracleBasicIP').val();
        	_port = $('#OracleBasicPort').val();
        	_serviceName = $('#OracleBasicName').val();
    	}else{
    		if($('.oracleTNSIP').eq(0).val() == ''){
        		alert('请填写主机名或IP地址！');
        		$('.oracleTNSIP').eq(0).addClass('inputError');
            	return;
        	}
        	if(isNaN(parseInt($('.oracleTNSPort').eq(0).val()))){
        		alert('端口必须是数字！');
        		$('.oracleTNSPort').eq(0).addClass('inputError');
            	return;
        	}
   			if($('#OracleTNSName').val() == ''){
           		alert('请填写Service Name！');
           		$('#OracleTNSName').addClass('inputError');
               	return;
           	}
   			
   			_ip = [];
        	_port = [];
        	
        	$('#TnsList .tnsList').each(function(){
        		_ip.push($(this).find('.oracleTNSIP').val());
        		_port.push($(this).find('.oracleTNSPort').val());
        	})

        	_ip = _ip.join(',');
        	_port = _port.join(',');
        	
        	_serviceName = $('#OracleTNSName').val();
        	_loadBalance = $('#OracleLoadBalance').val();
        	_failover = $('#OracleFailover').val();
    	}
    }
    if($('#EditDbName').val() == ''){
    	alert('请填写数据库标识！');
    	$('#EditDbName').addClass('inputError');
    	return;
    }
    if($('#EditUserName').val() == ''){
    	alert('请填写用户名！');
    	$('#EditUserName').addClass('inputError');
    	return;
    }
    if($('#EditPassword').val() == ''){
    	alert('请填写密码！');
    	$('#EditPassword').addClass('inputError');
    	return;
    }
    
	$.ajax({
		type: "POST",
		url : '<%=request.getContextPath()%>/config/updateDatabase.do',
		dataType: 'json',
		data: {
			appId : $('#EditAppId').val(),
            appName: $('#EditAppId option:selected').text(),
			dbType : $('#EditDbType').val(),
			dbName : $('#EditDbName').val(),
			userName : $('#EditUserName').val(),
			password : $('#EditPassword').val(),
			url: $('#EditUrl').val(),
			ip: _ip,
			port: _port,
			realDbName: _realDbName,
			connectType: _connectType,
			serviceName: _serviceName,
			failover: _failover,
			loadBalance: _loadBalance
		},

		success : function(ret) {
		     //出错
		     if (ret.err){
		    	 alert(ret.err);
		    	 return;
		     }
		     
			alert("<%=bundleJsp.getString("dbUpdateSuc")%>");
			_dialog.close();
			reload();
		},
		error : function() {
	   		alert("<%=bundleJsp.getString("dbUpdateFail")%>");
		}
	});
}
function validateInput(){
    if ( "" == $('#EditAppId').val() ){
        return "<%=bundleJsp.getString("selApp")%>";
    }
    if ( "" == $('#EditDbType').val()) {
        return "<%=bundleJsp.getString("selDbType")%>" ;
    } 
    if ( "" == $('#EditDbName').val()){
        return "<%=bundleJsp.getString("selDbName")%>" ;
    }
    if ( "" == $('#EditUserName').val()){
        return "<%=bundleJsp.getString("selDbUser")%>" ;
    }
    if ( "" == $('#EditUrl').val() ){
        return "<%=bundleJsp.getString("selDbConn")%>" ;
    }
    return null ;
}
function opDatabases(){
    var err = validateInput() ;
    if ( err != null ) {
        alert(err) ;
        return false; 
    }
	if ($('#opBtn').val() == '<%=bundleJsp.getString("add")%>'){
		addDatabase();
	}else{
		updateDatabase();
	}
}

function reload(){
	resetFields();
	$('#resultTab').trigger('reloadGrid');
}

function resetFields(){
	$('#databaseForm')[0].reset();
	
	if($('#opBtn').val() == "<%=bundleJsp.getString("update")%>"){
		$('#appId').attr('disabled',false);
		$('#dbName').attr('disabled',false);
		$('#dbType').attr('disabled',false);
		$('#opType').val("insert");
		$('#opBtn').val("<%=bundleJsp.getString("add")%>");
		$('#resetBtn').val("<%=bundleJsp.getString("reset")%>");

		$('#queryBtn').show();
		$('#opBtn').hide();
	} 
}

//流程查询
function query(){
	var appId = $('#appId').val();
	var dbType = $('#dbType').val();
	var dbName = $('#dbName').val();
    var userName = $('#userName').val();
	var url = $('#url').val();

	//查询参数
	var postData = {"appId":appId,"dbType":dbType,"dbName":dbName,"userName":userName,"url":url};
	//每次查询重置页数为1
	$("#resultTab").setGridParam({page : 1});
	
	$("#resultTab").setGridParam({
		postData : postData
	});
	$("#resultTab").setGridParam({
		datatype : 'json'
	}).trigger('reloadGrid');

}
</script>
