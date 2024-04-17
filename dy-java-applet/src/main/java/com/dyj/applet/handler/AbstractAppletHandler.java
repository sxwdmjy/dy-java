package com.dyj.applet.handler;

import com.dyj.common.client.AuthClient;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.spring.utils.SpringUtils;

/**
 * @author danmo
 * @date 2024-04-10 15:18
 **/
public abstract class AbstractAppletHandler {

    protected final AgentConfiguration agentConfiguration;

    public AbstractAppletHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    protected AuthClient getAuthClient() {
        return SpringUtils.getBean(AuthClient.class);
    }
}
