package com.tattoosoft.business.form.field;

public class ProfileFormField {
    private String fieldCode;
    private String value;

    public ProfileFormField(){

    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public ProfileFormField(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
