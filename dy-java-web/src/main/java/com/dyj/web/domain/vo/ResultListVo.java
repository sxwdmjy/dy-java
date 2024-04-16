package com.dyj.web.domain.vo;


import java.util.List;

public class ResultListVo <T> extends BaseVo{

    private List<T> result_list;

    public List<T> getResult_list() {
        return result_list;
    }

    public ResultListVo<T> setResult_list(List<T> result_list) {
        this.result_list = result_list;
        return this;
    }
}
