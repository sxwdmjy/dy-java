package com.dyj.web.domain;

import com.dyj.common.domain.vo.BaseVo;

import java.util.List;

public class StarHotResult extends BaseVo {

    /**
     * 热榜类型说明 选填
     */
    private String hot_list_description;
    /**
     * 达人热榜类型 选填
     */
    private Long hot_list_type;
    /**
     * 达人热榜更新时间戳 选填
     */
    private Long hot_list_update_timestamp;
    /**
     *  选填
     */
    private List<StarHotListData> list;

    public String getHot_list_description() {
        return hot_list_description;
    }

    public StarHotResult setHot_list_description(String hot_list_description) {
        this.hot_list_description = hot_list_description;
        return this;
    }

    public Long getHot_list_type() {
        return hot_list_type;
    }

    public StarHotResult setHot_list_type(Long hot_list_type) {
        this.hot_list_type = hot_list_type;
        return this;
    }

    public Long getHot_list_update_timestamp() {
        return hot_list_update_timestamp;
    }

    public StarHotResult setHot_list_update_timestamp(Long hot_list_update_timestamp) {
        this.hot_list_update_timestamp = hot_list_update_timestamp;
        return this;
    }

    public List<StarHotListData> getList() {
        return list;
    }

    public StarHotResult setList(List<StarHotListData> list) {
        this.list = list;
        return this;
    }
}
