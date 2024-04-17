package com.dyj.applet.domain.query;

/**
 * @author danmo
 * @date 2024-04-17 10:55
 **/
public class Code2SessionQuery {

    /**
     * 小程序 ID
     */
    private String appid;

    /**
     * 小程序的 APP Secret，可以在开发者后台获取
     */
    private String secret;

    /**
     * login 接口返回的登录凭证
     */
    private String code;

    /**
     * login 接口返回的匿名登录凭
     */
    private String anonymous_code;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAnonymous_code() {
        return anonymous_code;
    }

    public void setAnonymous_code(String anonymous_code) {
        this.anonymous_code = anonymous_code;
    }

    public static Code2SessionBuilder builder() {
        return new Code2SessionBuilder();
    }

    public static class Code2SessionBuilder {

        private String appid;
        private String secret;

        private String code;
        private String anonymousCode;

        public Code2SessionBuilder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public Code2SessionBuilder secret(String secret) {
            this.secret = secret;
            return this;
        }

        public Code2SessionBuilder code(String code) {
            this.code = code;
            return this;
        }

        public Code2SessionBuilder anonymousCode(String anonymousCode) {
            this.anonymousCode = anonymousCode;
            return this;
        }

        public Code2SessionQuery build() {
            Code2SessionQuery query = new Code2SessionQuery();
            query.setAppid(appid);
            query.setSecret(secret);
            query.setCode(code);
            query.setAnonymous_code(anonymousCode);
            return query;
        }
    }
}
