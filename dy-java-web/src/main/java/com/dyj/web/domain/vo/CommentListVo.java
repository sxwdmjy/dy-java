package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.Comment;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-10 16:57
 **/
public class CommentListVo extends BaseVo {

    /**
     * 用于下一页请求的cursor
     */
    private Integer cursor;

    /**
     * 用于判断是否还有下一页
     */
    private Boolean has_more;

    /**
     * 评论列表
     */
    private List<Comment> list;

    public Integer getCursor() {
        return cursor;
    }

    public void setCursor(Integer cursor) {
        this.cursor = cursor;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<Comment> getList() {
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

}
