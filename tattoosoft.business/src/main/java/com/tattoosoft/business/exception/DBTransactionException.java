package com.tattoosoft.business.exception;

/**
 * DB transaction exception.
 */
@SuppressWarnings("serial")
public class DBTransactionException extends RuntimeException {

	public DBTransactionException(String msg, Throwable e) {
		super(msg, e);
	}
}