package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.*;

/**
 * @author danmo
 * @date 2024-04-10 15:18
 **/
public abstract class AbstractWebHandler {

    protected final AgentConfiguration agentConfiguration;

    public AbstractWebHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    protected AuthClient getAuthClient() {
        return SpringUtils.getBean(AuthClient.class);
    }

    protected UserClient getUserClient() {
        return SpringUtils.getBean(UserClient.class);
    }

    protected VideoClient getVideoClient() {
        return SpringUtils.getBean(VideoClient.class);
    }

    protected BusinessClient getBusinessClient() {
        return SpringUtils.getBean(BusinessClient.class);
    }

    protected ChatMsgClient getChatMsgClient() {
        return SpringUtils.getBean(ChatMsgClient.class);
    }

    protected GroupClient getGroupClient() {
        return SpringUtils.getBean(GroupClient.class);
    }

    protected IntentionClient getIntentionClient() {
        return SpringUtils.getBean(IntentionClient.class);
    }
}
