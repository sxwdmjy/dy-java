package com.dyj.applet;

import com.dyj.applet.domain.query.*;
import com.dyj.applet.domain.vo.*;
import com.dyj.applet.handler.*;
import com.dyj.common.client.BaseClient;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.*;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-16 15:28
 **/
public class DyAppletClient extends BaseClient {


    public DyAppletClient() {
    }

    public static DyAppletClient getInstance() {
        return new DyAppletClient();
    }

    public DyAppletClient tenantId(Integer tenantId) {
        super.tenantId = tenantId;
        return this;
    }

    public DyAppletClient clientKey(String clientKey) {
        this.clientKey = clientKey;
        return this;
    }


    /**
     * 通过代码获取访问令牌。
     *
     * @param code 用户授权后返回的授权码。
     * @return 返回一个包含访问令牌信息的结果对象。
     */
    public DyResult<AccessTokenVo> accessToken(String code) {
        // 使用配置信息和授权码获取访问令牌
        return new AppletTokenHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).getAccessToken(code);
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
        UserTokenInfo userTokenInfo = configuration.getAgentTokenService().getUserTokenInfo(agentConfiguration.getTenantId(), agentConfiguration.getClientKey(), openId);
        // 利用配置信息和授权码获取新的访问令牌
        return new AppletTokenHandler(agentConfiguration).refreshToken(userTokenInfo.getRefreshToken());
    }


    /**
     * 根据指定的租户ID和客户端ID获取客户端令牌。
     *
     * @return 返回客户端令牌的结果，包含令牌信息或其他操作结果。
     */
    public DyResult<ClientTokenVo> clientToken() {
        AgentConfiguration agentConfiguration = configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey);
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的令牌
        return new AppletTokenHandler(agentConfiguration).getClientToken();
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
        UserTokenInfo userTokenInfo = configuration.getAgentTokenService().getUserTokenInfo(agentConfiguration.getTenantId(), agentConfiguration.getClientKey(), openId);
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的刷新令牌
        return new AppletTokenHandler(agentConfiguration).refreshAccessToken(userTokenInfo.getRefreshToken());
    }

    /**
     * BusinessToken 生成
     *
     * @param openId 用户ID
     * @param scope  用于指定Token所对应的能力，逗号分割
     * @return DyAppletResult<BizTokenVo>
     */
    public DyAppletResult<BizTokenVo> getBizToken(String openId, String scope) {
        return new AppletTokenHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getBizToken(openId, scope);
    }

    /**
     * BusinessToken 生成刷新
     *
     * @param refreshToken 刷新token
     * @return DyAppletResult<BizTokenVo>
     */
    public DyAppletResult<BizTokenVo> refreshBizToken(String refreshToken) {
        return new AppletTokenHandler(configuration().getAgentByTenantId(tenantId, clientKey)).refreshBizToken(refreshToken);
    }

    /**
     * 小程序 getAccessToken
     */
    public DyAppletResult<AppsV2TokenVo> appsV2Token() {
        return new AppletTokenHandler(configuration().getAgentByTenantId(tenantId, clientKey)).appsV2Token();
    }

    /**
     * code2Session
     *
     * @param code          login 接口返回的登录凭证
     * @param anonymousCode login 接口返回的匿名登录凭证
     * @return DySimpleResult<Code2SessionVo>
     */
    public DySimpleResult<Code2SessionVo> code2Session(String code, String anonymousCode) {
        return new LoginHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).code2Session(code, anonymousCode);
    }

    /**
     * 生成schema
     *
     * @param query 入参
     * @return DySimpleResult<GenerateSchemaVo>
     */
    public DySimpleResult<GenerateSchemaVo> generateSchema(GenerateSchemaQuery query) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).generateSchema(query);
    }

    /**
     * 查询schema
     *
     * @param appId  小程序ID
     * @param schema schema
     * @return DySimpleResult<QuerySchemaVo>
     */
    public DySimpleResult<QuerySchemaVo> querySchema(String appId, String schema) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).querySchema(appId, schema);
    }

    /**
     * 查询schema配额
     *
     * @param appId 小程序ID
     * @return DySimpleResult<QuerySchemaQuotaVo>
     */
    public DySimpleResult<QuerySchemaQuotaVo> querySchemaQuota(String appId) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).querySchemaQuota(appId);
    }

    /**
     * 生成urlLink
     *
     * @param query 入参
     * @return DySimpleResult<GenerateUrlLinkVo>
     */
    public DySimpleResult<GenerateUrlLinkVo> generateUrlLink(GenerateUrlLinkQuery query) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).generateUrlLink(query);
    }

    /**
     * 查询urlLink配额
     *
     * @param appId 小程序ID
     * @return DySimpleResult<QueryUrlLinkQuotaVo>
     */
    public DySimpleResult<QueryUrlLinkQuotaVo> queryUrlLinkQuota(String appId) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryUrlLinkQuota(appId);
    }

    /**
     * 查询urlLink
     *
     * @param appId   小程序ID
     * @param urlLink urlLink
     * @return DySimpleResult<QueryUrlLinkVo>
     */
    public DySimpleResult<QueryUrlLinkVo> queryUrlLink(String appId, String urlLink) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).queryUrlLink(appId, urlLink);
    }

    /**
     * 生成二维码
     *
     * @param query 入参
     * @return DySimpleResult<QrCodeVo>
     */
    public DySimpleResult<QrCodeVo> createQrCode(CreateQrCodeQuery query) {
        return new SchemaHandler(configuration().getAgentConfigService().loadAgentByTenantId(tenantId, clientKey)).createQrCode(query);
    }

    /**
     * 发送私信消息
     *
     * @param query 入参
     * @return ChatMsgResponseVo
     */
    public SendMsgResponseVo sendMessage(SendMsgQuery query) {
        return new ChatMsgHandler(configuration().getAgentByTenantId(tenantId, clientKey)).sendMessage(query);
    }

    /**
     * 发送主动私信
     *
     * @param query 入参
     * @return DySimpleResult<AuthSendMsgVo>
     */
    public DySimpleResult<AuthSendMsgVo> authSendMsg(SendMsgQuery query) {
        return new ChatMsgHandler(configuration().getAgentByTenantId(tenantId, clientKey)).authSendMsg(query);
    }

    /**
     * 查询主动私信用户授权状态
     *
     * @param openId  用户ID
     * @param cOpenId C端用户的open_id
     * @param appId   C端用户open_id所在的小程序 可不传
     * @return DySimpleResult<ImAuthStatusVo>
     */
    public DySimpleResult<ImAuthStatusVo> queryImAuthStatus(String openId, String cOpenId, String appId) {
        return new ChatMsgHandler(configuration().getAgentByTenantId(tenantId, clientKey)).queryImAuthStatus(openId, cOpenId, appId);
    }

    /**
     * 查询授权主动私信用户
     *
     * @param openId   用户ID
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return DySimpleResult<ImAuthUserListVo>
     */
    public DySimpleResult<ImAuthUserListVo> queryAuthorizeUserList(String openId, Long pageNum, Long pageSize) {
        return new ChatMsgHandler(configuration().getAgentByTenantId(tenantId, clientKey)).queryAuthorizeUserList(openId, pageNum, pageSize);
    }

    /**
     * 私信消息撤回
     *
     * @param openId           用户ID
     * @param msgId            消息ID
     * @param conversationId   会话 ID：来源于私信 webhook，接收私信消息事件，对应 webhook 的 content 里的conversation_short_id 字段
     * @param conversationType 会话类型 1- 单聊 2- 群聊
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> revokeMessage(String openId, String msgId, String conversationId, Integer conversationType) {
        return new ChatMsgHandler(configuration().getAgentByTenantId(tenantId, clientKey)).revokeMessage(openId, msgId, conversationId, conversationType);
    }


    /**
     * 创建线索组件
     *
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param region     区域
     * @return DySimpleResult<CreateClueComponentVo>
     */
    public DySimpleResult<CreateClueComponentVo> createClueComponent(String categoryId, String configName, String region) {
        return new ClueHandler(configuration().getAgentByTenantId(tenantId, clientKey)).createClueComponent(categoryId, configName, region);
    }

    /**
     * 创建线索组件
     *
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param regionList 区域
     * @return DySimpleResult<CreateClueComponentVo>
     */
    public DySimpleResult<CreateClueComponentVo> createClueComponent(String categoryId, String configName, List<String> regionList) {
        return new ClueHandler(configuration().getAgentByTenantId(tenantId, clientKey)).createClueComponent(categoryId, configName, regionList);
    }

    /**
     * 查询线索组件
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return DySimpleResult<ClueComponentVo>
     */
    public DySimpleResult<ClueComponentVo> queryClueComponent(Integer pageNo, Integer pageSize) {
        return new ClueHandler(configuration().getAgentByTenantId(tenantId, clientKey)).queryClueComponent(pageNo, pageSize);
    }

    /**
     * 更新线索组件
     *
     * @param configId   配置id
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param region     区域
     * @return DySimpleResult
     */
    public DySimpleResult updateClueComponent(String configId, String categoryId, String configName, String region) {
        return new ClueHandler(configuration().getAgentByTenantId(tenantId, clientKey)).updateClueComponent(configId, categoryId, configName, region);
    }

    /**
     * 更新线索组件
     *
     * @param configId   配置id
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param regionList 区域
     * @return DySimpleResult
     */
    public DySimpleResult updateClueComponent(String configId, String categoryId, String configName, List<String> regionList) {
        return new ClueHandler(configuration().getAgentByTenantId(tenantId, clientKey)).updateClueComponent(configId, categoryId, configName, regionList);
    }

    /**
     * 删除线索组件
     *
     * @param configId 配置id
     * @return DySimpleResult
     */
    public DySimpleResult deleteClueComponent(String configId) {
        return new ClueHandler(configuration().getAgentByTenantId(tenantId, clientKey)).deleteClueComponent(configId);
    }

    /**
     * 查询特定视频的视频数据
     *
     * @param openId   用户ID
     * @param itemIds  item_id 数组，仅能查询 access_token 对应用户上传的视频（与video_ids字段二选一，平台优先处理item_ids）
     * @param videoIds video_id 数组，仅能查询 access_token 对应用户上传的视频（与item_ids字段二选一，平台优先处理item_ids）
     * @return DyResult<AptVideoListVo>
     */
    public DyResult<AptVideoListVo> queryVideoList(String openId, List<String> itemIds, List<String> videoIds) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).queryVideoList(openId, itemIds, videoIds);
    }

    /**
     * 查询特定视频的视频数据(经营授权)
     *
     * @param openId   用户ID
     * @param itemIds  item_id 数组，仅能查询 access_token 对应用户上传的视频（与video_ids字段二选一，平台优先处理item_ids）
     * @param videoIds video_id 数组，仅能查询 access_token 对应用户上传的视频（与item_ids字段二选一，平台优先处理item_ids）
     * @return DyResult<AptVideoListVo>
     */
    public DyResult<AptVideoListVo> queryBizVideoList(String openId, List<String> itemIds, List<String> videoIds) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).queryBizVideoList(openId, itemIds, videoIds);
    }


    /**
     * 获取视频点赞数据
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    public DyResult<ItemLikeInfoVo> getItemLikeInfo(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemLikeInfo(openId, itemId, dateType);
    }

    /**
     * 获取视频点赞数据(经营授权)
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    public DyResult<ItemLikeInfoVo> getItemBizLikeInfo(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemBizLikeInfo(openId, itemId, dateType);
    }

    /**
     * 获取视频评论数据
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemCommentInfoVo>
     */
    public DyResult<ItemCommentInfoVo> getItemComment(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemComment(openId, itemId, dateType);
    }

    /**
     * 获取视频评论数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemCommentInfoVo>
     */
    public DyResult<ItemCommentInfoVo> getItemBizComment(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemBizComment(openId, itemId, dateType);
    }

    /**
     * 获取视频播放数据
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    public DyResult<ItemPlayInfoVo> getItemPlay(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemPlay(openId, itemId, dateType);
    }

    /**
     * 获取视频播放数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    public DyResult<ItemPlayInfoVo> getItemBizPlay(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemBizPlay(openId, itemId, dateType);
    }

    /**
     * 获取视频分享数据
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    public DyResult<ItemShareInfoVo> getItemShare(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemShare(openId, itemId, dateType);
    }

    /**
     * 获取视频分享数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    public DyResult<ItemShareInfoVo> getItemBizShare(String openId, String itemId, Integer dateType) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).getItemBizShare(openId, itemId, dateType);
    }

    /**
     * 置顶评论
     *
     * @param openId    用户ID
     * @param commentId 评论ID
     * @param itemId    视频ID
     * @param top       true: 置顶, false: 取消置顶
     * @return TopCommentVo
     */
    public TopCommentVo topComment(String openId, String commentId, String itemId, Boolean top) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).topComment(openId, commentId, itemId, top);
    }

    /**
     * 获取评论列表
     *
     * @param openId   用户ID
     * @param itemId   视频ID
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count    每页的数量，最大不超过50，最小不低于1
     * @param cursor   分页游标
     * @return DyResult<CommentListVo>
     */
    public DyResult<CommentListVo> commentList(String openId, String itemId, String sortType, Integer count, Long cursor) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).commentList(openId, itemId, sortType, count, cursor);
    }
    /**
     * 获取评论回复列表
     *
     * @param openId    用户ID
     * @param itemId    视频ID
     * @param commentId 评论ID
     * @param sortType  列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count     每页的数量，最大不超过50，最小不低于1
     * @param cursor    分页游标
     * @return DyResult<CommentListVo>
     */
    public DyResult<CommentListVo> commentReplyList(String openId, String itemId, String commentId, String sortType, Integer count, Long cursor) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).commentReplyList(openId, itemId, commentId, sortType, count, cursor);
    }

    /**
     * 回复评论
     *
     * @param openId   用户ID
     * @param content  评论内容
     * @param commentId 评论ID
     * @param itemId   视频ID
     * @return DyResult<CommentReplyVo>
     */
    public DyResult<CommentReplyVo> replyComment(String openId, String content, String commentId, String itemId) {
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).replyComment(openId, content, commentId, itemId);
    }

    /**
     * videoId转换itemId
     * @param accessKey 字段含义：小程序id或移动网站应用id  备注：填写转化为目标应用的应用ID，如果转化为本小程序可用的itemId，填入本小程序的appid即可。
     * @param appId 小程序ID
     * @param videoIds 需要转换的videoId
     * @return DySimpleResult<ConvertResultVo>
     */
    public DySimpleResult<ConvertResultVo> videoId2itemId(String accessKey,String appId, List<String> videoIds){
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).videoId2itemId(accessKey,appId,videoIds);
    }

    /**
     * itemId转换encryptId
     * @param accessKey  根据打通文档的说明，此处在使用的应用类型为小程序时应当为小程序的 appid。具体内容参见上面的 access_key 说明
     * @param itemIds 需要转换的itemId
     * @return DySimpleResult<ConvertResultVo>
     */
    public DySimpleResult<ConvertResultVo> itemId2encryptId(String accessKey, List<String> itemIds){
        return new AptVideoHandler(configuration().getAgentByTenantId(tenantId, clientKey)).itemId2encryptId(accessKey,itemIds);
    }
}