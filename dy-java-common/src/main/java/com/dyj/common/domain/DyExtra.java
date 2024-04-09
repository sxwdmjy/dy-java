package com.dyj.common.domain;

/**
 * @author danmo
 * @date 2024-04-03 11:19
 **/
public class DyExtra {

    private String description;
    private String error_code;

    private String logid;
    private Long now;
    private String sub_description;
    private Integer sub_error_code;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }

    public Integer getSub_error_code() {
        return sub_error_code;
    }

    public void setSub_error_code(Integer sub_error_code) {
        this.sub_error_code = sub_error_code;
    }

    @Override
    public String toString() {
        return "DyExtra{" +
                "description='" + description + '\'' +
                ", error_code='" + error_code + '\'' +
                ", logid='" + logid + '\'' +
                ", now=" + now +
                ", sub_description='" + sub_description + '\'' +
                ", sub_error_code=" + sub_error_code +
                '}';
    }
}
