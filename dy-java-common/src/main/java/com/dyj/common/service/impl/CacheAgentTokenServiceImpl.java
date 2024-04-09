package com.dyj.common.service.impl;

import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.UserTokenInfo;
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

    private final Map<String, UserTokenInfo> tokenInfoMap = new ConcurrentHashMap<>();
    private final Map<String, ClientTokenInfo> clientTokenInfoMap = new ConcurrentHashMap<>();

    @Override
    public void setTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn, String openId) throws AuthTokenNotFoundException {
        UserTokenInfo userTokenInfo = new UserTokenInfo();
        userTokenInfo.setAccessToken(accessToken);
        userTokenInfo.setExpiresIn(expiresIn);
        userTokenInfo.setRefreshToken(refreshToken);
        userTokenInfo.setRefreshExpiresIn(refreshExpiresIn);
        userTokenInfo.setOpenId(openId);
        tokenInfoMap.put(String.format("%s_%s_%s", tenantId, clientKey, openId), userTokenInfo);
    }

    @Override
    public UserTokenInfo getTokenInfo(Integer tenantId, String clientKey, String openId) throws AuthTokenNotFoundException {
        UserTokenInfo userTokenInfo = tokenInfoMap.get(String.format("%s_%s_%s", tenantId, clientKey,openId));
        if (Objects.isNull(userTokenInfo)) {
            throw new AuthTokenNotFoundException("token not found");
        }
        return userTokenInfo;
    }

    @Override
    public void setClientTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn) throws AuthTokenNotFoundException {
        ClientTokenInfo clientTokenInfo = new ClientTokenInfo();
        clientTokenInfo.setAccessToken(accessToken);
        clientTokenInfo.setExpiresIn(expiresIn);
        clientTokenInfoMap.put(String.format("%s_%s", tenantId, clientKey), clientTokenInfo);
    }

    @Override
    public ClientTokenInfo getClientTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException {
        return clientTokenInfoMap.get(String.format("%s_%s", tenantId, clientKey));
    }


}
