package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.query.GetH5ShareQuery;
import com.dyj.web.domain.vo.SchemaShareVo;
import com.dyj.web.interceptor.ClientTokenInterceptor;

/**
 * 场景跳转接口
 *
 * @author danmo
 * @date 2024-04-11 11:17
 **/

@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface SchemaClient {

    /**
     * H5分享跳转链接获取
     *
     * @param query 入参
     */
    @Post(value = "${schemaGetShare}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<SchemaShareVo> getH5Share(@JSONBody GetH5ShareQuery query);

    /**
     * 个人页跳转链接获取
     */
    @Post(value = "${schemaGetUserProfile}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<SchemaShareVo> getUserProfile(@JSONBody BaseQuery query, @JSONBody("open_id") String openId,@JSONBody("account") String account, @JSONBody("expire_at") Long expireAt);

    /**
     * 个人会话页跳转链接获取
     */
    @Post(value = "${schemaGetUserChat}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<SchemaShareVo> getUserChat(@JSONBody BaseQuery query, @JSONBody("open_id") String openId,@JSONBody("account") String account, @JSONBody("expire_at") Long expireAt);

    /**
     * 视频详情页跳转链接获取
     */
    @Post(value = "${schemaGetItem}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<SchemaShareVo> getItem(@JSONBody BaseQuery query, @JSONBody("item_id") String itemId, @JSONBody("video_id") String videoId, @JSONBody("expire_at") Long expireAt);

    /**
     * 直播间跳转链接获取
     */
    @Post(value = "${schemaGetLive}", interceptor = ClientTokenInterceptor.class)
    DySimpleResult<SchemaShareVo> getLive(@JSONBody BaseQuery query, @JSONBody("open_id") String openId, @JSONBody("account") String account, @JSONBody("expire_at") Long expireAt);
}
