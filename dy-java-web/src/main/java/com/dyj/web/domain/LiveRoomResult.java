package com.dyj.web.domain;

import java.util.List;

/**
 * 获取直播间互动数据返回值
 */
public class LiveRoomResult {

    /**
     * <p>数据就绪情况</p> 选填
     */
    private List<LiveRoomDataReadyStatus> data_ready_status;
    /**
     *  选填
     */
    private List<LiveRoomStats> stats;

    public List<LiveRoomDataReadyStatus> getData_ready_status() {
        return data_ready_status;
    }

    public LiveRoomResult setData_ready_status(List<LiveRoomDataReadyStatus> data_ready_status) {
        this.data_ready_status = data_ready_status;
        return this;
    }

    public List<LiveRoomStats> getStats() {
        return stats;
    }

    public LiveRoomResult setStats(List<LiveRoomStats> stats) {
        this.stats = stats;
        return this;
    }
}
