package com.dyj.web.domain;

/**
 * 获取用户粉丝喜好返回值
 */
public class GetFansFavouriteResult {

    /**
     * 热度指数
     */
    private Long hot_value;
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 排名
     */
    private Integer rank;

    public Long getHot_value() {
        return hot_value;
    }

    public GetFansFavouriteResult setHot_value(Long hot_value) {
        this.hot_value = hot_value;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public GetFansFavouriteResult setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public GetFansFavouriteResult setRank(Integer rank) {
        this.rank = rank;
        return this;
    }
}
