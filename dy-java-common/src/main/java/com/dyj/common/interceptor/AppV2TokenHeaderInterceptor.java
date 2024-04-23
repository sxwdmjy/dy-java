package com.dyj.common.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.domain.vo.AppsV2TokenVo;
import com.dyj.common.utils.DyConfigUtils;

import java.util.Objects;

/**
 * appV2token拦截器
 *
 * @author danmo
 * @date 2024-04-17 10:13
 **/
public class AppV2TokenHeaderInterceptor implements Interceptor<Object> {

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
        AppsV2TokenVo appsV2Token = DyConfigUtils.getAgentTokenService().getAppsV2Token(tenantId, clientKey);
        if (Objects.isNull(appsV2Token)) {
            throw new RuntimeException("access-token is null");
        }
        request.addHeader("access-token", appsV2Token.getAccess_token());
        return true;
    }

    @Override
    public void onSuccess(Object data, ForestRequest request, ForestResponse response) {
        Interceptor.super.onSuccess(data, request, response);
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        Interceptor.super.onError(ex, request, response);
    }

    @Override
    public void onRetry(ForestRequest request, ForestResponse response) {
        Interceptor.super.onRetry(request, response);
    }
}
