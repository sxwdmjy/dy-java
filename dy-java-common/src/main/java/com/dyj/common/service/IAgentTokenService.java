package com.dyj.common.service;

import com.dyj.common.domain.TokenInfo;
import com.dyj.common.exception.AuthTokenNotFoundException;

public interface IAgentTokenService {


    TokenInfo setTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn) throws AuthTokenNotFoundException;

    TokenInfo getTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException;
}
