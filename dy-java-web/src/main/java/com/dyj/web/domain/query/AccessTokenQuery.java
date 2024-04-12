package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-03 11:34
 **/
public class AccessTokenQuery {

    /**
     * 应用唯一标识
     */
    private String client_key;

    /**
     * 应用唯一标识对应的密钥
     */
    private String client_secret;

    /**
     * 用户授权码
     */
    private String code;

    /**
     * 固定值"authorization_code"
     */
    private final String grant_type = "authorization_code";


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }


    public AccessTokenQuery() {
    }

    private AccessTokenQuery(AccessTokenQueryBuilder builder) {
        this.client_key = builder.client_key;
        this.client_secret = builder.client_secret;
        this.code = builder.code;
    }

    public static AccessTokenQueryBuilder builder() {
        return new AccessTokenQueryBuilder();
    }

    public static class AccessTokenQueryBuilder {
        private String client_key;
        private String client_secret;
        private String code;

        public AccessTokenQueryBuilder clientKey(String clientKey) {
            this.client_key = clientKey;
            return this;
        }

        public AccessTokenQueryBuilder clientSecret(String clientSecret) {
            this.client_secret = clientSecret;
            return this;
        }

        public AccessTokenQueryBuilder code(String code) {
            this.code = code;
            return this;
        }

        public AccessTokenQuery build() {
            return new AccessTokenQuery(this);
        }
    }

}
