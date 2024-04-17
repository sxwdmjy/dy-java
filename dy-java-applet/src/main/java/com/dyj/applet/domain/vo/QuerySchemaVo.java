package com.dyj.applet.domain.vo;

/**
 * @author danmo
 * @date 2024-04-17 13:56
 **/
public class QuerySchemaVo {

    private String app_id;
    /**
     * 创建时间，为 Unix 时间戳
     */
    private Long create_time;
    /**
     * 到期失效时间，为 Unix 时间戳
     */
    private Long expire_time;
    /**
     * 小程序页面地址
     */
    private String path;
    /**
     * 小程序页面参数
     */
    private String query;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
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
}
