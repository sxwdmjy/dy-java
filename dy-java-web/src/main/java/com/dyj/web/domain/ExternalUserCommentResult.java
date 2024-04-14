package com.dyj.web.domain;

/**
 * 获取用户评论数返回值
 */
public class ExternalUserCommentResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 新增评论 选填
     */
    private Long new_comment;

    public String getDate() {
        return date;
    }

    public ExternalUserCommentResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getNew_comment() {
        return new_comment;
    }

    public ExternalUserCommentResult setNew_comment(Long new_comment) {
        this.new_comment = new_comment;
        return this;
    }
}
