<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page
	import="com.lenovo.lps.farseer.priest2.platform.security.AccessSession"%>
<%@page import="java.util.ResourceBundle"%>
<%
	Locale localeJsp = AccessSession.getLocale(request);
	String localeTypeJsp = localeJsp.getLanguage().toLowerCase();
	ResourceBundle bundleJsp = ResourceBundle.getBundle("i18n.i18n", localeJsp);
%>
<script type="text/javascript">
window.i18nValue="<%=localeTypeJsp%>";
</script>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/styles/main.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/styles/jquery-ui-1.8.4.custom.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/raphael-min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery-ui-1.8.4.custom.min.js"></script>

<!-- ui time -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/mobiscroll-2.0.1.full.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/mobiscroll-2.0.1.full.min.js"></script>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery.json-2.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/jquery.i18n.properties-min-1.0.9.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/myflow.js?20160908"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/myflow.editors.js?20160908"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/script/myflow.jpdl4.js?20160908"></script>
	
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/script/jquery-ui-timepicker-addon.min.js"></script>
	

<script type="text/javascript">	
window.DateBJ = new Date((new Date(<%=new java.util.Date().getTime()%>).getTime()+((new Date(<%=new java.util.Date().getTime()%>).getTimezoneOffset()+480)*60000))).getTime();
   //是否为admin账户标志
    var isAdmin = false;
   
	//非root用户,限定只能选择正常选择级
	<%
		if (AccessSession.getUserIsAdmin(request.getSession())) {
	%>
		isAdmin = true;
	<%}%>	
	
	//增加属性editor
	function addItem(dom,key,value){
		var n = parseInt(new Date(DateBJ).getTime());
		n = n*parseInt(Math.random()*1000+1);
		if (key){
			$(dom).append('<tr id="'+n+'" class="itemList"><td><input type="text" value="' + key + '" class="keyClass"/>&nbsp;=&nbsp;</td><td><input type="text" value="' + value + '" class="valueClass"/></td><td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" class="btn btn-default btn-sm" onclick="delItem('+n+')"><%=bundleJsp.getString("delete")%></a></td></tr>');
		}
		else{
			$(dom).append('<tr id="'+n+'" class="itemList"><td><input type="text" value="" class="keyClass"/>&nbsp;=&nbsp;</td><td><input type="text" value="" class="valueClass"/></td><td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" class="btn btn-default btn-sm" onclick="delItem('+n+')"><%=bundleJsp.getString("delete")%></a></td></tr>');
		}
		
	}	
	//删除属性editor
	function delItem(dom){
		$('#'+dom).remove();
	}	
		
	//流程名称正则表达式
	var namePattern = /[\s\\\/\*\?\,\.\|<>:"']+/
	
  //参数检查
  function inputCheck(jsonDef){
		//=>>>>>>>>begin 流程参数非空检查
		var process = JSON.parse(jsonDef);
		
		//日期正则
		var datePattern = /(\d{4})-(\d{1,2})-(\d{1,2})/;
		
		
		//流程名称
		var processName =  process.props.props.processName.value;          
		var processNameInput = $('#pprocessName').find('input');
		if (!processName){
			alert("<%=bundleJsp.getString("selProName")%>");
			
			if (processNameInput){
				$(processNameInput).focus();
			}
			return false;
		}
		if(processName){
			var length = processName.length;
			if (processName.length>200){
				alert("<%=bundleJsp.getString("proNameWarning")%>");
				return false;
			}
			if(namePattern.test(processName)){
				alert("<%=bundleJsp.getString("proNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
		
		//有效期
		var validate = process.props.props.validate.value;
		var validateInput = $('#pvalidate').find('input');
		if (validate){
			var results = validate.match(datePattern);
			var validDate=new Date(results[1],results[2] -1 ,results[3]);
			var  now = new Date(DateBJ);
			var toDay = new Date(now.getFullYear(),now.getMonth(),now.getDate());
			if (validDate < toDay){
				alert('<%=bundleJsp.getString("validateWarning")%>');
				
				if (validateInput){
					$(validateInput).focus();
				}
				return false;
			}		
		}	
		
		//所属应用
		var appName = process.props.props.appName.value;
		var appNameInput = $('#pappName').find('select');
		if (!appName){
			alert("<%=bundleJsp.getString("selApp")%>");
			
			if (appNameInput){
				$(appNameInput).focus();
			}			
			return false;
		}	
		
		//调度类型
		var scheduleType = process.props.props.scheduleType.value;
		var scheduleTypeInput = $('#pscheduleType').find('select');
		if (!scheduleType){
			alert("<%=bundleJsp.getString("selScheduleType")%>");
			
			if (scheduleTypeInput){
				$(scheduleTypeInput).focus();
			}	
			return false;
		}	
		
		//调度日期
		var scheduleDate = process.props.props.scheduleDate.value;
		var scheduleDateInput = $('#pscheduleDate').find('input');
		//非空检查
		if (!scheduleDate){
			alert("<%=bundleJsp.getString("selScheduleDate")%>");
			
			if (scheduleDateInput){
				$(scheduleDateInput).focus();
			}				
			return false;
		}
		//日期合法性检查
		else{
			var results = scheduleDate.match(datePattern);

			var scheduleD=new Date(results[1],results[2]-1,results[3]);
			var  now = new Date(DateBJ);
			var toDay = new Date(now.getFullYear(),now.getMonth(),now.getDate());
			if (scheduleD < toDay){
				alert('<%=bundleJsp.getString("scheduleDateW")%>');
				
				if (scheduleDateInput){
					$(scheduleDateInput).focus();
				}	
				return false;
			}
		}	
		
		//调度时间
		var scheduleTime = process.props.props.scheduleTime.value;
		var scheduleTimeInput = $('#pscheduleTime').find('input');
		if (!scheduleTime){
			alert("<%=bundleJsp.getString("selScheduleTime")%>");
			
			if (scheduleTimeInput){
				$(scheduleTimeInput).focus();
			}				
			return false;
		}
		
		//最晚调度时间
		var lateStartTime = process.props.props.lateStartTime.value;
		var lateStartTimeInput = $('#plateStartTime').find('input');
		if (lateStartTime){
			var timePattern = /([0-2][0-9]):([0-5][0-9])/;
			var results = lateStartTime.match(timePattern);
			var lateHour=results[1];
			var lateMinute=results[2];
			
			var resultSchedule = scheduleTime.match(timePattern);
			var scheduleHour=resultSchedule[1];
			var scheduleMinute=resultSchedule[2];			

			var nowTime = new Date(DateBJ);
			var  scheduleT = new Date(now.getFullYear(),now.getMonth(),now.getDate(),scheduleHour,scheduleMinute,0);
			var  lateScheduleT = new Date(now.getFullYear(),now.getMonth(),now.getDate(),lateHour,lateMinute,0);
			if (lateScheduleT < scheduleT){
				alert('<%=bundleJsp.getString("lastScheW")%>');
				if (lateStartTimeInput){
					$(lateStartTimeInput).focus();
				}	
				
				return false;
			}
		}
				
		
		//失败告警
		var alermMethod = process.props.props.alermMethod.value;
		var alermPerson = process.props.props.alermPerson.value;
		var alermMethodInput = $('#palermMethod').find('select');
		var alermPersonInput = $('#palermPerson').find('input');
		if (alermMethod && alermMethod != 'N'){
			if (!alermPerson){
				alert("<%=bundleJsp.getString("selAlarmPer")%>");
				
				if (alermPersonInput){
					$(alermPersonInput).focus();
				}	
				return false;
			}
		}	
		//=>>>>>>>>end 流程参数非空检查
		
		//组件参数检查
		var components = process.states;

		//流程Id
		var proId =  process.props.props.processId.value;  
		//属性遍历
		for(var p in components){
			if (typeof p != "function" && p.indexOf('rect') > -1){
					var component = components[p];
					var componentType = component.type;
					
					//输入参数是否合理标记
					var isOk = false;
					switch(componentType){
                    // notify
                    case 'notify':
                        isOk = notifyInputCheck(component);
						if (!isOk){
							return false;
						}
						break;
                        
					//依赖组件
					case 'dep':
						isOk = depInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;
					//Cache组件
					case 'cache':
						isOk = cacheInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;
					//Java组件
					case 'java':
						isOk = javaInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;
					//Shell组件
					case 'shell':
						isOk = shellInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;
					//mysql组件
					case 'mysql':
						isOk = mysqlInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;
					//hive组件
					case 'hive':
						isOk = hiveInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;	
					//spark sql组件
					case 'sparksql':
						isOk = sparkSqlCheck(component);
						
						if (!isOk){
							return false;
						}
						break;	
					//sparkjar组件
					case 'sparkjar':
						isOk = sparkJarCheck(component);
						
						if (!isOk){
							return false;
						}
						break;	
					//mapreduce组件
					case 'mapreduce':
						isOk = mapreduceInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;	
					//hdfs组件
					case 'hdfs':
						isOk = hdfsInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;		
					//transfer组件
					case 'transfer':
						isOk = transferInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;							
					//Oracle组件
					case 'oracle':
						isOk = oracleInputCheck(component);
						
						if (!isOk){
							return false;
						}
						break;							
					}					
					//end switch
			}
		}
		
		if(jsonDef.length>41999){
			alert("<%=bundleJsp.getString("processWarning")%>");
			return false;
		}
		var results = scheduleDate.match(datePattern);
		var scheduleD=new Date(results[1],results[2]-1,results[3]);
		var  now = new Date(DateBJ);
		var today = new Date(now.getFullYear(),now.getMonth(),now.getDate());
		if (scheduleD - today == 0){
			if(!confirm("<%=bundleJsp.getString("savePro")%>")){
				if (scheduleDateInput){
					$(scheduleDateInput).focus();
				}	
				return false;
			} else {
				if(!confirm("<%=bundleJsp.getString("saveProRun")%>")){
					return false;
				}
			}
		}
	
		
		return true;
  }
  // notify component check
  function notifyInputCheck(cpnt){
	  var props = cpnt.props;
	  var taskId   = props.taskId.value;
	  var taskName = props.taskName.value ;
	  var person   = props.alermPerson.value;
	  var content  = props.alermContent.value;
	  
      var which = taskId != "" ? "ID"+taskId+"<%=bundleJsp.getString("ofTask")%>" : "<%=bundleJsp.getString("emailpNotice")%>"
      
	  if (!taskName || taskName == ""){
		  alert(which + "<%=bundleJsp.getString("selTaskName")%>");
		  return false;
	  }
	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert(which + "<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert(which +"<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!person || person == ""){
		  alert(which+"<%=bundleJsp.getString("selNotice")%>");
		  return false;
	  }	  
	  var errors = "" ;
      var cnt = 0; 
      var targets = person.split('\n');
      var phone =/^1[0-9]{10}$/;
      var mail  = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      for( var i = 0 ; i<targets.length;i++){
        var tgts = targets[i].trim().split(',');
        if (tgts.length > 1) {
        	for (var j = 0; j < tgts.length; j++) {
            	var tgt = tgts[j].trim();
            	if ( tgt.length > 0 && (phone.test(tgt))){
                    cnt += 1;
                }else if( tgt.length>0){
                    errors = errors + tgt + "," ;
                }
            }
        } else {
            tgts = targets[i].trim().split(';');
            if (tgts.length > 1) {
            	for (var j = 0; j < tgts.length; j++) {
                	var tgt = tgts[j].trim();
                	if ( tgt.length > 0 && (mail.test(tgt))){
                        cnt += 1;
                    }else if( tgt.length>0){
                        errors = errors + tgt + "," ;
                    }
                }
            } else {
            	var tgt = targets[i].trim();
            	if ( tgt.length > 0 && (phone.test(tgt) || mail.test(tgt))){
                    cnt += 1;
                }else if( tgt.length>0){
                    errors = errors + tgt + "," ;
                }
            }
        }
      }
      if ( cnt < 1 ){
        alert(which+ "<%=bundleJsp.getString("empNotice")%>"); 
        return false ;
      }
      if ( errors.length > 0 ){
        alert(which+ "<%=bundleJsp.getString("noticeWrong")%>"+errors);
        return false;
      }
	  if (!content || content == ""){
		  alert(which+"<%=bundleJsp.getString("selNoticeCon")%>");
		  return false;
	  }	  
	  
	  return true;
  }
   
  //依赖组件参数检查
  function depInputCheck(dep){
	  var props = dep.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  var target = props.target.value;
	  var depType = props.depType.value;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  var number =/^[0-9]+$/;
	  if(depType == "process") {
	  	if (!target || target == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskId")%>");
		  return false;
	  	}
	  	if (!number.test(target)){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskIdErr")%>");
		  return false;
	  	}
	  } else if (depType == "hdfs_dir") {
	  	if (!target || target == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofFilePath")%>");
		  return false;
	  	}
	  } else if (depType == "hdfs_size") {
	  	if (!target || target == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofFilePath")%>");
		  return false;
	  	}
	  	var targetNum = props.targetNum.value;
	  	if (!targetNum || targetNum == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTargetNum")%>");
		  return false;
	  	}
	  	if (!number.test(targetNum)){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTargetNumErr")%>");
		  return false;
	  	}
	  } else if (depType == "tbl_count") {
	  	var depDbType = props.depDbType.value;
	  	if(depDbType == "mysql") {
	  		var rdbmsDB = props.rdbmsDB.value;
	  		if (!rdbmsDB || rdbmsDB == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskMysql")%>");
			  return false;
		  	}
	  	} else if (depDbType == 'oracle') {
	  		var rdbmsDB = props.rdbmsDB.value;
	  		if (!rdbmsDB || rdbmsDB == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskOracle")%>");
			  return false;
		  	}
	  	}
	  	if (!target || target == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSql")%>");
		  return false;
	  	}
	  	
	  	var targetNum = props.targetNum.value;
	  	
	  	if (!targetNum || targetNum == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTargetNum")%>");
		  return false;
	  	}
	  	if (!number.test(targetNum)){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTargetNumErr")%>");
		  return false;
	  	}
	  } 
	  	  
	  
	  return true;
  }
  
  //cache组件参数检查
  function cacheInputCheck(cache){
	  var props = cache.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  var cacheOp = props.cacheOp.value ;
	  var key = props.key.value ;
	  var value = props.value.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!cacheOp || cacheOp == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskCache")%>");
		  return false;
	  }	  
	  
	  if (!key || key == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskCkey")%>");
		  return false;
	  }
	  
	  if (props.cacheOp == 's'){
		  if (!value || value == ""){
			  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskCval")%>");
			  return false;
		  }		  
	  }
	  
	  return true;
  }  
  
  //java组件参数检查
  function javaInputCheck(java){
	  var props = java.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  var jar = props.jar.value ;
	  var className = props.className.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!jar || jar == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskJar")%>");
		  return false;
	  }	  
	  
	  if (!className || className == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskClass")%>");
		  return false;
	  }	  
	  return true;
  } 
  
  //shell组件参数检查
  function shellInputCheck(shell){
	  var props = shell.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var shellFile = props.shellFile.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!shellFile || shellFile == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskShell")%>");
		  return false;
	  }	  
  
	  return true;
  } 
  
  //mysql组件参数检查
  function mysqlInputCheck(mysql){
	  var props = mysql.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var sql = props.sql.value ;
	  var rdbmsDB = props.rdbmsDB.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
		
		  if (!sql || sql == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSql")%>");
			  return false;
		  }	 	
	  
		  if (!rdbmsDB || rdbmsDB == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskMysql")%>");
			  return false;
		  }	  
  
	  return true;
  }   
  
  //hive组件参数检查
  function hiveInputCheck(hive){
	  var props = hive.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var hsql = props.hsql.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!hsql || hsql == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSql")%>");
		  return false;
	  }	  
  
	  return true;
  }  
  
  //mapreduce组件参数检查
  function mapreduceInputCheck(mapreduce){
	  var props = mapreduce.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var mrJar = props.mrJar.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>10){
				alert("ID:" + taskId+"<%=bundleJsp.getString("taskMrNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("ID:" + taskId+"<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!mrJar || mrJar == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskMr")%>");
		  return false;
	  }	  
  
	  return true;
  } 
  //hive组件参数检查
  function sparkSqlCheck(sparksql){
	  var props = sparksql.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var ssql = props.ssql.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!ssql || ssql == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSql")%>");
		  return false;
	  }	  
  
	  return true;
  }  
  
  //mapreduce组件参数检查
  function sparkJarCheck(sparkjar){
	  var props = sparkjar.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var mainClass = props.mainClass.value ;
	  var jar = props.jar.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  
	  if (!jar || jar == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskMr")%>");
		  return false;
	  }	  
	  
	  if (!mainClass || mainClass == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskClass")%>");
		  return false;
	  }	 
	  return true;
  } 
  
  //hdfs组件参数检查
  function hdfsInputCheck(hdfs){
	  var props = hdfs.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var hdfsOp = props.hdfsOp.value ;
	  var srcPath = props.srcPath.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!hdfsOp || hdfsOp == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskHdfs")%>");
		  return false;
	  }	 
	  
	  if (!srcPath || srcPath == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSpath")%>");
		  return false;
	  }
	  
	    //目标路径检查
	    switch(hdfsOp){
	    //upload
	    case 'upload':	    
	    //copy
	    case 'copy':
		// move
		case 'move':
		var destPath = props.destPath.value ;			
	  	  if (!destPath || destPath == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskDpath")%>");
			  return false;
		  }   	
	    	break;		    
		}		  
  
	  return true;
  }    
  
  //transfer组件参数检查
  function transferInputCheck(transfer){
	  var props = transfer.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var transferMode = props.transferMode.value ;
	  var sourceData = props.sourceData.value ;
	  var destData = props.destData.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
	  
	  if (!transferMode || transferMode == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskTrans")%>");
		  return false;
	  }	 

	  if (!sourceData || sourceData == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSrc")%>");
		  return false;
	  }	
	  
	  if (!destData || destData == ""){
		  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskDest")%>");
		  return false;
	  }
	  
	  switch (transferMode){
		// HIVE >>> MySQL
	    case 'H2M':
		    if (!props.rdbmsDB.value || props.rdbmsDB.value == ""){
		    	alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskMysql")%>");
				return false;
		    }
			break;
		// MySQL >>> Hive
	    case 'M2H':
		    if (!props.rdbmsDB.value || props.rdbmsDB.value == ""){
		    	alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskMysql")%>");
				return false;
		    }	    
		    break;	
		// Hive >>> Oracle
	    case 'H2O':
		    if (!props.rdbmsDB.value || props.rdbmsDB.value == ""){
		    	alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskOracle")%>");
				return false;
		    }					
		    break;		    
		// create文件
		case 'O2H':
		    if (!props.rdbmsDB.value || props.rdbmsDB.value == ""){
		    	alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskOracle")%>");
				return false;
		    }			
		    break;    
		
	  }
  
	  return true;
  }  
  
  //mysql组件参数检查
  function oracleInputCheck(mysql){
	  var props = mysql.props;
	  var taskId = props.taskId.value;
	  var taskName = props.taskName.value ;
	  
	  var sql = props.sql.value ;
	  var rdbmsDB = props.rdbmsDB.value ;
	  
	  if (!taskName || taskName == ""){
		  alert("ID:" + taskId+"<%=bundleJsp.getString("ofTaskName")%>");
		  return false;
	  }
	  	  
	  if (taskId != "" && taskId == "0"){
		  alert(taskName + "<%=bundleJsp.getString("selTaskId")%>");
		  return false;
	  }
	  
		if(taskName){
			var length = taskName.length;
			if (taskName.length>200){
				alert("<%=bundleJsp.getString("taskNameWarning")%>");
				return false;
			}
			if(namePattern.test(taskName)){
				alert("<%=bundleJsp.getString("taskNameNotC")%>\\/|*?,.<>:\"'");
				return false;
			}
		}
		
		  if (!sql || sql == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskSql")%>");
			  return false;
		  }	 	
	  
		  if (!rdbmsDB || rdbmsDB == ""){
			  alert("ID:" + taskId +"<%=bundleJsp.getString("ofTaskOracle")%>");
			  return false;
		  }	  
  
	  return true;
  }     
  
  //后台保存新增/修改
  function save(jsonDef){
	if (!inputCheck(jsonDef)){
		return false;
	}

  	var url = '<%=request.getContextPath()%>/process/save.do';
    var param = {"jsonDef":jsonDef};
	$.ajax({
		type : "POST",
		url : url,
		async : true,
		dataType : 'json',
		data : param,
		success : function(ret) {
			// 出错提示
			if (ret.err) {
				alert(ret.err);
			} else {
				alert("<%=bundleJsp.getString("success")%>");				
				//新建流程时,会返回processId
				if (ret.processId){
					$('#processId').val(ret.processId);
					//调用change事件,通知控件值改变
					$('#processId').change();
				}
			}
		},
	error : function() {
		// 出错提示
	   window.parent.location.href="<%=request.getContextPath()%>/views/process_run.jsp";
	}
		
	});    	
  }
  
  //文件上传到服务器
  function fileUpload(){
  	var url = "<%=request.getContextPath()%>/config/uploadJar.do";
  	var data = new FormData();
  	
  	
  	var file = jQuery('#uploadJar').get(0).files[0];
    if (file && file.size > 1024 * 1024 * 50){
    	alert('上传文件大小不能超过50M!');
    	return -1;
    }
  	
  	jQuery.each($('#uploadJar')[0].files, function(i, file) {
  	    data.append('file-'+i, file);
  	});  	
    var serverFileName;
    
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		cache: false,
	    contentType: false,
	    processData: false,		
	    data:data,
		success : function(ret) {
			// 出错提示
			if (ret.err) {
				alert(ret.err);
			} else {
				serverFileName = ret.list[0];
			}
		},
		error : function() {
			// 出错提示
			alert('上传文件大小不能超过57M!');
		}
	});  
	
	return serverFileName;
  }
