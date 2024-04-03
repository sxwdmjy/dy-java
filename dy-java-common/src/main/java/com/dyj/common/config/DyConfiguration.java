package com.dyj.common.config;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author danmo
 * @date 2024-04-02 13:50
 **/
public class DyConfiguration implements Serializable {

    /**
     * 抖音应用配置缓存
     */
    private final Map<Integer, AgentConfiguration> AGENT_CACHE = new ConcurrentHashMap<>();


    private String beanId;

    private List<AgentConfiguration> agents;

    public DyConfiguration() {
    }

    public static DyConfiguration configuration(final String id) {
        DyConfiguration configuration = new DyConfiguration();
        configuration.setBeanId(id);
        return configuration;
    }

    public AgentConfiguration getAgentByTenantId(final Integer tenantId) {
        return AGENT_CACHE.get(tenantId);
    }


    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public List<AgentConfiguration> getAgents() {
        return agents;
    }

    public void setAgents(List<AgentConfiguration> agents) {
        this.agents = agents;
        if (!CollectionUtils.isEmpty(agents)) {
            AGENT_CACHE.putAll(agents.stream().collect(Collectors.toConcurrentMap(AgentConfiguration::getTenantId, Function.identity(), (t1, t2) -> t1)));
        }
    }
}
