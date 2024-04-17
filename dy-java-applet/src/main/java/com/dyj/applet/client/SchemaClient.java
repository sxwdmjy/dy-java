package com.dyj.applet.client;


import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.dyj.applet.domain.query.CreateQrCodeQuery;
import com.dyj.applet.domain.query.GenerateSchemaQuery;
import com.dyj.applet.domain.query.GenerateUrlLinkQuery;
import com.dyj.applet.domain.vo.*;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.interceptor.ClientTokenInterceptor;

@BaseRequest(baseURL = "${domain}", interceptor = ClientTokenInterceptor.class)
public interface SchemaClient {

    /**
     * 生成SchemaV2
     *
     * @param query 入参
     * @return DySimpleResult<GenerateSchemaVo>
     */
    @Post(value = "${generateSchema}")
    DySimpleResult<GenerateSchemaVo> generateSchema(@JSONBody GenerateSchemaQuery query);

    /**
     * 查询SchemaV2
     *
     * @param query  应用信息
     * @param appId  小程序ID
     * @param schema schema
     * @return
     */
    @Post(value = "${querySchema}")
    DySimpleResult<QuerySchemaVo> querySchema(@Var("query") BaseQuery query, @JSONBody("app_id") String appId, @JSONBody("schema") String schema);

    /**
     * 查询Schema配额V2
     *
     * @param query 应用信息
     * @param appId 小程序ID
     * @return DySimpleResult<QuerySchemaQuotaVo>
     */
    @Post(value = "${querySchemaQuota}")
    DySimpleResult<QuerySchemaQuotaVo> querySchemaQuota(@Var("query") BaseQuery query, @JSONBody("app_id") String appId);

    /**
     * 生成 Link V2
     *
     * @param query 入参
     * @return DySimpleResult<GenerateUrlLinkVo>
     */
    @Post(value = "${generateUrlLink}")
    DySimpleResult<GenerateUrlLinkVo> generateUrlLink(@JSONBody GenerateUrlLinkQuery query);

    /**
     * 查询 Link 配额V2
     *
     * @param query 应用信息
     * @param appId 小程序ID
     * @return DySimpleResult<QueryUrlLinkQuotaVo>
     */
    @Post(value = "${queryQuotaUrlLink}")
    DySimpleResult<QueryUrlLinkQuotaVo> queryUrlLinkQuota(@Var("query") BaseQuery query, @JSONBody("app_id") String appId);

    /**
     * 查询 Link V2
     *
     * @param query   应用信息
     * @param appId   小程序ID
     * @param urlLink urlLink
     * @return DySimpleResult<QueryUrlLinkVo>
     */
    @Post(value = "${queryInfoUrlLink}")
    DySimpleResult<QueryUrlLinkVo> queryUrlLink(@Var("query") BaseQuery query, @JSONBody("app_id") String appId, @JSONBody("url_link") String urlLink);


    /**
     * 生成QRCodeV2
     *
     * @param query 入参
     * @return DySimpleResult<QrCodeVo>
     */
    @Post(value = "${createQrCode}")
    DySimpleResult<QrCodeVo> createQrCode(@JSONBody CreateQrCodeQuery query);
}
