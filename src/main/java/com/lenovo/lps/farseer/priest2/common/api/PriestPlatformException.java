package com.lenovo.lps.farseer.priest2.common.api;

import java.io.Serializable;

public class PriestPlatformException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public PriestPlatformException() {
		super();
	}

	public PriestPlatformException(String message, Throwable cause) {
		super(message, cause);
	}

	public PriestPlatformException(String message) {
		super(message);
	}

	public PriestPlatformException(Throwable cause) {
		super(cause);
	}

}
