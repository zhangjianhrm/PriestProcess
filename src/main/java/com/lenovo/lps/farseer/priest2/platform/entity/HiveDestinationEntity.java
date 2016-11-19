package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;

/**
 * insert 目的地
 * 
 * @author clive
 * 
 */
public class HiveDestinationEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6805687806897619856L;

	private String destType;
	private String fileLocation;
	private String tableName;
	private String partion;

	public String getDestType() {
		return destType;
	}

	public void setDestType(String destType) {
		this.destType = destType;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPartion() {
		return partion;
	}

	public void setPartion(String partion) {
		this.partion = partion;
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
