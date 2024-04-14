package com.dyj.web.event;

/**
 * user.intention
 * 接收用户点赞事件
 */
public class NewVideoDiggEvent {

    /**
     * 点赞动作 1-点赞
     */
    private Integer action_type;

    /**
     * 点赞发生时间
     */
    private Long action_time;

    /**
     * 点赞视频 ID
     */
    private String item_id;

    public Integer getAction_type() {
        return action_type;
    }

    public void setAction_type(Integer action_type) {
        this.action_type = action_type;
    }

    public Long getAction_time() {
        return action_time;
    }

    public void setAction_time(Long action_time) {
        this.action_time = action_time;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
