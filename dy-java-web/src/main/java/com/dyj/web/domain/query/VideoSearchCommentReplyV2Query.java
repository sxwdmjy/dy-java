package com.dyj.web.domain.query;

/**
 * 关键词视频评论回复请求值
 * @author ws
 **/
public class VideoSearchCommentReplyV2Query extends UserInfoQuery {

    /**
     * 需要回复的评论id（如果需要回复的是视频不传此字段） 选填
     */
    private String comment_id;
    /**
     * content
     */
    private String content;
    /**
     * 视频搜索接口返回的加密的视频id
     */
    private String sec_item_id;

    public String getComment_id() {
        return comment_id;
    }

    public VideoSearchCommentReplyV2Query setComment_id(String comment_id) {
        this.comment_id = comment_id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public VideoSearchCommentReplyV2Query setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSec_item_id() {
        return sec_item_id;
    }

    public VideoSearchCommentReplyV2Query setSec_item_id(String sec_item_id) {
        this.sec_item_id = sec_item_id;
        return this;
    }
}