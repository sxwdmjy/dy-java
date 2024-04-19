package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.BaseQuery;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-19 14:33
 **/
public class ItemId2EncryptIdQuery extends BaseQuery {

    /**
     * 根据打通文档的说明，此处在使用的应用类型为小程序时应当为小程序的 appid。具体内容参见上面的 access_key 说明
     */
    private String access_key;

    /**
     * 要转换的 item_id 列表，最长为 100 个
     */
    private List<String> video_ids;

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public List<String> getVideo_ids() {
        return video_ids;
    }

    public void setVideo_ids(List<String> video_ids) {
        this.video_ids = video_ids;
    }

    public static ItemId2EncryptIdQueryBuilder builder() {
        return new ItemId2EncryptIdQueryBuilder();
    }

    public static class ItemId2EncryptIdQueryBuilder {
        private String accessKey;

        private List<String> videoIds;

        private Integer tenantId;

        private String clientKey;

        public ItemId2EncryptIdQueryBuilder accessKey(String accessKey) {
            this.accessKey = accessKey;
            return this;
        }

        public ItemId2EncryptIdQueryBuilder videoIds(List<String> videoIds) {
            this.videoIds = videoIds;
            return this;
        }

        public ItemId2EncryptIdQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ItemId2EncryptIdQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public ItemId2EncryptIdQuery build() {
            ItemId2EncryptIdQuery itemId2EncryptIdQuery = new ItemId2EncryptIdQuery();
            itemId2EncryptIdQuery.setAccess_key(accessKey);
            itemId2EncryptIdQuery.setVideo_ids(videoIds);
            itemId2EncryptIdQuery.setTenantId(tenantId);
            itemId2EncryptIdQuery.setClientKey(clientKey);
            return itemId2EncryptIdQuery;
        }
    }
}
