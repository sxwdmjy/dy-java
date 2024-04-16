package com.dyj.web.handler;


import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.VideoSearchCommentReplyV2Result;
import com.dyj.web.domain.query.VideoSearchCommentReplyV2Query;
import com.dyj.web.domain.vo.VideoSearchCommentListV2ListVo;
import com.dyj.web.domain.vo.VideoSearchListVo;

public class SearchHandler extends AbstractWebHandler{
    public SearchHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 关键词视频搜索
     * @param openId openId
     * @param keyword 关键词
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param count 每页数量
     * @return
     */
    public DyResult<VideoSearchListVo> videoSearchV2(String openId, String keyword, Integer count, Long cursor){
        return getSearchClient().videoSearchV2(userInfoQuery(openId),keyword,count,cursor);
    }

    /**
     * 关键词视频评论列表
     * @param count 每页数量。
     * @param secItemId 视频搜索接口返回的加密的视频id
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @return
     */
    public DyResult<VideoSearchCommentListV2ListVo> videoSearchCommentListV2(Integer count, String secItemId, Long cursor){
        return getSearchClient().videoSearchCommentListV2(count,secItemId,cursor);
    }

    /**
     * 关键词视频评论回复
     * @param body 关键词视频评论回复请求值
     * @return
     */
    public DyResult<VideoSearchCommentReplyV2Result> videoSearchCommentReplyV2(VideoSearchCommentReplyV2Query body){
        userInfoQuery(body);
        return getSearchClient().videoSearchCommentReplyV2(body);
    }

    /**
     * 关键词视频评论回复列表
     * @param cursor 分页游标, 第一页请求cursor是0, response中会返回下一页请求用到的cursor, 同时response还会返回has_more来表明是否有更多的数据。 选填
     * @param count 每页数量。
     * @param secItemId 视频搜索接口返回的加密的视频id
     * @param commentId 评论id
     * @return
     */
    public DyResult<VideoSearchCommentListV2ListVo> videoSearchCommentReplyListV2(Long cursor,Integer count,String secItemId,String commentId){
        return getSearchClient().videoSearchCommentReplyListV2(cursor,count,secItemId,commentId);
    }
}
