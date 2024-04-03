package com.dyj.web.interceptor;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.domain.DyResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author danmo
 * @date 2024-04-03 11:07
 **/
@Component
public class AuthInterceptor implements Interceptor<DyResult> {
    private final Log log = LogFactory.getLog(AuthInterceptor.class);


    @Override
    public boolean beforeExecute(ForestRequest request) {
        return true;
    }

    @Override
    public void onSuccess(DyResult data, ForestRequest request, ForestResponse response) {
        log.info("AuthInterceptor onSuccess:" + data.toString());
    }
}
