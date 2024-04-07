package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dyj.common.client.BaseClient;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.AccessTokenQuery;
import com.dyj.web.domain.query.ClientTokenQuery;
import com.dyj.web.domain.query.RefreshTokenQuery;
import com.dyj.web.domain.query.RefreshAccessTokenQuery;
import com.dyj.web.domain.vo.AccessTokenVo;
import com.dyj.web.domain.vo.ClientTokenVo;
import com.dyj.web.domain.vo.RefreshAccessTokenVo;
import com.dyj.web.domain.vo.RefreshTokenVo;
import com.dyj.web.interceptor.NoTokenInterceptor;

/**
 * @author danmo
 * @date 2024-04-03 11:03
 **/

@BaseRequest(baseURL = "${domain}", contentType = "application/json")
public interface AuthClient extends BaseClient {


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
