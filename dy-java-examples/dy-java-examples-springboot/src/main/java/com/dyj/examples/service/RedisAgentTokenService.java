package com.dyj.examples.service;

import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.BizTokenVo;
import com.dyj.common.exception.AuthTokenNotFoundException;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.web.DyWebClient;
import com.dyj.common.domain.vo.RefreshAccessTokenVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author danmo
 * @date 2024-04-12 10:51
 **/
public class RedisAgentTokenService implements IAgentTokenService {

    private final RedisTemplate redisTemplate;

    public RedisAgentTokenService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void setUserTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn, String openId) throws AuthTokenNotFoundException {
        UserTokenInfo userTokenInfo = new UserTokenInfo();
        userTokenInfo.setAccessToken(accessToken);
        userTokenInfo.setExpiresIn(expiresIn);
        userTokenInfo.setRefreshToken(refreshToken);
        userTokenInfo.setRefreshExpiresIn(refreshExpiresIn);
        userTokenInfo.setOpenId(openId);
        redisTemplate.opsForValue()
                .set(String.format("userToken:%s_%s_%s", tenantId, clientKey, openId), userTokenInfo, expiresIn, TimeUnit.SECONDS);
        redisTemplate.opsForValue()
                .set(String.format("userRefToken:%s_%s_%s", tenantId, clientKey, openId), userTokenInfo,refreshExpiresIn, TimeUnit.SECONDS);
    }

    @Override
    public UserTokenInfo getUserTokenInfo(Integer tenantId, String clientKey, String openId) throws AuthTokenNotFoundException {
        ValueOperations<String, UserTokenInfo> valueOperations = this.redisTemplate.opsForValue();
        UserTokenInfo userTokenInfo = valueOperations.get(String.format("userToken:%s_%s_%s", tenantId, clientKey, openId));
        if (Objects.isNull(userTokenInfo)) {
            UserTokenInfo refUserTokenInfo = valueOperations.get(String.format("userRefToken:%s_%s_%s", tenantId, clientKey, openId));
            if(Objects.nonNull(refUserTokenInfo)){
                RefreshAccessTokenVo refreshAccessTokenVo = DyWebClient.getInstance().refreshAccessToken(refUserTokenInfo.getOpenId()).getData();
                if(Objects.nonNull(refreshAccessTokenVo) && refreshAccessTokenVo.getError_code()==0){
                    setUserTokenInfo(tenantId, clientKey, refreshAccessTokenVo.getAccess_token(), refreshAccessTokenVo.getExpires_in(), refreshAccessTokenVo.getRefresh_token(), refreshAccessTokenVo.getRefresh_expires_in(), refUserTokenInfo.getOpenId());
                }
            }else {
                throw new AuthTokenNotFoundException("token not found");
            }
        }
        return userTokenInfo;
    }

    @Override
    public ClientTokenInfo setClientTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn) {
        ClientTokenInfo clientTokenInfo = new ClientTokenInfo();
        clientTokenInfo.setAccessToken(accessToken);
        clientTokenInfo.setExpiresIn(expiresIn);
        redisTemplate.opsForValue().set(String.format("clientToken:%s_%s", tenantId, clientKey), clientTokenInfo, expiresIn, TimeUnit.SECONDS);
        return clientTokenInfo;
    }

    @Override
    public ClientTokenInfo getClientTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException {
        ValueOperations<String, ClientTokenInfo> valueOperations = this.redisTemplate.opsForValue();
        return valueOperations.get(String.format("clientToken:%s_%s", tenantId, clientKey));
    }

    @Override
    public BizTokenVo getBizToken(Integer tenantId, String clientKey, String openId) {
        return null;
    }

    @Override
    public void setBizToken(Integer tenantId, String clientKey, String bizToken, Long bizExpiresIn, String bizRefreshToken, Long bizRefreshExpiresIn) {

    }
}
