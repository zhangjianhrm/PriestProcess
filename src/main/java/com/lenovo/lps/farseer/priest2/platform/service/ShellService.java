package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;

public interface ShellService {
	/**
	 * 执行shell 命令
	 * 
	 * @param commandFile
	 *            从用户上传的 shell文件路径，为空时执行操作系统命令
	 * @param commandArgs
	 *            运行shell时的参数
	 * @return
	 */
	public String runCommand(String commandFile, String commandArgs) throws IOException, InterruptedException;
}
