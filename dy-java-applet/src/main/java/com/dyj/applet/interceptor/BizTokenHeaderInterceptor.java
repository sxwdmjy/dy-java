package com.dyj.applet.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.vo.BizTokenVo;
import com.dyj.common.utils.DyConfigUtils;

import java.util.Objects;

/**
 * 经销token拦截器
 *
 * @author danmo
 * @date 2024-04-17 10:13
 **/
public class BizTokenHeaderInterceptor implements Interceptor<DyAppletResult> {


    @Override
    public boolean beforeExecute(ForestRequest request) {
        Integer tenantId = null;
        String clientKey = "";
        String openId = "";
        Object[] arguments = request.getArguments();

        BizTokenVo bizToken = DyConfigUtils.getAgentTokenService().getBizToken(tenantId, clientKey, openId);
        if (Objects.isNull(bizToken)) {
            throw new RuntimeException("access-token is null");
        }
        request.addHeader("access-token", bizToken.getBiz_token());
        return true;
    }

    @Override
    public void onSuccess(DyAppletResult data, ForestRequest request, ForestResponse response) {
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
