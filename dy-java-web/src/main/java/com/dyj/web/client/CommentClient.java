package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.CommentQuery;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.CommentListVo;
import com.dyj.web.domain.vo.CommentReplyVo;
import com.dyj.common.interceptor.TokenHeaderInterceptor;

/**
 * 评论管理
 *
 * @author danmo
 * @date 2024-04-10 16:44
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface CommentClient {

    /**
     * 置顶评论
     */
    @Post(value = "${commentTop}", interceptor = TokenHeaderInterceptor.class)
    DyResult<BaseVo> commentTop(@JSONBody CommentQuery query);

    /**
     * 查询评论列表
     * @param query 用户信息
     * @param itemId 视频id
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count 每页的数量，最大不超过20，最小不低于1
     * @param cursor 分页游标, 第一页请求cursor是0
     * @return DyResult<CommentListVo>
     */
    @Get(value = "${queryCommentList}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CommentListVo> queryCommentList(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("sort_type") String sortType, @Query("count") Integer count, @Query("cursor") Long cursor);

    /**
     * 评论回复列表
     * @param query 用户信息
     * @param itemId 视频id
     * @param commentId 评论id
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count 每页的数量，最大不超过20，最小不低于1
     * @param cursor 分页游标, 第一页请求cursor是0
     * @return
     */
    @Get(value = "${queryCommentReplyList}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CommentListVo> queryCommentReplyList(@Var("query") UserInfoQuery query, @Query("item_id") String itemId, @Query("comment_id") String commentId, @Query("sort_type") String sortType, @Query("count") Integer count, @Query("cursor") Long cursor);

    /**
     * 回复视频评论
     * @param query 入参
     * @return DyResult<CommentReplyVo>
     */
    @Post(value = "${commentReply}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CommentReplyVo> commentReply(@JSONBody CommentQuery query);
}
