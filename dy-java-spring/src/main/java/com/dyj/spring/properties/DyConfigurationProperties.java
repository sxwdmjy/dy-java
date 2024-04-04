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
     * 应用配置
     */
    private List<AgentConfiguration> agents;

    /**
     * forest参数配置
     */
    private DyForestConfigurationProperties forest;



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
}
