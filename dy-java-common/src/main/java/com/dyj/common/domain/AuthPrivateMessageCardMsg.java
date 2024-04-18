package com.dyj.common.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;

import java.util.Objects;

/**
 * 主动私信授权卡片
 * @author danmo
 * @date 2024-04-08 16:59
 **/
public class AuthPrivateMessageCardMsg extends MsgContent{

    private JSONObject auth_private_message_card;

    public AuthPrivateMessageCardMsg() {
        super.setMsg_type(MediaTypeEnum.auth_private_message_card);
    }


    public JSONObject getAuth_private_message_card() {
        return auth_private_message_card;
    }

    public void setAuth_private_message_card(JSONObject auth_private_message_card) {
        this.auth_private_message_card = auth_private_message_card;
    }
    public void setAuthPrivateMessageCard(AuthPrivateMessageCardAppInfo appInfo, AuthPrivateMessageCardToUserInfo toUserInfo) {
        if(Objects.isNull(this.auth_private_message_card)){
            this.auth_private_message_card = new JSONObject();
        }
        if(Objects.nonNull(appInfo)){
            this.auth_private_message_card.put("app_info",appInfo);
        }
        if(Objects.nonNull(toUserInfo)){
            this.auth_private_message_card.put("to_user_info",toUserInfo);
        }
    }

    public static AuthPrivateMessageCardMsgBuilder builder() {
        return new AuthPrivateMessageCardMsgBuilder();
    }

    public static class AuthPrivateMessageCardMsgBuilder {
        private AuthPrivateMessageCardAppInfo appInfo;
        private AuthPrivateMessageCardToUserInfo toUserInfo;
        public AuthPrivateMessageCardMsgBuilder appInfo(AuthPrivateMessageCardAppInfo appInfo) {
            this.appInfo = appInfo;
            return this;
        }
        public AuthPrivateMessageCardMsgBuilder toUserInfo(AuthPrivateMessageCardToUserInfo toUserInfo) {
            this.toUserInfo = toUserInfo;
            return this;
        }
        public AuthPrivateMessageCardMsg build() {
            AuthPrivateMessageCardMsg authPrivateMessageCardMsg = new AuthPrivateMessageCardMsg();
            authPrivateMessageCardMsg.setAuthPrivateMessageCard(appInfo,toUserInfo);
            return authPrivateMessageCardMsg;
        }
    }


    public static class AuthPrivateMessageCardAppInfo{
        private String app_id;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public static AuthPrivateMessageCardAppInfoBuilder builder(){
            return new AuthPrivateMessageCardAppInfoBuilder();
        }
        public static class AuthPrivateMessageCardAppInfoBuilder {
            private String appId;
            public AuthPrivateMessageCardAppInfoBuilder appId(String appId){
                this.appId = appId;
                return this;
            }
            public AuthPrivateMessageCardAppInfo build(){
                AuthPrivateMessageCardAppInfo authPrivateMessageCardAppInfo = new AuthPrivateMessageCardAppInfo();
                authPrivateMessageCardAppInfo.setApp_id(appId);
                return authPrivateMessageCardAppInfo;
            }
        }
    }

    public static class AuthPrivateMessageCardToUserInfo{
        private String app_id;
        private String open_id;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getOpen_id() {
            return open_id;
        }

        public void setOpen_id(String open_id) {
            this.open_id = open_id;
        }

        public static AuthPrivateMessageCardToUserInfoBuilder builder(){
            return new AuthPrivateMessageCardToUserInfoBuilder();
        }

        public static class AuthPrivateMessageCardToUserInfoBuilder {
            private String appId;
            private String openId;
            public AuthPrivateMessageCardToUserInfoBuilder appId(String appId){
                this.appId = appId;
                return this;
            }
            public AuthPrivateMessageCardToUserInfoBuilder openId(String openId){
                this.openId = openId;
                return this;
            }
            public AuthPrivateMessageCardToUserInfo build(){
                AuthPrivateMessageCardToUserInfo authPrivateMessageCardToUserInfo = new AuthPrivateMessageCardToUserInfo();
                authPrivateMessageCardToUserInfo.setApp_id(appId);
                authPrivateMessageCardToUserInfo.setOpen_id(openId);
                return authPrivateMessageCardToUserInfo;
            }
        }

    }

}
