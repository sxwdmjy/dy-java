package com.dyj.applet.handler;

import com.dyj.applet.domain.query.AptVideoQuery;
import com.dyj.applet.domain.vo.*;
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

    /**
     * 获取视频评论数据
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemCommentInfoVo>
     */
    public DyResult<ItemCommentInfoVo> getItemComment(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemComment(userInfoQuery(), itemId, dateType);
    }

    /**
     * 获取视频评论数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemCommentInfoVo>
     */
    public DyResult<ItemCommentInfoVo> getItemBizComment(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizComment(userInfoQuery(), itemId, dateType);
    }

    /**
     * 获取视频播放数据
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    public DyResult<ItemPlayInfoVo> getItemPlay(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemPlay(userInfoQuery(), itemId, dateType);
    }

    /**
     * 获取视频播放数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    public DyResult<ItemPlayInfoVo> getItemBizPlay(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizPlay(userInfoQuery(), itemId, dateType);
    }

    /**
     * 获取视频分享数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    public DyResult<ItemShareInfoVo> getItemShare(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemShare(userInfoQuery(), itemId, dateType);
    }

    /**
     * 获取视频分享数据（经营授权）
     *
     * @param openId  用户ID
     * @param itemId  item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    public DyResult<ItemShareInfoVo> getItemBizShare(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizShare(userInfoQuery(), itemId, dateType);
    }
}
