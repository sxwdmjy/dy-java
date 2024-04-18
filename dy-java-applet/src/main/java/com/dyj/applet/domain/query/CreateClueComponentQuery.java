package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.BaseQuery;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-18 15:16
 **/
public class CreateClueComponentQuery extends BaseQuery {

    /**
     * 要创建的线索组件的名称（配置名称长度不能大于20）
     */
    private String config_name;

    /**
     * 地区编号，必须精确到区/县，地区编号为国家政务公示网上所显示的编号
     * region和region_list必填一个
     */
    private String region;

    /**
     * 地区编号列表，必须精确到区/县，地区编号为国家政务公示网上所显示的编号
     * region和region_list必填一个
     */
    private List<String> region_list;

    /**
     * 小程序的服务类目id，格式为"xx,xx,xx"，需要传小程序已审核通过的服务类目id，获取小程序已设置的服务类目见获取服务类目
     */
    private String category_id;


    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getRegion_list() {
        return region_list;
    }

    public void setRegion_list(List<String> region_list) {
        this.region_list = region_list;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public static CreateClueComponentQueryBuilder builder() {
        return new CreateClueComponentQueryBuilder();
    }

    public static class CreateClueComponentQueryBuilder {
        private String configName;
        private String region;
        private List<String> regionList;
        private String categoryId;
        private Integer tenantId;
        private String clientKey;
        public CreateClueComponentQueryBuilder configName(String configName) {
            this.configName = configName;
            return this;
        }
        public CreateClueComponentQueryBuilder region(String region) {
            this.region = region;
            return this;
        }
        public CreateClueComponentQueryBuilder regionList(List<String> regionList) {
            this.regionList = regionList;
            return this;
        }
        public CreateClueComponentQueryBuilder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }
        public CreateClueComponentQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public CreateClueComponentQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public CreateClueComponentQuery build() {
            CreateClueComponentQuery createClueComponentQuery = new CreateClueComponentQuery();
            createClueComponentQuery.setConfig_name(configName);
            createClueComponentQuery.setRegion(region);
            createClueComponentQuery.setRegion_list(regionList);
            createClueComponentQuery.setCategory_id(categoryId);
            createClueComponentQuery.setTenantId(tenantId);
            createClueComponentQuery.setClientKey(clientKey);
            return createClueComponentQuery;
        }
    }
}
