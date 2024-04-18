package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-18 18:21
 **/
public class ItemBaseInfo {
    /**
     * 最近30天平均播放时长
     */
    private Double avg_play_duration;
    /**
     * 最近30天评论数
     */
    private Long total_comment;
    /**
     * 最近30天点赞数
     */
    private Long total_like;
    /**
     * 最近30天播放次数
     */
    private Long total_play;
    /**
     * 最近30天分享数
     */
    private Long total_share;

    public Double getAvg_play_duration() {
        return avg_play_duration;
    }

    public void setAvg_play_duration(Double avg_play_duration) {
        this.avg_play_duration = avg_play_duration;
    }

    public Long getTotal_comment() {
        return total_comment;
    }

    public void setTotal_comment(Long total_comment) {
        this.total_comment = total_comment;
    }

    public Long getTotal_like() {
        return total_like;
    }

    public void setTotal_like(Long total_like) {
        this.total_like = total_like;
    }

    public Long getTotal_play() {
        return total_play;
    }

    public void setTotal_play(Long total_play) {
        this.total_play = total_play;
    }

    public Long getTotal_share() {
        return total_share;
    }

    public void setTotal_share(Long total_share) {
        this.total_share = total_share;
    }
}
