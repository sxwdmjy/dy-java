package com.dyj.common.service;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.exception.AgentNotFoundException;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-02 18:50
 **/
public interface IAgentConfigService {


    /**
     * 根据租户ID加载代理配置。
     *
     * @param tenantId 租户的唯一标识符，用于查找对应的代理配置。
     * @return AgentConfiguration 返回匹配的代理配置对象。
     * @throws AgentNotFoundException 如果无法根据给定的租户ID找到代理配置，抛出此异常。
     */
    List<AgentConfiguration> loadAgentByTenantId(Integer tenantId) throws AgentNotFoundException;


    /**
     * 根据租户ID和客户端密钥加载代理配置。
     *
     * @param tenantId  租户ID，用于标识不同的租户。
     * @param clientKey 客户端密钥，用于验证客户端的身份。
     * @return AgentConfiguration 返回对应租户ID和客户端密钥的代理配置对象。
     * @throws AgentNotFoundException 如果根据给定的租户ID和客户端密钥找不到对应的代理配置，抛出此异常。
     */
    AgentConfiguration loadAgentByTenantId(Integer tenantId, String clientKey) throws AgentNotFoundException;

    void setDyConfiguration(DyConfiguration dyConfiguration);
}
