package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 群聊邀请卡片
 *
 * @author danmo
 * @date 2024-04-08 15:56
 **/
public class InvitationMsg extends MsgContent{


    private JSONObject group_invitation;

    public InvitationMsg() {
        super.setMsg_type(MediaTypeEnum.GROUP_INVITATION);
    }
    public JSONObject getGroup_invitation() {
        return group_invitation;
    }

    public void setGroup_invitation(JSONObject group_invitation) {
        this.group_invitation = group_invitation;
    }

    public void setGroupInvitation(String groupId, String groupToken) {
        if (Objects.isNull(this.group_invitation)) {
            this.group_invitation = new JSONObject();
        }
        if (StringUtils.hasLength(groupId)) {
            this.group_invitation.put("group_id", groupId);
        }
        if (StringUtils.hasLength(groupToken)) {
            this.group_invitation.put("group_id", groupId);
        }
    }

    public static InvitationMsg build() {
        return new InvitationMsg();
    }

    public InvitationMsg groupId(String groupId) {
        setGroupInvitation(groupId, null);
        return this;
    }

    public InvitationMsg groupToken(String groupToken) {
        setGroupInvitation(null, groupToken);
        return this;
    }

    @Override
    public String toString() {
        return "InvitationMsg{" +
                "msg_type=" + getMsg_type() +
                ", group_invitation=" + group_invitation +
                '}';
    }
}
