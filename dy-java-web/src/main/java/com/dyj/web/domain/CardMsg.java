package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

/**
 * 留资卡片
 * @author danmo
 * @date 2024-04-08 15:50
 **/
public class CardMsg extends MsgContent {


    private JSONObject retain_consult_card;

    public CardMsg() {
        super.msg_type = 8;
    }


    public JSONObject getRetain_consult_card() {
        return retain_consult_card;
    }

    public void setRetain_consult_card(JSONObject retain_consult_card) {
        this.retain_consult_card = retain_consult_card;
    }

    public void setRetainConsultCard(String cardId) {
        if (Objects.isNull(this.retain_consult_card)) {
            this.retain_consult_card = new JSONObject();
        }
        this.retain_consult_card.put("card_id", cardId);
    }

    public static CardMsg build() {
        return new CardMsg();
    }

    public CardMsg cardId(String cardId) {
        this.setRetainConsultCard(cardId);
        return this;
    }

    @Override
    public String toString() {
        return "CardMsg{" +
                "msg_type=" + getMsg_type() +
                ", retain_consult_card=" + retain_consult_card +
                '}';
    }
}
