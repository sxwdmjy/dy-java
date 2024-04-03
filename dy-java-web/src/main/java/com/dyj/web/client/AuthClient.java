package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dyj.common.client.BaseClient;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.DyAccessTokenQuery;
import com.dyj.web.domain.vo.DyAccessTokenVo;
import com.dyj.web.interceptor.AuthInterceptor;

/**
 * @author danmo
 * @date 2024-04-03 11:03
 **/

@BaseRequest(baseURL = "${domain}", interceptor = AuthInterceptor.class, contentType = "application/json")
public interface AuthClient extends BaseClient {


    @Post("${oauthAccessToken}")
    DyResult<DyAccessTokenVo> getAccessToken(@Body DyAccessTokenQuery query);
}
