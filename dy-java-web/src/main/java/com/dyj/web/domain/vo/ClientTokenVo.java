package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-03 11:25
 **/
public class ClientTokenVo  extends BaseVo{

    /**
     * client_token 接口调用凭证
     */
    private String access_token;
    /**
     * access_token接口调用凭证超时时间，单位（秒)
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
