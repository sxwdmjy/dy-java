package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-09 10:25
 **/
public class SetFansGroupEnterStatusQuery extends UserInfoQuery{

    /**
     * 入群申请id
     */
    private String apply_id;

    /**
     * 目标申请状态 2-通过 3-拒绝
     */
    private Integer status;


    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static SetFansGroupEnterStatusQueryBuilder builder() {
        return new SetFansGroupEnterStatusQueryBuilder();
    }

    public static class SetFansGroupEnterStatusQueryBuilder {
        private String applyId;
        private Integer status;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        public SetFansGroupEnterStatusQueryBuilder applyId(String applyId) {
            this.applyId = applyId;
            return this;
        }
        public SetFansGroupEnterStatusQueryBuilder status(Integer status) {
            this.status = status;
            return this;
        }
        public SetFansGroupEnterStatusQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public SetFansGroupEnterStatusQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public SetFansGroupEnterStatusQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public SetFansGroupEnterStatusQuery build() {
            SetFansGroupEnterStatusQuery query = new SetFansGroupEnterStatusQuery();
            query.setApply_id(applyId);
            query.setStatus(status);
            query.setOpen_id(openId);
            query.setTenantId(tenantId);
            query.setClientKey(clientKey);
            return query;
        }
    }


    @Override
    public String toString() {
        return "SetFansGroupEnterStatusQuery{" +
                "apply_id='" + apply_id + '\'' +
                ", status=" + status +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
