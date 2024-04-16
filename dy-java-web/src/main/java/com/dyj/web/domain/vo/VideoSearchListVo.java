package com.dyj.web.domain.vo;

import com.dyj.web.domain.VideoSearchResult;

import java.util.List;

public class VideoSearchListVo extends BaseVo {

    /**
     * 用于下一页请求的cursor
     */
    private Long cursor;


    private Boolean has_more;


    private List<VideoSearchResult> list;


    public List<VideoSearchResult> getList() {
        return list;
    }

    public VideoSearchListVo setList(List<VideoSearchResult> list) {
        this.list = list;
        return this;
    }

    public Long getCursor() {
        return cursor;
    }

    public VideoSearchListVo setCursor(Long cursor) {
        this.cursor = cursor;
        return this;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public VideoSearchListVo setHas_more(Boolean has_more) {
        this.has_more = has_more;
        return this;
    }

}
