package com.dyj.web.domain;

/**
 * 关键词视频评论列表返回值
 */
public class VideoSearchCommentListV2Result {

    /**
     * 评论id
     */
    private String comment_id;
    /**
     * 该条评论发布者的user_id
     */
    private String comment_user_id;
    /**
     * 评论的具体内容
     */
    private String content;
    /**
     * 创建时间戳，单位为秒
     */
    private Long create_time;
    /**
     * 该评论的点赞数
     */
    private Integer digg_count;
    /**
     * 该评论的回复数量
     */
    private Integer reply_comment_total;
    /**
     * 该评论是否被置顶
     */
    private Boolean top;

    public String getComment_id() {
        return comment_id;
    }

    public VideoSearchCommentListV2Result setComment_id(String comment_id) {
        this.comment_id = comment_id;
        return this;
    }

    public String getComment_user_id() {
        return comment_user_id;
    }

    public VideoSearchCommentListV2Result setComment_user_id(String comment_user_id) {
        this.comment_user_id = comment_user_id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public VideoSearchCommentListV2Result setContent(String content) {
        this.content = content;
        return this;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public VideoSearchCommentListV2Result setCreate_time(Long create_time) {
        this.create_time = create_time;
        return this;
    }

    public Integer getDigg_count() {
        return digg_count;
    }

    public VideoSearchCommentListV2Result setDigg_count(Integer digg_count) {
        this.digg_count = digg_count;
        return this;
    }

    public Integer getReply_comment_total() {
        return reply_comment_total;
    }

    public VideoSearchCommentListV2Result setReply_comment_total(Integer reply_comment_total) {
        this.reply_comment_total = reply_comment_total;
        return this;
    }

    public Boolean getTop() {
        return top;
    }

    public VideoSearchCommentListV2Result setTop(Boolean top) {
        this.top = top;
        return this;
    }
}
