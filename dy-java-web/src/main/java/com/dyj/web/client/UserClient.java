package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.web.domain.vo.UserInfoVo;
import com.dyj.web.interceptor.AccessTokenInterceptor;

/**
 * @author danmo
 * @date 2024-04-07 14:49
 **/
@BaseRequest(baseURL = "${domain}")
public interface UserClient {

    @Post(url = "${userInfo}",contentType = "application/x-www-form-urlencoded",interceptor = AccessTokenInterceptor.class)
    DyResult<UserInfoVo> getUserInfo(@Body UserInfoQuery query);
}
