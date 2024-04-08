package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;
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
        this.msg_type = 10;
    }



    public JSONObject getApplet_card() {
        return applet_card;
    }

    public void setApplet_card(JSONObject applet_card) {
        this.applet_card = applet_card;
    }

    public void setAppletCard(String cardTemplateId, String path, String query, String appId) {
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
    }


    public static AppletCardMsg build() {
        return new AppletCardMsg();
    }

    public AppletCardMsg cardTemplateId(String cardTemplateId) {
        setAppletCard(cardTemplateId, null, null, null);
        return this;
    }

    public AppletCardMsg path(String path) {
        setAppletCard(null, path, null, null);
        return this;
    }


    public AppletCardMsg query(String query) {
        setAppletCard(null, null, query, null);
        return this;
    }

    public AppletCardMsg appId(String appId) {
        setAppletCard(null, null, null, appId);
        return this;
    }

    @Override
    public String toString() {
        return "AppletCardMsg{" +
                "msg_type=" + getMsg_type() +
                ", applet_card=" + applet_card +
                '}';
    }
}
