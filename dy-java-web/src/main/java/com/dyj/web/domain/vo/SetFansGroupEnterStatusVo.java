package com.dyj.web.domain.vo;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-09 10:27
 **/
public class SetFansGroupEnterStatusVo extends DyResult<BaseVo> {

    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
