package com.dyj.web.domain;

/**
 * 直播榜
 */
public class LiveBillboard {

    /**
     * 直播封面 选填
     */
    private String cover;
    /**
     * 热度指数
     */
    private Double hot_value;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 直播标题 选填
     */
    private String title;

    public String getCover() {
        return cover;
    }

    public LiveBillboard setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public Double getHot_value() {
        return hot_value;
    }

    public LiveBillboard setHot_value(Double hot_value) {
        this.hot_value = hot_value;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public LiveBillboard setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public LiveBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LiveBillboard setTitle(String title) {
        this.title = title;
        return this;
    }
}
