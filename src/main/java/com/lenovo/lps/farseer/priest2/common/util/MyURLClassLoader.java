package com.lenovo.lps.farseer.priest2.common.util;

import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyURLClassLoader extends URLClassLoader {

	private final static Logger logger = LoggerFactory.getLogger(MyURLClassLoader.class);

    private List<JarURLConnection> jars = new ArrayList<JarURLConnection>();

	public MyURLClassLoader() {
		super(new URL[] {}, findParentClassLoader());
	}

	public void addURLFile(URL file) {
		addURL(file);
	}
	
    public void unloadJarFiles() {
        for (JarURLConnection url : jars) {
            try {
            	logger.info("Unloading plugin JAR file " + url.getJarFile().getName());
                url.getJarFile().close();
                url=null;
            } catch (Exception e) {
            	logger.error("Failed to unload JAR file:", e);
            }
        }
    }
	
    public void unloadJarFiles(JarURLConnection url) {
            try {
            	logger.info("卸载jar包==== " + url.getJarFile().getName());
                url.getJarFile().close();
            } catch (Exception e) {
            	logger.error("卸载jar包错误====="+e);
            }
    }

	private static ClassLoader findParentClassLoader() {
		ClassLoader parent = MyURLClassLoader.class.getClassLoader();
		if (parent == null) {
			parent = ClassLoader.getSystemClassLoader();
		}
		return parent;
	}
}
