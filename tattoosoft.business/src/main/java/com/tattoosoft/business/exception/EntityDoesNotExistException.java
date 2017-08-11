package com.tattoosoft.business.exception;

/**
 * Thrown when entity doesn't exist in db.
 */
@SuppressWarnings("serial")
public class EntityDoesNotExistException extends BusinessException {

    public EntityDoesNotExistException(String msg) {
        super(msg);
    }

    public EntityDoesNotExistException(String msg, Throwable e) {
        super(msg, e);
    }

}
