package com.dyj.web.domain;

/**
 * @author danmo
 * @date 2024/04/07 22:40
 */
public class AccountVideo {

    /**
     * 视频封面
     */
    private String cover;

    /**
     * 视频创建时间
     */
    private Long create_time;

    /**
     * 是否审核通过
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
     * 分享链接
     */
    private String share_url;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频状态。1:细化为5、6、7三种状态;2:不适宜公开;4:审核中;5:公开视频;6:好友可见;7:私密视频
     */
    private Integer video_status;

    /**
     * 视频类型
     */
    private Integer media_type;

    /**
     * 视频统计信息
     */
    private VideoStatistics statistics;

    /**
     * 视频真实id
     */
    private String video_id;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Boolean getIs_reviewed() {
        return is_reviewed;
    }

    public void setIs_reviewed(Boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    public Boolean getIs_top() {
        return is_top;
    }

    public void setIs_top(Boolean is_top) {
        this.is_top = is_top;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVideo_status() {
        return video_status;
    }

    public void setVideo_status(Integer video_status) {
        this.video_status = video_status;
    }

    public Integer getMedia_type() {
        return media_type;
    }

    public void setMedia_type(Integer media_type) {
        this.media_type = media_type;
    }

    public VideoStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(VideoStatistics statistics) {
        this.statistics = statistics;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
