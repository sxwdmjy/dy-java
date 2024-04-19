package com.dyj.common.enums;

public enum DyAppletUrlPathEnum {

    T_T_DOMAIN("ttDomain","https://developer.toutiao.com"),

    //BusinessToken 生成
    BUSINESS_ACCESS_TOKEN("bizAccessToken", "/oauth/business_token/"),

    //BusinessToken 刷新
    BUSINESS_ACCESS_TOKEN_REFRESH("bizTokenRefresh", "/oauth/refresh_biz_token/"),

    //经营能力当前状态查询
    BUSINESS_SCOPES("businessScopes", "/oauth/business_scopes/"),

    //getAccessToken
    APPS_V2_TOKEN("appsV2Token", "/api/apps/v2/token/"),

    //登录code2Session
    CODE_TO_SESSION("code2Session", "/api/apps/v2/jscode2session"),

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

    //创建线索组件
    CREATE_CLUE_COMPONENT("createClueComponent","/api/apps/v1/capacity/create_clue_component_info"),

    //查询已创建的线索组件
    QUERY_CLUE_COMPONENT("queryClueComponent","/api/apps/v1/capacity/query_clue_component_info"),
    //更新线索组件
    UPDATE_CLUE_COMPONENT("updateClueComponent","/api/apps/v1/capacity/update_clue_component_info"),
    //删除线索组件
    DELETE_CLUE_COMPONENT("deleteClueComponent","/api/apps/v1/capacity/delete_clue_component_info"),

    //查询特定视频的视频数据
    QUERY_VIDEO_LIST("queryAptVideoList", "/api/apps/v1/video/query/"),

    //查询特定视频的视频数据(经营授权)
    QUERY_BIZ_VIDEO_LIST("queryBizVideoList", "/api/apps/v1/video_bc/query/"),
    //获取视频基础数据
    GET_ITEM_BASE_INFO("getItemBaseInfo", "/api/apps/v1/item/get_base/"),
    //获取视频基础数据（经营授权）
    GET_ITEM_BIZ_BASE_INFO("getItemBizBaseInfo", "/api/apps/v1/item_bc/get_base/"),
    //获取视频点赞数据
    GET_ITEM_LIKE_INFO("getItemLikeInfo", "/api/apps/v1/item/get_like/"),
    //获取视频点赞数据（经营授权）
    GET_ITEM_BIZ_LIKE_INFO("getItemBizLikeInfo", "/api/apps/v1/item_bc/get_like/"),

    //获取视频评论数据
    GET_ITEM_COMMENT_INFO("getItemComment", "/api/apps/v1/item/get_comment/"),
    //获取视频评论数据（经营授权）
    GET_ITEM_BIZ_COMMENT_INFO("getItemBizComment", "/api/apps/v1/item_bc/get_comment/"),

    //获取视频播放数据
    GET_ITEM_PLAY_INFO("getItemPlay", "/api/apps/v1/item/get_play/"),

    //获取视频播放数据（经营授权）
    GET_ITEM_BIZ_PLAY_INFO("getItemBizPlay", "/api/apps/v1/item_bc/get_play/"),

    //获取视频分享数据
    GET_ITEM_SHARE_INFO("getItemShare", "/api/apps/v1/item/get_share/"),

    //获取视频分享数据（经营授权）
    GET_ITEM_BIZ_SHARE_INFO("getItemBizShare", "/api/apps/v1/item_bc/get_share/"),
    //置顶评论
    TOP_COMMENT("topComment","/api/apps/v1/item/top_comment/"),
    //评论列表
    COMMENT_LIST("commentList","/api/apps/v1/item/list_comment/"),
    //评论回复列表
    COMMENT_REPLY_LIST("commentReplyList","/api/apps/v1/item/list_comment_reply/"),
    //回复视频评论
    REPLY_COMMENT("replyComment","/api/apps/v1/item/reply_comment/"),
    //videoid转换itemid
    VIDEO_ID_TO_OPEN_ITEM_ID("videoId2itemId","/api/apps/v1/convert_video_id/video_id_to_open_item_id/"),
    //itemid转换encryptid
    ITEM_ID_TO_ENCRYPT_ID("itemId2encryptId","/api/apps/v1/convert_video_id/open_item_id_to_encrypt_id/"),

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
