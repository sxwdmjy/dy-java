package com.dyj.web.domain.vo;

import com.dyj.web.domain.DiscoveryEntRankItemHotSpot;

public class DiscoveryEntRankItemVo extends ListVo<DiscoveryEntRankItemHotSpot> {
    /**
     * 生成时间 选填
     */
    private String active_time;


    public String getActive_time() {
        return active_time;
    }

    public DiscoveryEntRankItemVo setActive_time(String active_time) {
        this.active_time = active_time;
        return this;
    }
}
