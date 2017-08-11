package com.tattoosoft.business.exception;

public interface ContextualException<T> {

    T getContext();
}
