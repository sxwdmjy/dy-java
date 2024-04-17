package com.dyj.applet.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.*;
import com.dyj.common.domain.vo.*;
import com.dyj.common.utils.DyConfigUtils;

import java.util.Objects;

/**
 * @author danmo
 * @date 2024-04-03 13:59
 **/
public class AppletTokenHandler extends AbstractAppletHandler {

    public AppletTokenHandler(AgentConfiguration agentConfiguration) {
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

    /**
     * BusinessToken 生成
     * @param openId 用户ID
     * @param scope 用于指定Token所对应的能力，逗号分割
     * @return  DyAppletResult<BizTokenVo>
     */
    public DyAppletResult<BizTokenVo> getBizToken(String openId, String scope) {
       return getAuthClient().getBizToken(BizTokenQuery.builder().clientKey(agentConfiguration.getClientKey()).clientSecret(agentConfiguration.getClientSecret()).openId(openId).scope(scope).build());
    }

    /**
     * BusinessToken 生成刷新
     * @param refreshToken 刷新token
     * @return DyAppletResult<BizTokenVo>
     */
    public DyAppletResult<BizTokenVo> refreshBizToken(String refreshToken) {
        return getAuthClient().refreshBizToken(BizRefreshTokenQuery.builder()
                .clientKey(agentConfiguration.getClientKey())
                .clientSecret(agentConfiguration.getClientSecret())
                .refreshToken(refreshToken)
                .build());
    }

    /**
     * 小程序 getAccessToken
     */
    public DyAppletResult<AppsV2TokenVo> appsV2Token() {
        return getAuthClient().appsV2Token(AppsV2TokenQuery.builder()
                .appid(agentConfiguration.getClientKey())
                .secret(agentConfiguration.getClientSecret())
                .build());
    }

}
