package com.dyj.web.domain;

/**
 * 获取直播间互动数据返回值stats
 */
public class LiveRoomStats {

    /**
     * <p>房间id</p>
     */
    private String item;
    /**
     * <p>3-房间，2-主播，1-用户</p>
     */
    private Integer item_type;
    /**
     * <p>1-抖火 3-西瓜头条</p>
     */
    private Long live_id;

    /**
     * "live_comment_ucnt_td"-直播间发送评论人数
     * "live_comment_cnt_td"-直播间评论次数
     * "live_share_cnt_td"- 直播间被转发次数
     * "live_like_cnt_td"- 直播间有点赞行为的次数
     *
     * "live_watch_cnt_td"-直播间当日观看次数
     * "live_watch_ucnt_td"-直播间当日观看人数
     * "live_watch_duration_td"-直播间当日观看总时长
     * "per_minute_watch_ucnt_td_max"-直播间最高同时在线人数
     * "live_fans_watch_ucnt_td"-粉丝观看人数
     * "live_fans_watch_duration_td"-粉丝观看总时长
     *
     * "live_start_ts"-直播开始时间
     * "live_end_ts"-直播结束时间
     * "live_duration_td"-直播时长
     * "live_follow_ucnt_td"-直播间内点击关注的人数
     */
    private String name;
    /**
     * <p>“2021-05-05”</p>
     */
    private String timeslot;
    /**
     *
     */
    private Long value;
    /**
     *
     */
    private Double value_float;

    public String getItem() {
        return item;
    }

    public LiveRoomStats setItem(String item) {
        this.item = item;
        return this;
    }

    public Integer getItem_type() {
        return item_type;
    }

    public LiveRoomStats setItem_type(Integer item_type) {
        this.item_type = item_type;
        return this;
    }

    public Long getLive_id() {
        return live_id;
    }

    public LiveRoomStats setLive_id(Long live_id) {
        this.live_id = live_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LiveRoomStats setName(String name) {
        this.name = name;
        return this;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public LiveRoomStats setTimeslot(String timeslot) {
        this.timeslot = timeslot;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public LiveRoomStats setValue(Long value) {
        this.value = value;
        return this;
    }

    public Double getValue_float() {
        return value_float;
    }

    public LiveRoomStats setValue_float(Double value_float) {
        this.value_float = value_float;
        return this;
    }
}
