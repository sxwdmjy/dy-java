package com.dyj.web.event;

import com.dyj.web.domain.GroupMsgUserInfo;

import java.util.List;

/**
 * im.group_message
 * 接收群消息事件
 */
public class ImGroupMsgEvent {

    /**
     * 群ID，群唯一标识
     */
    private String conversation_short_id;

    /**
     * 消息ID
     */
    private String server_message_id;

    /**
     * 会话类型（2：群聊）
     */
    private Integer conversation_type;

    /**
     * 消息类型（不同类型消息参数见下方介绍）
     * text：文本
     * image：图片
     * emoji：表情
     * video：视频
     * retain_consult_card：留资卡片
     * other：其他
     */
    private String message_type;

    /**
     * 消息创建时间，13位毫秒级时间戳
     */
    private Long create_time;

    /**
     * 群主open_id
     */
    private String owner_id;

    /**
     * 场景类型
     *
     * 1：关键词自动回复
     * 2:欢迎语
     * 100:其他
     */
    private Integer scene_type;

    /**
     *  区分发出应用
     * 通过发送群消息接口发送会显示具体的clientkey
     * 通过端上主动发送，该字段默认为空
     */
    private String source;

    /**
     * 用户基本信息，包括：昵称和头像
     */
    private List<GroupMsgUserInfo> user_infos;

    public String getConversation_short_id() {
        return conversation_short_id;
    }

    public void setConversation_short_id(String conversation_short_id) {
        this.conversation_short_id = conversation_short_id;
    }

    public String getServer_message_id() {
        return server_message_id;
    }

    public void setServer_message_id(String server_message_id) {
        this.server_message_id = server_message_id;
    }

    public Integer getConversation_type() {
        return conversation_type;
    }

    public void setConversation_type(Integer conversation_type) {
        this.conversation_type = conversation_type;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getScene_type() {
        return scene_type;
    }

    public void setScene_type(Integer scene_type) {
        this.scene_type = scene_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<GroupMsgUserInfo> getUser_infos() {
        return user_infos;
    }

    public void setUser_infos(List<GroupMsgUserInfo> user_infos) {
        this.user_infos = user_infos;
    }
}
