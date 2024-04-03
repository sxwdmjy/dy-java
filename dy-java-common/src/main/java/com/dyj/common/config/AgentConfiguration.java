package com.dyj.common.config;

/**
 * @author danmo
 * @date 2024-04-02 14:02
 **/
public class AgentConfiguration {

    /**
     * 租户ID
     */
    private Integer tenantId;
    /**
     * 应用Key
     */
    private String clientKey;

    /**
     * 应用秘钥
     */
    private String clientSecret;

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
