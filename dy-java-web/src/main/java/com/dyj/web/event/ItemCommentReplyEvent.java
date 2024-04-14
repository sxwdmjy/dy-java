package com.dyj.web.event;

/**
 * item.comment
 * 接收评论回复事件
 */
public class ItemCommentReplyEvent {

    /**
     * 评论id
     */
    private String comment_id;
    /**
     * 发评论的用户openid
     */
    private String comment_user_id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论创建时间（秒级时间戳）
     */
    private Long create_time;
    /**
     * 该评论的点赞量
     */
    private Integer digg_count;
    /**
     * 该评论下的回复评论量
     */
    private Integer reply_comment_total;
    /**
     * 该评论回复的上一级评论的评论id
     */
    private String reply_to_comment_id;
    /**
     * 该评论回复的视频id
     */
    private String reply_to_item_id;
    /**
     * 评论@的用户uid
     */
    private String at_user_id;
    /**
     * 评论发送方的头像
     */
    private String avatar;
    /**
     * 评论发送方的昵称
     */
    private String nick_name;
    /**
     * 二级评论和三级评论的parentId是所属的一级评论id，一级评论parentId为""
     */
    private String parent_id;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
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

    public String getReply_to_comment_id() {
        return reply_to_comment_id;
    }

    public void setReply_to_comment_id(String reply_to_comment_id) {
        this.reply_to_comment_id = reply_to_comment_id;
    }

    public String getReply_to_item_id() {
        return reply_to_item_id;
    }

    public void setReply_to_item_id(String reply_to_item_id) {
        this.reply_to_item_id = reply_to_item_id;
    }

    public String getAt_user_id() {
        return at_user_id;
    }

    public void setAt_user_id(String at_user_id) {
        this.at_user_id = at_user_id;
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

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }
}
