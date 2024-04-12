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
import com.dyj.common.utils.DyConfigUtils;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.web.domain.vo.ClientTokenVo;
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
        IAgentTokenService agentTokenService = DyConfigUtils.getAgentTokenService();
        ClientTokenInfo clientTokenInfo = agentTokenService.getClientTokenInfo(tenantId, clientKey);
        if (Objects.isNull(clientTokenInfo)) {
            ClientTokenVo clientToken = DyWebClient.getInstance().tenantId(tenantId).clientKey(clientKey).clientToken().getData();
            if(Objects.nonNull(clientToken) && clientToken.getError_code() == 0){
                clientTokenInfo = agentTokenService.setClientTokenInfo(tenantId, clientKey, clientToken.getAccess_token(), clientToken.getExpires_in());
            }
        }
        if (Objects.nonNull(clientTokenInfo)) {
            request.addHeader("access-token", clientTokenInfo.getAccessToken());
        }
        return true;
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
        log.info(sb.toString());
    }
}
