package com.tattoosoft.business.security.exception;

import org.springframework.security.authentication.AccountStatusException;

public class AccountInactiveException extends AccountStatusException {

	public AccountInactiveException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public AccountInactiveException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

}
