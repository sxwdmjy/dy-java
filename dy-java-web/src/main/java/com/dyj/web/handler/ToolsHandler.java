package com.dyj.web.handler;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Var;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.EventSubscribe;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.query.UpdateEventSubscribeQuery;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.EventSubscribeVo;
import com.dyj.web.domain.vo.MicAppDevtoolLegalVo;
import com.dyj.web.domain.vo.TicketVo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-11 17:36
 **/
public class ToolsHandler extends AbstractWebHandler {
    public ToolsHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 小程序接口能力
     * @param micAppId 小程序id
     * @return DyResult<MicAppDevtoolLegalVo>
     */
    public DyResult<MicAppDevtoolLegalVo> micAppDevtoolLegal(String micAppId) {
        return getToolsClient().micAppDevtoolLegal(baseQuery(), micAppId);
    }

    /**
     * 模拟webhook事件
     * @param eventType 事件类型
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> webhookEventSend(String eventType){
        return getToolsClient().webhookEventSend(baseQuery(), eventType);
    }

    /**
     * 获取jsb_ticket
     */
    public DyResult<TicketVo> getJsbTicket(){
        return getToolsClient().getJsbTicket(baseQuery());
    }

    /**
     * 获取 open_ticket
     */
    public DyResult<TicketVo> getOpenTicket(){
        return getToolsClient().getOpenTicket(baseQuery());
    }

    /**
     * 获取事件订阅状态
     * @return DyResult<EventSubscribeVo>
     */
    public DyResult<EventSubscribeVo> getEventSubscribeStatus(){
        return getToolsClient().getEventSubscribeStatus(baseQuery());
    }

    /**
     * 更新事件订阅状态
     * @param query
     * @return
     */
    public  DyResult<BaseVo> updateEventSubscribeStatus(UpdateEventSubscribeQuery query){
        baseQuery(query);
        return getToolsClient().updateEventSubscribeStatus(query);
    }
}
