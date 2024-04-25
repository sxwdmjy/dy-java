package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.DataAndExtraBodyVo;
import com.dyj.common.interceptor.ClientTokenInterceptor;
import com.dyj.web.domain.*;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.web.domain.vo.*;
import com.dyj.common.interceptor.TokenHeaderInterceptor;

/**
 * 数据开放服务
 */
@BaseRequest(baseURL = "${domain}",contentType = ContentType.APPLICATION_JSON)
public interface DataExternalClient {

    /**
     * 获取用户视频情况
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    @Get(value = "${externalUserItem}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalUserItemResult>> externalUserItem(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType);

    /**
     * 获取用户粉丝数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    @Get(value = "${externalUserFans}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalUserFansResult>> externalUserFans(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType);

    /**
     * 获取用户点赞数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    @Get(value = "${externalUserLike}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalUserLikeResult>> externalUserLike(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType);

    /**
     * 获取用户评论数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    @Get(value = "${externalUserComment}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalUserCommentResult>> externalUserComment(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType);

    /**
     * 获取用户分享数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    @Get(value = "${externalUserShare}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalUserShareResult>> externalUserShare(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType);

    /**
     * 获取用户主页访问数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    @Get(value = "${externalUserProfile}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalUserProfileResult>> externalUserProfile(@Var("query") UserInfoQuery query,@Query("date_type") Long dateType);

    /**
     * 获取视频基础数据
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @return
     */
    @Get(value = "${externalItemBase}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultVo<ExternalItemBaseResult>> externalItemBase(@Var("query") UserInfoQuery query, @Query("item_id") String itemId);
    /**
     * 获取视频点赞数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @return
     */
    @Get(value = "${externalItemLike}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalItemLikeResult>> externalItemLike(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType,@Query("item_id") String itemId);

    /**
     * 获取视频评论数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @return
     */
    @Get(value = "${externalItemComment}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalItemCommentResult>> externalItemComment(@Var("query") UserInfoQuery query,@Query("date_type") Long dateType,@Query("item_id") String itemId);

    /**
     * 获取视频播放数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @return
     */
    @Get(value = "${externalItemPlay}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalItemPlayResult>> externalItemPlay(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType,@Query("item_id") String itemId);

    /**
     * 获取视频分享数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @return
     */
    @Get(value = "${externalItemShare}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ResultListVo<ExternalItemShareResult>> externalItemShare(@Var("query") UserInfoQuery query, @Query("date_type") Long dateType,@Query("item_id") String itemId);

    /**
     * 获取主播历史开播过的房间ID
     * @param endTime 查询结束时间，秒级时间戳。
     * @param startTime 查询开始时间，秒级时间戳。
     * @return
     */
    @Get(value = "${getRoomIdList}", interceptor = TokenHeaderInterceptor.class)
    GetRoomIdListVo getRoomIdList(@Var("query") UserInfoQuery query, @Query("end_time") Long endTime, @Query("start_time") Long startTime);

    /**
     * 获取直播间互动数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param roomId 房间id
     * @return
     */
    @Get(value = "${getRoomInteractiveData}", interceptor = TokenHeaderInterceptor.class)
    DySimpleResult<LiveRoomResult> getRoomInteractiveData(@Var("query") UserInfoQuery query, @Query("live_id") Long liveId, @Query("room_id") Long roomId);

    /**
     * 获取直播间看播数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param roomId 房间id
     * @return
     */
    @Get(value = "${getRoomAudienceData}", interceptor = TokenHeaderInterceptor.class)
    DySimpleResult<LiveRoomResult> getRoomAudienceData(@Var("query") UserInfoQuery query, @Query("live_id") Long liveId, @Query("room_id") Long roomId);

    /**
     * 获取直播间基础数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param roomId 房间id
     * @return
     */
    @Get(value = "${getRoomBaseData}", interceptor = TokenHeaderInterceptor.class)
    DySimpleResult<LiveRoomResult> getRoomBaseData(@Var("query") UserInfoQuery query, @Query("live_id") Long liveId,@Query("room_id") Long roomId);

    /**
     * 获取用户粉丝数据
     * @return
     */
    @Get(value = "${apiFansDataBind}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ApiFansDataBindFansVo> apiFansDataBind(@Var("query") UserInfoQuery query);

    /**
     * 获取用户粉丝来源
     * @return
     */
    @Get(value = "${getFansSource}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ListVo<ItemValue>> getFansSource(@Var("query") UserInfoQuery query);

    /**
     * 获取用户粉丝喜好
     * @return
     */
    @Get(value = "${getFansFavourite}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ListVo<GetFansFavouriteResult>> getFansFavourite(@Var("query") UserInfoQuery query);

    /**
     * 获取用户粉丝热评
     * @return
     */
    @Get(value = "${getFansComment}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ListVo<GetFansCommentResult>> getFansComment(@Var("query") UserInfoQuery query);

    /**
     * 获取实时热点词
     * @return
     */
    @Get(value = "${hotSentences}", interceptor = ClientTokenInterceptor.class)
    DyResult<HotSentencesDataVo> hotSentences();

    /**
     * 获取上升词
     * @param count 每页数量
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。
     * @return
     */
    @Get(value = "${trendingSentences}", interceptor = ClientTokenInterceptor.class)
    DyResult<TrendingSentencesVo> trendingSentences(@Query("count") Integer count,@Query("cursor") Long cursor);

    /**
     * 获取热点词聚合的视频
     * @param hotSentence 热点词
     * @return
     */
    @Get(value = "${hotVideoList}", interceptor = ClientTokenInterceptor.class)
    DyResult<HotVideoListDataVo> hotVideoList(@Query("hot_sentence") String hotSentence);

    /**
     * 获取抖音星图达人热榜
     * @param hotListType 达人热榜类型 * `1` - 星图指数榜 * `2` - 涨粉指数榜 * `3` - 性价比指数榜 * `4` - 种草指数榜 * `5` - 精选指数榜 * `6` - 传播指数榜 选填
     * @return
     */
    @Get(value = "${starHotlist}", interceptor = ClientTokenInterceptor.class)
    DataAndExtraBodyVo<StarHotResult> starHotlist(@Query("hot_list_type") Long hotListType);

    /**
     * 获取抖音星图达人指数
     * @return
     */
    @Get(value = "${starAuthorScore}", interceptor = TokenHeaderInterceptor.class)
    DataAndExtraBodyVo<StarAuthorScoreResult> starAuthorScore(@Var("query") UserInfoQuery query);

    /**
     * 获取抖音星图达人指数数据V2
     * @param uniqueId 达人抖音号 选填
     * @return
     */
    @Get(value = "${starAuthorScoreV2}", interceptor = ClientTokenInterceptor.class)
    DataAndExtraBodyVo<StarAuthorScoreV2Result> starAuthorScoreV2(@Query("unique_id") String uniqueId);

    /**
     * 获取抖音电影榜、抖音电视剧榜、抖音综艺榜
     * @param type 榜单类型：  * 1 - 电影   * 2 - 电视剧   * 3 - 综艺 选填
     * @param version 榜单版本：空值默认为本周榜单 选填
     * @return
     */
    @Get(value = "${discoveryEntRankItem}", interceptor = ClientTokenInterceptor.class)
    DataAndExtraBodyVo<DiscoveryEntRankItemVo> discoveryEntRankItem(@Query("type") Long type,@Query("version") Long version);

    /**
     * 获取抖音影视综榜单版本
     * @param count 每页数量 选填
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param type 榜单类型：  * 1 - 电影   * 2 - 电视剧   * 3 - 综艺 选填
     * @return
     */
    @Get(value = "${discoveryEntRankVersion}", interceptor = ClientTokenInterceptor.class)
    DataAndExtraBodyVo<DiscoveryEntRankVersionListVo> discoveryEntRankVersion(@Query("count") Long count,@Query("cursor") Long cursor,@Query("type") Long type);

    /**
     * 热门视频榜
     * @return
     */
    @Get(value = "${getHotVideoBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<GetHotVideoBillboard>> getHotVideoBillboard();


    /**
     * 体育总榜
     * @return
     */
    @Get(value = "${sportOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportOverallBillboard();

    /**
     * 篮球榜
     * @return
     */
    @Get(value = "${sportBasketballBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportBasketballBillboard();

    /**
     * 足球榜
     * @return
     */
    @Get(value = "${sportSoccerBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportSoccerBillboard();

    /**
     * 综合体育榜
     * @return
     */
    @Get(value = "${sportComprehensiveBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportComprehensiveBillboard();

    /**
     * 运动健身榜
     * @return
     */
    @Get(value = "${sportFitnessBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportFitnessBillboard();

    /**
     * 户外运动榜
     * @return
     */
    @Get(value = "${sportOutdoorsBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportOutdoorsBillboard();

    /**
     * 台球榜
     * @return
     */
    @Get(value = "${sportTableTennisBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportTableTennisBillboard();

    /**
     * 运动文化榜
     * @return
     */
    @Get(value = "${sportCultureEBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> sportCultureEBillboard();

    /**
     * 搞笑总榜
     * @return
     */
    @Get(value = "${amusementOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> amusementOverallBillboard();

    /**
     * 搞笑新势力榜
     * @return
     */
    @Get(value = "${amusementNewBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> amusementNewBillboard();

    /**
     * 单机主机榜
     * @return
     */
    @Get(value = "${gameConsoleBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> gameConsoleBillboard();

    /**
     * 游戏资讯榜
     * @return
     */
    @Get(value = "${gameInfBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> gameInfBillboard();

    /**
     * 美食总榜
     * @return
     */
    @Get(value = "${foodOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> foodOverallBillboard();

    /**
     * 美食新势力榜
     * @return
     */
    @Get(value = "${foodNewBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> foodNewBillboard();

    /**
     * 美食教程榜
     * @return
     */
    @Get(value = "${foodTutorialBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> foodTutorialBillboard();

    /**
     * 美食探店榜
     * @return
     */
    @Get(value = "${foodShopBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> foodShopBillboard();

    /**
     * 剧情总榜
     * @return
     */
    @Get(value = "${dramaOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> dramaOverallBillboard();

    /**
     * 汽车总榜
     * @return
     */
    @Get(value = "${carOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> carOverallBillboard();

    /**
     * 评车
     * @return
     */
    @Get(value = "${carCommentBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> carCommentBillboard();

    /**
     * 玩车
     * @return
     */
    @Get(value = "${carPlayBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> carPlayBillboard();

    /**
     * 用车
     * @return
     */
    @Get(value = "${carUseBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> carUseBillboard();

    /**
     * 驾考
     * @return
     */
    @Get(value = "${carDriverBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> carDriverBillboard();

    /**
     * 旅游总榜单
     * @return
     */
    @Get(value = "${travelOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> travelOverallBillboard();

    /**
     * 旅游新势力榜
     * @return
     */
    @Get(value = "${travelNewBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> travelNewBillboard();

    /**
     * 二次元总榜
     * @return
     */
    @Get(value = "${cospaOverallBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaOverallBillboard();

    /**
     * 轻漫
     * @return
     */
    @Get(value = "${cospaQingManBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaQingManBillboard();

    /**
     * 出境拍摄
     * @return
     */
    @Get(value = "${cospaOutShotBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaOutShotBillboard();

    /**
     * 绘画
     * @return
     */
    @Get(value = "${cospaPaintingBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaPaintingBillboard();

    /**
     * 声控
     * @return
     */
    @Get(value = "${cospaVoiceControlBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaVoiceControlBillboard();

    /**
     * 脑洞
     * @return
     */
    @Get(value = "${cospaBrainCavityBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaBrainCavityBillboard();

    /**
     * 二次元新势力榜
     * @return
     */
    @Get(value = "${cospaNewBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<ExternDataBillboard>> cospaNewBillboard();

    /**
     * 娱乐明星榜
     * @return
     */
    @Get(value = "${getStarsBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<StarsBillboard>> getStarsBillboard();

    /**
     * 直播榜
     * @return
     */
    @Get(value = "${getLiveBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<LiveBillboard>> getLiveBillboard();

    /**
     * 热歌榜
     * @return
     */
    @Get(value = "${getHotMusicBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<MusicBillboard>> getHotMusicBillboard();

    /**
     * 飙升榜
     * @return
     */
    @Get(value = "${getSoarMusicBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<MusicBillboard>> getSoarMusicBillboard();

    /**
     * 原创榜
     * @return
     */
    @Get(value = "${getOriginalMusicBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<MusicBillboard>> getOriginalMusicBillboard();


    /**
     * 话题榜
     * @return
     */
    @Get(value = "${getTopicBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<TopicBillboard>> getTopicBillboard();

    /**
     * 道具榜
     * @return
     */
    @Get(value = "${getPropBillboard}", interceptor = ClientTokenInterceptor.class)
    DyResult<ListVo<PropBillboard>> getPropBillboard();
}
