package com.lenovo.lps.farseer.priest2.common.entity;

import java.io.Serializable;
import java.net.URI;

/**
 * 可序列化的FileStatus实例，用于将查询结果传送回客户端进行进一步处理。
 * 
 * @author longchao
 * 
 */
public class HdfsFile implements Serializable {

	private static final long serialVersionUID = -1278527501239580174L;

	private URI path;
	private long length;
	private boolean isDir;
	private int blockReplication;
	private long blockSize;
	private long modificationTime;
	private long accessTime;
	private String owner;
	private String group;

	public HdfsFile(long length, boolean isDir, int blockReplication, long blockSize, long modificationTime, URI path,
			long accessTime, String owner, String group) {
		this.path = path;
		this.length = length;
		this.isDir = isDir;
		this.blockReplication = blockReplication;
		this.blockSize = blockSize;
		this.modificationTime = modificationTime;
		this.accessTime = accessTime;
		this.owner = owner;
		this.group = group;
	}

	public URI getPath() {
		return path;
	}

	public long getLength() {
		return length;
	}

	public boolean isDir() {
		return isDir;
	}

	public int getBlockReplication() {
		return blockReplication;
	}

	public long getBlockSize() {
		return blockSize;
	}

	public long getModificationTime() {
		return modificationTime;
	}

	public long getAccessTime() {
		return accessTime;
	}

	public String getOwner() {
		return owner;
	}

	public String getGroup() {
		return group;
	}

	@Override
	public String toString() {
		return path.toString();
	}

}
