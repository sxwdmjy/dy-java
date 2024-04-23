package com.dyj.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.handler.RequestHandler;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.common.domain.query.UserInfoQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Objects;

/**
 * access_token拦截器
 *
 * @author danmo
 * @date 2024-04-07 15:03
 **/
public class QueryTokenInterceptor implements Interceptor<Object> {

    private final Log log = LogFactory.getLog(QueryTokenInterceptor.class);
    @Override
    public boolean beforeExecute(ForestRequest request) {
        Integer tenantId = null;
        String clientKey = "";
        String openId = "";
        Object[] arguments = request.getArguments();
        for (Object argument : arguments) {
            if(argument instanceof UserInfoQuery){
                UserInfoQuery query = (UserInfoQuery) argument;
                openId = query.getOpen_id();
                tenantId = query.getTenantId();
                clientKey = query.getClientKey();
            }
        }
        IAgentTokenService agentTokenService = RequestHandler.getInstance().getDyConfiguration().getAgentTokenService();
        UserTokenInfo userTokenInfo = agentTokenService.getUserTokenInfo(tenantId, clientKey,openId);
        if (Objects.isNull(userTokenInfo)) {
            throw new RuntimeException("access_token is null");
        }
        request.replaceOrAddQuery("access-token", userTokenInfo.getAccessToken());
        request.replaceOrAddQuery("open_id", openId);
        return Interceptor.super.beforeExecute(request);
    }



    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        StringBuilder sb = new StringBuilder("QueryTokenInterceptor onError ");
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
        log.info(sb.toString());
    }
}
