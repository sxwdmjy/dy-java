package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.AuthClient;
import com.dyj.web.domain.query.AccessTokenQuery;
import com.dyj.web.domain.query.ClientTokenQuery;
import com.dyj.web.domain.query.RefreshAccessTokenQuery;
import com.dyj.web.domain.query.RefreshTokenQuery;
import com.dyj.web.domain.vo.AccessTokenVo;
import com.dyj.web.domain.vo.ClientTokenVo;
import com.dyj.web.domain.vo.RefreshAccessTokenVo;
import com.dyj.web.domain.vo.RefreshTokenVo;

/**
 * @author danmo
 * @date 2024-04-03 13:59
 **/
public class AccessTokenHandler {

    private final AuthClient authClient;

    {
        authClient = SpringUtils.getBean(AuthClient.class);
    }

    private final AgentConfiguration agentConfiguration;

    public AccessTokenHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    public DyResult<AccessTokenVo> getAccessToken(String code) {
        AccessTokenQuery query = new AccessTokenQuery();
        query.setCode(code);
        query.setClient_key(agentConfiguration.getClientKey());
        query.setClient_secret(agentConfiguration.getClientSecret());
        return authClient.getAccessToken(query);
    }

    public DyResult<RefreshTokenVo> refreshToken(String refreshToken) {
        RefreshTokenQuery query = new RefreshTokenQuery();
        query.setClient_key(agentConfiguration.getClientKey());
        query.setRefresh_token(refreshToken);
        return authClient.refreshToken(query);
    }

    public DyResult<ClientTokenVo> getClientToken() {
        ClientTokenQuery query = new ClientTokenQuery();
        query.setClient_key(agentConfiguration.getClientKey());
        query.setClient_secret(agentConfiguration.getClientSecret());
        return authClient.getClientToken(query);
    }

    public DyResult<RefreshAccessTokenVo> refreshAccessToken(String refreshToken) {
        RefreshAccessTokenQuery query = new RefreshAccessTokenQuery();
        query.setRefresh_token(refreshToken);
        query.setClient_key(agentConfiguration.getClientKey());
        return authClient.refreshAccessToken(query);
    }


}
