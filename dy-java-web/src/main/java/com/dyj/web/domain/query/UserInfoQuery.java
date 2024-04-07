package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-07 14:56
 **/
public class UserInfoQuery extends BaseQuery{

    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
