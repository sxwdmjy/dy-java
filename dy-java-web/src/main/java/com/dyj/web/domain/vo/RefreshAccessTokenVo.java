package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-03 11:25
 **/
public class RefreshAccessTokenVo  extends BaseVo{


    /**
     * access_token接口调用凭证超时时间，单位（秒)
     */
    private Integer expires_in;

    /**
     * 日志ID
     */
    private String log_id;

    /**
     * 授权用户唯一标识
     */
    private String open_id;

    /**
     * refresh_token凭证超时时间，单位（秒)
     */
    private Integer refresh_expires_in;
    /**
     * 用户刷新access_token
     */
    private String refresh_token;
    /**
     * 用户授权的作用域(Scope)，使用逗号（,）分隔，开放平台几乎每个接口都需要特定的Scope。
     */
    private String scope;


    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public Integer getRefresh_expires_in() {
        return refresh_expires_in;
    }

    public void setRefresh_expires_in(Integer refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "RefreshAccessTokenVo{" +
                "expires_in=" + expires_in +
                ", log_id='" + log_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", refresh_expires_in=" + refresh_expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", scope='" + scope + '\'' +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
