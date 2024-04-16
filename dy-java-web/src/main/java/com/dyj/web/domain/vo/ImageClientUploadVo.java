package com.dyj.web.domain.vo;

import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-10 11:20
 **/
public class ImageClientUploadVo extends DyResult<BaseVo> {

    private String image_id;

    private Integer width;

    private Integer height;

    private String md5;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

}
