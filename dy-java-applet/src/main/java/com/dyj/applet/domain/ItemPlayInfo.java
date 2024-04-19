package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-19 11:17
 **/
public class ItemPlayInfo {

    /**
     * 日期 yyyy-MM-dd
     */
    private String date;

    /**
     * 每日播放数
     */
    private String play;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }
}
