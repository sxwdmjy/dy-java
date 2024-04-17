package com.dyj.applet.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.interceptor.BizTokenHeaderInterceptor;

/**
 * 私信管理
 *
 * @author danmo
 * @date 2024-04-08 09:36
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON, interceptor = BizTokenHeaderInterceptor.class)
public interface ChatMsgClient {


}
