package com.dyj.web.domain.query;

import com.alibaba.fastjson.JSONObject;
import com.dyj.web.domain.MsgContent;

/**
 * @author danmo
 * @date 2024-04-09 11:26
 **/
public class SendGroupMsgQuery extends UserInfoQuery {

    private String group_id;

    private MsgContent content;

    private String group_token;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public MsgContent getContent() {
        return content;
    }

    public void setContent(MsgContent content) {
        this.content = content;
    }

    public String getGroup_token() {
        return group_token;
    }

    public void setGroup_token(String group_token) {
        this.group_token = group_token;
    }

    public static SendGroupMsgQueryBuilder builder() {
        return new SendGroupMsgQueryBuilder();
    }

    public static class SendGroupMsgQueryBuilder {
        private String groupId;
        private MsgContent content;
        private String groupToken;
        private Integer tenantId;
        private String clientKey;
        private String openId;

        public SendGroupMsgQueryBuilder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public SendGroupMsgQueryBuilder content(MsgContent content) {
            this.content = content;
            return this;
        }

        public SendGroupMsgQueryBuilder groupToken(String groupToken) {
            this.groupToken = groupToken;
            return this;
        }

        public SendGroupMsgQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public SendGroupMsgQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public SendGroupMsgQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public SendGroupMsgQuery build() {
            return new SendGroupMsgQuery(this);
        }
    }

    public SendGroupMsgQuery() {
    }

    private SendGroupMsgQuery(SendGroupMsgQueryBuilder builder) {
        this.group_id = builder.groupId;
        this.content = builder.content;
        this.group_token = builder.groupToken;
        this.tenantId = builder.tenantId;
        this.clientKey = builder.clientKey;
        this.open_id = builder.openId;
    }


}
