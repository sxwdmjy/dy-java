package com.dyj.common.domain;

/**
 * @author danmo
 * @date 2024-04-03 11:18
 **/
public class DyAppletResult<T> {

    /**
     * 返回对象
     */
    private T data;

    private String message;
    /**
     * 错误码
     */
    private Integer error_code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }
}
