package com.dyj.web.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.handler.RequestHandler;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.query.UserInfoQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Objects;

/**
 * access_token拦截器
 *
 * @author danmo
 * @date 2024-04-07 15:03
 **/
public class AccessTokenInterceptor implements Interceptor<DyResult> {

    private final Log log = LogFactory.getLog(AccessTokenInterceptor.class);
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
            }else
            if (argument instanceof BaseQuery) {
                BaseQuery query = (BaseQuery) argument;
                tenantId = query.getTenantId();
                clientKey = query.getClientKey();
            }
        }
        IAgentTokenService agentTokenService = RequestHandler.getInstance().getDyConfiguration().getAgentTokenService();
        UserTokenInfo userTokenInfo = agentTokenService.getTokenInfo(tenantId, clientKey,openId);
        if (Objects.isNull(userTokenInfo)) {
            throw new RuntimeException("access_token is null");
        }
        request.addBody("access_token", userTokenInfo.getAccessToken());
        return Interceptor.super.beforeExecute(request);
    }

    @Override
    public void onSuccess(DyResult data, ForestRequest request, ForestResponse response) {
        log.info("AccessTokenInterceptor onSuccess:" + data.toString());
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        Interceptor.super.onError(ex, request, response);
    }
}
