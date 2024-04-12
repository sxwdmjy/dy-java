package com.dyj.web.domain;

/**
 * @author danmo
 * @date 2024-04-11 14:12
 **/
public class VideoBasicInfo {

    /**
     * 视频id
     */
    private String item_id;

    /**
     * 视频真实id
     */
    private String video_id;

    /**
     * 媒体类型
     * NONE=0
     * TEXT=1
     * PIC=2
     * GIF=3
     * VIDEO=4
     * PIC_LIST=5
     * STORY=1
     * 1VR=12
     * FORWARD=21
     * STORY_LIVE=22
     * STORY_PIC=23
     */
    private Integer media_type;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频状态。2:不适宜公开;4:审核中;5:公开视频
     */
    private Integer video_status;

    /**
     * 视频封面
     */
    private String cover;

    /**
     * 视频创建时间戳
     */
    private Long create_time;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public Integer getMedia_type() {
        return media_type;
    }

    public void setMedia_type(Integer media_type) {
        this.media_type = media_type;
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
}
