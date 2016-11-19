package com.lenovo.lps.farseer.priest2.platform.entity;

public enum DbTypeEnum {
	MySQL(1), Oracle(2);
	private Integer value;

	DbTypeEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static DbTypeEnum fromValue(Integer value) {
		if (value == 1) {
			return DbTypeEnum.MySQL;
		} else if (value == 2) {
			return DbTypeEnum.Oracle;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
