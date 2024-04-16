package com.dyj.web.domain;

/**
 * 实时热点词
 */
public class TrendingSentencesData {

    /**
     * 热度 综合点赞、评论、转发等计算得出
     */
    private Long hot_level;
    /**
     * <p>&gt;标签:* `0` - 无 * `1` - 新 * `2` - 推荐 * `3` - 热 * `4` - 爆 * `5` - 首发 * `6` - 直播 * `7` - 同城 * `8` - 独家 * `9` - 挑战 * `10` - 当事人 * `11` - 剧集 * `12` - 电影 * `13` - 综艺 * `14` - 音乐 * `15` - 晚会 * `16` - 辟谣 * `17` - 热议 * `18` - 种草</p>
     */
    private Long label;
    /**
     * 热点词
     */
    private String sentence;

    public Long getHot_level() {
        return hot_level;
    }

    public TrendingSentencesData setHot_level(Long hot_level) {
        this.hot_level = hot_level;
        return this;
    }

    public Long getLabel() {
        return label;
    }

    public TrendingSentencesData setLabel(Long label) {
        this.label = label;
        return this;
    }

    public String getSentence() {
        return sentence;
    }

    public TrendingSentencesData setSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }
}
