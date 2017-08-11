package com.tattoosoft.business.web.rest;

/**
 * Enum the response codes.
 */
public enum RestResponseCode {

    DEBUG(-1), SUCCESS(200), ERROR(300), VALIDATION_ERROR(301), EXCEPTION(500), FILE_UPLOAD_FAILURE(501);

    private final Integer code;

    /**
     *
     */
    private RestResponseCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getCode().toString();
    }
}
