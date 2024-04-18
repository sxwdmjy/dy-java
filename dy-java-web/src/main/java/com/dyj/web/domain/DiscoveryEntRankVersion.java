package com.dyj.web.domain;

/**
 * 获取抖音影视综榜单版本
 */
public class DiscoveryEntRankVersion {

    /**
     * 榜单生成时间 选填
     */
    private String active_time;
    /**
     * 榜单结束时间 选填
     */
    private String end_time;
    /**
     * 榜单起始时间 选填
     */
    private String start_time;
    /**
     * 类型：1=电影 2=电视剧 3=综艺 选填
     */
    private Long type;
    /**
     * 榜单版本 选填
     */
    private Long version;

    public String getActive_time() {
        return active_time;
    }

    public DiscoveryEntRankVersion setActive_time(String active_time) {
        this.active_time = active_time;
        return this;
    }

    public String getEnd_time() {
        return end_time;
    }

    public DiscoveryEntRankVersion setEnd_time(String end_time) {
        this.end_time = end_time;
        return this;
    }

    public String getStart_time() {
        return start_time;
    }

    public DiscoveryEntRankVersion setStart_time(String start_time) {
        this.start_time = start_time;
        return this;
    }

    public Long getType() {
        return type;
    }

    public DiscoveryEntRankVersion setType(Long type) {
        this.type = type;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public DiscoveryEntRankVersion setVersion(Long version) {
        this.version = version;
        return this;
    }
}
