package com.dyj.web.domain.query;

import com.dyj.web.domain.EventSubscribe;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-12 18:33
 **/
public class UpdateEventSubscribeQuery extends BaseQuery{

    private List<EventSubscribe> list;

    public List<EventSubscribe> getList() {
        return list;
    }

    public void setList(List<EventSubscribe> list) {
        this.list = list;
    }
}