</script>
<script type="text/javascript">
	$(function() {
		//jquery ui datepicker中文设置
		$.datepicker.regional['zh-CN'] = {
			closeText : '<%=bundleJsp.getString("close")%>',
			prevText : '<<%=bundleJsp.getString("lastMonth")%>',
			   nextText: '<%=bundleJsp.getString("nextMonth")%>>',
			currentText : '<%=bundleJsp.getString("today")%>',
			monthNames : [ '<%=bundleJsp.getString("january")%>', '<%=bundleJsp.getString("february")%>', '<%=bundleJsp.getString("march")%>', '<%=bundleJsp.getString("april")%>', '<%=bundleJsp.getString("may")%>', '<%=bundleJsp.getString("june")%>', '<%=bundleJsp.getString("july")%>', '<%=bundleJsp.getString("august")%>', '<%=bundleJsp.getString("september")%>', '<%=bundleJsp.getString("october")%>', '<%=bundleJsp.getString("november")%>', '<%=bundleJsp.getString("december")%>' ],
			monthNamesShort : [ '<%=bundleJsp.getString("jan")%>', '<%=bundleJsp.getString("feb")%>', '<%=bundleJsp.getString("mar")%>', '<%=bundleJsp.getString("apr")%>', '<%=bundleJsp.getString("may")%>', '<%=bundleJsp.getString("jun")%>', '<%=bundleJsp.getString("jul")%>', '<%=bundleJsp.getString("aug")%>', '<%=bundleJsp.getString("sep")%>', '<%=bundleJsp.getString("oct")%>', '<%=bundleJsp.getString("nov")%>', '<%=bundleJsp.getString("dec")%>' ],
			dayNames : [ '<%=bundleJsp.getString("sunday")%>', '<%=bundleJsp.getString("monday")%>', '<%=bundleJsp.getString("tuesday")%>', '<%=bundleJsp.getString("wednesday")%>', '<%=bundleJsp.getString("thursday")%>', '<%=bundleJsp.getString("friday")%>', '<%=bundleJsp.getString("saturday")%>' ],
			dayNamesShort : [ '<%=bundleJsp.getString("sun")%>', '<%=bundleJsp.getString("mon")%>', '<%=bundleJsp.getString("tue")%>', '<%=bundleJsp.getString("wed")%>', '<%=bundleJsp.getString("thu")%>', '<%=bundleJsp.getString("fri")%>', '<%=bundleJsp.getString("sat")%>' ],
			dayNamesMin : ['<%=bundleJsp.getString("sunMin")%>', '<%=bundleJsp.getString("monMin")%>', '<%=bundleJsp.getString("tueMin")%>', '<%=bundleJsp.getString("wedMin")%>', '<%=bundleJsp.getString("thuMin")%>', '<%=bundleJsp.getString("friMin")%>', '<%=bundleJsp.getString("satMin")%>' ],
			weekHeader : '<%=bundleJsp.getString("week")%>',
			dateFormat : 'yy-mm-dd',
			firstDay : 1,
			isRTL : false,
			showMonthAfterYear : true,
			yearSuffix : '<%=bundleJsp.getString("year")%>'
		};
		$.datepicker.setDefaults($.datepicker.regional['zh-CN']);

		$('#popupDialog').bind("click", function() {
			//用户在弹出框在输入完数据,或者选择cancel放弃输入时,会触发画板的click事件
			$(window).data("popupClick", "aa");
		});
		
		$('#popupPropertyDialog').bind("click", function() {
			//用户在弹出框在输入完数据,或者选择cancel放弃输入时,会触发画板的click事件
			$(window).data("popupClick", "aa");
		});		

		$('#fileUploadDiv').bind("click", function() {
			//用户在弹出框在输入完数据,或者选择cancel放弃输入时,会触发画板的click事件
			$(window).data("popupClick", "aa");
		});

		//弹出输入框
		$('#popupDialog').dialog(
				{
					modal : true,
					autoOpen : false,
					position : [ 'right', 'top' ],
					title : 'Input please',
					width : 500,
					height : 500,
					buttons : {
						'Cancel' : function() {
							$(window).data("popupClick", "aa");
							$(this).dialog('close');

						},
						'Ok' : function() {
							$(window).data("popupClick", "aa");

							//输入值
							var inputVal = $(this).find('#widgetName').val();
							
							//验证SQL准确性
							var nodeName = $(this).data('clickInput').nodeName;
							if(nodeName.toUpperCase() === 'TEXTAREA'){
								var contentType = $(this).data('contentType');
								if(contentType === 'msql' || contentType === 'hsql' || contentType === 'ssql'){
									var isOK = true;
									$.ajax({
										type : "POST",
										async : false,
										url : '<%=request.getContextPath()%>/process/checkSql.do',
														dataType : 'json',
														data : {
															'sqlType' : contentType,
															'sql' : inputVal
														},
														success : function(ret) {
															if (ret.isErr) {
																alert(ret.errMsg);
																isOK = false;
															}
														}
													});

											if (!isOK) {
												return false;
											}
										}
									}

									//保存输入值
									$($(this).data('clickInput')).val(inputVal);

									//调用change事件,通知控件值改变
									$($(this).data('clickInput')).change();

									$(this).dialog('close');

									//清除
									$(this).data('clickInput', null);
								}
							}
						});

		//弹出属性框
		$('#popupPropertyDialog').dialog({
			modal : true,
			autoOpen : false,
			position : [ 'right', 'top' ],
			title : 'Input please',
			width : 500,
			height : 600,
			buttons : {
				'Cancel' : function() {
					$(window).data("popupClick", "aa");
					$(this).dialog('close');

				},
				'Ok' : function() {
					$(window).data("popupClick", "aa");
					
					var _isAdd = $($(this).data('clickInput')).parent().attr('id') == 'pprocessVariables';

					//job参数
					var jobProperties = '';
					$('.itemList').each(function() {
						var key = $(this).find('.keyClass').val();
						var value = $(this).find('.valueClass').val();

						
						if (key) {
							if(_isAdd){
								if(key.indexOf('$') == -1){
									key = '\${'+key+'}';
								}
							}
							jobProperties += key + '=' + value + '\r\n';
						}
					});

					//保存输入值
					$($(this).data('clickInput')).val(jobProperties);

					//调用change事件,通知控件值改变
					$($(this).data('clickInput')).change();

					$(this).dialog('close');

					//清除
					$(this).data('clickInput', null);
				}
			}
		});

		var taskJsonDefStr = $(window.parent.document).find('#taskJsonDef')
				.val();
		var taskJsonDef;
		if (taskJsonDefStr) {
			taskJsonDef = eval('(' + taskJsonDefStr + ')');
		}

		//流程绘制
		$('#myflow').myflow({
			basePath : "",
			restore : taskJsonDef,
			tools : {
				save : {
					onclick : function(data) {
						save(data);
					}
				}
			}
		});

		//文件上传
		$('#fileUploadDiv').dialog({
			modal : true,
			autoOpen : false,
			position : [ 'right', 'top' ],
			title : 'Select file please',
			width : 350,
			height : 180,
			buttons : {
				'Cancel' : function() {
					$(window).data("popupClick", "aa");
					$(this).dialog('close');
				},
				'Ok' : function() {
					$(window).data("popupClick", "aa");
					//文件上传,并传回
					var serverFileName = fileUpload();
					
					if(serverFileName != -1){
						//保存输入值
						$($(this).data('fileInput')).val(serverFileName);
	
						//调用change事件,通知控件值改变
						$($(this).data('fileInput')).change();
	
						$(this).dialog('close');
	
						//清除
						$(this).data('fileInput', null);
					}
				}
			}
		});
		// 折叠工具栏
		/*
		$('#MyflowToolFold').click(function(){
			if($(this).hasClass('glyphicon-minus')){
				$(this).removeClass('glyphicon-minus').addClass('glyphicon-plus');
				$('#myflow_tools').animate({height: 24}, 250);
			}else{
				$(this).removeClass('glyphicon-plus').addClass('glyphicon-minus');
				$('#myflow_tools').animate({height: 530}, 250);
			}
		});

		// 折叠属性栏
		$('#MyflowPropsFold').click(function(){
			if($(this).hasClass('glyphicon-minus')){
				$(this).removeClass('glyphicon-minus').addClass('glyphicon-plus');
				$('#myflow_props').animate({height: 30}, 250);
			}else{
				$(this).removeClass('glyphicon-plus').addClass('glyphicon-minus');
				$('#myflow_props').animate({height: $('#myflow_props').find('table').outerHeight() + 52}, 250);
			}
		})
		 */
	});
