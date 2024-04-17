package com.dyj.common.service;

import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.BizTokenVo;
import com.dyj.common.exception.AuthTokenNotFoundException;

public interface IAgentTokenService {


    void setUserTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn, String refreshToken, Long refreshExpiresIn, String openId) throws AuthTokenNotFoundException;

    UserTokenInfo getUserTokenInfo(Integer tenantId, String clientKey, String openId) throws AuthTokenNotFoundException;


    ClientTokenInfo setClientTokenInfo(Integer tenantId, String clientKey, String accessToken, Long expiresIn);

    ClientTokenInfo getClientTokenInfo(Integer tenantId, String clientKey) throws AuthTokenNotFoundException;

    BizTokenVo getBizToken(Integer tenantId, String clientKey, String openId);

    void setBizToken(Integer tenantId, String clientKey, String bizToken, Long bizExpiresIn, String bizRefreshToken, Long bizRefreshExpiresIn);

    //String getOpenId() throws OpenIdIsNullException;
}
