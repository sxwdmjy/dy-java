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

    public CreateImageTextQuery image_list(List<String> image_list) {
        this.image_list = image_list;
        return this;
    }

    public CreateImageTextQuery text(String text) {
        this.text = text;
        return this;
    }

    public CreateImageTextQuery at_users(List<String> at_users) {
        this.at_users = at_users;
        return this;
    }

    public CreateImageTextQuery micro_app_title(String micro_app_title) {
        this.micro_app_title = micro_app_title;
        return this;
    }

    public CreateImageTextQuery micro_app_url(String micro_app_url) {
        this.micro_app_url = micro_app_url;
        return this;
    }

    public CreateImageTextQuery micro_app_id(String micro_app_id) {
        this.micro_app_id = micro_app_id;
        return this;
    }

    public CreateImageTextQuery poi_id(String poi_id) {
        this.poi_id = poi_id;
        return this;
    }

    public CreateImageTextQuery open_id(String open_id) {
        super.open_id = open_id;
        return this;
    }

    public CreateImageTextQuery tenantId(Integer tenantId) {
        super.tenantId = tenantId;
        return this;
    }

    public CreateImageTextQuery clientKey(String clientKey) {
        super.clientKey = clientKey;
        return this;
    }

    public static CreateImageTextQuery build() {
        return new CreateImageTextQuery();
    }

    @Override
    public String toString() {
        return "CreateImageTextQuery{" +
                "image_list=" + image_list +
                ", text='" + text + '\'' +
                ", at_users=" + at_users +
                ", micro_app_title='" + micro_app_title + '\'' +
                ", micro_app_url='" + micro_app_url + '\'' +
                ", micro_app_id='" + micro_app_id + '\'' +
                ", poi_id='" + poi_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
