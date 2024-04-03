package com.dyj.common.config;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author danmo
 * @date 2024-04-02 13:50
 **/
public class DyConfiguration implements Serializable {

    /**
     * 抖音应用配置缓存
     */
    private final Map<Integer, List<AgentConfiguration>> AGENT_CACHE = new ConcurrentHashMap<>();


    private String beanId;

    private List<AgentConfiguration> agents;

    public DyConfiguration() {
    }

    public static DyConfiguration configuration(final String id) {
        DyConfiguration configuration = new DyConfiguration();
        configuration.setBeanId(id);
        return configuration;
    }

    public List<AgentConfiguration> getAgentByTenantId(final Integer tenantId) {
        return AGENT_CACHE.get(tenantId);
    }

    public AgentConfiguration getAgentByTenantId(final Integer tenantId, final String clientKey) {
        if(Objects.isNull(tenantId)){
           return AGENT_CACHE.values().stream().flatMap(Collection::stream).findFirst().orElse(new AgentConfiguration());
        }
        if(StringUtils.hasLength(clientKey)){
           return Optional.ofNullable(AGENT_CACHE.get(tenantId)).orElseGet(ArrayList::new).stream().findFirst().orElse(new AgentConfiguration());
        }
        return Optional.ofNullable(AGENT_CACHE.get(tenantId)).orElseGet(ArrayList::new).stream().filter(agent -> agent.getClientKey().equals(clientKey)).findFirst().orElse(new AgentConfiguration());
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
            Map<Integer, List<AgentConfiguration>> collect = agents.stream().collect(Collectors.groupingBy(AgentConfiguration::getTenantId));
            AGENT_CACHE.putAll(collect);
        }
    }
}
