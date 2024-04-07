package com.dyj.web;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.TokenInfo;
import com.dyj.common.handler.RequestHandler;
import com.dyj.web.domain.query.CreateImageTextQuery;
import com.dyj.web.domain.query.CreateVideoQuery;
import com.dyj.web.domain.query.VideoDataQuery;
import com.dyj.web.domain.vo.*;
import com.dyj.web.handler.AccessTokenHandler;
import com.dyj.web.handler.UserHandler;
import com.dyj.web.handler.VideoHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author danmo
 * @date 2024-04-03 17:25
 **/
public class DyWebClient {

    private Integer tenantId;

    private String clientKey;

    public DyWebClient() {
    }

    public static DyWebClient getInstance() {
        return new DyWebClient();
    }

    public DyWebClient tenantId(Integer tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public DyWebClient clientKey(String clientKey) {
        this.clientKey = clientKey;
        return this;
    }

    private DyConfiguration configuration() {
        return RequestHandler.getInstance().getDyConfiguration();
    }

    /**
     * 通过代码获取访问令牌。
     *
     * @param code 用户授权后返回的授权码。
     * @return 返回一个包含访问令牌信息的结果对象。
     */
    public DyResult<AccessTokenVo> accessToken(String code) {
        AgentConfiguration agentConfiguration = configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        // 使用配置信息和授权码获取访问令牌
        return new AccessTokenHandler(agentConfiguration).getAccessToken(code);
    }

    /**
     * 刷新访问令牌。
     * 本方法用于根据租户ID和应用ID获取新的访问令牌。
     *
     * @return 返回一个包含刷新后的访问令牌信息的结果对象。
     */
    public DyResult<RefreshTokenVo> refreshToken() {
        DyConfiguration configuration = configuration();
        AgentConfiguration agentConfiguration = configuration.getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        TokenInfo tokenInfo = configuration.getAgentTokenService().getTokenInfo(tenantId, clientKey);
        // 利用配置信息和授权码获取新的访问令牌
        return new AccessTokenHandler(agentConfiguration).refreshToken(tokenInfo.getRefreshToken());
    }


    /**
     * 根据指定的租户ID和客户端ID获取客户端令牌。
     *
     * @return 返回客户端令牌的结果，包含令牌信息或其他操作结果。
     */
    public DyResult<ClientTokenVo> clientToken() {
        AgentConfiguration agentConfiguration = configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的令牌
        return new AccessTokenHandler(agentConfiguration).getClientToken();
    }


    /**
     * 带租户ID和客户端ID参数的刷新访问令牌方法。
     * 使用提供的租户ID和客户端ID刷新访问令牌。
     *
     * @return DyResult<RefreshAccessTokenVo> 包含刷新后的访问令牌信息的结果对象。
     */
    public DyResult<RefreshAccessTokenVo> refreshAccessToken() {
        DyConfiguration configuration = configuration();
        AgentConfiguration agentConfiguration = configuration.getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        TokenInfo tokenInfo = configuration.getAgentTokenService().getTokenInfo(tenantId, clientKey);
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的刷新令牌
        return new AccessTokenHandler(agentConfiguration).refreshAccessToken(tokenInfo.getRefreshToken());
    }

    /**
     * 获取用户信息的函数，支持指定租户ID和客户端ID。
     *
     * @param openId 用户的唯一标识。
     * @return 返回一个包含用户信息的DyResult对象。
     */
    public DyResult<UserInfoVo> getUserInfo(String openId) {
        // 根据配置获取Agent配置
        DyConfiguration configuration = configuration();
        AgentConfiguration agentConfiguration = configuration.getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        // 使用Agent配置和用户ID获取用户信息
        return new UserHandler(agentConfiguration).getUserInfo(openId);
    }

    /**
     * 检查指定用户是否为另一用户的粉丝。
     *
     * @param openId         主体用户的OpenID，即被检查关注情况的用户ID。
     * @param followerOpenId 粉丝用户的OpenID，即检查是否关注了主体用户的用户ID。
     * @return 返回一个DyResult对象，包含检查结果的详细信息。其中，CheckFansVo对象封装了粉丝检查的结果数据。
     */
    public DyResult<CheckFansVo> checkFans(String openId, String followerOpenId) {
        AgentConfiguration agentConfiguration = configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        return new UserHandler(agentConfiguration).checkFans(openId, followerOpenId);
    }

    /**
     * 根据用户标识和角色标签列表检查用户角色。
     *
     * @param openId        用户的开放标识，用于识别用户。
     * @param douyinShortId 抖音短ID，另一种用户标识方式。
     * @param roleLabels    用户可能拥有的角色标签列表。
     * @return DyResult<UserRoleCheckVo> 返回一个包含检查结果的响应对象，其中包含用户角色检查的详细信息。
     */
    public DyResult<UserRoleCheckVo> userRoleCheck(String openId, String douyinShortId, List<String> roleLabels) {
        AgentConfiguration agentConfiguration = configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        return new UserHandler(agentConfiguration).userRoleCheck(openId, douyinShortId, roleLabels);
    }

    /**
     * 创建图文消息。
     *
     * @param query 创建图文消息的查询参数。
     * @return DyResult<CreateImageTextVo> 返回一个包含创建图文消息结果的响应对象。
     */
    public DyResult<CreateImageTextVo> createImageText(CreateImageTextQuery query){
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).createImageText(query);
    }

