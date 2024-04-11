package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-11 14:08
 **/
public class ConfirmPostingTaskVo extends BaseVo{

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ConfirmPostingTaskVo{" +
                "result=" + result +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
