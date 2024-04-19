package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-19 11:17
 **/
public class ItemShareInfo {

    /**
     * 日期 yyyy-MM-dd
     */
    private String date;

    /**
     * 每日播放数
     */
    private String share;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