</script>
<style type="text/css">
select, input {
	display: inline-block;
	height: 28px;
	padding: 3px 4px;
	font-size: 13px;
	line-height: 20px;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #d9e2eb;
    border-radius: 2px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
}

textarea {
	height: 50px;
	border-radius: 0;
	border: 1px solid #d9e2eb;
}

input[disabled], select[disabled], textarea[disabled], input[readonly],
	select[readonly], textarea[readonly] {
	border: 1px solid #d9e2eb
}

textarea:focus, input:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 5px
		rgba(102, 175, 233, .5);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 5px
		rgba(102, 175, 233, .5);
}

#ui-datepicker-div {
	display: none
}

.ui-widget-content.tool {
	background: #fff;
	border: 1px solid #ddd;
	box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .1);
}

.ui-widget-header.tool {
	position: relative;
	height: 24px;
	margin-bottom: 5px;
	background: #509EDC;
	border: 0;
	line-height: 24px;
	color: #fff;
}

.ui-widget-header .glyphicon {
	display: none;
	position: absolute;
	right: 5px;
	top: 6px;
	color: #fff;
}

.node {
	width: 90px;
	height: 24px;
	margin-bottom: 6px;
	line-height: 24px;
	text-align: left;
	vertical-align: middle;
	cursor: default;
}

