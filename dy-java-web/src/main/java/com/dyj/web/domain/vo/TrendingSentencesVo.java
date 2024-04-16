package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.TrendingSentencesData;

import java.util.List;

/**
 * 获取上升词返回值
 */
public class TrendingSentencesVo extends BaseVo {

    /**
     * 用于下一页请求的cursor
     */
    private Long cursor;
    /**
     *
     */
    private Boolean has_more;
    /**
     *
     */
    private Integer total;
    /**
     * 实时热点词
     */
    private List<TrendingSentencesData> list;


    public Long getCursor() {
        return cursor;
    }

    public TrendingSentencesVo setCursor(Long cursor) {
        this.cursor = cursor;
        return this;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public TrendingSentencesVo setHas_more(Boolean has_more) {
        this.has_more = has_more;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public TrendingSentencesVo setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<TrendingSentencesData> getList() {
        return list;
    }

    public TrendingSentencesVo setList(List<TrendingSentencesData> list) {
        this.list = list;
        return this;
    }
}
