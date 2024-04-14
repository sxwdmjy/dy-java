package com.dyj.web.event;

/**
 * 视频分享消息
 */
public class ImGroupMsgVideoEvent extends ImGroupMsgEvent {
    /**
     * 加密后的视频ID
     */
    private String item_id;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
