package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-09 11:34
 **/
public class RevokeGroupMsgQuery extends UserInfoQuery {

    private String msg_id;

    /**
     * 群ID
     */
    private String conversation_id;

    /**
     * 群聊类型 群聊=2
     */
    private Integer conversation_type = 2;


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

    public Integer getConversation_type() {
        return conversation_type;
    }

    public void setConversation_type(Integer conversation_type) {
        this.conversation_type = conversation_type;
    }

    public static RevokeGroupMsgQueryBuilder builder() {
        return new RevokeGroupMsgQueryBuilder();
    }

    public static class RevokeGroupMsgQueryBuilder {
        private String msgId;
        private String conversationId;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        public RevokeGroupMsgQueryBuilder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }
        public RevokeGroupMsgQueryBuilder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }
        public RevokeGroupMsgQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public RevokeGroupMsgQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public RevokeGroupMsgQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public RevokeGroupMsgQuery build() {
            RevokeGroupMsgQuery revokeGroupMsgQuery = new RevokeGroupMsgQuery();
            revokeGroupMsgQuery.setMsg_id(msgId);
            revokeGroupMsgQuery.setConversation_id(conversationId);
            revokeGroupMsgQuery.setOpen_id(openId);
            revokeGroupMsgQuery.setTenantId(tenantId);
            revokeGroupMsgQuery.setClientKey(clientKey);
            return revokeGroupMsgQuery;
        }
    }

    @Override
    public String toString() {
        return "RevokeGroupMsgQuery{" +
                "msg_id='" + msg_id + '\'' +
                ", conversation_id='" + conversation_id + '\'' +
                ", conversation_type=" + conversation_type +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
