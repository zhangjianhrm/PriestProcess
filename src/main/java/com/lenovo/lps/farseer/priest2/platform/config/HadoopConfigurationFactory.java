package com.lenovo.lps.farseer.priest2.platform.config;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.platform.util.FileUtils;

/**
 * This class is used to generate new Hadoop configuration instance.
 * 
 * @author longchao
 * 
 */
public class HadoopConfigurationFactory  {
	private static Configuration hadoopConfiguration;
	
	private static Map<String, Long> fileLastTime = new HashMap<String, Long>();
	
	private static synchronized void init() throws MalformedURLException {
		
		File classFile = new File(HadoopConfigurationFactory.class.getProtectionDomain().getCodeSource().getLocation().getFile());
	
		List<File> configFiles = new ArrayList<File>();
		File[] listFiles = FileUtils.getHadoopConfigPath().listFiles();
		for (File config: listFiles) {
			if (config.getName().endsWith("-site.xml") && (fileLastTime.get(config.getName()) == null || config.lastModified() > fileLastTime.get(config.getName()))) {
				fileLastTime.put(config.getName(), config.lastModified());
				configFiles.add(config);
			}
		}
		
		for (File config: classFile.listFiles()) {
			if (config.getName().endsWith("-site.xml") && (fileLastTime.get(config.getName()) == null || config.lastModified() > fileLastTime.get(config.getName()))) {
				fileLastTime.put(config.getName(), config.lastModified());
				configFiles.add(config);
			}
		}
		
		if (configFiles.size() > 0) {
			Configuration configuration = new Configuration(true);
			for (File config: configFiles) {
				configuration.addResource(config.toURI().toURL());
			}
			hadoopConfiguration = configuration;
		}
	}
	
	public static Configuration getHadoopConfiguration() throws MalformedURLException {
		init();
		return hadoopConfiguration;
	}
	
	
	public static void copyConfigToClasspath() {
		File classFile;
		String classPath = HadoopConfigurationFactory.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		long oldTime;
		
		File[] listFiles = FileUtils.getHadoopConfigPath().listFiles();
		for (File config: listFiles) {
			classFile = new File(classPath + config.getName());
			oldTime = fileLastTime.get(config.getName()) == null ? 0:fileLastTime.get(config.getName());
			if (config.getName().endsWith("-site.xml") && (!classFile.exists() || (classFile.exists() && config.lastModified() > oldTime))) {
				AuditLog.log(String.format("copyFile configFile[%s] to classFile[%s]:", config, classFile));
				com.lenovo.lps.farseer.priest2.platform.util.FileUtils.copyFile(config, classFile);
				fileLastTime.put(classFile.getName(), classFile.lastModified());
			}
		}
	}
}
