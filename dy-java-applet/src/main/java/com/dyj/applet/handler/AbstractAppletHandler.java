package com.dyj.applet.handler;

import com.dyj.applet.client.ChatMsgClient;
import com.dyj.applet.client.LoginClient;
import com.dyj.applet.client.SchemaClient;
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

    protected LoginClient getLoginClient() {
        return SpringUtils.getBean(LoginClient.class);
    }

    protected SchemaClient getSchemaClient() {
        return SpringUtils.getBean(SchemaClient.class);
    }

    protected ChatMsgClient getChatMsgClient() {
        return SpringUtils.getBean(ChatMsgClient.class);
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
