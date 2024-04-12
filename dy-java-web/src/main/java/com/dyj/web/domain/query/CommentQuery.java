package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-10 16:46
 **/
public class CommentQuery extends UserInfoQuery{

    /**
     * 视频item_id
     */
    private String item_id;

    /**
     * 需要置顶的评论comment_id
     */
    private String comment_id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * true-置顶；false-不置顶
     */
    private Boolean top;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public static CommentQueryBuilder builder() {
        return new CommentQueryBuilder();
    }

    public static class CommentQueryBuilder {
        private String itemId;
        private String commentId;
        private String content;
        private Boolean top;
        private Integer tenantId;
        private String clientKey;
        private String open_id;

        public CommentQueryBuilder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public CommentQueryBuilder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        public CommentQueryBuilder content(String content) {
            this.content = content;
            return this;
        }

        public CommentQueryBuilder top(Boolean top) {
            this.top = top;
            return this;
        }

        public CommentQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CommentQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CommentQueryBuilder open_id(String open_id) {
            this.open_id = open_id;
            return this;
        }

        public CommentQuery build() {
            CommentQuery commentQuery = new CommentQuery();
            commentQuery.setItem_id(itemId);
            commentQuery.setComment_id(commentId);
            commentQuery.setContent(content);
            commentQuery.setTop(top);
            commentQuery.setTenantId(tenantId);
            commentQuery.setClientKey(clientKey);
            commentQuery.setOpen_id(open_id);
            return commentQuery;
        }
    }


}
