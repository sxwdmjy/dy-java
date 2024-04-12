package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-08 18:20
 **/
public class RevokeMsgQuery extends UserInfoQuery {

    /**
     * 会话 ID：来源于私信 webhook，接收私信消息事件，对应 webhook 的 content 里的conversation_short_id 字段
     */
    private String conversation_id;

    /**
     * 会话类型 1- 单聊 2- 群聊
     */
    private Integer conversation_type;

    /**
     * 消息 id：来源于私信 webhook 接收私信消息事件，对应 webhook 的 content 里的server_message_id 字段
     */
    private String msg_id;


    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Integer getConversation_type() {
        return conversation_type;
    }

    public void setConversation_type(Integer conversation_type) {
        this.conversation_type = conversation_type;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public static RevokeMsgQueryBuilder builder() {
        return new RevokeMsgQueryBuilder();
    }

    public static class RevokeMsgQueryBuilder {
        private String conversationId;
        private Integer conversationType;
        private String msgId;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        public RevokeMsgQueryBuilder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }
        public RevokeMsgQueryBuilder conversationType(Integer conversationType) {
            this.conversationType = conversationType;
            return this;
        }
        public RevokeMsgQueryBuilder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }
        public RevokeMsgQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public RevokeMsgQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public RevokeMsgQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public RevokeMsgQuery build() {
            RevokeMsgQuery revokeMsgQuery = new RevokeMsgQuery();
            revokeMsgQuery.setConversation_id(conversationId);
            revokeMsgQuery.setConversation_type(conversationType);
            revokeMsgQuery.setMsg_id(msgId);
            revokeMsgQuery.setOpen_id(openId);
            revokeMsgQuery.setTenantId(tenantId);
            revokeMsgQuery.setClientKey(clientKey);
            return revokeMsgQuery;
        }
}


}
