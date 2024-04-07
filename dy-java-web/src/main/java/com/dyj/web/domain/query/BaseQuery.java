package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-07 15:09
 **/
public class BaseQuery {


    /**
     * 租户ID
     */
    protected Integer tenantId;
    /**
     * 应用Key
     */
    protected String clientKey;

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
}
