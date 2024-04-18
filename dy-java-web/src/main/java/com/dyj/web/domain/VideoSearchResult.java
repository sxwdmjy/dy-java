package com.dyj.web.domain;

import com.dyj.common.domain.VideoStatistics;

/**
 * 关键词视频搜索接口返回
 */
public class VideoSearchResult {

    /**
     * 视频封面
     */
    private String cover;
    /**
     * 表示是否审核结束。审核通过或者失败都会返回true，审核中返回false
     */
    private Boolean is_reviewed;
    /**
     * 视频创建时间戳
     */
    private Long create_time;
    /**
     * 视频id
     */
    private String item_id;
    /**
     * 作者openID
     */
    private String open_id;
    /**
     * 特殊加密的视频id通过用户视频搜索的评论接口获取到
     */
    private String sec_item_id;
    /**
     * 视频播放页面。视频播放页可能会失效，请在观看视频前调用/video/data/获取最新的播放页。
     */
    private String share_url;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 视频标题
     */
    private String title;
    /**
     * 是否置顶
     */
    private Boolean is_top;
    /**
     * 统计数据 选填
     */
    private VideoStatistics statistics;

    public String getCover() {
        return cover;
    }

    public VideoSearchResult setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public Boolean getIs_reviewed() {
        return is_reviewed;
    }

    public VideoSearchResult setIs_reviewed(Boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
        return this;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public VideoSearchResult setCreate_time(Long create_time) {
        this.create_time = create_time;
        return this;
    }

    public String getItem_id() {
        return item_id;
    }

    public VideoSearchResult setItem_id(String item_id) {
        this.item_id = item_id;
        return this;
    }

    public String getOpen_id() {
        return open_id;
    }

    public VideoSearchResult setOpen_id(String open_id) {
        this.open_id = open_id;
        return this;
    }

    public String getSec_item_id() {
        return sec_item_id;
    }

    public VideoSearchResult setSec_item_id(String sec_item_id) {
        this.sec_item_id = sec_item_id;
        return this;
    }

    public String getShare_url() {
        return share_url;
    }

    public VideoSearchResult setShare_url(String share_url) {
        this.share_url = share_url;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public VideoSearchResult setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public VideoSearchResult setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public VideoSearchResult setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getIs_top() {
        return is_top;
    }

    public VideoSearchResult setIs_top(Boolean is_top) {
        this.is_top = is_top;
        return this;
    }

    public VideoStatistics getStatistics() {
        return statistics;
    }

    public VideoSearchResult setStatistics(VideoStatistics statistics) {
        this.statistics = statistics;
        return this;
    }

    @Override
    public String toString() {
        return "VideoSearchResult{" +
                "cover='" + cover + '\'' +
                ", is_reviewed=" + is_reviewed +
                ", create_time=" + create_time +
                ", item_id='" + item_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", sec_item_id='" + sec_item_id + '\'' +
                ", share_url='" + share_url + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", title='" + title + '\'' +
                ", is_top=" + is_top +
                ", statistics=" + statistics +
                '}';
    }
}
