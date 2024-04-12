package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.web.domain.vo.VideoSearchListVo;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

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

}
