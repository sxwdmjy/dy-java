package com.dyj.web.domain;

import java.util.List;

/**
 * 数据开放接口榜单
 */
public class ExternDataBillboard {

    /**
     * 头像
     */
    private String avatar;
    /**
     * 影响力指数
     */
    private Double effect_value;
    /**
     * 粉丝数
     */
    private Long follower_count;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 近一月在榜次数
     */
    private Integer onbillbaord_times;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 排名变化, 如果上一期未上榜用-表示
     */
    private String rank_change;
    /**
     * 视频列表 选填
     */
    private List<ExternDataBillboardVideo> video_list;

    public String getAvatar() {
        return avatar;
    }

    public ExternDataBillboard setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Double getEffect_value() {
        return effect_value;
    }

    public ExternDataBillboard setEffect_value(Double effect_value) {
        this.effect_value = effect_value;
        return this;
    }

    public Long getFollower_count() {
        return follower_count;
    }

    public ExternDataBillboard setFollower_count(Long follower_count) {
        this.follower_count = follower_count;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public ExternDataBillboard setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Integer getOnbillbaord_times() {
        return onbillbaord_times;
    }

    public ExternDataBillboard setOnbillbaord_times(Integer onbillbaord_times) {
        this.onbillbaord_times = onbillbaord_times;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public ExternDataBillboard setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getRank_change() {
        return rank_change;
    }

    public ExternDataBillboard setRank_change(String rank_change) {
        this.rank_change = rank_change;
        return this;
    }

    public List<ExternDataBillboardVideo> getVideo_list() {
        return video_list;
    }

    public ExternDataBillboard setVideo_list(List<ExternDataBillboardVideo> video_list) {
        this.video_list = video_list;
        return this;
    }
}
