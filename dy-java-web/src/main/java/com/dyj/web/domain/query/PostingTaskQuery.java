package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-11 14:00
 **/
public class PostingTaskQuery extends UserInfoQuery{

    /**
     * 任务ID
     */
    private String task_id;

    /**
     * 视频ID
     */
    private String video_id;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public static PostingTaskQueryBuild builder() {
        return new PostingTaskQueryBuild();
    }

    public static class PostingTaskQueryBuild {
        private String taskId;
        private String videoId;
        private Integer tenantId;
        private String clientKey;
        private String openId;
        public PostingTaskQueryBuild taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }
        public PostingTaskQueryBuild videoId(String videoId) {
            this.videoId = videoId;
            return this;
        }
        public PostingTaskQueryBuild tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public PostingTaskQueryBuild clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public PostingTaskQueryBuild openId(String openId) {
            this.openId = openId;
            return this;
        }

        public PostingTaskQuery build() {
            PostingTaskQuery postingTaskQuery = new PostingTaskQuery();
            postingTaskQuery.setTask_id(taskId);
            postingTaskQuery.setVideo_id(videoId);
            postingTaskQuery.setTenantId(tenantId);
            postingTaskQuery.setClientKey(clientKey);
            postingTaskQuery.setOpen_id(openId);
            return postingTaskQuery;
        }
    }


}
