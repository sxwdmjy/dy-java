package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-10 10:59
 **/
public class CreateAppletTemplateQuery extends UserInfoQuery {
    /**
     * 模板ID，更新模板时传入
     */
    private String card_template_id;

    /**
     * 卡片类型，创建模板时必传
     * 1：小程序卡片
     */
    private Integer card_type = 1;

    /**
     * 卡片内容，创建模板时必传，最长 30 字
     */
    private String content;

    /**
     * 图片的 ID，调用图片上传接口获取。
     * 创建模板时必传
     * 推荐比例16:9，尺寸240*135
     */
    private String media_id;

    /**
     * 小程序 AppID
     */
    private String app_id;

    /**
     * 卡片标题
     * 创建模板时必传，最长 30 字
     */
    private String title;

    public String getCard_template_id() {
        return card_template_id;
    }

    public void setCard_template_id(String card_template_id) {
        this.card_template_id = card_template_id;
    }

    public Integer getCard_type() {
        return card_type;
    }

    public void setCard_type(Integer card_type) {
        this.card_type = card_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static CreateAppletTemplateQueryBuilder builder() {
        return new CreateAppletTemplateQueryBuilder();
    }

    public static class CreateAppletTemplateQueryBuilder {
        private String cardTemplateId;
        private Integer cardType;
        private String content;
        private String mediaId;
        private String appId;
        private String title;
        private Integer tenantId;
        private String clientKey;
        private String openId;

        public CreateAppletTemplateQueryBuilder cardTemplateId(String cardTemplateId) {
            this.cardTemplateId = cardTemplateId;
            return this;
        }

        public CreateAppletTemplateQueryBuilder cardType(Integer cardType) {
            this.cardType = cardType;
            return this;
        }

        public CreateAppletTemplateQueryBuilder content(String content) {
            this.content = content;
            return this;
        }

        public CreateAppletTemplateQueryBuilder mediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }

        public CreateAppletTemplateQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public CreateAppletTemplateQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CreateAppletTemplateQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CreateAppletTemplateQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CreateAppletTemplateQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public CreateAppletTemplateQuery build() {
            CreateAppletTemplateQuery createAppletTemplateQuery = new CreateAppletTemplateQuery();
            createAppletTemplateQuery.setCard_template_id(cardTemplateId);
            createAppletTemplateQuery.setCard_type(cardType);
            createAppletTemplateQuery.setContent(content);
            createAppletTemplateQuery.setMedia_id(mediaId);
            createAppletTemplateQuery.setApp_id(appId);
            createAppletTemplateQuery.setTitle(title);
            createAppletTemplateQuery.setTenantId(tenantId);
            createAppletTemplateQuery.setClientKey(clientKey);
            createAppletTemplateQuery.setOpen_id(openId);
            return createAppletTemplateQuery;
        }
    }

}
