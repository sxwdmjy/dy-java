package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-22 18:57
 **/
public class SearchSubServiceReason {

    /**
     * 审核拒绝标签
     */
    private String audit_field;

    /**
     * 审核拒绝原因
     */
    private String reason;

    public String getAudit_field() {
        return audit_field;
    }

    public void setAudit_field(String audit_field) {
        this.audit_field = audit_field;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
