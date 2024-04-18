package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.ClueComponent;

/**
 * @author danmo
 * @date 2024-04-18 15:27
 **/
public class ClueComponentVo {

    /**
     * 线索组件列表
     */
    private ClueComponent clue_component_list;

    /**
     * 当前app_id是否有创建线索组件的权限，未开通线索组件能力返回false
     */
    private Boolean cert_status;

    /**
     * 线索组件总数
     */
    private Long total;

    public ClueComponent getClue_component_list() {
        return clue_component_list;
    }

    public void setClue_component_list(ClueComponent clue_component_list) {
        this.clue_component_list = clue_component_list;
    }

    public Boolean getCert_status() {
        return cert_status;
    }

    public void setCert_status(Boolean cert_status) {
        this.cert_status = cert_status;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
