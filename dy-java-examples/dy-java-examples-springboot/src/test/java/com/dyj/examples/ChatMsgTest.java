package com.dyj.examples;


import com.alibaba.fastjson.JSONArray;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.TextMsg;
import com.dyj.web.domain.query.AuthorizeUserListQuery;
import com.dyj.web.domain.query.RevokeMsgQuery;
import com.dyj.web.domain.query.SendMsgQuery;
import com.dyj.web.domain.vo.AuthorizeUserListVo;
import com.dyj.web.domain.vo.BaseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class ChatMsgTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    private final String msgId = "";
    private final String conversationId = "";

    /**
     * 发送私信消息
     */
    @Test
    void sendMessage() {
        SendMsgQuery sendMsgQuery = SendMsgQuery.builder().msgId("")
                .openId(openId)
                .msgId(msgId)
                .conversationId(conversationId)
                .toUserId("")
                .content(TextMsg.builder().text("12321321").build()).build();
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().sendMessage(sendMsgQuery);
        System.out.println(JSONArray.toJSONString(dyResult));
    }

    //查询主动授权私信用户
    @Test
    void queryAuthorizeUserList() {
        AuthorizeUserListQuery query = AuthorizeUserListQuery.builder()
                .pageNum(1)
                .pageSize(10)
                .openId(openId)
                .build();
        DyResult<AuthorizeUserListVo> dyResult = DyWebClient.getInstance().queryAuthorizeUserList(query);
        System.out.println(JSONArray.toJSONString(dyResult));
    }

    //私信消息撤回
    @Test
    void revokeMessage() {
        RevokeMsgQuery query = RevokeMsgQuery.builder()
                .msgId(msgId)
                .conversationId(conversationId)
                .conversationType(1)
                .build();
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().revokeMessage(query);
        System.out.println(JSONArray.toJSONString(dyResult));
    }
}