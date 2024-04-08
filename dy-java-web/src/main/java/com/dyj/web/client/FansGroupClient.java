package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.backend.ContentType;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
public interface FansGroupClient {


}
