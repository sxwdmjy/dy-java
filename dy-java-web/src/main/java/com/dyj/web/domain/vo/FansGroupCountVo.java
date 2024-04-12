package com.dyj.web.domain.vo;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-09 11:16
 **/
public class FansGroupCountVo extends DyResult<BaseVo> {

    /**
     * 剩余建群数
     */
    private Integer left_count;

    public Integer getLeft_count() {
        return left_count;
    }

    public void setLeft_count(Integer left_count) {
        this.left_count = left_count;
    }
}
