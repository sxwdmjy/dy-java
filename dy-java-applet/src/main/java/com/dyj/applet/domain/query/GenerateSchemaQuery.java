package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.BaseQuery;

/**
 * @author danmo
 * @date 2024-04-17 13:44
 **/
public class GenerateSchemaQuery extends BaseQuery {

    /**
     * 小程序ID
     */
    private String app_id;
    /**
     * 生成的 scheme 码类型，短期有效:false，长期有效:true。默认值false。
     */
    private Boolean no_expire;
    /**
     * 到期失效的 schema 的失效时间，为 Unix 时间戳，短期有效schema必传，最长间隔天数为180天。
     */
    private Long expire_time;

    /**
     * 通过 schema 进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带 query。
     * path 为空时会跳转小程序主页
     */
    private String path;
    /**
     * 通过 schema 进入小程序时的 query（json形式）。
     * 最大1024个字符，只支持数字，大小写英文以及部分特殊字符：`{}!#$&'()*+,/:;=?@-._~%``。
     */
    private String query;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Boolean getNo_expire() {
        return no_expire;
    }

    public void setNo_expire(Boolean no_expire) {
        this.no_expire = no_expire;
    }

    public Long getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Long expire_time) {
        this.expire_time = expire_time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public static GenerateSchemaBuilder builder() {
        return new GenerateSchemaBuilder();
    }

    public static class GenerateSchemaBuilder {
        private String appId;
        private Boolean noExpire;
        private Long expireTime;
        private String path;
        private String query;
        private Integer tenantId;
        private String clientKey;
        public GenerateSchemaBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public GenerateSchemaBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public GenerateSchemaBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }
        public GenerateSchemaBuilder noExpire(Boolean noExpire) {
            this.noExpire = noExpire;
            return this;
        }
        public GenerateSchemaBuilder expireTime(Long expireTime) {
            this.expireTime = expireTime;
            return this;
        }
        public GenerateSchemaBuilder path(String path) {
            this.path = path;
            return this;
        }
        public GenerateSchemaBuilder query(String query) {
            this.query = query;
            return this;
        }
        public GenerateSchemaQuery build() {
            GenerateSchemaQuery generateSchemaQuery = new GenerateSchemaQuery();
            generateSchemaQuery.setApp_id(appId);
            generateSchemaQuery.setNo_expire(noExpire);
            generateSchemaQuery.setExpire_time(expireTime);
            generateSchemaQuery.setPath(path);
            generateSchemaQuery.setQuery(query);
            generateSchemaQuery.setTenantId(tenantId);
            generateSchemaQuery.setClientKey(clientKey);
            return generateSchemaQuery;
        }
    }
}
