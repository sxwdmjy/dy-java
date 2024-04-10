package com.dyj.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.handler.RequestHandler;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.query.UserInfoQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Objects;

public class ClientTokenInterceptor implements Interceptor<DyResult> {
    private final Log log = LogFactory.getLog(ClientTokenInterceptor.class);
    @Override
    public boolean beforeExecute(ForestRequest request) {
        Integer tenantId = null;
        String clientKey = "";
        Object[] arguments = request.getArguments();
        for (Object argument : arguments) {
            if (argument instanceof BaseQuery) {
                BaseQuery query = (BaseQuery) argument;
                tenantId = query.getTenantId();
                clientKey = query.getClientKey();
            }

        }
        IAgentTokenService agentTokenService = RequestHandler.getInstance().getDyConfiguration().getAgentTokenService();
        ClientTokenInfo clientTokenInfo = agentTokenService.getClientTokenInfo(tenantId, clientKey);
        if (Objects.isNull(clientTokenInfo)) {
            throw new RuntimeException("access_token is null");
        }
        request.addBody("access-token", clientTokenInfo.getAccessToken());
        return Interceptor.super.beforeExecute(request);
    }

    @Override
    public void onSuccess(DyResult data, ForestRequest request, ForestResponse response) {
        log.info("ClientTokenInterceptor onSuccess:" + data.toString());
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        StringBuilder sb = new StringBuilder("ClientTokenInterceptor onError ");
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
