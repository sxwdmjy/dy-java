package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.ConfirmPostingTaskQuery;
import com.dyj.web.domain.query.CreatePostingTaskQuery;
import com.dyj.web.domain.query.PostingTaskQuery;
import com.dyj.web.domain.query.VideoDataQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.ConfirmPostingTaskVo;
import com.dyj.web.domain.vo.PostingTaskVo;
import com.dyj.web.domain.vo.VideoBasicListVo;
import com.dyj.web.interceptor.ClientTokenInterceptor;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

/**
 * 投稿任务
 *
 * @author danmo
 * @date 2024/04/09 14:08
 */
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface PostingTaskClient {

    /**
     * 创建投稿任务
     *
     * @param query 入参
     * @return DyResult<PostingTaskVo>
     */
    @Post(value = "${createPostingTask}", interceptor = ClientTokenInterceptor.class)
    DyResult<PostingTaskVo> createPostingTask(@JSONBody CreatePostingTaskQuery query);

    /**
     * 绑定视频
     * @param query 入参
     * @return DyResult<BaseVo>
     */
    @Post(value = "${postingTaskBindVideo}", interceptor = TokenHeaderInterceptor.class)
    DyResult<BaseVo> postingTaskBindVideo(@JSONBody PostingTaskQuery query);

    /**
     * 核销投稿任务
     * @param query 入参
     * @return DyResult<ConfirmPostingTaskVo>
     */
    @Post(value = "${postingTaskConfirm}", interceptor = ClientTokenInterceptor.class)
    DyResult<ConfirmPostingTaskVo> postingTaskConfirm(@JSONBody ConfirmPostingTaskQuery query);

    /**
     * 查询视频基础信息
     * @param query 入参
     * @return DyResult<VideoBasicListVo>
     */
    @Post(value = "${queryVideoBasicInfo}", interceptor = TokenHeaderInterceptor.class)
    DyResult<VideoBasicListVo> queryVideoBasicInfo(@JSONBody VideoDataQuery query);
}
