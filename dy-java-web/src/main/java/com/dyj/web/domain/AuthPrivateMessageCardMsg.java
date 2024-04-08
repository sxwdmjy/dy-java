package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

/**
 * 主动私信授权卡片
 * @author danmo
 * @date 2024-04-08 16:59
 **/
public class AuthPrivateMessageCardMsg extends MsgContent{

    private JSONObject auth_private_message_card;

    public AuthPrivateMessageCardMsg() {
        super.msg_type = 12;
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

    public static AuthPrivateMessageCardMsg build(){
        return new AuthPrivateMessageCardMsg();
    }

    public AuthPrivateMessageCardMsg appInfo(AuthPrivateMessageCardAppInfo appInfo){
        setAuthPrivateMessageCard(appInfo,null);
        return this;
    }

    public AuthPrivateMessageCardMsg toUserInfo(AuthPrivateMessageCardToUserInfo toUserInfo){
        setAuthPrivateMessageCard(null,toUserInfo);
        return this;
    }


    public static class AuthPrivateMessageCardAppInfo{
        private String app_id;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public static AuthPrivateMessageCardAppInfo build(){
            return new AuthPrivateMessageCardAppInfo();
        }

        public AuthPrivateMessageCardAppInfo appId(String appId){
            this.app_id = appId;
            return this;
        }

        @Override
        public String toString() {
            return "AuthPrivateMessageCardAppInfo{" +
                    "app_id='" + app_id + '\'' +
                    '}';
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

        public static AuthPrivateMessageCardToUserInfo build(){
            return new AuthPrivateMessageCardToUserInfo();
        }

        public AuthPrivateMessageCardToUserInfo appId(String appId){
            this.app_id = appId;
            return this;
        }

        @Override
        public String toString() {
            return "AuthPrivateMessageCardToUserInfo{" +
                    "app_id='" + app_id + '\'' +
                    ", open_id='" + open_id + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "AuthPrivateMessageCardMsg{" +
                "auth_private_message_card=" + auth_private_message_card +
                ", msg_type=" + msg_type +
                '}';
    }
}
