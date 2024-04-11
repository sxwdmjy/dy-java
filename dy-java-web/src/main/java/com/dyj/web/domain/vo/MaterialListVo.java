package com.dyj.web.domain.vo;

import com.dyj.web.domain.UploadMedia;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-11 15:17
 **/
public class MaterialListVo extends BaseVo {

    /**
     * 用于下一页请求的cursor
     */
    private Integer cursor;

    /**
     * 是否还有更多数据
     */
    private Boolean has_more;

    private List<UploadMedia> medias;

    public Integer getCursor() {
        return cursor;
    }

    public void setCursor(Integer cursor) {
        this.cursor = cursor;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<UploadMedia> getMedias() {
        return medias;
    }

    public void setMedias(List<UploadMedia> medias) {
        this.medias = medias;
    }

    @Override
    public String toString() {
        return "MaterialListVo{" +
                "cursor=" + cursor +
                ", has_more=" + has_more +
                ", medias=" + medias +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
