/**
 * 
 */
package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.service.MapReduceService;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;
import com.lenovo.lps.farseer.priest2.platform.util.FileUtils;

/**
 * @author niexm1
 * 
 */
public class MapReduceServiceImpl implements MapReduceService {
	private final Logger logger = Logger.getLogger(MapReduceServiceImpl.class);

	@Resource
	private ShellService shellService;
	
	@Override
	public void submit(String jobName, String jarFullFileName, String mainClass, Map<String, String> params, String appUser) {
		File jar = new File(jarFullFileName);
		Assert.isTrue(jar.exists(), "Map Reduce jar file does not exist:" + jarFullFileName);
		
		try {
			String hadoopConfPath = FileUtils.getJarPathForClass(MapReduceServiceImpl.class);
			StringBuffer commandLine = new StringBuffer();
			commandLine.append(ConfigUtil.getContextProperty("java.path", "/var/lib/priest/jdk1.7.0_67-cloudera/bin/java"));
			commandLine.append(" -DUSER.KERBEROS.REALM=");
			commandLine.append(ConfigUtil.getContextProperty("realm.krb", "@AVATAR.LENOVOMM.COM"));
			commandLine.append(" -classpath ");
			commandLine.append(hadoopConfPath);
			String runtimeClassPath = FileUtils.getHadoopProcessClassPath();
			if (CommUtils.isNotNull(runtimeClassPath)) {
				commandLine.append(File.pathSeparator);
				commandLine.append(runtimeClassPath);
			}
			
			commandLine.append(" ");

			// modified by niexm 2014/1/9. 在PriestRunJar实现 新process中login
			commandLine.append("com.lenovo.lps.farseer.priest2.ext.PriestRunJar");
			
			commandLine.append(" ");
			commandLine.append(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase());
			
			commandLine.append(" ");
			commandLine.append(com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getHadoopConfigPath().getAbsolutePath());
			
			commandLine.append(" ");
			commandLine.append(jarFullFileName);
			commandLine.append(" ");
			
			commandLine.append(appUser);
			commandLine.append(" ");
			
			// mainClass为可选,为null时需改为空字符
			commandLine.append(mainClass == null ? "" : mainClass);
			commandLine.append(" ");


			String extraArgs = null ;
			if ( params.containsKey("ExtraArgs")){
				extraArgs = org.apache.commons.lang.StringUtils.trimToNull(params.remove("ExtraArgs"));
			}
			// 增加 -Dkey=value
			if (params != null && params.size() > 0) {
				for (Entry<String, String> entry : params.entrySet()) {
					commandLine.append(entry.getKey());
					String value = entry.getValue();
					if (StringUtils.hasText(value)) {
						commandLine.append("=");
						commandLine.append(entry.getValue());
					}

					commandLine.append(" ");
				}
			}

			commandLine.append("-Dmapred.job.name=");
			commandLine.append(jobName);
			if ( extraArgs != null) {
				commandLine.append(" ");
				commandLine.append(extraArgs) ;
			}

			String command = commandLine.toString();
			AuditLog.log("Begin invoking map reduce job:" + command);

			shellService.runCommand(null, command);

			logger.info("end invoking map reduce job:" + command);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
