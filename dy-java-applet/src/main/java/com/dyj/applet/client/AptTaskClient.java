package com.dyj.applet.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.dyj.applet.domain.query.CreateLiveTaskQuery;
import com.dyj.applet.domain.query.CreateVideoTaskQuery;
import com.dyj.applet.domain.vo.CreateTaskVo;
import com.dyj.applet.domain.vo.WriteOffTaskVo;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.common.interceptor.TokenHeaderInterceptor;

/**
 * 任务能力
 *
 * @author danmo
 * @date 2024-04-23 13:57
 **/
@BaseRequest(baseURL = "${domain}")
public interface AptTaskClient {

    /**
     * 创建直播任务
     *
     * @param query 入参
     * @return DyResult<CreateTaskVo>
     */
    @Post(value = "${createLiveTask}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CreateTaskVo> createLiveTask(@JSONBody CreateLiveTaskQuery query);


    /**
     * 创建视频任务
     *
     * @param query 入参
     * @return DyResult<CreateTaskVo>
     */
    @Post(value = "${createVideoTask}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CreateTaskVo> createVideoTask(@JSONBody CreateVideoTaskQuery query);


    /**
     * 核销直播任务
     *
     * @param query  用户信息
     * @param openId 用户open_id,通过/oauth/access_token/获取，用户唯一标志
     * @param taskId 创建任务之后获取的任务ID
     * @return WriteOffTaskVo
     */
    @Post(value = "${writeOffLiveTask}", interceptor = TokenHeaderInterceptor.class)
    WriteOffTaskVo writeOffLiveTask(@Var("query") UserInfoQuery query, @JSONBody("open_id") String openId, @JSONBody("task_id") String taskId);

    /**
     * 核销视频任务
     *
     * @param query  用户信息
     * @param openId 用户open_id,通过/oauth/access_token/获取，用户唯一标志
     * @param taskId 创建任务之后获取的任务ID
     * @return WriteOffTaskVo
     */
    @Post(value = "${writeOffVideoTask}", interceptor = TokenHeaderInterceptor.class)
    WriteOffTaskVo writeOffVideoTask(@Var("query") UserInfoQuery query, @JSONBody("open_id") String openId, @JSONBody("task_id") String taskId);


}
