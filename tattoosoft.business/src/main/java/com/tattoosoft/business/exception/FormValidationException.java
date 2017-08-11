package com.tattoosoft.business.exception;

import com.tattoosoft.business.web.rest.RestResponse;

public class FormValidationException extends AbstractContextualException implements ContextualException<RestResponse>{
	public FormValidationException(RestResponse response) {
		super(response);
	}

	public FormValidationException(RestResponse response, Throwable cause) {
		super(response, cause);
	}

	public RestResponse getContext() {
		return (RestResponse) context;
	}
}
