package com.dyj.common.domain.vo;

/**
 * @author danmo
 * @date 2024-04-03 11:25
 **/
public class BizTokenVo{

    /**
     * 经营关系调用凭证
     */
    private String biz_token;
    /**
     * 经营关系Token 的有效期长度，单位为秒
     */
    private Long biz_expires_in;

    /**
     * 经营关系 Token刷新凭证有效期
     */
    private Long biz_refresh_expires_in;
    /**
     * 经营关系 Token刷新凭证。用于在biz_token过期时，进行刷新。也可以通过重新获取 Token 处理。
     */
    private String biz_refresh_token;

    public String getBiz_token() {
        return biz_token;
    }

    public void setBiz_token(String biz_token) {
        this.biz_token = biz_token;
    }

    public Long getBiz_expires_in() {
        return biz_expires_in;
    }

    public void setBiz_expires_in(Long biz_expires_in) {
        this.biz_expires_in = biz_expires_in;
    }

    public Long getBiz_refresh_expires_in() {
        return biz_refresh_expires_in;
    }

    public void setBiz_refresh_expires_in(Long biz_refresh_expires_in) {
        this.biz_refresh_expires_in = biz_refresh_expires_in;
    }

    public String getBiz_refresh_token() {
        return biz_refresh_token;
    }

    public void setBiz_refresh_token(String biz_refresh_token) {
        this.biz_refresh_token = biz_refresh_token;
    }
}
