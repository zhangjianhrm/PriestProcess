package com.lenovo.lps.farseer.priest2.platform.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.components.WorkSession;
import com.lenovo.lps.farseer.priest2.platform.service.ShellService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;

public class ShellServiceImpl implements ShellService {
	private final Logger logger = Logger.getLogger(ShellServiceImpl.class);
	// 是否是windows标记
	private final boolean isWindows = System.getProperty("os.name").indexOf("Windows") > -1;

	@Override
	public String runCommand(String commandFile, String commandArgs) throws IOException, InterruptedException {
		String[] args = commandArgs != null ? commandArgs.split("\\s") : null;
		int argc = args == null ? 0 : args.length;

		String[] commands;
		// 用户上传脚本文件,构造运行命令格式: xx.sh param1,param2
		if (StringUtils.hasText(commandFile)) {
			commands = buildCmdSyntax(commandFile, args, argc);
		}
		// 用户运行OS命令
		else {
			commands = execCmd(args, argc);
		}

		Process process = null;

		// 获取fork子进程返回码 0正常返回:非0,异常返回
		int exitCode = 0;
		final StringBuilder error = new StringBuilder();
		StringBuilder out = new StringBuilder();

		ProcessBuilder processBuilder = new ProcessBuilder(commands);
		// set priest params to this sub process .
		Map<String, String> env = processBuilder.environment() ;
		Map<String,String > runinfo = WorkSession.get().getRuntimeInfo() ;
		for ( String key : runinfo.keySet()) {
			env.put(Constants.PRIEST_PARAM_PRIFIX+ key, runinfo.get(key));
		}
				
		// 执行shell命令
		process = processBuilder.start();

		final BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
		BufferedReader inReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));

		// 异常信息获取
		// read error and input streams as this would free up the buffers
		// free the error stream buffer
		Thread errThread = new Thread() {
			@Override
			public void run() {
				try {
					String line = errReader.readLine();
					while ((line != null) && !isInterrupted()) {
						error.append(line);
						error.append(System.getProperty("line.separator"));
						line = errReader.readLine();
					}
				} catch (IOException ioe) {
					logger.warn("Error reading the error stream", ioe);
				}
			}
		};
		try {
			errThread.start();
		} catch (IllegalStateException ise) {
		}

		try {
			// 正常完成获取返回值
			char[] buf = new char[512];
			int nRead;
			while ((nRead = inReader.read(buf, 0, buf.length)) > 0) {
				out.append(buf, 0, nRead);
			}

			String line = inReader.readLine();
			// 必须用while,防止jvm 在某些OS下,有限的stream buffer满时,stream.write()
			// deadlock,致使process.waitFor()不能够返回
			while (line != null) {
				line = inReader.readLine();
			}

			if (out.length() > 0) {
				logger.info("Executor shell command std out:" + out);
			}
			// 获取fork子进程返回码
			exitCode = process.waitFor();

			try {
				// make sure that the error thread exits
				errThread.join();
			} catch (InterruptedException ie) {
				logger.warn("Interrupted while reading the error stream", ie);
			}

			if (error.length() > 0) {
				logger.error("Executor shell command error:" + error);
			}
		} catch (InterruptedException e) {
			throw e;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		} finally {
			cleanEnv(process, errReader, inReader);
		}

		// 出错时报错
		if (exitCode != 0) {
			throw new PriestPlatformException("Executor shell command error,return code:" + exitCode + " msg:"
					+ (error.length() > 0 ? error.toString() : out.toString()));
		} else {
			if (out.length() > 0) {
				long datasize = WorkSession.get().getMaxResultDatasize();
				if ( datasize > 0 && out.length() > datasize ){
					throw new IOException("output content length " + out.length() + " more than system configured "+ datasize);
				}
				String lineSeprator = System.getProperty("line.separator");
				String result = out.toString();

				if (result.endsWith(lineSeprator)) {
					result = out.substring(0, out.length() - lineSeprator.length());
				}
				
				return result;
			} else {
				return "";
			}
		}

	}

	private void cleanEnv(Process process, BufferedReader errReader, BufferedReader inReader) {
		if (process != null) {
			process.destroy();
		}

		if (errReader != null) {
			IOUtils.closeQuietly(errReader);
		}

		if (inReader != null) {
			IOUtils.closeQuietly(inReader);
		}
	}

	private String[] execCmd(String[] args, int argc) {
		String[] commands;
		// windows 命令行运行 cmd /C 命令及参数
		if (isWindows) {
			commands = new String[argc + 2];
			commands[0] = "cmd";
			commands[1] = "/C";
		}
		// *nix命令行
		else {
			commands = new String[argc];
		}

		if (argc > 0) {
			System.arraycopy(args, 0, commands, isWindows ? 2 : 0, argc);
		}
		return commands;
	}

	private String[] buildCmdSyntax(String commandFile, String[] args, int argc) {
		String[] commands;
		// 文件存在性检查
		File shell = new File(commandFile);
		Assert.isTrue(shell.exists(), "The shell file doesn't exists:" + commandFile);

		// 设置脚本执行权限
		if (!shell.canExecute()) {
			shell.setExecutable(true);
		}

		// windows 命令行运行 cmd /C 命令及参数
		if (isWindows) {
			commands = new String[argc + 3];
			commands[0] = "cmd";
			commands[1] = "/C";
			commands[2] = commandFile;

		}
		// *nix命令行运行 命令及参数
		else {
			commands = new String[argc + 1];
			commands[0] = commandFile;
		}

		// 构造运行命令格式: xx.sh param1,param2
		if (argc > 0) {
			System.arraycopy(args, 0, commands, isWindows ? 3 : 1, argc);
		}
		return commands;
	}
}
