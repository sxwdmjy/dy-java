package com.dyj.common.enums;

public enum DyAppletUrlPathEnum {

    //BusinessToken 生成
    BUSINESS_ACCESS_TOKEN("bizAccessToken", "/oauth/business_token/"),

    //BusinessToken 刷新
    BUSINESS_ACCESS_TOKEN_REFRESH("bizTokenRefresh", "/oauth/refresh_biz_token/"),

    //经营能力当前状态查询
    BUSINESS_SCOPES("businessScopes", "/oauth/business_scopes/"),

    //getAccessToken
    APPS_V2_TOKEN("appsV2Token", "/api/apps/v2/token/"),

    //登录code2Session
    CODE_TO_SESSION("code2Session", "https://developer.toutiao.com/api/apps/v2/jscode2session"),

    ;



    private String key;
    private String value;

    DyAppletUrlPathEnum(String key, String value) {
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
        for (DyAppletUrlPathEnum e : DyAppletUrlPathEnum.values()) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }
}
