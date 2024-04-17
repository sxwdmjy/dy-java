package com.dyj.applet.handler;

import com.dyj.applet.domain.query.CreateQrCodeQuery;
import com.dyj.applet.domain.query.GenerateSchemaQuery;
import com.dyj.applet.domain.query.GenerateUrlLinkQuery;
import com.dyj.applet.domain.vo.*;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;

/**
 * @author danmo
 * @date 2024-04-17 14:29
 **/
public class SchemaHandler extends AbstractAppletHandler {
    public SchemaHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 生成schema
     *
     * @param query 入参
     * @return DySimpleResult<GenerateSchemaVo>
     */
    public DySimpleResult<GenerateSchemaVo> generateSchema(GenerateSchemaQuery query) {
        baseQuery(query);
        return getSchemaClient().generateSchema(query);
    }

    /**
     * 查询schema
     *
     * @param appId  小程序ID
     * @param schema schema
     * @return DySimpleResult<QuerySchemaVo>
     */
    public DySimpleResult<QuerySchemaVo> querySchema(String appId, String schema) {
        return getSchemaClient().querySchema(baseQuery(), appId, schema);
    }

    /**
     * 查询schema配额
     *
     * @param appId 小程序ID
     * @return DySimpleResult<QuerySchemaQuotaVo>
     */
    public DySimpleResult<QuerySchemaQuotaVo> querySchemaQuota(String appId) {
        return getSchemaClient().querySchemaQuota(baseQuery(), appId);
    }

    /**
     * 生成urlLink
     *
     * @param query 入参
     * @return DySimpleResult<GenerateUrlLinkVo>
     */
    public DySimpleResult<GenerateUrlLinkVo> generateUrlLink(GenerateUrlLinkQuery query) {
        baseQuery(query);
        return getSchemaClient().generateUrlLink(query);
    }

    /**
     * 查询urlLink配额
     *
     * @param appId 小程序ID
     * @return DySimpleResult<QueryUrlLinkQuotaVo>
     */
    public DySimpleResult<QueryUrlLinkQuotaVo> queryUrlLinkQuota(String appId) {
        return getSchemaClient().queryUrlLinkQuota(baseQuery(), appId);
    }

    /**
     * 查询urlLink
     *
     * @param appId   小程序ID
     * @param urlLink urlLink
     * @return DySimpleResult<QueryUrlLinkVo>
     */
    public DySimpleResult<QueryUrlLinkVo> queryUrlLink(String appId, String urlLink) {
        return getSchemaClient().queryUrlLink(baseQuery(), appId, urlLink);
    }

    /**
     * 生成二维码
     *
     * @param query 入参
     * @return DySimpleResult<QrCodeVo>
     */
    public DySimpleResult<QrCodeVo> createQrCode(CreateQrCodeQuery query) {
        baseQuery(query);
        return getSchemaClient().createQrCode(query);
    }


}
