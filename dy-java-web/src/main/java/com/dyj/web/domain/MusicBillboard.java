package com.dyj.web.domain;

/**
 * 音乐榜单
 */
public class MusicBillboard {

    /**
     * 作者昵称
     */
    private String author;
    /**
     * 音乐封面 选填
     */
    private String cover;
    /**
     * 时长，精确到秒
     */
    private Integer duration;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 音乐分享链接 选填
     */
    private String share_url;
    /**
     * 歌曲标题 选填
     */
    private String title;
    /**
     * 使用量
     */
    private Long use_count;

    public String getAuthor() {
        return author;
    }

    public MusicBillboard setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public MusicBillboard setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public MusicBillboard setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public MusicBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getShare_url() {
        return share_url;
    }

    public MusicBillboard setShare_url(String share_url) {
        this.share_url = share_url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MusicBillboard setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getUse_count() {
        return use_count;
    }

    public MusicBillboard setUse_count(Long use_count) {
        this.use_count = use_count;
        return this;
    }
}
