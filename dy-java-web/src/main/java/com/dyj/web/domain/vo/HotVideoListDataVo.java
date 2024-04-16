package com.dyj.web.domain.vo;

import com.dyj.web.domain.HotVideoListDataResult;

import java.util.List;

/**
 * 获取热点词聚合的视频返回值
 */
public class HotVideoListDataVo {

    /**
     * 错误码描述
     */
    private String description;
    /**
     * 错误码
     */
    private Long error_code;
    /**
     * 视频列表
     */
    private List<HotVideoListDataResult> list;

    public String getDescription() {
        return description;
    }

    public HotVideoListDataVo setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getError_code() {
        return error_code;
    }

    public HotVideoListDataVo setError_code(Long error_code) {
        this.error_code = error_code;
        return this;
    }

    public List<HotVideoListDataResult> getList() {
        return list;
    }

    public HotVideoListDataVo setList(List<HotVideoListDataResult> list) {
        this.list = list;
        return this;
    }
}
