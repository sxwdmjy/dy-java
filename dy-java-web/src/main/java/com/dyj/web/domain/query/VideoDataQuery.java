package com.dyj.web.domain.query;

import java.util.List;

public class VideoDataQuery extends UserInfoQuery{

    /**
     * item_id 数组，仅能查询 access_token 对应用户上传的视频（与video_ids字段二选一，平台优先处理item_ids）
     */
    private List<String> item_ids;

    /**
     * video_id 数组，仅能查询 access_token 对应用户上传的视频（与item_ids字段二选一，平台优先处理item_ids）
     */
    private List<String> video_ids;

    public List<String> getItem_ids() {
        return item_ids;
    }

    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }

    public List<String> getVideo_ids() {
        return video_ids;
    }

    public void setVideo_ids(List<String> video_ids) {
        this.video_ids = video_ids;
    }

    public static VideoDataQueryBuilder builder() {
        return new VideoDataQueryBuilder();
    }

    public static class VideoDataQueryBuilder {
        private List<String> itemIds;
        private List<String> videoIds;
        private String openId;
        private Integer tenantId;
        private String clientKey;

        public VideoDataQueryBuilder itemIds(List<String> itemIds) {
            this.itemIds = itemIds;
            return this;
        }
        public VideoDataQueryBuilder videoIds(List<String> videoIds) {
            this.videoIds = videoIds;
            return this;
        }
        public VideoDataQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }
        public VideoDataQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public VideoDataQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }
        public VideoDataQuery build() {
            VideoDataQuery videoDataQuery = new VideoDataQuery();
            videoDataQuery.setItem_ids(itemIds);
            videoDataQuery.setVideo_ids(videoIds);
            videoDataQuery.setOpen_id(openId);
            videoDataQuery.setTenantId(tenantId);
            videoDataQuery.setClientKey(clientKey);
            return videoDataQuery;
        }
    }

    @Override
    public String toString() {
        return "VideoDataQuery{" +
                "item_ids=" + item_ids +
                ", video_ids=" + video_ids +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
