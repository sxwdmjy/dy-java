package com.dyj.web.domain;

/**
 * 获取热点词聚合的视频返回值 视频数据
 */
public class HotVideoListDataResult {

    /**
     * 视频封面
     */
    private String cover;
    /**
     * 视频创建时间戳
     */
    private Long create_time;
    /**
     * 表示是否审核结束。审核通过或者失败都会返回true，审核中返回false。
     */
    private Boolean is_reviewed;
    /**
     * 是否置顶
     */
    private Boolean is_top;
    /**
     * 视频id
     */
    private String item_id;
    /**
     * 媒体类型。2:图集;4:视频 选填
     */
    private Integer media_type;
    /**
     * 视频播放页面。视频播放页可能会失效，请在观看视频前调用/video/data/获取最新的播放页。
     */
    private String share_url;
    /**
     * 视频标题
     */
    private String title;
    /**
     * 表示视频状态。1:细化为5、6、7三种状态;2:不适宜公开;4:审核中;5:公开视频;6:好友可见;7:私密视频
     */
    private Integer video_status;
    /**
     * 统计数据 选填
     */
    private HotVideoListStatistics statistics;

    public String getCover() {
        return cover;
    }

    public HotVideoListDataResult setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public HotVideoListDataResult setCreate_time(Long create_time) {
        this.create_time = create_time;
        return this;
    }

    public Boolean getIs_reviewed() {
        return is_reviewed;
    }

    public HotVideoListDataResult setIs_reviewed(Boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
        return this;
    }

    public Boolean getIs_top() {
        return is_top;
    }

    public HotVideoListDataResult setIs_top(Boolean is_top) {
        this.is_top = is_top;
        return this;
    }

    public String getItem_id() {
        return item_id;
    }

    public HotVideoListDataResult setItem_id(String item_id) {
        this.item_id = item_id;
        return this;
    }

    public Integer getMedia_type() {
        return media_type;
    }

    public HotVideoListDataResult setMedia_type(Integer media_type) {
        this.media_type = media_type;
        return this;
    }

    public String getShare_url() {
        return share_url;
    }

    public HotVideoListDataResult setShare_url(String share_url) {
        this.share_url = share_url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public HotVideoListDataResult setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getVideo_status() {
        return video_status;
    }

    public HotVideoListDataResult setVideo_status(Integer video_status) {
        this.video_status = video_status;
        return this;
    }

    public HotVideoListStatistics getStatistics() {
        return statistics;
    }

    public HotVideoListDataResult setStatistics(HotVideoListStatistics statistics) {
        this.statistics = statistics;
        return this;
    }
}
