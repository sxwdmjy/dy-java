package com.dyj.web.event;

/**
 * aweme.share（默认都有）
 * 用户使用开发者应用分享视频到抖音（携带分享id)
 */
public class CreateVideoEvent {

    /**
     * 创建的视频id
     */
    private String item_id;

    /**
     * 分享的share_id
     */
    private String share_id;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getShare_id() {
        return share_id;
    }

    public void setShare_id(String share_id) {
        this.share_id = share_id;
    }
}
