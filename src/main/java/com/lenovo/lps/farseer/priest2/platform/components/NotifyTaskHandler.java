package com.lenovo.lps.farseer.priest2.platform.components;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;

import com.lenovo.lps.farseer.priest2.platform.entity.ComponentsType;
import com.lenovo.lps.farseer.priest2.platform.service.SMService;


public class NotifyTaskHandler extends AbstractTaskHandler  {
	private static final String COMPONENTS_PARAMS_PERSON = "alermPerson" ;
	private static final String COMPONENTS_PARAMS_CONTENT = "alermContent" ;
	

	public static final String ALARM_TYPE_SPLIT = "\\n";

	// 多个告警对象间分隔符：邮件";"，短信","
	private static final String ALARM_TARGET_CONCATE_CHAR_EMAIL = ";";
	private static final String ALARM_TARGET_CONCATE_CHAR_SMS = ",";
	
	private static final Pattern PTN_PHONE = Pattern.compile("^1[0-9]{10}$");
	private static final Pattern PTN_MAIL  = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

	@Resource
	private SMService smService;

	@Override
	protected Map<String, Object> getComponentParams(JsonNode jsonNode) {
		// 输入参数		
		String person  = jsonNode.get(COMPONENTS_PARAMS_PERSON).getTextValue();
		String content = jsonNode.get(COMPONENTS_PARAMS_CONTENT).getTextValue();

		Map<String, Object> componentParams = new HashMap<String, Object>();

		componentParams.put("person", person);
		componentParams.put("content", content);
		return componentParams;

	}

	@Override
	protected Object invokeComponentMethod(Map<String, Object> params) {
		Object result = null;
		String person = (String) params.get("person");
		String content = (String) params.get("content");
		
		String sendContent  = content;//DataTransformation.placeholderReplace(content, params);
		String[] alarmTargets = person.split(ALARM_TYPE_SPLIT), targets;
		
		// 多个联系人通过分隔符组织在一块，一块发送
		String smsReceivers = null;
		String mailReceivers = null ;
		
		for( String target : alarmTargets){
			target = StringUtils.trim(target);
			if ( StringUtils.isEmpty(target)){
				continue ;
			}
			
			targets = target.split(ALARM_TARGET_CONCATE_CHAR_SMS);
			if (targets.length > 1) {
				for (String targ: targets) {
					if ( PTN_PHONE.matcher(targ).matches()){
						if (smsReceivers == null){
							smsReceivers = "" ;
						}else{
							smsReceivers += ALARM_TARGET_CONCATE_CHAR_SMS ;
						}				
						smsReceivers +=  targ ;
					}
				}
			} else {
				targets = target.split(ALARM_TARGET_CONCATE_CHAR_EMAIL);
				if (targets.length > 1) {
					for (String targ: targets) {
						if( PTN_MAIL.matcher(targ).matches()){
							if (mailReceivers == null){
								mailReceivers = "";
							}else{
								mailReceivers += ALARM_TARGET_CONCATE_CHAR_EMAIL ;
							}
							mailReceivers +=  targ ;
						}
					}
				} else {
					if ( PTN_PHONE.matcher(target).matches()){
						if (smsReceivers == null){
							smsReceivers = "" ;
						}else{
							smsReceivers += ALARM_TARGET_CONCATE_CHAR_SMS ;
						}				
						smsReceivers +=  target ;
					}else if( PTN_MAIL.matcher(target).matches()){
						if (mailReceivers == null){
							mailReceivers = "";
						}else{
							mailReceivers += ALARM_TARGET_CONCATE_CHAR_EMAIL ;
						}
						mailReceivers +=  target ;
					}else {
						logger.error("Unkown notify target:"+ target);
					}
				}
			}
		}
		
		if(smsReceivers != null ) {
			try {
				smService.sendMessage("notify", smsReceivers,sendContent) ;
				logger.warn(String.format("Sms notice content[%s], phone[%s]", sendContent, smsReceivers));
			} catch (Exception e) {
				logger.error("Failed to send message :"+ sendContent + " to " + smsReceivers + e.getMessage());
			} 
			//System.out.println("call smsService.sendMessage("+smsReceivers+","+sendContent+")");
		}
		
		// else　不告警或者未设置 告警
		/*
		String value = (String) params.get("value");
		if (OP_GET.equals(cacheOp)) {
			result = cacheService.get(key);
		} else {
			cacheService.set(key, value);
		}
		*/
		return result;
	}

	@Override
	protected ComponentsType getComponetType() {
		// 任务类型为cache
		return ComponentsType.NOTIFY;
	}
}
