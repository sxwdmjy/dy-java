package com.dyj.web.domain;

/**
 * 实时热点词
 */
public class HotSentencesData {

    /**
     * 热度 综合点赞、评论、转发等计算得出
     */
    private Long hot_level;
    /**
     * 热点词
     */
    private String sentence;

    public Long getHot_level() {
        return hot_level;
    }

    public HotSentencesData setHot_level(Long hot_level) {
        this.hot_level = hot_level;
        return this;
    }

    public String getSentence() {
        return sentence;
    }

    public HotSentencesData setSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }
}
