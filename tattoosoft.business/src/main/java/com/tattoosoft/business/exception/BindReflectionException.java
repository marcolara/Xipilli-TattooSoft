package com.tattoosoft.business.exception;

/**
*
*/
@SuppressWarnings("serial")
public class BindReflectionException extends RuntimeException {

   public BindReflectionException() {
       super();
   }

   public BindReflectionException(String message) {
       super(message);
   }

   public BindReflectionException(String message, Throwable cause) {
       super(message, cause);
   }

   public BindReflectionException(Throwable cause) {
       super(cause);
   }

}
