package com.dyj.web.domain.vo;

import com.dyj.web.domain.VideoSearchCommentListV2Result;

import java.util.List;

/**
 * 关键词视频评论列表分页返回值
 */
public class VideoSearchCommentListV2ListVo extends BaseVo{

    /**
     * 用于下一页请求的cursor
     */
    private Long cursor;
    /**
     * 用于判断是否还有下一页
     */
    private Boolean has_more;
    /**
     * 关键词视频评论列表返回值
     */
    private List<VideoSearchCommentListV2Result> list;


    public Long getCursor() {
        return cursor;
    }

    public VideoSearchCommentListV2ListVo setCursor(Long cursor) {
        this.cursor = cursor;
        return this;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public VideoSearchCommentListV2ListVo setHas_more(Boolean has_more) {
        this.has_more = has_more;
        return this;
    }

    public List<VideoSearchCommentListV2Result> getList() {
        return list;
    }

    public VideoSearchCommentListV2ListVo setList(List<VideoSearchCommentListV2Result> list) {
        this.list = list;
        return this;
    }
}
