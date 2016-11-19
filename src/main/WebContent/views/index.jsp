<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<title>Farseer Log Management System - Management Console</title>
	<style type="text/css" title="currentStyle">
		@import "<%=request.getContextPath()%>/resources/styles/demo_page.css";
		@import "<%=request.getContextPath()%>/resources/styles/demo_table_jui.css";
		@import "<%=request.getContextPath()%>/resources/styles/demo_table.css";
		@import "<%=request.getContextPath()%>/resources/styles/jquery-ui-1.8.4.custom.css";
		@import "<%=request.getContextPath()%>/resources/styles/uploadify.css";
		@import "<%=request.getContextPath()%>/resources/styles/jquery-pop.css";
	</style>
<style type="text/css">
*{ margin:0; padding:0;}
body{ font-size:12px; font-family:Microsoft Yahei,Tahoma, Arial}
a{ color:#214FA3;}

.wrap{ margin:20px;}
.popAdd{ font-size:14px; color:#333; line-height:24px;}
.popAdd h2{ padding:5px; background:#EEF7F5; line-height:24px; font-size:16px;}
.popAdd .itemTitle{ padding:0 10px; background:#f8f8f8; line-height:24px;}
.popAdd .itemTitle .addItem{ float:right; }
.popAdd .itemTable{ padding:10px 0 15px 0;}
.popAdd .itemTable td{ padding:5px;}
.popAdd .itemTable input.col1{ width:90px;}
.popAdd .itemTable input.col2{ width:140px;}
.popAdd input{ height:16px; padding:3px; border:1px solid #ccc; line-height:16px; font-family:Tahoma; }

.addBtn{ padding: 6px 10px; cursor: pointer; display: inline-block; text-align: center; line-height: 1; *padding:4px 10px; *height:2em; letter-spacing:2px; font-family: Tahoma; width:auto; overflow:visible; *width:1; color: #333; border: solid 1px #999; border-radius: 5px; background: #DDD; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFFFF', endColorstr='#DDDDDD'); background: linear-gradient(top, #FFF, #DDD); background: -moz-linear-gradient(top, #FFF, #DDD); background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#FFF), to(#DDD)); text-shadow: 0px 1px 1px rgba(255, 255, 255, 1); box-shadow: 0 1px 0 rgba(255, 255, 255, .7),  0 -1px 0 rgba(0, 0, 0, .09); color: #FFF; border: solid 1px #3399dd; background: #2288cc; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bbee', endColorstr='#2288cc'); background: linear-gradient(top, #33bbee, #2288cc); background: -moz-linear-gradient(top, #33bbee, #2288cc); background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#33bbee), to(#2288cc)); text-shadow: -1px -1px 1px #1c6a9e; }

#uploadifyUploader{ vertical-align:middle;}
#jobTable tbody tr td.hover{ background:#8b92f9; color:#fff; cursor:pointer;}
#jobTable tbody tr td.click{ background:#707afb; color:#fff; cursor:pointer;}
</style>

</head>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/uploadify-v2.1.4/jquery.uploadify.v2.1.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/uploadify-v2.1.4/swfobject.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-pop.js"></script>
<script type="text/javascript">
$(function(){
	$('#ShowPop').click(function(){
		var dom = $('#Pop_1298534623');
		dom.show();
		
		$('#Pop_1298534623').Pop({
			fixedId:"",             //固定id的名称，配合setPosition使用
			showBot:"true",
			content:"true"
		});
		$('.need').val('').css('background','#fff');
		$('.mapReduceJobName').val('');
		$('.version').val('');
		$('.mainClass').val('');
		$('.Item1 .itemList').remove();
		$('.Item2 .itemList').remove();
		$('#fileQueue').html('');

	});

	loadJobDetail();
	
	$("#uploadify").uploadify({
        'uploader': '<%=request.getContextPath()%>/resources/script/uploadify-v2.1.4/uploadify.swf',
        'script': '../registerMapReduce/upload.do',
        'cancelImg': '<%=request.getContextPath()%>/resources/script/uploadify-v2.1.4/cancel.png',
        'queueID': 'fileQueue',
        'method': 'post',
        'auto': false,
        'multi': false,
        'onComplete': function(event, ID, fileObj, response, data) {
        	var json = getJson('#jobDetail');
        	$.ajax({
        		type : "POST",
        		url : "../registerMapReduce/add.do",
        		async : true,
        		data : {
        			params:json
        		},
        		dataType : "json",
        		success : function(data) {
        			if(data.success == 1) {
        				alert("注册成功！");
        				$('#Pop_1298534623').hide();
        				$('#PopMask').hide();
        				loadJobDetail();
        			} else {
        				alert("注册失败！" + data.message);
        			}
        		},
        		error : function(msg) {
        			alert("服务器报错！" + msg);
        		}
        	});
        	loadJobDetail();
        }
    });
});

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

function addItem(dom){
	var n = parseInt(new Date().getTime() / 1000);
	$(dom).append('<tr id="'+n+'" class="itemList"><td><input type="text" value="" class="col1"/> = </td><td><input type="text" value="" class="col2"/></td><td><a href="javascript:;" onclick="delItem('+n+')">删除</a></td></tr>');
}

function addItemEdit(dom,key,val){
	$(dom).append('<tr id="'+key+'" class="itemList"><td><input type="text" value="'+key+'" class="col1"/> = </td><td><input type="text" value="'+val+'" class="col2"/></td><td><a href="javascript:;" onclick="delItem(\''+key+'\')">删除</a></td></tr>');
}

function delItem(dom){
	$('#'+dom).remove();
}

var oTable = null;

function loadJobDetail(){
	if (oTable == null) {
		$('#dynamic').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="jobTable"></table>' );
		oTable = $('#jobTable').dataTable({
			"bProcessing": true,                               //加载数据时显示正在加载信息  
	        "bServerSide": true,                               //指定从服务器端获取数据  
	        "sAjaxSource": "../registerMapReduce/get.do", //获取数据的url  
	        "fnServerData": retrieveData,                      //获取数据的处理函数 
	        "bFilter": false,                                  //不使用过滤功能
			"bJQueryUI": true,
			"sPaginationType": "full_numbers",
			"bPaginate": true,
			"aoColumns": [
				{ "sTitle": "serNo", "sClass": "center", "sWidth": "15px"},
				{ "sTitle": "MRJobId" , "sClass": "center"},
				{ "sTitle": "MRJobName" , "sClass": "center"},
				{ "sTitle": "version", "sClass": "center" },
				{ "sTitle": "storePath", "sClass": "center" },
				{ "sTitle": "state", "sClass": "center" },
				{ "sTitle": "uploadTime", "sClass": "center" },
				{ "sTitle": "submitTime", "sClass": "center" },
				{ "sTitle": "event" }
	  		],
	  		"oLanguage": {
	  			"sProcessing": "正在加载数据..."
	  		}
		});
		
		$('#jobTable tbody tr td').live('click', function () {
			$('#jobTable tbody tr').find('td').removeClass('click');
			$(this).parent().find('td').addClass('click');
			if($(this).index() == $(this).parent().find('td').length - 1){
				return;
			}
			editJob($(this).parent().find('td').eq(1).text());
		});
		
		$('#jobTable tbody tr').live('hover', function () {
			$(this).find("td").addClass('hover');
		});
		$('#jobTable tbody tr').live('mouseleave', function () {
			$(this).find("td").removeClass('hover');
		});
	}

    oTable.fnDraw();
}

function retrieveData( sSource, aoData, fnCallback ) {
    $.ajax({  
        "type": "POST",
        "contentType": "application/json",
        "url": sSource,
        "dataType": "json",
        "data": JSON.stringify(aoData),
        "success": function(resp) {
            fnCallback(resp.jobList);
        }  
    });  
}  

function getJson(bindDom){
	var json;
	json = '{"mapReduceJobName":' + $(bindDom).find('.mapReduceJobName').val();
	json += ',"version":' + $(bindDom).find('.version').val();
	json += ',"mainClass":' + $(bindDom).find('.mainClass').val();
	
	var tr1 = $(bindDom).find('.Item1 tr');
	json += ',"JVM":{';
	for(var i=0; i<tr1.length; i++){
		json += '"';
		json += tr1.eq(i).find('.col1').val();
		json += '":"';
		json += tr1.eq(i).find('.col2').val();
		json += '",';
	}
	json = json.substring(0,json.lastIndexOf(',')); 
	if (tr1.length > 0) {
		json += '},';
	}else{
		json += ',';
	}
	
	var tr2 = $(bindDom).find('.Item2 tr');
	json += '"MR":{';
	for(var i=0; i<tr2.length; i++){
		var col1 = tr2.eq(i).find('.col1').val();
		var col2 = tr2.eq(i).find('.col2').val();
		if(col1 != "" && col2 != ""){
			json += '"' + col1 + '":"' + col2 + '",';
		}
	}
	json = json.substring(0,json.lastIndexOf(',')); 
	
	if (tr2.length > 0) {
		json += '}}';
	}else{
		json += '}';
	}
	return json;
}

function addJob(bindDom) {
	var need = 0;
	$(bindDom).find('.need').each(function(i){
		if($(this).val() == ""){
			need = 1;
			$(this).css('background','#FFECD9');
		}else{
			$(this).css('background','#fff');
		}
	});

	if(need == 1){
		alert("带\"*\"的为必填项 ！");
		return;
	}
	if($(bindDom).find('#fileQueue').html() == ""){
		alert("必须有上传的文件！");
		return;
	}
	
	$(bindDom).find('#uploadify').uploadifySettings("fileDataName","{fileName:"+$(bindDom).find(".mapReduceJobName").val()+",version:"+$(bindDom).find(".version").val()+"}");
	$(bindDom).find('#uploadify').uploadifyUpload();
}

function editJob(mapReduceJobId) {
	$.ajax({
		url : "../registerMapReduce/getDetail.do",
		type : "POST",
		async : true,
		data : {
			mapReduceJobId : mapReduceJobId
		},
		dataType : "json",
		success : function(data) {
			$('#PopEdit').Pop({
				fixedId:"",             //固定id的名称，配合setPosition使用
				showBot:"true",
				content:"true"
			});
			
			$('#jobDetailEdit').find(".Item2").html('<tr><td><input type="text" class="col1" value="-Doutput" onFocus="this.blur()"/> = </td><td><input class="col2" id="DoutputVal"/></td><td>&nbsp;<font color="red">*</font></td></tr>');
			$('#jobDetailEdit').find(".Item1").html("");
			
			$.each(data.jobDetail,function(key,val){
				if(key == "mapReduceJobName"){
					$('#jobDetailEdit').find('.mapReduceJobName').val(val);
					$('#jobDetailEdit').find('#mapReduceJobName_edit').html(val);
				}
				
				if(key == "mapReduceJobId"){
					$('#jobDetailEdit').find('#mapReduceJobId_edit').val(val);
				}
				
				if(key == "version"){
					$('#jobDetailEdit').find('.version').val(val);
					$('#jobDetailEdit').find('#version_edit').html(val);
				}
			
				if(key == "mainClass"){
					$('#jobDetailEdit').find('.mainClass').val(val);
					$('#jobDetailEdit').find('#mainClass_edit').html(val);
				}
			
				if(key == "params"){
					$.each(val,function(i,v){
						if(v.paramType == "MR"){
							if(v.paramName == '-Doutput'){
								$('#jobDetailEdit #DoutputVal').val(v.paramValue);
							}else{
								addItemEdit("#jobDetailEdit .Item2",v.paramName,v.paramValue);
							}
						}
						if(v.paramType == "JVM"){
							addItemEdit("#jobDetailEdit .Item1",v.paramName,v.paramValue);
						}
					});
				}
			});
		},
		error : function(msg) {
			alert("服务器报错！" + msg.success);
		}
	});
}

function modifyJob(bindDom) {
	var need = 0;
	var json = getJson(bindDom);
	var mapReduceJobId = $("#mapReduceJobId_edit").val();
	
	$.ajax({
		type : "POST",
		url : "../registerMapReduce/updateJobParams.do",
		async : true,
		data : {
			mapReduceJobId: mapReduceJobId,
			params: json
		},
		dataType : "json",
		success : function(data) {
			if(data.success == 1) {
				alert("提交成功！");
				$('#PopEdit').hide();
				$('#PopMask').hide();
				loadJobDetail();
			} else {
				alert("提交失败！" + data.message);
			}
		},
		error : function(msg) {
			alert("服务器报错！" + msg);
		}
	});
}

function submitJob(mapReduceJobId){
	$.ajax({
		url : "../mapReduceJobDriver/submit.do",
		type : "POST",
		async : true,
		data : {
			mapReduceJobId : mapReduceJobId
		},
		dataType : "json",
		success : function(data) {
			$('#PopSubmit').Pop({
				fixedId:"",             //固定id的名称，配合setPosition使用
				showBot:"true",
				content:"true"
			});
			
			$('#jobDetailSubmit').find(".Item2").html('<tr><td><input type="text" class="col1" value="-Doutput" onFocus="this.blur()"/> = </td><td><input class="col2" id="DoutputVal"/></td><td>&nbsp;<font color="red">*</font></td></tr>');
			$('#jobDetailSubmit').find(".Item1").html("");
			
			$.each(data.jobDetail,function(key,val){
				if(key == "mapReduceJobName"){
					$('#jobDetailSubmit').find('.mapReduceJobName').val(val);
					$('#jobDetailSubmit').find('#mapReduceJobName_submit').html(val);
				}
				
				if(key == "mapReduceJobId"){
					$('#jobDetailSubmit').find('#mapReduceJobId_submit').val(val);
				}
				
				if(key == "version"){
					$('#jobDetailSubmit').find('.version').val(val);
					$('#jobDetailSubmit').find('#version_submit').html(val);
				}
			
				if(key == "mainClass"){
					$('#jobDetailSubmit').find('.mainClass').val(val);
					$('#jobDetailSubmit').find('#mainClass_submit').html(val);
				}
			
				if(key == "params"){
					$.each(val,function(i,v){
						if(v.paramType == "MR"){
							if(v.paramName == '-Doutput'){
								$('#jobDetailSubmit #DoutputVal').val(v.paramValue);
							}else{
								addItemEdit("#jobDetailSubmit .Item2",v.paramName,v.paramValue);
							}
						}
						if(v.paramType == "JVM"){
							addItemEdit("#jobDetailSubmit .Item1",v.paramName,v.paramValue);
						}
					});
				}
			});
		},
		error : function(msg) {
			alert("服务器报错！" + msg.success);
		}
	});
}

function commitJob(bindDom) {
	var need = 0;
	var json = getJson(bindDom);
	var mapReduceJobId = $("#mapReduceJobId_submit").val();
	
	$.ajax({
		type : "POST",
		url : "../mapReduceJobDriver/commit.do",
		async : true,
		data : {
			mapReduceJobId: mapReduceJobId,
			params: json
		},
		dataType : "json",
		success : function(data) {
			if(data.success == 1) {
				alert("提交成功！");
				$('#PopSubmit').hide();
				$('#PopMask').hide();
				loadJobDetail();
			} else {
				alert("提交失败！" + data.message);
			}
		},
		error : function(msg) {
			alert("服务器报错！" + msg);
		}
	});
}

function deleteJob(mapReduceJobId){
	$.ajax({
		url : "../registerMapReduce/delete.do",
		type : "POST",
		async : true,
		data : {
			mapReduceJobId : mapReduceJobId
		},
		dataType : "json",
		success : function(data) {
			if(data.success == 1) {
				alert("删除成功！");
				loadJobDetail();
			} else {
				alert("删除失败！");
			}
		},
		error : function(msg) {
			alert("服务器报错！" + msg.success);
		}
	});
}
</script>
<body>
<div class="wrap">
	<h1>Farseer Log Management System - Management Console</h1>
	<div style="padding:10px 0 15px; text-align:right; line-height:24px;"><button class="addBtn" id="ShowPop">添加</button></div>
	<div id="dynamic"></div>


<div id="Pop_1298534623" class="pop" style="display:none; width: 700px; height: 545px; z-index: 1298534624; top: 0px; left: 360.5px;">
	<div class="popTitle">Regist Jar<a class="popClose" href="javascript:;" onclick="$('#Pop_1298534623').hide();$('#PopMask').hide();">x</a></div><div class="popCon"><div style="" id="pop1" pop="1298534623">
	<form action="" id="jobDetail">
		<div class="popAdd">
			<div style="padding:15px 30px; font-size:14px;">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody><tr>
						<td height="35" align="right">mapReduceJobName: </td>
						<td>&nbsp;<input type="text" size="50" value="" class="mapReduceJobName" class="need">&nbsp;<font color="red">*</font></td>
					</tr>
					<tr>
						<td height="35" align="right">version: </td>
						<td>&nbsp;<input type="text" size="50" value="" class="version" class="need">&nbsp;<font color="red">*</font></td>
					</tr>
					<tr>
						<td height="35" align="right">mainClass: </td>
						<td>&nbsp;<input type="text" size="50" value="" class="mainClass" class="need">&nbsp;<font color="red">*</font></td>
					</tr>
				</tbody></table>
			</div>
			<h2>Params:</h2>

			<div style="overflow:hidden; border-bottom:1px solid #D7EAE2 ">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody><tr>
						<td valign="top" style=" width:345px; border-right:1px solid #D7EAE2 ">
							<div class="itemTitle">
								<div class="addItem"><a onclick="addItem('#jobDetail .Item2')" href="javascript:;">添加</a></div>M/R:
							</div>
							<div style="height:200px; overflow-y:auto">
								<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable" >
									<tr><td><input type="text" class="col1" value="-Doutput" onFocus="this.blur()"/> = </td><td><input type="text" class="col2 need" value=""></td><td>&nbsp;<font color="red">*</font></td></tr>
								</table>
							</div>
						</td>
						<td valign="top" style="width:344px;">
							<div class="itemTitle">
								<div class="addItem"><a onclick="addItem('#jobDetail .Item1')" href="javascript:;">添加</a></div>JVM:
							</div>
							<div style="height:200px; overflow-y:auto">
								<table cellspacing="0" cellpadding="0" border="0" class="Item1 itemTable"></table>
							</div>
						</td>
					</tr>
				</tbody></table>	
			</div>
		</div>

		<div style=" height:50px; padding:5px 10px 10px; border-bottom:1px solid #D7EAE2; position:relative;">
			<div style="float:left; width:250px; margin-top:10px;">file path: <input width="120" type="file" height="30" name="uploadify" id="uploadify" style="display: none;"></div>
			<div style="float:left; width:300px;" id="fileQueue" class="uploadifyQueue"></div>
		</div>
	</form>
</div></div><div class="popBot"><button class="btnSubmit" onclick="addJob('#jobDetail')">Submit</button></div></div>




<div id="PopEdit" class="pop" style="display:none; width: 700px; height: 500px; z-index: 1298534624; top: 0px; left: 360.5px;">
	<div class="popTitle">Edit Jar<a class="popClose" href="javascript:;" onclick="$('#PopEdit').hide();$('#PopMask').hide();">x</a></div><div class="popCon"><div style="" id="pop_edit">
	<form action="" id="jobDetailEdit">
		<div class="popAdd">
			<div style="padding:15px 30px; font-size:14px;">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody><tr>
						<td height="35" align="right">mapReduceJobName: </td>
						<td>&nbsp;<input type="hidden" class="mapReduceJobName" /><b id="mapReduceJobName_edit"></b></td>
					</tr>
					<tr>
						<td height="35" align="right">version: </td>
						<td>&nbsp;<input type="hidden" class="version" /><b id="version_edit"></b></td>
					</tr>
					<tr>
						<td height="35" align="right">mainClass: </td>
						<td>&nbsp;<input type="hidden" class="mainClass" /><b id="mainClass_edit"></b></td>
					</tr>
				</tbody></table>
			</div>
			<h2>Params:</h2>

			<div style="overflow:hidden; border-bottom:1px solid #D7EAE2 ">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody><tr>
						<td valign="top" style=" width:345px; border-right:1px solid #D7EAE2 ">
							<div class="itemTitle">
								<div class="addItem"><a onclick="addItem('#jobDetailEdit .Item2')" href="javascript:;">添加</a></div>M/R:
							</div>
							<div style="height:200px; overflow-y:auto">
								<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable"></table>
							</div>
						</td>
						<td valign="top" style="width:344px;">
							<div class="itemTitle">
								<div class="addItem"><a onclick="addItem('#jobDetailEdit .Item1')" href="javascript:;">添加</a></div>JVM:
							</div>
							<div style="height:200px; overflow-y:auto">
								<table cellspacing="0" cellpadding="0" border="0" class="Item1 itemTable"></table>
							</div>
						</td>
					</tr>
				</tbody></table>	
			</div>
		</div>
		<input type="hidden" id="mapReduceJobId_edit"/>

	</form>
</div></div><div class="popBot"><button class="btnSubmit" onclick="modifyJob('#jobDetailEdit')">Modify</button></div></div>




<div id="PopSubmit" class="pop" style="display:none; width: 700px; height: 500px; z-index: 1298534624; top: 0px; left: 360.5px;">
	<div class="popTitle">Submit Jar<a class="popClose" href="javascript:;" onclick="$('#PopSubmit').hide();$('#PopMask').hide();">x</a></div><div class="popCon"><div style="" id="pop_submit">
	<form action="" id="jobDetailSubmit">
		<div class="popAdd">
			<div style="padding:15px 30px; font-size:14px;">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody><tr>
						<td height="35" align="right">mapReduceJobName: </td>
						<td>&nbsp;<input type="hidden" class="mapReduceJobName" /><b id="mapReduceJobName_submit"></b></td>
					</tr>
					<tr>
						<td height="35" align="right">version: </td>
						<td>&nbsp;<input type="hidden" class="version" /><b id="version_submit"></b></td>
					</tr>
					<tr>
						<td height="35" align="right">mainClass: </td>
						<td>&nbsp;<input type="hidden" class="mainClass" /><b id="mainClass_submit"></b></td>
					</tr>
				</tbody></table>
			</div>
			<h2>Params:</h2>

			<div style="overflow:hidden; border-bottom:1px solid #D7EAE2 ">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody><tr>
						<td valign="top" style=" width:345px; border-right:1px solid #D7EAE2 ">
							<div class="itemTitle">
								<div class="addItem"><a onclick="addItem('#jobDetailSubmit .Item2')" href="javascript:;">添加</a></div>M/R:
							</div>
							<div style="height:200px; overflow-y:auto">
								<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable"></table>
							</div>
						</td>
						<td valign="top" style="width:344px;">
							<div class="itemTitle">
								<div class="addItem"><a onclick="addItem('#jobDetailSubmit .Item1')" href="javascript:;">添加</a></div>JVM:
							</div>
							<div style="height:200px; overflow-y:auto">
								<table cellspacing="0" cellpadding="0" border="0" class="Item1 itemTable"></table>
							</div>
						</td>
					</tr>
				</tbody></table>	
			</div>
		</div>
		<input type="hidden" id="mapReduceJobId_submit" />

	</form>
</div></div><div class="popBot"><button class="btnSubmit" onclick="commitJob('#jobDetailSubmit')">Commit</button></div></div>

</div>

</body>
</html>