package com.dyj.web.domain;

/**
 * 获取视频分享数据返回值
 */
public class ExternalItemShareResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 每日分享数
     */
    private Long share;

    public String getDate() {
        return date;
    }

    public ExternalItemShareResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getShare() {
        return share;
    }

    public ExternalItemShareResult setShare(Long share) {
        this.share = share;
        return this;
    }
}
