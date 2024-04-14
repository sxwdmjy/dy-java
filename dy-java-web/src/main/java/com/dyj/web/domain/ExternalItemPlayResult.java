package com.dyj.web.domain;

/**
 * 获取视频播放数据返回值
 */
public class ExternalItemPlayResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 每日播放数
     */
    private Long play;

    public String getDate() {
        return date;
    }

    public ExternalItemPlayResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getPlay() {
        return play;
    }

    public ExternalItemPlayResult setPlay(Long play) {
        this.play = play;
        return this;
    }
}
