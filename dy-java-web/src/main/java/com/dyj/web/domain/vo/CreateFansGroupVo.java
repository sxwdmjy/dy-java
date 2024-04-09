package com.dyj.web.domain.vo;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-09 10:17
 **/
public class CreateFansGroupVo extends DyResult<BaseVo> {

    /**
     * 群组ID
     */
    private String group_id;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
