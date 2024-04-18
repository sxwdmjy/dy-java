package com.dyj.common.service.impl;

import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.BizTokenVo;
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

    private final Map<String, UserTokenInfo> userTokenMap = new ConcurrentHashMap<>();
    private final Map<String, ClientTokenInfo> clientTokenMap = new ConcurrentHashMap<>();

    @Override
    public void setUserTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn, String openId) throws AuthTokenNotFoundException {
        UserTokenInfo userTokenInfo = new UserTokenInfo();
        userTokenInfo.setAccessToken(accessToken);
        userTokenInfo.setExpiresIn(expiresIn);
        userTokenInfo.setRefreshToken(refreshToken);
        userTokenInfo.setRefreshExpiresIn(refreshExpiresIn);
        userTokenInfo.setOpenId(openId);
        userTokenMap.put(String.format("%s_%s_%s", tenantId, clientKey, openId), userTokenInfo);
    }

    @Override
    public UserTokenInfo getUserTokenInfo(Integer tenantId, String clientKey, String openId) throws AuthTokenNotFoundException {
        UserTokenInfo userTokenInfo = userTokenMap.get(String.format("%s_%s_%s", tenantId, clientKey, openId));
        if (Objects.isNull(userTokenInfo)) {
            throw new AuthTokenNotFoundException("token not found");
        }
        return userTokenInfo;
    }

    @Override
    public ClientTokenInfo setClientTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn){
        ClientTokenInfo clientTokenInfo = new ClientTokenInfo();
        clientTokenInfo.setAccessToken(accessToken);
        clientTokenInfo.setExpiresIn(expiresIn);
        clientTokenMap.put(String.format("%s_%s", tenantId, clientKey), clientTokenInfo);
        return clientTokenInfo;
    }

    @Override
    public ClientTokenInfo getClientTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException {
        return clientTokenMap.get(String.format("%s_%s", tenantId, clientKey));
    }

    @Override
    public BizTokenVo getBizToken(Integer tenantId, String clientKey, String openId) {
        return null;
    }

    @Override
    public void setBizToken(Integer tenantId, String clientKey, String bizToken, Long bizExpiresIn, String bizRefreshToken, Long bizRefreshExpiresIn, String openId) {

    }
}
