package com.dyj.applet.client;

import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dyj.applet.domain.query.Code2SessionQuery;
import com.dyj.applet.domain.vo.Code2SessionVo;
import com.dyj.common.domain.DySimpleResult;

/**
 * @author danmo
 * @date 2024-04-17 10:52
 **/
public interface LoginClient {

    @Post(url = "${code2Session}")
    DySimpleResult<Code2SessionVo> code2Session(@JSONBody Code2SessionQuery query);
}
