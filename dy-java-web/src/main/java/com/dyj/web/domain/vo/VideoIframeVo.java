package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;

public class VideoIframeVo extends BaseVo {

    /**
     * 视频iframe代码
     */
    private String iframe_code;

    /**
     * 视频高度
     */
    private String video_height;

    /**
     * 视频标题
     */
    private String video_title;

    /**
     * 视频宽度
     */
    private String video_width;

    public String getIframe_code() {
        return iframe_code;
    }

    public void setIframe_code(String iframe_code) {
        this.iframe_code = iframe_code;
    }

    public String getVideo_height() {
        return video_height;
    }

    public void setVideo_height(String video_height) {
        this.video_height = video_height;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_width() {
        return video_width;
    }

    public void setVideo_width(String video_width) {
        this.video_width = video_width;
    }

}
