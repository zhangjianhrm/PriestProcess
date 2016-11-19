
/*
 *String Prototype Function
*/
(function(){String.prototype.isEmpty=function(){if(this==undefined||this==""||this==null){return true}return false};String.prototype.isNotEmpty=function(){return !this.isEmpty()};String.prototype.isBlank=function(){if(this==undefined||this==""||this==null||/^\s*$/.test(this)){return true}return false};String.prototype.isNotBlank=function(){return !this.isBlank()};String.prototype.trim=function(){if(this.isEmpty()){return this}return this.replace(/(^\s*)|(\s*$)/g,"")};String.prototype.charLength=function(){var a=this.replace(/[^x00-xff]/mg,"JJ");return a.length};String.prototype.include=function(a){return this.indexOf(a)>-1};String.prototype.startsWith=function(a){return this.indexOf(a)===0};String.prototype.endsWith=function(b){var a=this.length-b.length;return a>=0&&this.lastIndexOf(b)===a}})();
/*
 * AFMS Util Class   2010-12-30
 */
var AFMS=AFMS||{};AFMS.Util={toInt:function(a){return parseInt(a,10)||0},isObject:function(a){return a&&typeof a=="object"},isElement:function(a){return !!(a&&a.nodeType==1)},isArray:function(a){return a!=null&&typeof a=="object"&&"splice" in a&&"join" in a},isFunction:function(a){return typeof a=="function"},isString:function(a){return typeof a=="string"},isNumber:function(a){return typeof a=="number"},isDate:function(a){return a&&typeof a.getFullYear=="function"},isBoolean:function(a){return typeof a=="boolean"},isUndefined:function(a){return typeof a=="undefined"},argToArr:function(b){if(!b){return[]}if(b.toArray){return b.toArray()}var a=b.length||0,c=new Array(a);while(a--){c[a]=b[a]}return c}};(function(){var r=navigator.userAgent.toLowerCase(),w=function(e){return e.test(r)},z=document,k=z.compatMode=="CSS1Compat",y=w(/opera/),g=w(/chrome/),s=w(/webkit/),v=!g&&w(/safari/),d=v&&w(/applewebkit\/4/),b=v&&w(/version\/3/),A=v&&w(/version\/4/),q=!y&&w(/msie/),o=q&&w(/msie 7/),n=q&&w(/msie 8/),p=q&&!o&&!n,m=!s&&w(/gecko/),f=m&&w(/rv:1\.8/),a=m&&w(/rv:1\.9/),t=q&&!k,x=w(/windows|win32/),j=w(/macintosh|mac os x/),h=w(/adobeair/),l=w(/linux/),c=/^https/i.test(window.location.protocol),i=function(){if($.browser.msie){return document.compatMode=="CSS1Compat"?document.documentElement.clientHeight:document.body.clientHeight}else{return self.innerHeight}};if(p){try{z.execCommand("BackgroundImageCache",false,true)}catch(u){}}jQuery.extend(AFMS.Util,{iframeSrc:c?"javascript:false":"about:blank",isStrict:k,isSecure:c,isOpera:y,isWebKit:s,isChrome:g,isSafari:v,isSafari3:b,isSafari4:A,isSafari2:d,isIE:q,isIE6:p,isIE7:o,isIE8:n,isGecko:m,isGecko2:f,isGecko3:a,isBorderBox:t,isLinux:l,isWindows:x,isMac:j,isAir:h,removeNode:q?function(){var e;return function(B){if(B&&B.tagName!="BODY"){e=e||z.createElement("div");e.appendChild(B);e.innerHTML=""}}}():function(e){if(e&&e.parentNode&&e.tagName!="BODY"){e.parentNode.removeChild(e)}},getDocScrollLeft:function(){return z.documentElement.scrollLeft||z.body.scrollLeft},getDocScrollTop:function(){return z.documentElement.scrollTop||z.body.scrollTop},getViewportHeight:function(){return k?z.documentElement.clientHeight:z.body.clientHeight},getViewportWidth:function(){return k?z.documentElement.clientWidth:z.body.clientWidth},getDocHeight:function(){return Math.max(k?z.documentElement.scrollHeight:z.body.scrollHeight,this.getViewportHeight())},getDocWidth:function(){return Math.max(k?z.documentElement.scrollWidth:z.body.scrollWidth,this.getViewportWidth())},clearSelection:function(){try{window.getSelection?window.getSelection().removeAllRanges():z.selection.empty()}catch(B){}},bdAutoHeight:function(){if(!q){return}}})})();AFMS.IdCard={area:{11:"\u5317\u4eac",12:"\u5929\u6d25",13:"\u6cb3\u5317",14:"\u5c71\u897f",15:"\u5185\u8499\u53e4",21:"\u8fbd\u5b81",22:"\u5409\u6797",23:"\u9ed1\u9f99\u6c5f",31:"\u4e0a\u6d77",32:"\u6c5f\u82cf",33:"\u6d59\u6c5f",34:"\u5b89\u5fbd",35:"\u798f\u5efa",36:"\u6c5f\u897f",37:"\u5c71\u4e1c",41:"\u6cb3\u5357",42:"\u6e56\u5317",43:"\u6e56\u5357",44:"\u5e7f\u4e1c",45:"\u5e7f\u897f",46:"\u6d77\u5357",50:"\u91cd\u5e86",51:"\u56db\u5ddd",52:"\u8d35\u5dde",53:"\u4e91\u5357",54:"\u897f\u85cf",61:"\u9655\u897f",62:"\u7518\u8083",63:"\u9752\u6d77",64:"\u5b81\u590f",65:"\u65b0\u7586",71:"\u53f0\u6e7e",81:"\u9999\u6e2f",82:"\u6fb3\u95e8",91:"\u56fd\u5916"},checkCard:function(a){if(a==undefined||a==""||a==null||/^\s*$/.test(a)){return false}if(this.isCardNo(a)===false){return false}if(this.checkProvince(a)===false){return false}if(this.checkBirthday(a)===false){return false}if(this.checkParity(a)===false){return false}return true},isCardNo:function(a){var b=/(^\d{15}$)|(^\d{17}(\d|X|x)$)/;if(b.test(a)===false){return false}return true},checkProvince:function(b){var a=b.substr(0,2);if(this.area[a]==undefined){return false}return true},checkBirthday:function(a){var b=this.getBirthday(a);return this.verifyBirthday(b[0],b[1],b[2],new Date(b.join("/")))},verifyBirthday:function(d,g,a,e){var b=new Date();var c=b.getFullYear();if(e.getFullYear()==d&&(e.getMonth()+1)==g&&e.getDate()==a){var f=c-d;if(f>=3&&f<=100){return true}return false}return false},checkParity:function(e){e=this.changeFivteenToEighteen(e);var b=e.length;if(b=="18"){var d=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);var a=new Array("1","0","X","9","8","7","6","5","4","3","2");var g=0,f,c;for(f=0;f<17;f++){g+=e.substr(f,1)*d[f]}c=a[g%11];if(c==e.substr(17,1).toUpperCase()){return true}return false}return false},changeFivteenToEighteen:function(c){if(c.length=="15"){var b=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);var a=new Array("1","0","X","9","8","7","6","5","4","3","2");var e=0,d;c=c.substr(0,6)+"19"+c.substr(6,c.length-6);for(d=0;d<17;d++){e+=c.substr(d,1)*b[d]}c+=a[e%11];return c}return c},getBirthday:function(e){var a=e.length;if(a=="15"){var f=/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;var d=e.match(f);var g=d[2];var h=d[3];var c=d[4];return["19"+g,h,c]}if(a=="18"){var b=/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/;var d=e.match(b);var g=d[2];var h=d[3];var c=d[4];return[g,h,c]}return false}};AFMS.Class={create:function(){var f=null,c=AFMS.Util.argToArr(arguments);if(typeof c[0]=="function"){f=c.shift()}var b=function(){this.init.apply(this,arguments)};b.superclass=f;if(f){var e=function(){};e.prototype=f.prototype;b.prototype=new e()}for(var d=0,a=c.length;d<a;d++){jQuery.extend(b.prototype,c[d])}if(!b.prototype.init){b.prototype.init=function(){}}b.prototype.constructor=b;return b}};AFMS.DateUtil={getDiffMonths:function(c,j){var g=0;var d=j;if(c.getTime()>j.getTime()){d=c;c=j}var f=d.getFullYear();var i=d.getMonth()+1;var b=d.getDate();var e=c.getFullYear();var h=c.getMonth()+1;var a=c.getDate();g+=(f*12+i)-(e*12+h);if(b<=a){g-=1}return g},isLeapYear:function(a){return((a%4==0&&a%100!=0)||(a%400==0))?true:false},getDays:function(a,b){switch(b){case 1:case 3:case 5:case 7:case 8:case 10:case 12:days=31;break;case 4:case 6:case 9:case 11:days=30;break;case 2:if(isLeapYear(a)){days=29}else{days=28}break}return days},toDate:function(c){if(!/^\d{4}\-\d\d?\-\d\d?$/.test(c)){return null}var a=c.replace(/\-0/g,"-").split("-");a=[AFMS.Util.toInt(a[0]),AFMS.Util.toInt(a[1])-1,AFMS.Util.toInt(a[2])];var b=new Date(a[0],a[1],a[2]);if(b.getFullYear()!=a[0]||b.getMonth()!=a[1]||b.getDate()!=a[2]){return null}return b},toTime:function(c){if(!/^\d{4}\-\d\d?\-\d\d? \d{2}[:]\d{2}$/.test(c)){return null}var a=c.replace(/\-0/g,"/");var b=new Date(a);return b}};AFMS.timer=function(h){var a=h||{},d=a.time||60,c=a.interval||1,f=a.delay,k=a.startFn,g=a.intervalFn,b=a.endFn,j=a.scope||window,i=d;var e=function(){if(i==d){if(k){k.apply(j,[])}}if(i<=0){if(b){b.apply(j,[])}i=d}else{setTimeout(e,c*1000);if(g){g.apply(j,[i,d-i]);i=i-c}}};if(f){setTimeout(e,f)}else{e()}};AFMS.Loading=function(b,a){var a=jQuery.extend({border:"none",padding:"15px",width:"160px",marginLeft:"-80px",textAlign:"center",top:"50%",backgroundColor:"#000","-webkit-border-radius":"10px","-moz-border-radius":"10px",opacity:0.5,color:"#fff"},a);var b=b||"Please wait...";jQuery.blockUI({css:a})};
/* Simple JavaScript Templating
/* John Resig - http://ejohn.org/ - MIT Licensed
*/
(function(){var b={};this.tmpl=function a(e,d){var c=!/\W/.test(e)?b[e]=b[e]||a(document.getElementById(e).innerHTML):new Function("obj","var p=[],print=function(){p.push.apply(p,arguments);};with(obj){p.push('"+e.replace(/[\r\t\n]/g," ").split("<%").join("\t").replace(/((^|%>)[^\t]*)'/g,"$1\r").replace(/\t=(.*?)%>/g,"',$1,'").split("\t").join("');").split("%>").join("p.push('").split("\r").join("\\'")+"');}return p.join('');");return d?c(d):c}})();
/* 
 * Show page   2010-12-30
 */
(function(a){jQuery.fn.extend({showPage:function(e){e=jQuery.extend({page:1,rowsCount:0,rowNum:10,showViewNum:true,rowList:[10,20,30],mode:"Max",callback:function(){}},e);var c=jQuery(this);c.addClass("pagebar");var d=e.rowsCount/e.rowNum;if(isNaN(parseInt(e.page))){e.page=1}if(isNaN(parseInt(d))){d=1}if(e.page<1){e.page=1}if(d<1){d=1}if(e.page>d){e.page=d}e.page=Math.ceil(e.page);d=Math.ceil(d);var m="",g=e.page-1,k=e.page+1;if(!!e.showViewNum){m+='<div class="sizer"><span class="explain">\u6bcf\u9875\u663e\u793a\u6570\u91cf</span>';jQuery.each(e.rowList,function(n){m+='<a href="#" data:view="'+e.rowList[n]+'">'+e.rowList[n]+"</a>"});m+="</div>"}if(e.mode=="Max"){m+='<div class="pager"><span class="explain">\u5171'+e.rowsCount+"\u6761\u8bb0\u5f55</span>"}else{if(e.mode=="Simple"){m+='<div class="pager"><span class="explain">'+e.page+"/"+d+"\u9875</span>"}}if(g<1){m+='<a href="#" title="\u5df2\u662f\u6700\u524d\u4e00\u9875" data:page="0" class="page-prev page-prev-disabled">\u5df2\u662f\u6700\u524d\u4e00\u9875</a>'}else{m+='<a href="#" title="\u4e0a\u4e00\u9875" data:page="'+g+'" class="page-prev">\u4e0a\u4e00\u9875</a>'}if(e.mode=="Max"){if(e.page==1){m+='<a href="#" title="\u7b2c 1 \u9875" data:page="1" class="active"><span>1</span></a>'}else{m+='<a href="#" title="\u7b2c 1 \u9875" data:page="1"><span>1</span></a>'}if(e.page>3){var j=e.page-3}else{var j=1}if(j>(d-6)&&(d-6)>0){var j=(d-6)}if(j>1){m+='<span class="page-break">...</span>'}for(var f=j+1;f<j+6;f++){if(f>=d){break}if(f==e.page){m+='<a href="#" title="\u7b2c '+f+' \u9875" data:page="'+f+'" class="active"><span>'+f+"</span></a>"}else{m+='<a href="#" title="\u7b2c '+f+' \u9875" data:page="'+f+'"><span>'+f+"</span></a>"}}if(d>j+6){m+='<span class="page-break">...</span>'}if(d>1){if(e.page==d){m+='<a href="#" title="\u7b2c '+d+' \u9875" data:page="0" class="active"><span> '+d+" </span></a>"}else{m+='<a href="#" title="\u7b2c '+d+' \u9875" data:page="'+d+'"><span> '+d+" </span></a>"}}}else{if(e.mode=="Simple"){m+='<a href="#" title="\u7b2c '+e.page+' \u9875" data:page="'+e.page+'" class="active"><span>'+e.page+"</span></a>"}}if(k>d){m+='<a href="#" title="\u5df2\u662f\u6700\u540e\u4e00\u9875" data:page="0" class="page-next page-next-disabled">\u5df2\u662f\u6700\u540e\u4e00\u9875</a>'}else{m+='<a href="#" title="\u4e0b\u4e00\u9875" data:page="'+k+'" class="page-next">\u4e0b\u4e00\u9875</a>'}if(e.mode=="Max"){m+='<span class="explain">\u5230\u7b2c</span> <input type="text" id="page" class="pagenum" maxlength="4"/> <span class="explain">\u9875</span><a href="#" class="confirm-btn" ><span>\u786e\u5b9a</span></a>'}else{if(e.mode=="Simple"){}}m+="</div>";c.html(m);c.find(".pager a").bind("click",function(){if(!jQuery(this).hasClass("active")){e.callback(jQuery(this).attr("data:page"),e.rowNum)}return false});c.find(".pager a.confirm-btn").unbind().bind("click",function(){l(c.find(".pager .pagenum").val(),d,e.rowNum,e.callback);return false});c.find(".pager .pagenum").keypress(function(i){if(i.keyCode==13){l(jQuery(this).val(),d,e.rowNum,e.callback)}});if(!!e.showViewNum){var b=c.find(".sizer a");for(var f=0,h=b.length;f<h;f++){if(jQuery(b[f]).attr("data:view")==e.rowNum){jQuery(b[f]).addClass("active")}}c.find(".sizer a").bind("click",function(){if(!jQuery(this).hasClass("active")){rowNum=jQuery(this).attr("data:view");e.callback(e.page,rowNum)}return false})}function l(n,i,o,p){if(isNaN(parseInt(n))){n=1}if(isNaN(parseInt(i))){i=1}if(n<1){n=1}if(i<1){i=1}if(n>i){n=i}n=parseInt(n,10);p(n,o)}}})})(jQuery);
/*
/* floatDiv   2010-12-30
*/
(function(a){jQuery.fn.extend({floatDiv:function(e){e=jQuery.extend({RunTime:300,position:"RightBottom",offset:[100,100]},e||{});var f=jQuery(this);var d;b();f.css({position:"absolute",zIndex:999});function c(){if(AFMS.Util.isIE6){var g=jQuery(window).height(),h=jQuery(window).scrollTop(),i=f.height();f.fadeOut("0");switch(e.position){case"RightBottom":f.css({top:(h+g-i-e.offset[1]),right:e.offset[0]}).fadeIn("10");break;case"LeftBottom":f.css({top:(h+g-i-e.offset[1]),left:e.offset[0]}).fadeIn("10");break;case"LeftTop":f.css({top:(h+e.offset[1]),left:e.offset[0]}).fadeIn("10");break;case"RightTop":f.css({top:(h+e.offset[1]),right:e.offset[0]}).fadeIn("10");break;default:}}else{switch(e.position){case"RightBottom":f.fadeIn("10").css({position:"fixed",bottom:e.offset[1],display:"block",right:e.offset[0]});break;case"LeftBottom":f.fadeIn("10").css({position:"fixed",bottom:e.offset[1],display:"block",left:e.offset[0]});break;case"LeftTop":f.fadeIn("10").css({position:"fixed",top:e.offset[1],display:"block",left:e.offset[0]});break;case"RightTop":f.fadeIn("10").css({position:"fixed",top:e.offset[1],display:"block",right:e.offset[0]});break;default:}}}function b(){c();jQuery(window).scroll(function(){if(AFMS.Util.isIE6){f.fadeOut("0")}clearInterval(d);d=setTimeout(function(){c()},e.RunTime)})}}})})(jQuery);
/*
/* soChange   2010-12-30
*/
(function(a){jQuery.fn.extend({soChange:function(b){b=jQuery.extend({thumbObj:null,botPrev:null,botNext:null,thumbNowClass:"now",thumbOverEvent:true,slideTime:1000,autoChange:true,clickFalse:true,overStop:true,changeTime:5000,delayTime:300},b||{});var h=jQuery(this);var i;var k=h.size();var e=0;var g;var c;var f;function d(){if(e!=g){if(b.thumbObj!=null){jQuery(b.thumbObj).removeClass(b.thumbNowClass).eq(g).addClass(b.thumbNowClass)}if(b.slideTime<=0){h.eq(e).hide();h.eq(g).show()}else{h.eq(e).fadeOut(b.slideTime);h.eq(g).fadeIn(b.slideTime)}e=g;if(b.autoChange==true){clearInterval(c);c=setInterval(j,b.changeTime)}}}function j(){g=(e+1)%k;d()}h.hide().eq(0).show();if(b.thumbObj!=null){i=jQuery(b.thumbObj);i.removeClass(b.thumbNowClass).eq(0).addClass(b.thumbNowClass);i.click(function(){g=i.index(jQuery(this));d();if(b.clickFalse==true){return false}});if(b.thumbOverEvent==true){i.mouseenter(function(){g=i.index(jQuery(this));f=setTimeout(d,b.delayTime)});i.mouseleave(function(){clearTimeout(f)})}}if(b.botNext!=null){jQuery(b.botNext).click(function(){if(h.queue().length<1){j()}return false})}if(b.botPrev!=null){jQuery(b.botPrev).click(function(){if(h.queue().length<1){g=(e+k-1)%k;d()}return false})}if(b.autoChange==true){c=setInterval(j,b.changeTime);if(b.overStop==true){h.mouseenter(function(){clearInterval(c)});h.mouseleave(function(){c=setInterval(j,b.changeTime)})}}}})})(jQuery);(function(a){jQuery.fn.extend({tabs:function(h){h=jQuery.extend({thumbObj:null,eq:0,thumbNowClass:"current",ajaxOptions:null,callback:null},h||{});var b=jQuery(this);var f;var e=b.eq(h.eq).attr("href");var i=h.eq;var c;var d=new Date().getTime();function g(j){var k=/^(#)[a-zA-Z0-9_-]+$/;f.find(".J_TabErr").remove();f.find(".J_TabDiv_"+d+"_"+i).hide();if(k.test(href)){f.find(href).show().attr("class","J_TabDiv_"+d+"_"+c);e=href;i=c;h.callback&&h.callback(j)}else{if(f.find(".J_TabDiv_"+d+"_"+c).length>0){f.find(".J_TabDiv_"+d+"_"+c).show();h.callback&&h.callback(j)}else{jQuery.ajax(jQuery.extend({},h.ajaxOptions,{type:"GET",url:href,dataType:"html",success:function(l){var m=jQuery("<div></div>").html(l).attr("class","J_TabDiv_"+d+"_"+c);m.appendTo(h.thumbObj);h.callback&&h.callback(j)}}))}e=href;i=c}AFMS.Util.bdAutoHeight()}f=jQuery(h.thumbObj);c=i;href=e;g(b.eq(i));if(h.thumbObj!=null){b.parent().removeClass(h.thumbNowClass).eq(h.eq).addClass(h.thumbNowClass);b.click(function(){if(jQuery(this).attr("rel")!="open"){c=b.index(jQuery(this));if(i!=c){href=jQuery(this).attr("href");b.parent().removeClass(h.thumbNowClass);jQuery(this).parent().addClass(h.thumbNowClass);g()}return false}})}}})})(jQuery);
/*
 * jQuery blockUI plugin
 * Version 2.36 (16-NOV-2010)
 * @requires jQuery v1.2.3 or later
 *
 * Examples at: http://malsup.com/jquery/block/
 * Copyright (c) 2007-2008 M. Alsup
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * Thanks to Amir-Hossein Sobhi for some excellent contributions!
 */
(function(i){if(/1\.(0|1|2)\.(0|1|2)/.test(jQuery.fn.jquery)||/^1.1/.test(jQuery.fn.jquery)){alert("blockUI requires jQuery v1.2.3 or later!  You are using v"+jQuery.fn.jquery);return}jQuery.fn._fadeIn=jQuery.fn.fadeIn;var c=function(){};var j=document.documentMode||0;var e=jQuery.browser.msie&&((jQuery.browser.version<8&&!j)||j<8);var f=jQuery.browser.msie&&/MSIE 6.0/.test(navigator.userAgent)&&!j;jQuery.blockUI=function(p){d(window,p)};jQuery.unblockUI=function(p){h(window,p)};jQuery.growlUI=function(u,s,r,t,p){var q=jQuery('<div class="growlUI"></div>');if(r=="err"){q.addClass("growlUIerr")}if(u){q.append("<h1>"+u+"</h1>")}if(s){q.append("<h2>"+s+"</h2>")}if(t==undefined){t=3000}jQuery.blockUI({message:q,fadeIn:700,fadeOut:1000,centerY:false,timeout:t,showOverlay:false,onUnblock:p,css:jQuery.blockUI.defaults.growlCSS})};jQuery.fn.block=function(p){return this.unblock({fadeOut:0}).each(function(){if(jQuery.css(this,"position")=="static"){this.style.position="relative"}if(jQuery.browser.msie){this.style.zoom=1}d(this,p)})};jQuery.fn.unblock=function(p){return this.each(function(){h(this,p)})};jQuery.blockUI.version=2.35;jQuery.blockUI.defaults={message:"<h1>Please wait...</h1>",title:null,draggable:true,theme:false,css:{padding:0,margin:0,width:"600px",top:"10%",left:"50%",marginLeft:"-300px",textAlign:"left",color:"#333",border:"6px solid #767576",backgroundColor:"#fff","-moz-box-shadow":"3px 2px 6px #333","-webkit-box-shadow":"#333 2px 2px 6px"},themedCSS:{width:"30%",top:"40%",left:"35%"},overlayCSS:{backgroundColor:"#000",opacity:0.2,cursor:"wait"},growlCSS:{width:"350px",top:"10px",left:"",right:"10px",border:"none",padding:"5px",opacity:0.6,cursor:"default",color:"#fff",backgroundColor:"#000","-webkit-border-radius":"10px","-moz-border-radius":"10px","border-radius":"10px"},iframeSrc:/^https/i.test(window.location.href||"")?"javascript:false":"about:blank",forceIframe:false,baseZ:1000,centerX:true,centerY:true,allowBodyStretch:true,bindEvents:true,constrainTabKey:true,fadeIn:200,fadeOut:400,timeout:0,showOverlay:true,focusInput:true,applyPlatformOpacityRules:true,onBlock:null,onUnblock:null,quirksmodeOffsetHack:4,blockMsgClass:"blockMsg"};var b=null;var g=[];function d(r,F){var A=(r==window);var w=F&&F.message!==undefined?F.message:undefined;F=jQuery.extend({},jQuery.blockUI.defaults,F||{});F.overlayCSS=jQuery.extend({},jQuery.blockUI.defaults.overlayCSS,F.overlayCSS||{});var C=jQuery.extend({},jQuery.blockUI.defaults.css,F.css||{});var N=jQuery.extend({},jQuery.blockUI.defaults.themedCSS,F.themedCSS||{});w=w===undefined?F.message:w;if(A&&b){h(window,{fadeOut:0})}if(w&&typeof w!="string"&&(w.parentNode||w.jquery)){var I=w.jquery?w[0]:w;var P={};jQuery(r).data("blockUI.history",P);P.el=I;P.parent=I.parentNode;P.display=I.style.display;P.position=I.style.position;if(P.parent){P.parent.removeChild(I)}}var B=F.baseZ;var M=(jQuery.browser.msie||F.forceIframe)?jQuery('<iframe class="blockUI" style="z-index:'+(B++)+';display:none;border:none;margin:0;padding:0;position:absolute;width:100%;height:100%;top:0;left:0" src="'+F.iframeSrc+'"></iframe>'):jQuery('<div class="blockUI" style="display:none"></div>');var L=jQuery('<div class="blockUI blockOverlay" style="z-index:'+(B++)+';display:none;border:none;margin:0;padding:0;width:100%;height:100%;top:0;left:0"></div>');var K,G;if(F.theme&&A){G='<div class="blockUI '+F.blockMsgClass+' blockPage ui-dialog ui-widget ui-corner-all" style="z-index:'+B+';display:none;position:fixed"><div class="ui-widget-header ui-dialog-titlebar ui-corner-all blockTitle">'+(F.title||"&nbsp;")+'</div><div class="ui-widget-content ui-dialog-content"></div></div>'}else{if(F.theme){G='<div class="blockUI '+F.blockMsgClass+' blockElement ui-dialog ui-widget ui-corner-all" style="z-index:'+B+';display:none;position:absolute"><div class="ui-widget-header ui-dialog-titlebar ui-corner-all blockTitle">'+(F.title||"&nbsp;")+'</div><div class="ui-widget-content ui-dialog-content"></div></div>'}else{if(A){G='<div class="blockUI '+F.blockMsgClass+' blockPage" style="z-index:'+B+';display:none;position:fixed"></div>'}else{G='<div class="blockUI '+F.blockMsgClass+' blockElement" style="z-index:'+B+';display:none;position:absolute"></div>'}}}K=jQuery(G);if(w){if(F.theme){K.css(N);K.addClass("ui-widget-content")}else{K.css(C)}}if(!F.applyPlatformOpacityRules||!(jQuery.browser.mozilla&&/Linux/.test(navigator.platform))){L.css(F.overlayCSS)}L.css("position",A?"fixed":"absolute");if(jQuery.browser.msie||F.forceIframe){M.css("opacity",0)}var y=[M,L,K],O=A?jQuery("body"):jQuery(r);jQuery.each(y,function(){this.appendTo(O)});if(F.theme&&F.draggable&&jQuery.fn.draggable){K.draggable({handle:".ui-dialog-titlebar",cancel:"li"})}var v=e&&(!jQuery.boxModel||jQuery("object,embed",A?null:r).length>0);if(f||v){if(A&&F.allowBodyStretch&&jQuery.boxModel){jQuery("html,body").css("height","100%")}if((f||!jQuery.boxModel)&&!A){var E=m(r,"borderTopWidth"),J=m(r,"borderLeftWidth");var x=E?"(0 - "+E+")":0;var D=J?"(0 - "+J+")":0}jQuery.each([M,L,K],function(t,S){var z=S[0].style;z.position="absolute";if(t<2){A?z.setExpression("height","Math.max(document.body.scrollHeight, document.body.offsetHeight) - (jQuery.boxModel?0:"+F.quirksmodeOffsetHack+') + "px"'):z.setExpression("height",'this.parentNode.offsetHeight + "px"');A?z.setExpression("width",'jQuery.boxModel && document.documentElement.clientWidth || document.body.clientWidth + "px"'):z.setExpression("width",'this.parentNode.offsetWidth + "px"');if(D){z.setExpression("left",D)}if(x){z.setExpression("top",x)}}else{if(F.centerY){if(A){z.setExpression("top",'(document.documentElement.clientHeight || document.body.clientHeight) / 2 - (this.offsetHeight / 2) + (blah = document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + "px"')}z.marginTop=0}else{if(!F.centerY&&A){var Q=(F.css&&F.css.top)?parseInt(F.css.top):0;var R="((document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + "+Q+') + "px"';z.setExpression("top",R)}}}})}if(w){if(F.theme){K.find(".ui-widget-content").append(w)}else{K.append(w)}if(w.jquery||w.nodeType){jQuery(w).show()}}if((jQuery.browser.msie||F.forceIframe)&&F.showOverlay){M.show()}if(F.fadeIn){var H=F.onBlock?F.onBlock:c;var q=(F.showOverlay&&!w)?H:c;var p=w?H:c;if(F.showOverlay){L._fadeIn(F.fadeIn,q)}if(w){K._fadeIn(F.fadeIn,p)}}else{if(F.showOverlay){L.show()}if(w){K.show()}if(F.onBlock){F.onBlock()}}l(1,r,F);if(A){b=K[0];g=jQuery(":input:enabled:visible",b);if(F.focusInput){setTimeout(o,20)}}else{a(K[0],F.centerX,F.centerY)}if(F.timeout){var u=setTimeout(function(){A?jQuery.unblockUI(F):jQuery(r).unblock(F)},F.timeout);jQuery(r).data("blockUI.timeout",u)}}function h(s,t){var r=(s==window);var q=jQuery(s);var u=q.data("blockUI.history");var v=q.data("blockUI.timeout");if(v){clearTimeout(v);q.removeData("blockUI.timeout")}t=jQuery.extend({},jQuery.blockUI.defaults,t||{});l(0,s,t);var p;if(r){p=jQuery("body").children().filter(".blockUI").add("body > .blockUI")}else{p=jQuery(".blockUI",s)}if(r){b=g=null}if(t.fadeOut){p.fadeOut(t.fadeOut);setTimeout(function(){k(p,u,t,s)},t.fadeOut)}else{k(p,u,t,s)}}function k(p,s,r,q){p.each(function(t,u){if(this.parentNode){this.parentNode.removeChild(this)}});if(s&&s.el){s.el.style.display=s.display;s.el.style.position=s.position;if(s.parent){s.parent.appendChild(s.el)}jQuery(q).removeData("blockUI.history")}if(typeof r.onUnblock=="function"){r.onUnblock(q,r)}}function l(p,t,u){var s=t==window,r=jQuery(t);if(!p&&(s&&!b||!s&&!r.data("blockUI.isBlocked"))){return}if(!s){r.data("blockUI.isBlocked",p)}if(!u.bindEvents||(p&&!u.showOverlay)){return}var q="mousedown mouseup keydown keypress";p?jQuery(document).bind(q,u,n):jQuery(document).unbind(q,n)}function n(t){if(t.keyCode&&t.keyCode==9){if(b&&t.data.constrainTabKey){var r=g;var q=!t.shiftKey&&t.target===r[r.length-1];var p=t.shiftKey&&t.target===r[0];if(q||p){setTimeout(function(){o(p)},10);return false}}}var s=t.data;if(jQuery(t.target).parents("div."+s.blockMsgClass).length>0){return true}return jQuery(t.target).parents().children().filter("div.blockUI").length==0}function o(p){if(!g){return}var q=g[p===true?g.length-1:0];if(q){q.focus()}}function a(w,q,A){var z=w.parentNode,v=w.style;var r=((z.offsetWidth-w.offsetWidth)/2)-m(z,"borderLeftWidth");var u=((z.offsetHeight-w.offsetHeight)/2)-m(z,"borderTopWidth");if(q){v.left=r>0?(r+"px"):"0"}if(A){v.top=u>0?(u+"px"):"0"}}function m(q,r){return parseInt(jQuery.css(q,r))||0}})(jQuery);
/* Copyright (c) 2006 Brandon Aaron (http://brandonaaron.net)
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) 
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 *
 * $LastChangedDate: 2007-07-21 18:44:59 -0500 (Sat, 21 Jul 2007) $
 * $Rev: 2446 $
 *
 * Version 2.1.1
 */
(function(a){jQuery.fn.bgIframe=jQuery.fn.bgiframe=function(c){if(jQuery.browser.msie&&/6.0/.test(navigator.userAgent)){c=jQuery.extend({top:"auto",left:"auto",width:"auto",height:"auto",opacity:true,src:"javascript:false;"},c||{});var d=function(e){return e&&e.constructor==Number?e+"px":e},b='<iframe class="bgiframe"frameborder="0"tabindex="-1"src="'+c.src+'"style="display:block;position:absolute;z-index:-1;'+(c.opacity!==false?"filter:Alpha(Opacity='0');":"")+"top:"+(c.top=="auto"?"expression(((parseInt(this.parentNode.currentStyle.borderTopWidth)||0)*-1)+'px')":d(c.top))+";left:"+(c.left=="auto"?"expression(((parseInt(this.parentNode.currentStyle.borderLeftWidth)||0)*-1)+'px')":d(c.left))+";width:"+(c.width=="auto"?"expression(this.parentNode.offsetWidth+'px')":d(c.width))+";height:"+(c.height=="auto"?"expression(this.parentNode.offsetHeight+'px')":d(c.height))+';"/>';return this.each(function(){if(jQuery("> iframe.bgiframe",this).length==0){this.insertBefore(document.createElement(b),this.firstChild)}})}return this}})(jQuery);
/*
 * jQuery optionTree Plugin
 * version: 1.2
 * @requires jQuery v1.3 or later
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 * @version $Id: jquery.optionTree.js 8 2010-10-06 08:48:31Z kkotowicz $
 * @author  Krzysztof Kotowicz <kkotowicz at gmail dot com>
 * @see http://code.google.com/p/jquery-option-tree/
 * @see http://blog.kotowicz.net/search/label/option
 */
(function(a){jQuery.fn.optionTree=function(b,e){e=jQuery.extend({choose:"Choose...",preselect:{},select_class:"",leaf_class:"final",empty_value:"",on_each_change:false,set_value_on:"leaf",indexed:false},e||{});var f=function(i){return i.replace(/_*$/,"")};var c=function(i){jQuery("select[name^='"+i+"']").remove()};var h=function(i,j){jQuery("input[name='"+f(i)+"']").val(j).change()};var d=function(j){var i=this;jQuery.getJSON(e.lazy_load,{id:j},function(k){for(var l in k){if(k.hasOwnProperty(l)){jQuery(i).optionTree(k,e);return}}jQuery(i).optionTree(j,e)})};if(typeof e.on_each_change=="string"){e.lazy_load=e.on_each_change;e.on_each_change=d}var g=function(j,i){if(!e.preselect||!e.preselect[j]){return false}if(jQuery.isArray(e.preselect[j])){return jQuery.inArray(i,e.preselect[j])!=-1}return(e.preselect[j]==i)};return this.each(function(){var l=jQuery(this).attr("name")+"_";c(l);if(typeof b=="object"){var k=jQuery("<select>").attr("name",l).change(function(){if(this.options[this.selectedIndex].value!=""){if(jQuery.isFunction(e.on_each_change)){c(l+"_");e.on_each_change.apply(this,[this.options[this.selectedIndex].value,b])}else{jQuery(this).optionTree(b[this.options[this.selectedIndex].value],e)}if(e.set_value_on=="each"){h(l,this.options[this.selectedIndex].value)}}else{c(l+"_");h(l,e.empty_value)}});var j;if(jQuery(this).is("input")){k.insertBefore(this)}else{k.insertAfter(this)}if(jQuery.isFunction(e.choose)){var m=jQuery(this).siblings().andSelf().filter("select").length;j=e.choose.apply(this,[m])}else{j=e.choose}if(e.select_class){k.addClass(e.select_class)}jQuery("<option>").html(j).val("").appendTo(k);var i=false;jQuery.each(b,function(p,n){var q,s;if(e.indexed){q=n;s=p}else{q=s=p}var t=jQuery("<option>").html(q).attr("value",s);var r=f(l);if(e.leaf_class&&typeof s!="object"){t.addClass(e.leaf_class)}t.appendTo(k);if(g(r,s)){t.get(0).selected=true;i=true}});if(i){k.change()}}else{if(e.set_value_on=="leaf"){if(e.indexed){h(l,this.options[this.selectedIndex].value)}else{h(l,b)}}}})}})(jQuery);if(jQuery){(function(a){jQuery.extend(jQuery.fn,{fileTree:function(c,b){if(!c){var c={}}if(c.root==undefined){c.root=""}if(c.script==undefined){c.script=""}if(c.folderEvent==undefined){c.folderEvent="click"}if(c.expandSpeed==undefined){c.expandSpeed=500}if(c.collapseSpeed==undefined){c.collapseSpeed=500}if(c.expandEasing==undefined){c.expandEasing=null}if(c.collapseEasing==undefined){c.collapseEasing=null}if(c.multiFolder==undefined){c.multiFolder=false}if(c.loadMessage==undefined){c.loadMessage="Loading..."}jQuery(this).each(function(){function e(g,f){jQuery(g).addClass("wait");jQuery(".Tree.start").remove();jQuery.post(c.script,{data:f},function(h){jQuery(g).find(".start").html("");jQuery(g).removeClass("wait").append(h);if(c.root==f){jQuery(g).find("UL:hidden").show()}else{jQuery(g).find("UL:hidden").slideDown({duration:c.expandSpeed,easing:c.expandEasing})}d(g)})}function d(f){jQuery(f).find("LI A").bind(c.folderEvent,function(){if(jQuery(this).parent().hasClass("directory")){if(jQuery(this).parent().hasClass("collapsed")){if(!c.multiFolder){jQuery(this).parent().parent().find("UL").slideUp({duration:c.collapseSpeed,easing:c.collapseEasing});jQuery(this).parent().parent().find("LI.directory").removeClass("expanded").addClass("collapsed")}if(jQuery(this).siblings("UL").length>0){jQuery(this).siblings("UL").slideDown({duration:c.collapseSpeed,easing:c.collapseEasing});jQuery(this).siblings("UL").find("LI.directory").removeClass("expanded").addClass("collapsed")}else{jQuery(this).parent().find("UL").remove();e(jQuery(this).parent(),jQuery(this).attr("rel"))}jQuery(this).parent().removeClass("collapsed").addClass("expanded")}else{jQuery(this).parent().find("UL").slideUp({duration:c.collapseSpeed,easing:c.collapseEasing});jQuery(this).parent().removeClass("expanded").addClass("collapsed")}}else{b(jQuery(this).attr("rel"),jQuery(this).html(),this)}return false});jQuery(f).find("LI A i").click(function(g){g.stopPropagation();b(jQuery(this).parent().attr("rel"),jQuery(this).parent().html(),jQuery(this).parent());return false});if(c.folderEvent.toLowerCase!="click"){jQuery(f).find("LI A").bind("click",function(){return false})}}jQuery(this).html('<ul class="Tree start"><li class="wait">'+c.loadMessage+"<li></ul>");jQuery(this).bgiframe({width:180,height:200});e(jQuery(this),c.root)})}})})(jQuery);
/*
/* LimitInput   2010-12-30
*/
}(function(a){jQuery.fn.extend({LimitInput:function(c){c=jQuery.extend({el:null,Limit:20},c||{});var d=jQuery(this);var b;jQuery(c.el).html("\u60a8\u8fd8\u53ef\u4ee5\u8f93\u5165"+c.Limit+"\u4e2a\u5b57\u3002");d.keyup(function(){var e=c.Limit-jQuery(this).val().length;if(e>=0){jQuery(c.el).html("\u60a8\u8fd8\u53ef\u4ee5\u8f93\u5165"+e+"\u4e2a\u5b57\u3002")}else{jQuery(c.el).html("<span style='color:red'>\u5df2\u8d85\u51fa"+(0-e)+"\u4e2a\u5b57\u3002</span>")}})}})})(jQuery);
/*
/* SeleUser   2010-12-30
*/
(function(a){jQuery.fn.extend({SeleUser:function(c){c=jQuery.extend({box:jQuery("#xbox-mock"),el:null,input:null,mode:"max",Limit:false,init:[],url:"",def:null,callback:null},c||{});var i=jQuery(this);i.data("user",[]);var e;if(c.init.length>0){b(c.init)}i.click(function(){j();jQuery.blockUI({message:c.box,css:{width:"690px",marginLeft:"-345px"}});jQuery("#J_userTree").fileTree({root:"",script:c.url,multiFolder:!c.Limit},function(m,l,k){g(m,l,k)});jQuery("#user-select-ok").unbind().click(function(){h()})});function j(k){var l=i.data("user");jQuery.each(l,function(n,m){f(m.id,m.text)})}function f(m,k){if(c.Limit){jQuery("#ulUserSelect").empty();jQuery("#J_userTree a").removeClass("select")}var l=jQuery('<li rel="'+m+'"><span class="name">'+k+'</span><span class="oprt">[<a href="javascript:void(0)" title="\u79fb\u51fa\u8be5\u8054\u7cfb\u4eba">\u79fb\u9664</a>]</span></li>');l.find(".oprt").click(function(){jQuery("#J_userTree").find("[rel="+l.attr("rel")+"]").removeClass("select");l.fadeOut("fast",function(){l.remove()})});l.appendTo("#ulUserSelect")}function g(n,m,l){if(jQuery(l).hasClass("quite")){return}var k=jQuery("#ulUserSelect").find("[rel="+n+"]").length;if(!jQuery(l).hasClass("select")&&k==0){f(n,m)}jQuery("#J_userTree").find("[rel="+n+"]").addClass("select")}function b(m,l){var l=l||false;i.data("user",[]);jQuery(c.input).val("");if(m.length>0){var n=[];jQuery.each(m,function(q,o){var s=o.id,r=o.text;var p={id:s,text:r};i.data("user").push(p);n.push(s)});jQuery(c.input).val(n.join(";"));switch(c.mode){case"max":var k=m.length;if(k>1){jQuery('<div class="user-name">\u5171 '+k+" \u4e2a\u8bb0\u5f55;</div>").appendTo(c.el)}else{jQuery('<div class="user-name">'+m[0].text+"</div>").appendTo(c.el)}break;case"def":break;default:}}if(l){c.callback&&c.callback(m)}}function h(){jQuery(c.el).empty();var l=jQuery("#ulUserSelect li");var k=[];jQuery.each(l,function(o,m){var q=jQuery(m).attr("rel"),p=jQuery(m).find(".name").html();var n={id:q,text:p};k.push(n)});b(k,true);d()}function d(){jQuery.unblockUI();jQuery("#ulUserSelect").empty()}jQuery(".xbox-close,.xbox-cancel").unbind().click(function(){d()})}})})(jQuery);
/* head & sidebar
 *  
 * 2010-12-30
 */
AFMS.Header=function(){return{init:function(){jQuery(".sys-selector").click(function(){if(jQuery("#J_SysChange").length==0){return}jQuery.blockUI({message:jQuery("#J_SysChange"),css:{width:"auto",marginLeft:"0",top:"25px",left:jQuery(this).width()+40,border:"0 none",position:"absolute","-moz-box-shadow":"none","-webkit-box-shadow":"none"},overlayCSS:{opacity:0,cursor:"default"},centerX:false,centerY:false});jQuery(".blockOverlay").click(jQuery.unblockUI)});jQuery("#ac").blur(function(){if(jQuery(this).val()==""){jQuery("#J_ac-val").show()}});jQuery("#J_ac-val").click(function(){jQuery(this).hide();jQuery("#ac").focus()})}}}();AFMS.Sider=function(){return{init:function(){jQuery(".top-ele.current .sub-ele").slideToggle("fast");jQuery("div.top-ele span").click(function(){if(jQuery(this).parent().hasClass("current")){jQuery(this).parent().removeClass("current");jQuery(this).next().slideToggle("fast");jQuery(this).attr("title","\u5c55\u5f00")}else{jQuery(".top-ele.current .sub-ele").slideToggle("fast");jQuery(".top-ele.current").removeClass("current");jQuery(this).parent().addClass("current");jQuery(this).next().slideToggle("fast");jQuery(this).attr("title","\u6536\u8d77")}return false})}}}();jQuery(document).ready(function(){AFMS.Util.bdAutoHeight()});

/* ===========================================================
 * bootstrap-tooltip.js v2.0.0
 * http://twitter.github.com/bootstrap/javascript.html#tooltips
 * Inspired by the original jQuery.tipsy by Jason Frame
 * ===========================================================
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
!function(b){var a=function(d,c){this.init("tooltip",d,c)};a.prototype={constructor:a,init:function(f,e,d){var g,c;this.type=f;this.$element=b(e);this.options=this.getOptions(d);this.enabled=true;if(this.options.trigger!="manual"){g=this.options.trigger=="hover"?"mouseenter":"focus";c=this.options.trigger=="hover"?"mouseleave":"blur";this.$element.on(g,this.options.selector,b.proxy(this.enter,this));this.$element.on(c,this.options.selector,b.proxy(this.leave,this))}this.options.selector?(this._options=b.extend({},this.options,{trigger:"manual",selector:""})):this.fixTitle()},getOptions:function(c){c=b.extend({},b.fn[this.type].defaults,c,this.$element.data());if(c.delay&&typeof c.delay=="number"){c.delay={show:c.delay,hide:c.delay}}return c},enter:function(d){var c=b(d.currentTarget)[this.type](this._options).data(this.type);if(!c.options.delay||!c.options.delay.show){c.show()}else{c.hoverState="in";setTimeout(function(){if(c.hoverState=="in"){c.show()}},c.options.delay.show)}},leave:function(d){var c=b(d.currentTarget)[this.type](this._options).data(this.type);if(!c.options.delay||!c.options.delay.hide){c.hide()}else{c.hoverState="out";setTimeout(function(){if(c.hoverState=="out"){c.hide()}},c.options.delay.hide)}},show:function(){var g,c,i,e,h,d,f;if(this.hasContent()&&this.enabled){g=this.tip();this.setContent();if(this.options.animation){g.addClass("fade")}d=typeof this.options.placement=="function"?this.options.placement.call(this,g[0],this.$element[0]):this.options.placement;c=/in/.test(d);g.remove().css({top:0,left:0,display:"block"}).appendTo(c?this.$element:document.body);i=this.getPosition(c);e=g[0].offsetWidth;h=g[0].offsetHeight;switch(c?d.split(" ")[1]:d){case"bottom":f={top:i.top+i.height,left:i.left+i.width/2-e/2};break;case"top":f={top:i.top-h,left:i.left+i.width/2-e/2};break;case"left":f={top:i.top+i.height/2-h/2,left:i.left-e};break;case"right":f={top:i.top+i.height/2-h/2,left:i.left+i.width};break}g.css(f).addClass(d).addClass("in")}},setContent:function(){var c=this.tip();c.find(".tooltip-inner").html(this.getTitle());c.removeClass("fade in top bottom left right")},hide:function(){var c=this,d=this.tip();d.removeClass("in");function e(){var f=setTimeout(function(){d.off(b.support.transition.end).remove()},500);d.one(b.support.transition.end,function(){clearTimeout(f);d.remove()})}b.support.transition&&this.$tip.hasClass("fade")?e():d.remove()},fixTitle:function(){var c=this.$element;if(c.attr("title")||typeof(c.attr("data-original-title"))!="string"){c.attr("data-original-title",c.attr("title")||"").removeAttr("title")}},hasContent:function(){return this.getTitle()},getPosition:function(c){return b.extend({},(c?{top:0,left:0}:this.$element.offset()),{width:this.$element[0].offsetWidth,height:this.$element[0].offsetHeight})},getTitle:function(){var e,c=this.$element,d=this.options;e=c.attr("data-original-title")||(typeof d.title=="function"?d.title.call(c[0]):d.title);e=e.toString().replace(/(^\s*|\s*$)/,"");return e},tip:function(){return this.$tip=this.$tip||b(this.options.template)},validate:function(){if(!this.$element[0].parentNode){this.hide();this.$element=null;this.options=null}},enable:function(){this.enabled=true},disable:function(){this.enabled=false},toggleEnabled:function(){this.enabled=!this.enabled},toggle:function(){this[this.tip().hasClass("in")?"hide":"show"]()}};b.fn.tooltip=function(c){return this.each(function(){var f=b(this),e=f.data("tooltip"),d=typeof c=="object"&&c;if(!e){f.data("tooltip",(e=new a(this,d)))}if(typeof c=="string"){e[c]()}})};b.fn.tooltip.Constructor=a;b.fn.tooltip.defaults={animation:true,delay:0,selector:false,placement:"top",trigger:"hover",title:"",template:'<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>'}}(window.jQuery);


