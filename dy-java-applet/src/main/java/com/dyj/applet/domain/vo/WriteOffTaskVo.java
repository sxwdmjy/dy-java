package com.dyj.applet.domain.vo;

import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-23 14:27
 **/
public class WriteOffTaskVo extends DyResult<Object> {

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
