package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.VideoClient;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VideoHandler {

    private final VideoClient videoClient;

    private final AgentConfiguration agentConfiguration;

    {
        videoClient = SpringUtils.getBean(VideoClient.class);
    }

    public VideoHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    public DyResult<CreateImageTextVo> createImageText(CreateImageTextQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return videoClient.createImageText(query);
    }

    public DyResult<UploadImageVo> uploadImage(String openId, File file) throws FileNotFoundException {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        FileInputStream inputStream = new FileInputStream(file);
        return videoClient.uploadImage(query, inputStream);
    }

    public DyResult<UploadVideoVo> uploadVideo(String openId, File file) throws FileNotFoundException {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        FileInputStream inputStream = new FileInputStream(file);
        return videoClient.uploadVideo(query, inputStream);
    }

    public DyResult<CreateVideoVo> createVideo(CreateVideoQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return videoClient.createVideo(query);
    }

    public DyResult<UploadVideoVo> completeVideoPartUpdate(String openId, String uploadId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return videoClient.completeVideoPartUpload(query, uploadId);
    }

    public DyResult<BaseVo> updateVideoPart(String openId, String uploadId, Integer partNumber, File file) throws FileNotFoundException {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        FileInputStream inputStream = new FileInputStream(file);
        return videoClient.uploadVideoPart(query, uploadId, partNumber, inputStream);
    }

    public DyResult<InitPartUploadVo> initializeVideoPartUpload(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return videoClient.initializeVideoPartUpload(query);
    }

    public DyResult<QueryVideoListVo> queryVideoList(String openId, Integer cursor, Integer count) {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return videoClient.queryVideoList(query, cursor, count);
    }

    public DyResult<QueryVideoListVo> queryVideoData(VideoDataQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return videoClient.queryVideoData(query);
    }

    public DyResult<QueryVideoPublishResultVo> queryVideoPublishResult(String defaultHashtag, String linkParam, Boolean needCallback, String sourceStyleId) {
        BaseQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return videoClient.queryVideoPublishResult(query, defaultHashtag, linkParam, needCallback, sourceStyleId);
    }

    public DyResult<QueryVideoLocationVo> queryVideoLocation(Integer count, String keyword, String city, Integer cursor) {
        BaseQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return videoClient.queryVideoLocation(query, count, keyword, city, cursor);
    }

    public DyResult<VideoIframeVo> getIframeByVideo(String videoId) {
        return videoClient.getIframeByVideo(videoId);
    }

    public DyResult<VideoIframeVo> getIframeByItem(String itemId) {
        return videoClient.getIframeByItem(itemId, agentConfiguration.getClientKey());
    }
}
