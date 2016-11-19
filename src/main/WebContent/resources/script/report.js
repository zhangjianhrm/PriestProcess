/**
 * query report scripts
 * 
 * #charttabs下为标签页，每个标签页只允许创建一个图表
 * 标签页上绑定两个属性：
 * type: 图表类型(pie, line, column...)
 * props: 图表属性(title, query flag, columns)
 */

$(function() {
	$.i18n.properties({
	    name : 'i18n', //资源文件名称
	    path : '../resources/script/i18n/', //资源文件路径
	    mode : 'map', //用Map的方式使用资源文件中的值
	    language : window.i18nValue,
	    callback : function() {//加载成功后设置显示内容
	    }
	});
	$('#loading').hide();
	
	// 图表
	$(".chart").draggable({ 
		helper: 'clone',
		revert: 'invalid',
		containment: '#tab1',
		appendTo: "#tab1"
	});
	// 文本
	$('#txtLabel').draggable({
		helper: function(){
			var txtInput = $('<textarea></textarea>').text('input text here')
					.attr({'type':'text', 'rows':'1'})
					.css({'resize':'auto', 'border-width':'0px', 'font-size':'150%'});
			return txtInput;
		},
		revert: 'invalid',
		containment: '#tab1',
		appendTo: "#tab1"
	});
	addDroppable($('#tab1'));
		
	//标签页
	$('#charttabs').tabs({
		select : function(event, ui){
			var curTab = $(ui.panel);
			$(".chart, #txtLabel").draggable('option', 'containment', curTab)
				.draggable('option', 'appendTo', curTab);
		}
	}).bind('mouseup', function(){
		closeDialog();
	}).data('currentTabIdx', 2);
	
	$('#newtab').bind('click', function(){
		closeDialog();
		
		var chartTabs =  $('#charttabs');
		var tabIdx = chartTabs.data('currentTabIdx');
		if(tabIdx > 12){
			alert($.i18n.prop('maxCrt'));
			return;
		}
		chartTabs.data('currentTabIdx', tabIdx+1);
		
		var newTabId = "tab" + tabIdx;
		var newTabDiv = $('<div></div>');
		newTabDiv.attr('id', newTabId);
		$('#charttabs').append(newTabDiv);
		addDroppable(newTabDiv);
		$('#charttabs').tabs('add', '#' + newTabId, $.i18n.prop('chart') + tabIdx);
	}).bind('mouseout', function(){
		$(this).blur();
	});
	
	$('#charts').bind('click', function(){
		closeDialog();
		$('#charttype').dialog({
			draggable: false,
			resizable : false,
			width : 220,
			position: {
				my: 'center top',
				at: 'center bottom',
				of: '#charts'
			}
		}).dialog('widget').find('.ui-dialog-titlebar').hide();
	});
	
	$('#props').bind('click', function(){
		closeDialog();
		
		var currentTabIdx = $('#charttabs').tabs('option', 'selected');
		var currentTabId = $('#charttabs > div').eq(currentTabIdx).attr('id');
		var currentTabObj = $('#' + currentTabId);
		
		if(!(currentTabObj.find("svg").length > 0 || currentTabObj.find(".chart").length > 0)){
			alert($.i18n.prop('selChart'));
			$('#charts').trigger('click');
			return false;
		}
		
		if(currentTabObj.data('type') === 'pieChart' || currentTabObj.data('type') === 'donutChart' 
				|| currentTabObj.find(".chart").attr('type') === 'pieChart' || currentTabObj.find(".chart").attr('type') === 'donutChart'){
			$('#xAxis').parent().prev().text($.i18n.prop('dataCol'));
			$('#yAxis').parent().parent().hide();
		} else {
			$('#xAxis').parent().prev().text($.i18n.prop('xData'));
			$('#yAxis').parent().parent().show();
		}
		
		// 从当前tab恢复图表数据
		if(currentTabObj.data('props')){
			var props = currentTabObj.data('props');
			$('#chartTitle').val(props.chartTitle);
			$('#queryFlag').val(props.queryFlag);
			$('#xAxis').val(props.xAxis);
			$('#yAxis').val(props.yAxis);
		} else {
			$('#chartTitle').val('');
			$('#queryFlag').val('');
			$('#xAxis').val('');
			$('#yAxis').val('');
		}
		
		
		$('#propsEditor').dialog({
			draggable: false,
			resizable : false,
			width : 260,
			position: {
				my: 'center top',
				at: 'center bottom',
				of: '#props'
			}
		}).dialog('widget').find('.ui-dialog-titlebar').hide();
	});
	
});

function addDroppable(obj){
	obj.droppable({
		accept : '.chart, #txtLabel',
		drop : function(event, ui){
			//添加拖动图表
			var helperCopy = $(ui.helper).clone();
			
			if(helperCopy.attr('type') !== 'text'){
				if((obj.find("svg").length > 0 || obj.find(".chart").length > 1)){
					alert($.i18n.prop('chartAlarm'));
					return false;
				}
				
				helperCopy.find('img').css('width', '144px').css('height', '144px');
				
				// 只有图表绑定点击事件
				helperCopy.bind('click', function(){
					$('#props').data('currentObj', helperCopy).trigger('click');
				});
			} else {
				helperCopy.bind('dblclick', function(){
					$(this).focus();
				}).bind('focusin', function(){
					if($(this).text() === 'input text here'){
						$(this).text('');
					}
				}).bind('focusout', function(){
					if($(this).text() === ''){
						$(this).text("input text here");
					}
				}).draggable({
					cancel : '.cancel'
				});
			}
			
			$(this).append(helperCopy);
			
			//关闭图表选项dialog
			closeDialog();
		}
	});
}

function closeDialog(){
	$('#charttype, #propsEditor').dialog('close');
}