package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-03 11:25
 **/
public class RefreshTokenVo  extends BaseVo{
    /**
     * 接口调用凭证
     */
    private String refresh_token;
    /**
     * access_token接口调用凭证超时时间，单位（秒)
     */
    private Integer expires_in;


    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "RefreshTokenVo{" +
                "refresh_token='" + refresh_token + '\'' +
                ", expires_in=" + expires_in +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
