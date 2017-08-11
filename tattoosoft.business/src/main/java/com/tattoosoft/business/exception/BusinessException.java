/**
 *
 */
package com.tattoosoft.business.exception;

/**
 * @author mlara
 *
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    public BusinessException(String arg0) {
	super(arg0);
    }

    public BusinessException(Throwable arg0) {
	super(arg0);
    }

    public BusinessException(String arg0, Throwable arg1) {
	super(arg0, arg1);
    }

}
