package com.dyj.web.domain;

/**
 * @author danmo
 * @date 2024-04-10 15:13
 **/
public class IntentionLog {

    /**
     * 详细互动记录对应 Webhook 内容
     */
    private String content;

    /**
     * 事件名
     */
    private String event;

    /**
     * 事件时间（毫秒级）
     */
    private String event_time;

    /**
     * 互动用户 open_id
     */
    private String open_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

}
