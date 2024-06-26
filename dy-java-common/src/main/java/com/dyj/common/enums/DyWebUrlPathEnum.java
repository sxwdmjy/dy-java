package com.dyj.common.enums;

public enum DyWebUrlPathEnum {

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
    QUERY_VIDEO_LIST("queryVideoList", "/api/douyin/v1/video/video_list/"),


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

    /**
     * 关键词视频评论列表
     */
    VIDEO_SEARCH_COMMENT_LIST_V2("videoSearchCommentListV2", "/video/search/comment/list/"),

    /**
     * 关键词视频评论回复
     */
    VIDEO_SEARCH_COMMENT_REPLY_V2("videoSearchCommentReplyV2", "/video/search/comment/reply/"),

    /**
     * 关键词视频评论回复列表
     */
    VIDEO_SEARCH_COMMENT_REPLY_LIST_V2("videoSearchCommentReplyListV2", "/video/search/comment/reply/list/"),

    /**
     * 获取用户视频情况
     */
    EXTERNAL_USER_ITEM("externalUserItem", "/data/external/user/item/"),

    /**
     * 获取用户粉丝数
     */
    EXTERNAL_USER_FANS("externalUserFans", "/data/external/user/fans/"),

    /**
     * 获取用户点赞数
     */
    EXTERNAL_USER_LIKE("externalUserLike", "/data/external/user/like/"),

    /**
     * 获取用户评论数
     */
    EXTERNAL_USER_COMMENT("externalUserComment", "/data/external/user/comment/"),

    /**
     * 获取用户分享数
     */
    EXTERNAL_USER_SHARE("externalUserShare", "/data/external/user/share/"),


    /**
     * 获取用户主页访问数
     */
    EXTERNAL_USER_PROFILE("externalUserProfile", "/data/external/user/profile/"),

    /**
     * 获取视频基础数据
     */
    EXTERNAL_ITEM_BASE("externalItemBase", "/data/external/item/base/"),

    /**
     * 获取视频点赞数据
     */
    EXTERNAL_ITEM_LIKE("externalItemLike", "/data/external/item/like/"),

    /**
     * 获取视频评论数据
     */
    EXTERNAL_ITEM_COMMENT("externalItemComment", "/data/external/item/comment/"),

    /**
     * 获取视频播放数据
     */
    EXTERNAL_ITEM_PLAY("externalItemPlay", "/data/external/item/play/"),

    /**
     * 获取视频分享数据
     */
    EXTERNAL_ITEM_SHARE("externalItemShare", "/data/external/item/share/"),

    /**
     * 获取主播历史开播过的房间ID
     */
    GET_ROOM_ID_LIST("getRoomIdList", "/room/data/room_id/get/"),

    /**
     * 获取直播间互动数据
     */
    GET_ROOM_INTERACTIVE_DATA("getRoomInteractiveData", "/room/data/interactive/get/"),

    /**
     * 获取直播间看播数据
     */
    GET_ROOM_AUDIENCE_DATA("getRoomAudienceData", "/room/data/audience/get/"),

    /**
     * 获取直播间基础数据
     */
    GET_ROOM_BASE_DATA("getRoomBaseData", "/room/data/base/get/"),

    /**
     * 获取用户粉丝数据
     */
    API_FANS_DATA_BIND("apiFansDataBind", "/api/douyin/v1/user/fans_data/"),

    /**
     * 获取用户粉丝来源
     */
    GET_FANS_SOURCE("getFansSource", "/data/extern/fans/source/"),

    /**
     * 获取用户粉丝喜好
     */
    GET_FANS_FAVOURITE("getFansFavourite", "/data/extern/fans/favourite/"),

    /**
     * 获取用户粉丝热评
     */
    GET_FANS_COMMENT("getFansComment", "/data/extern/fans/comment/"),

    /**
     * 获取实时热点词
     */
    HOT_SENTENCES("hotSentences", "/hotsearch/sentences/"),

