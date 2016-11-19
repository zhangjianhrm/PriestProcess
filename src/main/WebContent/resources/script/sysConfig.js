/* sweetalert */
!function(e,t,n){"use strict";!function o(e,t,n){function a(s,l){if(!t[s]){if(!e[s]){var i="function"==typeof require&&require;if(!l&&i)return i(s,!0);if(r)return r(s,!0);var u=new Error("Cannot find module '"+s+"'");throw u.code="MODULE_NOT_FOUND",u}var c=t[s]={exports:{}};e[s][0].call(c.exports,function(t){var n=e[s][1][t];return a(n?n:t)},c,c.exports,o,e,t,n)}return t[s].exports}for(var r="function"==typeof require&&require,s=0;s<n.length;s++)a(n[s]);return a}({1:[function(o,a,r){var s=function(e){return e&&e.__esModule?e:{"default":e}};Object.defineProperty(r,"__esModule",{value:!0});var l,i,u,c,d=o("./modules/handle-dom"),f=o("./modules/utils"),p=o("./modules/handle-swal-dom"),m=o("./modules/handle-click"),v=o("./modules/handle-key"),y=s(v),h=o("./modules/default-params"),b=s(h),g=o("./modules/set-params"),w=s(g);r["default"]=u=c=function(){function o(e){var t=a;return t[e]===n?b["default"][e]:t[e]}var a=arguments[0];if(d.addClass(t.body,"stop-scrolling"),p.resetInput(),a===n)return f.logStr("SweetAlert expects at least 1 attribute!"),!1;var r=f.extend({},b["default"]);switch(typeof a){case"string":r.title=a,r.text=arguments[1]||"",r.type=arguments[2]||"";break;case"object":if(a.title===n)return f.logStr('Missing "title" argument!'),!1;r.title=a.title;for(var s in b["default"])r[s]=o(s);r.confirmButtonText=r.showCancelButton?"Confirm":b["default"].confirmButtonText,r.confirmButtonText=o("confirmButtonText"),r.doneFunction=arguments[1]||null;break;default:return f.logStr('Unexpected type of argument! Expected "string" or "object", got '+typeof a),!1}w["default"](r),p.fixVerticalPosition(),p.openModal(arguments[1]);for(var u=p.getModal(),v=u.querySelectorAll("button"),h=["onclick","onmouseover","onmouseout","onmousedown","onmouseup","onfocus"],g=function(e){return m.handleButton(e,r,u)},C=0;C<v.length;C++)for(var S=0;S<h.length;S++){var x=h[S];v[C][x]=g}p.getOverlay().onclick=g,l=e.onkeydown;var k=function(e){return y["default"](e,r,u)};e.onkeydown=k,e.onfocus=function(){setTimeout(function(){i!==n&&(i.focus(),i=n)},0)},c.enableButtons()},u.setDefaults=c.setDefaults=function(e){if(!e)throw new Error("userParams is required");if("object"!=typeof e)throw new Error("userParams has to be a object");f.extend(b["default"],e)},u.close=c.close=function(){var o=p.getModal();d.fadeOut(p.getOverlay(),5),d.fadeOut(o,5),d.removeClass(o,"showSweetAlert"),d.addClass(o,"hideSweetAlert"),d.removeClass(o,"visible");var a=o.querySelector(".sa-icon.sa-success");d.removeClass(a,"animate"),d.removeClass(a.querySelector(".sa-tip"),"animateSuccessTip"),d.removeClass(a.querySelector(".sa-long"),"animateSuccessLong");var r=o.querySelector(".sa-icon.sa-error");d.removeClass(r,"animateErrorIcon"),d.removeClass(r.querySelector(".sa-x-mark"),"animateXMark");var s=o.querySelector(".sa-icon.sa-warning");return d.removeClass(s,"pulseWarning"),d.removeClass(s.querySelector(".sa-body"),"pulseWarningIns"),d.removeClass(s.querySelector(".sa-dot"),"pulseWarningIns"),setTimeout(function(){var e=o.getAttribute("data-custom-class");d.removeClass(o,e)},300),d.removeClass(t.body,"stop-scrolling"),e.onkeydown=l,e.previousActiveElement&&e.previousActiveElement.focus(),i=n,clearTimeout(o.timeout),!0},u.showInputError=c.showInputError=function(e){var t=p.getModal(),n=t.querySelector(".sa-input-error");d.addClass(n,"show");var o=t.querySelector(".sa-error-container");d.addClass(o,"show"),o.querySelector("p").innerHTML=e,setTimeout(function(){u.enableButtons()},1),t.querySelector("input").focus()},u.resetInputError=c.resetInputError=function(e){if(e&&13===e.keyCode)return!1;var t=p.getModal(),n=t.querySelector(".sa-input-error");d.removeClass(n,"show");var o=t.querySelector(".sa-error-container");d.removeClass(o,"show")},u.disableButtons=c.disableButtons=function(){var e=p.getModal(),t=e.querySelector("button.confirm"),n=e.querySelector("button.cancel");t.disabled=!0,n.disabled=!0},u.enableButtons=c.enableButtons=function(){var e=p.getModal(),t=e.querySelector("button.confirm"),n=e.querySelector("button.cancel");t.disabled=!1,n.disabled=!1},"undefined"!=typeof e?e.sweetAlert=e.swal=u:f.logStr("SweetAlert is a frontend module!"),a.exports=r["default"]},{"./modules/default-params":2,"./modules/handle-click":3,"./modules/handle-dom":4,"./modules/handle-key":5,"./modules/handle-swal-dom":6,"./modules/set-params":8,"./modules/utils":9}],2:[function(e,t,n){Object.defineProperty(n,"__esModule",{value:!0});var o={title:"",text:"",type:null,allowOutsideClick:!1,showConfirmButton:!0,showCancelButton:!1,closeOnConfirm:!0,closeOnCancel:!0,confirmButtonText:"OK",confirmButtonColor:"#8CD4F5",cancelButtonText:"Cancel",imageUrl:null,imageSize:null,timer:null,customClass:"",html:!1,animation:!0,allowEscapeKey:!0,inputType:"text",inputPlaceholder:"",inputValue:"",showLoaderOnConfirm:!1};n["default"]=o,t.exports=n["default"]},{}],3:[function(t,n,o){Object.defineProperty(o,"__esModule",{value:!0});var a=t("./utils"),r=(t("./handle-swal-dom"),t("./handle-dom")),s=function(t,n,o){function s(e){m&&n.confirmButtonColor&&(p.style.backgroundColor=e)}var u,c,d,f=t||e.event,p=f.target||f.srcElement,m=-1!==p.className.indexOf("confirm"),v=-1!==p.className.indexOf("sweet-overlay"),y=r.hasClass(o,"visible"),h=n.doneFunction&&"true"===o.getAttribute("data-has-done-function");switch(m&&n.confirmButtonColor&&(u=n.confirmButtonColor,c=a.colorLuminance(u,-.04),d=a.colorLuminance(u,-.14)),f.type){case"mouseover":s(c);break;case"mouseout":s(u);break;case"mousedown":s(d);break;case"mouseup":s(c);break;case"focus":var b=o.querySelector("button.confirm"),g=o.querySelector("button.cancel");m?g.style.boxShadow="none":b.style.boxShadow="none";break;case"click":var w=o===p,C=r.isDescendant(o,p);if(!w&&!C&&y&&!n.allowOutsideClick)break;m&&h&&y?l(o,n):h&&y||v?i(o,n):r.isDescendant(o,p)&&"BUTTON"===p.tagName&&sweetAlert.close()}},l=function(e,t){var n=!0;r.hasClass(e,"show-input")&&(n=e.querySelector("input").value,n||(n="")),t.doneFunction(n),t.closeOnConfirm&&sweetAlert.close(),t.showLoaderOnConfirm&&sweetAlert.disableButtons()},i=function(e,t){var n=String(t.doneFunction).replace(/\s/g,""),o="function("===n.substring(0,9)&&")"!==n.substring(9,10);o&&t.doneFunction(!1),t.closeOnCancel&&sweetAlert.close()};o["default"]={handleButton:s,handleConfirm:l,handleCancel:i},n.exports=o["default"]},{"./handle-dom":4,"./handle-swal-dom":6,"./utils":9}],4:[function(n,o,a){Object.defineProperty(a,"__esModule",{value:!0});var r=function(e,t){return new RegExp(" "+t+" ").test(" "+e.className+" ")},s=function(e,t){r(e,t)||(e.className+=" "+t)},l=function(e,t){var n=" "+e.className.replace(/[\t\r\n]/g," ")+" ";if(r(e,t)){for(;n.indexOf(" "+t+" ")>=0;)n=n.replace(" "+t+" "," ");e.className=n.replace(/^\s+|\s+$/g,"")}},i=function(e){var n=t.createElement("div");return n.appendChild(t.createTextNode(e)),n.innerHTML},u=function(e){e.style.opacity="",e.style.display="block"},c=function(e){if(e&&!e.length)return u(e);for(var t=0;t<e.length;++t)u(e[t])},d=function(e){e.style.opacity="",e.style.display="none"},f=function(e){if(e&&!e.length)return d(e);for(var t=0;t<e.length;++t)d(e[t])},p=function(e,t){for(var n=t.parentNode;null!==n;){if(n===e)return!0;n=n.parentNode}return!1},m=function(e){e.style.left="-9999px",e.style.display="block";var t,n=e.clientHeight;return t="undefined"!=typeof getComputedStyle?parseInt(getComputedStyle(e).getPropertyValue("padding-top"),10):parseInt(e.currentStyle.padding),e.style.left="",e.style.display="none","-"+parseInt((n+t)/2)+"px"},v=function(e,t){if(+e.style.opacity<1){t=t||16,e.style.opacity=0,e.style.display="block";var n=+new Date,o=function(e){function t(){return e.apply(this,arguments)}return t.toString=function(){return e.toString()},t}(function(){e.style.opacity=+e.style.opacity+(new Date-n)/100,n=+new Date,+e.style.opacity<1&&setTimeout(o,t)});o()}e.style.display="block"},y=function(e,t){t=t||16,e.style.opacity=1;var n=+new Date,o=function(e){function t(){return e.apply(this,arguments)}return t.toString=function(){return e.toString()},t}(function(){e.style.opacity=+e.style.opacity-(new Date-n)/100,n=+new Date,+e.style.opacity>0?setTimeout(o,t):e.style.display="none"});o()},h=function(n){if("function"==typeof MouseEvent){var o=new MouseEvent("click",{view:e,bubbles:!1,cancelable:!0});n.dispatchEvent(o)}else if(t.createEvent){var a=t.createEvent("MouseEvents");a.initEvent("click",!1,!1),n.dispatchEvent(a)}else t.createEventObject?n.fireEvent("onclick"):"function"==typeof n.onclick&&n.onclick()},b=function(t){"function"==typeof t.stopPropagation?(t.stopPropagation(),t.preventDefault()):e.event&&e.event.hasOwnProperty("cancelBubble")&&(e.event.cancelBubble=!0)};a.hasClass=r,a.addClass=s,a.removeClass=l,a.escapeHtml=i,a._show=u,a.show=c,a._hide=d,a.hide=f,a.isDescendant=p,a.getTopMargin=m,a.fadeIn=v,a.fadeOut=y,a.fireClick=h,a.stopEventPropagation=b},{}],5:[function(t,o,a){Object.defineProperty(a,"__esModule",{value:!0});var r=t("./handle-dom"),s=t("./handle-swal-dom"),l=function(t,o,a){var l=t||e.event,i=l.keyCode||l.which,u=a.querySelector("button.confirm"),c=a.querySelector("button.cancel"),d=a.querySelectorAll("button[tabindex]");if(-1!==[9,13,32,27].indexOf(i)){for(var f=l.target||l.srcElement,p=-1,m=0;m<d.length;m++)if(f===d[m]){p=m;break}9===i?(f=-1===p?u:p===d.length-1?d[0]:d[p+1],r.stopEventPropagation(l),f.focus(),o.confirmButtonColor&&s.setFocusStyle(f,o.confirmButtonColor)):13===i?("INPUT"===f.tagName&&(f=u,u.focus()),f=-1===p?u:n):27===i&&o.allowEscapeKey===!0?(f=c,r.fireClick(f,l)):f=n}};a["default"]=l,o.exports=a["default"]},{"./handle-dom":4,"./handle-swal-dom":6}],6:[function(n,o,a){var r=function(e){return e&&e.__esModule?e:{"default":e}};Object.defineProperty(a,"__esModule",{value:!0});var s=n("./utils"),l=n("./handle-dom"),i=n("./default-params"),u=r(i),c=n("./injected-html"),d=r(c),f=".sweet-alert",p=".sweet-overlay",m=function(){var e=t.createElement("div");for(e.innerHTML=d["default"];e.firstChild;)t.body.appendChild(e.firstChild)},v=function(e){function t(){return e.apply(this,arguments)}return t.toString=function(){return e.toString()},t}(function(){var e=t.querySelector(f);return e||(m(),e=v()),e}),y=function(){var e=v();return e?e.querySelector("input"):void 0},h=function(){return t.querySelector(p)},b=function(e,t){var n=s.hexToRgb(t);e.style.boxShadow="0 0 2px rgba("+n+", 0.8), inset 0 0 0 1px rgba(0, 0, 0, 0.05)"},g=function(n){var o=v();l.fadeIn(h(),10),l.show(o),l.addClass(o,"showSweetAlert"),l.removeClass(o,"hideSweetAlert"),e.previousActiveElement=t.activeElement;var a=o.querySelector("button.confirm");a.focus(),setTimeout(function(){l.addClass(o,"visible")},500);var r=o.getAttribute("data-timer");if("null"!==r&&""!==r){var s=n;o.timeout=setTimeout(function(){var e=(s||null)&&"true"===o.getAttribute("data-has-done-function");e?s(null):sweetAlert.close()},r)}},w=function(){var e=v(),t=y();l.removeClass(e,"show-input"),t.value=u["default"].inputValue,t.setAttribute("type",u["default"].inputType),t.setAttribute("placeholder",u["default"].inputPlaceholder),C()},C=function(e){if(e&&13===e.keyCode)return!1;var t=v(),n=t.querySelector(".sa-input-error");l.removeClass(n,"show");var o=t.querySelector(".sa-error-container");l.removeClass(o,"show")},S=function(){var e=v();e.style.marginTop=l.getTopMargin(v())};a.sweetAlertInitialize=m,a.getModal=v,a.getOverlay=h,a.getInput=y,a.setFocusStyle=b,a.openModal=g,a.resetInput=w,a.resetInputError=C,a.fixVerticalPosition=S},{"./default-params":2,"./handle-dom":4,"./injected-html":7,"./utils":9}],7:[function(e,t,n){Object.defineProperty(n,"__esModule",{value:!0});var o='<div class="sweet-overlay" tabIndex="-1"></div><div class="sweet-alert"><div class="sa-icon sa-error">\n      <span class="sa-x-mark">\n        <span class="sa-line sa-left"></span>\n        <span class="sa-line sa-right"></span>\n      </span>\n    </div><div class="sa-icon sa-warning">\n      <span class="sa-body"></span>\n      <span class="sa-dot"></span>\n    </div><div class="sa-icon sa-info"></div><div class="sa-icon sa-success">\n      <span class="sa-line sa-tip"></span>\n      <span class="sa-line sa-long"></span>\n\n      <div class="sa-placeholder"></div>\n      <div class="sa-fix"></div>\n    </div><div class="sa-icon sa-custom"></div><h2>Title</h2>\n    <p>Text</p>\n    <fieldset>\n      <input type="text" tabIndex="3" />\n      <div class="sa-input-error"></div>\n    </fieldset><div class="sa-error-container">\n      <div class="icon">!</div>\n      <p>Not valid!</p>\n    </div><div class="sa-button-container">\n      <button class="cancel" tabIndex="2">Cancel</button>\n      <div class="sa-confirm-button-container">\n        <button class="confirm" tabIndex="1">OK</button><div class="la-ball-fall">\n          <div></div>\n          <div></div>\n          <div></div>\n        </div>\n      </div>\n    </div></div>';n["default"]=o,t.exports=n["default"]},{}],8:[function(e,t,o){Object.defineProperty(o,"__esModule",{value:!0});var a=e("./utils"),r=e("./handle-swal-dom"),s=e("./handle-dom"),l=["error","warning","info","success","input","prompt"],i=function(e){var t=r.getModal(),o=t.querySelector("h2"),i=t.querySelector("p"),u=t.querySelector("button.cancel"),c=t.querySelector("button.confirm");if(o.innerHTML=e.html?e.title:s.escapeHtml(e.title).split("\n").join("<br>"),i.innerHTML=e.html?e.text:s.escapeHtml(e.text||"").split("\n").join("<br>"),e.text&&s.show(i),e.customClass)s.addClass(t,e.customClass),t.setAttribute("data-custom-class",e.customClass);else{var d=t.getAttribute("data-custom-class");s.removeClass(t,d),t.setAttribute("data-custom-class","")}if(s.hide(t.querySelectorAll(".sa-icon")),e.type&&!a.isIE8()){var f=function(){for(var o=!1,a=0;a<l.length;a++)if(e.type===l[a]){o=!0;break}if(!o)return logStr("Unknown alert type: "+e.type),{v:!1};var i=["success","error","warning","info"],u=n;-1!==i.indexOf(e.type)&&(u=t.querySelector(".sa-icon.sa-"+e.type),s.show(u));var c=r.getInput();switch(e.type){case"success":s.addClass(u,"animate"),s.addClass(u.querySelector(".sa-tip"),"animateSuccessTip"),s.addClass(u.querySelector(".sa-long"),"animateSuccessLong");break;case"error":s.addClass(u,"animateErrorIcon"),s.addClass(u.querySelector(".sa-x-mark"),"animateXMark");break;case"warning":s.addClass(u,"pulseWarning"),s.addClass(u.querySelector(".sa-body"),"pulseWarningIns"),s.addClass(u.querySelector(".sa-dot"),"pulseWarningIns");break;case"input":case"prompt":c.setAttribute("type",e.inputType),c.value=e.inputValue,c.setAttribute("placeholder",e.inputPlaceholder),s.addClass(t,"show-input"),setTimeout(function(){c.focus(),c.addEventListener("keyup",swal.resetInputError)},400)}}();if("object"==typeof f)return f.v}if(e.imageUrl){var p=t.querySelector(".sa-icon.sa-custom");p.style.backgroundImage="url("+e.imageUrl+")",s.show(p);var m=80,v=80;if(e.imageSize){var y=e.imageSize.toString().split("x"),h=y[0],b=y[1];h&&b?(m=h,v=b):logStr("Parameter imageSize expects value with format WIDTHxHEIGHT, got "+e.imageSize)}p.setAttribute("style",p.getAttribute("style")+"width:"+m+"px; height:"+v+"px")}t.setAttribute("data-has-cancel-button",e.showCancelButton),e.showCancelButton?u.style.display="inline-block":s.hide(u),t.setAttribute("data-has-confirm-button",e.showConfirmButton),e.showConfirmButton?c.style.display="inline-block":s.hide(c),e.cancelButtonText&&(u.innerHTML=s.escapeHtml(e.cancelButtonText)),e.confirmButtonText&&(c.innerHTML=s.escapeHtml(e.confirmButtonText)),e.confirmButtonColor&&(c.style.backgroundColor=e.confirmButtonColor,c.style.borderLeftColor=e.confirmLoadingButtonColor,c.style.borderRightColor=e.confirmLoadingButtonColor,r.setFocusStyle(c,e.confirmButtonColor)),t.setAttribute("data-allow-outside-click",e.allowOutsideClick);var g=e.doneFunction?!0:!1;t.setAttribute("data-has-done-function",g),e.animation?"string"==typeof e.animation?t.setAttribute("data-animation",e.animation):t.setAttribute("data-animation","pop"):t.setAttribute("data-animation","none"),t.setAttribute("data-timer",e.timer)};o["default"]=i,t.exports=o["default"]},{"./handle-dom":4,"./handle-swal-dom":6,"./utils":9}],9:[function(t,n,o){Object.defineProperty(o,"__esModule",{value:!0});var a=function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n]);return e},r=function(e){var t=/^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(e);return t?parseInt(t[1],16)+", "+parseInt(t[2],16)+", "+parseInt(t[3],16):null},s=function(){return e.attachEvent&&!e.addEventListener},l=function(t){e.console&&e.console.log("SweetAlert: "+t)},i=function(e,t){e=String(e).replace(/[^0-9a-f]/gi,""),e.length<6&&(e=e[0]+e[0]+e[1]+e[1]+e[2]+e[2]),t=t||0;var n,o,a="#";for(o=0;3>o;o++)n=parseInt(e.substr(2*o,2),16),n=Math.round(Math.min(Math.max(0,n+n*t),255)).toString(16),a+=("00"+n).substr(n.length);return a};o.extend=a,o.hexToRgb=r,o.isIE8=s,o.logStr=l,o.colorLuminance=i},{}]},{},[1]),"function"==typeof define&&define.amd?define(function(){return sweetAlert}):"undefined"!=typeof module&&module.exports&&(module.exports=sweetAlert)}(window,document);

