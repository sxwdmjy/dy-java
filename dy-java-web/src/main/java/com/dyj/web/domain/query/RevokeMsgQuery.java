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

    public static RevokeMsgQuery build() {
        return new RevokeMsgQuery();
    }

    public RevokeMsgQuery conversationId(String conversation_id) {
        this.conversation_id = conversation_id;
        return this;
    }

    public RevokeMsgQuery conversationType(Integer conversation_type) {
        this.conversation_type = conversation_type;
        return this;
    }

    public RevokeMsgQuery msgId(String msg_id) {
        this.msg_id = msg_id;
        return this;
    }

    public RevokeMsgQuery openId(String open_id) {
        this.open_id = open_id;
        return this;
    }

    public RevokeMsgQuery tenantId(Integer tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public RevokeMsgQuery clientKey(String clientKey) {
        this.clientKey = clientKey;
        return this;
    }

    @Override
    public String toString() {
        return "RevokeMsgQuery{" +
                "conversation_id='" + conversation_id + '\'' +
                ", conversation_type=" + conversation_type +
                ", msg_id='" + msg_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
