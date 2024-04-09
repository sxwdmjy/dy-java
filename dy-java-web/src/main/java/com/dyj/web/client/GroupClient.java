package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.CreateFansGroupQuery;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface GroupClient {

    @Post(value = "${createFansGroup}?open_id=${query.openId}", interceptor = TokenHeaderInterceptor.class)
    DyResult<Object> createFansGroup(@Body CreateFansGroupQuery query);

}
