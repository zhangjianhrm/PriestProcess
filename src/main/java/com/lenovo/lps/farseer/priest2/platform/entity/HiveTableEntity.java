package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;

/**
 * 表
 * 
 * @author clive
 * 
 */
public class HiveTableEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017498234757497185L;

	// 数据库名
	private String schemaName;
	// 表名
	private String name;
	// 别名
	private String alias;

	public HiveTableEntity(String schemaName, String name, String alias) {
		this.schemaName = schemaName;
		this.name = name;
		this.alias = alias;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		try {
			ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(byteOutStream);

			os.writeObject(this);
			os.flush();

			return new String(byteOutStream.toByteArray(), "UTF-8");
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

	}
}
