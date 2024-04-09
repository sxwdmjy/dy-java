package com.dyj.web.domain.vo;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 11:21
 **/
public class FansGroupEnterStatusApplyVo {

    private Integer cursor;

    private Boolean has_more;

    private List<StatusApply> list;

    public static class StatusApply {
        /**
         * 入群申请id
         */
        private String apply_id;
        /**
         * 入群申请状态 1-申请中
         */
        private Integer apply_status;
        /**
         * 创建时间戳，单位为秒
         */
        private Long create_time;
        /**
         * 群id
         */
        private String group_id;
        /**
         * 申请入群用户open_id
         */
        private String user_id;

        public String getApply_id() {
            return apply_id;
        }

        public void setApply_id(String apply_id) {
            this.apply_id = apply_id;
        }

        public Integer getApply_status() {
            return apply_status;
        }

        public void setApply_status(Integer apply_status) {
            this.apply_status = apply_status;
        }

        public Long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Long create_time) {
            this.create_time = create_time;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

    public Integer getCursor() {
        return cursor;
    }

    public void setCursor(Integer cursor) {
        this.cursor = cursor;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<StatusApply> getList() {
        return list;
    }

    public void setList(List<StatusApply> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
