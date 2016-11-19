//获取流程/任务ID
function genId(idType) {
	$.i18n.properties({
	    name : 'i18n', //资源文件名称
	    path : '../resources/script/i18n/', //资源文件路径
	    mode : 'map', //用Map的方式使用资源文件中的值
	    language : window.i18nValue,
	    callback : function() {//加载成功后设置显示内容
	    }
	});
	var url = '../idGen/genId.do';
	var param = {
		'idType' : idType
	};

	var id = 0;
	$.ajax({
		type : "GET",
		url : url,
		async : false,
		data : param,
		success : function(ret) {
			// 出错提示
			if (ret.err) {
				alert(ret.err);
			} else {
				id = ret.id;
			}
		},
		error : function() {
			// 出错提示
			alert('System error!');
		}
	});

	return id;

}

function hdfsOpInit(hdfsOp){
	var _srcPathTr = $('#psrcPath').parents('tr');
	var _destPathTr = $('#pdestPath').parents('tr');
	var _outTr = $('#pout').parents('tr');
	
	// 开始动态属性处理
    switch(hdfsOp){
		// 用户选择"判断路径是否为文件"操作
	    case 'isFile':
	    	_srcPathTr.find('th').eq(0).html('源路径');
	    	_destPathTr.addClass('hidden');
			break;
		// 文件大小
		case 'fileSize':
			_srcPathTr.find('th').eq(0).html('文件路径');
	    	_destPathTr.addClass('hidden');
		    break;
			// 文件大小
		case 'fileCount':
			_srcPathTr.find('th').eq(0).html('文件路径');
	    	_destPathTr.addClass('hidden');
		    break;
		// 文件上传到hdfs
	    case 'upload':
	    	_srcPathTr.find('th').eq(0).html('本地文件');
	    	_destPathTr.find('th').eq(0).html('目标路径');
	    	_outTr.addClass('hidden');
		    break;	
		// 文件从hdfs下载
	    case 'download':
	    	_srcPathTr.find('th').eq(0).html('HDFS文件');
	    	_destPathTr.find('th').eq(0).html('目标路径');
	    	_outTr.addClass('hidden');
		    break;		    
		// 删除文件
	    case 'remove':
	    case 'remove_quiet':
	    	_srcPathTr.find('th').eq(0).html('删除路径');
	    	_destPathTr.addClass('hidden');
	    	_outTr.addClass('hidden');
			
		    break;	
		// create文件
		case 'createFile':
			_srcPathTr.find('th').eq(0).html('创建路径');
	    	_destPathTr.addClass('hidden');
			
		    break;	
		// create目录
		case 'createDir':
			_srcPathTr.find('th').eq(0).html('创建路径');
	    	_destPathTr.addClass('hidden');
			
		    break;		    
		// 检查文件/目录是否存在
		case 'exist':
			_srcPathTr.find('th').eq(0).html('文件路径');
	    	_destPathTr.addClass('hidden');
		    break;		    
		// copy
		case 'copy':
			_srcPathTr.find('th').eq(0).html('源路径');
	    	_destPathTr.find('th').eq(0).html('目标路径');
	    	_outTr.addClass('hidden');
			
		    break;		    
		// move
		case 'move':
			_srcPathTr.find('th').eq(0).html('源路径');
	    	_destPathTr.find('th').eq(0).html('目标路径');
	    	_outTr.addClass('hidden');
		
	    break;		    
	}	
}

