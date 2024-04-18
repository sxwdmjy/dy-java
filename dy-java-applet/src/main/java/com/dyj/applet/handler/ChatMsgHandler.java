package com.dyj.applet.handler;

import com.dyj.applet.domain.query.ImAuthStatusQuery;
import com.dyj.applet.domain.query.ImAuthorizeUserListQuery;
import com.dyj.applet.domain.query.RevokeMsgQuery;
import com.dyj.applet.domain.query.SendMsgQuery;
import com.dyj.applet.domain.vo.AuthSendMsgVo;
import com.dyj.applet.domain.vo.ImAuthStatusVo;
import com.dyj.applet.domain.vo.ImAuthUserListVo;
import com.dyj.applet.domain.vo.SendMsgResponseVo;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-18 13:48
 **/
public class ChatMsgHandler extends AbstractAppletHandler {

    public ChatMsgHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 发送私信消息
     *
     * @param query 入参
     * @return ChatMsgResponseVo
     */
    public SendMsgResponseVo sendMessage(SendMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getChatMsgClient().sendMessage(query);
    }

    /**
     * 发送主动私信
     *
     * @param query 入参
     * @return DySimpleResult<AuthSendMsgVo>
     */
    public DySimpleResult<AuthSendMsgVo> authSendMsg(SendMsgQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getChatMsgClient().authSendMsg(query);
    }

    /**
     * 查询主动私信用户授权状态
     *
     * @param openId  用户ID
     * @param cOpenId C端用户的open_id
     * @param appId   C端用户open_id所在的小程序 可不传
     * @return DySimpleResult<ImAuthStatusVo>
     */
    public DySimpleResult<ImAuthStatusVo> queryImAuthStatus(String openId, String cOpenId, String appId) {
        ImAuthStatusQuery query = ImAuthStatusQuery.builder().openId(openId).cOpenId(cOpenId).appId(appId)
                .clientKey(agentConfiguration.getClientKey()).tenantId(agentConfiguration.getTenantId()).build();
        return getChatMsgClient().queryImAuthStatus(query);
    }

    /**
     * 查询授权主动私信用户
     *
     * @param openId   用户ID
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return DySimpleResult<ImAuthUserListVo>
     */
    public DySimpleResult<ImAuthUserListVo> queryAuthorizeUserList(String openId, Long pageNum, Long pageSize) {
        return getChatMsgClient().queryAuthorizeUserList(ImAuthorizeUserListQuery.builder()
                .openId(openId).pageNum(pageNum).pageSize(pageSize)
                .clientKey(agentConfiguration.getClientKey()).tenantId(agentConfiguration.getTenantId()).build());
    }

    /**
     * 私信消息撤回
     *
     * @param openId           用户ID
     * @param msgId            消息ID
     * @param conversationId   会话 ID：来源于私信 webhook，接收私信消息事件，对应 webhook 的 content 里的conversation_short_id 字段
     * @param conversationType 会话类型 1- 单聊 2- 群聊
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> revokeMessage(String openId, String msgId, String conversationId, Integer conversationType) {
        return getChatMsgClient().revokeMessage(RevokeMsgQuery.builder()
                .openId(openId).msgId(msgId).conversationId(conversationId).conversationType(conversationType)
                .clientKey(agentConfiguration.getClientKey()).tenantId(agentConfiguration.getTenantId())
                .build());
    }
}
