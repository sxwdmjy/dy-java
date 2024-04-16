package com.dyj.common.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.AccessTokenQuery;
import com.dyj.common.domain.query.ClientTokenQuery;
import com.dyj.common.domain.query.RefreshAccessTokenQuery;
import com.dyj.common.domain.query.RefreshTokenQuery;
import com.dyj.common.domain.vo.AccessTokenVo;
import com.dyj.common.domain.vo.ClientTokenVo;
import com.dyj.common.domain.vo.RefreshAccessTokenVo;
import com.dyj.common.domain.vo.RefreshTokenVo;
import com.dyj.common.interceptor.NoTokenInterceptor;

/**
 * @author danmo
 * @date 2024-04-03 11:03
 **/

@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface AuthClient {


    /** 获取accessToken */
    @Post(value = "${oauthAccessToken}",interceptor = NoTokenInterceptor.class)
    DyResult<AccessTokenVo> getAccessToken(@Body AccessTokenQuery query);

    /** 刷新 refresh_token */
    @Post(value = "${oauthRefreshToken}",interceptor = NoTokenInterceptor.class)
    DyResult<RefreshTokenVo> refreshToken(@Body RefreshTokenQuery query);

    /** 获取client_token */
    @Post(value = "${oauthClientToken}",interceptor = NoTokenInterceptor.class)
    DyResult<ClientTokenVo> getClientToken(@Body ClientTokenQuery query);

    /** 刷新 access_token */
    @Post(value = "${accessTokenRefresh}",interceptor = NoTokenInterceptor.class)
    DyResult<RefreshAccessTokenVo> refreshAccessToken(@Body RefreshAccessTokenQuery query);
}
