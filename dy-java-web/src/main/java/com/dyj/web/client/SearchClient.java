package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.VideoSearchCommentReplyV2Result;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.web.domain.query.VideoSearchCommentReplyV2Query;
import com.dyj.web.domain.vo.VideoSearchCommentListV2ListVo;
import com.dyj.web.domain.vo.VideoSearchListVo;
import com.dyj.common.interceptor.TokenHeaderInterceptor;

/**
 * 搜索管理
 * @author ws
 */
@BaseRequest(baseURL = "${domain}")
public interface SearchClient {


    /**
     * 关键词视频搜索
     * @param query 用户信息
     * @param keyword 关键词
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param count 每页数量
     * @return
     */
    @Get(value = "${videoSearchV2}", interceptor = TokenHeaderInterceptor.class,contentType = ContentType.APPLICATION_JSON)
    DyResult<VideoSearchListVo> videoSearchV2(@Var("query") UserInfoQuery query, @Query("keyword") String keyword, @Query("count") Integer count, @Query("cursor") Long cursor);

    /**
     * 关键词视频评论列表
     * @param count 每页数量。
     * @param secItemId 视频搜索接口返回的加密的视频id
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @return
     */
    @Get(value = "${videoSearchCommentListV2}", interceptor = TokenHeaderInterceptor.class,contentType = ContentType.APPLICATION_JSON)
    DyResult<VideoSearchCommentListV2ListVo> videoSearchCommentListV2(@Query("count") Integer count, @Query("sec_item_id") String secItemId, @Query("cursor") Long cursor);


    /**
     * 关键词视频评论回复
     * @param body 关键词视频评论回复请求值
     * @return
     */
    @Post(value = "${videoSearchCommentReplyV2}", interceptor = TokenHeaderInterceptor.class,contentType = ContentType.APPLICATION_JSON)
    DyResult<VideoSearchCommentReplyV2Result> videoSearchCommentReplyV2(@JSONBody VideoSearchCommentReplyV2Query body);

    /**
     * 关键词视频评论回复列表
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param count 每页数量。
     * @param secItemId 视频搜索接口返回的加密的视频id
     * @param commentId 评论id
     * @return
     */
    @Get(value = "${videoSearchCommentReplyListV2}", interceptor = TokenHeaderInterceptor.class)
    DyResult<VideoSearchCommentListV2ListVo> videoSearchCommentReplyListV2(@Query("cursor") Long cursor,@Query("count") Integer count,@Query("sec_item_id") String secItemId,@Query("comment_id") String commentId);
}
