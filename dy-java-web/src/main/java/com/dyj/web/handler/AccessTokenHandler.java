package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.utils.DyConfigUtils;
import com.dyj.common.domain.query.AccessTokenQuery;
import com.dyj.common.domain.query.ClientTokenQuery;
import com.dyj.common.domain.query.RefreshAccessTokenQuery;
import com.dyj.common.domain.query.RefreshTokenQuery;
import com.dyj.common.domain.vo.AccessTokenVo;
import com.dyj.common.domain.vo.ClientTokenVo;
import com.dyj.common.domain.vo.RefreshAccessTokenVo;
import com.dyj.common.domain.vo.RefreshTokenVo;

import java.util.Objects;

/**
 * @author danmo
 * @date 2024-04-03 13:59
 **/
public class AccessTokenHandler extends AbstractWebHandler {

    public AccessTokenHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    public DyResult<AccessTokenVo> getAccessToken(String code) {
        AccessTokenQuery query = new AccessTokenQuery();
        query.setCode(code);
        query.setClient_key(agentConfiguration.getClientKey());
        query.setClient_secret(agentConfiguration.getClientSecret());
        DyResult<AccessTokenVo> dyResult = getAuthClient().getAccessToken(query);
        if (Objects.nonNull(dyResult) && dyResult.getData().getError_code() == 0) {
            DyConfigUtils.getAgentTokenService().setUserTokenInfo(agentConfiguration.getTenantId(), agentConfiguration.getClientKey(), dyResult.getData().getAccess_token(), dyResult.getData().getExpires_in(), dyResult.getData().getRefresh_token(), dyResult.getData().getRefresh_expires_in(), dyResult.getData().getOpen_id());
        }
        return dyResult;
    }

    public DyResult<RefreshTokenVo> refreshToken(String refreshToken) {
        RefreshTokenQuery query = new RefreshTokenQuery();
        query.setClient_key(agentConfiguration.getClientKey());
        query.setRefresh_token(refreshToken);
        return getAuthClient().refreshToken(query);
    }

    public DyResult<ClientTokenVo> getClientToken() {
        ClientTokenQuery query = new ClientTokenQuery();
        query.setClient_key(agentConfiguration.getClientKey());
        query.setClient_secret(agentConfiguration.getClientSecret());
        return getAuthClient().getClientToken(query);
    }

    public DyResult<RefreshAccessTokenVo> refreshAccessToken(String refreshToken) {
        RefreshAccessTokenQuery query = new RefreshAccessTokenQuery();
        query.setRefresh_token(refreshToken);
        query.setClient_key(agentConfiguration.getClientKey());
        return getAuthClient().refreshAccessToken(query);
    }


}
