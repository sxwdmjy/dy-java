package com.dyj.web.domain.query;

import com.dyj.web.domain.MiroAppInfo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-11 11:28
 **/
public class GetH5ShareQuery extends BaseQuery{

    /**
     * client_ticket
     */
    private String client_ticket;

    /**
     * 过期时间
     */
    private String expire_at;

    /**
     * 支持有第三方预设内容分享抖音时默认携带的话题
     */
    private List<String> hashtag_list;

    /**
     * 图片文件路径(多个)，图集模式分享
     */
    private List<String> image_list_path;

    /**
     * 添加小程序。视频成功发布视频后，在视频左下角带有小程序入口。
     */
    private List<MiroAppInfo> micro_app_info;

    /**
     * 地理位置信息锚点id，与小程序appId互斥，优先展示小程序。
     */
    private String poi_id;

    /**
     * 为1时直接分享到抖音发布页（仅视频）
     */
    private Integer share_to_publish;

    /**
     * 建议填写，按照文档获取share_id，可以获取视频发布情况
     */
    private String state;
    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频文件路径（单个，不能超过128M)。
     */
    private String video_path;

    public String getClient_ticket() {
        return client_ticket;
    }

    public void setClient_ticket(String client_ticket) {
        this.client_ticket = client_ticket;
    }

    public String getExpire_at() {
        return expire_at;
    }

    public void setExpire_at(String expire_at) {
        this.expire_at = expire_at;
    }

    public List<String> getHashtag_list() {
        return hashtag_list;
    }

    public void setHashtag_list(List<String> hashtag_list) {
        this.hashtag_list = hashtag_list;
    }

    public List<String> getImage_list_path() {
        return image_list_path;
    }

    public void setImage_list_path(List<String> image_list_path) {
        this.image_list_path = image_list_path;
    }

    public List<MiroAppInfo> getMicro_app_info() {
        return micro_app_info;
    }

    public void setMicro_app_info(List<MiroAppInfo> micro_app_info) {
        this.micro_app_info = micro_app_info;
    }

    public String getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(String poi_id) {
        this.poi_id = poi_id;
    }

    public Integer getShare_to_publish() {
        return share_to_publish;
    }

    public void setShare_to_publish(Integer share_to_publish) {
        this.share_to_publish = share_to_publish;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public static GetH5ShareQueryBuilder builder() {
        return new GetH5ShareQueryBuilder();
    }

    public static class GetH5ShareQueryBuilder {
        private String clientTicket;
        private String expireAt;
        private List<String> hashtagList;
        private List<String> imageListPath;
        private List<MiroAppInfo> microAppInfo;
        private String poiId;
        private Integer shareToPublish;
        private String state;
        private String title;
        private String videoPath;


        public GetH5ShareQueryBuilder clientTicket(String clientTicket) {
            this.clientTicket = clientTicket;
            return this;
        }

        public GetH5ShareQueryBuilder expireAt(String expireAt) {
            this.expireAt = expireAt;
            return this;
        }

        public GetH5ShareQueryBuilder hashtagList(List<String> hashtagList) {
            this.hashtagList = hashtagList;
            return this;
        }

        public GetH5ShareQueryBuilder imageListPath(List<String> imageListPath) {
            this.imageListPath = imageListPath;
            return this;
        }

        public GetH5ShareQueryBuilder microAppInfo(List<MiroAppInfo> microAppInfo) {
            this.microAppInfo = microAppInfo;
            return this;
        }

        public GetH5ShareQueryBuilder poiId(String poiId) {
            this.poiId = poiId;
            return this;
        }

        public GetH5ShareQueryBuilder shareToPublish(Integer shareToPublish) {
            this.shareToPublish = shareToPublish;
            return this;
        }

        public GetH5ShareQueryBuilder state(String state) {
            this.state = state;
            return this;
        }

        public GetH5ShareQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        public GetH5ShareQueryBuilder videoPath(String videoPath) {
            this.videoPath = videoPath;
            return this;
        }

        public GetH5ShareQuery build() {
            GetH5ShareQuery getH5ShareQuery = new GetH5ShareQuery();
            getH5ShareQuery.setClient_ticket(clientTicket);
            getH5ShareQuery.setExpire_at(expireAt);
            getH5ShareQuery.setHashtag_list(hashtagList);
            getH5ShareQuery.setImage_list_path(imageListPath);
            getH5ShareQuery.setMicro_app_info(microAppInfo);
            getH5ShareQuery.setPoi_id(poiId);
            getH5ShareQuery.setShare_to_publish(shareToPublish);
            getH5ShareQuery.setState(state);
            getH5ShareQuery.setTitle(title);
            getH5ShareQuery.setVideo_path(videoPath);
            return getH5ShareQuery;
        }

    }

}
