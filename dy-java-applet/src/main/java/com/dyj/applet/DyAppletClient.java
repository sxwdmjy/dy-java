package com.dyj.applet;

import com.dtflys.forest.annotation.BaseRequest;
import com.dyj.applet.handler.AppletTokenHandler;
import com.dyj.common.client.BaseClient;
import com.dyj.common.domain.DyAppletResult;
import com.dyj.common.domain.vo.AppsV2TokenVo;
import com.dyj.common.domain.vo.BizTokenVo;

/**
 * @author danmo
 * @date 2024-04-16 15:28
 **/
@BaseRequest(baseURL = "${domain}")
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
}
