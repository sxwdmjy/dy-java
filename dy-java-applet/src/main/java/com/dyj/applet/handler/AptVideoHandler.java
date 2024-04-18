package com.dyj.applet.handler;

import com.dyj.applet.domain.query.AptVideoQuery;
import com.dyj.applet.domain.vo.AptVideoListVo;
import com.dyj.applet.domain.vo.ItemBaseInfoVo;
import com.dyj.applet.domain.vo.ItemLikeInfoVo;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-18 16:55
 **/
public class AptVideoHandler extends AbstractAppletHandler {

    public AptVideoHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
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
        return getVideoClient().queryVideoList(AptVideoQuery.builder()
                .openId(openId)
                .itemIds(itemIds)
                .videoIds(videoIds)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey()).build());
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
        return getVideoClient().queryBizVideoList(AptVideoQuery.builder()
                .openId(openId)
                .itemIds(itemIds)
                .videoIds(videoIds)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey()).build());
    }

    /**
     * 获取视频基础信息
     *
     * @param openId 用户ID
     * @param itemId item_id
     * @return DyResult<ItemBaseInfoVo>
     */
    public DyResult<ItemBaseInfoVo> getItemBaseInfo(String openId, String itemId) {
        return getVideoClient().getItemBaseInfo(userInfoQuery(), itemId);
    }


    /**
     * 获取视频基础数据（经营授权）
     *
     * @param openId 用户ID
     * @param itemId item_id
     * @return DyResult<ItemBaseInfoVo>
     */
    public DyResult<ItemBaseInfoVo> getItemBizBaseInfo(String openId, String itemId) {
        return getVideoClient().getItemBizBaseInfo(userInfoQuery(), itemId);
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
        return getVideoClient().getItemLikeInfo(userInfoQuery(), itemId, dateType);
    }
    /**
     * 获取视频点赞数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    public DyResult<ItemLikeInfoVo> getItemBizLikeInfo(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizLikeInfo(userInfoQuery(), itemId, dateType);
    }
}
