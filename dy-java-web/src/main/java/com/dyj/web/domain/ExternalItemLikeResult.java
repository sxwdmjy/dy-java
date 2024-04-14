package com.dyj.web.domain;

/**
 * 获取视频点赞数据返回值
 */
public class ExternalItemLikeResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 每日点赞数
     */
    private Long like;

    public String getDate() {
        return date;
    }

    public ExternalItemLikeResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getLike() {
        return like;
    }

    public ExternalItemLikeResult setLike(Long like) {
        this.like = like;
        return this;
    }
}
