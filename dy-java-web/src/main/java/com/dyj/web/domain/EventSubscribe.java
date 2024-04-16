package com.dyj.web.domain;

/**
 * @author danmo
 * @date 2024-04-12 17:39
 **/
public class EventSubscribe {

    /**
     * 推送事件名称
     */
    private String event;

    /**
     * 事件订阅状态 * `0` - 未订阅 * `1` - 已订阅
     */
    private Integer status;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static EventSubscribeBuild builder() {
        return new EventSubscribeBuild();
    }

    public static class EventSubscribeBuild {
        private String event;
        private Integer status;
        public EventSubscribeBuild event(String event) {
            this.event = event;
            return this;
        }
        public EventSubscribeBuild status(Integer status) {
            this.status = status;
            return this;
        }
        public EventSubscribe build() {
            EventSubscribe eventSubscribe = new EventSubscribe();
            eventSubscribe.setEvent(event);
            eventSubscribe.setStatus(status);
            return eventSubscribe;
        }
    }
}
