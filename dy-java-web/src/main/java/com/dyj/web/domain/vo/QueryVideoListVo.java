package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.AccountVideo;

import java.util.List;

public class QueryVideoListVo extends BaseVo {

    private Long cursor;

    private Boolean has_more;

    private List<AccountVideo> list;

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

    public List<AccountVideo> getList() {
        return list;
    }

    public void setList(List<AccountVideo> list) {
        this.list = list;
    }
}
