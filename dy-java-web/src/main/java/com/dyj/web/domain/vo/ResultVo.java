package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;

public class ResultVo <T> extends BaseVo {

    private T result;

    public T getResult() {
        return result;
    }

    public ResultVo<T> setResult(T result) {
        this.result = result;
        return this;
    }
}
