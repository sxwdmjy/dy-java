package com.dyj.web.domain.vo;

import com.dyj.web.domain.UploadMedia;

/**
 * @author danmo
 * @date 2024-04-11 15:10
 **/
public class UploadMaterialVo extends BaseVo{

    private UploadMedia media;

    public UploadMedia getMedia() {
        return media;
    }

    public void setMedia(UploadMedia media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "UploadMaterialVo{" +
                "media=" + media +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
