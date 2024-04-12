package com.dyj.web.domain.vo;

import com.dyj.web.domain.VideoLocation;

import java.util.List;

public class QueryVideoLocationVo extends BaseVo {

    private Integer cursor;

    private Boolean has_more;

    private List<VideoLocation> list;

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

    public List<VideoLocation> getList() {
        return list;
    }

    public void setList(List<VideoLocation> list) {
        this.list = list;
    }


}
