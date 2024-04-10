package com.dyj.web;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.handler.RequestHandler;
import com.dyj.common.service.IAgentConfigService;
import com.dyj.common.utils.DyConfigUtils;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;
import com.dyj.web.handler.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
        return DyConfigUtils.getDyConfig();
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
    public DyResult<RefreshTokenVo> refreshToken(String openId) {
        DyConfiguration configuration = configuration();
        AgentConfiguration agentConfiguration = configuration.getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        UserTokenInfo userTokenInfo = configuration.getAgentTokenService().getTokenInfo(tenantId, clientKey,openId);
        // 利用配置信息和授权码获取新的访问令牌
        return new AccessTokenHandler(agentConfiguration).refreshToken(userTokenInfo.getRefreshToken());
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
    public DyResult<RefreshAccessTokenVo> refreshAccessToken(String openId) {
        DyConfiguration configuration = configuration();
        AgentConfiguration agentConfiguration = configuration.getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        UserTokenInfo userTokenInfo = configuration.getAgentTokenService().getTokenInfo(tenantId, clientKey,openId);
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的刷新令牌
        return new AccessTokenHandler(agentConfiguration).refreshAccessToken(userTokenInfo.getRefreshToken());
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
     * 用户经营身份管理。
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

    /**
     * 发送私信消息。
     * @param query 包含发送消息所需信息的查询对象。
     * @return 返回操作结果，包括是否成功及可能的错误信息。
     */
    public DyResult<BaseVo> sendMessage(SendMsgQuery query) {
        // 通过租户ID和客户端密钥加载代理配置，并使用该配置创建ChatMsgHandler来处理消息发送
        return new ChatMsgHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).sendMessage(query);
    }

    /**
     * 查询授权主动私信用户。
     * @param query 包含查询授权用户列表所需信息的查询对象。
     * @return 返回操作结果，包括授权用户列表及可能的错误信息。
     */
    public DyResult<AuthorizeUserListVo> queryAuthorizeUserList(AuthorizeUserListQuery query) {
        // 通过租户ID和客户端密钥加载代理配置，并使用该配置创建ChatMsgHandler来处理授权用户列表查询
        return new ChatMsgHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryAuthorizeUserList(query);
    }

    /**
     * 私信消息撤回。
     * @param query 包含撤销消息所需信息的查询对象。
     * @return 返回操作结果，包括是否成功及可能的错误信息。
     */
    public DyResult<BaseVo> revokeMessage(RevokeMsgQuery query) {
        // 通过租户ID和客户端密钥加载代理配置，并使用该配置创建ChatMsgHandler来处理消息撤销
        return new ChatMsgHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).revokeMessage(query);
    }

    /**
     * 创建粉丝群。
     *
     * @param query 创建粉丝群组的查询参数，包含创建群组所需的所有信息。
     * @return 返回创建粉丝群组的结果信息，包括群组的详细信息等。
     */
    public CreateFansGroupVo createFansGroup(CreateFansGroupQuery query){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).createFansGroup(query);
    }

    /**
     * 变更用户入群申请状态。
     *
     * @param query 设置进群权限的查询参数，包含群组ID、进群权限等。
     * @return 返回设置进群权限的结果信息，包括进群权限的详细信息等。
     */
    public SetFansGroupEnterStatusVo setFansGroupEnterStatus(SetFansGroupEnterStatusQuery query){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).setFansGroupEnterStatus(query);
    }

    /**
     * 查询粉丝群。
     *
     * @param openId 用户的openId。
     * @return 返回查询查询粉丝群结果。
     */
    public FansGroupVo queryFansGroup(String openId){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryFansGroup(openId);
    }

    /**
     * 发送群消息。
     *
     * @param query 发送群聊消息的查询参数，包含群组ID、消息内容等。
     * @return 返回发送群聊消息的结果信息，包括消息的详细信息等。
     */
    public ChatMsgResponseVo sendGroupMessage(SendGroupMsgQuery query){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).sendGroupMessage(query);
    }

    /**
     * 撤回群消息。
     *
     * @param query 撤回群聊消息的查询参数，包含群组ID、消息ID等。
     * @return 返回撤回群聊消息的结果信息，包括消息的详细信息等。
     */
    public DySimpleResult revokeGroupMessage(RevokeGroupMsgQuery query){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).revokeGroupMessage(query);
    }

    /**
     * 设置进群问候语&群公告。
     *
     * @param query 查询群设置查询参数，包含群组ID等。
     * @return 返回设置进群问候语&群公告结果。
     */
    public FansGroupSettingVo queryFansGroupSetting(FansGroupSettingQuery query){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryFansGroupSetting(query);
    }

    /**
     * 查询群主所在群的用户入群申请状态。
     *
     * @param openId 用户的openId。
     * @param count  查询数量。
     * @param cursor 查询游标。
     * @return 返回查询群主所在群的用户入群申请状态结果。
     */
    public FansGroupEnterStatusVo queryFansGroupEnterStatus(String openId, Integer count, Integer cursor){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryFansGroupEnterStatus(openId, count, cursor);
    }

    /**
     * 取消进群问候语&群公告配置。
     *
     * @param query 查询群设置查询参数，包含群组ID等。
     * @return 返回取消进群问候语&群公告配置结果。
     */
    public FansGroupSettingVo cancelFansGroupSetting(FansGroupSettingQuery query){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).cancelFansGroupSetting(query);
    }

    /**
     * 查询用户剩余建群额度。
     *
     * @param openId 用户的openId。
     * @return 返回查询用户剩余建群额度结果。
     */
    public FansGroupCountVo queryFansGroupCount(String openId){
        return new GroupHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryFansGroupCount(openId);
    }

    /**
     * 创建/更新留资卡片
     * @param query 保存留资卡片的查询参数
     * @return 返回创建/更新留资卡片结果
     */
    public SaveRetainConsultCardVo saveRetainConsultCard(SaveRetainConsultCardQuery query){
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).saveRetainConsultCard(query);
    }

    /**
     * 查询留资卡片
     * @param openId 用户的openId
     * @return 返回查询留资卡片结果
     */
    public RetainConsultCardVo getRetainConsultCard(String openId){
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getRetainConsultCard(openId);
    }

    /**
     * 删除留资卡片
     * @param query 删除留资卡片的查询参数
     * @return 返回删除留资卡片结果
     */
    public SaveRetainConsultCardVo deleteRetainConsultCard(SaveRetainConsultCardQuery query){
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).deleteRetainConsultCard(query);
    }

    /**
     * 创建/更新小程序引导卡片模板
     * @param query 创建/更新小程序引导卡片模板的查询参数
     * @return 返回创建/更新小程序引导卡片模板结果
     */
    public DyResult<CreateAppletTemplateVo> setAppletTemplate(CreateAppletTemplateQuery query){
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).setAppletTemplate(query);
    }

    /**
     * 查询小程序引导卡片模板
     * @param query 查询小程序引导卡片模板的查询参数
     * @return 返回查询小程序引导卡片模板结果
     */
    public DyResult<AppletTemplateVo> getAppletTemplate(AppletTemplateQuery query) {
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getAppletTemplate(query);
    }

    /**
     * 删除小程序引导卡片模板
     * @param query 删除小程序引导卡片模板的查询参数
     * @return 返回删除小程序引导卡片模板结果
     */
    public DyResult<BaseVo> delAppletTemplate(AppletTemplateQuery query) {
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).delAppletTemplate(query);
    }

    /**
     * 上传图片
     * @param file 图片文件
     * @return 返回上传图片结果
     */
    public ImageClientUploadVo imageClientUpload(File file) {
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).imageClientUpload(file);
    }

    /**
     * 上传图片
     * @param inputStream 图片文件流
     * @return 返回上传图片结果
     */
    public ImageClientUploadVo imageClientUpload(InputStream inputStream) {
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).imageClientUpload(inputStream);
    }

    /**
     * 上传图片
     * @param bytes 图片文件字节数组
     * @return 返回上传图片结果
     */
    public ImageClientUploadVo imageClientUpload(Byte[] bytes) {
        return new BusinessHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).imageClientUpload(bytes);
    }

    /**
     * 互动用户记录查询
     *
     * @param query 入参
     * @return DyResult<IntentionLogVo>
     */
    public DyResult<IntentionLogVo> intentionLog(IntentionLogQuery query){
        return new IntentionHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).intentionLog(query);
    }
}
