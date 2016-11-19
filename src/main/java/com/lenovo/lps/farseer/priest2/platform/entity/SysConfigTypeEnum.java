package com.lenovo.lps.farseer.priest2.platform.entity;

public enum SysConfigTypeEnum {
	HIVE(1), SPARK(2),REDIS(3),SMS(4),MAIL(5),OOZIE(6);
	private Integer value;

	SysConfigTypeEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static SysConfigTypeEnum fromValue(Integer value) {
		if (value == 1) {
			return SysConfigTypeEnum.HIVE;
		} else if (value == 2) {
			return SysConfigTypeEnum.SPARK;
		} else if (value == 3) {
			return SysConfigTypeEnum.REDIS;
		} else if (value == 4) {
			return SysConfigTypeEnum.SMS;
		} else if (value == 5) {
			return SysConfigTypeEnum.MAIL;
		} else if (value == 6) {
			return SysConfigTypeEnum.OOZIE;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
