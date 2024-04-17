package com.dyj.common.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.*;
import com.dyj.common.domain.vo.*;
import com.dyj.common.interceptor.NoTokenInterceptor;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-03 11:03
 **/

@BaseRequest(baseURL = "${domain}",interceptor = NoTokenInterceptor.class)
public interface AuthClient {


    /** 获取accessToken */
    @Post(value = "${oauthAccessToken}")
    DyResult<AccessTokenVo> getAccessToken(@JSONBody AccessTokenQuery query);

    /** 刷新 refresh_token */
    @Post(value = "${oauthRefreshToken}")
    DyResult<RefreshTokenVo> refreshToken(@JSONBody RefreshTokenQuery query);

    /** 获取client_token */
    @Post(value = "${oauthClientToken}")
    DyResult<ClientTokenVo> getClientToken(@JSONBody ClientTokenQuery query);

    /** 刷新 access_token */
    @Post(value = "${accessTokenRefresh}")
    DyResult<RefreshAccessTokenVo> refreshAccessToken(@JSONBody RefreshAccessTokenQuery query);

    /** BusinessToken 生成 */
    @Post(value = "${bizAccessToken}")
    DyAppletResult<BizTokenVo> getBizToken(@JSONBody BizTokenQuery query);

    /**
     * BusinessToken 生成刷新
     */
    @Post(value = "${bizTokenRefresh}")
    DyAppletResult<BizTokenVo> refreshBizToken(@JSONBody BizRefreshTokenQuery query);

    /**
     * 小程序 getAccessToken
     */
    @Post(value = "${appsV2Token}")
    DyAppletResult<AppsV2TokenVo> appsV2Token(@JSONBody AppsV2TokenQuery query);
}
