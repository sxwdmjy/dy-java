package com.dyj.applet.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.applet.interceptor.BizTokenHeaderInterceptor;
import com.dyj.common.domain.DyAppletResult;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-17 10:12
 **/
@BaseRequest(baseURL = "${domain}")
public interface BsClient {

    /**
     * 经营能力当前状态查询
     */
    @Post(value = "${businessScopes}", contentType = ContentType.APPLICATION_JSON ,interceptor = BizTokenHeaderInterceptor.class)
    DyAppletResult<List<String>> getBusinessScopes();
}
