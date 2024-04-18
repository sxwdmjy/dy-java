package com.dyj.common.service;

import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.AppsV2TokenVo;
import com.dyj.common.domain.vo.BizTokenVo;
import com.dyj.common.exception.AuthTokenNotFoundException;

public interface IAgentTokenService {


    void setUserTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn, String openId) throws AuthTokenNotFoundException;

    UserTokenInfo getUserTokenInfo(Integer tenantId, String clientKey, String openId) throws AuthTokenNotFoundException;


    ClientTokenInfo setClientTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn);

    ClientTokenInfo getClientTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException;

    BizTokenVo getBizToken(Integer tenantId, String clientKey, String openId);

    void setBizToken(Integer tenantId, String clientKey, String bizToken, Long bizExpiresIn, String bizRefreshToken, Long bizRefreshExpiresIn, String openId);

    void setAppsV2Token(Integer tenantId, String clientKey, String accessToken, Long expiresIn);

    AppsV2TokenVo getAppsV2Token(Integer tenantId, String clientKey);
    //String getOpenId() throws OpenIdIsNullException;
}