.node img {
	float: left;
	margin: 4px 0 0 4px;
}

.mover {
	background-color: #b8e1ff;
}

.selected {
	background-color: #ddd;
}

.tool_selected {
	background-color: #b8e1ff;
	font-weight: bold;
}

.state {
	cursor: pointer;
}

#myflow_props th {
	width: 55px;
	text-align: left;
	padding: 4px 5px;
	font-weight: normal;
	color: #165c9d;
	font-size: 13px;
}

#myflow_props td {
	padding: 4px 5px;
}

#pointer {
	background-repeat: no-repeat;
	background-position: center;
}

#path {
	background-repeat: no-repeat;
	background-position: center;
}

#task {
	background-repeat: no-repeat;
	background-position: center;
}

#state {
	background-repeat: no-repeat;
	background-position: center;
}

body {
	overflow-x: hidden;
	overflow-y: hidden;
}

.ui-widget-header.tool.myflowToolHeader{ cursor: move; height: 30px; line-height: 30px; text-align: center; font-size: 14px;}
.gray { 
    -webkit-filter: grayscale(100%);
    -moz-filter: grayscale(100%);
    -ms-filter: grayscale(100%);
    -o-filter: grayscale(100%);
    filter: grayscale(100%);
    filter: gray;
}
.myflowInfo{ position: absolute; right: 5px; top: 7px; width: 16px; height: 16px; background: url(../resources/images/icon_info.png) center center no-repeat;}
</style>

