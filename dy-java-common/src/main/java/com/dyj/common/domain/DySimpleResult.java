package com.dyj.common.domain;

/**
 * @author danmo
 * @date 2024-04-09 11:30
 **/
public class DySimpleResult <T>{

    private String err_msg;

    private String err_tips;

    private Integer err_no;

    private String log_id;

    private T data;

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public Integer getErr_no() {
        return err_no;
    }

    public void setErr_no(Integer err_no) {
        this.err_no = err_no;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getErr_tips() {
        return err_tips;
    }

    public void setErr_tips(String err_tips) {
        this.err_tips = err_tips;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "err_msg='" + err_msg + '\'' +
                ", err_no=" + err_no +
                ", log_id='" + log_id + '\'' +
                ", err_tips='" + err_tips + '\'' +
                ", data=" + data +
                '}';
    }
}
