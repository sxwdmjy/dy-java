package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.AptAccountVideo;
import com.dyj.common.domain.vo.BaseVo;

import java.util.List;

public class AptVideoListVo extends BaseVo {

    private Long cursor;

    private Boolean has_more;

    private List<AptAccountVideo> list;

    public Long getCursor() {
        return cursor;
    }

    public void setCursor(Long cursor) {
        this.cursor = cursor;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<AptAccountVideo> getList() {
        return list;
    }

    public void setList(List<AptAccountVideo> list) {
        this.list = list;
    }
}