<!-- 工具栏 -->
<div id="myflow_tools"
	style="position: absolute; left: 0; top: 0; width: 90px; padding: 5px; z-index: 10;"
	class="ui-widget-content tool">
	<div id="myflow_tools_handle" class="ui-widget-header tool myflowToolHeader"><%=bundleJsp.getString("componentSet")%>
		<a href="javascript:;" class="myflowInfo" id="MyflowTool"></a>
	</div>
	
	<div class="node" id="myflow_save">
		<img src="../resources/img/save.png" />&nbsp;&nbsp;<%=bundleJsp.getString("save")%>
	</div>
	<div>
		<hr />
	</div>
	<div class="node selectable tool_selected" id="pointer">
		<img src="../resources/img/select16.png" />&nbsp;&nbsp;<%=bundleJsp.getString("opt")%>
	</div>
	<div class="node selectable" id="path">
		<img src="../resources/img/16/flow_sequence.png" />&nbsp;&nbsp;<%=bundleJsp.getString("line")%>
	</div>
	<div>
		<hr />
	</div>
	<div class="node state" id="start" type="start">
		<img src="../resources/img/16/start_event_empty.png" />&nbsp;&nbsp;<%=bundleJsp.getString("start")%>
	</div>
	<div class="node state" id="end" type="end">
		<img src="../resources/img/16/end_event_terminate.png" />&nbsp;&nbsp;<%=bundleJsp.getString("end")%>
	</div>
	<!--  
	<div class="node state" id="fork" type="fork">
		<img src="../resources/img/16/gateway_parallel.png" />&nbsp;&nbsp;并发
	</div>
	-->
	<div class="node state" id="judge" type="judge">
		<img src="../resources/img/16/gateway_exclusive.png" />&nbsp;&nbsp;<%=bundleJsp.getString("branch")%>
	</div>
	<div class="node state" id="join" type="join">
		<img src="../resources/img/16/gateway_parallel.png" />&nbsp;&nbsp;<%=bundleJsp.getString("merger")%>
	</div>
	
	<div class="node state" id="dep" type="dep">
		<img src="../resources/img/16/depend.png" />&nbsp;&nbsp;<%=bundleJsp.getString("depend")%>
	</div>
	
	<div>
		<hr />
	</div>
	<div class="node state" id="transfer" type="transfer">
		<img src="../resources/img/16/sqoop.png" />&nbsp;&nbsp;<%=bundleJsp.getString("derivative")%>
	</div>
	<div class="node state" id="hdfs" type="hdfs">
		<img src="../resources/img/16/hadoop.png" />&nbsp;&nbsp;Hdfs
	</div>
	<div class="node state" id="mapreduce" type="mapreduce">
		<img src="../resources/img/16/mr.png" />&nbsp;&nbsp;M/R
	</div>
	<div class="node state" id="hive" type="hive">
		<img src="../resources/img/16/hive.png" />&nbsp;&nbsp;Hive
	</div>
	<!--
	<div class="node state" id="sparkjar" type="sparkjar">
		<img src="../resources/img/16/spark-jar.png" />&nbsp;&nbsp;SparkJar
	</div>
	-->
	<div class="node state" id="sparksql" type="sparksql">
		<img src="../resources/img/16/spark.png" />&nbsp;&nbsp;SparkSql
	</div>
	<div class="node state" id="mysql" type="mysql">
		<img src="../resources/img/16/mysql.png" />&nbsp;&nbsp;Mysql
	</div>
	<div class="node state" id="oracle" type="oracle">
		<img src="../resources/img/16/oracle.png" />&nbsp;&nbsp;Oracle
	</div>
	<div class="node state" id="shell" type="shell">
		<img src="../resources/img/16/shell.png" />&nbsp;&nbsp;Shell
	</div>
	<div class="node state" id="java" type="java">
		<img src="../resources/img/16/java.png" />&nbsp;&nbsp;Java
	</div>
	<!-- 
	<div class="node state" id="cache" type="cache">
		<img src="../resources/img/16/memcached.png" />&nbsp;&nbsp;Cache
	</div>
	 -->
	
	<div class="node state" id="notify" type="notify">
		<img src="../resources/img/16/notify.png" />&nbsp;&nbsp;<%=bundleJsp.getString("notice")%>
	</div>
