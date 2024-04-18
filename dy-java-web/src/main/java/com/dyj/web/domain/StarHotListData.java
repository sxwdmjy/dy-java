package com.dyj.web.domain;

import java.util.List;

/**
 * 获取抖音星图达人热榜返回值下的list里的值
 */
public class StarHotListData {

    /**
     * 粉丝数 选填
     */
    private Long follower;
    /**
     * 达人昵称 选填
     */
    private String nick_name;
    /**
     * 热榜排名 选填
     */
    private Long rank;
    /**
     * 热榜类型对应的热榜指数 选填
     */
    private Double score;
    /**
     * 抖音号 选填
     */
    private String unique_id;
    /**
     *  选填
     */
    private List<String> tags;

    public Long getFollower() {
        return follower;
    }

    public StarHotListData setFollower(Long follower) {
        this.follower = follower;
        return this;
    }

    public String getNick_name() {
        return nick_name;
    }

    public StarHotListData setNick_name(String nick_name) {
        this.nick_name = nick_name;
        return this;
    }

    public Long getRank() {
        return rank;
    }

    public StarHotListData setRank(Long rank) {
        this.rank = rank;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public StarHotListData setScore(Double score) {
        this.score = score;
        return this;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public StarHotListData setUnique_id(String unique_id) {
        this.unique_id = unique_id;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public StarHotListData setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }
}
