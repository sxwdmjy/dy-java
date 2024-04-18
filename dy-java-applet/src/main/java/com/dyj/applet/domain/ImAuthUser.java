package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-08 17:20
 **/
public class ImAuthUser {

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
     * C 端用户授权来源小程序
     */
    private String auth_user_source_app_id;

    /**
     * 开发者在主动私信授权组件中自定义参数
     */
    private String data_im_extra;

    /**
     * 用户在获取用户私信授权组件授权服务账号所在小程序当前页面的path参数
     */
    private String path;

    /**
     * 用户在获取用户私信授权组件中授权服务账号所在小程序当前页面的query参数
     */
    private String query;

    /**
     * 使用调用应用加密的 open_id
     */
    private String target_open_id;

    /**
     * 授权归因，不同的授权来源对应不同的归因字段
     */
    private AuthAttribution attribution;

    public String getEnter_from() {
        return enter_from;
    }

    public void setEnter_from(String enter_from) {
        this.enter_from = enter_from;
    }

    public String getAuth_user_source_app_id() {
        return auth_user_source_app_id;
    }

    public void setAuth_user_source_app_id(String auth_user_source_app_id) {
        this.auth_user_source_app_id = auth_user_source_app_id;
    }

    public String getData_im_extra() {
        return data_im_extra;
    }

    public void setData_im_extra(String data_im_extra) {
        this.data_im_extra = data_im_extra;
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

    public String getTarget_open_id() {
        return target_open_id;
    }

    public void setTarget_open_id(String target_open_id) {
        this.target_open_id = target_open_id;
    }

    public AuthAttribution getAttribution() {
        return attribution;
    }

    public void setAttribution(AuthAttribution attribution) {
        this.attribution = attribution;
    }
}
