package com.dyj.web.event;

/**
 * user.intention
 * 接收用户关注事件
 */
public class NewFollowActionEvent {

    /**
     * 关注动作
     * 1-关注
     */
    private String action_type;

    /**
     * 关注发生时间
     */
    private Long action_time;

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public Long getAction_time() {
        return action_time;
    }

    public void setAction_time(Long action_time) {
        this.action_time = action_time;
    }
}
