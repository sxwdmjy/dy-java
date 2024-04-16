package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.ConfirmPostingTaskQuery;
import com.dyj.web.domain.query.CreatePostingTaskQuery;
import com.dyj.web.domain.query.PostingTaskQuery;
import com.dyj.web.domain.query.VideoDataQuery;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.ConfirmPostingTaskVo;
import com.dyj.web.domain.vo.PostingTaskVo;
import com.dyj.web.domain.vo.VideoBasicListVo;

/**
 * @author danmo
 * @date 2024-04-11 14:18
 **/
public class PostingTaskHandler extends AbstractWebHandler {

    public PostingTaskHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 创建投稿任务
     *
     * @param query 入参
     * @return DyResult<PostingTaskVo>
     */
    public DyResult<PostingTaskVo> createPostingTask(CreatePostingTaskQuery query) {
        baseQuery(query);
        return getPostingTaskClient().createPostingTask(query);
    }

    /**
     * 绑定视频
     *
     * @param query 入参
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> postingTaskBindVideo(PostingTaskQuery query) {
        baseQuery(query);
        return getPostingTaskClient().postingTaskBindVideo(query);
    }

    /**
     * 核销投稿任务
     *
     * @param query 入参
     * @return DyResult<ConfirmPostingTaskVo>
     */
    public DyResult<ConfirmPostingTaskVo> confirmPostingTask(ConfirmPostingTaskQuery query) {
        baseQuery(query);
        return getPostingTaskClient().postingTaskConfirm(query);
    }

    /**
     * 查询视频基础信息
     *
     * @param query 入参
     * @return DyResult<VideoBasicListVo>
     */
    public DyResult<VideoBasicListVo> queryVideoBasicInfo(VideoDataQuery query) {
        baseQuery(query);
        return getPostingTaskClient().queryVideoBasicInfo(query);
    }


}
