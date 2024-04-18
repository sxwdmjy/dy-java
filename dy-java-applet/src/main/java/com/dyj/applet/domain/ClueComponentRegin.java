package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-18 15:30
 **/
public class ClueComponentRegin {

    /**
     * 当前填写的编码
     */
    private String region;
    /**
     * 省份编码
     */
    private String province_code;
    /**
     * 省份名称
     */
    private String province_name;
    /**
     * 城市编码
     */
    private String city_code;
    /**
     * 城市名称
     */
    private String city_name;
    /**
     * 地区编码
     */
    private String district_code;

    /**
     * 地区名称
     */
    private String district_name;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }
}
