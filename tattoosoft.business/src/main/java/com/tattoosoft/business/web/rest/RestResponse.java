package com.tattoosoft.business.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * Standard REST response message object.
 *
 * On success: - responseCode = ResponseCode.SUCCESS - data or dataMap to be
 * populated.
 *
 * On validation failure: - responseCode = ResponseCode.VALIDATION_FAILURE -
 * errorMap populated by [{attributePath => errorMsg}]
 *
 * On all other errors: - responseCode = ResponseCode.ERROR - data is null,
 * {@see AbstractRestController} will return appropriate HTTP 400-level response
 * code
 */
@Component
public class RestResponse<T> {

    public static final <T> RestResponse<T> forSuccess() {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.SUCCESS);
        response.setSuccess(true);
        return response;
    }

    public static final <T> RestResponse<T> forSuccess(Map<String, T> dataMap) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.SUCCESS);
        response.setDataMap(dataMap);
        response.setSuccess(true);
        return response;
    }

    public static final <T> RestResponse<T> forSuccess(T data) {
        HashMap<String, T> map = new HashMap<String, T>();
        map.put("data", data);
        return RestResponse.forSuccess(map);
    }

    public static final <T> RestResponse<T> forSuccess(T data, Long totalRows) {
        HashMap<String, T> map = new HashMap<String, T>();
        map.put("data", data);
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.SUCCESS);
        response.setDataMap(map);
        response.setSuccess(true);
        response.setTotalRows(totalRows);
        return response;
    }

    public static final <T> RestResponse<T> forSuccess(Map<String, T> dataMap, Long totalRows) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.SUCCESS);
        response.setDataMap(dataMap);
        response.setSuccess(true);
        response.setTotalRows(totalRows);
        return response;
    }

    public static final <T> RestResponse<List<T>> forSuccess(List<T> paged, Long totalRows) {
        HashMap map = new HashMap();
        map.put("results", paged);
        RestResponse<List<T>> response = new RestResponse<List<T>>();
        response.setResponseCode(RestResponseCode.SUCCESS);
        response.setDataMap(map);
        response.setSuccess(true);
        response.setTotalRows(totalRows);
        return response;
    }

    /**
     * Used by {@see AbstractRestController} upon validation exception.
     */
    public static final <T> RestResponse<T> forFileUploadFailure(BindingResult result) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.FILE_UPLOAD_FAILURE);
        response.setSuccess(false);
        for (ObjectError err : result.getAllErrors()) {
            response.addError(err.getCode(), err.getDefaultMessage());
        }
        return response;
    }

    /**
     * Used by {@see AbstractRestController} for any unrecoverable exception.
     */
    public static final <T> RestResponse<T> forError(String message) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.ERROR);
        response.setSuccess(false);
        response.addError("error", message);
        return response;
    }

    /**
     * Used by {@see AbstractRestController} for any unrecoverable exception.
     */
    public static final <T> RestResponse<T> forRuntimeExceptionError(RuntimeException ex) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.EXCEPTION);
        response.setSuccess(false);
        response.addError("exception", ex.getMessage());
        return response;
    }
    
    /**
     * Used by {@see AbstractRestController} for any unrecoverable exception.
     */
    public static final <T> RestResponse<T> forError(BindingResult result) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResponseCode(RestResponseCode.VALIDATION_ERROR);
        response.setSuccess(false);
        for (ObjectError err : result.getAllErrors()) {
            if (err instanceof FieldError){
                response.addError(((FieldError)err).getField(), err.getDefaultMessage());
            } else if (err instanceof ObjectError){
                response.addError(err.getObjectName(), err.getDefaultMessage());
            }
        }
        return response;
    }

    private Boolean				success		= false;
    private Integer				responseCode;
    private Map<String, String>	errorMap	= new HashMap<String, String>();
    private Map<String, T>		dataMap		= new HashMap<String, T>();
    private long				totalRows	= 0;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void addError(String string, String message) {
        errorMap.put(string, message);
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(RestResponseCode responseCode) {
        this.responseCode = responseCode.getCode();
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public Map<String, T> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, T> dataMap) {
        this.dataMap = dataMap;
    }

    public void putData(String key, T value) {
        dataMap.put(key, value);
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
    public long getTotalRows() {
        return totalRows;
    }
    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }
}
