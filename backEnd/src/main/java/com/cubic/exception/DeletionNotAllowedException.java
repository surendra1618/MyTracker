package com.cubic.exception;

public class DeletionNotAllowedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeletionNotAllowedException() {
		// TODO Auto-generated constructor stub
	}

	public DeletionNotAllowedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeletionNotAllowedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DeletionNotAllowedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeletionNotAllowedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
