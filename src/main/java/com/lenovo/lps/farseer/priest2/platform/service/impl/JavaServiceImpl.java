package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.platform.service.JavaService;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;

/**
 * 
 * @author niexm1
 * 
 */
public class JavaServiceImpl implements JavaService {
	private static Logger logger = Logger.getLogger(JavaServiceImpl.class);

	@Resource
	private ShellService shellService;
	
	@Override
	public void runJavaMethod(String jarOrClassFile, String className, String methodName, String args, String appUser) {
		try {
			Assert.isTrue(StringUtils.hasText(jarOrClassFile) || StringUtils.hasText(args), "Please enter the .jar or .class file and the parameters");
			StringBuffer commandLine = new StringBuffer();
			commandLine.append(ConfigUtil.getContextProperty("java.path", "/var/lib/priest/jdk1.7.0_67-cloudera/bin/java"));
			
			commandLine.append(" -DUSER.KERBEROS.REALM=");
			commandLine.append(ConfigUtil.getContextProperty("realm.krb", "@AVATAR.LENOVOMM.COM"));
			commandLine.append(" -classpath ");
			commandLine.append(com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getJarPathForClass(JavaServiceImpl.class));
			List<String> runtimeClassPath = com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getAllLibClassPath();
			for (String path: runtimeClassPath) {
				if (CommUtils.isNotEmpty(path)) {
					commandLine.append(File.pathSeparator);
					commandLine.append(path);
				}
			}
			
			commandLine.append(" ");
	
			// modified by niexm 2014/1/9. 在PriestRunJar实现 新process中login
			commandLine.append("com.lenovo.lps.farseer.priest2.ext.JavaRunJar");
			commandLine.append(" ");
			commandLine.append(jarOrClassFile);
			commandLine.append(" ");
			// mainClass为可选,为null时需改为空字符
			commandLine.append(className == null ? "" : className);
			commandLine.append(" ");
			
			// mainClass为可选,为null时需改为空字符
			commandLine.append(methodName == null ? "" : methodName);
			commandLine.append(" ");
			
			commandLine.append(" ");
			commandLine.append(ConfigUtil.getContextProperty("hadoop.security.authentication", "simple").toLowerCase());
			
			commandLine.append(" ");
			commandLine.append(com.lenovo.lps.farseer.priest2.platform.util.FileUtils.getHadoopConfigPath().getAbsolutePath());
			
			commandLine.append(appUser);
			commandLine.append(" ");
			
			// 前端属性传过来形式为:key1=value1\nkey2=value2\n
			Map<String, String> map = new LinkedHashMap<String, String>();
			if (StringUtils.hasText(args)) {
				String[] props = args.split("\n");
				// key=value
				for (String prop : props) {
					int index = prop.indexOf("=");
					String key = prop.substring(0, index);
					String value = prop.substring(index + 1);
					map.put(key, value);
				}
			}
			
			// 增加 -Dkey=value
			if (map != null && map.size() > 0) {
				for (Entry<String, String> entry : map.entrySet()) {
					commandLine.append(entry.getKey());
					String value = entry.getValue();
					if (StringUtils.hasText(value)) {
						commandLine.append("=");
						commandLine.append(entry.getValue());
					}
	
					commandLine.append(" ");
				}
			}
	
			String command = commandLine.toString();
			AuditLog.log("Begin run jar:" + command);
			shellService.runCommand(null, command);
			logger.info("end run jar::" + command);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
}
