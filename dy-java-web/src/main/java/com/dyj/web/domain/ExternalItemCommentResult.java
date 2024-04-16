package com.dyj.web.domain;

/**
 * 获取视频评论数据返回值
 */
public class ExternalItemCommentResult {

    /**
     * 每日评论数
     */
    private Long comment;
    /**
     * 日期
     */
    private String date;

    public Long getComment() {
        return comment;
    }

    public ExternalItemCommentResult setComment(Long comment) {
        this.comment = comment;
        return this;
    }

    public String getDate() {
        return date;
    }

    public ExternalItemCommentResult setDate(String date) {
        this.date = date;
        return this;
    }
}
