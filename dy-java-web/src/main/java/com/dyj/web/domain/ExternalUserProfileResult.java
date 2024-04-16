package com.dyj.web.domain;

/**
 * 获取用户主页访问数返回值
 */
public class ExternalUserProfileResult {

    /**
     * 日期
     */
    private String date;
    /**
     * 当日个人主页访问人数 选填
     */
    private Long profile_uv;

    public String getDate() {
        return date;
    }

    public ExternalUserProfileResult setDate(String date) {
        this.date = date;
        return this;
    }

    public Long getProfile_uv() {
        return profile_uv;
    }

    public ExternalUserProfileResult setProfile_uv(Long profile_uv) {
        this.profile_uv = profile_uv;
        return this;
    }
}
