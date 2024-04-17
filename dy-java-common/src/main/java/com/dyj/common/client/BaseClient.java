package com.dyj.common.client;

import com.dyj.common.config.DyConfiguration;
import com.dyj.common.utils.DyConfigUtils;

public class BaseClient {

    public Integer tenantId;

    public String clientKey;

    public DyConfiguration configuration() {
        return DyConfigUtils.getDyConfig();
    }
}
