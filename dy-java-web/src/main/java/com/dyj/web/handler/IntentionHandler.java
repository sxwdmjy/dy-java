package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.IntentionLogQuery;
import com.dyj.web.domain.vo.IntentionLogVo;

/**
 * @author danmo
 * @date 2024-04-10 15:17
 **/
public class IntentionHandler extends AbstractWebHandler {
    public IntentionHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 互动用户记录查询
     *
     * @param query 入参
     * @return DyResult<IntentionLogVo>
     */
    public DyResult<IntentionLogVo> intentionLog(IntentionLogQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getIntentionClient().intentionLog(query);
    }
}
