package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.interceptor.BodyTokenInterceptor;
import com.dyj.web.domain.query.CheckFansQuery;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.web.domain.query.UserRoleCheckQuery;
import com.dyj.web.domain.vo.CheckFansVo;
import com.dyj.web.domain.vo.UserInfoVo;
import com.dyj.web.domain.vo.UserRoleCheckVo;
import com.dyj.common.interceptor.TokenHeaderInterceptor;

/**
 * @author danmo
 * @date 2024-04-07 14:49
 **/
@BaseRequest(baseURL = "${domain}")
public interface UserClient {

    @Post(url = "${userInfo}", contentType = ContentType.APPLICATION_X_WWW_FORM_URLENCODED, interceptor = BodyTokenInterceptor.class)
    DyResult<UserInfoVo> getUserInfo(@Body UserInfoQuery query);

    @Get(url = "${checkFans}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<CheckFansVo> checkFans(@JSONBody CheckFansQuery query);

    @Post(url = "${userRoleCheck}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<UserRoleCheckVo> userRoleCheck(@JSONBody UserRoleCheckQuery query);
}
