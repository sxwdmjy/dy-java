package com.dyj.applet.domain.vo;

/**
 * @author danmo
 * @date 2024-04-17 14:00
 **/
public class QueryUrlLinkQuotaVo {
    /**
     * url_link 生成次数上限
     */
    private Integer url_link_limit;
    /**
     * url_link 已生成次数
     */
    private Integer url_link_used;

    public Integer getUrl_link_limit() {
        return url_link_limit;
    }

    public void setUrl_link_limit(Integer url_link_limit) {
        this.url_link_limit = url_link_limit;
    }

    public Integer getUrl_link_used() {
        return url_link_used;
    }

    public void setUrl_link_used(Integer url_link_used) {
        this.url_link_used = url_link_used;
    }
}
