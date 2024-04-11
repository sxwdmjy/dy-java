package com.dyj.web.domain;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-11 15:11
 **/
public class UploadMedia {

    /**
     * 素材id
     */
    private String media_id;
    /**
     * 素材链接数组
     */
    private List<String> url_list;
    /**
     * 审核状态（avaliable可使用,review审核中,reject审核不通过)
     */
    private String status;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public List<String> getUrl_list() {
        return url_list;
    }

    public void setUrl_list(List<String> url_list) {
        this.url_list = url_list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UploadMedia{" +
                "media_id='" + media_id + '\'' +
                ", url_list=" + url_list +
                ", status='" + status + '\'' +
                '}';
    }
}
