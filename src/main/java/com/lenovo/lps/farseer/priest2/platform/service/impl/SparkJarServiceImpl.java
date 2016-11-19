/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;
import com.lenovo.lps.farseer.priest2.platform.service.SparkJarService;

/**
 * @author niexm1
 * 
 */
public class SparkJarServiceImpl implements SparkJarService {
	@Resource
	private ShellService shellService;
	
	@Override
	public void submit(String jobName, String jarFullFileName, String mainClass, Map<String, String> params, String appUser) {
		File jar = new File(jarFullFileName);
		Assert.isTrue(jar.exists(), "Spark Run jar file doesn't exists:" + jarFullFileName);

		try {
			StringBuffer commandLine = new StringBuffer();
			commandLine.append(" --name ");
			commandLine.append(jobName);
			commandLine.append(" --proxy-user ");
			commandLine.append(appUser);
			commandLine.append(" --class ");
			commandLine.append(mainClass);
			commandLine.append(" --master ");
			commandLine.append(ConfigUtil.getContextProperty("spark.master"));
			commandLine.append(" ");
			// 增加 --key value
			if (params != null && params.size() > 0) {
				for (Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (entry.getKey().contains("--") && (!entry.getKey().contains("--proxy-user")) && !entry.getKey().contains("--keytab")) {
						commandLine.append(entry.getKey());
						commandLine.append(" ");
						if (StringUtils.hasText(value)) {
							commandLine.append(entry.getValue());
						}
					}

					commandLine.append(" ");
				}
			}
			commandLine.append(jarFullFileName);
			commandLine.append(" ");
			
			String extraArgs = null ;
			if ( params.containsKey("ExtraArgs")){
				extraArgs = org.apache.commons.lang.StringUtils.trimToNull(params.remove("ExtraArgs"));
			}
			// 增加 -Dkey=value
			if (params != null && params.size() > 0) {
				for (Entry<String, String> entry : params.entrySet()) {
					
					String value = entry.getValue();
					if (!(entry.getKey().contains("--"))) {
						commandLine.append(entry.getKey());
						if (StringUtils.hasText(value)) {
							commandLine.append("=");
							commandLine.append(entry.getValue());
						}
					}

					commandLine.append(" ");
				}
			}
			
			if ( extraArgs != null) {
				commandLine.append(" ");
				commandLine.append(extraArgs) ;
			}

			String command = commandLine.toString();
			AuditLog.log("Begin invoking Spark jar job:" + command);
			HadoopUgiServiceImpl.priestLogin();
			shellService.runCommand(ConfigUtil.getContextProperty("spark.submit"), command);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
}
