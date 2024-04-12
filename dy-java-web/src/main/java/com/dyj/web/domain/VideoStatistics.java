package com.dyj.web.domain;

public class VideoStatistics {

    /**
     * 评论数
     */
    private Integer comment_count;

     /**
     * 点赞数
     */
    private Integer digg_count;

    /**
     * 下载数
     */
    private Integer download_count;

    /**
     * 转发数
     */
    private Integer forward_count;

    /**
     * 播放数
     */
    private Integer play_count;

    /**
     * 分享数
     */
    private Integer share_count;

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(Integer digg_count) {
        this.digg_count = digg_count;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    public Integer getForward_count() {
        return forward_count;
    }

    public void setForward_count(Integer forward_count) {
        this.forward_count = forward_count;
    }

    public Integer getPlay_count() {
        return play_count;
    }

    public void setPlay_count(Integer play_count) {
        this.play_count = play_count;
    }

    public Integer getShare_count() {
        return share_count;
    }

    public void setShare_count(Integer share_count) {
        this.share_count = share_count;
    }
}
