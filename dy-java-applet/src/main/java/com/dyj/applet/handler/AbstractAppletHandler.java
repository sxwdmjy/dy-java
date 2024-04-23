package com.dyj.applet.handler;

import com.dyj.applet.client.*;
import com.dyj.common.client.AuthClient;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.spring.utils.SpringUtils;

import java.util.Objects;

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

    protected AptLoginClient getLoginClient() {
        return SpringUtils.getBean(AptLoginClient.class);
    }

    protected AptSchemaClient getSchemaClient() {
        return SpringUtils.getBean(AptSchemaClient.class);
    }

    protected AptChatMsgClient getChatMsgClient() {
        return SpringUtils.getBean(AptChatMsgClient.class);
    }

    protected AptClueClient getClueClient() {
        return SpringUtils.getBean(AptClueClient.class);
    }


    protected AptVideoClient getVideoClient() {
        return SpringUtils.getBean(AptVideoClient.class);
    }

    protected SearchSubServiceClient getSearchSubServiceClient() {
        return SpringUtils.getBean(SearchSubServiceClient.class);
    }

    protected AptTaskClient getTaskClient() {
        return SpringUtils.getBean(AptTaskClient.class);
    }

    protected BaseQuery baseQuery(){
        return baseQuery(null);
    }

    protected BaseQuery baseQuery(BaseQuery query){
        if(Objects.isNull(query)){
            query = new BaseQuery();
        }
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return query;
    }

    protected UserInfoQuery userInfoQuery(){
        return userInfoQuery(new UserInfoQuery());
    }

    protected UserInfoQuery userInfoQuery(String openId){
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        return userInfoQuery(query);
    }

    protected UserInfoQuery userInfoQuery(UserInfoQuery query){
        if(Objects.isNull(query)){
            query = new UserInfoQuery();
        }
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return query;
    }
}
