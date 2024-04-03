package com.dyj.common.domain;

/**
 * @author danmo
 * @date 2024-04-03 11:18
 **/
public class DyResult<T>{

    /**
     * 返回对象
     */
    private T data;

    private String message;
    /**
     * 错误码描述
     */
    private DyExtra extra;

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

    public DyExtra getExtra() {
        return extra;
    }

    public void setExtra(DyExtra extra) {
        this.extra = extra;
    }


    @Override
    public String toString() {
        return "DyResult{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", extra=" + extra +
                '}';
    }
}
