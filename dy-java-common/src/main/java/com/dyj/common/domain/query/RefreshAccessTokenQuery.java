package com.dyj.common.domain.query;

/**
 * @author danmo
 * @date 2024-04-03 11:34
 **/
public class RefreshAccessTokenQuery {

    /**
     * 应用唯一标识
     */
    private String client_key;

    /**
     * 填写通过 access_token 获取到的 refresh_token 参数
     */
    private String refresh_token;


    private String grant_type = "refresh_token";


    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
