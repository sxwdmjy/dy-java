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
}
