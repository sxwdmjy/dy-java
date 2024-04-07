package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.CreateImageTextQuery;
import com.dyj.web.domain.vo.CreateImageTextVo;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

/**
 * @author danmo
 * @date 2024-04-07 18:47
 **/

@BaseRequest(baseURL = "${domain}")
public interface VideoClient {

    @Post(url = "${createImageText}?open_id=${query.open_id}", contentType = ContentType.APPLICATION_JSON)
    DyResult<CreateImageTextVo> createImageText(@JSONBody @Var("query") CreateImageTextQuery query);
}
