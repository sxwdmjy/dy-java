package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.AuthorizeUserListQuery;
import com.dyj.web.domain.query.RevokeMsgQuery;
import com.dyj.web.domain.query.SendMsgQuery;
import com.dyj.web.domain.vo.AuthorizeUserListVo;
import com.dyj.web.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-08 18:22
 **/
public class ChatMsgHandler extends AbstractWebHandler {

    public ChatMsgHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    public DyResult<BaseVo> sendMessage(SendMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getChatMsgClient().sendMessage(query);
    }

    public DyResult<AuthorizeUserListVo> queryAuthorizeUserList(AuthorizeUserListQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getChatMsgClient().queryAuthorizeUserList(query);
    }

    public DyResult<BaseVo> revokeMessage(RevokeMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getChatMsgClient().revokeMessage(query);
    }
}
