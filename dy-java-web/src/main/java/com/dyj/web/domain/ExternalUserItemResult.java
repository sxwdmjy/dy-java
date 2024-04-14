package com.dyj.web.domain;

/**
 * 获取用户视频情况返回值
 */
public class ExternalUserItemResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 每日发布内容数 选填
     */
    private Long new_issue;
    /**
     * 每日新增视频播放 选填
     */
    private Long new_play;
    /**
     * <p>总发布内容数</p> 选填
     */
    private Long total_issue;

    public String getDate() {
        return date;
    }

    public ExternalUserItemResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getNew_issue() {
        return new_issue;
    }

    public ExternalUserItemResult setNew_issue(Long new_issue) {
        this.new_issue = new_issue;
        return this;
    }

    public Long getNew_play() {
        return new_play;
    }

    public ExternalUserItemResult setNew_play(Long new_play) {
        this.new_play = new_play;
        return this;
    }

    public Long getTotal_issue() {
        return total_issue;
    }

    public ExternalUserItemResult setTotal_issue(Long total_issue) {
        this.total_issue = total_issue;
        return this;
    }
}
