package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
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
}
