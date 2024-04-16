package com.dyj.web.event;

import java.util.List;

/**
 * 用户给应用经营关系（scope名为xxx.bind，或私信相关能力）授权
 */
public class ContractAuthorizeEvent {

    /**
     * 经营Scope
     */
    private List<String> scopes;

    /**
     * 事件时间戳
     */
    private Long timestamp;

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
