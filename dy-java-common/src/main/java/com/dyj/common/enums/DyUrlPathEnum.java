package com.dyj.common.enums;

public enum DyUrlPathEnum {

    /**
     * 域名
     */
    DOMAIN("domain", "https://open.douyin.com"),

    /**
     * 获取 access_token
     */
    OAUTH_ACCESS_TOKEN("oauthAccessToken", "/oauth/access_token/"),

    /**
     * 刷新 access_token
     */
    REFRESH_TOKEN("oauthRefreshToken", "/oauth/renew_refresh_token/"),

    /**
     * 获取 client_token
     */
    CLIENT_TOKEN("oauthClientToken", "/oauth/client_token/"),

    /**
     * 刷新 access_token
     */
    REFRESH_ACCESS_TOKEN("accessTokenRefresh", "/oauth/refresh_token/"),

    /**
     * 用户信息
     */
    USER_INFO("userInfo", "/oauth/userinfo/"),
    /**
     * 粉丝判断
     */
    FANS_CHECK("checkFans", "/fans/check/"),

    /**
     * 用户经营身份管理
     */
    USER_ROLE_CHECK("userRoleCheck", "/api/douyin/v1/role/check/"),

    /**
     * 创建图文
     */
    CREATE_IMAGE_TEXT("createImageText", "/api/douyin/v1/video/create_image_text/"),

    /**
     * 上传图片
     */
    UPLOAD_IMAGE("uploadImage", "/api/douyin/v1/video/upload_image/"),

    /**
     * 上传视频
     */
    UPLOAD_VIDEO("uploadVideo", "/api/douyin/v1/video/upload_video/"),

    /**
     * 创建视频
     */
    CREATE_VIDEO("createVideo", "/api/douyin/v1/video/create_video/"),

    /**
     * 分片上传完成
     */
    COMPLETE_VIDEO_PART_UPLOAD("completeVideoPartUpload", "/api/douyin/v1/video/complete_video_part_upload/"),


    /**
     * 分片上传
     */
    UPLOAD_VIDEO_PART("uploadVideoPart", "/api/douyin/v1/video/upload_video_part/"),


    /**
     * 分片上传初始化
     */
    Initialize_Video_Part_Upload("initializeVideoPartUpload", "/api/douyin/v1/video/init_video_part_upload/"),


    /**
     * 查询授权账号视频列表
     */
    QUERY_VIDEO_LIST("queryVideoList", "/api/douyin/v1/video/init_video_part_upload/"),


    /**
     * 查询特定视频的视频数据
     */
    QUERY_VIDEO_DATA("queryVideoData", "/api/douyin/v1/video/video_data/"),

    /**
     * 查询视频发布结果
     */
    QUERY_VIDEO_PUBLISH_RESULT("queryVideoPublishResult", "/share-id/"),

    /**
     * 查询视频携带的地点信息
     */
    QUERY_VIDEO_LOCATION("queryVideoLocation", "/poi/search/keyword/"),

    /**
     * 通过VideoID获取IFrame代码
     */
    QUERY_VIDEO_IFRAME("queryVideoIframe", "/api/douyin/v1/video/get_iframe_by_video/"),

    /**
     * 通过ItemID获取IFrame代码
     */
    QUERY_VIDEO_IFRAME_BY_ITEM("queryVideoIframeByItem", "/api/douyin/v1/video/get_iframe_by_item/"),


    /**
     * 发送私信消息
     */
    SEND_MESSAGE("sendMessage", "/im/send/msg/"),

    /**
     * 查询授权主动私信用户
     */
    QUERY_AUTHORIZE_USER_LIST("queryAuthorizeUserList", "/im/authorize/user_list/"),

    /**
     * 私信消息撤回
     */
    REVOKE_MESSAGE("revokeMessage", "/im/recall/msg/"),

    /**
     * 创建粉丝群
     */
    CREATE_FANS_GROUP("createFansGroup","/im/group/fans/create/"),


    /**
     * 变更用户入群申请状态
     */
    SET_FANS_GROUP_ENTER_STATUS("setFansGroupEnterStatus","/im/group/enter/audit/set/"),


    /**
     * 查询粉丝群
     */
    QUERY_FANS_GROUP("queryFansGroup","/im/group/fans/list/"),


    /**
     * 设置进群问候语&群公告
     */
    QUERY_FANS_GROUP_SETTING("queryFansGroupSetting","/im/group/setting/set/"),


    /**
     * 取消进群问候语&群公告配置
     */
    CANCEL_FANS_GROUP_SETTING("cancelFansGroupSetting","/im/group/setting/disable/"),


    /**
     * 查询用户剩余建群额度
     */
    QUERY_FANS_GROUP_COUNT("queryFansGroupCount","/im/group/count/"),


    /**
     * 查询群主所在群的用户入群申请状态
     */
    QUERY_FANS_GROUP_ENTER_STATUS("queryFansGroupEnterStatus","/im/group/enter/audit/get/"),

    /**
     * 发送群消息
     */
    SEND_GROUP_MESSAGE("sendGroupMessage","/im/send/msg/group/"),


    /**
     * 撤回群消息
     */
    REVOKE_GROUP_MESSAGE("revokeGroupMessage","/im/recall/msg/"),


