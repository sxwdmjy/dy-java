package com.dyj.web.domain;

/**
 * 获取用户粉丝数返回值
 */
public class ExternalUserFansResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 每天新粉丝数 选填
     */
    private Long new_fans;
    /**
     * 每日总粉丝数 选填
     */
    private Long total_fans;

    public String getDate() {
        return date;
    }

    public ExternalUserFansResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getNew_fans() {
        return new_fans;
    }

    public ExternalUserFansResult setNew_fans(Long new_fans) {
        this.new_fans = new_fans;
        return this;
    }

    public Long getTotal_fans() {
        return total_fans;
    }

    public ExternalUserFansResult setTotal_fans(Long total_fans) {
        this.total_fans = total_fans;
        return this;
    }
}
