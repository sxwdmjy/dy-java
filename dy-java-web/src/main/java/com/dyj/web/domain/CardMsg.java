package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;

import java.util.Objects;

/**
 * 留资卡片
 * @author danmo
 * @date 2024-04-08 15:50
 **/
public class CardMsg extends MsgContent {


    private JSONObject retain_consult_card;

    public CardMsg() {
        super.setMsg_type(MediaTypeEnum.RETAIN_CONSULT_CARD);
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

    public static CardMsgBuilder builder() {
        return new CardMsgBuilder();
    }

   public static class CardMsgBuilder {
        private String cardId;

        public CardMsgBuilder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        public CardMsg build() {
            CardMsg cardMsg = new CardMsg();
            cardMsg.setRetainConsultCard(this.cardId);
            return cardMsg;
        }
   }
}
