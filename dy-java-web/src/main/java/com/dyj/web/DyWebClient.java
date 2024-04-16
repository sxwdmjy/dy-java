package com.dyj.web;

import com.dtflys.forest.annotation.JSONBody;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.utils.DyConfigUtils;
import com.dyj.web.domain.*;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;
import com.dyj.web.handler.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
     * 回调事件签名验证
     * @param signature 签名
     * @param wholeStr  消息体字符串
     * @return 验证结果
     */
    public Boolean checkSign(String signature, String wholeStr) {
        AgentConfiguration agentConfiguration = configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        String data = agentConfiguration.getClientSecret() + wholeStr;
        String sign = DigestUtils.sha1Hex(data);
        if(!sign.equals(signature)){
            return false;
        }
        return true;
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
        UserTokenInfo userTokenInfo = configuration.getAgentTokenService().getUserTokenInfo(agentConfiguration.getTenantId(), agentConfiguration.getClientKey(),openId);
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
        UserTokenInfo userTokenInfo = configuration.getAgentTokenService().getUserTokenInfo(agentConfiguration.getTenantId(), agentConfiguration.getClientKey(),openId);
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
    public DyResult<UploadImageVo> uploadImage(String openId, File file) throws IOException {
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
    public DyResult<UploadVideoVo> uploadVideo(String openId, File file) throws IOException {
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
    public DyResult<BaseVo> updateVideoPart(String openId, String uploadId, Integer partNumber, File file) throws IOException {
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
    public ImageClientUploadVo imageClientUpload(byte[] bytes) {
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

    /**
     * 评论置顶
     * @param query
     * @return
     */
    public DyResult<BaseVo> commentTop(CommentQuery query) {
        return new CommentHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).commentTop(query);
    }


    /**
     * 查询评论列表。
     * @param openId 用户标识。
     * @param itemId 视频id。
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)。
     * @param count 每页的数量，最大不超过20，最小不低于1
     * @param cursor 分页游标。
     * @return 返回评论列表的结果，包含评论信息。
     */
    public DyResult<CommentListVo> queryCommentList(String openId, String itemId, String sortType, Integer count, Integer cursor) {
        // 通过租户ID和客户端密钥加载代理配置，创建评论处理器并查询评论列表
        return new CommentHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryCommentList(openId, itemId, sortType, count, cursor);
    }

    /**
     * 查询评论回复列表。
     * @param openId 用户标识。
     * @param itemId 视频id。
     * @param commentId 评论Id。
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)。
     * @param count 每页的数量，最大不超过20，最小不低于1
     * @param cursor 分页游标。
     * @return 返回评论回复列表的结果，包含评论回复信息。
     */
    public DyResult<CommentListVo> queryCommentReplyList(String openId, String itemId, String commentId, String sortType, Integer count, Integer cursor) {
        // 通过租户ID和客户端密钥加载代理配置，创建评论处理器并查询评论回复列表
        return new CommentHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryCommentReplyList(openId, itemId, commentId, sortType, count, cursor);
    }

    /**
     * 发表评论回复。
     * @param query 包含评论信息的查询参数。
     * @return 返回评论回复的结果，包含评论回复的详细信息。
     */
    public DyResult<CommentReplyVo> commentReply(CommentQuery query) {
        // 通过租户ID和客户端密钥加载代理配置，创建评论处理器并发表评论回复
        return new CommentHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).commentReply(query);
    }

    /**
     * H5分享跳转链接获取
     * @param query 入参
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getH5Share(GetH5ShareQuery query) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getH5Share(query);
    }
    /**
     * 个人页跳转链接获取
     * @param openId  用户ID
     * @param account 抖音号
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getUserProfile(String openId, String account, Long expireAt) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getUserProfile(openId, account, expireAt);
    }
    /**
     * 个人会话页跳转链接获取
     * @param openId  用户ID
     * @param account 抖音号
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getUserChat(String openId, String account, Long expireAt){
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getUserChat(openId, account, expireAt);
    }
    /**
     * 视频详情页跳转链接获取
     * @param itemId 视频ID
     * @param videoId 视频ID
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getItem(String itemId, String videoId, Long expireAt) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getItem(itemId, videoId, expireAt);
    }

    /**
     * 直播间页跳转链接获取
     * @param openId  用户ID
     * @param account 抖音号
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getLive(String openId,String account, Long expireAt) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getLive(openId, account, expireAt);
    }

    /**
     * 创建投稿任务
     *
     * @param query 入参
     * @return DyResult<PostingTaskVo>
     */
    public DyResult<PostingTaskVo> createPostingTask(CreatePostingTaskQuery query){
        return new PostingTaskHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).createPostingTask(query);
    }
    /**
     * 绑定视频
     * @param query 入参
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> postingTaskBindVideo(PostingTaskQuery query){
        return new PostingTaskHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).postingTaskBindVideo(query);
    }
    /**
     * 核销投稿任务
     * @param query 入参
     * @return DyResult<ConfirmPostingTaskVo>
     */
    public DyResult<ConfirmPostingTaskVo> confirmPostingTask(ConfirmPostingTaskQuery query){
        return new PostingTaskHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).confirmPostingTask(query);
    }
    /**
     * 查询视频基础信息
     * @param query 入参
     * @return DyResult<VideoBasicListVo>
     */
    public DyResult<VideoBasicListVo> queryVideoBasicInfo(VideoDataQuery query){
        return new PostingTaskHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryVideoBasicInfo(query);
    }

    /**
     * 上传素材
     *
     * @param file 文件
     * @return DyResult<UploadMaterialVo>
     * @throws IOException
     */
    public DyResult<UploadMaterialVo> uploadMaterial(File file) throws IOException {
        return uploadMaterial(Files.newInputStream(file.toPath()));
    }

    /**
     * 上传素材
     *
     * @param inputStream 流
     * @return DyResult<UploadMaterialVo>
     * @throws IOException
     */
    public DyResult<UploadMaterialVo> uploadMaterial(InputStream inputStream) throws IOException {
        return uploadMaterial(StreamUtils.copyToByteArray(inputStream));
    }

    /**
     * 上传素材
     *
     * @param bytes bytes
     * @return DyResult<UploadMaterialVo>
     */
    public DyResult<UploadMaterialVo> uploadMaterial(byte[] bytes) {
        return new MediaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).uploadMaterial(bytes);
    }

    /**
     * 上传临时素材
     *
     * @param file 文件
     * @return DyResult<UploadMaterialVo>
     * @throws IOException
     */
    public DyResult<UploadMaterialVo> uploadTemporaryMaterial(File file) throws IOException {
        return uploadTemporaryMaterial(Files.newInputStream(file.toPath()));
    }

    /**
     * 上传临时素材
     *
     * @param inputStream 流
     * @return DyResult<UploadMaterialVo>
     * @throws IOException
     */
    public DyResult<UploadMaterialVo> uploadTemporaryMaterial(InputStream inputStream) throws IOException {
        return uploadTemporaryMaterial(StreamUtils.copyToByteArray(inputStream));
    }

    /**
     * 上传临时素材
     *
     * @param bytes bytes
     * @return DyResult<UploadMaterialVo>
     */
    public DyResult<UploadMaterialVo> uploadTemporaryMaterial(byte[] bytes) {
        return new MediaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).uploadTemporaryMaterial(bytes);
    }

    /**
     * 素材列表接口
     *
     * @param openId 用户ID
     * @param cursor cursor
     * @param count  数量
     * @return DyResult<MaterialListVo>
     */
    public DyResult<MaterialListVo> queryMaterialList(String openId, Integer cursor, Integer count) {
        return new MediaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryMaterialList(openId, cursor, count);
    }

    /**
     * 删除素材
     * @param openId 用户ID
     * @param mediaId 素材ID
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> deleteMaterial(String openId, String mediaId) {
        return new MediaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).deleteMaterial(openId, mediaId);
    }

    /**
     * 小程序接口能力
     * @param micAppId 小程序id
     * @return DyResult<MicAppDevtoolLegalVo>
     */
    public DyResult<MicAppDevtoolLegalVo> micAppDevtoolLegal(String micAppId) {
        return new ToolsHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).micAppDevtoolLegal(micAppId);
    }
    /**
     * 模拟webhook事件
     * @param eventType 事件类型
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> webhookEventSend(String eventType) {
        return new ToolsHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).webhookEventSend(eventType);
    }

    /**
     * 获取jsb_ticket
     */
    public DyResult<TicketVo> getJsbTicket(){
        return new ToolsHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getJsbTicket();
    }

    /**
     * 获取 open_ticket
     */
    public DyResult<TicketVo> getOpenTicket(){
        return new ToolsHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getOpenTicket();
    }

    /**
     * 获取事件订阅状态
     * @return DyResult<EventSubscribeVo>
     */
    public DyResult<EventSubscribeVo> getEventSubscribeStatus(){
        return new ToolsHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getEventSubscribeStatus();
    }


    /**
     * 更新事件订阅状态
     * @param query 状态入参
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> updateEventSubscribeStatus(UpdateEventSubscribeQuery query){
        return new ToolsHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).updateEventSubscribeStatus(query);
    }


    /**
     * 关键词视频搜索
     * @param openId openId
     * @param keyword 关键词
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param count 每页数量
     * @return
     */
    public DyResult<VideoSearchListVo> videoSearchV2(String openId, String keyword, Integer count, Long cursor){
        return new SearchHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).videoSearchV2(openId, keyword, count, cursor);
    }

    /**
     * 关键词视频评论列表
     * @param count 每页数量。
     * @param secItemId 视频搜索接口返回的加密的视频id
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @return
     */
    public DyResult<VideoSearchCommentListV2ListVo> videoSearchCommentListV2(Integer count, String secItemId, Long cursor){
        return new SearchHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).videoSearchCommentListV2(count, secItemId, cursor);
    }


    /**
     * 关键词视频评论回复
     * @param body 关键词视频评论回复请求值
     * @return
     */
    public DyResult<VideoSearchCommentReplyV2Result> videoSearchCommentReplyV2(VideoSearchCommentReplyV2Query body){
        return new SearchHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).videoSearchCommentReplyV2(body);
    }

    /**
     * 关键词视频评论回复列表
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param count 每页数量。
     * @param secItemId 视频搜索接口返回的加密的视频id
     * @param commentId 评论id
     * @return
     */
    public DyResult<VideoSearchCommentListV2ListVo> videoSearchCommentReplyListV2(Long cursor,Integer count,String secItemId,String commentId){
        return new SearchHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).videoSearchCommentReplyListV2(cursor, count, secItemId, commentId);
    }

    /**
     * 获取用户视频情况
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserItemResult>> externalUserItem(Long dateType, String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalUserItem(dateType,openId);
    }

    /**
     * 获取用户粉丝数
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    public DyResult<ResultListVo<ExternalUserFansResult>> externalUserFans(Long dateType, String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalUserFans(dateType,openId);
    }

    /**
     * 获取用户点赞数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserLikeResult>> externalUserLike(Long dateType, String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalUserLike(dateType,openId);
    }

    /**
     * 获取用户评论数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserCommentResult>> externalUserComment(Long dateType, String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalUserComment(dateType,openId);
    }

    /**
     * 获取用户分享数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserShareResult>> externalUserShare(Long dateType, String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalUserShare(dateType,openId);

    }

    /**
     * 获取用户主页访问数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserProfileResult>> externalUserProfile(Long dateType,String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalUserProfile(dateType,openId);
    }

    /**
     * 获取视频基础数据
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultVo<ExternalItemBaseResult>> externalItemBase(String itemId, String openId) {
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalItemBase(itemId,openId);
    }

    /**
     * 获取视频点赞数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemLikeResult>> externalItemLike(Long dateType,String itemId,String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalItemLike(dateType,itemId,openId);
    }

    /**
     * 获取视频评论数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemCommentResult>> externalItemComment(Long dateType,String itemId,String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalItemComment(dateType,itemId,openId);
    }

    /**
     * 获取视频播放数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemPlayResult>> externalItemPlay(Long dateType,String itemId,String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalItemPlay(dateType,itemId,openId);
    }

    /**
     * 获取视频分享数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemShareResult>> externalItemShare(Long dateType,String itemId,String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).externalItemShare(dateType,itemId,openId);
    }


    /**
     * 获取主播历史开播过的房间ID
     * @param endTime 查询结束时间，秒级时间戳。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @param startTime 查询开始时间，秒级时间戳。
     * @return
     */
    public GetRoomIdListVo getRoomIdList(Long endTime, String openId, Long startTime){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getRoomIdList(endTime,openId,startTime);

    }

    /**
     * 获取直播间互动数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @param roomId 房间id
     * @return
     */
    public DySimpleResult<LiveRoomResult> getRoomInteractiveData(Long liveId, String openId, Long roomId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getRoomInteractiveData(liveId,openId,roomId);
    }

    /**
     * 获取直播间看播数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param openId 调用 /oauth/access_token/ 生成的 open_id，53dba859-3b1a-4a82-9249-3baf97fcada8
     * @param roomId 房间id
     * @return
     */
    public DySimpleResult<LiveRoomResult> getRoomAudienceData(Long liveId,String openId,Long roomId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getRoomAudienceData(liveId,openId,roomId);
    }

    /**
     * 获取直播间基础数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param openId <p>调用 <a href="https://developer.open-douyin.com/docs/resource/zh-CN/dop/develop/openapi/account-permission/get-access-token" target="_blank" rel="nofollow" class="syl-link" elementtiming="element-timing">/oauth/access_token/</a> 生成的 open_id，53dba859-3b1a-4a82-9249-3baf97fcada8</p>
     * @param roomId 房间id
     * @return
     */
    public DySimpleResult<LiveRoomResult> getRoomBaseData(Long liveId,String openId,Long roomId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getRoomBaseData(liveId,openId,roomId);
    }

    /**
     * 获取用户粉丝数据
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ApiFansDataBindFansVo> apiFansDataBind(String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).apiFansDataBind(openId);
    }

    /**
     * 获取用户粉丝来源
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ListVo<ItemValue>> getFansSource(String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getFansSource(openId);
    }

    /**
     * 获取用户粉丝喜好
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ListVo<GetFansFavouriteResult>> getFansFavourite(String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getFansFavourite(openId);
    }

    /**
     * 获取用户粉丝热评
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ListVo<GetFansCommentResult>> getFansComment(String openId){
        return new DataExternalHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId,clientKey)).getFansComment(openId);

    }
}
