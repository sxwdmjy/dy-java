package com.dyj.web.domain;

/**
 * 获取用户点赞数返回值
 */
public class ExternalUserLikeResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 新增点赞 选填
     */
    private Long new_like;

    public String getDate() {
        return date;
    }

    public ExternalUserLikeResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getNew_like() {
        return new_like;
    }

    public ExternalUserLikeResult setNew_like(Long new_like) {
        this.new_like = new_like;
        return this;
    }
}
