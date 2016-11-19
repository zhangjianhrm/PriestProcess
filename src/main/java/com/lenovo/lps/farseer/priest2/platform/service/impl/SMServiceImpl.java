package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.mapper.LockMapper;
import com.lenovo.lps.farseer.priest2.platform.service.HttpClient;
import com.lenovo.lps.farseer.priest2.platform.service.SMService;
import com.lenovo.lps.farseer.priest2.platform.util.XMLParseUtils;

public class SMServiceImpl implements SMService {
	// 使用priest.notification单独记录日志，与业务日志分开，避免影响业务出错日志
	private Logger logger = Logger.getLogger("priest.notification");

	@Autowired
	@Qualifier("httpClient")
	private HttpClient httpClient;
	
	@Autowired
	private LockMapper lockMapper;
	
	private int limitContent = 480;
	
	@Resource
	private ApplicationDao applicationDao;
	
	private void sendMsg(String sendPhones, String context, int depth, String flag, SysConfigEntity config) {
		depth++;
		if (depth > 5) {
			return;
		}
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("cdkey", config.getUser());
		paramsMap.put("password", config.getPasswd());
		paramsMap.put("phone", sendPhones);
		String smContent = context;
		if (smContent.length() > limitContent) {
			smContent = "【Lenovo】" + smContent.substring(0, limitContent) + ConfigUtil.getContextProperty("subfix_of_mail_and_message", "(home)");
		} else {
			smContent = "【Lenovo】" + smContent + ConfigUtil.getContextProperty("subfix_of_mail_and_message", "(home)");
		}
		paramsMap.put("message", smContent + flag + depth + "]");

		try {
			response(httpClient.sendPost(config.getUrl(), paramsMap));
		}
		// 通知服务，为不影响正常业务，异常吞掉．
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (context.length() > limitContent) {
			sendMsg(sendPhones,  context.substring(limitContent, context.length()), depth, flag, config);
		}
	}

	@Override
	public boolean sendMessage(String ipAddr, String sendPhones, String context) throws IOException, HttpException, URISyntaxException {
		Assert.hasText(context, "sms message has no text");
		Assert.hasText(sendPhones, "sms phone has no numbers");
		limitContent = Integer.parseInt(ConfigUtil.getContextProperty("system.priest.sms.content.limit", "480"));
		SysConfigEntity config = new SysConfigEntity();
		config.setType(String.valueOf(SysConfigTypeEnum.SMS.getValue()));
		List<SysConfigEntity> scs =  applicationDao.getSysConfig(config);
		if (scs != null && scs.size() > 0) {
			config = scs.get(0);
		}
		try {
			String phones = "", today = "";
			int sendNum, limitNum = Integer.parseInt(ConfigUtil.getContextProperty("system.priest.sms.limit", "100"));
			today = DateUtils.parseDate2String(new Date(), DateUtils.getDateDayFormat());
			Map<String, String> paramPhone, paramMap;
			for (String phone: sendPhones.split(",")) {
				paramPhone = new HashMap<String, String>();
				paramPhone.put("phone", phone);
				paramPhone.put("p_event_date", today);
				sendNum = lockMapper.phoneSendNum(paramPhone);
				paramPhone.put("context", context);
				paramPhone.put("ip_addr", ipAddr);
				paramPhone.put("is_send", "0");
				
				
				if (sendNum < limitNum) {
					phones += phone + ",";
					paramPhone.put("is_send", "1");
				} else if (sendNum == limitNum) {
					try {
						paramMap = new HashMap<String, String>();
						paramMap.put("cdkey", config.getUser());
						paramMap.put("password", config.getPasswd());
						paramMap.put("phone", phone);
						paramMap.put("message", String.format("【Lenovo】(%s)Priest process send msg more than %s, it will not send message today, thanks!", today, limitNum));
						response(httpClient.sendPost(config.getUrl(), paramMap));
					} catch (Exception e) {}
				}
				lockMapper.saveSendMsg(paramPhone);
			}
			if ("".equals(phones)) {
				return false;
			}
			sendPhones = phones.substring(0, phones.length() - 1);
		} catch (Exception e){
			logger.error(e);
			AuditLog.log(String.format("ipAddr[%s], errors[%s]", ipAddr, e.getMessage()));
		}

		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("cdkey", config.getUser());
		paramsMap.put("password", config.getPasswd());
		paramsMap.put("phone", sendPhones);

		String smContent = context, flag = String.format("(Time:%s, Num:", DateUtils.parseDate2Time(new Date()));
		/**
		 * 短信最多160个字,应亿美短信网关防止短信过于密集发送被运营商禁止发送要求，前缀加"【联想】"
		 */
		if (smContent.length() > limitContent) {
			smContent = "【Lenovo】" + smContent.substring(0, limitContent) + ConfigUtil.getContextProperty("subfix_of_mail_and_message", "(home)") + flag + "1)";
		} else {
			smContent = "【Lenovo】" + smContent + ConfigUtil.getContextProperty("subfix_of_mail_and_message", "(home)");
		}

		paramsMap.put("message", smContent);

		boolean result = false;
		try {
			result = response(httpClient.sendPost(config.getUrl(), paramsMap));
		}
		// 通知服务，为不影响正常业务，异常吞掉．
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			if (context.length() > limitContent) {
				sendMsg(sendPhones,  context.substring(limitContent, context.length()), 1, flag, config);
			}
		} catch (Exception e) {
			logger.error("error send sms info:", e);
		}

		return result;
	}

	private boolean response(String response) {
		boolean flag = false;
		String statusCode = XMLParseUtils.getNodeValue(response, "/response/*[name()='error']");
		if ("0".equalsIgnoreCase(statusCode)) {
			flag = true;
		} else {
			throw new PriestPlatformException("The error code of SMS is " + statusCode);
		}
		return flag;
	}

}
