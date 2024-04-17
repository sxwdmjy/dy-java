package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.web.domain.query.GetH5ShareQuery;
import com.dyj.web.domain.vo.SchemaShareVo;

/**
 * @author danmo
 * @date 2024-04-11 11:54
 **/
public class SchemaHandler extends AbstractWebHandler {
    public SchemaHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * H5分享跳转链接获取
     * @param query
     * @return
     */
    public DySimpleResult<SchemaShareVo> getH5Share(GetH5ShareQuery query) {
        baseQuery(query);
        return getSchemaClient().getH5Share(query);
    }

    /**
     * 个人页跳转链接获取
     * @param openId  用户ID
     * @param account 抖音号
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getUserProfile(String openId, String account, Long expireAt) {
        return getSchemaClient().getUserProfile(baseQuery(), openId, account, expireAt);
    }

    /**
     * 个人会话页跳转链接获取
     * @param openId  用户ID
     * @param account 抖音号
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getUserChat(String openId, String account, Long expireAt){
        return getSchemaClient().getUserChat(baseQuery(), openId, account, expireAt);
    }

    /**
     * 视频详情页跳转链接获取
     * @param itemId 视频ID
     * @param videoId 视频ID
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getItem(String itemId, String videoId, Long expireAt){
        return getSchemaClient().getItem(baseQuery(), itemId, videoId, expireAt);
    }

    /**
     * 直播间页跳转链接获取
     * @param openId  用户ID
     * @param account 抖音号
     * @param expireAt 生成短链过期时间
     * @return DySimpleResult<SchemaShareVo>
     */
    public DySimpleResult<SchemaShareVo> getLive(String openId,String account, Long expireAt){
        return getSchemaClient().getLive(baseQuery(), openId,account, expireAt);
    }
}
