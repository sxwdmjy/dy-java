package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-10 15:05
 **/
public class IntentionLogQuery extends UserInfoQuery {

    /**
     * 本次查询获取数量最大值 100
     */
    private Integer count;

    /**
     * 开始时间戳
     */
    private Long start_time;

    /**
     * 结束时间戳
     */
    private Long end_time;

    /**
     * 事件名不传的时候默认获取全部事件
     */
    private String event;

    /**
     * 下次查询的 session 信息，首次查询时无需传入
     */
    private String query_session;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if(count > 100){
            count = 100;
        }
        this.count = count;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getQuery_session() {
        return query_session;
    }

    public void setQuery_session(String query_session) {
        this.query_session = query_session;
    }

    public static IntentionLogQueryBuilder builder() {
        return new IntentionLogQueryBuilder();
    }

    public static class IntentionLogQueryBuilder {
        private Integer count;
        private Long startTime;
        private Long endTime;
        private String event;
        private String querySession;
        private Integer tenantId;
        private String clientKey;
        private String openId;

        public IntentionLogQueryBuilder count(Integer count) {
            this.count = count;
            return this;
        }
        public IntentionLogQueryBuilder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }
        public IntentionLogQueryBuilder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }
        public IntentionLogQueryBuilder event(String event) {
            this.event = event;
            return this;
        }
        public IntentionLogQueryBuilder querySession(String querySession) {
            this.querySession = querySession;
            return this;
        }
        public IntentionLogQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public IntentionLogQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public IntentionLogQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public IntentionLogQuery build() {
            IntentionLogQuery intentionLogQuery = new IntentionLogQuery();
            intentionLogQuery.setCount(count);
            intentionLogQuery.setStart_time(startTime);
            intentionLogQuery.setEnd_time(endTime);
            intentionLogQuery.setEvent(event);
            intentionLogQuery.setQuery_session(querySession);
            intentionLogQuery.setTenantId(tenantId);
            intentionLogQuery.setClientKey(clientKey);
            intentionLogQuery.setOpen_id(openId);
            return intentionLogQuery;
        }
    }

    @Override
    public String toString() {
        return "IntentionLogQuery{" +
                "count=" + count +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", event='" + event + '\'' +
                ", query_session='" + query_session + '\'' +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
