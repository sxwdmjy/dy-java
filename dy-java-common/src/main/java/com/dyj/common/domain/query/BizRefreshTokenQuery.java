package com.dyj.common.domain.query;

/**
 * @author danmo
 * @date 2024-04-17 09:53
 **/
public class BizRefreshTokenQuery {

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
     * 获取经营 Token 时，一同返回的刷新 Token。
     */
    private String refresh_token;


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

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public static BizRefreshTokenQueryBuilder builder() {
        return new BizRefreshTokenQueryBuilder();
    }

    public static class BizRefreshTokenQueryBuilder {
        private String clientKey;
        private String clientSecret;
        private String refreshToken;

        public BizRefreshTokenQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public BizRefreshTokenQueryBuilder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        public BizRefreshTokenQueryBuilder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }
        public BizRefreshTokenQuery build() {
            BizRefreshTokenQuery bizRefreshTokenQuery = new BizRefreshTokenQuery();
            bizRefreshTokenQuery.setClient_key(clientKey);
            bizRefreshTokenQuery.setClient_secret(clientSecret);
            bizRefreshTokenQuery.setRefresh_token(refreshToken);
            return bizRefreshTokenQuery;
        }

    }
}
