package com.dyj.web.domain.query;

import java.util.List;

public class CreateVideoQuery extends UserInfoQuery{

    /**
     * 必须上传加密的 video_id。加密的 video_id 通过调用 /video/upload 接口可以得到。
     */
    private String video_id;

    /**
     * 视频标题。可以带话题，@用户。注意：话题审核依旧遵循抖音的审核逻辑，强烈建议第三方谨慎拟定话题名称，避免强导流行为。
     */
    private String text;

    /**
     * 如果需要 at 其他用户。将 text 中 @nickname 对应的 open_id 放到这里。
     */
    private List<String> at_users;

    /**
     * 小程序标题
     */
    private String micro_app_title;

    /**
     * 开发者在小程序中生成该页面时写的 path 地址
     */
    private String micro_app_url;
    /**
     * 小程序 id
     */
    private String micro_app_id;
    /**
     * 地理位置 id，poi_id 可通过"查询视频携带的地点信息"能力获取
     */
    private String poi_id;

    /**
     * 将传入的指定时间点对应帧设置为视频封面（单位：秒）
     */
    private Double cover_tsp;

    /**
     * 为 true 时，如果用户拥有门店推广能力，则用户发布视频所添加的地理位置默认开启门店推广
     */
    private Boolean poi_commerce;

    /**
     * 自定义封面图片，参数为图片上传接口返回的 image_id
     */
    private String custom_cover_image_url;

    /**
     * 影视ID
     */
    private String ent_id;


    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
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

    public Double getCover_tsp() {
        return cover_tsp;
    }

    public void setCover_tsp(Double cover_tsp) {
        this.cover_tsp = cover_tsp;
    }

    public Boolean getPoi_commerce() {
        return poi_commerce;
    }

    public void setPoi_commerce(Boolean poi_commerce) {
        this.poi_commerce = poi_commerce;
    }

    public String getCustom_cover_image_url() {
        return custom_cover_image_url;
    }

    public void setCustom_cover_image_url(String custom_cover_image_url) {
        this.custom_cover_image_url = custom_cover_image_url;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public static CreateVideoQueryBuilder builder() {
        return new CreateVideoQueryBuilder();
    }
    public static class CreateVideoQueryBuilder {
        private String videoId;
        private String text;
        private List<String> atUsers;
        private String microAppTitle;
        private String microAppUrl;

        private String microAppId;
        private String poiId;
        private Double coverTsp;
        private Boolean poiCommerce;
        private String customCoverImageUrl;
        private String entId;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        public CreateVideoQueryBuilder videoId(String videoId) {
            this.videoId = videoId;
            return this;
        }
        public CreateVideoQueryBuilder text(String text) {
            this.text = text;
            return this;
        }
        public CreateVideoQueryBuilder atUsers(List<String> atUsers) {
            this.atUsers = atUsers;
            return this;
        }
        public CreateVideoQueryBuilder microAppTitle(String microAppTitle) {
            this.microAppTitle = microAppTitle;
            return this;
        }
        public CreateVideoQueryBuilder microAppUrl(String microAppUrl) {
            this.microAppUrl = microAppUrl;
            return this;
        }
        public CreateVideoQueryBuilder microAppId(String microAppId) {
            this.microAppId = microAppId;
            return this;
        }
        public CreateVideoQueryBuilder poiId(String poiId) {
            this.poiId = poiId;
            return this;
        }
        public CreateVideoQueryBuilder coverTsp(Double coverTsp) {
            this.coverTsp = coverTsp;
            return this;
        }
        public CreateVideoQueryBuilder poiCommerce(Boolean poiCommerce) {
            this.poiCommerce = poiCommerce;
            return this;
        }
        public CreateVideoQueryBuilder customCoverImageUrl(String customCoverImageUrl) {
            this.customCoverImageUrl = customCoverImageUrl;
            return this;
        }
        public CreateVideoQueryBuilder entId(String entId) {
            this.entId = entId;
            return this;
        }
        public CreateVideoQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public CreateVideoQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public CreateVideoQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CreateVideoQuery build() {
            CreateVideoQuery createVideoQuery = new CreateVideoQuery();
            createVideoQuery.setVideo_id(videoId);
            createVideoQuery.setText(text);
            createVideoQuery.setAt_users(atUsers);
            createVideoQuery.setMicro_app_title(microAppTitle);
            createVideoQuery.setMicro_app_url(microAppUrl);
            createVideoQuery.setMicro_app_id(microAppId);
            createVideoQuery.setPoi_id(poiId);
            createVideoQuery.setCover_tsp(coverTsp);
            createVideoQuery.setPoi_commerce(poiCommerce);
            createVideoQuery.setCustom_cover_image_url(customCoverImageUrl);
            createVideoQuery.setEnt_id(entId);
            createVideoQuery.setOpen_id(openId);
            createVideoQuery.setTenantId(tenantId);
            createVideoQuery.setClientKey(clientKey);
            return createVideoQuery;
        }
    }

    @Override
    public String toString() {
        return "CreateVideoQuery{" +
                "video_id='" + video_id + '\'' +
                ", text='" + text + '\'' +
                ", at_users=" + at_users +
                ", micro_app_title='" + micro_app_title + '\'' +
                ", micro_app_url='" + micro_app_url + '\'' +
                ", micro_app_id='" + micro_app_id + '\'' +
                ", poi_id='" + poi_id + '\'' +
                ", cover_tsp=" + cover_tsp +
                ", poi_commerce=" + poi_commerce +
                ", custom_cover_image_url='" + custom_cover_image_url + '\'' +
                ", ent_id='" + ent_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
