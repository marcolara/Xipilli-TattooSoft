package com.tattoosoft.business.exception;

@SuppressWarnings("serial")
public abstract class AbstractContextualException extends RuntimeException {

	protected Object context;

	public AbstractContextualException(Object context) {
		super();
		this.context = context;
	}

	public AbstractContextualException(Object context, String message) {
		super(message);
		this.context = context;
	}

	public AbstractContextualException(Object context, String message,
			Throwable cause) {
		super(message, cause);
		this.context = context;
	}

	public AbstractContextualException(Object context, Throwable cause) {
		super(cause);
		this.context = context;
	}

}
