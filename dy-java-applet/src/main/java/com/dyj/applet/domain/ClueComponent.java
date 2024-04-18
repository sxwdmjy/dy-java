package com.dyj.applet.domain;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-18 15:28
 **/
public class ClueComponent {

    /**
     * 线索组件id（线索组件的唯一标识）
     */
    private String config_id;

    /**
     * 线索组件的名称
     */
    private String config_name;

    /**
     * 创建线索组件时所填入的地区编码
     */
    private String region;

    /**
     * 创建线索组件时所填入的类目id
     */
    private String category_id;

    /**
     * 当前线索组件的状态（0-未激活 1-已激活 2-已失效）
     */
    private String state;
    /**
     * 类目id所对应的中文类目
     */
    private String category_name;
    /**
     * 地区编码对应的中文位置
     */
    private String region_name;
    /**
     * 地区列表
     */
    private List<ClueComponentRegin> region_list;


    public String getConfig_id() {
        return config_id;
    }

    public void setConfig_id(String config_id) {
        this.config_id = config_id;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public List<ClueComponentRegin> getRegion_list() {
        return region_list;
    }

    public void setRegion_list(List<ClueComponentRegin> region_list) {
        this.region_list = region_list;
    }
}
