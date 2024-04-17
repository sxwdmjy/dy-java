package com.dyj.common.domain.query;

/**
 * @author danmo
 * @date 2024-04-17 13:54
 **/
public class QuerySchemaQuery extends BaseQuery{

    private String app_id;

    /**
     * 生成的schema
     */
    private String schema;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public static QuerySchemaQueryBuilder builder(){
        return new QuerySchemaQueryBuilder();
    }

    public static class QuerySchemaQueryBuilder{
        private String appId;
        private String schema;
        private Integer tenantId;
        private String clientKey;

        public QuerySchemaQueryBuilder appId(String appId){
            this.appId = appId;
            return this;
        }

        public QuerySchemaQueryBuilder schema(String schema){
            this.schema = schema;
            return this;
        }

        public QuerySchemaQueryBuilder tenantId(Integer tenantId){
            this.tenantId = tenantId;
            return this;
        }

        public QuerySchemaQueryBuilder clientKey(String clientKey){
            this.clientKey = clientKey;
            return this;
        }

        public QuerySchemaQuery build(){
            QuerySchemaQuery querySchemaQuery = new QuerySchemaQuery();
            querySchemaQuery.setApp_id(appId);
            querySchemaQuery.setSchema(schema);
            querySchemaQuery.setTenantId(tenantId);
            querySchemaQuery.setClientKey(clientKey);
            return querySchemaQuery;
        }
    }
}
