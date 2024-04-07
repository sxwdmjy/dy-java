package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.UserClient;
import com.dyj.web.domain.query.CheckFansQuery;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.web.domain.query.UserRoleCheckQuery;
import com.dyj.web.domain.vo.CheckFansVo;
import com.dyj.web.domain.vo.UserInfoVo;
import com.dyj.web.domain.vo.UserRoleCheckVo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-03 13:59
 **/
public class UserHandler {

    private final UserClient userClient;

    private AgentConfiguration agentConfiguration;

    {
        userClient = SpringUtils.getBean(UserClient.class);
    }

    public UserHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    public DyResult<UserInfoVo> getUserInfo(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return userClient.getUserInfo(query);
    }

    public DyResult<CheckFansVo> checkFans(String openId, String followerOpenId) {
        CheckFansQuery query = new CheckFansQuery();
        query.setOpen_id(openId);
        query.setFollower_open_id(followerOpenId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return userClient.checkFans(query);
    }

    public DyResult<UserRoleCheckVo> userRoleCheck(String openId, String douyinShortId, List<String> roleLabels) {
        UserRoleCheckQuery query = new UserRoleCheckQuery();
        query.setOpen_id(openId);
        query.setDouyin_shortId(douyinShortId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setRole_labels(roleLabels);
        return userClient.userRoleCheck(query);
    }
}
