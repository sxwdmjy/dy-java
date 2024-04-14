package com.dyj.web.domain;

/**
 * 获取用户分享数返回值
 */
public class ExternalUserShareResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 新增分享 选填
     */
    private Long new_share;


    public String getDate() {
        return date;
    }

    public ExternalUserShareResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getNew_share() {
        return new_share;
    }

    public ExternalUserShareResult setNew_share(Long new_share) {
        this.new_share = new_share;
        return this;
    }
}