</div>

<!-- 流程绘制区 -->
<div id="myflow"
	style="position: absolute; left: 0; top: 10px; width: 100%; height: 100%; z-index: 9;"></div>

<!-- 属性区 -->
<div id="myflow_props"
	style="position: absolute; right: 10px; top: 5px; width: 280px; padding: 5px; z-index: 10;"
	class="ui-widget-content tool">
	<div id="myflow_props_handle" class="ui-widget-header tool"
		style="cursor: move; height: 30px; padding-left: 10px; line-height: 30px; text-align: center; font-size: 14px;">
		<span><%=bundleJsp.getString("property")%></span>
		<a href="javascript:;" class="myflowInfo" id="MyflowProps" data-type="prop"></a>
	</div>
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	</table>
	<div>&nbsp;</div>
</div>

<!-- 弾出输入框 -->
<div id="popupDialog">
	<textarea rows="100" cols="100" id="widgetName"
		style="width: 475px; height: 380px"></textarea>
</div>

<!-- 弾出属性编辑框 -->
<div id="popupPropertyDialog">
	<h2 style="margin: 5px 0; font-size: 16px; font-weight: normal;"><%=bundleJsp.getString("parameters")%>:</h2>
	<div style="overflow:hidden;>
		<table cellspacing="0" cellpadding="0" border="0">
			<tbody><tr>
				<td valign="top" style=" width:600px;">
					<div style="height:400px; overflow-y:auto">
						<table cellspacing="0" cellpadding="0" border="0" class="Item2 itemTable" >
						</table>
						<div class="itemTitle">
							<div class="addItem" style="margin: 10px 0"><a onclick="addItem('.Item2')" href="javascript:;" class="btn btn-primary">+<%=bundleJsp.getString("add")%></a></div>
						</div>
					</div>
				</td>
			</tr></tbody>
	  </table>	
	</div>
</div>

<!-- 弹出文件上传 -->
<div id="fileUploadDiv">
	<form id="fileUpload">
		<input type="file" id="uploadJar" name="uploadJar" value="file"/>
	</form>
</div>

