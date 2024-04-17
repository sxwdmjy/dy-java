package com.dyj.common.domain.vo;

import com.dyj.common.domain.DyExtra;

public class DataAndExtraBodyVo <T>{
    private T data;

    private DyExtra extra_body;

    public T getData() {
        return data;
    }

    public DataAndExtraBodyVo<T> setData(T data) {
        this.data = data;
        return this;
    }

    public DyExtra getExtra_body() {
        return extra_body;
    }

    public DataAndExtraBodyVo<T> setExtra_body(DyExtra extra_body) {
        this.extra_body = extra_body;
        return this;
    }
}
