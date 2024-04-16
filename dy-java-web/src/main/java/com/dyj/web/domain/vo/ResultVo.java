package com.dyj.web.domain.vo;

public class ResultVo <T> extends BaseVo{

    private T result;

    public T getResult() {
        return result;
    }

    public ResultVo<T> setResult(T result) {
        this.result = result;
        return this;
    }
}
