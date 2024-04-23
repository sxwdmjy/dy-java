package com.dyj.applet.handler;

import com.dyj.applet.domain.query.CreateLiveTaskQuery;
import com.dyj.applet.domain.query.CreateVideoTaskQuery;
import com.dyj.applet.domain.vo.CreateTaskVo;
import com.dyj.applet.domain.vo.WriteOffTaskVo;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-23 14:31
 **/
public class AptTaskHandler extends AbstractAppletHandler {

    public AptTaskHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 创建直播任务
     *
     * @param query 入参
     * @return DyResult<CreateTaskVo>
     */
    public DyResult<CreateTaskVo> createLiveTask(CreateLiveTaskQuery query) {
        userInfoQuery(query);
        return getTaskClient().createLiveTask(query);
    }

    /**
     * 创建视频任务
     *
     * @param query 入参
     * @return DyResult<CreateTaskVo>
     */
    public DyResult<CreateTaskVo> createVideoTask(CreateVideoTaskQuery query) {
        userInfoQuery(query);
        return getTaskClient().createVideoTask(query);
    }

    /**
     * 核销直播任务
     *
     * @param openId 用户open_id,通过/oauth/access_token/获取，用户唯一标志
     * @param taskId 创建任务之后获取的任务ID
     * @return WriteOffTaskVo
     */
    public WriteOffTaskVo writeOffLiveTask(String openId, String taskId) {
        return getTaskClient().writeOffLiveTask(userInfoQuery(openId), openId, taskId);
    }

    /**
     * 核销视频任务
     *
     * @param openId 用户open_id,通过/oauth/access_token/获取，用户唯一标志
     * @param taskId 创建任务之后获取的任务ID
     * @return WriteOffTaskVo
     */
    public WriteOffTaskVo writeOffVideoTask(String openId, String taskId) {
        return getTaskClient().writeOffVideoTask(userInfoQuery(openId), openId, taskId);
    }
}
