package com.dyj.web.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.web.domain.MsgContent;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-08 13:37
 **/
public class SendMsgQuery extends UserInfoQuery {

    /**
     * 消息id，场景一、场景二必传
     * 场景一：来源于接收私信消息事件，对应 webhook 的 content 中 server_message_id 字段（有效期为24小时）
     * 场景二:来源于接收用户进入私信会话页事件，对应 webhook 的 content 中 server_message_id 字段（有效期为24小时）
     */
    private String msg_id;

    /**
     * 会话 id，场景一、场景二必传
     * 场景一：来源于接收私信消息事件，对应webhook 的 content 里的 conversation_short_id 字段（长期有效）
     * 场景二：来源于接收用户进入私信会话页事件，对应webhook 的 content 里的 conversation_short_id 字段（长期有效）
     */
    private String conversation_id;

    /**
     * 消息的接收方 open_id
     */
    private String to_user_id;

    /**
     * 消息体，场景一、场景二必传
     * 文本 content
     * 图片 content
     * 视频 content
     * 留资卡片 content
     * 小程序引导卡片 content
     * 群邀请卡片 content
     * 小程序券 content
     * 主动私信卡片 content
     */
    private MsgContent content;

    /**
     * 私信场景
     * 场景一：默认场景，可选传入 im_replay_msg
     * 场景二：用户主动进入私信会话页，必传 im_enter_direct_msg
     * 场景三: B2B场景私信触达，必传 im_b2b_direct_message
     * 场景四：主动私信持续触达，必传 im_authorize_message
     */
    private String scene;

    /**
     * 场景三, 场景四必传，最多支持三条消息
     * 场景三必须包含一条小程序卡片消息
     * 场景四必须包含一条小程序卡片/主动私信卡片/小程序券消息
     */
    private List<MsgContent> content_list;

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(String to_user_id) {
        this.to_user_id = to_user_id;
    }

    public MsgContent getContent() {
        return content;
    }

    public void setContent(MsgContent content) {
        this.content = content;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public List<MsgContent> getContent_list() {
        return content_list;
    }

    public void setContent_list(List<MsgContent> content_list) {
        this.content_list = content_list;
    }

    public static SendMsgQueryBuilder builder() {
        return new SendMsgQueryBuilder();
    }
    public static class SendMsgQueryBuilder {
        private String msgId;
        private String conversationId;
        private String toUserId;
        private MsgContent content;
        private String scene;
        private List<MsgContent> contentList;

        private Integer tenantId;
        private String clientKey;
        private String openId;

        public SendMsgQueryBuilder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public SendMsgQueryBuilder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public SendMsgQueryBuilder toUserId(String toUserId) {
            this.toUserId = toUserId;
            return this;
        }

        public SendMsgQueryBuilder content(MsgContent content) {
            this.content = content;
            return this;
        }

        public SendMsgQueryBuilder scene(String scene) {
            this.scene = scene;
            return this;
        }

        public SendMsgQueryBuilder contentList(List<MsgContent> contentList) {
            this.contentList = contentList;
            return this;
        }

        public SendMsgQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public SendMsgQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public SendMsgQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }


        public SendMsgQuery build() {
            SendMsgQuery sendMsgQuery = new SendMsgQuery();
            sendMsgQuery.setMsg_id(msgId);
            sendMsgQuery.setConversation_id(conversationId);
            sendMsgQuery.setTo_user_id(toUserId);
            sendMsgQuery.setContent(content);
            sendMsgQuery.setScene(scene);
            sendMsgQuery.setContent_list(contentList);
            sendMsgQuery.setTenantId(tenantId);
            sendMsgQuery.setClientKey(clientKey);
            sendMsgQuery.setOpen_id(openId);
            return sendMsgQuery;
        }
    }

}
