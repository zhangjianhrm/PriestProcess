/**
 * 
 */
package com.lenovo.lps.farseer.priest2.ext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.util.RunJar;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;

/**
 * @author hubin3
 * 
 */
public class PriestRunJar extends RunJar {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		String usage = "PriestRunJar jarFile [mainClass] appuser args...";

		if (args.length < 1) {
			System.err.println(usage);
			System.exit(-1);
		}

		int firstArg = 0;
		//主方法
		String securityType = args[firstArg++];
		if (CommUtils.isEmpty(securityType)) {
			securityType = "simple";
		}
		String configPath = args[firstArg++];
		if (CommUtils.isEmpty(configPath)) {
			configPath = "/etc/hadoop/conf";
		}
		String fileName = args[firstArg++];
		File file = new File(fileName);
		
		// 业务用户
		String appUser = args[firstArg++];
		if (appUser == null) {
			System.err.println(usage);
			System.exit(-1);
		}
		String mainClassName = null;

		JarFile jarFile;
		try {
			jarFile = new JarFile(fileName);
		} catch (IOException io) {
			throw new IOException("Error opening job jar: " + fileName).initCause(io);
		}

		Manifest manifest = jarFile.getManifest();
		if (manifest != null) {
			mainClassName = manifest.getMainAttributes().getValue("Main-Class");
		}
		jarFile.close();

		boolean getMcn = true;
		if (mainClassName == null) {
			if (args.length < 5) {
				System.err.println(usage);
				System.exit(-1);
			}
			mainClassName = args[firstArg++];
			getMcn = false;
		}
		mainClassName = mainClassName.replaceAll("/", ".");


		File tmpDir = new File(new Configuration().get("hadoop.tmp.dir"));
		ensureDirectory(tmpDir);

		final File workDir;
		try {
			workDir = File.createTempFile("hadoop-unjar", "", tmpDir);
		} catch (IOException ioe) {
			// if user has insufficient perms to write to tmpDir, default
			// "Permission denied" message doesn't specify a filename.
			System.err.println("Error creating temp dir in hadoop.tmp.dir " + tmpDir + " due to " + ioe.getMessage());
			System.exit(-1);
			return;
		}

		if (!workDir.delete()) {
			System.err.println("Delete failed for " + workDir);
			System.exit(-1);
		}
		ensureDirectory(workDir);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				FileUtil.fullyDelete(workDir);
			}
		});

		unJar(file, workDir);

		List<URL> classPath = new LinkedList<URL>();
		classPath.add(new File(workDir + "/").toURI().toURL());
		classPath.add(file.toURI().toURL());
		classPath.add(new File(workDir, "classes/").toURI().toURL());
		File[] libs = new File(workDir, "lib").listFiles();
		if (libs != null) {
			for (int i = 0; i < libs.length; i++) {
				classPath.add(libs[i].toURI().toURL());
			}
		}

		ClassLoader loader = new URLClassLoader(classPath.toArray(new URL[0]));

		Thread.currentThread().setContextClassLoader(loader);
		Class<?> mainClass = Class.forName(mainClassName, true, loader);
		final Method main = mainClass.getMethod("main", new Class[] { Array.newInstance(String.class, 0).getClass() });
		int startNum = firstArg;
		if (getMcn) {
			startNum += 1;
		}
		final String[] newArgs = Arrays.asList(args).subList(startNum, args.length).toArray(new String[0]);
		// 本进程login priest账户,获取tgt
		File hadoopConfig = new File(configPath);
		if ("kerberos".equals(securityType)) {
			HadoopUgiUtil.doAs(hadoopConfig, appUser, new PrivilegedExceptionAction<Void>() {
				@Override
				public Void run() {
					try {
						main.invoke(null, new Object[] { newArgs });
					} catch (Exception e) {
						throw new PriestPlatformException(e);
					}

					return null;
				}
			});
		} else {
			try {
				main.invoke(null, new Object[] { newArgs });
			} catch (Exception e) {
				throw new PriestPlatformException(e);
			}
		}

	}

	/**
	 * Ensure the existence of a given directory.
	 * 
	 * @throws IOException
	 *             if it cannot be created and does not already exist
	 */
	private static void ensureDirectory(File dir) throws IOException {
		if (!dir.mkdirs() && !dir.isDirectory()) {
			throw new IOException("Mkdirs failed to create " + dir.toString());
		}
	}
}
