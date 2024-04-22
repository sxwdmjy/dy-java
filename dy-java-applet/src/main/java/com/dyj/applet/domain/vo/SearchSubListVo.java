package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.SearchSubServiceInfo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-22 18:54
 **/
public class SearchSubListVo {

    private Boolean has_more;

    private Long total;

    private List<SearchSubServiceInfo> ma_sub_service_info_list;


    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<SearchSubServiceInfo> getMa_sub_service_info_list() {
        return ma_sub_service_info_list;
    }

    public void setMa_sub_service_info_list(List<SearchSubServiceInfo> ma_sub_service_info_list) {
        this.ma_sub_service_info_list = ma_sub_service_info_list;
    }
}
