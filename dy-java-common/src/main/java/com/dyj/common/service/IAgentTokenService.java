package com.dyj.common.service;

import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.exception.AuthTokenNotFoundException;

public interface IAgentTokenService {


    void setTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn, String openId) throws AuthTokenNotFoundException;

    UserTokenInfo getTokenInfo(Integer tenantId, String clientKey, String openId) throws AuthTokenNotFoundException;

    ClientTokenInfo setClientTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn);

    ClientTokenInfo getClientTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException;

    //String getOpenId() throws OpenIdIsNullException;
}
