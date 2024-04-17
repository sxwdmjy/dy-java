package com.dyj.applet;

import com.dyj.applet.domain.query.CreateQrCodeQuery;
import com.dyj.applet.domain.query.GenerateSchemaQuery;
import com.dyj.applet.domain.query.GenerateUrlLinkQuery;
import com.dyj.applet.domain.vo.*;
import com.dyj.applet.handler.AppletTokenHandler;
import com.dyj.applet.handler.LoginHandler;
import com.dyj.applet.handler.SchemaHandler;
import com.dyj.common.client.BaseClient;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.*;

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
}
