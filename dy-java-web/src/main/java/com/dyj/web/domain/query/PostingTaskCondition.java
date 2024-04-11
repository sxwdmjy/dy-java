package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-11 13:52
 **/
public class PostingTaskCondition {

    /**
     * 收藏:collection
     * 评论:comment
     * 点赞:digg
     * 播放:play
     * 分享:share
     * 下载:download
     */
    private String condition;

    /**
     * 右区间, 播放数:最大为1000w, 其他:最大10w
     */
    private Integer max_value;
    /**
     * 左区间, 最小为0
     */
    private Integer min_value;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getMax_value() {
        return max_value;
    }

    public void setMax_value(Integer max_value) {
        this.max_value = max_value;
    }

    public Integer getMin_value() {
        return min_value;
    }

    public void setMin_value(Integer min_value) {
        this.min_value = min_value;
    }

    @Override
    public String toString() {
        return "PostingTaskCondition{" +
                "condition='" + condition + '\'' +
                ", max_value=" + max_value +
                ", min_value=" + min_value +
                '}';
    }
}
