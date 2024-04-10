package com.dyj.web.domain.vo;

import com.dyj.web.domain.UploadVideo;

public class UploadVideoVo extends BaseVo {

    private UploadVideo video;

    public UploadVideo getVideo() {
        return video;
    }

    public void setVideo(UploadVideo video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "UploadVideoVo{" +
                "video=" + video +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}