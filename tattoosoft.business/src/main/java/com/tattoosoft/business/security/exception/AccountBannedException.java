package com.tattoosoft.business.security.exception;

import org.springframework.security.authentication.AccountStatusException;

public class AccountBannedException extends AccountStatusException {

	public AccountBannedException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public AccountBannedException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

}
