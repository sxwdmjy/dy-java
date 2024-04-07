package com.dyj.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 无需access_token拦截器
 * @author danmo
 * @date 2024-04-03 11:07
 **/
public class NoTokenInterceptor implements Interceptor<DyResult> {
    private final Log log = LogFactory.getLog(NoTokenInterceptor.class);

    @Override
    public boolean beforeExecute(ForestRequest request) {
        return true;
    }

    @Override
    public void onSuccess(DyResult data, ForestRequest request, ForestResponse response) {
        log.info("AuthInterceptor onSuccess:" + data.toString());
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        StringBuilder sb = new StringBuilder("AuthInterceptor onError ");
        sb.append("url:");
        sb.append(request.getUrl());
        sb.append(", ");
        sb.append("params:");
        sb.append(JSONObject.toJSONString(request.getArguments()));
        sb.append(", ");
        sb.append("result:");
        sb.append(response.getContent());
        sb.append(", ");
        sb.append("msg:");
        sb.append(ex.getMessage());
        log.info("AuthInterceptor onError:" + sb.toString());
    }
}
