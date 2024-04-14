package com.dyj.web.event;

/**
 * 基础事件对象
 * @param <T>
 */
public class BaseEvent<T> {

    /**
     * 事件类型
     */
    private String event;

    /**
     * 应用Key
     */
    private String client_key;

    /**
     * 事件发起用户user_id   即为 open_id
     */
    private String from_user_id;

    /**
     * 事件接收用户user_id
     */
    private String to_user_id;

    private String log_id;
    /**
     * 时间内容
     */
    private T content;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(String from_user_id) {
        this.from_user_id = from_user_id;
    }

    public String getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(String to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
