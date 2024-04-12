package com.dyj.web.domain.vo;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author danmo
 * @date 2024-04-07 16:55
 **/
public class UserRoleCheckVo extends BaseVo {

    /**
     * 匹配状态
     */
    private Boolean match_result;

    /**
     * 返回查询集合中，没有身份的信息
     */
    private JSONObject filter_role;

    private String log_id;

    private Integer err_no;

    private String err_msg;

    public Boolean getMatch_result() {
        return match_result;
    }

    public void setMatch_result(Boolean match_result) {
        this.match_result = match_result;
    }

    public JSONObject getFilter_role() {
        return filter_role;
    }

    public void setFilter_role(JSONObject filter_role) {
        this.filter_role = filter_role;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public Integer getErr_no() {
        return err_no;
    }

    public void setErr_no(Integer err_no) {
        this.err_no = err_no;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }


}
