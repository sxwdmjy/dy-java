package com.dyj.web.domain;

/**
 * 话题榜
 */
public class TopicBillboard {



    /**
     * 影响力指数
     */
    private Double effect_value;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 排名变化
     */
    private String rank_change;
    /**
     * 话题标题 选填
     */
    private String title;

    public Double getEffect_value() {
        return effect_value;
    }

    public TopicBillboard setEffect_value(Double effect_value) {
        this.effect_value = effect_value;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public TopicBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getRank_change() {
        return rank_change;
    }

    public TopicBillboard setRank_change(String rank_change) {
        this.rank_change = rank_change;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TopicBillboard setTitle(String title) {
        this.title = title;
        return this;
    }
}
