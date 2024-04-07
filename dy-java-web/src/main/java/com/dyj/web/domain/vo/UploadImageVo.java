package com.dyj.web.domain.vo;

import com.dyj.web.domain.UploadImage;

public class UploadImageVo extends BaseVo{

    private UploadImage image;

    public UploadImage getImage() {
        return image;
    }

    public void setImage(UploadImage image) {
        this.image = image;
    }

    @Override
    public String
    toString() {
        return "UploadImageVo{" +
                "image=" + image +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
