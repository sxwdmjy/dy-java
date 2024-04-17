package com.dyj.web.domain;

import com.dyj.common.domain.vo.BaseVo;

/**
 * 获取抖音星图达人指数返回值
 */
public class StarAuthorScoreResult extends BaseVo {

    /**
     * 合作指数 选填
     */
    private Double cooperation_score;
    /**
     * 性价比指数 选填
     */
    private Double cp_score;

    /**
     * 粉丝数 选填
     */
    private Long follower;
    /**
     * 涨粉指数 选填
     */
    private Double growth_score;
    /**
     * 达人昵称 选填
     */
    private String nick_name;
    /**
     * 种草指数 选填
     */
    private Double shop_score;
    /**
     * 传播指数 选填
     */
    private Double spread_score;
    /**
     * 星图指数 选填
     */
    private Double star_score;
    /**
     * 达人指数更新时间戳 选填
     */
    private Long update_timestamp;

    public Double getCooperation_score() {
        return cooperation_score;
    }

    public StarAuthorScoreResult setCooperation_score(Double cooperation_score) {
        this.cooperation_score = cooperation_score;
        return this;
    }

    public Double getCp_score() {
        return cp_score;
    }

    public StarAuthorScoreResult setCp_score(Double cp_score) {
        this.cp_score = cp_score;
        return this;
    }

    public Long getFollower() {
        return follower;
    }

    public StarAuthorScoreResult setFollower(Long follower) {
        this.follower = follower;
        return this;
    }

    public Double getGrowth_score() {
        return growth_score;
    }

    public StarAuthorScoreResult setGrowth_score(Double growth_score) {
        this.growth_score = growth_score;
        return this;
    }

    public String getNick_name() {
        return nick_name;
    }

    public StarAuthorScoreResult setNick_name(String nick_name) {
        this.nick_name = nick_name;
        return this;
    }

    public Double getShop_score() {
        return shop_score;
    }

    public StarAuthorScoreResult setShop_score(Double shop_score) {
        this.shop_score = shop_score;
        return this;
    }

    public Double getSpread_score() {
        return spread_score;
    }

    public StarAuthorScoreResult setSpread_score(Double spread_score) {
        this.spread_score = spread_score;
        return this;
    }

    public Double getStar_score() {
        return star_score;
    }

    public StarAuthorScoreResult setStar_score(Double star_score) {
        this.star_score = star_score;
        return this;
    }

    public Long getUpdate_timestamp() {
        return update_timestamp;
    }

    public StarAuthorScoreResult setUpdate_timestamp(Long update_timestamp) {
        this.update_timestamp = update_timestamp;
        return this;
    }
}
