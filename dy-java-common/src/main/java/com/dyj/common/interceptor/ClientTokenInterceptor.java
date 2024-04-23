package com.dyj.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dyj.common.client.AuthClient;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.ClientTokenInfo;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.domain.query.ClientTokenQuery;
import com.dyj.common.domain.vo.ClientTokenVo;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.common.utils.DyConfigUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;

@Component
public class ClientTokenInterceptor implements Interceptor<DySimpleResult> {
    private final Log log = LogFactory.getLog(ClientTokenInterceptor.class);
    @Resource
    private AuthClient authClient;

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
            AgentConfiguration agent = DyConfigUtils.getAgent(tenantId, clientKey);
            ClientTokenQuery clientTokenQuery = new ClientTokenQuery();
            clientTokenQuery.setClient_key(agent.getClientKey());
            clientTokenQuery.setClient_secret(agent.getClientSecret());
            ClientTokenVo clientToken = authClient.getClientToken(clientTokenQuery).getData();
            if (Objects.nonNull(clientToken) && clientToken.getError_code() == 0) {
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
