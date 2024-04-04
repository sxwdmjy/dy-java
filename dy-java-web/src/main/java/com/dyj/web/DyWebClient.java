package com.dyj.web;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.handler.RequestHandler;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.AuthClient;
import com.dyj.web.domain.vo.AccessTokenVo;
import com.dyj.web.domain.vo.ClientTokenVo;
import com.dyj.web.domain.vo.RefreshAccessTokenVo;
import com.dyj.web.domain.vo.RefreshTokenVo;
import com.dyj.web.handler.AccessTokenHandler;

/**
 * @author danmo
 * @date 2024-04-03 17:25
 **/
public abstract class DyWebClient {

    private static final AuthClient authClient = SpringUtils.getBean(AuthClient.class);

    public static DyConfiguration configuration(){
        return RequestHandler.getInstance().getDyConfiguration();
    }

    /**
     * 获取访问令牌。
     *
     * @param code 用户授权后返回的授权码，用于获取访问令牌。
     * @param tenantId 租户标识，用于区分不同租户的数据。
     * @return 返回一个包含访问令牌信息的结果对象。如果成功，结果对象中包含访问令牌、刷新令牌等信息；如果失败，结果对象中包含错误信息。
     */
    public static DyResult<AccessTokenVo> accessToken(String code, Integer tenantId) {
        return accessToken(code, tenantId, null);
    }


    /**
     * 通过代码获取访问令牌。
     *
     * @param code 用户授权后返回的授权码。
     * @param tenantId 租户标识，用于指定获取哪个租户的访问令牌。
     * @param clientId 应用标识，用于指定获取哪个应用的访问令牌。
     * @return 返回一个包含访问令牌信息的结果对象。
     */
    public static DyResult<AccessTokenVo> accessToken(String code, Integer tenantId, String clientId) {
        // 根据租户ID和应用ID获取配置信息
        AgentConfiguration agentConfiguration = configuration().getAgentByTenantId(tenantId, clientId);
        // 使用配置信息和授权码获取访问令牌
        return new AccessTokenHandler(authClient,agentConfiguration).getAccessToken(code);
    }

    /**
     * 获取accessToken
     * 主要通过传递code来获取accessToken，code通常为授权后的凭证。
     * @param code 用户授权后返回的code，用于向服务器换取accessToken。
     * @return 返回一个DyResult对象，包含获取accessToken的结果信息。
     *         DyResult中的data字段会包含AccessTokenVo类型的accessToken信息。
     */
    public static DyResult<AccessTokenVo> accessToken(String code) {
        return accessToken(code, null);
    }


    /**
     * 刷新令牌的方法。
     * <p>该方法用于获取新的令牌。这里提供了一个重载方法，允许通过不同的参数来进行刷新令牌的操作。</p>
     *
     * @return DyResult<RefreshTokenVo> 返回一个包含刷新令牌结果的DyResult对象。
     */
    public static DyResult<RefreshTokenVo> refreshToken() {
        return refreshToken(null);
    }


    /**
     * 刷新令牌的方法。
     * 这是一个静态方法，旨在通过给定的租户ID刷新令牌。本方法提供了一个重载版本，允许指定额外的参数。
     *
     * @param tenantId 租户ID，用于识别请求的租户。这是一个必需的参数。
     * @return 返回一个包含刷新令牌结果的DyResult对象。该对象可能包含新的刷新令牌、访问令牌等信息。
     */
    public static DyResult<RefreshTokenVo> refreshToken(Integer tenantId) {
        return refreshToken(tenantId, null);
    }


    /**
     * 刷新访问令牌。
     * 本方法用于根据租户ID和应用ID获取新的访问令牌。
     *
     * @param tenantId 租户ID，用于标识不同的租户。
     * @param clientId 应用ID，用于标识具体的应用。
     * @return 返回一个包含刷新后的访问令牌信息的结果对象。
     */
    public static DyResult<RefreshTokenVo> refreshToken(Integer tenantId, String clientId) {
        // 根据租户ID和应用ID获取相应的配置信息
        AgentConfiguration agentConfiguration = configuration().getAgentByTenantId(tenantId, clientId);
        // 利用配置信息和授权码获取新的访问令牌
        return new AccessTokenHandler(authClient,agentConfiguration).refreshToken();
    }


    /**
     * 获取客户端令牌的工具方法。
     * 无参数调用时，将尝试获取默认租户和客户端的令牌。
     * 当提供租户ID和客户端ID时，将获取指定租户和客户端的令牌。
     */
    // 无参数版本，获取默认租户和客户端的令牌
    public static DyResult<ClientTokenVo> clientToken() {
        return clientToken(null);
    }

    // 基于租户ID获取客户端令牌，若clientId为空，则尝试获取默认客户端的令牌
    public static DyResult<ClientTokenVo> clientToken(Integer tenantId) {
        return clientToken(tenantId, null);
    }

    /**
     * 根据指定的租户ID和客户端ID获取客户端令牌。
     * @param tenantId 租户ID，可为空，默认尝试获取系统配置中的租户令牌。
     * @param clientId 客户端ID，可为空，默认尝试获取系统配置中的客户端令牌。
     * @return 返回客户端令牌的结果，包含令牌信息或其他操作结果。
     */
    public static DyResult<ClientTokenVo> clientToken(Integer tenantId, String clientId){
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的令牌
        return new AccessTokenHandler(authClient,configuration().getAgentByTenantId(tenantId, clientId)).getClientToken();
    }


    /**
     * 刷新访问令牌的工具方法。
     * @return DyResult<RefreshAccessTokenVo> 包含刷新后的访问令牌信息的结果对象。
     */
    public static DyResult<RefreshAccessTokenVo> refreshAccessToken() {
        return refreshAccessToken(null);
    }

    /**
     * 带租户ID参数的刷新访问令牌方法。
     * 使用提供的租户ID和默认客户端ID刷新访问令牌。
     *
     * @param tenantId 租户ID，用于指定要刷新访问令牌的租户。
     * @return DyResult<RefreshAccessTokenVo> 包含刷新后的访问令牌信息的结果对象。
     */
    public static DyResult<RefreshAccessTokenVo> refreshAccessToken(Integer tenantId) {
        return refreshAccessToken(tenantId, null);
    }

    /**
     * 带租户ID和客户端ID参数的刷新访问令牌方法。
     * 使用提供的租户ID和客户端ID刷新访问令牌。
     *
     * @param tenantId 租户ID，用于指定要刷新访问令牌的租户。
     * @param clientId 客户端ID，用于指定要刷新访问令牌的客户端。
     * @return DyResult<RefreshAccessTokenVo> 包含刷新后的访问令牌信息的结果对象。
     */
    public static DyResult<RefreshAccessTokenVo> refreshAccessToken(Integer tenantId, String clientId) {
        // 通过AccessTokenHandler处理逻辑，获取指定租户和客户端的刷新令牌
        return new AccessTokenHandler(authClient,configuration().getAgentByTenantId(tenantId, clientId)).refreshAccessToken();
    }

}
