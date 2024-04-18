package com.dyj.common.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 小程序引导卡片
 *
 * @author danmo
 * @date 2024-04-08 16:39
 **/
public class AppletCardMsg extends MsgContent {


    private JSONObject applet_card;

    public AppletCardMsg() {
        super.setMsg_type(MediaTypeEnum.APPLET_CARD);
    }



    public JSONObject getApplet_card() {
        return applet_card;
    }

    public void setApplet_card(JSONObject applet_card) {
        this.applet_card = applet_card;
    }

    public void setAppletCard(String cardTemplateId, String path, String query, String appId, String schema) {
        if (Objects.isNull(this.applet_card)) {
            this.applet_card = new JSONObject();
        }
        if (StringUtils.hasLength(cardTemplateId)) {
            this.applet_card.put("card_template_id", cardTemplateId);
        }

        if (StringUtils.hasLength(path)) {
            this.applet_card.put("path", path);
        }
        if (StringUtils.hasLength(query)) {
            this.applet_card.put("query", query);
        }

        if (StringUtils.hasLength(appId)) {
            this.applet_card.put("app_id", appId);
        }
        if(StringUtils.hasLength(schema)){
            this.applet_card.put("schema", schema);
        }
    }

    public static AppletCardMsgBuilder builder() {
        return new AppletCardMsgBuilder();
    }

    public static class AppletCardMsgBuilder {
        private String cardTemplateId;
        private String path;
        private String query;
        private String appId;
        private String schema;

        public AppletCardMsgBuilder cardTemplateId(String cardTemplateId) {
            this.cardTemplateId = cardTemplateId;
            return this;
        }

        public AppletCardMsgBuilder path(String path) {
            this.path = path;
            return this;
        }

        public AppletCardMsgBuilder query(String query) {
            this.query = query;
            return this;
        }

        public AppletCardMsgBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public AppletCardMsgBuilder schema(String schema) {
            this.schema = schema;
            return this;
        }

        public AppletCardMsg build() {
            AppletCardMsg appletCardMsg = new AppletCardMsg();
            appletCardMsg.setAppletCard(cardTemplateId, path, query, appId, schema);
            return appletCardMsg;
        }

    }
}
