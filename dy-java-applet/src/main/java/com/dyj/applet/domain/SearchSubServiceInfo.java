package com.dyj.applet.domain;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-22 18:55
 **/
public class SearchSubServiceInfo {

    /**
     * 审核状态
     */
    private Long approval_state;

    /**
     * 创建时间-秒级
     */
    private String create_time;
    /**
     * 小程序图标url
     */
    private String micro_app_icon;
    /**
     * 小程序id
     */
    private String micro_app_id;
    /**
     * 创建搜索直达服务时创建的关键词
     */
    private List<String> search_key_word;
    /**
     * 跳转链接
     */
    private String  start_page_url;
    /**
     * 搜索直达服务id
     */
    private String  sub_service_id;
    /**
     * 搜索直达服务名称
     */
    private String  sub_service_name;

    /**
     * 理由
     */
    private List<SearchSubServiceReason> reasons;

    public Long getApproval_state() {
        return approval_state;
    }

    public void setApproval_state(Long approval_state) {
        this.approval_state = approval_state;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getMicro_app_icon() {
        return micro_app_icon;
    }

    public void setMicro_app_icon(String micro_app_icon) {
        this.micro_app_icon = micro_app_icon;
    }

    public String getMicro_app_id() {
        return micro_app_id;
    }

    public void setMicro_app_id(String micro_app_id) {
        this.micro_app_id = micro_app_id;
    }

    public List<String> getSearch_key_word() {
        return search_key_word;
    }

    public void setSearch_key_word(List<String> search_key_word) {
        this.search_key_word = search_key_word;
    }

    public String getStart_page_url() {
        return start_page_url;
    }

    public void setStart_page_url(String start_page_url) {
        this.start_page_url = start_page_url;
    }

    public String getSub_service_id() {
        return sub_service_id;
    }

    public void setSub_service_id(String sub_service_id) {
        this.sub_service_id = sub_service_id;
    }

    public String getSub_service_name() {
        return sub_service_name;
    }

    public void setSub_service_name(String sub_service_name) {
        this.sub_service_name = sub_service_name;
    }

    public List<SearchSubServiceReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<SearchSubServiceReason> reasons) {
        this.reasons = reasons;
    }
}
