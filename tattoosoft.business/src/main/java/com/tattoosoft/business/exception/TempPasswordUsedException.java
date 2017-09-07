package com.tattoosoft.business.exception;

import org.springframework.security.core.AuthenticationException;

public class TempPasswordUsedException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public TempPasswordUsedException(String msg) {
		super(msg);
	}

	public TempPasswordUsedException(String msg, Throwable e) {
		super(msg, e);
	}
}
