package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;

/**
 * @author danmo
 * @date 2024-04-18 13:35
 **/
public class ImAuthStatusQuery extends UserInfoQuery {

    /**
     * C端用户的open_id
     */
    private String c_open_id;

    /**
     * C端用户open_id所在的小程序
     */
    private String app_id;

    public String getC_open_id() {
        return c_open_id;
    }

    public void setC_open_id(String c_open_id) {
        this.c_open_id = c_open_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public static ImAuthStatusQueryBuilder builder() {
        return new ImAuthStatusQueryBuilder();
    }

    public static class ImAuthStatusQueryBuilder {
        private String cOpenId;
        private String appId;
        private Integer tenantId;
        private String clientKey;
        private String openId;

        public ImAuthStatusQueryBuilder cOpenId(String cOpenId) {
            this.cOpenId = cOpenId;
            return this;
        }
        public ImAuthStatusQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public ImAuthStatusQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ImAuthStatusQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public ImAuthStatusQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public ImAuthStatusQuery build() {
            ImAuthStatusQuery imAuthStatusQuery = new ImAuthStatusQuery();
            imAuthStatusQuery.setC_open_id(cOpenId);
            imAuthStatusQuery.setApp_id(appId);
            imAuthStatusQuery.setTenantId(tenantId);
            imAuthStatusQuery.setClientKey(clientKey);
            imAuthStatusQuery.setOpen_id(openId);
            return imAuthStatusQuery;
        }

    }
}
