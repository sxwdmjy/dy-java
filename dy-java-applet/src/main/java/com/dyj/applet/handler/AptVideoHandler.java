package com.dyj.applet.handler;

import com.dtflys.forest.annotation.JSONBody;
import com.dyj.applet.domain.query.AptVideoQuery;
import com.dyj.applet.domain.query.CommentQuery;
import com.dyj.applet.domain.query.ItemId2EncryptIdQuery;
import com.dyj.applet.domain.query.VideoId2ItemIdQuery;
import com.dyj.applet.domain.vo.*;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;

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
        return getVideoClient().getItemBaseInfo(userInfoQuery(openId), itemId);
    }


    /**
     * 获取视频基础数据（经营授权）
     *
     * @param openId 用户ID
     * @param itemId item_id
     * @return DyResult<ItemBaseInfoVo>
     */
    public DyResult<ItemBaseInfoVo> getItemBizBaseInfo(String openId, String itemId) {
        return getVideoClient().getItemBizBaseInfo(userInfoQuery(openId), itemId);
    }

    /**
     * 获取视频点赞数据
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    public DyResult<ItemLikeInfoVo> getItemLikeInfo(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemLikeInfo(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频点赞数据（经营授权）
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，只支持近7/15/30天
     * @return DyResult<ItemLikeInfoVo>
     */
    public DyResult<ItemLikeInfoVo> getItemBizLikeInfo(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizLikeInfo(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频评论数据
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemCommentInfoVo>
     */
    public DyResult<ItemCommentInfoVo> getItemComment(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemComment(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频评论数据（经营授权）
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemCommentInfoVo>
     */
    public DyResult<ItemCommentInfoVo> getItemBizComment(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizComment(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频播放数据
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    public DyResult<ItemPlayInfoVo> getItemPlay(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemPlay(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频播放数据（经营授权）
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemPlayInfoVo>
     */
    public DyResult<ItemPlayInfoVo> getItemBizPlay(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizPlay(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频分享数据（经营授权）
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    public DyResult<ItemShareInfoVo> getItemShare(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemShare(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 获取视频分享数据（经营授权）
     *
     * @param openId   用户ID
     * @param itemId   item_id
     * @param dateType 数据范围，数据范围，近7/15天；输入7代表7天、15代表15天
     * @return DyResult<ItemShareInfoVo>
     */
    public DyResult<ItemShareInfoVo> getItemBizShare(String openId, String itemId, Integer dateType) {
        return getVideoClient().getItemBizShare(userInfoQuery(openId), itemId, dateType);
    }

    /**
     * 置顶评论
     *
     * @param openId    用户ID
     * @param commentId 评论ID
     * @param itemId    视频ID
     * @param top       true: 置顶, false: 取消置顶
     * @return TopCommentVo
     */
    public TopCommentVo topComment(String openId, String commentId, String itemId, Boolean top) {
        return getVideoClient().topComment(CommentQuery.builder()
                .commentId(commentId)
                .itemId(itemId)
                .top(top)
                .openId(openId)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }

    /**
     * 获取评论列表
     *
     * @param openId   用户ID
     * @param itemId   视频ID
     * @param sortType 列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count    每页的数量，最大不超过50，最小不低于1
     * @param cursor   分页游标
     * @return DyResult<CommentListVo>
     */
    public DyResult<CommentListVo> commentList(String openId, String itemId, String sortType, Integer count, Long cursor) {
        return getVideoClient().commentList(userInfoQuery(openId), itemId, sortType, count, cursor);
    }

    /**
     * 获取评论回复列表
     *
     * @param openId    用户ID
     * @param itemId    视频ID
     * @param commentId 评论ID
     * @param sortType  列表排序方式，不传默认按推荐序，可选值：time(时间逆序)、time_asc(时间顺序)
     * @param count     每页的数量，最大不超过50，最小不低于1
     * @param cursor    分页游标
     * @return DyResult<CommentListVo>
     */
    public DyResult<CommentListVo> commentReplyList(String openId, String itemId, String commentId, String sortType, Integer count, Long cursor) {
        return getVideoClient().commentReplyList(userInfoQuery(openId), itemId, commentId, sortType, count, cursor);
    }

    /**
     * 回复评论
     *
     * @param openId   用户ID
     * @param content  评论内容
     * @param commentId 评论ID
     * @param itemId   视频ID
     * @return DyResult<CommentReplyVo>
     */
    public DyResult<CommentReplyVo> replyComment(String openId, String content, String commentId, String itemId) {
        return getVideoClient().replyComment(CommentQuery.builder()
                .content(content)
                .commentId(commentId)
                .itemId(itemId)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .openId(openId)
                .build());
    }

    /**
     * videoId转换itemId
     * @param accessKey 字段含义：小程序id或移动网站应用id  备注：填写转化为目标应用的应用ID，如果转化为本小程序可用的itemId，填入本小程序的appid即可。
     * @param appId 小程序ID
     * @param videoIds 需要转换的videoId
     * @return DySimpleResult<ConvertResultVo>
     */
    public DySimpleResult<ConvertResultVo> videoId2itemId(String accessKey,String appId, List<String> videoIds){
        return getVideoClient().videoId2itemId(VideoId2ItemIdQuery.builder()
                .accessKey(accessKey)
                .appId(appId)
                .videoIds(videoIds)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }

    /**
     * itemId转换encryptId
     * @param accessKey  根据打通文档的说明，此处在使用的应用类型为小程序时应当为小程序的 appid。具体内容参见上面的 access_key 说明
     * @param itemIds 需要转换的itemId
     * @return DySimpleResult<ConvertResultVo>
     */
    public DySimpleResult<ConvertResultVo> itemId2encryptId(String accessKey, List<String> itemIds){
        return getVideoClient().itemId2encryptId(ItemId2EncryptIdQuery.builder()
                .accessKey(accessKey)
                .videoIds(itemIds)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }
}
