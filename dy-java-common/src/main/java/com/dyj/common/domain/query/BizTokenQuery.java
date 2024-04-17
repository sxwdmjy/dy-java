package com.dyj.common.domain.query;

/**
 * @author danmo
 * @date 2024-04-17 09:53
 **/
public class BizTokenQuery {

    /**
     * 抖音开发平台接入方标识，小程序调用时填入 AppID
     */
    private String client_key;

    /**
     * 接入方密钥，可以从开发-开发配置-Webhook 页面的 Webhook Secret 位置获取。
     * 注意：不是appSecret
     */
    private String client_secret;

    /**
     * 用于指定Token所对应的用户。
     */
    private String open_id;

    /**
     * 用于指定Token所对应的能力，逗号分割。可以根据业务场景自行隔离，控制 Token 泄露风险。
     */
    private String scope;

    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public static BizTokenQueryBuilder builder() {
        return new BizTokenQueryBuilder();
    }

    public static class BizTokenQueryBuilder {
        private String clientKey;
        private String clientSecret;
        private String openId;
        private String scope;

        public BizTokenQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public BizTokenQueryBuilder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        public BizTokenQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public BizTokenQueryBuilder scope(String scope) {
            this.scope = scope;
            return this;
        }
        public BizTokenQuery build() {
            BizTokenQuery bizTokenQuery = new BizTokenQuery();
            bizTokenQuery.setClient_key(clientKey);
            bizTokenQuery.setClient_secret(clientSecret);
            bizTokenQuery.setOpen_id(openId);
            bizTokenQuery.setScope(scope);
            return bizTokenQuery;
        }
    }
}
