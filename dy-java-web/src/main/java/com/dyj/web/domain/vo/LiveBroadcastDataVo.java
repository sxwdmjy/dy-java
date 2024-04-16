package com.dyj.web.domain.vo;

import java.util.List;

/**
 * 直播数据接口返回数据
 */
public class LiveBroadcastDataVo <T> {

    /**
     *
     */
    private String err_msg;
    /**
     *
     */
    private Integer err_no;
    /**
     *
     */
    private String log_id;
    /**
     *
     */
    private List<T> room_ids;

    public String getErr_msg() {
        return err_msg;
    }

    public LiveBroadcastDataVo<T> setErr_msg(String err_msg) {
        this.err_msg = err_msg;
        return this;
    }

    public Integer getErr_no() {
        return err_no;
    }

    public LiveBroadcastDataVo<T> setErr_no(Integer err_no) {
        this.err_no = err_no;
        return this;
    }

    public String getLog_id() {
        return log_id;
    }

    public LiveBroadcastDataVo<T> setLog_id(String log_id) {
        this.log_id = log_id;
        return this;
    }

    public List<T> getRoom_ids() {
        return room_ids;
    }

    public LiveBroadcastDataVo<T> setRoom_ids(List<T> room_ids) {
        this.room_ids = room_ids;
        return this;
    }
}
