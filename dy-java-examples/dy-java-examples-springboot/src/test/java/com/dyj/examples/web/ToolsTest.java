package com.dyj.examples.web;


import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.examples.DyJavaExamplesApplication;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.EventSubscribe;
import com.dyj.web.domain.query.UpdateEventSubscribeQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.EventSubscribeVo;
import com.dyj.web.domain.vo.MicAppDevtoolLegalVo;
import com.dyj.web.domain.vo.TicketVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class ToolsTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    //小程序接口能力
    @Test
    void micAppDevtoolLegal() {
        DyResult<MicAppDevtoolLegalVo> dyResult = DyWebClient.getInstance().micAppDevtoolLegal("micAppId");
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //模拟webhook事件
    @Test
    void webhookEventSend() {
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().webhookEventSend("eventType");
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //获取jsb_ticket
    @Test
    void getJsbTicket() {
        DyResult<TicketVo> dyResult = DyWebClient.getInstance().getJsbTicket();
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //获取 open_ticket
    @Test
    void getOpenTicket() {
        DyResult<TicketVo> dyResult = DyWebClient.getInstance().getOpenTicket();
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //获取事件订阅状态
    @Test
    void getEventSubscribeStatus() {
        DyResult<EventSubscribeVo> dyResult = DyWebClient.getInstance().getEventSubscribeStatus();
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //更新事件订阅状态
    @Test
    void updateEventSubscribeStatus() {
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().updateEventSubscribeStatus(UpdateEventSubscribeQuery.builder().list(Collections.singletonList(EventSubscribe.builder().build())).build());
    }
}