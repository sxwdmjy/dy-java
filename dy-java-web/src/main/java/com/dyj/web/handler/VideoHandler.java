package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;

import java.io.*;
import java.nio.file.Files;

public class VideoHandler extends AbstractWebHandler{


    public VideoHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    public DyResult<CreateImageTextVo> createImageText(CreateImageTextQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getVideoClient().createImageText(query);
    }

    public DyResult<UploadImageVo> uploadImage(String openId, File file) throws IOException {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return getVideoClient().uploadImage(query, Files.newInputStream(file.toPath()));
    }

    public DyResult<UploadVideoVo> uploadVideo(String openId, File file) throws IOException {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return getVideoClient().uploadVideo(query, Files.newInputStream(file.toPath()));
    }

    public DyResult<CreateVideoVo> createVideo(CreateVideoQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getVideoClient().createVideo(query);
    }

    public DyResult<UploadVideoVo> completeVideoPartUpdate(String openId, String uploadId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return getVideoClient().completeVideoPartUpload(query, uploadId);
    }

    public DyResult<BaseVo> updateVideoPart(String openId, String uploadId, Integer partNumber, File file) throws IOException {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return getVideoClient().uploadVideoPart(query, uploadId, partNumber, Files.newInputStream(file.toPath()));
    }

    public DyResult<InitPartUploadVo> initializeVideoPartUpload(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return getVideoClient().initializeVideoPartUpload(query);
    }

    public DyResult<QueryVideoListVo> queryVideoList(String openId, Integer cursor, Integer count) {
        UserInfoQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        query.setOpen_id(openId);
        return getVideoClient().queryVideoList(query, cursor, count);
    }

    public DyResult<QueryVideoListVo> queryVideoData(VideoDataQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getVideoClient().queryVideoData(query);
    }

    public DyResult<QueryVideoPublishResultVo> queryVideoPublishResult(String defaultHashtag, String linkParam, Boolean needCallback, String sourceStyleId) {
        BaseQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getVideoClient().queryVideoPublishResult(query, defaultHashtag, linkParam, needCallback, sourceStyleId);
    }

    public DyResult<QueryVideoLocationVo> queryVideoLocation(Integer count, String keyword, String city, Integer cursor) {
        BaseQuery query = new UserInfoQuery();
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getVideoClient().queryVideoLocation(query, count, keyword, city, cursor);
    }

    public DyResult<VideoIframeVo> getIframeByVideo(String videoId) {
        return getVideoClient().getIframeByVideo(videoId);
    }

    public DyResult<VideoIframeVo> getIframeByItem(String itemId) {
        return getVideoClient().getIframeByItem(itemId, agentConfiguration.getClientKey());
    }
}
