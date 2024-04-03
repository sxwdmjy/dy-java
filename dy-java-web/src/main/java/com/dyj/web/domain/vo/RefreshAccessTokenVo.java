package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-03 11:25
 **/
public class RefreshAccessTokenVo {

    /**
     * 描述
     */
    private String description;
    /**
     * 错误码
     */
    private Integer error_code;

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

}
