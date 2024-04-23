package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-23 14:18
 **/
public class CreateVideoTaskQuery extends UserInfoQuery {

    /**
     * 收藏:collection
     * 评论:comment
     * 点赞:digg
     * 分享:share
     * 完播:complete_play
     * 目前只能填一个
     */
    private List<String> conditions;

    /**
     * 结束时间秒级时间戳
     */
    private Long end_time;
    /**
     * 开始时间秒级时间戳
     */
    private Long start_time;

    /**
     * 任务名称，只能是中英文+数字，长度不超过50个字符
     */
    private String task_name;

    /**
     * 抖音开放平台加密的视频id，和video_url二选一传入
     */
    private String item_id;

    /**
     * 抖音开放平台加密的视频id，和video_url二选一传入
     */
    private String video_url;

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public static CreateVideoTaskQueryBuilder builder() {
        return new CreateVideoTaskQueryBuilder();
    }
    public static class CreateVideoTaskQueryBuilder {
        private String taskName;
        private String itemId;
        private String videoUrl;
        private List<String> conditions;
        private Long startTime;
        private Long endTime;
        private String openId;
        private String clientKey;
        private Integer tenantId;

        public CreateVideoTaskQueryBuilder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }
        public CreateVideoTaskQueryBuilder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }
        public CreateVideoTaskQueryBuilder videoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }
        public CreateVideoTaskQueryBuilder conditions(List<String> conditions) {
            this.conditions = conditions;
            return this;
        }
        public CreateVideoTaskQueryBuilder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }
        public CreateVideoTaskQueryBuilder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }
        public CreateVideoTaskQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public CreateVideoTaskQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public CreateVideoTaskQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CreateVideoTaskQuery build() {
            CreateVideoTaskQuery createVideoTaskQuery = new CreateVideoTaskQuery();
            createVideoTaskQuery.setTask_name(taskName);
            createVideoTaskQuery.setItem_id(itemId);
            createVideoTaskQuery.setVideo_url(videoUrl);
            createVideoTaskQuery.setConditions(conditions);
            createVideoTaskQuery.setStart_time(startTime);
            createVideoTaskQuery.setEnd_time(endTime);
            createVideoTaskQuery.setOpen_id(openId);
            createVideoTaskQuery.setClientKey(clientKey);
            createVideoTaskQuery.setTenantId(tenantId);
            return createVideoTaskQuery;
        }
    }
}
