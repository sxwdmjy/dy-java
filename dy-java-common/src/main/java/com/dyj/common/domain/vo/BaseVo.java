package com.dyj.common.domain.vo;

/**
 * @author danmo
 * @date 2024-04-07 14:58
 **/
public class BaseVo {

    /**
     * 描述
     */
    protected String description;
    /**
     * 错误码
     */
    protected Integer error_code;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

}
