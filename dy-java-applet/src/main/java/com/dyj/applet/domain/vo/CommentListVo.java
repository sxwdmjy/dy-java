package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.Comment;
import com.dyj.common.domain.vo.BaseVo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-10 16:57
 **/
public class CommentListVo extends BaseVo {

    /**
     * 用于下一页请求的cursor
     */
    private Long cursor;

    /**
     * 用于判断是否还有下一页
     */
    private Boolean has_more;

    /**
     * 评论列表
     */
    private List<Comment> list;

    public Long getCursor() {
        return cursor;
    }

    public void setCursor(Long cursor) {
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
