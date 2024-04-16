package com.dyj.web.domain;

/**
 * 获取热点词聚合的视频返回值统计数据
 */
public class HotVideoListStatistics {

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
     * 播放数，只有作者本人可见。公开视频设为私密后，播放数也会返回0。
     */
    private Integer play_count;
    /**
     * 分享数
     */
    private Integer share_count;

    public Integer getComment_count() {
        return comment_count;
    }

    public HotVideoListStatistics setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
        return this;
    }

    public Integer getDigg_count() {
        return digg_count;
    }

    public HotVideoListStatistics setDigg_count(Integer digg_count) {
        this.digg_count = digg_count;
        return this;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public HotVideoListStatistics setDownload_count(Integer download_count) {
        this.download_count = download_count;
        return this;
    }

    public Integer getForward_count() {
        return forward_count;
    }

    public HotVideoListStatistics setForward_count(Integer forward_count) {
        this.forward_count = forward_count;
        return this;
    }

    public Integer getPlay_count() {
        return play_count;
    }

    public HotVideoListStatistics setPlay_count(Integer play_count) {
        this.play_count = play_count;
        return this;
    }

    public Integer getShare_count() {
        return share_count;
    }

    public HotVideoListStatistics setShare_count(Integer share_count) {
        this.share_count = share_count;
        return this;
    }
}
