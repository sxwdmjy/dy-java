package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-11 14:00
 **/
public class ConfirmPostingTaskQuery extends UserInfoQuery{

    /**
     * 任务ID
     */
    private String task_id;

    /**
     * 目标用户open_id
     */
    private String target_open_id;

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

    public String getTarget_open_id() {
        return target_open_id;
    }

    public void setTarget_open_id(String target_open_id) {
        this.target_open_id = target_open_id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public static ConfirmPostingTaskQueryBuild builder() {
        return new ConfirmPostingTaskQueryBuild();
    }

    public static class ConfirmPostingTaskQueryBuild {
        private String taskId;
        private String targetOpenId;
        private String videoId;
        private Integer tenantId;
        private String clientKey;
        private String openId;
        public ConfirmPostingTaskQueryBuild taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }
        public ConfirmPostingTaskQueryBuild targetOpenId(String targetOpenId) {
            this.targetOpenId = targetOpenId;
            return this;
        }
        public ConfirmPostingTaskQueryBuild videoId(String videoId) {
            this.videoId = videoId;
            return this;
        }
        public ConfirmPostingTaskQueryBuild tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public ConfirmPostingTaskQueryBuild clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public ConfirmPostingTaskQueryBuild openId(String openId) {
            this.openId = openId;
            return this;
        }

        public ConfirmPostingTaskQuery build() {
            ConfirmPostingTaskQuery postingTaskQuery = new ConfirmPostingTaskQuery();
            postingTaskQuery.setTask_id(taskId);
            postingTaskQuery.setTarget_open_id(targetOpenId);
            postingTaskQuery.setVideo_id(videoId);
            postingTaskQuery.setTenantId(tenantId);
            postingTaskQuery.setClientKey(clientKey);
            postingTaskQuery.setOpen_id(openId);
            return postingTaskQuery;
        }
    }

    @Override
    public String toString() {
        return "ConfirmPostingTaskQuery{" +
                "task_id='" + task_id + '\'' +
                ", target_open_id='" + target_open_id + '\'' +
                ", video_id='" + video_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
