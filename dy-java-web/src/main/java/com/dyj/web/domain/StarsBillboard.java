package com.dyj.web.domain;

/**
 * 娱乐明星榜
 */
public class StarsBillboard {


    /**
     * 头像
     */
    private String avatar;
    /**
     * 影响力指数
     */
    private Double effect_value;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 排名
     */
    private Integer rank;

    public String getAvatar() {
        return avatar;
    }

    public StarsBillboard setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Double getEffect_value() {
        return effect_value;
    }

    public StarsBillboard setEffect_value(Double effect_value) {
        this.effect_value = effect_value;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public StarsBillboard setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public StarsBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }
}
