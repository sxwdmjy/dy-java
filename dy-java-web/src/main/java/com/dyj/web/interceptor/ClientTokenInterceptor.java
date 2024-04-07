package com.dyj.web.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyResult;

public class ClientTokenInterceptor implements Interceptor<DyResult> {

    @Override
    public boolean beforeExecute(ForestRequest request) {
        return Interceptor.super.beforeExecute(request);
    }

    @Override
    public void onSuccess(DyResult data, ForestRequest request, ForestResponse response) {
        Interceptor.super.onSuccess(data, request, response);
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        Interceptor.super.onError(ex, request, response);
    }
}
