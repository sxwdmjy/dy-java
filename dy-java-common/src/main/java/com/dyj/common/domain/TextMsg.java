package com.dyj.common.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;

import java.util.Objects;

/**
 * 文本
 * @author danmo
 * @date 2024-04-08 14:22
 **/
public class TextMsg extends MsgContent{

    private JSONObject text;

    public TextMsg() {
        super.setMsg_type(MediaTypeEnum.TEXT);
    }

    public JSONObject getText() {
        return text;
    }

    public void setText(String text) {
        if (Objects.isNull(this.text)) {
            this.text = new JSONObject();
        }
        this.text.put("text", text);
    }

    public void setText(JSONObject text) {
        this.text = text;
    }

    public static TextMsgBuilder builder(){
        return new TextMsgBuilder();
    }

    public static class TextMsgBuilder{
        private String text;

        public TextMsgBuilder text(String text){
            this.text = text;
            return this;
        }

        public TextMsg build(){
            TextMsg textMsg = new TextMsg();
            textMsg.setText(text);
            return textMsg;
        }
    }



}
