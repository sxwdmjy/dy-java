package com.dyj.web.domain.query;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-07 16:52
 **/
public class UserRoleCheckQuery extends UserInfoQuery {

    /**
     * 用户抖音号。
     * 与open_id字段必须传一个，如果都传会以open_id为第一优先级进行查询。
     */
    private String douyin_shortId;

    /**
     * 多个身份信息枚举数组，可以根据需求传以下字段列表：
     * COMPANY_BAND：企业号品牌号
     * AUTH_COMPANY：认证企业号
     * STAFF：员工号
     * OPEN_BRAND：开平品牌号
     * OPEN_STAFF：开平员工号
     * OPEN_PARTNER：开平合作号
     */
    private List<String> role_labels;


    public String getDouyin_shortId() {
        return douyin_shortId;
    }

    public void setDouyin_shortId(String douyin_shortId) {
        this.douyin_shortId = douyin_shortId;
    }

    public List<String> getRole_labels() {
        return role_labels;
    }

    public void setRole_labels(List<String> role_labels) {
        this.role_labels = role_labels;
    }

    @Override
    public String toString() {
        return "UserRoleCheckQuery{" +
                "douyin_shortId='" + douyin_shortId + '\'' +
                ", role_labels=" + role_labels +
                ", open_id='" + open_id + '\'' +
                '}';
    }
}
