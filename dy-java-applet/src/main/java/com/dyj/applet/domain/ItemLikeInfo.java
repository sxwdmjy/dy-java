package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-18 18:39
 **/
public class ItemLikeInfo {

    /**
     * 日期 yyyy-MM-dd
     */
    private String date;

    /**
     * 每日点赞数
     */
    private String like;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
