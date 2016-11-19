(function($){
	$.fn.Pop = function(options) {
		var setting = {
			title :"添加",          //标题
			width :500,             //弹出层宽度
			height:400,             //弹出层高度
			offsetX:0,              //x轴偏移量
			offsetY:0,              //y轴偏移量
			mask:"true",            //是否显示遮罩  "true"代表显示遮罩
			btnText:"确定",         //底部按钮的文字
			setPosition:"center",   //显示位置  默认是"center",rightBottom:右下角，leftBottom:左下角，fixedId:根据fixedId的位置定位，配合fixedId使用
			fixedId:"",             //固定id的名称，配合setPosition使用
			showBot:"true",
			content:"false",
			onChange:function(){}   //点击底部按钮后执行其他的操作
		};
		var opt = $.extend({},setting, options);

		//判断IE6
		var isIE6 = $.browser.msie&&$.browser.version <= 6.0;


		//创建弹出层模型
		if(opt.content == "false"){
			//如果存在这个弹出层，显示弹出层和遮罩
			if($(this).attr('pop')){
				pos($('#Pop_'+$(this).attr('pop')));
				if(opt.mask == "true"){
					$('#PopMask').show();
				}
				$(window).bind('resize.pop',function(){
					pos($('#Pop_'+$(this).attr('pop')));
				});
				return;
			}

			/*--- 实现方法开始 ---*/
			var maxN = parseInt(new Date().getTime() / 1000);
			var popDom = createPop('Pop_'+maxN).hide();
			$(document.body).append(popDom);
			var popD = $('#Pop_'+maxN);
			
			//是否显示底部
			if(opt.showBot == 'false'){
				popD.find('.popBot').remove();
			}

			//把内容植入弹出层中
			$(this).show().attr('pop',maxN);
			$(this).appendTo(popD.find('.popCon'));
		}else{
			$(this).show();
			var popD = $(this);
		}

		//定义弹出层的位置
		pos(popD);

		//添加遮罩
		if(opt.mask == "true"){
			$('#PopMask')[0] ? $('#PopMask').show() : mask();
		};

		if(opt.contend == "false"){
		
			//弹出层按下的时候改变z轴大小
			popD.bind('mousedown.pop',function(){
				popD.css('z-index',parseInt(new Date().getTime() / 1000));
			});
			
			//屏幕缩放重新定位位置
			$(window).bind('resize.pop',function(){
				pos(popD);
			});
			
			
			//全屏按钮事件
			popD.find('.popFullScreen').bind('click',function(){
				if($(this).html() == '+'){
					posMax(popD);
					$(this).html('-');
				}else{
					pos(popD);
					$(this).html('+');
				}
			});
			
			//折叠弹出层内容
			popD.find('.popMin').bind('click',function(){
				if(parseInt(popD.height()) >= opt.height){
					popD.animate({'height':popD.find('.popTitle').outerHeight()}, 200);
				}else{
					if(parseInt(popD.css('width')) == $(window).width()-10){
						posMax(popD);
					}else{
						popD.animate({'height':opt.height}, 200);
					}
				}
				$(this).toggleClass('popMinUp');
			});
		}
		
		//实现拖动
		if(opt.setPosition != 'rightBottom' && opt.setPosition != 'leftBottom'){
			drag(popD.find('.popTitle'), popD);
		}
		/*--- 实现方法结束 ---*/


		//创建弹出层dom模型
		function createPop(id){
			var dom = $('<div class="pop" id="'+id+'">'
				+'<div class="popTitle">'+opt.title+'<a href="javascript:;" class="popMin"><span></span></a><a href="javascript:;" class="popFullScreen">+</a><a href="javascript:;" class="popClose">x</a></div>'
				+'<div class="popCon">'
				+'</div>'
				+'<div class="popBot"><button class="btnSubmit">'+opt.btnText+'</button></div>'
				+'</div>');
			return dom;
		};

		//关闭操作
		function closePop(){
			if(opt.setPosition == 'leftBottom' || opt.setPosition == 'rightBottom'){
				if(popD.find('.popClose').html() == '-'){
					popD.animate({'top' : parseInt(popD.css('top')) + popD.outerHeight() - popD.find('.popTitle').height()}, 200);
					popD.find('.popClose').html('+');
				}else{
					popD.animate({'top' : $(window).height() + $(window).scrollTop() - popD.outerHeight()}, 200);
					popD.find('.popClose').html('-');
				}
			}else{
				//popD.hide();
				$(window).unbind('.pop');
			}

			if(opt.mask == "true"){
				$('#PopMask').hide();
			}
		};

		//位置居中
		function pos(dom){
			if(opt.content == "false"){
				alert(456);
				dom.css({'width':opt.width,'height':opt.height});
				dom.css('z-index',parseInt(new Date().getTime() / 1000));
			}
			//定义scrollTop
			var _sh = $(window).scrollTop();
			switch (opt.setPosition){
				case 'rightBottom':
					dom.find('.popMin').remove();
					dom.find('.popFullScreen').remove();
					dom.find('.popClose').html('-');
					dom.css({'left' : $(window).width() - dom.outerWidth(), 'top' : $(window).height() + _sh - dom.outerHeight()});
					break;
				case 'leftBottom':
					dom.find('.popMin').remove();
					dom.find('.popFullScreen').remove();
					dom.find('.popClose').html('-');
					dom.css({'left' : 0, 'top' : $(window).height() + _sh - dom.outerHeight() + opt.offsetY});
					break;
				case 'fixedId':
					dom.css({'left' : $(opt.fixedId).offset().left, 'top' : $(opt.fixedId).offset().top + $(opt.fixedId).outerHeight()});
					break;
				default:
					var _left = $(window).width()/2 - dom.outerWidth()/2 + opt.offsetX;
					var _top = $(window).height()/2 - dom.outerHeight()/2 + opt.offsetY;
					_left = _left>0 ? _left:0;
					_top = _top>0 ? _top:0;

					//if(isIE6){
					dom.css({'top' : _top + _sh});
					//}else{
					//dom.css({position:'fixed','top':_top});
					//}
					dom.css({'left' : _left});
			}
			dom.show();
		}

		//全屏
		function posMax(dom){
			dom.animate({'top':'5px','left':'5px','width':$(window).width()-10,'height':$(window).height()-10}, 200);
		}

		//创建遮罩
		function mask(){
			$(document.body).append('<div class="popMask" id="PopMask"></div>');
			var _mh = $(document).height();
			$('#PopMask').css({'position':'absolute','height':_mh}).show();
			if(isIE6){
				$('#PopMask').append('<iframe scrolling="no" frameborder="0" class="popMaskIframe"></iframe>');
				$('#Iframe').css({'height' : _mh});
			};
		}

		//拖动
		function drag(control, dom){
			var _drag = false, _x, _y, cw, ch, sw, sh;
			control.css('cursor','move');
			control.mousedown(function(e){
				control.addClass('popTitleDrag');
				_drag = true;
				_x = e.pageX - parseInt(dom.css('left'));
				_y = e.pageY - parseInt(dom.css('top'));
				cw = $(window).width();
				ch = $(window).height();
				sw = parseInt(dom.outerWidth());
				sh = parseInt(dom.outerHeight());
				
				window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty(); //禁止拖放对象文本被选择的方法
				document.body.setCapture && dom[0].setCapture(); // IE下鼠标超出视口仍可被监听
				
				$(document).mousemove(function(e){
					if (_drag) {
						var x = e.pageX - _x;
						var y = e.pageY - _y;
						x = x < 0 ? x = 0 : x < (cw-sw) ? x :(cw-sw);
//						y = y < 0 ? y = 0 : y < (ch-sh) ? y :(ch-sh);
						x = x < 0 ? x = 0 : x;
						y = y < 0 ? y = 0 : y;
						dom.css({
							top: y,
							left: x
						});
					}
				}).mouseup(function(){
					control.removeClass('popTitleDrag');
					_drag = false;
					document.body.releaseCapture && dom[0].releaseCapture();
				});
			});
		}
	};
})(jQuery);