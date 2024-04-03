package com.dyj.web;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.handler.RequestHandler;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.AuthClient;
import com.dyj.web.domain.vo.AccessTokenVo;
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

    public static DyResult<RefreshTokenVo> refreshToken() {
    }
}