    /**
     * 创建/更新留资卡片
     */
    SAVE_RETAIN_CONSULT_CARD("saveRetainConsultCard","/im/save/retain_consult_card/"),

    /**
     * 查询留资卡片
     */
    GET_RETAIN_CONSULT_CARD("getRetainConsultCard","/im/get/retain_consult_card/"),

    /**
     * 删除留资卡片
     */
    DELETE_RETAIN_CONSULT_CARD("deleteRetainConsultCard","/im/del/retain_consult_card/"),

    /**
     * 创建/更新小程序引导卡片模板
     */
    SET_APPLET_TEMPLATE("setAppletTemplate","/api/douyin/v1/im/set_applet_template/"),

    /**
     * 查询小程序引导卡片模板
     */
    GET_APPLET_TEMPLATE("getAppletTemplate","/api/douyin/v1/im/get_applet_template/"),

    /**
     * 删除小程序引导卡片模板
     */
    DEL_APPLET_TEMPLATE("delAppletTemplate","/api/douyin/v1/im/del_applet_template/"),

    /**
     * 图片上传
     */
    IMAGE_CLIENT_UPLOAD("imageClientUpload","/tool/imagex/client_upload/"),

    /**
     * 互动用户记录查询
     */
    QUERY_INTERACTION_LOG_RECORD("intentionLog","/api/douyin/v1/interactive/intention/log/list/"),

    /**
     * 置顶评论
     */
    COMMENT_TOP("commentTop","/item/comment/top/"),

    /**
     * 查询评论列表
     */
    QUERY_COMMENT_LIST("queryCommentList","/item/comment/list/"),

    /**
     * 评论回复列表
     */
    QUERY_COMMENT_REPLY_LIST("queryCommentReplyList","/item/comment/reply/list/"),


    /**
     * 回复视频评论
     */
    COMMENT_REPLY("commentReply","/item/comment/reply/"),

    /**
     * H5分享跳转链接获取
     */
    SCHEMA_GET_SHARE("schemaGetShare","/api/douyin/v1/schema/get_share/"),


    /**
     * 个人页跳转链接获取
     */
    SCHEMA_GET_USER_PROFILE("schemaGetUserProfile","/api/douyin/v1/schema/get_user_profile/"),

    /**
     * 个人会话页跳转链接获取
     */
    SCHEMA_GET_USER_CHAT("schemaGetUserChat","/api/douyin/v1/schema/get_chat/"),

    /**
     * 视频详情页跳转链接获取
     */
    SCHEMA_GET_ITEM_INFO("schemaGetItemInfo","/api/douyin/v1/schema/get_item_info/"),

    /**
     * 直播间跳转链接获取
     */
    SCHEMA_GET_LIVE("schemaGetLive","/api/douyin/v1/schema/get_live/"),

    /**
     * 创建投稿任务
     */
    CREATE_POSTING_TASK("createPostingTask","/task/posting/create/"),

    /**
     * 绑定视频
     */
    POSTING_TASK_BIND_VIDEO("postingTaskBindVideo","/task/posting/bind_video/"),
    /**
     * 核销投稿任务
     */
    POSTING_TASK_CONFIRM("postingTaskConfirm","/task/posting/user/"),
    /**
     * 查询视频基础信息
     */
    QUERY_VIDEO_BASIC_INFO("queryVideoBasicInfo","/api/douyin/v1/video/video_basic_info/"),


    /**
     * 上传素材接口
     */
    UPLOAD_MATERIAL("uploadMaterial","/enterprise/media/upload/"),

    /**
     * 上传临时素材接口
     */
    UPLOAD_TEMPORARY_MATERIAL("uploadTemporaryMaterial","/enterprise/media/temp/upload/"),

    /**
     * 素材列表接口
     */
    QUERY_MATERIAL_LIST("queryMaterialList","/enterprise/media/list/"),

    /**
     * 删除素材接口
     */
    DELETE_MATERIAL("deleteMaterial","/enterprise/media/delete/"),

    /**
     * 小程序接口能力
     */
    MICAPP_DEVTOOL_LEGAL("micAppDevtoolLegal","/devtool/micapp/is_legal/"),

    /**
     * 模拟webhook事件
     */
    WEBHOOK_EVENT_SEND("webhookEventSend","/sandbox/webhook/event/send/"),

    /**
     * 获取jsb_ticket
     */
    GET_TICKET("getJsbTicket","/js/getticket/"),

    /**
     * 获取 open_ticket
     */
    GET_OPEN_TICKET("getOpenTicket","/open/getticket/"),

    /**
     * 获取事件订阅状态
     */
    GET_EVENT_SUBSCRIBE_STATUS("getEventSubscribeStatus","/event/status/list/"),

    /**
     * 更新应用推送事件订阅状态
     */
    UPDATE_EVENT_SUBSCRIBE_STATUS("updateEventSubscribeStatus","/event/status/update/"),

    /**
     * 关键词视频搜索
     */
    VIDEO_SEARCH_V2("videoSearchV2", "/video/search/"),
    ;



    private String key;
    private String value;

    DyUrlPathEnum(String key, String value) {
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
        for (DyUrlPathEnum e : DyUrlPathEnum.values()) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }
}
