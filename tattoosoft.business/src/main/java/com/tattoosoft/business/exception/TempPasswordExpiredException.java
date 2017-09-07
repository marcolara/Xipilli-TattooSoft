package com.tattoosoft.business.exception;

import org.springframework.security.core.AuthenticationException;

public class TempPasswordExpiredException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public TempPasswordExpiredException(String msg) {
        super(msg);
    }

    public TempPasswordExpiredException(String msg, Throwable e) {
        super(msg, e);
    }
}
