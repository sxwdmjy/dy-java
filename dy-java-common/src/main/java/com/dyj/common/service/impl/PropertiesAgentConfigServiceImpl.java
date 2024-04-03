package com.dyj.common.service.impl;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.exception.AgentNotFoundException;
import com.dyj.common.service.IAgentConfigService;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 从配置文件获取agent配置
 *
 * @author danmo
 * @date 2024-04-02 18:55
 **/
public class PropertiesAgentConfigServiceImpl implements IAgentConfigService {

    private final DyConfiguration dyConfiguration;

    public PropertiesAgentConfigServiceImpl(DyConfiguration dyConfiguration) {
        this.dyConfiguration = dyConfiguration;
    }

    @Override
    public List<AgentConfiguration> loadAgentByTenantId(Integer tenantId) throws AgentNotFoundException {
        List<AgentConfiguration> agentConfiguration = dyConfiguration.getAgentByTenantId(tenantId);
        if (!CollectionUtils.isEmpty(agentConfiguration)) {
            throw new AgentNotFoundException("租户未配置应用信息");
        }
        return agentConfiguration;
    }
}
