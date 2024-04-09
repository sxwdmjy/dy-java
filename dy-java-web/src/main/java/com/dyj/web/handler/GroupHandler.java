package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.GroupClient;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;

/**
 * @author danmo
 * @date 2024-04-09 11:40
 **/
public class GroupHandler {

    private GroupClient groupClient;

    private final AgentConfiguration agentConfiguration;

    {
        groupClient = SpringUtils.getBean(GroupClient.class);
    }

    public GroupHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    public CreateFansGroupVo createFansGroup(CreateFansGroupQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.createFansGroup(query);
    }

    public SetFansGroupEnterStatusVo setFansGroupEnterStatus(SetFansGroupEnterStatusQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.setFansGroupEnterStatus(query);
    }

    public FansGroupVo queryFansGroup(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.queryFansGroup(query);
    }

    public FansGroupSettingVo queryFansGroupSetting(FansGroupSettingQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.queryFansGroupSetting(query);
    }

    public FansGroupSettingVo cancelFansGroupSetting(FansGroupSettingQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.cancelFansGroupSetting(query);
    }

    public FansGroupCountVo queryFansGroupCount(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.queryFansGroupCount(query);
    }

    public FansGroupEnterStatusVo queryFansGroupEnterStatus(String openId, Integer count, Integer cursor) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.queryFansGroupEnterStatus(query, count, cursor);
    }

    public ChatMsgResponseVo sendGroupMessage(SendGroupMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.sendGroupMessage(query);
    }

    public DySimpleResult revokeGroupMessage(RevokeGroupMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return groupClient.revokeGroupMessage(query);
    }

}
