package com.dyj.applet.client;

import com.dtflys.forest.annotation.*;
import com.dyj.applet.domain.query.AptVideoQuery;
import com.dyj.applet.domain.vo.AptVideoListVo;
import com.dyj.applet.domain.vo.ItemBaseInfoVo;
import com.dyj.applet.domain.vo.ItemLikeInfoVo;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.BaseQuery;
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
     * @return
     */
    @Get(url = "${getItemBaseInfo}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemBaseInfoVo> getItemBaseInfo(@Var("query")UserInfoQuery query, @Query("item_id") String itemId);

    /**
     * 获取视频基础数据（经营授权）
     * @param query 用户信息
     * @param itemId 视频ID
     * @return
     */
    @Get(url = "${getItemBizBaseInfo}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemBaseInfoVo> getItemBizBaseInfo(@Var("query") UserInfoQuery query, @Query("item_id") String itemId);

    @Get(url = "${getItemLikeInfo}", interceptor = TokenHeaderInterceptor.class)
    DyResult<ItemLikeInfoVo> getItemLikeInfo(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);

    @Get(url = "${getItemLikeInfo}", interceptor = BizTokenHeaderInterceptor.class)
    DyResult<ItemLikeInfoVo> getItemBizLikeInfo(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("date_type") Integer dateType);
}
