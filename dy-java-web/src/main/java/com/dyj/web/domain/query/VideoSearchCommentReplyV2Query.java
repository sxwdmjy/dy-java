package com.dyj.web.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;

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

    public static VideoSearchCommentReplyV2QueryBuilder builder(){
        return new VideoSearchCommentReplyV2QueryBuilder();
    }


    public static final class VideoSearchCommentReplyV2QueryBuilder {
        private String commentId;
        private String content;
        private String secItemId;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        private VideoSearchCommentReplyV2QueryBuilder() {
        }

        public static VideoSearchCommentReplyV2QueryBuilder aVideoSearchCommentReplyV2Query() {
            return new VideoSearchCommentReplyV2QueryBuilder();
        }

        public VideoSearchCommentReplyV2QueryBuilder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        public VideoSearchCommentReplyV2QueryBuilder content(String content) {
            this.content = content;
            return this;
        }

        public VideoSearchCommentReplyV2QueryBuilder secItemId(String secItemId) {
            this.secItemId = secItemId;
            return this;
        }

        public VideoSearchCommentReplyV2QueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public VideoSearchCommentReplyV2QueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public VideoSearchCommentReplyV2QueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public VideoSearchCommentReplyV2Query build() {
            VideoSearchCommentReplyV2Query videoSearchCommentReplyV2Query = new VideoSearchCommentReplyV2Query();
            videoSearchCommentReplyV2Query.setComment_id(commentId);
            videoSearchCommentReplyV2Query.setContent(content);
            videoSearchCommentReplyV2Query.setSec_item_id(secItemId);
            videoSearchCommentReplyV2Query.setOpen_id(openId);
            videoSearchCommentReplyV2Query.setTenantId(tenantId);
            videoSearchCommentReplyV2Query.setClientKey(clientKey);
            return videoSearchCommentReplyV2Query;
        }
    }
}