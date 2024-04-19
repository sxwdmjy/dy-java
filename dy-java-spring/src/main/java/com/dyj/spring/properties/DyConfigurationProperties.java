package com.dyj.spring.properties;

import com.dyj.common.config.AgentConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-02 13:38
 **/
@Component
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
@ConfigurationProperties(prefix = "dy-java", ignoreUnknownFields = true)
public class DyConfigurationProperties {


    /**
     * bean实例ID
     */
    private String beanId;

    /**
     * 默认租户ID
     */
    private Integer defaultId;

    /**
     * 域名
     */
    private String domain;

    /**
     * 域名
     */
    private String ttDomain;

    /**
     * 应用配置
     */
    private List<AgentConfiguration> agents;

    /**
     * forest参数配置
     */
    private DyForestConfigurationProperties forest;

    /**
     * 应用配置类
     */
    private String agentSourceClass = "com.dyj.common.service.impl.PropertiesAgentConfigServiceImpl";

    /**
     * token配置类
     */
    private String tokenSourceClass = "com.dyj.common.service.impl.CacheAgentTokenServiceImpl";

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTtDomain() {
        return ttDomain;
    }

    public void setTtDomain(String ttDomain) {
        this.ttDomain = ttDomain;
    }

    public List<AgentConfiguration> getAgents() {
        return agents;
    }

    public void setAgents(List<AgentConfiguration> agents) {
        this.agents = agents;
    }

    public DyForestConfigurationProperties getForest() {
        return forest;
    }

    public void setForest(DyForestConfigurationProperties forest) {
        this.forest = forest;
    }

    public Integer getDefaultId() {
        return this.defaultId;
    }

    public void setDefaultId(Integer defaultId) {
        this.defaultId = defaultId;
    }

    public String getAgentSourceClass() {
        return agentSourceClass;
    }

    public void setAgentSourceClass(String agentSourceClass) {
        this.agentSourceClass = agentSourceClass;
    }

    public String getTokenSourceClass() {
        return tokenSourceClass;
    }

    public void setTokenSourceClass(String tokenSourceClass) {
        this.tokenSourceClass = tokenSourceClass;
    }
}
