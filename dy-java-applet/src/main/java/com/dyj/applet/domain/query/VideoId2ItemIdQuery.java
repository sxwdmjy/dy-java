package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.BaseQuery;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-19 14:27
 **/
public class VideoId2ItemIdQuery extends BaseQuery {

    /**
     * 字段含义：小程序id或移动网站应用id；
     * 备注：填写转化为目标应用的应用ID，如果转化为本小程序可用的itemId，填入本小程序的appid即可。
     */
    private String access_key;

    /**
     * 小程序ID
     */
    private String app_id;

    private List<String> video_ids;

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public List<String> getVideo_ids() {
        return video_ids;
    }

    public void setVideo_ids(List<String> video_ids) {
        this.video_ids = video_ids;
    }

    public static VideoId2ItemIdQueryBuilder builder() {
        return new VideoId2ItemIdQueryBuilder();
    }

    public static class VideoId2ItemIdQueryBuilder {
        private String accessKey;
        private String appId;
        private List<String> videoIds;
        private Integer tenantId;
        private String clientKey;

        public VideoId2ItemIdQueryBuilder accessKey(String accessKey) {
            this.accessKey = accessKey;
            return this;
        }

        public VideoId2ItemIdQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public VideoId2ItemIdQueryBuilder videoIds(List<String> videoIds) {
            this.videoIds = videoIds;
            return this;
        }

        public VideoId2ItemIdQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public VideoId2ItemIdQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public VideoId2ItemIdQuery build() {
            VideoId2ItemIdQuery videoId2ItemIdQuery = new VideoId2ItemIdQuery();
            videoId2ItemIdQuery.setAccess_key(accessKey);
            videoId2ItemIdQuery.setApp_id(appId);
            videoId2ItemIdQuery.setVideo_ids(videoIds);
            videoId2ItemIdQuery.setTenantId(tenantId);
            videoId2ItemIdQuery.setClientKey(clientKey);
            return videoId2ItemIdQuery;
        }

}
}
