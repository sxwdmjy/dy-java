package com.dyj.common.utils;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.handler.RequestHandler;
import com.dyj.common.service.IAgentConfigService;
import com.dyj.common.service.IAgentTokenService;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-10 10:21
 **/
public class DyConfigUtils {

    public static DyConfiguration getDyConfig() {
        return RequestHandler.getInstance().getDyConfiguration();
    }

    public static IAgentConfigService getAgentConfigService() {
        return RequestHandler.getInstance().getDyConfiguration().getAgentConfigService();
    }

    public static IAgentTokenService getAgentTokenService() {
        return RequestHandler.getInstance().getDyConfiguration().getAgentTokenService();
    }

    public static List<AgentConfiguration> getAgents() {
        return RequestHandler.getInstance().getDyConfiguration().getAgents();
    }

    public static List<AgentConfiguration> getAgents(Integer tenantId) {
        return RequestHandler.getInstance().getDyConfiguration().getAgentByTenantId(tenantId);
    }

    public static AgentConfiguration getAgent(Integer tenantId, String clientKey) {
        return RequestHandler.getInstance().getDyConfiguration().getAgentByTenantId(tenantId,clientKey);
    }

    public static Integer getDefaultTenantId() {
        return RequestHandler.getInstance().getDyConfiguration().getDefaultId();
    }

}
