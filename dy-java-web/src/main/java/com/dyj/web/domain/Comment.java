package com.dyj.web.domain;

/**
 * @author danmo
 * @date 2024-04-10 16:58
 **/
public class Comment {

    /**
     * 评论id
     */
    private String comment_id;

    /**
     * 该评论回复的评论的评论id
     */
    private String reply_comment_id;

    /**
     * 该条评论发布者的user_id
     */
    private String comment_user_id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论创建的秒级时间戳
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
     * false-未置顶
     */
    private Boolean top;

    /**
     * 用户头像url
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nick_name;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getReply_comment_id() {
        return reply_comment_id;
    }

    public void setReply_comment_id(String reply_comment_id) {
        this.reply_comment_id = reply_comment_id;
    }

    public String getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(String comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Integer getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(Integer digg_count) {
        this.digg_count = digg_count;
    }

    public Integer getReply_comment_total() {
        return reply_comment_total;
    }

    public void setReply_comment_total(Integer reply_comment_total) {
        this.reply_comment_total = reply_comment_total;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id='" + comment_id + '\'' +
                ", reply_comment_id='" + reply_comment_id + '\'' +
                ", comment_user_id='" + comment_user_id + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", digg_count=" + digg_count +
                ", reply_comment_total=" + reply_comment_total +
                ", top=" + top +
                ", avatar='" + avatar + '\'' +
                ", nick_name='" + nick_name + '\'' +
                '}';
    }
}
