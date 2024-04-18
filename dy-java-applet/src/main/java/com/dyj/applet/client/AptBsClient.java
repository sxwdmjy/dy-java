package com.dyj.applet.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Header;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyAppletResult;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-17 10:12
 **/
@BaseRequest(baseURL = "${domain}")
public interface AptBsClient {

    /**
     * 经营能力当前状态查询
     */
    @Post(value = "${businessScopes}", contentType = ContentType.APPLICATION_JSON)
    DyAppletResult<List<String>> getBusinessScopes(@Header("access-token") String accessToken);
}
