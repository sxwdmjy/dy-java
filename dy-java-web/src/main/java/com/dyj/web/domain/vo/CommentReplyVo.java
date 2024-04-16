package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-10 17:09
 **/
public class CommentReplyVo extends BaseVo {

    /**
     * 评论id
     */
    private String comment_id;

    /**
     * 用户头像url
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nick_name;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }


}
