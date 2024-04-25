package com.dyj.web.domain;

/**
 * 道具榜
 */
public class PropBillboard {

    /**
     * 日收藏数，离线数据（统计前一日数据）
     */
    private Double daily_collection_cnt;
    /**
     * 日投稿量，离线数据（统计前一日数据）
     */
    private Double daily_issue_cnt;
    /**
     * 日投稿占比，格式:XX.XX% 精确小数点后2位 离线数据（统计前一日数据）
     */
    private String daily_issue_percent;
    /**
     * 日播放数，离线数据（统计前一日数据）
     */
    private Double daily_play_cnt;
    /**
     * 影响力指数
     */
    private Double effect_value;
    /**
     * 道具名 选填
     */
    private String name;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 排名变化
     */
    private String rank_change;
    /**
     * 开拍量，离线数据（统计前一日数据）
     */
    private Double shoot_cnt;
    /**
     * 展现量，离线数据（统计前一日数据）
     */
    private Double show_cnt;

    public Double getDaily_collection_cnt() {
        return daily_collection_cnt;
    }

    public PropBillboard setDaily_collection_cnt(Double daily_collection_cnt) {
        this.daily_collection_cnt = daily_collection_cnt;
        return this;
    }

    public Double getDaily_issue_cnt() {
        return daily_issue_cnt;
    }

    public PropBillboard setDaily_issue_cnt(Double daily_issue_cnt) {
        this.daily_issue_cnt = daily_issue_cnt;
        return this;
    }

    public String getDaily_issue_percent() {
        return daily_issue_percent;
    }

    public PropBillboard setDaily_issue_percent(String daily_issue_percent) {
        this.daily_issue_percent = daily_issue_percent;
        return this;
    }

    public Double getDaily_play_cnt() {
        return daily_play_cnt;
    }

    public PropBillboard setDaily_play_cnt(Double daily_play_cnt) {
        this.daily_play_cnt = daily_play_cnt;
        return this;
    }

    public Double getEffect_value() {
        return effect_value;
    }

    public PropBillboard setEffect_value(Double effect_value) {
        this.effect_value = effect_value;
        return this;
    }

    public String getName() {
        return name;
    }

    public PropBillboard setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public PropBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getRank_change() {
        return rank_change;
    }

    public PropBillboard setRank_change(String rank_change) {
        this.rank_change = rank_change;
        return this;
    }

    public Double getShoot_cnt() {
        return shoot_cnt;
    }

    public PropBillboard setShoot_cnt(Double shoot_cnt) {
        this.shoot_cnt = shoot_cnt;
        return this;
    }

    public Double getShow_cnt() {
        return show_cnt;
    }

    public PropBillboard setShow_cnt(Double show_cnt) {
        this.show_cnt = show_cnt;
        return this;
    }
}
