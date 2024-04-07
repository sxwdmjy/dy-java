package com.dyj.web;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.TokenInfo;
import com.dyj.common.handler.RequestHandler;
import com.dyj.web.domain.vo.*;
import com.dyj.web.handler.AccessTokenHandler;
import com.dyj.web.handler.UserHandler;

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

}
