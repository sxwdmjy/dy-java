package com.dyj.applet.client;

import com.dtflys.forest.annotation.*;
import com.dyj.applet.domain.query.AptVideoQuery;
import com.dyj.applet.domain.vo.*;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.common.interceptor.BizTokenHeaderInterceptor;
import com.dyj.common.interceptor.TokenHeaderInterceptor;

/**
 * 视频能力
 *
 * @author danmo
 * @date 2024-04-18 16:43
 **/
@BaseRequest(baseURL = "${domain}")
public interface AptVideoClient {

    /**
     * 查询特定视频的视频数据
     *
     * @param query 入参
     * @return DyResult<AptVideoListVo>
     */
    @Post(url = "${queryAptVideoList}", interceptor = TokenHeaderInterceptor.class)
    DyResult<AptVideoListVo> queryVideoList(@JSONBody AptVideoQuery query);
    /**
     * 查询特定视频的视频数据(经营授权)
     *
     * @param query 入参
     * @return DyResult<AptVideoListVo>
     */
    @Post(url = "${queryBizVideoList}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<AptVideoListVo> queryBizVideoList(@JSONBody AptVideoQuery query);

    /**
     * 获取视频基础数据
     * @param query 用户信息
     * @param itemId 视频ID
     * @return DyResult<ItemBaseInfoVo>
     */
    @Get(url = "${getItemBaseInfo}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemBaseInfoVo> getItemBaseInfo(@Var("query")UserInfoQuery query, @Query("item_id") String itemId);

    /**
     * 获取视频基础数据（经营授权）
     * @param query 用户信息
     * @param itemId 视频ID
     * @return DyResult<ItemBaseInfoVo>
     */
    @Get(url = "${getItemBizBaseInfo}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemBaseInfoVo> getItemBizBaseInfo(@Var("query") UserInfoQuery query, @Query("item_id") String itemId);

    /**
     * 获取视频点赞数据
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    @Get(url = "${getItemLikeInfo}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemLikeInfoVo> getItemLikeInfo(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频点赞数据（经营授权）
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    @Get(url = "${getItemLikeInfo}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemLikeInfoVo> getItemBizLikeInfo(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频评论数据
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemLikeInfoVo>
     */
    @Get(url = "${getItemComment}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemCommentInfoVo> getItemComment(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频评论数据（经营授权）
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemLikeInfoVo>
     */
    @Get(url = "${getItemBizComment}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemCommentInfoVo> getItemBizComment(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频播放数据
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    @Get(url = "${getItemPlay}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemPlayInfoVo> getItemPlay(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频播放数据（经营授权）
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围 近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    @Get(url = "${getItemBizPlay}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemPlayInfoVo> getItemBizPlay(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频分享数据
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    @Get(url = "${getItemShare}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemShareInfoVo> getItemShare(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    /**
     * 获取视频分享数据（经营授权）
     * @param query 用户信息
     * @param itemId 视频ID
     * @param dateType 数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    @Get(url = "${getItemBizShare}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemShareInfoVo> getItemBizShare(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);
}

