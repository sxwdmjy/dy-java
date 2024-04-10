package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-10 11:07
 **/
public class AppletTemplateQuery extends UserInfoQuery {

    /**
     * 卡片素材ID
     */
    private String card_template_id;

    /**
     * 每页数量，不传 card_template_id 时，该值必传，最大值为 50
     */
    private Integer  count;

    /**
     * 分页游标
     */
    private Integer  cursor;

    /**
     * 卡片状态，缺省则返回所有状态的数据
     * 0：待审核
     * 1：审核通过
     * 2：审核未通过
     */
    private Integer status;

    public String getCard_template_id() {
        return card_template_id;
    }

    public void setCard_template_id(String card_template_id) {
        this.card_template_id = card_template_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCursor() {
        return cursor;
    }

    public void setCursor(Integer cursor) {
        this.cursor = cursor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static AppletTemplateQueryBuilder builder() {
        return new AppletTemplateQueryBuilder();
    }

    public static class AppletTemplateQueryBuilder {
        private String cardTemplateId;
        private Integer count;
        private Integer cursor;
        private Integer status;
        private Integer tenantId;
        private String clientKey;
        private String openId;

        public AppletTemplateQueryBuilder cardTemplateId(String cardTemplateId) {
            this.cardTemplateId = cardTemplateId;
            return this;
        }

        public AppletTemplateQueryBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public AppletTemplateQueryBuilder cursor(Integer cursor) {
            this.cursor = cursor;
            return this;
        }

        public AppletTemplateQueryBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public AppletTemplateQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public AppletTemplateQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public AppletTemplateQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public AppletTemplateQuery build() {
            AppletTemplateQuery appletTemplateQuery = new AppletTemplateQuery();
            appletTemplateQuery.setCard_template_id(cardTemplateId);
            appletTemplateQuery.setCount(count);
            appletTemplateQuery.setCursor(cursor);
            appletTemplateQuery.setStatus(status);
            appletTemplateQuery.setTenantId(tenantId);
            appletTemplateQuery.setClientKey(clientKey);
            appletTemplateQuery.setOpen_id(openId);
            return appletTemplateQuery;
        }

    }

    @Override
    public String toString() {
        return "AppletTemplateQuery{" +
                "card_template_id='" + card_template_id + '\'' +
                ", count=" + count +
                ", cursor=" + cursor +
                ", status=" + status +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