// hdfs控件 操作下拉框值变更
function hdfsOpChange(hdfsOp){
    if (typeof hdfsOp === 'string'){
    	$('#phdfsOp').data('op',hdfsOp);
    }
    // table重新加载
    else{
    	hdfsOp = $('#phdfsOp').data('op');
    }
    
    var r = $('#phdfsOp').data('r');
    var src = $('#phdfsOp').data('src');
    var srcProps = $('#phdfsOp').data('srcProps');
    // 静态属性
    var props =  {
		componentName : {
			name : 'componentName',
			label : $.i18n.prop('compName'),
			value : '',
			editor : function() {
				return new $.myflow.editors.textEditor('hdfs');
			}
		},
		taskId : {
			name : 'taskId',
			label : $.i18n.prop('task')+' ID',
			value : srcProps['taskId'].value,
			editor : function() {
				return new $.myflow.editors.idEditor('T');
			}
		},
		taskName : {
			name : 'taskName',
			label : $.i18n.prop('taskName'),
			value : srcProps['taskName'].value,
			editor : function() {
				return new $.myflow.editors.popInputEditor();
			}
		},					
		hdfsOp : {
			name : 'hdfsOp',
			label : 'Hdfs'+$.i18n.prop('operate'),
			value : hdfsOp,
			editor : function() {
				return new $.myflow.editors.hdfsOpSelectEditor([ {
					name : $.i18n.prop('option'),
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
				}, {
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
		}
	}
    
    // 开始动态属性处理
    switch(hdfsOp){
		// 用户选择"判断路径是否为文件"操作
	    case 'isFile':
			$.extend(props ,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('srcPath'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});
			break;
		// 文件大小
		case 'fileSize':
			 $.extend(props,{
					srcPath : {
						name : 'srcPath',
						label : $.i18n.prop('filePath'),
						value : srcProps['srcPath']?srcProps['srcPath'].value:'',
						editor : function() {
							return new $.myflow.editors.popInputEditor();
						}
					}
				});		
		    break;
			// 文件大小
		case 'fileCount':
			 $.extend(props,{
					srcPath : {
						name : 'srcPath',
						label : $.i18n.prop('filePath'),
						value : srcProps['srcPath']?srcProps['srcPath'].value:'',
						editor : function() {
							return new $.myflow.editors.popInputEditor();
						}
					}
				});		
		    break;
		// 文件上传到hdfs
	    case 'upload':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('localFile'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.fileUploadEditor();
					}
				},
				destPath : {
					name : 'destPath',
					label : $.i18n.prop('destPath'),
					value : srcProps['destPath']?srcProps['destPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});		
		    break;	
		// 文件从hdfs下载
	    case 'download':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : 'HDFS' + $.i18n.prop('file'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				},
				destPath : {
					name : 'destPath',
					label : $.i18n.prop('destPath'),
					value : srcProps['destPath']?srcProps['destPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor(true);
					}
				}
			});		
		    break;		    
		// 删除文件
	    case 'remove':
	    case 'remove_quiet':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('delPath'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});		
			
		    break;	
		// create文件
		case 'createFile':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('crtPath'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});		
			
		    break;	
		// create目录
		case 'createDir':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('crtPath'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});		
			
		    break;		    
		// 检查文件/目录是否存在
		case 'exist':
			 $.extend(props,{
					srcPath : {
						name : 'srcPath',
						label : $.i18n.prop('filePath'),
						value : srcProps['srcPath']?srcProps['srcPath'].value:'',
						editor : function() {
							return new $.myflow.editors.popInputEditor();
						}
					}
				});		
		    break;		    
		// copy
		case 'copy':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('srcPath'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				},
				destPath : {
					name : 'destPath',
					label : $.i18n.prop('destPath'),
					value : srcProps['destPath']?srcProps['destPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});		
			
		    break;		    
		// move
		case 'move':
			 $.extend(props,{
				srcPath : {
					name : 'srcPath',
					label : $.i18n.prop('srcPath'),
					value : srcProps['srcPath']?srcProps['srcPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				},
				destPath : {
					name : 'destPath',
					label : $.i18n.prop('destPath'),
					value : srcProps['destPath']?srcProps['destPath'].value:'',
					editor : function() {
						return new $.myflow.editors.popInputEditor();
					}
				}
			});		
		
	    break;		    
	}	
    
    if(['upload', 'download', 'remove', 'remove_quiet', 'copy', 'move'].indexOf(hdfsOp) == -1){
		$.extend(props ,{
			out: {
				name : 'out',
				label : $.i18n.prop('optOut'),
				value : srcProps['out']?srcProps['out'].value:'',
				editor : function() {
					return new $.myflow.editors.inputEditor();
				}
			}}
		);
    }
    
   src.setProps(props);
  
   //销毁旧属性编辑框
   var divProps=$('#myflow_props');
   divProps.hide();
   var tab=divProps.find('table');
   $(tab).find('.editor').each( function (){
	   var e=$(this).data('editor');
	   if (e){
		  e.destroy();
	   }
   });
   tab.empty();
   
   
   //生成新属性编辑框
   divProps.show();
   for (var key in props){
	   tab.append('<tr><th style="text-align: right;">' + props[key].label + '</th><td style="width:150px;"><div id="p'	+ key + '" class="editor"></div></td></tr>');
		if (props[key].editor)
			props[key].editor().init(props, key, 'p' + key, src, r);	   
   }
}

//transfermode控件 操作下拉框值变更
function transferModeChange(mode){
    if (typeof mode === 'string'){
    	$('#ptransferMode').data('mode',mode);
    }
    // table重新加载
    else{
    	mode = $('#ptransferMode').data('mode');
    }
    
    var r = $('#ptransferMode').data('r');
    var src = $('#ptransferMode').data('src');
    var srcProps = $('#ptransferMode').data('srcProps');
    // 静态属性
    var props =  {
    	componentName : {
			name : 'componentName',
			label : $.i18n.prop('compName'),
			value : '',
			editor : function() {
				return new $.myflow.editors.textEditor('transfer');
			}
		},
		taskId : {
			name : 'taskId',
			label : $.i18n.prop('task')+' ID',
			value : srcProps['taskId'].value,
			editor : function() {
				return new $.myflow.editors.idEditor('T');
			}
		},
		taskName : {
			name : 'taskName',
			label : $.i18n.prop('taskName'),
			value : srcProps['taskName'].value,
			editor : function() {
				return new $.myflow.editors.popInputEditor();
			}
		},					
		transferMode : {
			name : 'transferMode',
			label : $.i18n.prop('transMode') ,
			value : mode,
			editor : function() {
				return new $.myflow.editors.transferModeSelectEditor([ {
					name : $.i18n.prop('option'),
					value : ""
				},{
					name : 'Hive'+$.i18n.prop('to') + 'Mysql',
					value : 'H2M'
				}, {
					name : 'Mysql'+$.i18n.prop('to') + 'Hive',
					value : 'M2H'
				}, {
					name : 'Hive'+$.i18n.prop('to') + 'HDFS',
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
		}
	}
    
    // 开始动态属性处理
    switch(mode){
	// HIVE >>> MySQL
    case 'H2M':
		$.extend(props ,{
			sourceData : {
				name : 'sourceData',
				label : $.i18n.prop('srcData'),
				value : srcProps['sourceData']?srcProps['sourceData'].value:'',
				editor : function() {
					return new $.myflow.editors.popMultiInputEditor();
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
			destData : {
				name : 'destData',
				label : $.i18n.prop('transDest'),
				value : srcProps['destData']?srcProps['destData'].value:'',
				editor : function() {
					return new $.myflow.editors.popInputEditor();
				}
			}			
		});
		break;
	// MySQL >>> Hive
    case 'M2H':
		 $.extend(props,{
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
			sourceData : {
				name : 'sourceData',
				label : $.i18n.prop('srcData'),
				value : srcProps['sourceData']?srcProps['sourceData'].value:'',
				editor : function() {
					return new $.myflow.editors.popMultiInputEditor();
				}
			},
			overWrite : {
				name : 'overWrite',
				label : $.i18n.prop('overOld'),
				value : srcProps['overWrite']?srcProps['overWrite'].value:'',
				editor : function() {
					return new $.myflow.editors.selectEditor([ {
						name : $.i18n.prop('option'),
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
				value : srcProps['destData']?srcProps['destData'].value:'',
				editor : function() {
					return new $.myflow.editors.popInputEditor();
				}
			}
		});		
	    break;	
	// Hive >>> hdfs
    case 'H2D':
		 $.extend(props,{
			sourceData : {
				name : 'sourceData',
				label : $.i18n.prop('srcData'),
				value : srcProps['sourceData']?srcProps['sourceData'].value:'',
				editor : function() {
					return new $.myflow.editors.popMultiInputEditor();
				}
			},
			overWrite : {
				name : 'overWrite',
				label : $.i18n.prop('overOld'),
				value : srcProps['overWrite']?srcProps['overWrite'].value:'',
				editor : function() {
					return new $.myflow.editors.selectEditor([ {
						name : $.i18n.prop('option'),
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
				value : srcProps['destData']?srcProps['destData'].value:'',
				editor : function() {
					return new $.myflow.editors.popInputEditor();
				}
			}
	});		
	    break;		    
	// hdfs >>> hive
    case 'D2H':
		 $.extend(props,{
			sourceData : {
				name : 'sourceData',
				label : $.i18n.prop('srcData'),
				value : srcProps['sourceData']?srcProps['sourceData'].value:'',
				editor : function() {
					return new $.myflow.editors.popMultiInputEditor();
				}
			},
			overWrite : {
				name : 'overWrite',
				label : $.i18n.prop('overOld'),
				value : srcProps['overWrite']?srcProps['overWrite'].value:'',
				editor : function() {
					return new $.myflow.editors.selectEditor([ {
						name : $.i18n.prop('option'),
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
				value : srcProps['destData']?srcProps['destData'].value:'',
				editor : function() {
					return new $.myflow.editors.popInputEditor();
				}
			}
		});		
		
	    break;	
	// Hive >>> Oracle
    case 'H2O':
		 $.extend(props,{
			sourceData : {
				name : 'sourceData',
				label : $.i18n.prop('srcData'),
				value : srcProps['sourceData']?srcProps['sourceData'].value:'',
				editor : function() {
					return new $.myflow.editors.popMultiInputEditor();
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
			destData : {
				name : 'destData',
				label : $.i18n.prop('transDest'),
				value : srcProps['destData']?srcProps['destData'].value:'',
				editor : function() {
					return new $.myflow.editors.popInputEditor();
				}
			}	
		});		
		
	    break;		    
	// create文件
	case 'O2H':
		 $.extend(props,{
			 rdbmsDB : {
				name : 'rdbmsDB',
				label : $.i18n.prop('oracle'),
				value : '',
				editor : function() {
					var appId =$.myflow.config.props.props.appName.value;				
					var url =  '../config/getAppDbNames.do?appId=' + appId + '&dbType=' + 2;
					return new $.myflow.editors.selectEditor(url);
				}
			},			 
			sourceData : {
				name : 'sourceData',
				label : $.i18n.prop('srcData'),
				value : srcProps['sourceData']?srcProps['sourceData'].value:'',
				editor : function() {
					return new $.myflow.editors.popMultiInputEditor();
				}
			},
			overWrite : {
				name : 'overWrite',
				label : $.i18n.prop('overOld'),
				value : srcProps['overWrite']?srcProps['overWrite'].value:'',
				editor : function() {
					return new $.myflow.editors.selectEditor([ {
						name : $.i18n.prop('option'),
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
				value : srcProps['destData']?srcProps['destData'].value:'',
				editor : function() {
					return new $.myflow.editors.popInputEditor();
				}
			}
		});		
		
	    break;    
	}	
    
   src.setProps(props);
  
   //销毁旧属性编辑框
   var divProps=$('#myflow_props');
   divProps.hide();
   var tab=divProps.find('table');
   $(tab).find('.editor').each( function (){
	   var e=$(this).data('editor');
	   if (e){
		  e.destroy();
	   }
   });
   tab.empty();
   
   
   //生成新属性编辑框
   divProps.show();
   for (var key in props){
	   tab.append('<tr><th style="text-align: right;">' + props[key].label + '</th><td style="width:150px;"><div id="p' + key + '" class="editor"></div></td></tr>');
		if (props[key].editor)
			props[key].editor().init(props, key, 'p' + key, src, r);	   
   }
}

//depType控件 操作下拉框值变更
function depTypeChange(mode){

    if (typeof mode === 'string'){
    	$('#pdepType').data('mode',mode);
    }
    // table重新加载
    else{
    	mode = $('#pdepType').data('mode');
    }
    
    var r = $('#pdepType').data('r');
    var src = $('#pdepType').data('src');
    var srcProps = $('#pdepType').data('srcProps');
    // 静态属性
    var props =  {
    	componentName : {
			name : 'componentName',
			label : $.i18n.prop('compName'),
			value : '',
			editor : function() {
				return new $.myflow.editors.textEditor('dep');
			}
		},
		taskId : {
			name : 'taskId',
			label : $.i18n.prop('task')+' ID',
			value : srcProps['taskId'].value,
			editor : function() {
				return new $.myflow.editors.idEditor('T');
			}
		},
		taskName : {
			name : 'taskName',
			label : $.i18n.prop('taskName'),
			value : srcProps['taskName'].value,
			editor : function() {
				return new $.myflow.editors.popInputEditor();
			}
		},						
				depType : {
					name : 'depType',
					label : $.i18n.prop('depType') ,
					value : mode,
					editor : function() {
						return new $.myflow.editors.depTypeSelectEditor([{
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
				}
	}
    
    // 开始动态属性处理
    switch(mode){
	// HIVE >>> MySQL
    case 'process':
		$.extend(props ,{
			target : {
					name : 'target',
					label : $.i18n.prop('process') + ' ID',
					value : '',
					editor : function() {
						return new $.myflow.editors.inputEditor();
					}
				}			
		});
		break;
	// MySQL >>> Hive
    case 'hdfs_dir':
		 $.extend(props,{
			 target:{name : 'target',label : $.i18n.prop('filePath'), value : '' ,editor : function() {return new $.myflow.editors.inputEditor();} }
		});		
	    break;	
	// Hive >>> hdfs
    case 'hdfs_size':
		 $.extend(props,{
			target:{name : 'target',label : $.i18n.prop('filePath'), 
								value : '' ,editor : function() {return new $.myflow.editors.inputEditor();} },targetNum:{name : 'targetNum',label : $.i18n.prop('targetNum'), 
									value : '' ,editor : function() {return new $.myflow.editors.inputEditor();} }
	});		
	    break;		    
	// hdfs >>> hive
    case 'tbl_count':
		 $.extend(props,{
			depDbType:{name : 'depDbType',label : $.i18n.prop('depDbType'), 
								value : '' ,editor : function() {return new $.myflow.editors.depDbTypeSelectEditor([
									{
										name : 'mysql',
										value : "mysql"
									},
									{
										name : 'oracle',
										value : "oracle"
									},
									{
										name : 'spark',
										value : "spark"
									}]);} },rdbmsDB : { name : 'rdbmsDB',	label : $.i18n.prop('mysql'),value : '', editor : function() {	
										var appId = $.myflow.config.props.props.appName.value;var url =  '../config/getAppDbNames.do?appId=' + appId + '&dbType=' + 1;	return new $.myflow.editors.selectEditor(url);}}, target:{name : 'target',label : 'SQL', 
											value : '' ,editor : function() {return new $.myflow.editors.popMultiInputEditor();} },targetNum:{name : 'targetNum',label : $.i18n.prop('targetNum'), 
												value : '' ,editor : function() {return new $.myflow.editors.inputEditor();} }
		});		
		
	    break;	 
	}	
    
   src.setProps(props);
  
   //销毁旧属性编辑框
   var divProps=$('#myflow_props');
   divProps.hide();
   var tab=divProps.find('table');
   $(tab).find('.editor').each( function (){
	   var e=$(this).data('editor');
	   if (e){
		  e.destroy();
	   }
   });
   tab.empty();
   
   
   //生成新属性编辑框
   divProps.show();
   for (var key in props){
	   tab.append('<tr><th style="text-align: right;">' + props[key].label + '</th><td style="width:150px;"><div id="p' + key + '" class="editor"></div></td></tr>');
		if (props[key].editor)
			props[key].editor().init(props, key, 'p' + key, src, r);	   
   }
}

//depType控件 操作下拉框值变更
function depDbTypeChange(mode){

    if (typeof mode === 'string'){
    	$('#pdepDbType').data('mode',mode);
    }
    // table重新加载
    else{
    	mode = $('#pdepDbType').data('mode');
    }
    
    var r = $('#pdepDbType').data('r');
    var src = $('#pdepDbType').data('src');
    var srcProps = $('#pdepDbType').data('srcProps');
    // 静态属性
    var props =  {
    	componentName : {
			name : 'componentName',
			label : $.i18n.prop('compName'),
			value : '',
			editor : function() {
				return new $.myflow.editors.textEditor('dep');
			}
		},
		taskId : {
			name : 'taskId',
			label : $.i18n.prop('task')+' ID',
			value : srcProps['taskId'].value,
			editor : function() {
				return new $.myflow.editors.idEditor('T');
			}
		},
		taskName : {
			name : 'taskName',
			label : $.i18n.prop('taskName'),
			value : srcProps['taskName'].value,
			editor : function() {
				return new $.myflow.editors.popInputEditor();
			}
		},						
				depType : {
					name : 'depType',
					label : $.i18n.prop('depType') ,
					value : srcProps['depType'].value,
					editor : function() {
						return new $.myflow.editors.depTypeSelectEditor([{
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
		depDbType:{name : 'depDbType',label : $.i18n.prop('depDbType'), 
								value : mode ,editor : function() {return new $.myflow.editors.depDbTypeSelectEditor([
									{
										name : 'mysql',
										value : "mysql"
									},
									{
										name : 'oracle',
										value : "oracle"
									},
									{
										name : 'spark',
										value : "spark"
									}]);} }
	}
    
    // 开始动态属性处理
    switch(mode){
	// HIVE >>> MySQL
    case 'mysql':
		$.extend(props ,{
			rdbmsDB : { name : 'rdbmsDB',	label : $.i18n.prop('mysql'),value : '', editor : function() {	
				var appId = $.myflow.config.props.props.appName.value;var url =  '../config/getAppDbNames.do?appId=' + appId + '&dbType=' + 1;	return new $.myflow.editors.selectEditor(url);}}, target:{name : 'target',label : 'SQL', 
											value : '' ,editor : function() {return new $.myflow.editors.popMultiInputEditor();} },targetNum:{name : 'targetNum',label : $.i18n.prop('targetNum'), 
												value : '' ,editor : function() {return new $.myflow.editors.inputEditor();}}			
		});
		break;
	// MySQL >>> Hive
    case 'oracle':
		 $.extend(props,{
			 rdbmsDB : { name : 'rdbmsDB',	label : $.i18n.prop('oracle'),value : '', editor : function() {	
				 var appId = $.myflow.config.props.props.appName.value;var url =  '../config/getAppDbNames.do?appId=' + appId + '&dbType=' + 2;	return new $.myflow.editors.selectEditor(url);}},target:{name : 'target',label : 'SQL', 
											value : '' ,editor : function() {return new $.myflow.editors.popMultiInputEditor();} },targetNum:{name : 'targetNum',label : $.i18n.prop('targetNum'), 
												value : '' ,editor : function() {return new $.myflow.editors.inputEditor();}}
		});		
	    break;	
	// Hive >>> hdfs
    case 'spark':
		 $.extend(props,{
			target:{name : 'target',label : 'SQL', 
					value : '' ,editor : function() {return new $.myflow.editors.popMultiInputEditor();} },
			targetNum:{name : 'targetNum',label : $.i18n.prop('targetNum'), 
					value : '' ,editor : function() {return new $.myflow.editors.inputEditor();}}
	});		
	    break;		     
	}	
    
   src.setProps(props);
  
   //销毁旧属性编辑框
   var divProps=$('#myflow_props');
   divProps.hide();
   var tab=divProps.find('table');
   $(tab).find('.editor').each( function (){
	   var e=$(this).data('editor');
	   if (e){
		  e.destroy();
	   }
   });
   tab.empty();
   
   
   //生成新属性编辑框
   divProps.show();
   for (var key in props){
	   tab.append('<tr><th style="text-align: right;">' + props[key].label + '</th><td style="width:150px;"><div id="p' + key + '" class="editor"></div></td></tr>');
		if (props[key].editor)
			props[key].editor().init(props, key, 'p' + key, src, r);	   
   }
}

(function($) {
	var myflow = $.myflow;

	$.extend(true, myflow.editors, {
		nullEditor : function() {
			this.init = function(props, k, div, src, r){}
			
			this.destroy = function() {}
		},		
		inputEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				$('<input style="width:100%;"/>').val(props[_k].value).change(
						function() {
							if(_k == 'out'){
								if($(this).val().indexOf('$') == -1 && $(this).val() != ''){
									$(this).val('\${' + $(this).val() + '}');
								}
							}
							props[_k].value = $(this).val();
						}).appendTo('#' + _div);

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},
		
		textareaEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				$('<textarea style="width:100%;" rows="1" cols="5"></textarea>').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' textarea').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},
		selectEditor : function(arg, single) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				var sle = $('<select  style="width:100%;"/>').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
					if(_k == 'alermMethod'){
						if($(this).val() == 'S'){
							$('.alermPerson').removeClass('isHide');
						}else{
							$('.alermPerson').addClass('isHide');
						}
					}
				}).appendTo('#' + _div);

				if (typeof arg === 'string') {
					if(single == undefined){
						sle.append('<option value="">'+$.i18n.prop('option')+'</option>');
					}
					$.ajax({
						type : "GET",
						url : arg,
						success : function(data) {
							var opts = eval(data).list;
							if (opts && opts.length) {
								for ( var idx = 0; idx < opts.length; idx++) {
									sle.append('<option value="'
											+ opts[idx].value + '">'
											+ opts[idx].name + '</option>');
								}
								sle.val(_props[_k].value);
							}
							if (_k === 'appName') {
								myflow.config.props.props.appName.value = sle.val();
								$.getJSON('../config/getAppVars.do', {"appId" : sle.val()}, function(data){
									$('textarea.pop-property:eq(1)').val(data.appVars);
									myflow.config.props.props.appVariables.value = data.appVars;
								});
							}
						}
					});
				} else {
					for ( var idx = 0; idx < arg.length; idx++) {
						sle.append('<option value="' + arg[idx].value + '">'
								+ arg[idx].name + '</option>');
					}
					sle.val(_props[_k].value);
				}
				
				// 所选应用改变时，触发应用变量重新加载
				if (_k === 'appName') {
					sle.change(function(){
						if (sle.val() !== '') {
							$.getJSON('../config/getAppVars.do', {"appId" : sle.val()}, function(data){
								$('textarea.pop-property:eq(1)').val(data.appVars);
								myflow.config.props.props.appVariables.value = data.appVars;
							});
						}
					});
				}

				$('#' + _div).data('editor', this);
			};
			this.destroy = function() {
				$('#' + _div + ' select').each(function() {
					_props[_k].value = $(this).val();
				});
			};
		},
		dateEditor : function(clickByTask) {
			// clickByTask 参数用来表示日期框从组件属性点击,非流程属性点击.
			// 引入该参数是因为在日期框上做任何点击操作,都会触发组件的click事件,从而使组件失去焦点,流程获取焦点
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				$('<input style="width:100%;" class="ui-date" />').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);
				$('.ui-date').datepicker();
				
				if(clickByTask){
					$('#ui-datepicker-div').bind("click", function() {
						// 用户在日期框做操作时,会触发画板的click事件
						$(window).data("popupClick", "aa");
					});
				}
				
				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},		
		timeEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				$('<input style="width:100%;" class="ui-time" />').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);
				
				$('.ui-time').timepicker({
					timeOnlyTitle: $.i18n.prop('hour') + '<span style="display:inline-block; width: 45px;"></span>' + $.i18n.prop('min'),
					timeText: '',
					currentText: '',
					controlType: 'select',
					closeText: $.i18n.prop('set'),
					oneLine: true,
					timeFormat: 'HH:mm',
					afterInject: function(){
						if(this.$input.val() == ''){
							this.$input.val('00:00');
							props[_k].value = '00:00';
						}
					}
				});
				
				
//				$('.ui-time').scroller({
//			        preset: 'time',
//					hourText : $.i18n.prop('hour'),
//					minuteText : $.i18n.prop('min'),
//					setText : $.i18n.prop('set'),
//					cancelText : $.i18n.prop('cancel'),
//					theme: 'ios',
//					display: 'modal',
//					mode: 'scroller',
//					timeFormat:'HH:ii',
//					timeWheels:'HH:ii'
//			    });
				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},
		popInputEditor : function(placeholder) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;
				$('<input style="width:100%;" class="pop-input" />').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);

				$('.pop-input').click(function() {
					var _placeholder = '';
					if(placeholder && $(this).parent().attr('id') == 'pdestPath'){
						_placeholder = '未配置下载目录时，此处需输入默认的目标路径：/data/remote_share/子文件夹，比如：/data/remote_share/newfile';
					}
					
					// 保存点击输入框,以便输入完后获取结果
					$('#popupDialog').data('clickInput', this);
					$('#popupDialog').find('#widgetName').val($(this).val());
					if(_placeholder != ''){
						$('#popupDialog').find('#widgetName').attr('placeholder', _placeholder);
					}else{
						$('#popupDialog').find('#widgetName').removeAttr('placeholder');
					}
					$('#popupDialog').dialog('open');
				});
				

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}

		},
		fileUploadEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;
				$('<input style="width:100%;" class="uploadClass" />').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);
				
				$('.uploadClass').click(function() {
					// 保存点击输入框,以便输入完后获取结果
					$('#fileUploadDiv').data('fileInput', this);

					$('#fileUploadDiv').dialog('open');
				});
				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}

		},
		idEditor : function(idType) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;
				var v;
				if (!props[_k].value) {
					v = genId(idType);
					props[_k].value = v.toString() ;
				} else {
					v = props[_k].value;
				}

				$('<input style="width:100%;" readOnly class="selected"/>').val(v).appendTo('#' + _div);
				
				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},
		readOnlyEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				$('<input style="width:100%;" readOnly class="selected" value="" />')
						.val(props[_k].value).appendTo('#' + _div);

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},
		processIdEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				$('<input style="width:100%;" readOnly class="selected" value=""  id="processId"/>')
						.val(props[_k].value).change(function() {
							props[_k].value = $(this).val();
						}).appendTo('#' + _div);

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}
		},
		hdfsOpSelectEditor : function(arg) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				var sle = $('<select  style="width:100%;"/ onchange="hdfsOpChange(this.value)" id="hdfsOpSelect">').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);


				for ( var idx = 0; idx < arg.length; idx++) {
					sle.append('<option value="' + arg[idx].value + '">'
							+ arg[idx].name + '</option>');
				}

				sle.val(_props[_k].value);

				$('#' + _div).data('op',_props[_k].value);
				$('#' + _div).data('r',_r);
				$('#' + _div).data('src',_src);
				$('#' + _div).data('srcProps',_props);

				$('#' + _div).data('editor', this);
				
				setTimeout(function(){
					hdfsOpInit(props[_k].value);
				}, 200)
			};
			this.destroy = function() {
				$('#' + _div + ' select').each(function() {
					_props[_k].value = $(this).val();
				});
			};
		},
		popMultiInputEditor : function() {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;
				
				$('<textarea style="width:100%;" class="pop-input" rows="1" cols="5"></textarea>').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);

				$('.pop-input').click(function() {
					var _placeholder = '';
					if($(this).parent().attr('id') == 'palermPerson'){
						_placeholder = "请输入手机号，多个号码请用\",\"隔开！"
					}else if($(this).parent().attr('id') == 'pssql'){
						_placeholder = "查询的数据表需带上数据库名称，比如：database_name.table"
					}
					
					$('#popupDialog').data('contentType', _props[_k].name);
					// 保存点击输入框,以便输入完后获取结果
					$('#popupDialog').data('clickInput', this);
					$('#popupDialog').find('#widgetName').val($(this).val());
					if(_placeholder != ''){
						$('#popupDialog').find('#widgetName').attr('placeholder', _placeholder);
					}else{
						$('#popupDialog').find('#widgetName').removeAttr('placeholder');
					}
					$('#popupDialog').dialog('open');
				});

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
			}

		},
		popPropertyEditor : function() {
			var _props, _k, _div, _src, _r,_divHtml;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;
				$('<textarea style="width:100%;" class="pop-property" rows="1" cols="5"></textarea>').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);
				
				// 首次恢复时重新加载应用变量
				if(props[_k].value === '' && _k === 'appVariables' && myflow.config.restore) {
						var appID = myflow.config.props.props.appName.value;
						$.getJSON('../config/getAppVars.do', {"appId" : appID}, function(data){
							$('textarea', '#' + _div).val(data.appVars);
							myflow.config.props.props.appVariables.value = data.appVars;
						});
				}

				//保存html，控件销毁时恢复
				_divHtml = $('#popupPropertyDialog').html();
				$('.pop-property').click(function() {
					// 保存点击输入框,以便输入完后获取结果
					$('#popupPropertyDialog').data('clickInput', this);
					//由于两个输入框同时使用该editor，需要每次都重新加载属性
					$('#popupPropertyDialog').find('.itemList').remove();
					//job属性,以"\n"分隔多个key=value对
					var jobProperties = $(this).val();
					if(jobProperties){
						var props = jobProperties.split('\n');
						$.each(props,function(idx,val){
							//key=value
							var index = val.indexOf('=');
							var key = val.substring(0,index);
							var value = val.substring(index+1);
							if(key && key!=''){
								addItem('.Item2',key,value);
							}
						});
					}
					$('#popupPropertyDialog').dialog('open');
				});

				$('#' + _div).data('editor', this);
			}
			this.destroy = function() {
				$('#' + _div + ' input').each(function() {
					_props[_k].value = $(this).val();
				});
				$('#popupPropertyDialog').html(_divHtml);
			}

		},
		transferModeSelectEditor : function(arg) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				var sle = $('<select  style="width:100%;"/ onchange="transferModeChange(this.value)" id="transferModeSelect">').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);


				for ( var idx = 0; idx < arg.length; idx++) {
					sle.append('<option value="' + arg[idx].value + '">'
							+ arg[idx].name + '</option>');
				}

				sle.val(_props[_k].value);

				$('#' + _div).data('mode',_props[_k].value);
				$('#' + _div).data('r',_r);
				$('#' + _div).data('src',_src);
				$('#' + _div).data('srcProps',_props);

				$('#' + _div).data('editor', this);
			};
			this.destroy = function() {
				$('#' + _div + ' select').each(function() {
					_props[_k].value = $(this).val();
				});
			};
		},
		depDbTypeSelectEditor : function(arg) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				var sle = $('<select  style="width:100%;"/ onchange="depDbTypeChange(this.value)" id="depDbTypeSelect">').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);


				for ( var idx = 0; idx < arg.length; idx++) {
					sle.append('<option value="' + arg[idx].value + '">'
							+ arg[idx].name + '</option>');
				}

				sle.val(_props[_k].value);

				$('#' + _div).data('mode',_props[_k].value);
				$('#' + _div).data('r',_r);
				$('#' + _div).data('src',_src);
				$('#' + _div).data('srcProps',_props);

				$('#' + _div).data('editor', this);
			};
			this.destroy = function() {
				$('#' + _div + ' select').each(function() {
					_props[_k].value = $(this).val();
				});
			};
		},
		depTypeSelectEditor : function(arg) {
			var _props, _k, _div, _src, _r;
			this.init = function(props, k, div, src, r) {
				_props = props;
				_k = k;
				_div = div;
				_src = src;
				_r = r;

				var sle = $('<select  style="width:100%;"/ onchange="depTypeChange(this.value)" id="depTypeSelect">').val(
						props[_k].value).change(function() {
					props[_k].value = $(this).val();
				}).appendTo('#' + _div);


				for ( var idx = 0; idx < arg.length; idx++) {
					sle.append('<option value="' + arg[idx].value + '">'
							+ arg[idx].name + '</option>');
				}

				sle.val(_props[_k].value);

				$('#' + _div).data('mode',_props[_k].value);
				$('#' + _div).data('r',_r);
				$('#' + _div).data('src',_src);
				$('#' + _div).data('srcProps',_props);

				$('#' + _div).data('editor', this);
			};
			this.destroy = function() {
				$('#' + _div + ' select').each(function() {
					_props[_k].value = $(this).val();
				});
			};
		}
		
	});

})(jQuery);
