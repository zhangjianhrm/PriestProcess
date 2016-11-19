String.prototype.trim = function(s) {
    s = (s ? s : "\\s");
    s = ("(" + s + ")");
    var reg_trim = new RegExp("(^" + s + "*)|(" + s + "*$)", "g");
    return this.replace(reg_trim, "");
};

function getWindowFunction(funcName){
    // find object and check its type ;
    if (typeof window[funcName] === "function") {
        return window[funcName] ;
    }
    return undefined ;
}

$.extend({
    History : {
        appId : undefined ,
        settings : {
            processApp : 'processApp',
            act        : 'playAction',
        },
        _flatten : function(params,sep){
            if ( params.constructor == String ){
                return params ;
            }
            var sep = sep || '&' ;
            var arr = [] ;
            for ( var k in params ){
                arr.push( k+'='+params[k] ) ; 
            }
            return arr.join(sep);
        } ,
        _dict :  function(params,sep){
            if( params.constructor == Object ){
                return params ;    
            }
            var d = {} ; 
            var sep = sep || '&' ;
            var kvs = params.split( sep );
            for(var i = 0; i < kvs.length; i ++) {
                var kv = kvs[i].split("=");
                if ( kv[0].length > 0 ) {
                    if ( kv.length == 1 ){
                        d[kv[0]] = undefined ;
                    }else if ( kv.length == 2) {
                        d[kv[0]] = decodeURIComponent(kv[1]);
                    }
                }
            }
            return d ;
        },
        _fill_form : function( hash ){
            var objdict = this._dict( hash ) ;
            for( var o in objdict ){
                var obj = $('#'+o); 
                if ( obj != undefined ){ 
                    obj.val(objdict[o] ); 
                } 
            }
            return objdict ;
        } , 
        init : function(settings){
            this.settings = $.extend(this.settings,settings) ;
        } ,
        resetProcessApp : function(obj) {
            var kApp = this.settings['processApp'] || 'undefined' ;
            if ( obj == undefined && this.appId != undefined ){
                $('#'+kApp).val( this.appId );
            }else if ( obj != undefined ){
                this.appId = obj[kApp] ;
            }
        },
        record : function(params){
            if ( !gFirstLoad ) {
                var hash = this._flatten( params ) ; 
                location.hash = hash ;
            }
        },
        play:  function(){
            var dict = this._fill_form( location.hash.trim('#') ) ;
            if (!$.isEmptyObject(dict)){
                this.resetProcessApp( dict ) ;
                var kAct = this.settings['act'] ;
                var fplayAction = getWindowFunction( dict[ kAct ] ) ;
                if ( fplayAction != undefined ) {
                    fplayAction.apply(null,[dict]) ;
                } else { // try call reloadTable ; 
                    var fplayDef = getWindowFunction('reloadTable') ;
                    if ( fplayDef != undefined ) {
                        fplayDef.apply(null,[dict]) ;
                    }
                }                
            }
        },        
    },
});

/*
  not to record the query hash when first loaded .
*/
var gFirstLoad = true ;
$(function(){
    window.onhashchange = function(){
        $.History.play()  ;
    }
     
    $.History.play();
    gFirstLoad = false; 
    
/* 
  hook processApp ajax complete event to reset the selected value
  as processApp is a select list and always binded after loaded by ajax ,
  when play called , this select may not be binded ,so the value may not 
  correct , so ,need mark selected appid , set this selected value to 
  processApp when ajax success completed return. 
*/
    $(document).bind("ajaxComplete",function(evt,xhr,opts){
        var url = opts['url'] ;
        if ( url != undefined && url.constructor == String && url.endsWith('config/getApps.do')){
            $.History.resetProcessApp();
        }
    });
}) ;

