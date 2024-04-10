package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.IntentionLogQuery;
import com.dyj.web.domain.vo.IntentionLogVo;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

/**
 * @author danmo
 * @date 2024-04-10 13:33
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface IntentionClient {

    /**
     * 互动用户记录查询
     * @param query
     * @return
     */
    @Get(value = "${intentionLog}", interceptor = TokenHeaderInterceptor.class)
    DyResult<IntentionLogVo> intentionLog(@Query IntentionLogQuery query);
}