    /**
     * 获取上升词
     */
    TRENDING_SENTENCES("trendingSentences", "/hotsearch/trending/sentences/"),

    /**
     * 获取热点词聚合的视频
     */
    HOT_VIDEO_LIST("hotVideoList", "/hotsearch/videos/"),

    /**
     * 获取抖音星图达人热榜
     */
    STAR_HOTLIST("starHotlist", "/star/hot_list/"),

    /**
     * 获取抖音星图达人指数
     */
    STAR_AUTHOR_SCORE("starAuthorScore", "/star/author_score/"),


    /**
     * 获取抖音星图达人指数数据V2
     */
    STAR_AUTHOR_SCORE_V2("starAuthorScoreV2", "/star/author_score_v2/"),

    /**
     * 获取抖音电影榜、抖音电视剧榜、抖音综艺榜
     */
    DISCOVERY_ENT_RANK_ITEM("discoveryEntRankItem", "/discovery/ent/rank/item/"),

    /**
     * 获取抖音影视综榜单版本
     */
    DISCOVERY_ENT_RANK_VERSION("discoveryEntRankVersion", "/discovery/ent/rank/version/"),

    /**
     * 热门视频榜
     */
    GET_HOT_VIDEO_BILLBOARD("getHotVideoBillboard", "/data/extern/billboard/hot_video/"),


    /**
     * 体育总榜
     */
    SPORT_OVERALL_BILLBOARD("sportOverallBillboard", "/data/extern/billboard/sport/overall/"),


    /**
     * 篮球榜
     */
    SPORT_BASKETBALL_BILLBOARD("sportBasketballBillboard", "/data/extern/billboard/sport/basketball/"),

    /**
     * 足球榜
     */
    SPORT_SOCCER_BILLBOARD("sportSoccerBillboard", "/data/extern/billboard/sport/soccer/"),

    /**
     * 综合体育榜
     */
    SPORT_COMPREHENSIVE_BILLBOARD("sportComprehensiveBillboard", "/data/extern/billboard/sport/comprehensive/"),

    /**
     * 运动健身榜
     */
    SPORT_FITNESS_BILLBOARD("sportFitnessBillboard", "/data/extern/billboard/sport/fitness/"),

    /**
     * 户外运动榜
     */
    SPORT_OUTDOORS_BILLBOARD("sportOutdoorsBillboard", "/data/extern/billboard/sport/outdoors/"),

    /**
     * 台球榜
     */
    SPORT_TABLE_TENNIS_BILLBOARD("sportTableTennisBillboard", "/data/extern/billboard/sport/table_tennis/"),

    /**
     * 运动文化榜
     */
    SPORT_CULTURE_E_BILLBOARD("sportCultureEBillboard", "/data/extern/billboard/sport/culture/"),


    /**
     * 搞笑总榜
     */
    AMUSEMENT_OVERALL_BILLBOARD("amusementOverallBillboard", "/data/extern/billboard/amusement/overall/"),

    /**
     * 搞笑新势力榜
     */
    AMUSEMENT_NEW_BILLBOARD("amusementNewBillboard", "/data/extern/billboard/amusement/new/"),

    /**
     * 单机主机榜
     */
    GAME_CONSOLE_BILLBOARD("gameConsoleBillboard", "/data/extern/billboard/game/console/"),

    /**
     * 游戏资讯榜
     */
    GAME_INF_BILLBOARD("gameInfBillboard", "/data/extern/billboard/game/inf/"),


    /**
     * 美食总榜
     */
    FOOD_OVERALL_BILLBOARD("foodOverallBillboard", "/data/extern/billboard/food/overall/"),

    /**
     * 美食新势力榜
     */
    FOOD_NEW_BILLBOARD("foodNewBillboard", "/data/extern/billboard/food/new/"),

    /**
     * 美食教程榜
     */
    FOOD_TUTORIAL_BILLBOARD("foodTutorialBillboard", "/data/extern/billboard/food/tutorial/"),