<div class="infoList" id="Info_tool">
	<p>保存--流程编辑后保存</p>
	<p>选择--绘制流程图选择各组件节点 选中节点后会弹出属性窗口</p>
	<p>线条--流程绘制基本组件，连接绘制流程节点/并指明运行方向 若开始节点为分支节点 则可以指定判断条件</p>
	<p>开始节点--流程绘制基本组件，绘制流程需以该节点开始</p>
	<p>结束节点--流程绘制基本组件，绘制流程需以该节点结束</p>
	<p>分支节点--流程绘制基本组件，流程执行到该节点,会根据连接分支节点线条上的表达式判断，走判断条件成立的一条分支(注暂支持串行运行，多条分支判断成立 只跑其中一条)</p>
	<p>合并节点--流程绘制基本组件，将分支造成的多条流程路径合并为一条到一个节点(有分支形成多条路径时 必须使用合并节点进行合并)</p>
	
	<p>依赖节点--流程绘制扩展组件，流程开始依赖判断, 分流程依赖、文件/目录存在、文件大小、表记录数</p>
	<p>导数节点--流程绘制扩展组件，用于数据迁移,支持hive迁移到mysql、mysql迁移hive、hive迁移到hdfs、hdfs迁移到hive、hive迁移到oracle、oracle迁移到hive</p>
	<p>hdfs节点--流程绘制扩展组件，支持hdfs基本操作：判断是否为文件、文件大小、文件数量、上传文件、下载文件/目录、删除、安静地删除(目录不存在不会报错)、创建文件、创建目录、文件/目录存在检查、拷贝文件/目录、移动文件/目录，支持正则表达式</p>
	<p>M/R节点--流程绘制扩展组件，支持mapreduce调度</p>
	<p>Hive节点--流程绘制扩展组件，支持hiveSql运行</p>
	<p>SparkSql节点--流程绘制扩展组件，支持sparkSql运行</p>
	<p>Mysql节点--流程绘制扩展组件，支持mysql sql运行</p>
	<p>Oracle节点--流程绘制扩展组件，支持oracle sql运行</p>
	<p>Shell节点--流程绘制扩展组件，支持shell脚本运行</p>
	<p>Java节点--流程绘制扩展组件，支持jar包调度</p>
	<p>通知节点--流程绘制扩展组件，支持短信信息发送</p>
</div>

