package com.dyj.web.domain;

import java.util.List;

/**
 * 获取用户粉丝数据返回值
 */
public class ApiFansDataBindFansData {

    /**
     * 所有粉丝的数量
     */
    private Integer all_fans_num;
    /**
     * 粉丝活跃天数分布 item: ["0-4","5~8","9~12","13~16","17~20","20+"] 选填
     */
    private List<ItemValue> active_days_distributions;
    /**
     * 粉丝年龄分布 item: ["1-23", "24-30", "31-40", "41-50", "50-"] 选填
     */
    private List<ItemValue> age_distributions;
    /**
     * 粉丝设备分布 item: ["苹果","华为","三星","小米"...] 选填
     */
    private List<ItemValue> device_distributions;
    /**
     * 粉丝流量贡献 flow: ["vv","like_cnt","comment_cnt","share_video_cnt"] 选填
     */
    private List<ApiFansDataBindFansDataFlowContributions> flow_contributions;
    /**
     * 粉丝性别分布 item: ["1","2"] (男:1,女:2) 选填
     */
    private List<ItemValue> gender_distributions;
    /**
     * 粉丝地域分布 item: ["北京","福建","香港"...] 选填
     */
    private List<ItemValue> geographical_distributions;
    /**
     * 粉丝兴趣分布 item: ["生活","美食","旅行"...] 选填
     */
    private List<ItemValue> interest_distributions;


    public Integer getAll_fans_num() {
        return all_fans_num;
    }

    public ApiFansDataBindFansData setAll_fans_num(Integer all_fans_num) {
        this.all_fans_num = all_fans_num;
        return this;
    }

    public List<ItemValue> getActive_days_distributions() {
        return active_days_distributions;
    }

    public ApiFansDataBindFansData setActive_days_distributions(List<ItemValue> active_days_distributions) {
        this.active_days_distributions = active_days_distributions;
        return this;
    }

    public List<ItemValue> getAge_distributions() {
        return age_distributions;
    }

    public ApiFansDataBindFansData setAge_distributions(List<ItemValue> age_distributions) {
        this.age_distributions = age_distributions;
        return this;
    }

    public List<ItemValue> getDevice_distributions() {
        return device_distributions;
    }

    public ApiFansDataBindFansData setDevice_distributions(List<ItemValue> device_distributions) {
        this.device_distributions = device_distributions;
        return this;
    }

    public List<ApiFansDataBindFansDataFlowContributions> getFlow_contributions() {
        return flow_contributions;
    }

    public ApiFansDataBindFansData setFlow_contributions(List<ApiFansDataBindFansDataFlowContributions> flow_contributions) {
        this.flow_contributions = flow_contributions;
        return this;
    }

    public List<ItemValue> getGender_distributions() {
        return gender_distributions;
    }

    public ApiFansDataBindFansData setGender_distributions(List<ItemValue> gender_distributions) {
        this.gender_distributions = gender_distributions;
        return this;
    }

    public List<ItemValue> getGeographical_distributions() {
        return geographical_distributions;
    }

    public ApiFansDataBindFansData setGeographical_distributions(List<ItemValue> geographical_distributions) {
        this.geographical_distributions = geographical_distributions;
        return this;
    }

    public List<ItemValue> getInterest_distributions() {
        return interest_distributions;
    }

    public ApiFansDataBindFansData setInterest_distributions(List<ItemValue> interest_distributions) {
        this.interest_distributions = interest_distributions;
        return this;
    }
}
