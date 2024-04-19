package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-19 11:17
 **/
public class ItemCommentInfo {

    /**
     * 日期 yyyy-MM-dd
     */
    private String date;

    /**
     * 每日评论数
     */
    private String comment;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
