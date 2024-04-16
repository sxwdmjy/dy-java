package com.dyj.web.domain.vo;

import java.util.List;

/**
 * 获取主播历史开播过的房间ID返回值
 * @author ws
 **/
public class GetRoomIdListVo {

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
    private List<Long> room_ids;

    public String getErr_msg() {
        return err_msg;
    }

    public GetRoomIdListVo setErr_msg(String err_msg) {
        this.err_msg = err_msg;
        return this;
    }

    public Integer getErr_no() {
        return err_no;
    }

    public GetRoomIdListVo setErr_no(Integer err_no) {
        this.err_no = err_no;
        return this;
    }

    public String getLog_id() {
        return log_id;
    }

    public GetRoomIdListVo setLog_id(String log_id) {
        this.log_id = log_id;
        return this;
    }

    public List<Long> getRoom_ids() {
        return room_ids;
    }

    public GetRoomIdListVo setRoom_ids(List<Long> room_ids) {
        this.room_ids = room_ids;
        return this;
    }
}
