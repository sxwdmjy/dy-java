package com.dyj.applet.client;

import com.dtflys.forest.annotation.*;
import com.dyj.applet.domain.query.AptVideoQuery;
import com.dyj.applet.domain.query.CommentQuery;
import com.dyj.applet.domain.query.ItemId2EncryptIdQuery;
import com.dyj.applet.domain.query.VideoId2ItemIdQuery;
import com.dyj.applet.domain.vo.*;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.common.interceptor.BizTokenHeaderInterceptor;
import com.dyj.common.interceptor.ClientTokenInterceptor;
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

    /**
     * 置顶评论
     * @param query 用户信息
     * @return TopCommentVo
     */
    @Post(url = "${topComment}", interceptor = TokenHeaderInterceptor.class)
    TopCommentVo topComment(@JSONBody CommentQuery query);

    /**
     * 获取评论列表
     * @param query 用户信息
     * @param itemId 视频ID
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count 每页的数量，最大不超过50，最小不低于1
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。
     * @return DyResult<CommentListVo>
     */
    @Get(url = "${commentList}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CommentListVo> commentList(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("sort_type") String sortType, @Query("count") Integer count, @Query("cursor") Long cursor);


    /**
     * 获取评论回复列表
     * @param query 用户信息
     * @param itemId 视频ID
     * @param commentId 评论ID
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count 每页的数量，最大不超过50，最小不低于1
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。
     * @return DyResult<CommentListVo>
     */
    @Get(url = "${commentReplyList}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CommentListVo> commentReplyList(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("comment_id") String commentId, @Query("sort_type") String sortType, @Query("count") Integer count, @Query("cursor") Long cursor);

    /**
     * 回复视频评论
     * @param query 入参
     * @return DyResult<CommentReplyVo>
     */
    @Post(value = "${replyComment}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CommentReplyVo> replyComment(@JSONBody CommentQuery query);

    /**
     * videoId转换itemId
     * @param query videoId入参
     * @return DySimpleResult<ConvertResultVo>
     */
    @Post(value = "${videoId2itemId}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<ConvertResultVo> videoId2itemId(@JSONBody VideoId2ItemIdQuery query);

    /**
     * itemId转换encryptId
     * @param query itemId入参
     * @return DySimpleResult<ConvertResultVo>
     */
    @Post(value = "${itemId2encryptId}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<ConvertResultVo> itemId2encryptId(@JSONBody ItemId2EncryptIdQuery query);

}

