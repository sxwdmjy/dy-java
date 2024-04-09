package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.SaveRetainConsultCardQuery;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.SaveRetainConsultCardVo;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

/**
 * 经营工具
 * @author danmo
 * @date 2024-04-09 16:45
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface BusinessClient {

    @Post(value = "${saveRetainConsultCard}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    SaveRetainConsultCardVo saveRetainConsultCard(@JSONBody @Var("query") SaveRetainConsultCardQuery query);

    @Get(value = "${getRetainConsultCard}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    DyResult<BaseVo> getRetainConsultCard(@Var("query") UserInfoQuery query);

    @Post(value = "${deleteRetainConsultCard}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    SaveRetainConsultCardVo deleteRetainConsultCard(@JSONBody @Var("query") SaveRetainConsultCardQuery query);
}
