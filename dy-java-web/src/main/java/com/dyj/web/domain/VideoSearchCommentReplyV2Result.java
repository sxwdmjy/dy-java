package com.dyj.web.domain;

/**
 * 关键词视频评论回复返回值
 * @author ws
 **/
public class VideoSearchCommentReplyV2Result {

    /**
     * 评论id 选填
     */
    private String comment_id;

    public String getComment_id() {
        return comment_id;
    }

    public VideoSearchCommentReplyV2Result setComment_id(String comment_id) {
        this.comment_id = comment_id;
        return this;
    }
}
