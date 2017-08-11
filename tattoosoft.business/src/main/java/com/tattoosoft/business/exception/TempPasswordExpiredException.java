package com.tattoosoft.business.exception;

public class TempPasswordExpiredException extends BusinessException {
    private static final long serialVersionUID = 4520445567761760760L;

    public TempPasswordExpiredException(String msg) {
        super(msg);
    }

    public TempPasswordExpiredException(String msg, Throwable e) {
        super(msg, e);
    }
}
