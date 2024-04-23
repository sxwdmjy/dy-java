package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-23 14:02
 **/
public class CreateLiveTaskQuery extends UserInfoQuery {

    /**
     * live_watch直播观看
     * live_digg直播点赞
     * live_share直播分享
     * 目前只能填一个
     */
    private List<String> conditions;

    /**
     * live_watch直播观看
     * live_digg直播点赞
     * 目前只能填一个
     */
    private List<String> condition_value;

    /**
     * 直播结束时间(秒)
     */
    private Long end_time;
    /**
     * 直播开始时间(秒)
     */
    private Long start_time;

    /**
     * 任务名称，只能是中英文+数字，长度不超过50个字符
     */
    private String task_name;

    /**
     * 主播抖音号
     */
    private String aweme_id;

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public List<String> getCondition_value() {
        return condition_value;
    }

    public void setCondition_value(List<String> condition_value) {
        this.condition_value = condition_value;
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

    public String getAweme_id() {
        return aweme_id;
    }

    public void setAweme_id(String aweme_id) {
        this.aweme_id = aweme_id;
    }

    public static CreateVideoQueryBuilder builder() {
        return new CreateVideoQueryBuilder();
    }

    public static class CreateVideoQueryBuilder {
        private String taskName;

        private String awemeId;
        private List<String> conditions;
        private List<String> conditionValue;
        private Long startTime;
        private Long endTime;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        public CreateVideoQueryBuilder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }
        public CreateVideoQueryBuilder awemeId(String awemeId) {
            this.awemeId = awemeId;
            return this;
        }
        public CreateVideoQueryBuilder conditions(List<String> conditions) {
            this.conditions = conditions;
            return this;
        }
        public CreateVideoQueryBuilder conditionValue(List<String> conditionValue) {
            this.conditionValue = conditionValue;
            return this;
        }
        public CreateVideoQueryBuilder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }
        public CreateVideoQueryBuilder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }
        public CreateVideoQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public CreateVideoQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public CreateVideoQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public CreateLiveTaskQuery build() {
            CreateLiveTaskQuery createLiveTaskQuery = new CreateLiveTaskQuery();
            createLiveTaskQuery.setTask_name(taskName);
            createLiveTaskQuery.setAweme_id(awemeId);
            createLiveTaskQuery.setConditions(conditions);
            createLiveTaskQuery.setCondition_value(conditionValue);
            createLiveTaskQuery.setStart_time(startTime);
            createLiveTaskQuery.setEnd_time(endTime);
            createLiveTaskQuery.setOpen_id(openId);
            createLiveTaskQuery.setTenantId(tenantId);
            createLiveTaskQuery.setClientKey(clientKey);
            return createLiveTaskQuery;
        }
    }
}