    /**
     * 上传图片。
     *
     * @param openId 用户的OpenID，用于标识上传者。
     * @param file   要上传的图片文件。
     * @return DyResult<UploadImageVo> 返回一个包含上传图片结果的响应对象。
     * @throws FileNotFoundException 如果指定的文件不存在，则抛出此异常。
     */
    public DyResult<UploadImageVo> uploadImage(String openId, File file) throws FileNotFoundException {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).uploadImage(openId, file);
    }

    /**
     * 上传视频。
     *
     * @param openId 用户的OpenID，用于标识上传者。
     * @param file   要上传的视频文件。
     * @return DyResult<UploadVideoVo> 返回一个包含上传视频结果的响应对象。
     * @throws FileNotFoundException 如果指定的文件不存在，则抛出此异常。
     */
    public DyResult<UploadVideoVo> uploadVideo(String openId, File file) throws FileNotFoundException {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).uploadVideo(openId, file);
    }

    /**
     * 创建视频。
     *
     * @param query 创建视频的查询参数。
     * @return DyResult<CreateVideoVo> 返回一个包含创建视频结果的响应对象。
     */
    public DyResult<CreateVideoVo> createVideo(CreateVideoQuery query){
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).createVideo(query);
    }

    /**
     * 分片上传完成。
     *
     * @param openId 用户ID。
     * @param uploadId 分片上传的标记。
     * @return DyResult<UploadVideoVo>。
     */
    public DyResult<UploadVideoVo> completeVideoPartUpdate(String openId, String uploadId) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).completeVideoPartUpdate(openId, uploadId);
    }

    /**
     * 分片上传。
     *
     * @param openId 用户ID。
     * @param uploadId 分片上传的标记。
     * @param partNumber 分片上传的序号。
     * @param file 要上传的文件。
     * @return DyResult<BaseVo>。
     * @throws FileNotFoundException 如果指定的文件不存在，则抛出此异常。
     */
    public DyResult<BaseVo> updateVideoPart(String openId, String uploadId, Integer partNumber, File file) throws FileNotFoundException {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).updateVideoPart(openId, uploadId, partNumber, file);
    }

    /**
     * 初始化分片上传。
     *
     * @param openId 用户ID。
     * @return DyResult<InitPartUploadVo>。
     */
    public DyResult<InitPartUploadVo> initializeVideoPartUpload(String openId) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).initializeVideoPartUpload(openId);
    }

    /**
     * 查询授权账号视频列表。
     *
     * @param openId 用户ID。
     * @param cursor 分页游标。
     * @param count 每页数量。
     * @return DyResult<QueryVideoListVo>。
     */
    public DyResult<QueryVideoListVo> queryVideoList(String openId, Integer cursor, Integer count) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryVideoList(openId, cursor, count);
    }

    /**
     * 查询特定视频的视频数据。
     *
     * @param query 查询参数。
     * @return DyResult<QueryVideoListVo>。
     */
    public DyResult<QueryVideoListVo> queryVideoData(VideoDataQuery query) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryVideoData(query);
    }

    /**
     * 查询视频发布结果。
     *
     * @param defaultHashtag 默认话题。
     * @param linkParam 链接参数。
     * @param needCallback 是否需要回调。
     * @param sourceStyleId 源样式ID。
     * @return DyResult<QueryVideoPublishResultVo>。
     */
    public DyResult<QueryVideoPublishResultVo> queryVideoPublishResult(String defaultHashtag, String linkParam, Boolean needCallback, String sourceStyleId) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryVideoPublishResult(defaultHashtag, linkParam, needCallback, sourceStyleId);
    }

    /**
     * 查询视频携带的地点信息。
     *
     * @param count 每页数量。
     * @param keyword 关键词。
     * @param city 城市。
     * @param cursor 分页游标。
     * @return DyResult<QueryVideoLocationVo>。
     */
    public DyResult<QueryVideoLocationVo> queryVideoLocation(Integer count, String keyword, String city, Integer cursor) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryVideoLocation(count, keyword, city, cursor);
    }

    /**
     * 查询视频的IFRAME。
     *
     * @param videoId 视频ID。
     * @return DyResult<VideoIframeVo>。
     */
    public DyResult<VideoIframeVo> getIframeByVideo(String videoId) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getIframeByVideo(videoId);
    }

    /**
     * 查询视频的IFRAME。
     *
     * @param itemId 视频ID。
     * @return DyResult<VideoIframeVo>。
     */
    public DyResult<VideoIframeVo> getIframeByItem(String itemId) {
        return new VideoHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getIframeByItem(itemId);
    }
}
