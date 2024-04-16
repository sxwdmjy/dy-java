package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.HotSentencesData;

import java.util.List;

/**
 * 获取实时热点词返回值
 */
public class HotSentencesDataVo extends BaseVo {

    /**
     * 刷新时间
     */
    private String active_time;

    /**
     * 实时热点词
     */
    private List<HotSentencesData> list;

    public String getActive_time() {
        return active_time;
    }

    public HotSentencesDataVo setActive_time(String active_time) {
        this.active_time = active_time;
        return this;
    }

    public List<HotSentencesData> getList() {
        return list;
    }

    public HotSentencesDataVo setList(List<HotSentencesData> list) {
        this.list = list;
        return this;
    }
}