    /**
     * 美食探店榜
     */
    FOOD_SHOP_BILLBOARD("foodShopBillboard", "/data/extern/billboard/food/shop/"),

    /**
     * 剧情总榜
     */
    DRAMA_OVERALL_BILLBOARD("dramaOverallBillboard", "/data/extern/billboard/drama/overall/"),

    /**
     * 汽车总榜
     */
    CAR_OVERALL_BILLBOARD("carOverallBillboard", "/data/extern/billboard/car/overall/"),

    /**
     * 评车
     */
    CAR_COMMENT_BILLBOARD("carCommentBillboard", "/data/extern/billboard/car/comment/"),

    /**
     * 玩车
     */
    CAR_PLAY_BILLBOARD("carPlayBillboard", "/data/extern/billboard/car/play/"),

    /**
     * 用车
     */
    CAR_USE_BILLBOARD("carUseBillboard", "/data/extern/billboard/car/use/"),


    /**
     * 驾考
     */
    CAR_DRIVER_BILLBOARD("carDriverBillboard", "/data/extern/billboard/car/driver/"),

    /**
     * 旅游总榜单
     */
    TRAVEL_OVERALL_BILLBOARD("travelOverallBillboard", "/data/extern/billboard/travel/overall/"),

    /**
     * 旅游新势力榜
     */
    TRAVEL_NEW_BILLBOARD("travelNewBillboard", "/data/extern/billboard/travel/new/"),


    /**
     * 二次元总榜
     */
    COSPA_OVERALL_BILLBOARD("cospaOverallBillboard", "/data/extern/billboard/cospa/overall/"),

    /**
     * 轻漫
     */
    COSPA_QING_MAN_BILLBOARD("cospaQingManBillboard", "/data/extern/billboard/cospa/qing_man/"),



    /**
     * 出境拍摄
     */
    COSPA_OUT_SHOT_BILLBOARD("cospaOutShotBillboard", "/data/extern/billboard/cospa/out_shot/"),

    /**
     * 绘画
     */
    COSPA_PAINTING_BILLBOARD("cospaPaintingBillboard", "/data/extern/billboard/cospa/painting/"),

    /**
     * 声控
     */
    COSPA_VOICE_CONTROL_BILLBOARD("cospaVoiceControlBillboard", "/data/extern/billboard/cospa/voice_control/"),


    /**
     * 脑洞
     */
    COSPA_BRAIN_CAVITY_BILLBOARD("cospaBrainCavityBillboard", "/data/extern/billboard/cospa/brain_cavity/"),

    /**
     * 二次元新势力榜
     */
    COSPA_NEW_BILLBOARD("cospaNewBillboard", "/data/extern/billboard/cospa/new/"),

    /**
     * 娱乐明星榜
     */
    GET_STARS_BILLBOARD("getStarsBillboard", "/data/extern/billboard/stars/"),

    /**
     * 直播榜
     */
    GET_LIVE_BILLBOARD("getLiveBillboard", "/data/extern/billboard/live/"),

    /**
     * 热歌榜
     */
    GET_HOT_MUSIC_BILLBOARD("getHotMusicBillboard", "/data/extern/billboard/music/hot/"),

    /**
     * 飙升榜
     */
    GET_SOAR_MUSIC_BILLBOARD("getSoarMusicBillboard", "/data/extern/billboard/music/soar/"),

    /**
     * 原创榜
     */
    GET_ORIGINAL_MUSIC_BILLBOARD("getOriginalMusicBillboard", "/data/extern/billboard/music/original/"),

    /**
     * 话题榜
     */
    GET_TOPIC_BILLBOARD("getTopicBillboard", "/data/extern/billboard/topic/"),

    /**
     * 道具榜
     */
    GET_PROP_BILLBOARD("getPropBillboard", "/data/extern/billboard/prop/"),

    ;



    private String key;
    private String value;

    DyWebUrlPathEnum(String key, String value) {
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
        for (DyWebUrlPathEnum e : DyWebUrlPathEnum.values()) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }
}
