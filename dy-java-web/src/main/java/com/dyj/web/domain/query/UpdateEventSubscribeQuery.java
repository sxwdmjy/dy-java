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

    public static UpdateEventSubscribeQueryBuild builder() {
        return new UpdateEventSubscribeQueryBuild();
    }

    public static class UpdateEventSubscribeQueryBuild {
        private List<EventSubscribe> list;

        public UpdateEventSubscribeQueryBuild list(List<EventSubscribe> list) {
            this.list = list;
            return this;
        }

        public UpdateEventSubscribeQuery build() {
            UpdateEventSubscribeQuery updateEventSubscribeQuery = new UpdateEventSubscribeQuery();
            updateEventSubscribeQuery.setList(list);
            return updateEventSubscribeQuery;
        }
    }
}
