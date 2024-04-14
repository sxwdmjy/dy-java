package com.dyj.web.event;

import java.util.List;

/**
 * 抖音用户解除授权，推送事件给开发者APP
 */
public class UnAuthorizeEvent {

    /**
     * 授权scope列表
     */
    private List<String> scopes;

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }
}
