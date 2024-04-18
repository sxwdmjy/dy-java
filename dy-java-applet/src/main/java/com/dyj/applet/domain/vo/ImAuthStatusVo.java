package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.AuthAttribution;

/**
 * @author danmo
 * @date 2024-04-18 13:39
 **/
public class ImAuthStatusVo {

    /**
     * 授权状态
     * 1 授权中
     * 2 未授权
     */
    private Integer status;

    /**
     * 授权归因，不同的授权来源对应不同的归因字段
     */
    private AuthAttribution attribution;

    /**
     * 在小程序跳转私信组件中开发者自定义参数
     */
    private String data_im_extra;

    /**
     * 授权来源
     * micro_app 小程序
     * button组件
     * im_card 服务私信授权卡片
     * action_bar 会话页快捷入口
     * live_shelf_panel 直播间货架入口
     * micro_app_pendant 小程序内免研悬浮组件
     * mp_follow_account 小程序内关注后拉起主动私信授权
     */
    private String enter_from;

    /**
     * 用户点击获取用户私信授权组件时所在小程序当前页面的path参数
     */
    private String path;

    /**
     * 用户点击获取用户私信授权组件时所在小程序当前页面的query参数
     */
    private String query;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AuthAttribution getAttribution() {
        return attribution;
    }

    public void setAttribution(AuthAttribution attribution) {
        this.attribution = attribution;
    }

    public String getData_im_extra() {
        return data_im_extra;
    }

    public void setData_im_extra(String data_im_extra) {
        this.data_im_extra = data_im_extra;
    }

    public String getEnter_from() {
        return enter_from;
    }

    public void setEnter_from(String enter_from) {
        this.enter_from = enter_from;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
