package com.dyj.common.domain.query;

/**
 * @author danmo
 * @date 2024-04-17 10:26
 **/
public class AppsV2TokenQuery {

    /**
     * 小程序ID
     */
    private String appid;

    /**
     * 小程序的 APP Secret，可以在开发者后台获取
     */
    private String secret;

    //获取 access_token 时值为 client_credential
    private String grant_type = "client_credential";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }


    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public static AppsV2TokenQueryBuilder builder() {
        return new AppsV2TokenQueryBuilder();
    }

    public static class AppsV2TokenQueryBuilder {
        private String appid;
        private String secret;

        public AppsV2TokenQueryBuilder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public AppsV2TokenQueryBuilder secret(String secret) {
            this.secret = secret;
            return this;
        }

        public AppsV2TokenQuery build() {
            AppsV2TokenQuery appsV2TokenQuery = new AppsV2TokenQuery();
            appsV2TokenQuery.setAppid(appid);
            appsV2TokenQuery.setSecret(secret);
            return appsV2TokenQuery;
        }
    }
}
