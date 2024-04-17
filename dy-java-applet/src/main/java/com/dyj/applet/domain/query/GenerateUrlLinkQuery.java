package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.BaseQuery;

/**
 * @author danmo
 * @date 2024-04-17 13:44
 **/
public class GenerateUrlLinkQuery extends BaseQuery {

    /**
     * 小程序ID
     */
    private String app_id;
    /**
     * 宿主名称，可选 douyin，douyinlite
     */
    private String app_name;

    /**
     * 到期失效的URL Link的失效时间。为 Unix 时间戳，实际失效时间为距离当前时间小时数，向上取整。最长间隔天数为180天。
     */
    private Long expire_time;

    /**
     * 通过URL Link进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带 query。path 为空时会跳转小程序主页
     */
    private String path;
    /**
     * 通过URL Link进入小程序时的 query（json形式），若无请填{}。
     * 最大1024个字符，只支持数字，大小写英文以及部分特殊字符：`{}!#$&'()*+,/:;=?@-._~%``。
     */
    private String query;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
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
        private String appName;
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

        public GenerateSchemaBuilder appName(String appName) {
            this.appName = appName;
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
        public GenerateUrlLinkQuery build() {
            GenerateUrlLinkQuery generateUrlLinkQuery = new GenerateUrlLinkQuery();
            generateUrlLinkQuery.setApp_id(appId);
            generateUrlLinkQuery.setApp_name(appName);
            generateUrlLinkQuery.setExpire_time(expireTime);
            generateUrlLinkQuery.setPath(path);
            generateUrlLinkQuery.setQuery(query);
            generateUrlLinkQuery.setTenantId(tenantId);
            generateUrlLinkQuery.setClientKey(clientKey);
            return generateUrlLinkQuery;
        }
    }
}
