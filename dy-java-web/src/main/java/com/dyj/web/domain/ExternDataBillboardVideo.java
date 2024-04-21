package com.dyj.web.domain;

/**
 * 数据开放接口榜单 视频信息
 */
public class ExternDataBillboardVideo {

    /**
     * 视频封面图
     */
    private String item_cover;
    /**
     * 视频播放页面。视频播放页可能会失效，请在观看视频前调用/video/data/获取最新的播放页。 选填
     */
    private String share_url;
    /**
     * 视频标题 选填
     */
    private String title;

    public String getItem_cover() {
        return item_cover;
    }

    public ExternDataBillboardVideo setItem_cover(String item_cover) {
        this.item_cover = item_cover;
        return this;
    }

    public String getShare_url() {
        return share_url;
    }

    public ExternDataBillboardVideo setShare_url(String share_url) {
        this.share_url = share_url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ExternDataBillboardVideo setTitle(String title) {
        this.title = title;
        return this;
    }
}
