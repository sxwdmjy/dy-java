package com.dyj.web.domain;

/**
 * 粉丝流量贡献 flow: ["vv","like_cnt","comment_cnt","share_video_cnt"]
 * @author ws
 **/
public class ApiFansDataBindFansDataFlowContributions {


    /**
     * 总流量贡献
     */
    private Long all_sum;
    /**
     * 粉丝流量贡献
     */
    private Long fans_sum;
    /**
     * <p>流量贡献种类</p><ul><li>vv</li><li>点赞</li><li>评论</li><li>分享</li></ul>
     */
    private String flow;


    public Long getAll_sum() {
        return all_sum;
    }

    public ApiFansDataBindFansDataFlowContributions setAll_sum(Long all_sum) {
        this.all_sum = all_sum;
        return this;
    }

    public Long getFans_sum() {
        return fans_sum;
    }

    public ApiFansDataBindFansDataFlowContributions setFans_sum(Long fans_sum) {
        this.fans_sum = fans_sum;
        return this;
    }

    public String getFlow() {
        return flow;
    }

    public ApiFansDataBindFansDataFlowContributions setFlow(String flow) {
        this.flow = flow;
        return this;
    }
}
