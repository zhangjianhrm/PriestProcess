package com.lenovo.lps.farseer.priest2.ext;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;

/**
 * This class is used to generate new Hadoop configuration instance.
 * 
 * @author longchao
 * 
 */
public class HadoopSqoopConfigFactory  {
	private static Configuration hadoopConfiguration;
	
	private static synchronized void init(File hadoopConfig) throws MalformedURLException {
		
		File classFile = new File(AuditLog.class.getProtectionDomain().getCodeSource().getLocation().getFile());
	
		List<File> configFiles = new ArrayList<File>();
		File[] listFiles = hadoopConfig.listFiles();
		for (File config: listFiles) {
			if (config.getName().endsWith("-site.xml")) {
				configFiles.add(config);
			}
		}
		
		for (File config: classFile.listFiles()) {
			if (config.getName().endsWith("-site.xml")) {
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
	
	public static Configuration getHadoopConfiguration(File hadoopConfig) throws MalformedURLException {
		copyConfigToClasspath(hadoopConfig);
		init(hadoopConfig);
		return hadoopConfiguration;
	}
	
	public static void copyConfigToClasspath(File hadoopConfig) {
		File classFile;
		String classPath = AuditLog.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		
		File[] listFiles = hadoopConfig.listFiles();
		for (File config: listFiles) {
			classFile = new File(classPath + config.getName());
			if (config.getName().endsWith("-site.xml") && !classFile.exists()) {
				AuditLog.log(String.format("copyFile configFile[%s] to classFile[%s]:", config, classFile));
				com.lenovo.lps.farseer.priest2.platform.util.FileUtils.copyFile(config, classFile);
			}
		}
	}
}
