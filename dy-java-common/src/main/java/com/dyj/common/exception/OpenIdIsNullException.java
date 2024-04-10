package com.dyj.common.exception;

/**
 * @author danmo
 * @date 2024-04-02 18:52
 **/
public class OpenIdIsNullException extends RuntimeException {

    protected String message;

    private Integer code = -1;

    public OpenIdIsNullException(String message) {
        this.message = message;
    }

    public OpenIdIsNullException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
