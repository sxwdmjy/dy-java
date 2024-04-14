package com.dyj.web.domain.vo;

import com.dyj.web.domain.ApiFansDataBindFansData;

/**
 * 获取用户粉丝数据返回值
 */
public class ApiFansDataBindFansVo {

    private ApiFansDataBindFansData fans_data;

    public ApiFansDataBindFansData getFans_data() {
        return fans_data;
    }

    public ApiFansDataBindFansVo setFans_data(ApiFansDataBindFansData fans_data) {
        this.fans_data = fans_data;
        return this;
    }
}
