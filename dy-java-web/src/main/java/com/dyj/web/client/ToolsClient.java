package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.interceptor.ClientTokenInterceptor;
import com.dyj.web.domain.query.UpdateEventSubscribeQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.EventSubscribeVo;
import com.dyj.web.domain.vo.TicketVo;
import com.dyj.web.domain.vo.MicAppDevtoolLegalVo;
import com.dyj.common.interceptor.ClientQueryTokenInterceptor;

/**
 * @author danmo
 * @date 2024-04-11 17:29
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface ToolsClient {

    /**
     * 小程序接口能力
     * @param query 基本信息
     * @param micAppId 小程序id
     * @return DyResult<MicAppDevtoolLegalVo>
     */
    @Get(value = "${micAppDevtoolLegal}", interceptor = ClientTokenInterceptor.class)
    DyResult<MicAppDevtoolLegalVo> micAppDevtoolLegal(@Var("query") BaseQuery query, @Query("micapp_id") String micAppId);

    /**
     *模拟webhook事件
     */
    @Post(value = "${webhookEventSend}", interceptor = ClientTokenInterceptor.class)
    DyResult<BaseVo> webhookEventSend(@Var("query") BaseQuery query, @Body("event_type") String eventType);

    /**
     * 获取jsb_ticket
     */
    @Get(value = "${getJsbTicket}", interceptor = ClientTokenInterceptor.class)
    DyResult<TicketVo> getJsbTicket(@Var("query") BaseQuery query);

    /**
     * 获取 open_ticket
     */
    @Get(value = "${getOpenTicket}", interceptor = ClientTokenInterceptor.class)
    DyResult<TicketVo> getOpenTicket(@Var("query") BaseQuery query);

    /**
     * 获取事件订阅状态
     */
    @Get(value = "${getEventSubscribeStatus}", interceptor = ClientQueryTokenInterceptor.class)
    DyResult<EventSubscribeVo> getEventSubscribeStatus(@Var("query") BaseQuery query);

    /**
     * 更新应用推送事件订阅状态
     * @param query
     * @return
     */
    @Post(value = "${updateEventSubscribeStatus}", interceptor = ClientQueryTokenInterceptor.class)
    DyResult<BaseVo> updateEventSubscribeStatus(@JSONBody UpdateEventSubscribeQuery query);
}
