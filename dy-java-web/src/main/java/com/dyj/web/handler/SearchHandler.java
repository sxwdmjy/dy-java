package com.dyj.web.handler;


import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
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

}