$(function(){
	$.i18n.properties({
	    name : 'i18n', //资源文件名称
	    path : '../resources/script/i18n/', //资源文件路径
	    mode : 'map', //用Map的方式使用资源文件中的值
	    language : window.i18nValue,
	    callback : function() {//加载成功后设置显示内容
	    }
	});
	
	var LinkName = ['hive', 'spark', 'redis']; 
	function getConfig(type){
		var _param = type ? {type: type} : {}; 
		$.ajax({
			url: '../config/getSysConfig.do',
			type: 'post',
			data: _param,
			success: function(data) {
				var _data = [[],[],[],[],[]];
				$.each(data.rows, function(k, v){
					var _type = parseInt(v.type) - 1;
					
					_data[_type].push(v);
				})
				
				$.each(_data, function(k, v){
					if(typeof type == "undefined" || (typeof type != "undefined" && type == (k+1))){
						if(k < 3){
							var _html = '';
							
							$.each(v, function(key, val){
								_html += '<li data-type="'+val.type+'" data-url="'+val.url+'" data-priority="'+val.priority+'" data-ip="'+val.ip+'" data-port="'+val.port+'" data-db="'+val.dbName+'" data-principal="'+val.principal+'">'
										+'<div class="name">'+LinkName[k]+$.i18n.prop('link')+(key+1)+'：</div>'
										+'<div class="text">'+val.url+'</div>'
										+'<div class="opts">'
										+'<a href="javascript:;" class="edit" data-type="'+val.type+'" data-priority="'+v.priority+'"><span class="glyphicon glyphicon-edit"></span></a>'
										+'<a href="javascript:;" class="del" data-type="'+val.type+'" data-priority="'+v.priority+'"><span class="glyphicon glyphicon-trash"></span></a>'
										+'</div>'
										+'</li>';
							})
							$('#Config_' + (k+1)).find('.configList').html('<ul></ul>');
						
							if(_html == '' && ((typeof type == "undefined") || (typeof type != "undefined" && type == (k+1)))){
								$('#Config_' + (k+1)).find('.nullTip').removeClass('hidden');
								$('#Config_' + (k+1)).find('.configList').addClass('hidden');
							}else{
								$('#Config_' + (k+1)).find('.configList ul').html(_html);
							}
						}else if(k == 3){
							if(v.length > 0){
								$('#Config_4').find('.nullTip').addClass('hidden');
								$('#Config_4').find('.addConfig').addClass('hidden');
								$('#Config_4').find('.configList').html('<ul></ul>');
								$('#Config_4').find('.search-btn').remove();
								
								
								var _phone = '';
								if(v[0].target != null){
									_phone = '<li><div class="name">'+$.i18n.prop('phone')+'：</div><div class="text cellList">'
									$.each(v[0].target.split(','), function(k, v){
										_phone += '<div class="cell" data-val="'+v+'">'+v+'<a href="javascript:;" class="delCell">×</a></div>'
									})
									_phone += '<div class="cell addCellLink"><a href="javascript:;" class="addCell"><span class="glyphicon glyphicon-remove-circle"></span></a></div></div></li>'
								}
								
								$('#Config_4').find('.configList ul').html('<li>'
										+'<div class="name">'+$.i18n.prop('userName')+'：</div>'
										+'<div class="text textS" data-val="'+v[0].user+'">'
										+v[0].user
										+'</div>'
										+'</li>'
										+'<li>'
										+'<div class="name">'+$.i18n.prop('password')+'：</div>'
										+'<div class="text textS passwd" data-val="'+v[0].passwd+'">'
										+'******<a href="javascript:;" class="passwdEye"></a>'
										+'</div>'
										
										+'</li><li>'
										+'<div class="name">'+$.i18n.prop('link')+'：</div>'
										+'<div class="text">'+v[0].url+'</div>'
										+'</li>'+ _phone);
								
								$('#Config_4 .tit .opts').html('<a href="javascript:;" class="btn btn-primary edit" data-type="4" data-priority="1"><span class="glyphicon glyphicon-edit"></span>编辑</a>'
								+'<a href="javascript:;" class="btn btn-default del" data-type="4" data-priority="1"><span class="glyphicon glyphicon-trash"></span>删除</a>');
							}
						}else if(k == 4){
							if(v.length > 0){
								$('#Config_5').find('.nullTip').addClass('hidden');
								$('#Config_5').find('.addConfig').addClass('hidden');
								$('#Config_5').find('.configList').html('<ul></ul>');
								
								var _email = '';
								if(v[0].target != null){
									_email = '<li><div class="name">'+$.i18n.prop('email')+'：</div><div class="text cellList">'
									$.each(v[0].target.split(';'), function(k, v){
										_email += '<div class="cell" data-val="'+v+'">'+v+'<a href="javascript:;" class="delCell">×</a></div>'
									})
									_email += '<div class="cell addCellLink"><a href="javascript:;" class="addCell"><span class="glyphicon glyphicon-remove-circle"></span></a></div></div></li>'
								}
								
								$('#Config_5').find('.configList ul').html('<li>'
										+'<div class="name">'+$.i18n.prop('link')+'：</div>'
										+'<div class="text">'+v[0].url+'</div>'
										+'<div class="opts">'
										+'<a href="javascript:;" class="edit" data-type="5" data-priority="1"><span class="glyphicon glyphicon-edit"></span></a>'
										+'<a href="javascript:;" class="del" data-type="5" data-priority="1"><span class="glyphicon glyphicon-trash"></span></a>'
										+'</div>'
										+'</li>'+_email);
							}
						}
					}
				})
			},
			
			error : function() {
				// 出错提示
				swal("Error", 'System error!', "error");
			}
		});
	}
	
	function getEnvConfig(){
		$.ajax({
			url: '../config/getSysMap.do',
			type: 'post',
			success: function(data) {
				var _data = data.rows;
				$('.evnConfig li').each(function(){
					var _type = $(this).data('type');
					if(_data[_type]){
						$(this).find('.text').html(_data[_type]);
					}
				})
			},
			error : function() {
				// 出错提示
				swal("Error", 'System error!', "error");
			}
		});
	}
	
	function bindEvent(){
		$('.configItem').on('click', '.edit', function(){
			var _type = $(this).data('type');
			
			if(_type == 4 || _type == 5){
				var _thisCon = $(this).parents('.configItem');
				
				if(_thisCon.find('.search-btn').length > 0){
					return;
				}
				
				_thisCon.find('.text').each(function(){
					if(!$(this).hasClass('cellList')){
						if($(this).hasClass('textS')){
							$(this).html('<input type="text" value="'+$(this).data('val')+'" data-val="'+$(this).data('val')+'">')
						}else{
							$(this).html('<textarea class="textarea" data-val="'+$(this).html()+'">'+$(this).html()+'</textarea>');
						}
					}else{
						$(this).addClass('editAble');
					}
				})
				_thisCon.append('<div class="search-btn">'
						+'<input type="button" value="'+$.i18n.prop("save")+'" class="btn btn-primary saveEdit" data-type="'+_type+'">'
						+'<input type="reset" value="'+$.i18n.prop("cancel")+'" class="btn btn-default cancelEdit" data-type="'+_type+'">'
						+'</div>')
			}else{
				var _thisCon = $(this).parents('li');
				if(_thisCon.find('.search-btn').length > 0){
					return;
				}
				
				_thisCon.find('.opts').addClass('hidden');
				
				var _priority = _thisCon.data('priority'),
					_ip = _thisCon.data('ip'),
					_port = _thisCon.data('port'),
					_dbName = _thisCon.data('db'),
					_principal = _thisCon.data('principal'),
					_url = _thisCon.data('url');
				
				if(_type == 1 || _type == 2){
					_thisCon.append('<li class="editCon" data-type="'+_type+'" data-priority="'+ _priority +'">'
							+'<div class="urlList">'
								+'<div class="name">IP：</div>'
								+'<div class="text"><input type="text" class="form-control urlIP" value="'+_ip+'"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">端口：</div>'
								+'<div class="text"><input type="text" class="form-control urlPort" value="'+_port+'"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">数据库名：</div>'
								+'<div class="text"><input type="text" class="form-control urlDB" value="'+_dbName+'"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">principal：</div>'
								+'<div class="text"><input type="text" class="form-control urlPrincipal" value="'+_principal+'"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">url：</div>'
								+'<div class="text"><textarea class="textarea urlCon">'+ _url +'</textarea></div>'
							+'</div>'
							+'</li>');
				}else{
					
					var _hostHtml = '';
					
					
					_ip = _ip.split(',');
					_port = (_port+'').split(',');
					
					$.each(_ip, function(k, v){
						var _addHtml = k == _ip.length - 1 ? '<a href="javascript:;" class="btn btn-default btn-sm urlAdd">添加连接</a>' : '';
						_hostHtml += '<div class="urlList">'
										+'<div class="name">连接：</div>'
										+'<div class="text">'
											+'<input type="text" class="form-control urlIP" placeholder="IP" style="width: 180px;" value="'+v+'">'
											+'<input type="text" class="form-control urlPort" placeholder="端口" style="width: 100px; margin: 0 20px 0 15px;" value="'+_port[k]+'">'
											+ _addHtml
										+'</div>'
									+'</div>'
					})
				
					_thisCon.append('<li class="editCon" data-type="'+_type+'" data-priority="'+ _priority +'">'
							+'<div id="UrlList">'
							+ _hostHtml
							+'</div>'
							
							+'<div class="urlList">'
								+'<div class="name">url：</div>'
								+'<div class="text"><textarea class="textarea urlCon">'+_url+'</textarea></div>'
							+'</div>'
							+'</li>');
				}
				
//				_thisCon.find('.text').html('<textarea class="textarea" data-val="'+_thisCon.find('.text').html()+'">'+_thisCon.find('.text').html()+'</textarea>');
				
				_thisCon.append('<div class="search-btn">'
						+'<input type="button" value="'+$.i18n.prop("save")+'" class="btn btn-primary saveEdit" data-type="'+_type+'">'
						+'<input type="reset" value="'+$.i18n.prop("cancel")+'" class="btn btn-default cancelEdit" data-type="'+_type+'">'
						+'</div>');
				
				$('.urlList input').keyup(function(){
					setUrl($(this));
				})
						
			}
		})
		
		$('.configItem').on('click', '.del', function(){
			if($(this).data('type') == 4 || $(this).data('type') == 5){
				var _priority = $(this).data('priority');
				var _type = $(this).data('type');
			}else{
				var _thisCon = $(this).parents('li');
				var _priority = _thisCon.data('priority');
				var _type = _thisCon.data('type');
			}
			
			$.ajax({
				url: '../config/delSysConfig.do',
				type: 'post',
				data: {
					type: _type,
					priority: _priority
				},
				success: function(data) {
					if(_type == 4 || _type == 5){
						$('#Config_' + _type).find('.nullTip').removeClass('hidden');
						$('#Config_' + _type).find('.configList').html('');
						$('#Config_' + _type).find('.tit .opts').html('<a href="javascript:;" class="btn btn-primary addConfig" data-type="'+_type+'"><i class="iconAdd"></i>添加配置</a>');
					}else{
						getConfig(_type);
					}
				},
				error: function() {
					// 出错提示
					swal("Error", 'System error!', "error");
				}
			});
		})
		
		
		$('.configItem').on('click', '.cancelEdit', function(){
			var _type = $(this).data('type');
			if(_type == 4 || _type == 5){
				getConfig(_type);
			}else{
				var _thisCon = $(this).parents('li');
				
				_thisCon.find('.opts').removeClass('hidden');
				_thisCon.find('.editCon').remove();
				_thisCon.find('.search-btn').remove();
			}
		})
		
		$('.configItem').on('click', '.saveEdit', function(){
			var _type = $(this).data('type');
			if(_type == 4){
				var _thisCon = $(this).parents('.configItem');
				var _user = _thisCon.find('input').eq(0).val();
				var _passwd = _thisCon.find('input').eq(1).val();
				var _url = _thisCon.find('.textarea').val();
				var _target = [];
				
				if(_user == ''){
					alert('用户名不能为空！');
					return;
				}
				if(_passwd == ''){
					alert('密码不能为空！');
					return;					
				}
				if(_url == ''){
					alert('链接不能为空！');
					return;					
				}
				
				var _next = true;
				_thisCon.find('.cell').each(function(){
					if(!$(this).hasClass('addCellLink')){
						if($(this).hasClass('cellAdd')){
							if($(this).find('input').val() != ''){
								if($(this).find('input').val() == 0){
									if($(this).find('.errorTip').length == 0){
										$(this).addClass('has-error');
										$(this).append('<span class="errorTip">不能为空！</span>');
									}
									_next = false;
								}
								if(!/^0?1[3|4|5|8|7][0-9]\d{8}$/.test($(this).find('input').val())){
									if($(this).find('.errorTip').length == 0){
										$(this).addClass('has-error');
										$(this).append('<span class="errorTip">'+$.i18n.prop('phoneError')+'</span>');
									}
									_next = false;
								}
								_target.push($(this).find('input').val());
							}
						}else{
							_target.push($(this).data('val'));
						}
					}
				})
				if(!_next){
					return;
				}
				if(_target.length == 0){
					alert('至少添加一个接收号码！');
					return;
				}
				_target = _target.join(',');
				
				$.ajax({
					url: '../config/updateSysConfig.do',
					type: 'post',
					data: {
						type: 4,
						priority: 1,
						url: _url,
						user: _user,
						passwd: _passwd,
						target: _target
					},
					success: function(data) {
						swal($.i18n.prop('updateSuccess'), '', 'success');
						getConfig(4);
					},
					error : function() {
						// 出错提示
						swal("Error", 'System error!', "error");
					}
				});
			}else if(_type == 5){
				var _thisCon = $(this).parents('.configList');
				var _url = _thisCon.find('.textarea').val();
				var _target = [];
				
				var _next = true;
				_thisCon.find('.cell').each(function(){
					if(!$(this).hasClass('addCellLink')){
						if($(this).hasClass('cellAdd')){
							if($(this).find('input').val() != ''){
								if(!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test($(this).find('input').val())){
									if($(this).find('.errorTip').length == 0){
										$(this).addClass('has-error');
										$(this).append('<span class="errorTip">'+$.i18n.prop('emailError')+'</span>');
									}
									_next = false;
								}
								_target.push($(this).find('input').val());
							}
						}else{
							_target.push($(this).data('val'));
						}
					}
				})
				if(!_next){
					return;
				}
				_target = _target.join(';');
				
				$.ajax({
					url: '../config/updateSysConfig.do',
					type: 'post',
					data: {
						type: 5,
						priority: 1,
						url: _url,
						target: _target
					},
					success: function(data) {
						swal($.i18n.prop('updateSuccess'), '', 'success');
						getConfig(5);
					},
					error : function() {
						// 出错提示
						swal("Error", 'System error!', "error");
					}
				});
			}else{
				var _thisCon = $(this).parents('li');
				var _priority = _thisCon.data('priority');
				var _type = _thisCon.data('type');
				var _url = _thisCon.find('.textarea').val();
				
				var _ip = _thisCon.find('.urlIP').val();
				var _port = _thisCon.find('.urlPort').val();
				var _dbName = _thisCon.find('.urlDB').val();
				var _principal = _thisCon.find('.urlPrincipal').val();
				
				if(_type == 3){
					_ip = [];
					_port = [];
					
					$('#UrlList .urlList').each(function(){
						_ip.push($(this).find('.urlIP').val());
						_port.push($(this).find('.urlPort').val());
					})
					
					_ip = _ip.join(',');
					_port = _port.join(',');
				}
				
				if(_url == ''){
					swal("Error", 'url为必填项!', "error");
					return;
				}
				
				$.ajax({
					url: '../config/updateSysConfig.do',
					type: 'post',
					data: {
						type: _type,
						priority: _priority,
						url: _url,
						ip: _ip,
						port: _port,
						dbName: _dbName,
						principal: _principal
					},
					success: function(data) {
						swal($.i18n.prop('updateSuccess'), '', 'success');
						
						_thisCon.data('ip', _ip);
						_thisCon.data('port', _port);
						_thisCon.data('db', _dbName);
						_thisCon.data('principal', _principal);
						_thisCon.data('url', _url);
						
						_thisCon.find('.text').html(_url);
						_thisCon.find('.editCon').remove();
						_thisCon.find('.search-btn').remove();
					},
					error: function() {
						// 出错提示
						swal("Error", 'System error!', "error");
					}
				});
			}
		})
		
		
		$('.configItem').on('click', '.addConfig', function(){
			var _thisCon = $(this).parents('.configItem');
			var _type = $(this).data('type');
			
			_thisCon.find('.nullTip').addClass('hidden');
			
			if(_type == 4){
				$('#Config_4 .configList').html('<div class="configList">'
						+'<ul>'
						+'<li><div class="name">'+$.i18n.prop('userName')+'：</div>'
						+'<div class="text textS"><input type="text" class="form-control" value=""></div>'
						+'</li>'
						+'<li>'
						+'<div class="name">'+$.i18n.prop('password')+'：</div>'
						+'<div class="text textS"><input type="text" class="form-control" value=""></div>'
						+'</li>'
						+'<li>'
						+'<div class="name">'+$.i18n.prop('link')+'：</div>'
						+'<div class="text"><textarea class="textarea"></textarea></div>'
						+'</li>'
						+'<li>'
						+'<div class="name">'+$.i18n.prop('phone')+'：</div>'
						+'<div class="text cellList editAble">'
						+'<div class="cell cellAdd">'
							+'<input type="text" class="form-control">'
						+'</div>'
						+'<div class="cell addCellLink">'
						+'<a href="javascript:;" class="addCell"><span class="glyphicon glyphicon-remove-circle"></span></a>'
						+'</div>'
						+'</div>'
						+'</li>'
						+'</ul>'
						+'<div class="search-btn"><input type="button" value="'+$.i18n.prop("save")+'" class="btn btn-primary save" data-type="4"><input type="reset" value="'+$.i18n.prop("cancel")+'" class="btn btn-default cancel" data-type="4"></div></div>')
				$(this).addClass('hidden');
			}else if(_type == 5){
				$('#Config_5 .configList').html('<div class="configList">'
						+'<ul>'
							+'<li>'
								+'<div class="name">'+$.i18n.prop('link')+'：</div>'
								+'<div class="text"><textarea class="textarea"></textarea></div>'
								+'<div class="opts hidden">'
								+'<a href="javascript:;" class="edit" data-type="4" data-priority="1"><span class="glyphicon glyphicon-edit"></span></a>'
								+'<a href="javascript:;" class="del" data-type="4" data-priority="1"><span class="glyphicon glyphicon-trash"></span></a>'
								+'</div>'
							+'</li>'
							+'<li>'
								+'<div class="name">'+$.i18n.prop('email')+'：</div>'
								+'<div class="text cellList editAble">'
									+'<div class="cell cellAdd">'
										+'<input type="text" class="form-control">'
									+'</div>'
									+'<div class="cell addCellLink">'
										+'<a href="javascript:;" class="addCell"><span class="glyphicon glyphicon-remove-circle"></span></a>'
									+'</div>'
								+'</div>'
							+'</li>'
						+'</ul>'
						+'<div class="search-btn"><input type="button" value="'+$.i18n.prop("save")+'" class="btn btn-primary save" data-type="5"><input type="reset" value="'+$.i18n.prop("cancel")+'" class="btn btn-default cancel" data-type="5"></div></div>')
				$(this).addClass('hidden');
			}else{
				if(_thisCon.find('.configList li.addNew').length > 0){
					return;
				}
				
				var _size = _thisCon.find('.configList li').length + 1;
				
				if(_type == 3 && _size > 1){
					swal($.i18n.prop('addMax1'), '', 'warning');
					return;
				}
				if(_size > 6){
					swal($.i18n.prop('addMax5'), '', 'warning');
					return;
				}
				
				_thisCon.find('.configList').removeClass('hidden');
				
				if(_type == 1 || _type == 2){
					_thisCon.find('.configList ul').append('<li class="addNew addNewM" data-type="'+_type+'" data-priority="'+(_size+1)+'">'
							+'<div class="urlList">'
								+'<div class="name">IP：</div>'
								+'<div class="text"><input type="text" class="form-control urlIP"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">端口：</div>'
								+'<div class="text"><input type="text" class="form-control urlPort"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">数据库名：</div>'
								+'<div class="text"><input type="text" class="form-control urlDB"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">principal：</div>'
								+'<div class="text"><input type="text" class="form-control urlPrincipal"></div>'
							+'</div>'
							+'<div class="urlList">'
								+'<div class="name">url：</div>'
								+'<div class="text"><textarea class="textarea urlCon"></textarea></div>'
							+'</div>'
							+'<div class="search-btn">'
							+'<input type="button" value="'+$.i18n.prop("save")+'" class="btn btn-primary save">'
							+'<input type="reset" value="'+$.i18n.prop("cancel")+'" class="btn btn-default cancel">'
							+'</div>'
							+'</li>');
				}else{
					_thisCon.find('.configList ul').append('<li class="addNew addNewM" data-type="'+_type+'" data-priority="'+(_size+1)+'">'
							+'<div id="UrlList">'
								+'<div class="urlList">'
									+'<div class="name">连接：</div>'
									+'<div class="text">'
										+'<input type="text" class="form-control urlIP" placeholder="IP" style="width: 180px;">'
										+'<input type="text" class="form-control urlPort" placeholder="端口" style="width: 100px; margin: 0 20px 0 15px;">'
										+'<a href="javascript:;" class="btn btn-default btn-sm urlAdd">添加连接</a>'
									+'</div>'
								+'</div>'
							+'</div>'
							
							+'<div class="urlList">'
								+'<div class="name">url：</div>'
								+'<div class="text"><textarea class="textarea urlCon"></textarea></div>'
							+'</div>'
							+'<div class="search-btn">'
							+'<input type="button" value="'+$.i18n.prop("save")+'" class="btn btn-primary save">'
							+'<input type="reset" value="'+$.i18n.prop("cancel")+'" class="btn btn-default cancel">'
							+'</div>'
							+'</li>');
				}
				
				$('.urlList input').keyup(function(){
					setUrl($(this));
				})
			}
		})
		
		$('.configItem').on('click', '.urlAdd', function(){
			$('#UrlList').append('<div class="urlList">'
				+'<div class="name">连接：</div>'
				+'<div class="text">'
					+'<input type="text" class="form-control urlIP" placeholder="IP" style="width: 180px;">'
					+'<input type="text" class="form-control urlPort" placeholder="端口" style="width: 100px; margin: 0 20px 0 15px;">'
					+'<a href="javascript:;" class="btn btn-default btn-sm urlAdd">添加连接</a>'
				+'</div>'
			+'</div>');
			
			$('.urlList input').keyup(function(){
				setUrl($(this));
			})
			$(this).remove();
		})
		
		
		function setUrl(_self){
			var _url = '';
			
			var _addCon = _self.parents('li');
			var _type = _addCon.data('type');
			
			if(_type == 1 || _type == 2){
				var _ip = _addCon.find('.urlIP').val(),
					_port = _addCon.find('.urlPort').val(),
					_db = _addCon.find('.urlDB').val(),
					_principal = _addCon.find('.urlPrincipal').val()
				if(_ip != ''){
					_url = 'jdbc:hive2://'+_ip+':'+_port+'/'+_db+';'
					if(_principal != ''){
						_url += 'principal='+ _principal +';hive.server2.proxy.user='
					}
						
					_addCon.find('.urlCon').val(_url)
				}
			}else{
				$('#UrlList .urlList').each(function(){
					var _ip = $(this).find('.urlIP').val(),
						_port = $(this).find('.urlPort').val();
					if(_ip != ''){
						_url += _ip+':'+_port+';'
					}
				})
				_addCon.find('.urlCon').val(_url)
			}
		}
		
		
		$('.configItem').on('click', '.cancel', function(){
			if($(this).data('type') != undefined){
				$('#Config_' + $(this).data('type')).find('.addConfig').removeClass('hidden');
				$('#Config_' + $(this).data('type')).find('.nullTip').removeClass('hidden');
				$('#Config_' + $(this).data('type')).find('.configList').html('');
			}else{
				var _thisConfigItem = $(this).parents('.configItem');
				var _thisCon = $(this).parents('li');
				
				_thisCon.remove();
				
				if(_thisConfigItem.find('.configList li').length == 0){
					_thisConfigItem.find('.nullTip').removeClass('hidden');
					_thisConfigItem.find('.configList').addClass('hidden');
				}
			}
		})
		
		$('.configItem').on('click', '.save', function(){
			var _type = $(this).data('type');
			if(_type == 4){
				var _thisCon = $(this).parents('.configList');
				var _user = _thisCon.find('input').eq(0).val();
				var _passwd = _thisCon.find('input').eq(1).val();
				var _url = _thisCon.find('.textarea').val();
				var _target = [];
				
				if(_user == ''){
					alert('用户名不能为空！');
					return;
				}
				if(_passwd == ''){
					alert('密码不能为空！');
					return;					
				}
				if(_url == ''){
					alert('链接不能为空！');
					return;					
				}
				
				var _next = true;
				_thisCon.find('.cell').each(function(){
					if(!$(this).hasClass('addCellLink')){
						if($(this).hasClass('cellAdd')){
							if($(this).find('input').val() != ''){
								if($(this).find('input').val() == 0){
									if($(this).find('.errorTip').length == 0){
										$(this).addClass('has-error');
										$(this).append('<span class="errorTip">不能为空！</span>');
									}
									_next = false;
								}
								if(!/^0?1[3|4|5|8|7][0-9]\d{8}$/.test($(this).find('input').val())){
									if($(this).find('.errorTip').length == 0){
										$(this).addClass('has-error');
										$(this).append('<span class="errorTip">'+$.i18n.prop('phoneError')+'</span>');
									}
									_next = false;
								}
								_target.push($(this).find('input').val());
							}
						}else{
							_target.push($(this).data('val'));
						}
					}
				})
				if(!_next){
					return;
				}
				if(_target.length == 0){
					alert('至少添加一个接收号码！');
					return;
				}
				_target = _target.join(',');
				
				
				
				$.ajax({
					url: '../config/addSysConfig.do',
					type: 'post',
					data: {
						type: 4,
						url: _url,
						user: _user,
						passwd: _passwd,
						target: _target
					},
					success: function(data) {
						swal($.i18n.prop('addSuccess'), '', 'success');
						getConfig(4);
					},
					error : function() {
						// 出错提示
						swal("Error", 'System error!', "error");
					}
				});
			}else if(_type == 5){
				var _thisCon = $(this).parents('.configList');
				var _url = _thisCon.find('.textarea').val();
				var _target = [];
				
				var _next = true;
				_thisCon.find('.cell').each(function(){
					if(!$(this).hasClass('addCellLink')){
						if($(this).hasClass('cellAdd')){
							if($(this).find('input').val() != ''){
								if(!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test($(this).find('input').val())){
									if($(this).find('.errorTip').length == 0){
										$(this).addClass('has-error');
										$(this).append('<span class="errorTip">'+$.i18n.prop('emailError')+'</span>');
									}
									_next = false;
								}
								_target.push($(this).find('input').val());
							}
						}else{
							_target.push($(this).data('val'));
						}
					}
				})
				if(!_next){
					return;
				}
				_target = _target.join(';');
				
				$.ajax({
					url: '../config/addSysConfig.do',
					type: 'post',
					data: {
						type: 5,
						url: _url,
						target: _target
					},
					success: function(data) {
						swal($.i18n.prop('addSuccess'), '', 'success');
						getConfig(5);
					},
					error : function() {
						// 出错提示
						swal("Error", 'System error!', "error");
					}
				});
			}else{
				var _thisCon = $(this).parents('li');
				var _priority = _thisCon.data('priority');
				var _type = _thisCon.data('type');
				var _url = _thisCon.find('.textarea').val();
				var _ip = _thisCon.find('.urlIP').val();
				var _port = _thisCon.find('.urlPort').val();
				var _dbName = _thisCon.find('.urlDB').val();
				var _principal = _thisCon.find('.urlPrincipal').val();
				
				if(_type == 3){
					_ip = [];
					_port = [];
					
					$('#UrlList .urlList').each(function(){
						_ip.push($(this).find('.urlIP').val());
						_port.push($(this).find('.urlPort').val());
					})
					
					_ip = _ip.join(',');
					_port = _port.join(',');
				}
				
				if(_url == ''){
					swal("Error", 'url为必填项!', "error");
					return;
				}
				
				$.ajax({
					url: '../config/addSysConfig.do',
					type: 'post',
					data: {
						type: _type,
						priority: _priority,
						url: _url,
						ip: _ip,
						port: _port,
						dbName: _dbName,
						principal: _principal
					},
					success: function(data) {
						swal($.i18n.prop('addSuccess'), '', 'success');
						getConfig(_type);
					},
					error : function() {
						// 出错提示
						swal("Error", 'System error!', "error");
					}
				});
			}
		})
		
		$('.configItem').on('click', '.addLink', function(){
			$(this).parents('.configItem').find('.addConfig').click();
		})
		
		$('.configItem').on('click', '.delCell', function(){
			$(this).parent().remove();
		})
		
		$('.configItem').on('click', '.addCell', function(){
			if($(this).parents('.cellList').find('.cell').length == 11){
				swal($.i18n.prop('addMax10'), '', 'warning');
				return;
			}
			$('<div class="cell cellAdd"><input type="text" class="form-control"></div>').insertBefore($(this).parent());
			
//			var _thisCon = $(this).parents('.configList ul');
//			if(_thisCon.find('.addLi').length == 0){
//				_thisCon.append('<li class="addLi"><div class="name"></div><div class="text addCellCon"><div><input type="text"></div></div>')
//			}else{
//				_thisCon.find('.addCellCon').append('<div><input type="text"></div>')
//			}
		})
		
		$('.configItem').on('keyup', '.form-control', function(){
  		   $(this).parent().removeClass('has-error');
  		   $(this).parent().find('.errorTip').remove();
		})
		
		$('.configItem').on('click', '.passwdEye', function(){
  		   $(this).parent().html($(this).parent().data('val'));
		})
		
		
		$('.editEvnConfig').click(function(){
			var _config = $(this).parents('.configItem');
			if(!_config.find('.search-btn').hasClass('hidden')){
				return;
			}
			
			_config.find('li').each(function(){
				var _dis = $(this).data('dis');
				var _val = $(this).find('.text').html();
				_val = _val == '--' ? '' : _val;
				if(_dis == 'sel'){
					var _opts = $(this).data('opts').split(',');
					var _html = '<select class="form-control" data-old="'+_val+'">';
					$.each(_opts, function(k, v){
						_html += '<option value="'+v+'">'+v+'</option>'
					})
					_html += '</select>';
					
					$(this).find('.text').html(_html);
					$(this).find('.form-control').val(_val);
				}else if(_dis == 'textarea'){
					$(this).find('.text').html('<textarea class="form-control textarea" data-old="'+_val+'">'+_val+'</textarea>');
				}else{
					$(this).find('.text').html('<input type="text" class="form-control" value="'+_val+'" data-old="'+_val+'">');
				}
			})
			_config.find('.search-btn').removeClass('hidden');
		})
		
		$('.configItem').on('click', '.cancelEvnEdit', function(){
			var _config = $(this).parents('.configItem');
			
			_config.find('li').each(function(){
				var _val = $(this).find('.form-control').data('old');
				_val = _val == '' ? '--' : _val;
				$(this).find('.text').html(_val);
			})
			_config.find('.search-btn').addClass('hidden');
		})
		
		$('.configItem').on('click', '.saveEvnEdit', function(){
			var _config = $(this).parents('.configItem');
			var _data = {};
			_config.find('li').each(function(){
				_data[$(this).data('type')] = $(this).find('.form-control').val();
			})
			
			$.ajax({
				url: '../config/addSysMap.do',
				type: 'post',
				data: {'keys': JSON.stringify(_data)},
				success: function(data) {
					swal($.i18n.prop('updateSuccess'), '', 'success');
					
					_config.find('li').each(function(){
						var _val = $(this).find('.form-control').val();
						_val = _val == '' ? '--' : _val;
						$(this).find('.text').html(_val);
					})
					_config.find('.search-btn').addClass('hidden');
				},
				error : function() {
					// 出错提示
					swal("Error", 'System error!', "error");
				}
			});
		})
	}
	
	
	getConfig();
	getEnvConfig();
	bindEvent();
	
})