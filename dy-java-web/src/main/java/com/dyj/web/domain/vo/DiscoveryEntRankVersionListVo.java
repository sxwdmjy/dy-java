package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.DiscoveryEntRankVersion;

import java.util.List;

public class DiscoveryEntRankVersionListVo extends BaseVo {

    /**
     * 用于下一页请求的cursor 选填
     */
    private Long cursor;

    /**
     *  选填
     */
    private Boolean has_more;
    /**
     * 榜单版本列表 选填
     */
    private List<DiscoveryEntRankVersion> list;

    public Long getCursor() {
        return cursor;
    }

    public DiscoveryEntRankVersionListVo setCursor(Long cursor) {
        this.cursor = cursor;
        return this;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public DiscoveryEntRankVersionListVo setHas_more(Boolean has_more) {
        this.has_more = has_more;
        return this;
    }

    public List<DiscoveryEntRankVersion> getList() {
        return list;
    }

    public DiscoveryEntRankVersionListVo setList(List<DiscoveryEntRankVersion> list) {
        this.list = list;
        return this;
    }
}
