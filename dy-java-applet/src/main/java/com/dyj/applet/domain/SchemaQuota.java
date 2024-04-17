package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-17 14:01
 **/
public class SchemaQuota {

    /**
     * schema 生成次数上限
     */
    private Integer schema_limit;
    /**
     * schema 已生成次数
     */
    private Integer schema_used;

    public Integer getSchema_limit() {
        return schema_limit;
    }

    public void setSchema_limit(Integer schema_limit) {
        this.schema_limit = schema_limit;
    }

    public Integer getSchema_used() {
        return schema_used;
    }

    public void setSchema_used(Integer schema_used) {
        this.schema_used = schema_used;
    }
}
