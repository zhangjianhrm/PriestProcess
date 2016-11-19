package com.lenovo.lps.farseer.priest2.platform.manager.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.manager.SMManager;
import com.lenovo.lps.farseer.priest2.platform.service.SMService;

public class SMManagerImpl implements SMManager {

	@Autowired
	@Qualifier("smService")
	private SMService smService;
	
	@Resource
	private ApplicationDao applicationDao;

	@Override
	public boolean sendMessage(String context) throws IOException, HttpException, URISyntaxException {
		return this.sendMessage("process", null, context);
	}

	@Override
	public boolean sendMessage(String ipAddr, String phoneNumbers, String context) throws IOException, HttpException, URISyntaxException {
		String phones = null;
		if (phoneNumbers != null) {
			phones = phoneNumbers;
		} else {
			SysConfigEntity config = new SysConfigEntity();
			config.setType(String.valueOf(SysConfigTypeEnum.SMS.getValue()));
			List<SysConfigEntity> scs =  applicationDao.getSysConfig(config);
			if (scs != null && scs.size() > 0) {
				phones = scs.get(0).getTarget();
			}
		}
		if (phones == null || "".equals(phones)) {
			throw new PriestPlatformException("The phone number is empty");
		}
		return smService.sendMessage(ipAddr, phones, context);
	}
}
