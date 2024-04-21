package com.dyj.web.domain;

/**
 * 热门视频榜
 */
public class GetHotVideoBillboard {

    /**
     * 视频发布者
     */
    private String author;
    /**
     * 评论数，离线数据（统计前一日数据）
     */
    private Long comment_count;
    /**
     * 点赞数，离线数据（统计前一日数据）
     */
    private Long digg_count;
    /**
     * 热度指数
     */
    private Double hot_value;
    /**
     * 视频热词（以,隔开） 选填
     */
    private String hot_words;
    /**
     * 视频封面图
     */
    private String item_cover;
    /**
     * 播放数，离线数据（统计前一日数据）
     */
    private Long play_count;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 视频播放页面。视频播放页可能会失效，请在观看视频前调用/video/data/获取最新的播放页。
     */
    private String share_url;
    /**
     * 视频标题 选填
     */
    private String title;

    public String getAuthor() {
        return author;
    }

    public GetHotVideoBillboard setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Long getComment_count() {
        return comment_count;
    }

    public GetHotVideoBillboard setComment_count(Long comment_count) {
        this.comment_count = comment_count;
        return this;
    }

    public Long getDigg_count() {
        return digg_count;
    }

    public GetHotVideoBillboard setDigg_count(Long digg_count) {
        this.digg_count = digg_count;
        return this;
    }

    public Double getHot_value() {
        return hot_value;
    }

    public GetHotVideoBillboard setHot_value(Double hot_value) {
        this.hot_value = hot_value;
        return this;
    }

    public String getHot_words() {
        return hot_words;
    }

    public GetHotVideoBillboard setHot_words(String hot_words) {
        this.hot_words = hot_words;
        return this;
    }

    public String getItem_cover() {
        return item_cover;
    }

    public GetHotVideoBillboard setItem_cover(String item_cover) {
        this.item_cover = item_cover;
        return this;
    }

    public Long getPlay_count() {
        return play_count;
    }

    public GetHotVideoBillboard setPlay_count(Long play_count) {
        this.play_count = play_count;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public GetHotVideoBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getShare_url() {
        return share_url;
    }

    public GetHotVideoBillboard setShare_url(String share_url) {
        this.share_url = share_url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GetHotVideoBillboard setTitle(String title) {
        this.title = title;
        return this;
    }
}
