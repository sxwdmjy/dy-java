package com.dyj.web.domain.vo;

import com.dyj.web.domain.IntentionLog;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-10 15:11
 **/
public class IntentionLogVo extends BaseVo {

    /**
     * 是否有后续数据
     */
    private Boolean has_more;

    private List<IntentionLog> intention_log_infos;

    /**
     * 下次查询需要传入的 session 信息
     */
    private String query_session;

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<IntentionLog> getIntention_log_infos() {
        return intention_log_infos;
    }

    public void setIntention_log_infos(List<IntentionLog> intention_log_infos) {
        this.intention_log_infos = intention_log_infos;
    }

    public String getQuery_session() {
        return query_session;
    }

    public void setQuery_session(String query_session) {
        this.query_session = query_session;
    }

    @Override
    public String toString() {
        return "IntentionLogVo{" +
                "has_more=" + has_more +
                ", intention_log_infos=" + intention_log_infos +
                ", query_session='" + query_session + '\'' +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
