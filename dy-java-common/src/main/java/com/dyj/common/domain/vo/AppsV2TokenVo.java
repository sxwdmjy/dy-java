package com.dyj.common.domain.vo;

/**
 * @author danmo
 * @date 2024-04-17 10:29
 **/
public class AppsV2TokenVo {

    /**
     * 获取的 access_tokenTip: token 是小程序级别 token，不要为每个用户单独分配一个 token，会导致 token 校验失败。建议每小时更新一次即可
     */
    private String access_token;

    /**
     * access_token 有效时间，单位：秒
     */
    private Long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}
