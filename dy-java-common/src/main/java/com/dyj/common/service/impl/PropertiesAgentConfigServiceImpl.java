package com.dyj.common.service.impl;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.exception.AgentNotFoundException;
import com.dyj.common.service.IAgentConfigService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * 从配置文件获取agent配置
 *
 * @author danmo
 * @date 2024-04-02 18:55
 **/
public class PropertiesAgentConfigServiceImpl implements IAgentConfigService {

    private DyConfiguration dyConfiguration;


    @Override
    public List<AgentConfiguration> loadAgentByTenantId(Integer tenantId) throws AgentNotFoundException {
        List<AgentConfiguration> agentConfiguration = dyConfiguration.getAgentByTenantId(tenantId);
        if (!CollectionUtils.isEmpty(agentConfiguration)) {
            throw new AgentNotFoundException("租户未配置应用信息");
        }
        return agentConfiguration;
    }

    @Override
    public AgentConfiguration loadAgentByTenantId(Integer tenantId, String clientKey) throws AgentNotFoundException {
        AgentConfiguration agentConfiguration = dyConfiguration.getAgentByTenantId(tenantId, clientKey);
        if (Objects.isNull(agentConfiguration)) {
            throw new AgentNotFoundException("租户未配置应用信息");
        }
        return agentConfiguration;
    }

    @Override
    public void setDyConfiguration(DyConfiguration dyConfiguration) {
        this.dyConfiguration = dyConfiguration;
    }


}
