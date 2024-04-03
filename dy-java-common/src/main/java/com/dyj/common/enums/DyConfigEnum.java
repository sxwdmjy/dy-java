package com.dyj.common.enums;

public enum DyConfigEnum {

    /**
     * 域名
     */
    DOMAIN("domain","https://open.douyin.com"),

    /**
     * 获取 access_token
     */
    OAUTH_ACCESS_TOKEN("oauthAccessToken","/oauth/access_token"),

    /**
     * 刷新 access_token
     */
    REFRESH_TOKEN("oauthRefreshToken","/oauth/renew_refresh_token"),

    /**
     * 获取 client_token
     */
    CLIENT_TOKEN("oauthClientToken","/oauth/client_token"),

    /**
     * 刷新 access_token
     */
    REFRESH_ACCESS_TOKEN("accessTokenRefresh","/oauth/refresh_token"),



    ;



    private String key;
    private String value;

    DyConfigEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public static String getValueByKey(String key) {
        for (DyConfigEnum e : DyConfigEnum.values()) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }
}
