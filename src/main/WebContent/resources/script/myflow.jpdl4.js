(function($) {
	$.i18n.properties({
	    name : 'i18n', //资源文件名称
	    path : '../resources/script/i18n/', //资源文件路径
	    mode : 'map', //用Map的方式使用资源文件中的值
	    language : window.i18nValue,
	    callback : function() {//加载成功后设置显示内容
	    }
	});
	var myflow = $.myflow;
	$.extend(true, myflow.config.rect, {
		attr : {
			r : 0,
			fill : '#fff',
			stroke : '#aaa',
			"stroke-width" : 1
		}
	});
	
	$.extend(true, myflow.config.props.props, {
		processId : {
			name : 'processId',
			label : $.i18n.prop('process') + 'ID:',
			editor : function() {
				return new myflow.editors.processIdEditor();
			}
		},
		processName : {
			name : 'processName',
			label : $.i18n.prop('processName'),
			value : '',
			editor : function() {
				return new myflow.editors.inputEditor();
			}
		},
		processDesc : {
			name : 'processDesc',
			label : $.i18n.prop('discription'),
			value : '',
			editor : function() {
				return new myflow.editors.textareaEditor();
			}
		},
		validate : {
			name : 'validate',
			label :$.i18n.prop('validate'),
			value : '',
			editor : function() {
				return new myflow.editors.dateEditor();
			}
		},
		priority : {
			name : 'priority',
			label : $.i18n.prop('priority'),
			value : '',
			editor : function() {
				return new myflow.editors.selectEditor([ 
//				                                         {
//					name : $.i18n.prop('option') ,
//					value : ""
//				}, {
//					name : $.i18n.prop('low'),
//					value : "L"
//				}, 
				{
					name : $.i18n.prop('normal'),
					value : "N"
				}, {
					name : $.i18n.prop('high'),
					value : "H"
				} ]);
			}
		},
		appName : {
			name : 'appName',
			label : $.i18n.prop('app'),
			value : '',
			editor : function() {
				var url =  '../config/getApps.do';
				return new myflow.editors.selectEditor(url, 1);
			}
		},
		scheduleType : {
			name : 'scheduleType',
			label :$.i18n.prop('scheduleType'),
			value : '',
			editor : function() {
				return new myflow.editors.selectEditor([ {
					name : $.i18n.prop('option') ,
					value : ""
				}, {
					name : $.i18n.prop('onlyOne'),
					value : "O"
				}, {
					name : $.i18n.prop('day'),
					value : "D"
				}, {
					name : $.i18n.prop('week'),
					value : "W"
				}, {
					name : $.i18n.prop('month'),
					value : "M"
				}, {
					name : $.i18n.prop('quarter'),
					value : "Q"
				}, {
					name : $.i18n.prop('year'),
					value : "Y"
				} ]);
			}
		},
		scheduleDate : {
			name : 'scheduleDate',
			label : $.i18n.prop('scheduleDate'),
			value : '',
			editor : function() {
				return new myflow.editors.dateEditor();
			}
		},
		scheduleTime : {
			name : 'scheduleTime',
			label : $.i18n.prop('scheduleTime'),
			value : '',
			editor : function() {
				return new myflow.editors.timeEditor();
			}
		},
		lateStartTime : {
			name : 'lateStartTime',
			label : $.i18n.prop('lastTime'),
			value : '',
			editor : function() {
				return new myflow.editors.timeEditor();
			}
		},
		alermMethod : {
			name : 'alermMethod',
			label : $.i18n.prop('failAlarm'),
			value : '',
			editor : function() {
				return new myflow.editors.selectEditor([{
					name : $.i18n.prop('option') ,
					value : ''
				}, {
					name : $.i18n.prop('noAlarm'),
					value : 'N'
				}, {
					name : $.i18n.prop('smsAlarm'),
					value : 'S'
				}]);
			}
		},
		alermPerson : {
			name : 'alermPerson',
			label : $.i18n.prop('alarmObj'),
			value : '',
			editor : function() {
				return new myflow.editors.popMultiInputEditor();
			}
		},
		processVariables : {
			name : 'processVariables',
			label :$.i18n.prop('proVar'),
			value : '',
			editor : function() {
				return new myflow.editors.popPropertyEditor();
			}
		},
		appVariables : {
			name : 'appVariables',
			label : $.i18n.prop('appVar'),
			value : '',
			editor : function() {
				return new myflow.editors.popPropertyEditor();
			}
		}
	});

	$.extend(true, myflow.config.tools.states, {
		start : {
			showType : 'image',
			type : 'start',
			name : {
				text : '<<start>>'
			},
			text : {
				text : $.i18n.prop('start')
			},
			img : {
				src : '../resources/img/48/start_event_empty.png',
				width : 48,
				height : 48
			},
			attr : {
				width : 48,
				heigth : 48
			},
			props : {
				text : {
					name : 'text',
					label : $.i18n.prop('display'),
					value : $.i18n.prop('start'),
					editor : function() {
						return new myflow.editors.textEditor('start');
					}
				}
			}
		},
		end : {
			showType : 'image',
			type : 'end',
			name : {
				text : '<<end>>'
			},
			text : {
				text : $.i18n.prop('end')
			},
			img : {
				src : '../resources/img/48/end_event_terminate.png',
				width : 48,
				height : 48
			},
			attr : {
				width : 48,
				heigth : 48
			},
			props : {
				text : {
					name : 'text',
					label : $.i18n.prop('display'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('end');
					},
					value : $.i18n.prop('end')
				}
			}
		},
		judge : {
			showType : 'image',
			type : 'judge',
			name : {
				text : '<<judge>>'
			},
			text : {
				text : $.i18n.prop('branch')
			},
			img : {
				src : '../resources/img/48/gateway_exclusive.png',
				width : 48,
				height : 48
			},
			attr : {
				width : 48,
				height : 48
			},
			props : {
				text : {
					name : 'text',
					label : $.i18n.prop('display'),
					value : $.i18n.prop('branch'),
					editor : function() {
						return new myflow.editors.textEditor('judge');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				}				
			}
		},		
		join : {
			showType : 'image',
			type : 'join',
			name : {
				text : '<<join>>'
			},
			text : {
				text : $.i18n.prop('merger')
			},
			img : {
				src : '../resources/img/48/gateway_parallel.png',
				width : 48,
				height : 48
			},
			attr : {
				width : 48,
				height : 48
			},
			props : {
				text : {
					name : 'text',
					label : $.i18n.prop('display'),
					value : $.i18n.prop('merger'),
					editor : function() {
						return new myflow.editors.textEditor('judge');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				}				
			}
		},
		transfer : {
			showType : 'image&text',
			type : 'transfer',
			name : {
				text : '<<transfer>>'
			},
			text : {
				text : $.i18n.prop('dataTran')
			},
			img : {
				src : '../resources/img/16/sqoop.png',
				width : 18,
				height : 15
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					editor : function() {
						return new myflow.editors.textEditor('transfer');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},				
				transferMode : {
					name : 'transferMode',
					label : $.i18n.prop('transMode') ,
					value : '',
					editor : function() {
						return new myflow.editors.transferModeSelectEditor([ {
							name : $.i18n.prop('option') ,
							value : ""
						},{
							name : 'Hive'+$.i18n.prop('to') + 'Mysql',
							value : 'H2M'
						}, {
							name : 'Mysql'+$.i18n.prop('to') + 'Hive',
							value : 'M2H'
						}, {
							name :  'Hive'+$.i18n.prop('to') + 'HDFS',
							value : 'H2D'
						}, {
							name : 'HDFS'+$.i18n.prop('to') + 'Hive',
							value : 'D2H'
						}, {
							name : 'Hive'+$.i18n.prop('to') + 'Oracle',
							value : 'H2O'
						}, {
							name : 'Oracle'+$.i18n.prop('to') + 'Hive',
							value : 'O2H'
						} ]);
					}
				},
				sourceData : {
					name : 'sourceData',
					label : $.i18n.prop('srcData')+ '&nbsp;&nbsp;',
					value : '',
					editor : function() {
						 return new myflow.editors.popMultiInputEditor();
					}
				},
				overWrite : {
					name : 'overWrite',
					label : $.i18n.prop('overOld'),
					value : '',
					editor : function() {
						return new myflow.editors.selectEditor([ {
							name : $.i18n.prop('option') ,
							value : ""
						},{
							name : $.i18n.prop('overOld'),
							value : 'Y'
						}, {
							name : $.i18n.prop('noOver'),
							value : 'N'
						} ]);
					}
				},
				destData : {
					name : 'destData',
					label : $.i18n.prop('transDest'),
					value : '',
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				}			
			}
		},
		hdfs : {
			showType : 'image&text',
			type : 'hdfs',
			name : {
				text : '<<Hdfs' + $.i18n.prop('srcData')+ '>>'
			},
			text : {
				text : 'Hdfs' + $.i18n.prop('srcData')
			},
			img : {
				src : '../resources/img/16/hadoop.png',
				width : 15,
				height : 14
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('hdfs');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				hdfsOp : {
					name : 'hdfsOp',
					label : 'Hdfs'+$.i18n.prop('operate'),
					value : '',
					editor : function() {
						return new myflow.editors.hdfsOpSelectEditor([ {
							name : $.i18n.prop('option') ,
							value : ""
						},
						{
							name : $.i18n.prop('isFile'),
							value : "isFile"
						},
						{
							name : $.i18n.prop('fileSize'),
							value : "fileSize"
						},
						{
							name : $.i18n.prop('fileCount'),
							value : "fileCount"
						},
						{
							name : $.i18n.prop('upload'),
							value : "upload"
						}, {
							name : $.i18n.prop('download'),
							value : 'download'
						}, {
							name : $.i18n.prop('remove'),
							value : 'remove'
				        }, {
					        name : $.i18n.prop('removeQui'),
					        value : 'remove_quiet'
						}, {
							name : $.i18n.prop('createFile'),
							value : 'createFile'
						},{
							name : $.i18n.prop('createDir'),
							value : 'createDir'
						}, {
							name : $.i18n.prop('fileExChe'),
							value : 'exist'
						}, {
							name : $.i18n.prop('copyFile'),
							value : 'copy'
						}, {
							name : $.i18n.prop('moveFile'),
							value : 'move'
						} ]);

					}
				},
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('srcPath'),
					value : '',
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},
				destPath : {
					name : 'destPath',
					label : $.i18n.prop('destPath'),
					value : '',
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
					   return new myflow.editors.inputEditor();
					}
				}
			}
		},
		mapreduce : {
			showType : 'image&text',
			type : 'mapreduce',
			name : {
				text : '<<mapReduce>>'
			},
			text : {
				text : 'MapReduce'
			},
			img : {
				src : '../resources/img/16/mr.png',
				width : 15,
				height : 14
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('mapreduce');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				params : {
					name : 'params',
					label : 'Job' + $.i18n.prop('param'),
					value : '',
					editor : function() {
						return new myflow.editors.popPropertyEditor();
					}
				},
				mrJar : {
					name : 'mrJar',
					label : 'M/R Jar',
					value : '',
					editor : function() {
						return new myflow.editors.fileUploadEditor();
					}
				},
				mainClass : {
					name : 'mainClass',
					label : 'mainClass',
					value : '',
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				}
			}
		},
		sparkjar : {
			showType : 'text',
			type : 'sparkjar',
			name : {
				text : '<<sparkjar>>'
			},
			text : {
				text : 'SparkJar'
			},
			img : {
				src : '../resources/img/48/task_empty.png',
				width : 48,
				height : 48
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('sparkjar');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				params : {
					name : 'params',
					label : 'Job' + $.i18n.prop('param'),
					value : '',
					editor : function() {
						return new myflow.editors.popPropertyEditor();
					}
				},
				jar : {
					name : 'jar',
					label : 'Spark Jar',
					value : '',
					editor : function() {
						return new myflow.editors.fileUploadEditor();
					}
				},
				mainClass : {
					name : 'mainClass',
					label : 'mainClass',
					value : '',
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},				
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		hive : {
			showType : 'image&text',
			type : 'hive',
			name : {
				text : '<<hive>>'
			},
			text : {
				text : 'Hive'
			},
			img : {
				src : '../resources/img/16/hive.png',
				width : 17,
				height : 20
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('hive');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				hsql : {
					name : 'hsql',
					label : 'Hive SQL',
					value : '',
					editor : function() {
						return new myflow.editors.popMultiInputEditor();
					}
				},
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		sparksql : {
			showType : 'image&text',
			type : 'sparksql',
			name : {
				text : '<<sparksql>>'
			},
			text : {
				text : 'Spark Sql'
			},
			img : {
				src : '../resources/img/16/spark.png',
				width : 17,
				height : 14
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('sparksql');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				ssql : {
					name : 'ssql',
					label : 'Spark SQL',
					value : '',
					editor : function() {
						return new myflow.editors.popMultiInputEditor();
					}
				},
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		mysql : {
			showType : 'image&text',
			type : 'mysql',
			name : {
				text : '<<mysql>>'
			},
			text : {
				text : 'Mysql'
			},
			img : {
				src : '../resources/img/16/mysql.png',
				width : 15,
				height : 17
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('mysql');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},	
				rdbmsDB : {
					name : 'rdbmsDB',
					label : $.i18n.prop('mysql'),
					value : '',
					editor : function() {
						var appId = $.myflow.config.props.props.appName.value;		
						var url =  '../config/getAppDbNames.do?appId=' + appId + '&dbType=' + 1;
						return new $.myflow.editors.selectEditor(url);
					}
				},				
				sql : {
					name : 'msql',
					label : 'SQL',
					value : '',
					editor : function() {
						return new myflow.editors.popMultiInputEditor();
					}
				},
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		oracle : {
			showType : 'image&text',
			type : 'oracle',
			name : {
				text : '<<oracle>>'
			},
			text : {
				text : 'Oracle'
			},
			img : {
				src : '../resources/img/16/oracle.png',
				width : 15,
				height : 15
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('oracle');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},
				rdbmsDB : {
					name : 'rdbmsDB',
					label : $.i18n.prop('oracle'),
					value : '',
					editor : function() {
						var appId = $.myflow.config.props.props.appName.value;		
						var url =  '../config/getAppDbNames.do?appId=' + appId + '&dbType=' + 2;
						return new $.myflow.editors.selectEditor(url);
					}
				},				
				sql : {
					name : 'osql',
					label : 'SQL',
					value : '',
					editor : function() {
						return new myflow.editors.popMultiInputEditor();
					}
				},
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		shell : {
			showType : 'image&text',
			type : 'shell',
			name : {
				text : '<<shell>>'
			},
			text : {
				text : 'shell ' + $.i18n.prop('script')
			},
			img : {
				src : '../resources/img/16/shell.png',
				width : 15,
				height : 16
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('shell');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				shellFile : {
					name : 'shellFile',
					label : $.i18n.prop('runScript'),
					value : '',
					editor : function() {
						return new myflow.editors.fileUploadEditor();
					}
				},
				params : {
					name : 'params',
					label : $.i18n.prop('runParm'),
					value : '',
					editor : function() {
						return new myflow.editors.popMultiInputEditor();
					}
				},
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		java : {
			showType : 'image&text',
			type : 'java',
			name : {
				text : '<<java>>'
			},
			text : {
				text : 'java ' + $.i18n.prop('code')
			},
			img : {
				src : '../resources/img/16/java.png',
				width : 16,
				height : 18
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('java');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				jar : {
					name : 'jar',
					label : 'jar',
					value : '',
					editor : function() {
						return new myflow.editors.fileUploadEditor();
					}
				},
				className : {
					name : 'className',
					label : $.i18n.prop('packCla'),
					value : '',
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},
				methodName : {
					name : 'methodName',
					label : $.i18n.prop('methodName'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				},
				params : {
					name : 'params',
					label : $.i18n.prop('runParm'),
					value : '',
					editor : function() {
						return new myflow.editors.popPropertyEditor();
					}
				}
			}
		},
		cache : {
			showType : 'text',
			type : 'cache',
			name : {
				text : '<<cache>>'
			},
			text : {
				text : 'cache'
			},
			img : {
				src : '../resources/img/48/task_empty.png',
				width : 48,
				height : 48
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor();
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},					
				cacheOp : {
					name : 'cacheOp',
					label : $.i18n.prop('operate'),
					value : '',
					editor : function() {
						return new myflow.editors.selectEditor([ {
							name : 'set',
							value : "s"
						}, {
							name : 'get',
							value : "g"
						} ]);
					}
				},
				key : {
					name : 'key',
					label : 'Key',
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				},	
				value : {
					name : 'value',
					label : 'Value',
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				},					
				out : {
					name : 'out',
					label : $.i18n.prop('optOut'),
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		dep : {
			showType : 'image&text',
			type : 'dep',
			name : {
				text : '<<dep>>'
			},
			text : {
				text : $.i18n.prop('processDep')
			},
			img : {
				src : '../resources/img/16/depend.png',
				width : 15,
				height : 15
			},
			props : {
				componentName : {
					name : 'componentName',
					label : $.i18n.prop('compName'),
					value : '',
					editor : function() {
						return new myflow.editors.textEditor('dep');
					}
				},
				taskId : {
					name : 'taskId',
					label : $.i18n.prop('task') + 'ID',
					editor : function() {
						return new myflow.editors.idEditor('T');
					}
				},
				taskName : {
					name : 'taskName',
					label : $.i18n.prop('taskName'),
					editor : function() {
						return new myflow.editors.popInputEditor();
					}
				},	
				depType : {
					name : 'depType',
					label : $.i18n.prop('depType') ,
					value : '',
					editor : function() {
						return new myflow.editors.depTypeSelectEditor([{
							name : $.i18n.prop('processDep'),
							value : 'process'
						},{
							name : $.i18n.prop('depHdfsDir'),
							value : 'hdfs_dir'
						},{
							name : $.i18n.prop('depHdfsSize'),
							value : 'hdfs_size'
						},{
							name : $.i18n.prop('depTblCount'),
							value : 'tbl_count'
						} ]);
					}
				},
				target : {
					name : 'target',
					label : $.i18n.prop('process') + ' ID',
					value : '',
					editor : function() {
						return new myflow.editors.inputEditor();
					}
				}
			}
		},
		notify:{
            showType : 'image&text',
            type : 'notify',
            name : {
                text : '<<notify>>'
            },
            text : {
                text : '短信通知'
            },
                        img : {
                                src : '../resources/img/16/notify.png',
                                width : 16,
                                height : 14
                        },
            props : {
                                componentName : {
                                        name : 'componentName',
                                        label : $.i18n.prop('compName'),
                                        value : '',
                                        editor : function() {
                                                return new myflow.editors.textEditor('notify');
                                        }
                                },
                                taskId : {
                                        name : 'taskId',
                                        label : $.i18n.prop('task') + 'ID',
                                        editor : function() {
                                                return new myflow.editors.idEditor('T');
                                        }
                                },
                                taskName : {
                                        name : 'taskName',
                                        label : $.i18n.prop('taskName'),
                                        editor : function() {
                                                return new myflow.editors.popInputEditor();
                                        }
                                },
                alermPerson : {
                    name : 'alermPerson',
                    label : $.i18n.prop('noticeObj') + ":",
                    value : '',
                    editor : function() {
                        return new myflow.editors.popMultiInputEditor();
                    }
                },
                alermContent : {
                    name : 'alermContent',
                    label : $.i18n.prop('noticeCon') + ":",
                    value : '',
                    editor : function() {
                        return new myflow.editors.popMultiInputEditor();
                    }
                },
            }
		}
	});
})(jQuery);
