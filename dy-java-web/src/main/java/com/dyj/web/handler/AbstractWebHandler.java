package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.*;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.query.UserInfoQuery;

import java.util.Objects;

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

    protected CommentClient getCommentClient() {
        return SpringUtils.getBean(CommentClient.class);
    }
    protected SchemaClient getSchemaClient() {
        return SpringUtils.getBean(SchemaClient.class);
    }

    protected PostingTaskClient getPostingTaskClient() {
        return SpringUtils.getBean(PostingTaskClient.class);
    }

    protected MediaClient getMediaClient() {
        return SpringUtils.getBean(MediaClient.class);
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
