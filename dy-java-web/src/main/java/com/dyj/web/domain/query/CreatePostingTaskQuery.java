package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-11 13:51
 **/
public class CreatePostingTaskQuery extends BaseQuery {

    /**
     * 开始时间秒级时间戳
     */
    private Long start_time;

    /**
     * 开始时间秒级时间戳
     */
    private Long end_time;

    /**
     * 任务名称，长度不超过50个字符
     */
    private String task_name;

    /**
     * 任务条件
     */
    private PostingTaskCondition task_condition;

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public PostingTaskCondition getTask_condition() {
        return task_condition;
    }

    public void setTask_condition(PostingTaskCondition task_condition) {
        this.task_condition = task_condition;
    }

    public static CreatePostingTaskQueryBuild builder(){
        return new CreatePostingTaskQueryBuild();
    }

    public static class CreatePostingTaskQueryBuild{
        private String taskName;
        private Long startTime;
        private Long endTime;
        private PostingTaskCondition taskCondition;

        private String clientKey;
        private Integer tenantId;

        public CreatePostingTaskQueryBuild taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }
        public CreatePostingTaskQueryBuild startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }
        public CreatePostingTaskQueryBuild endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }
        public CreatePostingTaskQueryBuild taskCondition(PostingTaskCondition taskCondition) {
            this.taskCondition = taskCondition;
            return this;
        }
        public CreatePostingTaskQueryBuild clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CreatePostingTaskQueryBuild tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CreatePostingTaskQuery build(){
            CreatePostingTaskQuery createPostingTaskQuery = new CreatePostingTaskQuery();
            createPostingTaskQuery.setStart_time(startTime);
            createPostingTaskQuery.setEnd_time(endTime);
            createPostingTaskQuery.setTask_name(taskName);
            createPostingTaskQuery.setTask_condition(taskCondition);
            createPostingTaskQuery.setTenantId(tenantId);
            createPostingTaskQuery.setClientKey(clientKey);
            return createPostingTaskQuery;
        }
    }

    @Override
    public String toString() {
        return "CreatePostingTaskQuery{" +
                "start_time=" + start_time +
                ", end_time=" + end_time +
                ", task_name='" + task_name + '\'' +
                ", task_condition=" + task_condition +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
