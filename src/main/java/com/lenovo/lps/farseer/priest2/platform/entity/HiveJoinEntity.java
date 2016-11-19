package com.lenovo.lps.farseer.priest2.platform.entity;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;

public class HiveJoinEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5358053683063630827L;

	List<Object> joins = new ArrayList<Object>();

	public List<Object> getJoins() {
		return joins;
	}

	public void setJoins(List<Object> joins) {
		this.joins = joins;
	}

	public void setJoin(Object join) {
		this.joins.add(join);
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
