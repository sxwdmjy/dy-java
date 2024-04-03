package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-03 11:25
 **/
public class RefreshTokenVo {

    /**
     * 描述
     */
    private String description;
    /**
     * 错误码
     */
    private Integer error_code;

    /**
     * 接口调用凭证
     */
    private String refresh_token;
    /**
     * access_token接口调用凭证超时时间，单位（秒)
     */
    private Integer expires_in;

}
