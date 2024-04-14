package com.dyj.web.event;

/**
 * 文本消息
 */
public class ImGroupMsgTextEvent extends ImGroupMsgEvent {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