<div class="infoList" id="Info_prop">
	<p>流程ID--流程编号</p>
	<p>流程名称--流程名称,有名称重复判断</p>
	<p>描述--流程详细描述</p>
	<p>调度类型--只运行一次(只运行达到运行条件的一次调度) </p>
	<div class="list">天(达到运行条件后 每天自动调度一次)<br/>
				周(达到运行条件后 每周自动调度一次 运行条件是周几 就每周几运行)<br/>
				月(达到运行条件后 每月自动调度一次 运行条件是每月几号 就每月几号运行)<br/>
				季(达到运行条件后 每季度自动调度一次 运行条件是每季度几月几号 就每季度几月几号运行)<br/>
				年(达到运行条件后 每年度自动调度一次 运行条件是每年几月几号 就每年几月几号运行)</div>
	<p>调度日期--流程开始运行日期</p>
	<p>调度时间--流程开始调度时间 (其月调度日期构成运行条件,如果流程存在流程依赖,流程将会在调度日期当天 依赖流程执行成功后开始调度 调度时间将无效</p>
	<p>失败告警--失败后自动告警,暂支持短信告警</p>
	<p>告警对象--告警手机号(多个号码用,或者换行隔开)</p>
	<p>流程变量--灵活指定流程变量,流程中变量应用格式为${变量名称} sql中使用变量 字符串变量需加上''等支持的引号</p>
	<div class="list">process应用中默认支持的流程变量如下:<br/>
					variables.put("now", sf.format(scheduleDate.getTime()));<br/>
					variables.put("year", scheduleDate.get(Calendar.YEAR));<br/>
					variables.put("month", scheduleDate.get(Calendar.MONTH) + 1);<br/>
					variables.put("weekOfMonth", scheduleDate.get(Calendar.WEEK_OF_MONTH));<br/>
					variables.put("weekOfYear", scheduleDate.get(Calendar.WEEK_OF_YEAR));<br/>
					variables.put("dayOfMonth", scheduleDate.get(Calendar.DAY_OF_MONTH));<br/>
					// 一周星期几, 1-7,JDK星期天为1,星期一为2...<br/>
					int dayOfWeek = scheduleDate.get(Calendar.DAY_OF_WEEK);<br/>
					// 转为中国特有的周星期一为1,星期二为2<br/>
					dayOfWeek = dayOfWeek - 1;<br/>
					// 星期七为1,转为7<br/>
					dayOfWeek = dayOfWeek == 0 ? 7 : dayOfWeek;<br/>
					variables.put("dayOfWeek", dayOfWeek);</div>
</div>

<div class="infoList" id="Info_start">
	<p>显示--节点标示</p>
</div>
<div class="infoList" id="Info_end">
	<p>显示--节点标示</p>
</div>
<div class="infoList" id="Info_judge">
	<p>显示--节点标示</p>
	<p>任务ID--节点编号</p>
</div>

<div class="infoList" id="Info_joinLine">
	<p>表达式--分支判断条件表达式</p>
</div>

<div class="infoList" id="Info_join">
	<p>显示--节点标示</p>
	<p>任务ID--节点编号</p>
</div>
<div class="infoList" id="Info_dep">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>依赖类型:</p>
	<p>流程依赖--流程之间依赖 上一流程执行成功 自动开始本流程调度</p>
	<p>流程ID--本流程依赖的上一流程编号</p>
	<p>文件/目录存在--hdfs文件或者目录存在判断, 如指定文件路径存在 则开始调度本流程</p>
	<p>文件路劲--存在判断的目标路径</p>
	<p>文件大小--hdfs文件或者目录大小判断, 若指定路径大小达到触发值 将开始调度本流程</p>
	<p>文件路劲--计算大小的目标路径</p>
	<p>触发值--大小达到调度流程的数值</p>
	<p>表记录数--通过mysql、oracle和spark不同数据源, 执行sql返回数值结果,当返回数值结果达到触发值 开始调度本流程</p>
	<p>数据库类型--mysql、oracle和spark不同数据源</p>
	<p>mysql/oracle库--指选定不同mysql、oracle数据库</p>
	<p>SQL--对应数据库支持的sql语句</p>
	<p>触发值--返回数值结果达到调度流程的数值</p>
</div>


<div class="infoList" id="Info_transfer">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>迁移方式--hive迁移到mysql、mysql迁移hive、hive迁移到hdfs、hdfs迁移到hive、hive迁移到oracle、oracle迁移到hive, mysql/oracle库--指选定不同mysql、oracle数据库</p>
	<p>源数据--迁移数据来源(hive、mysql、oracle数据源为sql,sql只支持单表查询,暂不支持多表join等操作联合查询; hdfs数据源则指定hdfs文件路径)</p>
	<p>覆盖旧数据--若迁移目的为hive或者hdfs时 可指定是否覆盖旧数据(mysql、oracle暂不支持)</p>
	<p>迁移目的地--指迁移到hive、mysql、oracle表 或者hdfs路径名称 其中hive指定迁移到分区写法为: 表名称[分区1=分区1值,分区2=分区2值,...]</p>
</div>

<div class="infoList" id="Info_hdfs">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>hdfs操作--判断是否为文件、文件大小、文件数量、上传文件、下载文件/目录、删除、安静地删除(目录不存在不会报错)、 创建文件、创建目录、文件/目录存在检查、拷贝文件/目录、移动文件/目录</p>
	<p>判断是否为文件</p>
	<p>源路径--判断是否为文件的目标文件路径,不支持正则表达式</p>
	<p>结果变量--指定返回boolean值到流程变量,便于后继流程使用</p>
	<p>文件大小</p>
	<p>文件路径--统计文件/目录大小的目标路径,支持正则表达式</p>
	<p>结果变量--指定long值(文件大小byte)到流程变量,便于后继流程使用</p>
	<p>文件数量</p>
	<p>文件路径--统计文件数量的目标路径,支持正则表达式</p>
	<p>结果变量--指定int值(文件个数)到流程变量,便于后继流程使用</p>
	<p>上传文件</p>
	<p>本地文件--选择本机需上传到hdfs的文件,文件上传后会自动加上后缀标示,用于防止重名文件</p>
	<p>目标路径--hdfs文件路径</p>
	<p>下载文件/目录</p>
	<p>HDFS文件--hdfs文件路径,支持正则表达式</p>
	<p>目标路径--process部署机器上路径</p>
	<p>删除</p>
	<p>删除路径--删除hdfs路径,支持正则表达式</p>
	<p>安静地删除(目录不存在不会报错)</p>
	<p>删除路径--删除hdfs路径,支持正则表达式</p>
	<p>创建文件</p>
	<p>创建路径--创建hdfs文件路径,不支持正则表达式</p>
	<p>结果变量--指定返回boolean值(true表示创建成功)到流程变量,便于后继流程使用</p>
	<p>创建目录</p>
	<p>创建路径--创建hdfs目录路径,不支持正则表达式</p>
	<p>结果变量--指定返回boolean值(true表示创建成功)到流程变量,便于后继流程使用</p>
	<p>文件/目录存在检查</p>
	<p>文件路径--检查存在的目标路径,不支持正则表达式</p>
	<p>结果变量--指定返回boolean值(true表示存在)到流程变量,便于后继流程使用</p>
	<p>拷贝文件/目录</p>
	<p>源路径--拷贝hdfs文件的源路径,支持正则表达式</p>
	<p>目标路径--拷贝hdfs文件的目标路径</p>
	<p>移动文件/目录</p>
	<p>源路径--移动hdfs文件的源路径,支持正则表达式</p>
	<p>目标路径--移动hdfs文件的目标路径</p>
</div>


<div class="infoList" id="Info_mapreduce">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>Job参数--可以灵活指定mapreduce所需参数</p>
	<p>M/R jar--上传mapreduce jar包 只需要将自定义class打入jar包内,其余应用lib可以不用打入</p>
	<p>mainClass--指定运行主函数类</p>
</div>

<div class="infoList" id="Info_hive">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>Hive SQL--hive sql</p>
	<p>结果变量--指定String,Number,Date类型数据, sql返回结果存在多行、多列 只取第一条行的第一列数据</p>
</div>

<div class="infoList" id="Info_sparksql">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>Spark SQL--Spark支持sql<p>
	<p>结果变量--指定String,Number,Date类型数据, sql返回结果存在多行、多列 只取第一条行的第一列数据</p>
</div>

<div class="infoList" id="Info_mysql">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>Mysql库--指选定不同mysql数据库</p>
	<p>SQL--mysql sql</p>
	<p>结果变量--指定String,Number,Date类型数据, sql返回结果存在多行、多列 只取第一条行的第一列数据</p>
</div>

<div class="infoList" id="Info_oracle">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>Mysql库--指选定不同oracle数据库</p>
	<p>SQL--oracle sql</p>
	<p>结果变量--指定String,Number,Date类型数据, sql返回结果存在多行、多列 只取第一条行的第一列数据
</div>

<div class="infoList" id="Info_shell">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>运行脚本--上传执行脚本名称</p>
	<p>运行参数--灵活指定运行脚本参数 多个参数用空格分隔</p>
	<p>结果变量--指定脚本返回结果</p>
</div>

<div class="infoList" id="Info_java">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>jar--上传jar包 只需要将自定义class打入jar包内,其余应用lib可以不用打入</p>
	<p>包&类路径--指定运行方法类路径</p>
	<p>方法名称--指定运行方法</p>
	<p>运行参数--可以灵活指定jar所需参数</p>
</div>

<div class="infoList" id="Info_notify">
	<p>组件名--节点标示</p>
	<p>任务ID--节点编号</p>
	<p>任务名称--任务命名(相同流程任务名称不能重复)</p>
	<p>通知对象--手机号码(多个号码用,或者换行隔开)</p>
	<p>通知内容--通知内容</p>
</div>

<script>
$('#myflow_new').bind('click',function(){
	window.parent.window.location.href="<%=request.getContextPath()%>/views/process_def.jsp?click=pd";
})

$(window).bind('beforeunload', function(){
	if(window.parent.location.href.indexOf('process_def') >
		0 && $('#myflow').find('svg text').length > 0 &&
		($('#processId').val() == '' || typeof $('#processId').val() ==
		'undefined') ){ return '<%=bundleJsp.getString("selProSave")%>'; } });

$('#MyflowTool').click(function(){
	$('#Info_tool').dialog({
		modal: true,
		title : '流程组件集说明',
		position: ['center', 'top'],
		width: 600,
		height: 600,
		buttons: {
			'Ok' : function() {
				$(this).dialog('close');
			}
		}
	});
})

$('#MyflowProps').click(function(){
	var _type = $(this).data('type');
	var _height = $('#Info_' + _type).outerHeight();
	_height = _height > 500 ? 500 : _height + 150;
	$('#Info_' + _type).dialog({
		modal: true,
		title : '属性说明',
		position: ['center', 'top'],
		width: 600,
		height: _height,
		buttons: {
			'Ok' : function() {
				$(this).dialog('close');
			}
		}
	});
})
		
		
</script>