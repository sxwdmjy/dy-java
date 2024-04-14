package com.dyj.web.domain;

/**
 * 获取用户粉丝热评返回值
 */
public class GetFansCommentResult {

    /**
     * 热度指数
     */
    private Long hot_value;
    /**
     * 评论热词
     */
    private String keyword;

    public Long getHot_value() {
        return hot_value;
    }

    public GetFansCommentResult setHot_value(Long hot_value) {
        this.hot_value = hot_value;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public GetFansCommentResult setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }
}
