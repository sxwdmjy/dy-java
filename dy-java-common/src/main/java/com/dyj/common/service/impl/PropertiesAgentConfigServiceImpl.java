package com.dyj.common.service.impl;

import com.dyj.common.config.DyConfiguration;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.exception.AgentNotFoundException;
import com.dyj.common.service.IAgentConfigService;
import org.springframework.stereotype.Component;

/**
 * 从配置文件获取agent配置
 * @author danmo
 * @date 2024-04-02 18:55
 **/
@Component
public class PropertiesAgentConfigServiceImpl implements IAgentConfigService {

    private final DyConfiguration dyConfiguration;

    public PropertiesAgentConfigServiceImpl(DyConfiguration dyConfiguration) {
        this.dyConfiguration = dyConfiguration;
    }

    @Override
    public AgentConfiguration loadAgentByTenantId(Integer tenantId) throws AgentNotFoundException {
        return dyConfiguration.getAgentByTenantId(tenantId);
    }
}
