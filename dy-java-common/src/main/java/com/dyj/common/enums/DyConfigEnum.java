package com.dyj.common.enums;

public enum DyConfigEnum {

    /**
     * 域名
     */
    DOMAIN("domain", "https://open.douyin.com"),

    /**
     * 获取 access_token
     */
    OAUTH_ACCESS_TOKEN("oauthAccessToken", "/oauth/access_token"),

    /**
     * 刷新 access_token
     */
    REFRESH_TOKEN("oauthRefreshToken", "/oauth/renew_refresh_token"),

    /**
     * 获取 client_token
     */
    CLIENT_TOKEN("oauthClientToken", "/oauth/client_token"),

    /**
     * 刷新 access_token
     */
    REFRESH_ACCESS_TOKEN("accessTokenRefresh", "/oauth/refresh_token"),

    /**
     * 用户信息
     */
    USER_INFO("userInfo", "/oauth/userinfo"),
    /**
     * 粉丝判断
     */
    FANS_CHECK("checkFans", "/fans/check/"),

    /**
     * 用户经营身份管理
     */
    USER_ROLE_CHECK("userRoleCheck", "/api/douyin/v1/role/check"),

    /**
     * 创建图文
     */
    CREATE_IMAGE_TEXT("createImageText", "/api/douyin/v1/video/create_image_text"),

    /**
     * 上传图片
     */
    UPLOAD_IMAGE("uploadImage", "/api/douyin/v1/video/upload_image"),

    /**
     * 上传视频
     */
    UPLOAD_VIDEO("uploadVideo", "/api/douyin/v1/video/upload_video"),

    /**
     * 创建视频
     */
    CREATE_VIDEO("createVideo", "/api/douyin/v1/video/create_video"),

    /**
     * 分片上传完成
     */
    COMPLETE_VIDEO_PART_UPLOAD("completeVideoPartUpload", "/api/douyin/v1/video/complete_video_part_upload"),


    /**
     * 分片上传
     */
    UPLOAD_VIDEO_PART("uploadVideoPart", "/api/douyin/v1/video/upload_video_part"),


    /**
     * 分片上传初始化
     */
    Initialize_Video_Part_Upload("initializeVideoPartUpload", "/api/douyin/v1/video/init_video_part_upload"),


    /**
     * 查询授权账号视频列表
     */
    QUERY_VIDEO_LIST("queryVideoList", "/api/douyin/v1/video/init_video_part_upload"),


    /**
     * 查询特定视频的视频数据
     */
    QUERY_VIDEO_DATA("queryVideoData", "/api/douyin/v1/video/video_data"),

    /**
     * 查询视频发布结果
     */
    QUERY_VIDEO_PUBLISH_RESULT("queryVideoPublishResult", "/share-id"),

    /**
     * 查询视频携带的地点信息
     */
    QUERY_VIDEO_LOCATION("queryVideoLocation", "/poi/search/keyword"),

    /**
     * 通过VideoID获取IFrame代码
     */
    QUERY_VIDEO_IFRAME("queryVideoIframe", "/api/douyin/v1/video/get_iframe_by_video"),

    /**
     * 通过ItemID获取IFrame代码
     */
    QUERY_VIDEO_IFRAME_BY_ITEM("queryVideoIframeByItem", "/api/douyin/v1/video/get_iframe_by_item"),


    /**
     * 发送私信消息
     */
    SEND_MESSAGE("sendMessage", "/im/send/msg"),

    /**
     * 查询授权主动私信用户
     */
    QUERY_AUTHORIZE_USER_LIST("queryAuthorizeUserList", "/im/authorize/user_list"),

    /**
     * 私信消息撤回
     */
    REVOKE_MESSAGE("revokeMessage", "/im/recall/msg"),

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
