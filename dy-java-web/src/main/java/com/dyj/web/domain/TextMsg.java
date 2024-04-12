package com.dyj.web.domain;

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

    public static TextMsg build(){
        return new TextMsg();
    }

    public TextMsg text(String text){
        setText(text);
        return this;
    }


}
