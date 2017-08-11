package com.tattoosoft.business.security.exception;

import org.springframework.security.authentication.AccountStatusException;

public class AccountUnconfirmedException extends AccountStatusException {

	public AccountUnconfirmedException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public AccountUnconfirmedException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

}
