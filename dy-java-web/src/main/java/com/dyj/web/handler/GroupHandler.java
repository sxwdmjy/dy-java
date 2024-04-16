package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;

/**
 * @author danmo
 * @date 2024-04-09 11:40
 **/
public class GroupHandler extends AbstractWebHandler{


    public GroupHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    public CreateFansGroupVo createFansGroup(CreateFansGroupQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().createFansGroup(query);
    }

    public SetFansGroupEnterStatusVo setFansGroupEnterStatus(SetFansGroupEnterStatusQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().setFansGroupEnterStatus(query);
    }

    public FansGroupVo queryFansGroup(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().queryFansGroup(query);
    }

    public FansGroupSettingVo queryFansGroupSetting(FansGroupSettingQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().queryFansGroupSetting(query);
    }

    public FansGroupSettingVo cancelFansGroupSetting(FansGroupSettingQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().cancelFansGroupSetting(query);
    }

    public FansGroupCountVo queryFansGroupCount(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().queryFansGroupCount(query);
    }

    public FansGroupEnterStatusVo queryFansGroupEnterStatus(String openId, Integer count, Integer cursor) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().queryFansGroupEnterStatus(query, count, cursor);
    }

    public ChatMsgResponseVo sendGroupMessage(SendGroupMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().sendGroupMessage(query);
    }

    public DySimpleResult<BaseVo> revokeGroupMessage(RevokeGroupMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getGroupClient().revokeGroupMessage(query);
    }

}
