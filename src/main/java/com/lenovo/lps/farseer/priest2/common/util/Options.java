package com.lenovo.lps.farseer.priest2.common.util;

/**
 * Configuration options
 * @author luojiang2
 */
public enum Options{
	//LenovoID接口URL
	LENOVOID_INTERFACE_URL("lenovoid.interface.url","https://passport.lenovo.com/wauthen2/gateway"),
	// 调用LenovoID接口的动作参数
	LENOVOID_ACTION_PARAM("lenovoid.action.param","?lenovoid.action="),
	//调用LenovoID接口的域参数
	LENOVOID_REALM_PARAM("lenovoid.realm.param","&lenovoid.realm="),
	//调用LenovoID接口后的回调URL参数
	LENOVOID_CALLBACK_PARAM("lenovoid.callback.param","&lenovoid.cb="),
	//LenovoID的登录过期时间参数
	LENOVOID_VP_PARAM("lenovoid.vp.param","&lenovoid.vp="),
	//调用LenovoID接口时的回调参数
	LENOVOID_CTX_PARAM("lenovoid.ctx.param","&lenovoid.ctx="),

	//LenovoID票据获取URL
	LENOVOID_TICKET_URL("lenovoid.ticket.url","http://passport.lenovo.com/interserver/authen/1.2/getaccountid"),
	//调用LenovoID接口获取登录用户信息的lpsust参数
	LENOVOID_LPSUST_PARAM("lenovoid.lpsust.param","?lpsust="),
	//调用lpsust接口时使用的域参数
	LENOVOID_LPSUST_REALM_PARAM("realm.param","&realm="),
	
    //调用LenovoID接口的域
	LENOVOID_REALM("lenovoid.realm","open.passport.lenovo.com"),
	//调用LenovoID接口后的回调URL
	LENOVOID_CALLBACK("lenovoid.callback","http://ln.lenovomm.com:8081/priest/index.do"),
	//LenovoID的登录过期时间
	LENOVOID_VP("lenovoid.vp","7200");
	
	private Options(String name,Object defaultValue){
		this.name=name;
		this.defaultValue=defaultValue;
	}
	private String name;		 //property name
	private Object defaultValue; //property default value
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}
}