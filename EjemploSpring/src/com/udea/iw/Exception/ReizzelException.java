package com.udea.iw.Exception;

import org.apache.log4j.Logger;

public class ReizzelException extends Exception {
	public ReizzelException() {
		// TODO Auto-generated constructor stub
	}

	public ReizzelException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReizzelException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ReizzelException(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
		// TODO Auto-generated constructor stub
	}

	public ReizzelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	Logger log= Logger.getLogger(this.getClass());
}
