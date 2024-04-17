package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.SchemaQuota;

/**
 * @author danmo
 * @date 2024-04-17 14:00
 **/
public class QuerySchemaQuotaVo {

    /**
     * 长期有效 schema quota 配置
     */
    private SchemaQuota long_term_schema_quota;

    /**
     * 短期有效 schema quota 配置
     */
    private SchemaQuota short_term_schema_quota;

    public SchemaQuota getLong_term_schema_quota() {
        return long_term_schema_quota;
    }

    public void setLong_term_schema_quota(SchemaQuota long_term_schema_quota) {
        this.long_term_schema_quota = long_term_schema_quota;
    }

    public SchemaQuota getShort_term_schema_quota() {
        return short_term_schema_quota;
    }

    public void setShort_term_schema_quota(SchemaQuota short_term_schema_quota) {
        this.short_term_schema_quota = short_term_schema_quota;
    }
}
