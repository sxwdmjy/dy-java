package com.dyj.web.handler;


import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.DataAndExtraBodyVo;
import com.dyj.web.domain.*;
import com.dyj.web.domain.ApiFansDataBindFansData;
import com.dyj.web.domain.vo.*;

import java.util.List;

/**
 * 数据开放服务
 */
public class DataExternalHandler extends AbstractWebHandler{
    public DataExternalHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }


    /**
     * 获取用户视频情况
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserItemResult>> externalUserItem(Long dateType, String openId){
        return getDataExternalClient().externalUserItem(userInfoQuery(openId),dateType);
    }

    /**
     * 获取用户粉丝数
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @return
     */
    public DyResult<ResultListVo<ExternalUserFansResult>> externalUserFans(Long dateType, String openId){
        return getDataExternalClient().externalUserFans(userInfoQuery(openId),dateType);
    }

    /**
     * 获取用户点赞数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserLikeResult>> externalUserLike(Long dateType, String openId){
        return getDataExternalClient().externalUserLike(userInfoQuery(openId),dateType);
    }

    /**
     * 获取用户评论数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserCommentResult>> externalUserComment(Long dateType, String openId){
        return getDataExternalClient().externalUserComment(userInfoQuery(openId),dateType);
    }

    /**
     * 获取用户分享数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserShareResult>> externalUserShare(Long dateType, String openId){
        return getDataExternalClient().externalUserShare(userInfoQuery(openId),dateType);
    }

    /**
     * 获取用户主页访问数
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalUserProfileResult>> externalUserProfile(Long dateType,String openId){
        return getDataExternalClient().externalUserProfile(userInfoQuery(openId),dateType);
    }

    /**
     * 获取视频基础数据
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultVo<ExternalItemBaseResult>> externalItemBase(String itemId, String openId) {
        return getDataExternalClient().externalItemBase(userInfoQuery(openId),itemId);
    }

    /**
     * 获取视频点赞数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemLikeResult>> externalItemLike(Long dateType,String itemId,String openId){
        return getDataExternalClient().externalItemLike(userInfoQuery(openId),dateType,itemId);
    }

    /**
     * 获取视频评论数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemCommentResult>> externalItemComment(Long dateType,String itemId,String openId){
        return getDataExternalClient().externalItemComment(userInfoQuery(openId),dateType,itemId);
    }

    /**
     * 获取视频播放数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemPlayResult>> externalItemPlay(Long dateType,String itemId,String openId){
        return getDataExternalClient().externalItemPlay(userInfoQuery(openId),dateType,itemId);
    }


    /**
     * 获取视频分享数据
     * @param dateType 近7/15/30天；输入7代表7天、15代表15天、30代表30天。
     * @param itemId item_id，仅能查询access_token对应用户上传的视频
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ResultListVo<ExternalItemShareResult>> externalItemShare(Long dateType,String itemId,String openId){
        return getDataExternalClient().externalItemShare(userInfoQuery(openId),dateType,itemId);
    }

    /**
     * 获取主播历史开播过的房间ID
     * @param endTime 查询结束时间，秒级时间戳。
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @param startTime 查询开始时间，秒级时间戳。
     * @return
     */
    public GetRoomIdListVo getRoomIdList(Long endTime, String openId, Long startTime){
        return getDataExternalClient().getRoomIdList(userInfoQuery(openId),endTime,startTime);
    }

    /**
     * 获取直播间互动数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @param roomId 房间id
     * @return
     */
    public DySimpleResult<LiveRoomResult> getRoomInteractiveData(Long liveId, String openId, Long roomId){
        return getDataExternalClient().getRoomInteractiveData(userInfoQuery(openId),liveId,roomId);
    }

    /**
     * 获取直播间看播数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param openId 调用 /oauth/access_token/ 生成的 open_id，53dba859-3b1a-4a82-9249-3baf97fcada8
     * @param roomId 房间id
     * @return
     */
    public DySimpleResult<LiveRoomResult> getRoomAudienceData(Long liveId, String openId, Long roomId){
        return getDataExternalClient().getRoomAudienceData(userInfoQuery(openId),liveId,roomId);
    }

    /**
     * 获取直播间基础数据
     * @param liveId 业务线，1：抖火，3：西瓜头条
     * @param openId <p>调用 <a href="https://developer.open-douyin.com/docs/resource/zh-CN/dop/develop/openapi/account-permission/get-access-token" target="_blank" rel="nofollow" class="syl-link" elementtiming="element-timing">/oauth/access_token/</a> 生成的 open_id，53dba859-3b1a-4a82-9249-3baf97fcada8</p>
     * @param roomId 房间id
     * @return
     */
    public DySimpleResult<LiveRoomResult> getRoomBaseData(Long liveId,String openId,Long roomId){
        return getDataExternalClient().getRoomBaseData(userInfoQuery(openId),liveId,roomId);
    }

    /**
     * 获取用户粉丝数据
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ApiFansDataBindFansVo> apiFansDataBind(String openId){
        return getDataExternalClient().apiFansDataBind(userInfoQuery(openId));
    }

    /**
     * 获取用户粉丝来源
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ListVo<ItemValue>> getFansSource(String openId){
        return getDataExternalClient().getFansSource(userInfoQuery(openId));
    }

    /**
     * 获取用户粉丝喜好
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ListVo<GetFansFavouriteResult>> getFansFavourite(String openId){
        return getDataExternalClient().getFansFavourite(userInfoQuery(openId));
    }

    /**
     * 获取用户粉丝热评
     * @param openId 通过/oauth/access_token/获取，用户唯一标志
     * @return
     */
    public DyResult<ListVo<GetFansCommentResult>> getFansComment(String openId){
        return getDataExternalClient().getFansComment(userInfoQuery(openId));
    }

    /**
     * 获取实时热点词
     * @return
     */
    public DyResult<HotSentencesDataVo> hotSentences(){
        return getDataExternalClient().hotSentences();
    }

    /**
     * 获取上升词
     * @param count 每页数量
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。
     * @return
     */
    public DyResult<TrendingSentencesVo> trendingSentences(Integer count,Long cursor){
        return getDataExternalClient().trendingSentences(count,cursor);
    }


    /**
     * 获取热点词聚合的视频
     * @param hotSentence 热点词
     * @return
     */
    public DyResult<HotVideoListDataVo> hotVideoList(String hotSentence){
        return getDataExternalClient().hotVideoList(hotSentence);
    }

    /**
     * 获取抖音星图达人热榜
     * @param hotListType 达人热榜类型 * `1` - 星图指数榜 * `2` - 涨粉指数榜 * `3` - 性价比指数榜 * `4` - 种草指数榜 * `5` - 精选指数榜 * `6` - 传播指数榜 选填
     * @return
     */
    public DataAndExtraBodyVo<StarHotResult> starHotlist(Long hotListType){
        return getDataExternalClient().starHotlist(hotListType);
    }

    /**
     * 获取抖音星图达人指数
     * @param openId 通过/oauth/access_token/获取，用户唯一标志 选填
     * @return
     */
    public DataAndExtraBodyVo<StarAuthorScoreResult> starAuthorScore(String openId){
        return getDataExternalClient().starAuthorScore(userInfoQuery(openId));
    }

    /**
     * 获取抖音星图达人指数数据V2
     * @param uniqueId 达人抖音号 选填
     * @return
     */
    public DataAndExtraBodyVo<StarAuthorScoreV2Result> starAuthorScoreV2(String uniqueId){
        return getDataExternalClient().starAuthorScoreV2(uniqueId);
    }

    /**
     * 获取抖音电影榜、抖音电视剧榜、抖音综艺榜
     * @param type 榜单类型：  * 1 - 电影   * 2 - 电视剧   * 3 - 综艺 选填
     * @param version 榜单版本：空值默认为本周榜单 选填
     * @return
     */
    public DataAndExtraBodyVo<DiscoveryEntRankItemVo> discoveryEntRankItem(Long type,Long version){
        return getDataExternalClient().discoveryEntRankItem(type,version);
    }

    /**
     * 获取抖音影视综榜单版本
     * @param count 每页数量 选填
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param type 榜单类型：  * 1 - 电影   * 2 - 电视剧   * 3 - 综艺 选填
     * @return
     */
    public DataAndExtraBodyVo<DiscoveryEntRankVersionListVo> discoveryEntRankVersion(Long count,Long cursor,Long type){
        return getDataExternalClient().discoveryEntRankVersion(count,cursor,type);
    }


}
