package com.dyj.web.domain.vo;

import java.util.List;

public class ListVo<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public ListVo<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
}
