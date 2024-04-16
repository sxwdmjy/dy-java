package com.dyj.common.domain.query;

/**
 * @author danmo
 * @date 2024-04-03 11:34
 **/
public class ClientTokenQuery {

    /**
     * 应用唯一标识，对应小程序id
     */
    private String client_key;

    /**
     * 应用唯一标识对应的密钥，对应小程序的app secret，可以在开发者后台获取
     */
    private String client_secret;


    /**
     * 固定值"client_credential"
     */
    private final String grant_type = "client_credential";


    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }
}
