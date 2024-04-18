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

    //生成SchemaV2
    GENERATE_SCHEMA("generateSchema", "/api/apps/v1/url/generate_schema/"),
    //查询SchemaV2
    QUERY_SCHEMA("querySchema", "/api/apps/v1/url/query_schema/"),
    //查询Schema配额V2
    QUERY_SCHEMA_QUOTA("querySchemaQuota", "/api/apps/v1/url/query_schema_quota/"),
    //生成 Link V2
    GENERATE_URL_LINK("generateUrlLink", "/api/apps/v1/url_link/generate/"),
    //查询 Link 配额V2
    QUERY_QUOTA_URL_LINK("queryQuotaUrlLink", "/api/apps/v1/url_link/query_quota/"),
    //查询 Link V2
    QUERY_INFO_URL_LINK("queryInfoUrlLink", "/api/apps/v1/url_link/query_info/"),
    //生成QRCodeV2
    CREATE_QR_CODE("createQrCode", "/api/apps/v1/qrcode/create/"),

    //发送主动私信
    AUTHORIZE_SEND_MSG("authSendMsg","/im/authorize/send/msg/"),

    //查询主动私信用户授权状态
    IM_AUTHORIZE_STATUS("imAuthStatus","/im/authorize/status/"),

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
