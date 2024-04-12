package com.dyj.web.domain;

/**
 * 授权归因，不同的授权来源对应不同的归因字段
 * @author danmo
 * @date 2024-04-08 17:23
 **/
public class AuthUserAttribution {

    /**
     * 主播id
     */
    private String anchor_id;
    /**
     * 作者id
     */
    private String author_id;
    /**
     * 群聊id
     */
    private String conversation_id;
    /**
     * 消息发送者id
     */
    private String from_att_uid;
    /**
     * 群id
     */
    private String group_id;
    /**
     * 消息id
     */
    private String message_id;
    /**
     * 直播房间id
     */
    private String room_id;


    public String getAnchor_id() {
        return anchor_id;
    }

    public void setAnchor_id(String anchor_id) {
        this.anchor_id = anchor_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getFrom_att_uid() {
        return from_att_uid;
    }

    public void setFrom_att_uid(String from_att_uid) {
        this.from_att_uid = from_att_uid;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }
}
