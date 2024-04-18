package com.dyj.web.domain;

import java.util.List;

/**
 * 获取抖音电影榜、抖音电视剧榜、抖音综艺榜 实时热点词
 */
public class DiscoveryEntRankItemHotSpot {

    /**
     * 视频讨论度 选填
     */
    private Long discussion_hot;
    /**
     * 热度值 选填
     */
    private Long hot;
    /**
     * 影片ID 选填
     */
    private String id;
    /**
     * 账号影响力 选填
     */
    private Long influence_hot;
    /**
     * 猫眼id：只有电影榜返回，可能为空 选填
     */
    private String maoyan_id;
    /**
     * 片名 选填
     */
    private String name;
    /**
     * 英文片名 选填
     */
    private String name_en;
    /**
     * 海报 选填
     */
    private String poster;
    /**
     * 上映时间 选填
     */
    private String release_date;
    /**
     * 搜索指数 选填
     */
    private Long search_hot;
    /**
     * 话题热度值 选填
     */
    private Long topic_hot;
    /**
     * 类型：1=电影 2=电视剧 3=综艺 选填
     */
    private Long type;
    /**
     * 演员 选填
     */
    private List<String> actors;
    /**
     * 地区 选填
     */
    private List<String> areas;
    /**
     * 导演 选填
     */
    private List<String> directors;
    /**
     * 类型标签 选填
     */
    private List<String> tags;


    public Long getDiscussion_hot() {
        return discussion_hot;
    }

    public DiscoveryEntRankItemHotSpot setDiscussion_hot(Long discussion_hot) {
        this.discussion_hot = discussion_hot;
        return this;
    }

    public Long getHot() {
        return hot;
    }

    public DiscoveryEntRankItemHotSpot setHot(Long hot) {
        this.hot = hot;
        return this;
    }

    public String getId() {
        return id;
    }

    public DiscoveryEntRankItemHotSpot setId(String id) {
        this.id = id;
        return this;
    }

    public Long getInfluence_hot() {
        return influence_hot;
    }

    public DiscoveryEntRankItemHotSpot setInfluence_hot(Long influence_hot) {
        this.influence_hot = influence_hot;
        return this;
    }

    public String getMaoyan_id() {
        return maoyan_id;
    }

    public DiscoveryEntRankItemHotSpot setMaoyan_id(String maoyan_id) {
        this.maoyan_id = maoyan_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DiscoveryEntRankItemHotSpot setName(String name) {
        this.name = name;
        return this;
    }

    public String getName_en() {
        return name_en;
    }

    public DiscoveryEntRankItemHotSpot setName_en(String name_en) {
        this.name_en = name_en;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public DiscoveryEntRankItemHotSpot setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public String getRelease_date() {
        return release_date;
    }

    public DiscoveryEntRankItemHotSpot setRelease_date(String release_date) {
        this.release_date = release_date;
        return this;
    }

    public Long getSearch_hot() {
        return search_hot;
    }

    public DiscoveryEntRankItemHotSpot setSearch_hot(Long search_hot) {
        this.search_hot = search_hot;
        return this;
    }

    public Long getTopic_hot() {
        return topic_hot;
    }

    public DiscoveryEntRankItemHotSpot setTopic_hot(Long topic_hot) {
        this.topic_hot = topic_hot;
        return this;
    }

    public Long getType() {
        return type;
    }

    public DiscoveryEntRankItemHotSpot setType(Long type) {
        this.type = type;
        return this;
    }

    public List<String> getActors() {
        return actors;
    }

    public DiscoveryEntRankItemHotSpot setActors(List<String> actors) {
        this.actors = actors;
        return this;
    }

    public List<String> getAreas() {
        return areas;
    }

    public DiscoveryEntRankItemHotSpot setAreas(List<String> areas) {
        this.areas = areas;
        return this;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public DiscoveryEntRankItemHotSpot setDirectors(List<String> directors) {
        this.directors = directors;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public DiscoveryEntRankItemHotSpot setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }
}
