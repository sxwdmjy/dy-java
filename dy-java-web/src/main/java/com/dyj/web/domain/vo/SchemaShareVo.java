package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-11 11:41
 **/
public class SchemaShareVo {

    /**
     * 	Schema链接
     */
    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "SchemaShareVo{" +
                "schema='" + schema + '\'' +
                '}';
    }
}
