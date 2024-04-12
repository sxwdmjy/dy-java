package com.dyj.web.domain.query;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 16:51
 **/
public class SaveRetainConsultCardQuery extends UserInfoQuery {

    /**
     * 留资卡片ID，修改卡片时需要填写
     */
    private String card_id;

    /**
     * 1：姓名
     * 2：手机号
     * 3：城市
     */
    private List<Integer> components;

    /**
     * 图片的 ID。
     * 通过图片上传接口获取
     * 图片尺寸建议：宽263高120
     * 尺寸不一样会自动适配短边占满
     */
    private String media_id;

    /**
     * 卡片标题
     */
    private String title;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public List<Integer> getComponents() {
        return components;
    }

    public void setComponents(List<Integer> components) {
        this.components = components;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static SaveRetainConsultCardQueryBuilder builder() {
        return new SaveRetainConsultCardQueryBuilder();
    }

    public static class SaveRetainConsultCardQueryBuilder {
        private String cardId;
        private List<Integer> components;
        private String mediaId;
        private String title;
        private String openId;
        private Integer tenantId;
        private String clientKey;
        public SaveRetainConsultCardQueryBuilder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }
        public SaveRetainConsultCardQueryBuilder components(List<Integer> components) {
            this.components = components;
            return this;
        }
        public SaveRetainConsultCardQueryBuilder mediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }
        public SaveRetainConsultCardQueryBuilder title(String title) {
            this.title = title;
            return this;
        }
        public SaveRetainConsultCardQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public SaveRetainConsultCardQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public SaveRetainConsultCardQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public SaveRetainConsultCardQuery build() {
            SaveRetainConsultCardQuery saveRetainConsultCardQuery = new SaveRetainConsultCardQuery();
            saveRetainConsultCardQuery.setCard_id(cardId);
            saveRetainConsultCardQuery.setComponents(components);
            saveRetainConsultCardQuery.setMedia_id(mediaId);
            saveRetainConsultCardQuery.setTitle(title);
            saveRetainConsultCardQuery.setCard_id(openId);
            saveRetainConsultCardQuery.setTenantId(tenantId);
            saveRetainConsultCardQuery.setClientKey(clientKey);
            return saveRetainConsultCardQuery;
        }

    }


}
