package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-11 17:35
 **/
public class MicAppDevtoolLegalVo extends BaseVo{

    private Boolean is_legal;

    public Boolean getIs_legal() {
        return is_legal;
    }

    public void setIs_legal(Boolean is_legal) {
        this.is_legal = is_legal;
    }

    @Override
    public String toString() {
        return "MicAppDevtoolLegalVo{" +
                "is_legal=" + is_legal +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
