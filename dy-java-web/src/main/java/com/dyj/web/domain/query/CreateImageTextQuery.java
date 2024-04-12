package com.dyj.web.domain.query;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-07 18:50
 **/
public class CreateImageTextQuery extends UserInfoQuery {

    /**
     * 通过/image/upload/接口得到
     */
    private List<String> image_list;

    /**
     * 视频标题。可以带话题，@用户。
     * 注意：话题审核依旧遵循抖音的审核逻辑，强烈建议第三方谨慎拟定话题名称，避免强导流行为。
     */
    private String text;

    /**
     * 如果需要at其他用户。将 text 中 @nickname 对应的 open_id 放到这里。
     */
    private List<String> at_users;

    /**
     * 小程序标题
     */
    private String micro_app_title;

    /**
     * 开发者在小程序中生成该页面时写的path地址
     */
    private String micro_app_url;

    /**
     * 小程序 ID
     */
    private String micro_app_id;

    /**
     * 地理位置 id，poi_id 可通过"查询 POI 信息"能力获取
     */
    private String poi_id;


    public List<String> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<String> image_list) {
        this.image_list = image_list;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAt_users() {
        return at_users;
    }

    public void setAt_users(List<String> at_users) {
        this.at_users = at_users;
    }

    public String getMicro_app_title() {
        return micro_app_title;
    }

    public void setMicro_app_title(String micro_app_title) {
        this.micro_app_title = micro_app_title;
    }

    public String getMicro_app_url() {
        return micro_app_url;
    }

    public void setMicro_app_url(String micro_app_url) {
        this.micro_app_url = micro_app_url;
    }

    public String getMicro_app_id() {
        return micro_app_id;
    }

    public void setMicro_app_id(String micro_app_id) {
        this.micro_app_id = micro_app_id;
    }

    public String getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(String poi_id) {
        this.poi_id = poi_id;
    }

    public static CreateImageTextQueryBuilder builder() {
        return new CreateImageTextQueryBuilder();
    }

    public static class CreateImageTextQueryBuilder {
        private String openId;
        private Integer tenantId;
        private String clientKey;
        private List<String> imageList;
        private String text;
        private List<String> atUsers;
        private String microAppTitle;
        private String microAppUrl;
        private String microAppId;
        private String poiId;
        public CreateImageTextQueryBuilder imageList(List<String> imageList) {
            this.imageList = imageList;
            return this;
        }
        public CreateImageTextQueryBuilder text(String text) {
            this.text = text;
            return this;
        }
        public CreateImageTextQueryBuilder atUsers(List<String> atUsers) {
            this.atUsers = atUsers;
            return this;
        }
        public CreateImageTextQueryBuilder microAppTitle(String microAppTitle) {
            this.microAppTitle = microAppTitle;
            return this;
        }
        public CreateImageTextQueryBuilder microAppUrl(String microAppUrl) {
            this.microAppUrl = microAppUrl;
            return this;
        }
        public CreateImageTextQueryBuilder microAppId(String microAppId) {
            this.microAppId = microAppId;
            return this;
        }
        public CreateImageTextQueryBuilder poiId(String poiId) {
            this.poiId = poiId;
            return this;
        }

        public CreateImageTextQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public CreateImageTextQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CreateImageTextQuery build() {
            CreateImageTextQuery createImageTextQuery = new CreateImageTextQuery();
            createImageTextQuery.setImage_list(imageList);
            createImageTextQuery.setText(text);
            createImageTextQuery.setAt_users(atUsers);
            createImageTextQuery.setMicro_app_title(microAppTitle);
            createImageTextQuery.setMicro_app_url(microAppUrl);
            createImageTextQuery.setMicro_app_id(microAppId);
            createImageTextQuery.setPoi_id(poiId);
            createImageTextQuery.setTenantId(tenantId);
            createImageTextQuery.setClientKey(clientKey);
            createImageTextQuery.setOpen_id(openId);
            return createImageTextQuery;
        }
    }
}
