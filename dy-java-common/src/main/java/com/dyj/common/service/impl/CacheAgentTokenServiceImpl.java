package com.dyj.common.service.impl;

import com.dyj.common.domain.TokenInfo;
import com.dyj.common.exception.AuthTokenNotFoundException;
import com.dyj.common.service.IAgentTokenService;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author danmo
 * @date 2024-04-07 13:49
 **/
public class CacheAgentTokenServiceImpl implements IAgentTokenService {

    Map<String, TokenInfo> tokenInfoMap = new ConcurrentHashMap<>();

    @Override
    public TokenInfo setTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn) throws AuthTokenNotFoundException {
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setAccessToken(accessToken);
        tokenInfo.setExpiresIn(expiresIn);
        tokenInfo.setRefreshToken(refreshToken);
        tokenInfo.setRefreshExpiresIn(refreshExpiresIn);
        tokenInfoMap.put(String.format("%s_%s", tenantId, clientKey), tokenInfo);
        return tokenInfo;
    }

    @Override
    public TokenInfo getTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException {
        TokenInfo tokenInfo = tokenInfoMap.get(String.format("%s_%s", tenantId, clientKey));
        if (Objects.isNull(tokenInfo)) {
            throw new AuthTokenNotFoundException("token not found");
        }
        return tokenInfo;
    }


}
